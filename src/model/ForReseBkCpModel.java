package model;

import java.awt.*;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ForReseBkCpModel {
	ForSigninModel fsimdl = new ForSigninModel();
	String loggedReseId = fsimdl.getReseId(); //getting the id of the researcher who has logged in

	//method to read the files using arraylist to get the data
	public ArrayList<ForMngBookChapsModel> getBkChapArrayList(){
		ArrayList<ForMngBookChapsModel> bChaps = null;
		String nameOfFile = "documents/bkChaptersDetails".concat(".dat");
		try {
			FileInputStream fisOfbChaps = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfbChaps = new ObjectInputStream(fisOfbChaps);
			Object ojct = oisOfbChaps.readObject();
			bChaps = (ArrayList<ForMngBookChapsModel>) ojct;
			oisOfbChaps.close();
		}
		catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioet) {}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return bChaps;

	}

	//method for getting data of the hired book chapters in the table
	public JTable getBCpTbl() {
		ForMngBookChapsModel fmngBk = new ForMngBookChapsModel();
		DefaultTableModel defModel = new DefaultTableModel(0,7);
		JTable jTblForBk = new JTable(defModel);
		for(int i =0; i<getBkChapArrayList().size();i++) {
			fmngBk = getBkChapArrayList().get(i);
			//condition to check if there is id of the logged in researcher in the loaned out to column 
			if(fmngBk.getNmOfRe().contains(loggedReseId)) {
				Object[] objData = {fmngBk.getttlOfBChap(), fmngBk.getAuthNmOfBChap(),fmngBk.getEditorOfBk(), fmngBk.getPubYearOfBk(), fmngBk.getPlcOfPub(),fmngBk.getPubleroOfBk(),fmngBk.getPgOfBChap()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Title of Book Chapter", "Author/s","Editor/s", "<html>Publication<br>Year</html>","Place of Publication","Publisher","Page No."};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForBk.setRowHeight(28);

		JTableHeader tblHeader = jTblForBk.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForBk;
	}

	//method for getting data of the available book chapters in the table
	public JTable getBCpTbl2() {
		ForMngBookChapsModel fmngBk = new ForMngBookChapsModel();
		DefaultTableModel defModel = new DefaultTableModel(0,8);
		JTable jTblForBk = new JTable(defModel);
		for(int i =0; i<getBkChapArrayList().size();i++) {
			fmngBk = getBkChapArrayList().get(i);
			//condition to check if there is availability of book chapters that the logged in researcher has not hired
			if(!fmngBk.getNmOfRe().contains(loggedReseId) && !fmngBk.getNoOfBks().contentEquals("0")) {
				Object[] objData = {fmngBk.getttlOfBChap(), fmngBk.getAuthNmOfBChap(),fmngBk.getEditorOfBk(), fmngBk.getPubYearOfBk(), fmngBk.getPlcOfPub(),fmngBk.getPubleroOfBk(),fmngBk.getPgOfBChap(), fmngBk.getNoOfBks()};
				defModel.addRow(objData);
			}
		}

		String reColTitles[]  = {"Title of Book Chapter", "Author/s","Editor/s", "<html>Publication<br>Year</html>","Place of Publication","Publisher","Page No.","<html>No. of Articles<br>Available</html>"};
		defModel.setColumnIdentifiers(reColTitles);
		jTblForBk.setRowHeight(28);

		JTableHeader tblHeader = jTblForBk.getTableHeader();
		tblHeader.setPreferredSize(new Dimension(100,35));
		tblHeader.setBackground(new Color(21, 34, 49));
		tblHeader.setForeground(Color.WHITE);

		return jTblForBk;
	}
}
