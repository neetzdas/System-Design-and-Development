package controller;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import model.*;
import view.*;

public class ForMngBookChapsController {
	ForMngBookChapsView fmngBkCV;
	JTable jTblForBkCpC = new JTable();
	private int rowOfBkTbl;

	public ForMngBookChapsController(ForMngBookChapsView fmngBkCV) {
		this.fmngBkCV = fmngBkCV;
	}

	//method to select the row of the table
	public void dataSelection() {
		jTblForBkCpC = fmngBkCV.getjTblForBkChapsView();
		jTblForBkCpC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTblForBkCpC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				fmngBkCV.getjTxfdNoOfBks().setEditable(false);
				fmngBkCV.getjBtnAdding().setEnabled(false);
				fmngBkCV.getjBtnModifying().setEnabled(true);
				fmngBkCV.getjBtnRemoving().setEnabled(true);
				fmngBkCV.getjBtnReturning().setVisible(true);
				fmngBkCV.getjBtnLoaning().setVisible(true);

				String ttlOfBChp, authNmOfBChp, editrOfBChp, pubYear, pubLctn, publisrOfBk, pgOfBChp, noOfBks, nmOfRese; 
				rowOfBkTbl = jTblForBkCpC.getSelectedRow();
				ttlOfBChp = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 1);
				authNmOfBChp = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 2);
				editrOfBChp = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 3);
				pubYear = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 4);
				pubLctn = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 5);
				publisrOfBk = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 6);
				pgOfBChp = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 7);
				noOfBks = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 8);
				nmOfRese = (String) jTblForBkCpC.getValueAt(rowOfBkTbl, 9);
				//setting the values of the respective row in the textfields
				fmngBkCV.setValuesInRow(ttlOfBChp, authNmOfBChp, editrOfBChp, pubYear, pubLctn, publisrOfBk, pgOfBChp,noOfBks, nmOfRese);
			}
		});
	}

	//method for buttons	
	public void infoSavingBtns() {
		//add button
		fmngBkCV.getjBtnAdding().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actE) {
				if(fmngBkCV.getjTxfdBkChap().isEmpty()
						|| fmngBkCV.getjTxfdAuthr().isBlank() 
						|| fmngBkCV.getjTxfdEditorOfBk().isBlank()
						|| fmngBkCV.getjTxfdYrOfPub().isEmpty()
						|| fmngBkCV.getjTxfdPlaceOfPubn().isEmpty()
						|| fmngBkCV.getjTxfdPublisher().isBlank()
						|| fmngBkCV.getjTxfdPgNum().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					bkChapInfoAddBtn();
				}
			}
		});

		//modify button
		fmngBkCV.getjBtnModifying().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				if(fmngBkCV.getjTxfdBkChap().isEmpty()
						|| fmngBkCV.getjTxfdAuthr().isBlank() 
						|| fmngBkCV.getjTxfdEditorOfBk().isBlank()
						|| fmngBkCV.getjTxfdYrOfPub().isEmpty()
						|| fmngBkCV.getjTxfdPlaceOfPubn().isEmpty()
						|| fmngBkCV.getjTxfdPublisher().isBlank()
						|| fmngBkCV.getjTxfdPgNum().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Book Chapter Data modified successfully");
					bkChapInfoEditBtn();
				}
			}
		});

		//delete button
		fmngBkCV.getjBtnRemoving().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				int deleteConfm = JOptionPane.showConfirmDialog(fmngBkCV, "ARE YOU SURE?", "CONFIRM",
						JOptionPane.YES_NO_OPTION);
				if (deleteConfm == 0) {
					bkChapInfoDeleteBtn();
				}
			}
		});

		//loan out button used mouse listener
		fmngBkCV.getjBtnLoaning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngBkCV.getjLbelRese().setVisible(true);
				fmngBkCV.getjTxfdRese().setVisible(true);
				fmngBkCV.getjBtnModifying().setEnabled(false);
				fmngBkCV.getjBtnReturning().setEnabled(false);
				if(e.getClickCount()==2){  //if clicked twice
					noOfArtAfterLoan();
				}
			}
		});

		//return button used mouse listener
		fmngBkCV.getjBtnReturning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngBkCV.getjLbelRese().setVisible(true);
				fmngBkCV.getjTxfdRese().setVisible(true);
				fmngBkCV.getjBtnModifying().setEnabled(false);
				fmngBkCV.getjBtnLoaning().setEnabled(false);
				if(e.getClickCount()==2){    //if clicked twice
					noOfArtAfterReturn();
				}
			}
		});

		//clear button
		fmngBkCV.getjBtnClearing().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				updatingPanelMthd();
			}
		});
	}

	//method for adding the data after the add button is clicked
	public void bkChapInfoAddBtn() {
		ForMngBookChapsModel fmngBkcpMd = new ForMngBookChapsModel(fmngBkCV.getjTxfdBkChap(),fmngBkCV.getjTxfdAuthr(),fmngBkCV.getjTxfdEditorOfBk(),fmngBkCV.getjTxfdYrOfPub(),fmngBkCV.getjTxfdPlaceOfPubn(),fmngBkCV.getjTxfdPublisher(),fmngBkCV.getjTxfdPgNum(),fmngBkCV.getjTxfdNoOfBks().getText(),fmngBkCV.getjTxfdRese().getText());
		JOptionPane.showMessageDialog(null, "Book Chapter Data saved successfully");
		updatingPanelMthd();
	}

	//method for editing the data after the edit button is clicked
	public void bkChapInfoEditBtn() {
		ForMngBookChapsModel fmgBkcpMdl = new ForMngBookChapsModel();
		fmgBkcpMdl.mthdForEditBChap(fmngBkCV, rowOfBkTbl);
		updatingPanelMthd();
	}
	
	//method for deleting the data after the delete button is clicked
	public void bkChapInfoDeleteBtn() {
		ForMngBookChapsModel fmgBkcpMdl = new ForMngBookChapsModel();
		fmgBkcpMdl.mthdForDeleteBChap(rowOfBkTbl);
		JOptionPane.showMessageDialog(null, "Book Chapter Data removed successfully");
		updatingPanelMthd();
	}

	//method for decreasing the number of chapters after the loan out button is clicked
	public void noOfArtAfterLoan() {
		int noOfBkChpAvail = Integer.parseInt(fmngBkCV.getjTxfdNoOfBks().getText());
		String newNoOfBkChpAvail;
		if(noOfBkChpAvail>0 && noOfBkChpAvail<=5) {
			newNoOfBkChpAvail = Integer.toString(noOfBkChpAvail-1);
			fmngBkCV.getjTxfdNoOfBks().setText(newNoOfBkChpAvail);
			JOptionPane.showMessageDialog(null, "Book Chapter loaned out");
			bkChapInfoEditBtn();
		}
		else if(noOfBkChpAvail==0) {
			JOptionPane.showMessageDialog(null, "No Chapters to loan out");
			bkChapInfoEditBtn();
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid number of articles");
		}
	}

	//method for increasing the number of chapters after the return button is clicked
	public void noOfArtAfterReturn() {
		int noOfBkChpAvail = Integer.parseInt(fmngBkCV.getjTxfdNoOfBks().getText());
		String newNoOfBkChpAvail;
		if(noOfBkChpAvail==0 || noOfBkChpAvail<5) {
			newNoOfBkChpAvail = Integer.toString(noOfBkChpAvail+1);
			fmngBkCV.getjTxfdNoOfBks().setText(newNoOfBkChpAvail);
			JOptionPane.showMessageDialog(null, "Book Chapter returned");
			bkChapInfoEditBtn();
		}
		else if(noOfBkChpAvail==5) {
			fmngBkCV.getjTxfdRese().setText(null);
			JOptionPane.showMessageDialog(null, "No Chapters to return");
			bkChapInfoEditBtn();
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
		ForMngBookChapsView viewOfMngBookCp = new ForMngBookChapsView();	
		ForMngBookChapsController cntrlOfMngBookCp = new ForMngBookChapsController(viewOfMngBookCp);
		viewOfAdm.getjPnlForAdmHmBtwn().add(viewOfMngBookCp);
		viewOfMngBookCp.revalidate();
		viewOfMngBookCp.repaint();	

		//this method is for closing all the windows except for the current window
		java.awt.Window winFrame[] = java.awt.Window.getWindows(); 
		for(int i=0;i<(winFrame.length)-1;i++){ 
			winFrame[i].dispose(); 
		}
	}
}