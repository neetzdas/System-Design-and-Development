package model;

import java.awt.*;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ForReseCoArticlesModel {
	ForSigninModel fsimdl = new ForSigninModel();
	String loggedReseId = fsimdl.getReseId(); //getting the id of the researcher who has logged in

	//method to read the files using arraylist to get the data
	public ArrayList<ForMngCoArticleModel> getCoArtArrayList(){
		ArrayList<ForMngCoArticleModel> cofArticles = null;
		String nameOfFile = "documents/confArticleDetails".concat(".dat");
		try {
			FileInputStream fisOfCoArt = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfCoArt = new ObjectInputStream(fisOfCoArt);
			Object ojct = oisOfCoArt.readObject();
			cofArticles = (ArrayList<ForMngCoArticleModel>) ojct;
			oisOfCoArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return cofArticles;
	}

	//method for getting data of the hired articles in the table
	public JTable getCoTbl() {
		ForMngCoArticleModel fmngCof = new ForMngCoArticleModel();
		DefaultTableModel defModel = new DefaultTableModel(0,6);
		JTable jTblForConA = new JTable(defModel);
		for(int i =0; i<getCoArtArrayList().size();i++) {
			fmngCof = getCoArtArrayList().get(i);
			//condition to check if there is id of the logged in researcher in the loaned out to column 
			if(fmngCof.getNmOfRe().contains(loggedReseId)) {
				Object[] objData = {fmngCof.getArNmOfConfnArt(), fmngCof.getAuthNmOfConfnArt(),fmngCof.getEditorOfConfnArt(), fmngCof.getYrOfConfnArt(), fmngCof.getLocnOfConfnArt(),fmngCof.getPgOfConfnArt()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Name of Article", "Author/s","Editor/s", "<html>Publication<br>Year</html>","<html>Location Of<br>Conference</html>","Page No."};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForConA.setRowHeight(28);

		JTableHeader tblHeader = jTblForConA.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForConA;
	}

	//method for getting data of the available articles in the table
	public JTable getCoTbl2() {
		ForMngCoArticleModel fmngCof = new ForMngCoArticleModel();
		DefaultTableModel defModel = new DefaultTableModel(0,7);
		JTable jTblForConA = new JTable(defModel);
		for(int i =0; i<getCoArtArrayList().size();i++) {
			fmngCof = getCoArtArrayList().get(i);
			//condition to check if there is availability of articles that the logged in researcher has not hired
			if(!fmngCof.getNmOfRe().contains(loggedReseId) && !fmngCof.getNoOfConfnArt().contentEquals("0")) {
				Object[] objData = {fmngCof.getArNmOfConfnArt(), fmngCof.getAuthNmOfConfnArt(),fmngCof.getEditorOfConfnArt(), fmngCof.getYrOfConfnArt(), fmngCof.getLocnOfConfnArt(),fmngCof.getPgOfConfnArt(), fmngCof.getNoOfConfnArt()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Name of Article", "Author/s","Editor/s", "<html>Publication<br>Year</html>","<html>Location Of<br>Conference</html>","Page No.","<html>No. of Articles<br>Available</html>"};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForConA.setRowHeight(28);

		JTableHeader tblHeader = jTblForConA.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForConA;
	}

}
