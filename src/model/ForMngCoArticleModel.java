package model;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import view.ForMngCoArticleView;

public class ForMngCoArticleModel implements Serializable{
	private static final long serialVersionUID = 1L;

	DefaultTableModel defTblForConArtMdl = new DefaultTableModel(0,9);
	private JTable jTblForConArtMdl = new JTable(defTblForConArtMdl){
		//method to make the rows and columns of the table uneditable.
		public boolean isCellEditable(int row, int column) {
			return false; 
		}
	};
	private JScrollPane jSpForConArtMdl = new JScrollPane(jTblForConArtMdl);
	
	String arNmOfConfnArt, authNmOfConfnArt, editorOfConfnArt, yrOfConfnArt, locnOfConfnArt, issOfConfnArt, pgOfConfnArt, noOfConfnArt, nmOfRe; 
	ArrayList <ForMngCoArticleModel> arrLOfConfnArt = new ArrayList<ForMngCoArticleModel>();
	
	public ForMngCoArticleModel() {}
	
	//this is the constructor used for adding these data to its class
	public ForMngCoArticleModel(String arNmOfConfnArt,String authNmOfConfnArt,String editorOfConfnArt,String yrOfConfnArt,String locnOfConfnArt,String pgOfConfnArt,String noOfConfnArt,String nmOfRe) {
		this.arNmOfConfnArt = arNmOfConfnArt;
		this.authNmOfConfnArt = authNmOfConfnArt;
		this.editorOfConfnArt = editorOfConfnArt;
		this.yrOfConfnArt = yrOfConfnArt;
		this.locnOfConfnArt = locnOfConfnArt;
		this.pgOfConfnArt = pgOfConfnArt;
		this.noOfConfnArt = noOfConfnArt;
		this.nmOfRe = nmOfRe;

		//method for adding the data
		if(getConArtArrayList()!=null) {
			arrLOfConfnArt = getConArtArrayList();
			arrLOfConfnArt.add(this);
			saveInDocuments(); //saving the data in the file
		}
		else {
			arrLOfConfnArt.add(this);
			saveInDocuments();
		}
	}

	//this is the method for editing the data and saving in the files
	public void mthdForEditConfArt(ForMngCoArticleView fMgConView, int indexNum) {
		arrLOfConfnArt = getConArtArrayList();
		ForMngCoArticleModel fMConMdl = new ForMngCoArticleModel(fMgConView.getjTxfdArTtl(),fMgConView.getjTxfdAuthr(),fMgConView.getjTxfdEditorOfCoPd(),fMgConView.getjTxfdYrOfPub(),fMgConView.getjTxfdCoLoctn(),fMgConView.getjTxfdPgNum(),fMgConView.getjTxfdNoOfAr().getText().toString(),fMgConView.getjTxfdRese().getText().toString());
		arrLOfConfnArt.set(indexNum, fMConMdl);
		saveInDocuments();
	}

	//this is the method for deleting the selected row data
	public void mthdForDeleteConfArt(int indexNum) {
		arrLOfConfnArt = getConArtArrayList();
		arrLOfConfnArt.remove(indexNum);
		saveInDocuments();
	}

	//method for writing the data in the respective dat file using arraylist
	public void saveInDocuments() {
		String nameOfFile = "documents/confArticleDetails".concat(".dat");
		try {
			FileOutputStream fopsOfConfnArt = new FileOutputStream(nameOfFile);
			ObjectOutputStream oopsOfConfnArt = new ObjectOutputStream(fopsOfConfnArt);
			oopsOfConfnArt.writeObject(arrLOfConfnArt);
			oopsOfConfnArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {
		}
	}

	//method for reading the data from the respective dat file
	@SuppressWarnings("unchecked")
	public ArrayList<ForMngCoArticleModel> getConArtArrayList(){
		ArrayList<ForMngCoArticleModel> confArtList = null;
		String nameOfFile = "documents/confArticleDetails".concat(".dat");
		try {
			FileInputStream fisOfConfnArt = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfConfnArt = new ObjectInputStream(fisOfConfnArt);
			Object ojct = oisOfConfnArt.readObject();
			confArtList = (ArrayList<ForMngCoArticleModel>) ojct;
			oisOfConfnArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return confArtList;
	}

	//method for displaying data in the table in scrollpane 	
	public JScrollPane layOutTbl() {
		if(getConArtArrayList()!=null) {
			arrLOfConfnArt = getConArtArrayList();
			ForMngCoArticleModel fmConArMdel = new ForMngCoArticleModel();
			for(int i = 0; i<arrLOfConfnArt.size();i++) {
				fmConArMdel = arrLOfConfnArt.get(i);
				int snOfConfnArt = i+1;
				Object[] confArtValues = {snOfConfnArt,fmConArMdel.getArNmOfConfnArt(), fmConArMdel.getAuthNmOfConfnArt(), fmConArMdel.getEditorOfConfnArt(), fmConArMdel.getYrOfConfnArt(), fmConArMdel.getLocnOfConfnArt(), fmConArMdel.getPgOfConfnArt(), fmConArMdel.getNoOfConfnArt(), fmConArMdel.getNmOfRe()};
				defTblForConArtMdl.addRow(confArtValues);
			}
		}
		
		String reColTitles[]  = {"SNo.", "Name of Article", "Author/s","Editor/s", "<html>Publication<br>Year</html>","<html>Location Of<br>Conference</html>","Page No.","<html>No. of Articles<br>Available</html>","Loaned Out To"};
		defTblForConArtMdl.setColumnIdentifiers(reColTitles);
		jTblForConArtMdl.setRowHeight(28);
		jTblForConArtMdl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//designs for the table header
		JTableHeader tblHeader = jTblForConArtMdl.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		TableColumnModel tblColMdl = jTblForConArtMdl.getColumnModel();
		tblColMdl.getColumn(1).setPreferredWidth(140);
		tblColMdl.getColumn(2).setPreferredWidth(140);
		tblColMdl.getColumn(3).setPreferredWidth(140);
		tblColMdl.getColumn(5).setPreferredWidth(140);
		tblColMdl.getColumn(7).setPreferredWidth(95);
		tblColMdl.getColumn(8).setPreferredWidth(130);

		return jSpForConArtMdl;
	}

	public JTable getjTblForConArtMdl() {
		return jTblForConArtMdl;
	}
	
	public String getArNmOfConfnArt() {
		return arNmOfConfnArt;
	}

	public String getAuthNmOfConfnArt() {
		return authNmOfConfnArt;
	}

	public String getEditorOfConfnArt() {
		return editorOfConfnArt;
	}

	public String getYrOfConfnArt() {
		return yrOfConfnArt;
	}

	public String getLocnOfConfnArt() {
		return locnOfConfnArt;
	}

	public String getPgOfConfnArt() {
		return pgOfConfnArt;
	}

	public String getNoOfConfnArt() {
		return noOfConfnArt;
	}

	public String getNmOfRe() {
		return nmOfRe;
	}
	
}
