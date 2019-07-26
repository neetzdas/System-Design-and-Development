package model;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import view.ForMngJrArticleView;

public class ForMngJrArticleModel implements Serializable{
	private static final long serialVersionUID = 1L;

	DefaultTableModel defTblForJrArtMdl = new DefaultTableModel(0,10);
	private JTable jTblForJrArtMdl = new JTable(defTblForJrArtMdl){
		//method to make the rows and columns of the table uneditable.
		public boolean isCellEditable(int row, int column) {
			return false; 
		}
	};
	private JScrollPane jSpForJrArtMdl = new JScrollPane(jTblForJrArtMdl);

	String arNmOfJr, authNmOfJr, nmOfJr, yrOfJr, volOfJr, issOfJr, pgOfJr, noOfJr, nmOfRe; 
	ArrayList <ForMngJrArticleModel> arrLOfJr = new ArrayList<ForMngJrArticleModel>();

	public ForMngJrArticleModel() {}

	//this is the constructor used for adding these data to its class
	public ForMngJrArticleModel(String arNmOfJr,String authNmOfJr,String nmOfJr,String yrOfJr,String volOfJr,String issOfJr,String pgOfJr,String noOfJr,String nmOfRe) {
		this.arNmOfJr = arNmOfJr;
		this.authNmOfJr = authNmOfJr;
		this.nmOfJr = nmOfJr;
		this.yrOfJr = yrOfJr;
		this.volOfJr = volOfJr;
		this.issOfJr = issOfJr;
		this.pgOfJr = pgOfJr;
		this.noOfJr = noOfJr;
		this.nmOfRe = nmOfRe;

		//method for adding the data 
		if(getJrArtArrayList()!=null) {
			arrLOfJr = getJrArtArrayList();
			arrLOfJr.add(this);
			saveInDocuments(); //saving the data in the file
		}
		else {
			arrLOfJr.add(this);
			saveInDocuments();
		}
	}

	//this is the method for editing the data and saving in the files
	public void mthdForEditJr(ForMngJrArticleView fMgJrView, int indexNum) {
		arrLOfJr = getJrArtArrayList();
		ForMngJrArticleModel fMJrMdl = new ForMngJrArticleModel(fMgJrView.getjTxfdArTtl(),fMgJrView.getjTxfdAuthr(),fMgJrView.getjTxfdJrTtl(),fMgJrView.getjTxfdYrOfPub(),fMgJrView.getjTxfdVolNum(),fMgJrView.getjTxfdIssueNum(),fMgJrView.getjTxfdPgNum(),fMgJrView.getjTxfdNoOfAr().getText().toString(),fMgJrView.getjTxfdRese().getText().toString());
		arrLOfJr.set(indexNum, fMJrMdl);
		saveInDocuments();
	}

	//this is the method for deleting the selected row data
	public void mthdForDeleteJr(int indexNum) {
		arrLOfJr = getJrArtArrayList();
		arrLOfJr.remove(indexNum);
		saveInDocuments();
	}

	//method for writing the data in the respective dat file using arraylist
	public void saveInDocuments() {
		String nameOfFile = "documents/journalDetails".concat(".dat");
		try {
			FileOutputStream fopsOfJrArt = new FileOutputStream(nameOfFile);
			ObjectOutputStream oopsOfJrArt = new ObjectOutputStream(fopsOfJrArt);
			oopsOfJrArt.writeObject(arrLOfJr);
			oopsOfJrArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {
		}
	}

	//method for reading the data from the respective dat file
	@SuppressWarnings("unchecked")
	public ArrayList<ForMngJrArticleModel> getJrArtArrayList(){
		ArrayList<ForMngJrArticleModel> jrArtList = null;
		String nameOfFile = "documents/journalDetails".concat(".dat");
		try {
			FileInputStream fisOfJrArt = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfJrArt = new ObjectInputStream(fisOfJrArt);
			Object ojct = oisOfJrArt.readObject();
			jrArtList = (ArrayList<ForMngJrArticleModel>) ojct;
			oisOfJrArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return jrArtList;

	}

	//method for displaying data in the table in scrollpane  
	public JScrollPane layOutTbl() {
		if(getJrArtArrayList()!=null) {
			arrLOfJr = getJrArtArrayList();
			ForMngJrArticleModel fmJrMdel = new ForMngJrArticleModel();
			for(int i = 0; i<arrLOfJr.size();i++) {
				fmJrMdel = arrLOfJr.get(i);
				int snOfJr = i+1;
				Object[] jrArtValues = {snOfJr,fmJrMdel.getArNmOfJr(), fmJrMdel.getAuthNmOfJr(), fmJrMdel.getNmOfJr(), fmJrMdel.getYrOfJr(), fmJrMdel.getVolOfJr(),fmJrMdel.getIssOfJr(), fmJrMdel.getPgOfJr(), fmJrMdel.getNoOfJr(), fmJrMdel.getNmOfRe()};
				defTblForJrArtMdl.addRow(jrArtValues);
			}
		}
		String reColTitles[]  = {"SNo.", "Name of Article", "Author/s","Journal Title", "<html>Publication<br>Year</html>","Volume No.","Issue No.","Page No.","<html>No. of Articles<br>Available</html>","Loaned Out To"};
		defTblForJrArtMdl.setColumnIdentifiers(reColTitles);
		jTblForJrArtMdl.setRowHeight(28);
		jTblForJrArtMdl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//designs for the table header
		JTableHeader tblHeader = jTblForJrArtMdl.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		TableColumnModel tblColMdl = jTblForJrArtMdl.getColumnModel();
		tblColMdl.getColumn(1).setPreferredWidth(140);
		tblColMdl.getColumn(2).setPreferredWidth(140);
		tblColMdl.getColumn(3).setPreferredWidth(140);
		tblColMdl.getColumn(8).setPreferredWidth(95);
		tblColMdl.getColumn(9).setPreferredWidth(150);

		return jSpForJrArtMdl;
	}

	public JTable getjTblForJrArtMdl() {
		return jTblForJrArtMdl;
	}

	public String getArNmOfJr() {
		return arNmOfJr;
	}

	public String getAuthNmOfJr() {
		return authNmOfJr;
	}

	public String getNmOfJr() {
		return nmOfJr;
	}

	public String getYrOfJr() {
		return yrOfJr;
	}

	public String getVolOfJr() {
		return volOfJr;
	}

	public String getIssOfJr() {
		return issOfJr;
	}

	public String getPgOfJr() {
		return pgOfJr;
	}

	public String getNoOfJr() {
		return noOfJr;
	}

	public String getNmOfRe() {
		return nmOfRe;
	}
}