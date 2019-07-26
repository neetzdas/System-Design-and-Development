package model;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import view.ForMngBookChapsView;

public class ForMngBookChapsModel implements Serializable{
	private static final long serialVersionUID = 1L;

	DefaultTableModel defTblForBkCharMdl = new DefaultTableModel(0,10);
	private JTable jTblForBkCharMdl = new JTable(defTblForBkCharMdl){
		//method to make the rows and columns of the table uneditable.
		public boolean isCellEditable(int row, int column) {
			return false; 
		}
	};
	private JScrollPane jSpForBkCharMdl = new JScrollPane(jTblForBkCharMdl);

	String ttlOfBChap, authNmOfBChap, editorOfBk, pubYearOfBk, plcOfPub, publeroOfBk, pgOfBChap, noOfBks, nmOfRe; 
	ArrayList <ForMngBookChapsModel> arrLOfBChap = new ArrayList<ForMngBookChapsModel>();

	public ForMngBookChapsModel() {}

	//this is the constructor used for adding these data to its class
	public ForMngBookChapsModel(String ttlOfBChap,String authNmOfBChap,String editorOfBk,String pubYearOfBk,String plcOfPub,String publeroOfBk,String pgOfBChap,String noOfBks,String nmOfRe) {
		this.ttlOfBChap = ttlOfBChap;
		this.authNmOfBChap = authNmOfBChap;
		this.editorOfBk = editorOfBk;
		this.pubYearOfBk = pubYearOfBk;
		this.plcOfPub = plcOfPub;
		this.publeroOfBk = publeroOfBk;
		this.pgOfBChap = pgOfBChap;
		this.noOfBks = noOfBks;
		this.nmOfRe = nmOfRe;

		//method for adding the data 
		if(getBkChArrayList()!=null) {
			arrLOfBChap = getBkChArrayList();
			arrLOfBChap.add(this);
			saveInDocuments();//saving the data in the fil
		}
		else {
			arrLOfBChap.add(this);
			saveInDocuments();
		}
	}

	//this is the method for editing the data and saving in the files
	public void mthdForEditBChap(ForMngBookChapsView fMgBChapView, int indexNum) {
		arrLOfBChap = getBkChArrayList();
		ForMngBookChapsModel fMBChapMdl = new ForMngBookChapsModel(fMgBChapView.getjTxfdBkChap(),fMgBChapView.getjTxfdAuthr(),fMgBChapView.getjTxfdEditorOfBk(),fMgBChapView.getjTxfdYrOfPub(),fMgBChapView.getjTxfdPlaceOfPubn(),fMgBChapView.getjTxfdPublisher(),fMgBChapView.getjTxfdPgNum(),fMgBChapView.getjTxfdNoOfBks().getText().toString(),fMgBChapView.getjTxfdRese().getText().toString());
		arrLOfBChap.set(indexNum, fMBChapMdl);
		saveInDocuments();
	}

	//this is the method for deleting the selected row data
	public void mthdForDeleteBChap(int indexNum) {
		arrLOfBChap = getBkChArrayList();
		arrLOfBChap.remove(indexNum);
		saveInDocuments();
	}

	//method for writing the data in the respective dat file using arraylist
	public void saveInDocuments() {
		String nameOfFile = "documents/bkChaptersDetails".concat(".dat");
		try {
			FileOutputStream fopsOfBkChar = new FileOutputStream(nameOfFile);
			ObjectOutputStream oopsOfBkChar = new ObjectOutputStream(fopsOfBkChar);
			oopsOfBkChar.writeObject(arrLOfBChap);
			oopsOfBkChar.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {
		}
	}

	//method for reading the data from the respective dat file
	@SuppressWarnings("unchecked")
	public ArrayList<ForMngBookChapsModel> getBkChArrayList(){
		ArrayList<ForMngBookChapsModel> BkCharList = null;
		String nameOfFile = "documents/bkChaptersDetails".concat(".dat");
		try {
			FileInputStream fisOfBkChar = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfBkChar = new ObjectInputStream(fisOfBkChar);
			Object ojct = oisOfBkChar.readObject();
			BkCharList = (ArrayList<ForMngBookChapsModel>) ojct;
			oisOfBkChar.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return BkCharList;

	}

	//method for displaying data in the table in scrollpane
	public JScrollPane layOutTbl() {
		if(getBkChArrayList()!=null) {
			arrLOfBChap = getBkChArrayList();
			ForMngBookChapsModel fmBChapMdel = new ForMngBookChapsModel();
			for(int i = 0; i<arrLOfBChap.size();i++) {
				fmBChapMdel = arrLOfBChap.get(i);
				int snOfBChap = i+1;
				Object[] BkCharValues = {snOfBChap,fmBChapMdel.getttlOfBChap(), fmBChapMdel.getAuthNmOfBChap(), fmBChapMdel.getEditorOfBk(), fmBChapMdel.getPubYearOfBk(), fmBChapMdel.getPlcOfPub(),fmBChapMdel.getPubleroOfBk(), fmBChapMdel.getPgOfBChap(), fmBChapMdel.getNoOfBks(), fmBChapMdel.getNmOfRe()};
				defTblForBkCharMdl.addRow(BkCharValues);
			}
		}
		String reColTitles[]  = {"SNo.", "Title of Book Chapter", "Author/s","Editor/s", "<html>Publication<br>Year</html>","Place of Publication","Publisher","Page No.","<html>No. of Articles<br>Available</html>","Loaned Out To"};
		defTblForBkCharMdl.setColumnIdentifiers(reColTitles);
		jTblForBkCharMdl.setRowHeight(28);
		jTblForBkCharMdl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//designs for the table header
		JTableHeader tblHeader = jTblForBkCharMdl.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		TableColumnModel tblColMdl = jTblForBkCharMdl.getColumnModel();
		tblColMdl.getColumn(1).setPreferredWidth(160);
		tblColMdl.getColumn(2).setPreferredWidth(140);
		tblColMdl.getColumn(3).setPreferredWidth(140);
		tblColMdl.getColumn(5).setPreferredWidth(140);
		tblColMdl.getColumn(6).setPreferredWidth(140);
		tblColMdl.getColumn(8).setPreferredWidth(95);
		tblColMdl.getColumn(9).setPreferredWidth(150);

		return jSpForBkCharMdl;
	}

	public JTable getjTblForBkCharMdl() {
		return jTblForBkCharMdl;
	}

	public String getttlOfBChap() {
		return ttlOfBChap;
	}

	public String getAuthNmOfBChap() {
		return authNmOfBChap;
	}

	public String getEditorOfBk() {
		return editorOfBk;
	}

	public String getPubYearOfBk() {
		return pubYearOfBk;
	}

	public String getPlcOfPub() {
		return plcOfPub;
	}

	public String getPubleroOfBk() {
		return publeroOfBk;
	}

	public String getPgOfBChap() {
		return pgOfBChap;
	}

	public String getNoOfBks() {
		return noOfBks;
	}

	public String getNmOfRe() {
		return nmOfRe;
	}
}