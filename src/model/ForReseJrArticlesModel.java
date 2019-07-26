package model;

import java.awt.*;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ForReseJrArticlesModel {
	ForSigninModel fsimdl = new ForSigninModel();
	String loggedReseId = fsimdl.getReseId(); //getting the id of the researcher who has logged in

	//method to read the files using arraylist to get the data
	public ArrayList<ForMngJrArticleModel> getJrArtArrayList(){
		ArrayList<ForMngJrArticleModel> jrArticles = null;
		String nameOfFile = "documents/journalDetails".concat(".dat");
		try {
			FileInputStream fisOfJrArt = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfJrArt = new ObjectInputStream(fisOfJrArt);
			Object ojct = oisOfJrArt.readObject();
			jrArticles = (ArrayList<ForMngJrArticleModel>) ojct;
			oisOfJrArt.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return jrArticles;
	}

	//method for getting data of the hired articles in the table
	public JTable getJrTbl() {
		ForMngJrArticleModel fmngJr = new ForMngJrArticleModel();
		DefaultTableModel defModel = new DefaultTableModel(0,7);
		JTable jTblForJr = new JTable(defModel);
		for(int i =0; i<getJrArtArrayList().size();i++) {
			fmngJr = getJrArtArrayList().get(i);
			//condition to check if there is id of the logged in researcher in the loaned out to column 
			if(fmngJr.getNmOfRe().contains(loggedReseId)) {
				Object[] objData = {fmngJr.getArNmOfJr(), fmngJr.getAuthNmOfJr(),fmngJr.getNmOfJr(), fmngJr.getYrOfJr(), fmngJr.getVolOfJr(),fmngJr.getIssOfJr(),fmngJr.getPgOfJr()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Name of Article", "Author/s","Journal Title", "<html>Publication<br>Year</html>","Volume No.","Issue No.","Page No."};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForJr.setRowHeight(28);

		JTableHeader tblHeader = jTblForJr.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForJr;
	}

	//method for getting data of the available articles in the table
	public JTable getJrTbl2() {
		ForMngJrArticleModel fmngJr = new ForMngJrArticleModel();
		DefaultTableModel defModel = new DefaultTableModel(0,8);
		JTable jTblForJr = new JTable(defModel);
		for(int i =0; i<getJrArtArrayList().size();i++) {
			fmngJr = getJrArtArrayList().get(i);
			//condition to check if there is availability of articles that the logged in researcher has not hired
			if(!fmngJr.getNmOfRe().contains(loggedReseId) && !fmngJr.getNoOfJr().contentEquals("0")) {
				Object[] objData = {fmngJr.getArNmOfJr(), fmngJr.getAuthNmOfJr(),fmngJr.getNmOfJr(), fmngJr.getYrOfJr(), fmngJr.getVolOfJr(),fmngJr.getIssOfJr(),fmngJr.getPgOfJr(),fmngJr.getNoOfJr()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Name of Article", "Author/s","Journal Title", "<html>Publication<br>Year</html>","Volume No.","Issue No.","Page No.","<html>No. of Articles<br>Available</html>"};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForJr.setRowHeight(28);

		JTableHeader tblHeader = jTblForJr.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForJr;
	}
}