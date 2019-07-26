package controller;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import view.*;
import model.*;

public class ForMngJrArticleController {
	ForMngJrArticleView fmngJrv;
	JTable jTblForJrC = new JTable();
	private int rowOfJrTbl;

	public ForMngJrArticleController(ForMngJrArticleView fmngJrv) {
		this.fmngJrv = fmngJrv;
	}

	//method to select the row of the table
	public void dataSelection() {
		jTblForJrC = fmngJrv.getjTblForJrArtView();
		jTblForJrC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTblForJrC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				fmngJrv.getjTxfdNoOfAr().setEditable(false);
				fmngJrv.getjBtnAdding().setEnabled(false);
				fmngJrv.getjBtnModifying().setEnabled(true);
				fmngJrv.getjBtnRemoving().setEnabled(true);
				fmngJrv.getjBtnReturning().setVisible(true);
				fmngJrv.getjBtnLoaning().setVisible(true);

				String arNmOfJrArt, authNmOfJrArt, nmOfJrArt, yrOfJrArt, volOfJrArt, issOfJrArt, pgOfJrArt, noOfJrArt, nmOfRese; 
				rowOfJrTbl = jTblForJrC.getSelectedRow();
				arNmOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 1);
				authNmOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 2);
				nmOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 3);
				yrOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 4);
				volOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 5);
				issOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 6);
				pgOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 7);
				noOfJrArt = (String) jTblForJrC.getValueAt(rowOfJrTbl, 8);
				nmOfRese = (String) jTblForJrC.getValueAt(rowOfJrTbl, 9);
				//setting the values of the respective row in the textfields
				fmngJrv.setValuesInRow(arNmOfJrArt, authNmOfJrArt, nmOfJrArt, yrOfJrArt, volOfJrArt, issOfJrArt, pgOfJrArt,noOfJrArt, nmOfRese);
			}
		});
	}

	//method for buttons
	public void infoSavingBtns() {
		//add button
		fmngJrv.getjBtnAdding().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actE) {
				if(fmngJrv.getjTxfdArTtl().isEmpty()
						|| fmngJrv.getjTxfdAuthr().isBlank() 
						|| fmngJrv.getjTxfdJrTtl().isBlank()
						|| fmngJrv.getjTxfdYrOfPub().isEmpty()
						|| fmngJrv.getjTxfdVolNum().isEmpty()
						|| fmngJrv.getjTxfdIssueNum().isBlank()
						|| fmngJrv.getjTxfdPgNum().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					jrArticleInfoAddBtn();
				}
			}
		});

		//modify button
		fmngJrv.getjBtnModifying().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				if(fmngJrv.getjTxfdArTtl().isEmpty()
						|| fmngJrv.getjTxfdAuthr().isBlank() 
						|| fmngJrv.getjTxfdJrTtl().isBlank()
						|| fmngJrv.getjTxfdYrOfPub().isEmpty()
						|| fmngJrv.getjTxfdVolNum().isEmpty()
						|| fmngJrv.getjTxfdIssueNum().isBlank()
						|| fmngJrv.getjTxfdPgNum().isBlank())  {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Journal Article Data modified successfully");
					jrArticleInfoEditBtn();
				}
			}
		});

		//delete button
		fmngJrv.getjBtnRemoving().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				int deleteConfm = JOptionPane.showConfirmDialog(fmngJrv, "ARE YOU SURE?", "CONFIRM",
						JOptionPane.YES_NO_OPTION);
				if (deleteConfm == 0) {
					jrArticleInfoDeleteBtn();
				}
			}
		});

		//loan out button used mouse listener
		fmngJrv.getjBtnLoaning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngJrv.getjLbelRese().setVisible(true);
				fmngJrv.getjTxfdRese().setVisible(true);
				fmngJrv.getjBtnModifying().setEnabled(false);
				fmngJrv.getjBtnReturning().setEnabled(false);
				if(e.getClickCount()==2){  //if clicked twice
					noOfArtAfterLoan();
				}
			}
		});

		//return button used mouse listener
		fmngJrv.getjBtnReturning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngJrv.getjLbelRese().setVisible(true);
				fmngJrv.getjTxfdRese().setVisible(true);
				fmngJrv.getjBtnModifying().setEnabled(false);
				fmngJrv.getjBtnLoaning().setEnabled(false);
				if(e.getClickCount()==2){  //if clicked twice
					noOfArtAfterReturn();
				}
			}
		});

		//clear button
		fmngJrv.getjBtnClearing().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				updatingPanelMthd();
			}
		});
	}
	
	//method for adding the data after the add button is clicked
	public void jrArticleInfoAddBtn() {
		ForMngJrArticleModel fmngJrMd = new ForMngJrArticleModel(fmngJrv.getjTxfdArTtl(),fmngJrv.getjTxfdAuthr(),fmngJrv.getjTxfdJrTtl(),fmngJrv.getjTxfdYrOfPub(),fmngJrv.getjTxfdVolNum(),fmngJrv.getjTxfdIssueNum(),fmngJrv.getjTxfdPgNum(),fmngJrv.getjTxfdNoOfAr().getText(),fmngJrv.getjTxfdRese().getText());
		JOptionPane.showMessageDialog(null, "Journal Article Data saved successfully");
		updatingPanelMthd();
	}

	//method for editing the data after the edit button is clicked
	public void jrArticleInfoEditBtn() {
		ForMngJrArticleModel fmgJrMdl = new ForMngJrArticleModel();
		fmgJrMdl.mthdForEditJr(fmngJrv, rowOfJrTbl);
		updatingPanelMthd();
	}
	
	//method for deleting the data after the delete button is clicked
	public void jrArticleInfoDeleteBtn() {
		ForMngJrArticleModel fmgJrMdl = new ForMngJrArticleModel();
		fmgJrMdl.mthdForDeleteJr(rowOfJrTbl);
		JOptionPane.showMessageDialog(null, "Journal Article Data removed successfully");
		updatingPanelMthd();
	}

	//method for decreasing the number of articles after the loan out button is clicked
	public void noOfArtAfterLoan() {
		int noOfArtAvail = Integer.parseInt(fmngJrv.getjTxfdNoOfAr().getText());
		String newNoOfArtAvail;
		if(noOfArtAvail>0 && noOfArtAvail<=5) {
			newNoOfArtAvail = Integer.toString(noOfArtAvail-1);
			fmngJrv.getjTxfdNoOfAr().setText(newNoOfArtAvail);
			JOptionPane.showMessageDialog(null, "Journal Article loaned out");
			jrArticleInfoEditBtn();
		}
		else if(noOfArtAvail==0) {
			JOptionPane.showMessageDialog(null, "No Articles to loan out");
			jrArticleInfoEditBtn();
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid number of articles");
		}
	}

	//method for increasing the number of articles after the return button is clicked
	public void noOfArtAfterReturn() {
		int noOfArtAvail = Integer.parseInt(fmngJrv.getjTxfdNoOfAr().getText()); 
		String newNoOfArtAvail;
		if(noOfArtAvail==0 || noOfArtAvail<5) {
			newNoOfArtAvail = Integer.toString(noOfArtAvail+1);
			fmngJrv.getjTxfdNoOfAr().setText(newNoOfArtAvail);
			JOptionPane.showMessageDialog(null, "Journal Article returned");
			jrArticleInfoEditBtn();
		}
		else if(noOfArtAvail==5) {
			fmngJrv.getjTxfdRese().setText(null);
			JOptionPane.showMessageDialog(null, "No Articles to return");
			jrArticleInfoEditBtn();
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid number of articles");
		}
	}

	//this method is for refreshing the table after adding, modifying and deleting.
	public void updatingPanelMthd() {
		//again creating the frame of admin so that the panel of researcher can also be repainted. 
		ForAdmHmView viewOfAdm = new ForAdmHmView();
		ForAdmHmController cntrlOfAdm = new ForAdmHmController(viewOfAdm);
		viewOfAdm.getjPnlForAdmHmBtwn().removeAll();

		//the panel of researcher is repainted.
		ForMngJrArticleView viewOfMngJrArt = new ForMngJrArticleView();	
		ForMngJrArticleController cntrlOfMngJrArt = new ForMngJrArticleController(viewOfMngJrArt);
		viewOfAdm.getjPnlForAdmHmBtwn().add(viewOfMngJrArt);
		viewOfMngJrArt.revalidate();
		viewOfMngJrArt.repaint();	

		//this method is for closing all the windows except for the current window
		java.awt.Window winFrame[] = java.awt.Window.getWindows(); 
		for(int i=0;i<(winFrame.length)-1;i++){ 
			winFrame[i].dispose(); 
		}
	}
}