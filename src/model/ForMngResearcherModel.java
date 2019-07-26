package model;

import java.awt.*;
import java.io.*;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import controller.ForMngResearcherController;
import view.ForMngResearcherView;

public class ForMngResearcherModel implements Serializable{
	private static final long serialVersionUID = 1L;

	DefaultTableModel defTblForReMdl = new DefaultTableModel(0,8);
	private JTable jTblForReMdl = new JTable(defTblForReMdl){
		//method to make the rows and columns of the table uneditable.
		public boolean isCellEditable(int row, int column) {
			return false; 
		}
	};
	private JScrollPane jSpForReMdl = new JScrollPane(jTblForReMdl);

	String idOfRe, nmOfRe, genOfRe, adrOfRe, phnOfRe, emlOfRe, usNmOfRe;
	char[] psdOfRe;
	ArrayList<ForMngResearcherModel> arrLOfRe = new ArrayList<ForMngResearcherModel>();

	public ForMngResearcherModel() {}

	//this is the constructor used for adding these data to its class
	public ForMngResearcherModel(String idOfRe, String nmOfRe, String genOfRe, String adrOfRe, String phnOfRe, String emlOfRe, String usNmOfRe, char[] psdOfRe) {
		this.idOfRe = idOfRe;
		this.nmOfRe = nmOfRe;
		this.genOfRe = genOfRe;
		this.adrOfRe = adrOfRe;
		this.phnOfRe = phnOfRe;
		this.emlOfRe = emlOfRe;
		this.usNmOfRe = usNmOfRe;
		this.psdOfRe = psdOfRe;

		//method for adding the data 
		if(getReseArrayList()!=null) {
			arrLOfRe = getReseArrayList();
			arrLOfRe.add(this);
			saveInDocuments(); //saving the data in the file
		}
		else {
			arrLOfRe.add(this);
			saveInDocuments();
		}	
	}

	//this is the method for editing the data and saving in the files
	public void mthdForEditRe(ForMngResearcherView fMgReView, int indexNum) {
		arrLOfRe = getReseArrayList();
		ForMngResearcherModel fMReseMdl = new ForMngResearcherModel(fMgReView.getjTxfdReIdNo(), fMgReView.getjTxfdReFullNm(),fMgReView.getjRdBtnGp().getSelection().getActionCommand().toString(),fMgReView.getjTxfdReLtn(),fMgReView.getjTxfdRePhn(),fMgReView.getjTxfdReEmAds(),fMgReView.getjTxfdReUsrNm(),fMgReView.getjTxfdRePwd().getText().toCharArray());
		arrLOfRe.set(indexNum, fMReseMdl);
		saveInDocuments();
	}

	//this is the method for deleting the selected row data
	public void mthdForDeleteRe(int indexNum) {
		arrLOfRe = getReseArrayList();
		arrLOfRe.remove(indexNum);
		saveInDocuments();
	}

	//method for writing the data in the respective dat file using arraylist
	public void saveInDocuments() {
		String nameOfFile = "documents/researcherDetails".concat(".dat");
		try {
			FileOutputStream fopsOfRese = new FileOutputStream(nameOfFile);
			ObjectOutputStream oopsOfRese = new ObjectOutputStream(fopsOfRese);
			oopsOfRese.writeObject(arrLOfRe);
			oopsOfRese.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {
		}
	}

	//method for reading the data from the respective dat file
	@SuppressWarnings("unchecked")
	public ArrayList<ForMngResearcherModel> getReseArrayList(){
		ArrayList<ForMngResearcherModel> reseList = null;
		String nameOfFile = "documents/researcherDetails".concat(".dat");
		try {
			FileInputStream fisOfRese = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfRese = new ObjectInputStream(fisOfRese);
			Object ojct = oisOfRese.readObject();
			reseList = (ArrayList<ForMngResearcherModel>) ojct;
			oisOfRese.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return reseList;
	}

	//method for displaying data in the table in scrollpane  
	public JScrollPane layOutTbl() {
		if(getReseArrayList()!=null) {
			arrLOfRe = getReseArrayList();
			ForMngResearcherModel fmrMdel = new ForMngResearcherModel();
			for(int i = 0; i<arrLOfRe.size();i++) {
				fmrMdel = arrLOfRe.get(i);
				Object[] reseValues = {fmrMdel.getIdOfRe(), fmrMdel.getNmOfRe(), fmrMdel.getGenOfRe(), fmrMdel.getAdrOfRe(), fmrMdel.getPhnOfRe(),fmrMdel.getEmlOfRe(), fmrMdel.getUsNmOfRe(), fmrMdel.getPsdOfRe()};
				defTblForReMdl.addRow(reseValues);
			}
		}
		String reColTitles[]  = {"ID", "FullName","Gender", "Address","Phone","Email","Username","Password"};
		defTblForReMdl.setColumnIdentifiers(reColTitles);
		jTblForReMdl.setRowHeight(28);
		jTblForReMdl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//designs for the table header
		JTableHeader tblHeader = jTblForReMdl.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		TableColumnModel tblColMdl = jTblForReMdl.getColumnModel();
		tblColMdl.getColumn(0).setPreferredWidth(50);
		tblColMdl.getColumn(1).setPreferredWidth(140);
		tblColMdl.getColumn(3).setPreferredWidth(140);
		tblColMdl.getColumn(4).setPreferredWidth(100);
		tblColMdl.getColumn(5).setPreferredWidth(160);
		tblColMdl.getColumn(6).setPreferredWidth(100);
		tblColMdl.getColumn(7).setPreferredWidth(90);
		return jSpForReMdl;
	}

	public JTable getjTblForReMdl() {
		return jTblForReMdl;
	}

	public String getIdOfRe() {
		return idOfRe;
	}

	public String getNmOfRe() {
		return nmOfRe;
	}

	public String getGenOfRe() {
		return genOfRe;
	}

	public String getAdrOfRe() {
		return adrOfRe;
	}

	public String getPhnOfRe() {
		return phnOfRe;
	}

	public String getEmlOfRe() {
		return emlOfRe;
	}

	public String getUsNmOfRe() {
		return usNmOfRe;
	}
	public char[] getPsdOfRe() {
		return psdOfRe;
	}
}