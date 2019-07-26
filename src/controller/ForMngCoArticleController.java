package controller;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import model.*;
import view.*;

public class ForMngCoArticleController {
	ForMngCoArticleView fmngCoArtV;
	JTable jTblForCoArtC = new JTable();
	private int rowOfCoArtTbl;

	public ForMngCoArticleController(ForMngCoArticleView fmngCoArtV) {
		this.fmngCoArtV = fmngCoArtV;
	}

	//method to select the row of the table
	public void dataSelection() {
		jTblForCoArtC = fmngCoArtV.getjTblForConArtView();
		jTblForCoArtC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTblForCoArtC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				fmngCoArtV.getjTxfdNoOfAr().setEditable(false);
				fmngCoArtV.getjBtnAdding().setEnabled(false);
				fmngCoArtV.getjBtnModifying().setEnabled(true);
				fmngCoArtV.getjBtnRemoving().setEnabled(true);
				fmngCoArtV.getjBtnReturning().setVisible(true);
				fmngCoArtV.getjBtnLoaning().setVisible(true);

				String arNmOfConArt, authNmOfConArt, editorOfConArt, yrOfConArt, loctnOfConf, pgOfConArt, noOfConArt, nmOfRese; 
				rowOfCoArtTbl = jTblForCoArtC.getSelectedRow();
				arNmOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 1);
				authNmOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 2);
				editorOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 3);
				yrOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 4);
				loctnOfConf = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 5);
				pgOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 6);
				noOfConArt = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 7);
				nmOfRese = (String) jTblForCoArtC.getValueAt(rowOfCoArtTbl, 8);
				//setting the values of the respective row in the textfields
				fmngCoArtV.setValuesInRow(arNmOfConArt, authNmOfConArt, editorOfConArt, yrOfConArt, loctnOfConf, pgOfConArt,noOfConArt, nmOfRese); 
			}
		});
	}

	//method for buttons
	public void infoSavingBtns() {
		//add button
		fmngCoArtV.getjBtnAdding().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actE) {
				if(fmngCoArtV.getjTxfdArTtl().isEmpty()
						|| fmngCoArtV.getjTxfdAuthr().isBlank() 
						|| fmngCoArtV.getjTxfdEditorOfCoPd().isBlank()
						|| fmngCoArtV.getjTxfdYrOfPub().isEmpty()
						|| fmngCoArtV.getjTxfdCoLoctn().isEmpty()
						|| fmngCoArtV.getjTxfdPgNum().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					ConArticleInfoAddBtn();
				}
			}
		});

		//modify button
		fmngCoArtV.getjBtnModifying().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				if(fmngCoArtV.getjTxfdArTtl().isEmpty()
						|| fmngCoArtV.getjTxfdAuthr().isBlank() 
						|| fmngCoArtV.getjTxfdEditorOfCoPd().isBlank()
						|| fmngCoArtV.getjTxfdYrOfPub().isEmpty()
						|| fmngCoArtV.getjTxfdCoLoctn().isEmpty()
						|| fmngCoArtV.getjTxfdPgNum().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Conference Article Data modified successfully");
					ConArticleInfoEditBtn();
				}
			}
		});

		//delete button
		fmngCoArtV.getjBtnRemoving().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				int deleteConfm = JOptionPane.showConfirmDialog(fmngCoArtV, "ARE YOU SURE?", "CONFIRM",
						JOptionPane.YES_NO_OPTION);
				if (deleteConfm == 0) {
					ConArticleInfoDeleteBtn();
				}
			}
		});

		//loan out button used mouse listener
		fmngCoArtV.getjBtnLoaning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngCoArtV.getjLbelRese().setVisible(true);
				fmngCoArtV.getjTxfdRese().setVisible(true);
				fmngCoArtV.getjBtnModifying().setEnabled(false);
				fmngCoArtV.getjBtnReturning().setEnabled(false);
				if(e.getClickCount()==2){  //id clicked twice
					noOfArtAfterLoan();
				}
			}
		});

		//return button used mouse listener
		fmngCoArtV.getjBtnReturning().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){ //if clicked once
				fmngCoArtV.getjLbelRese().setVisible(true);
				fmngCoArtV.getjTxfdRese().setVisible(true);
				fmngCoArtV.getjBtnModifying().setEnabled(false);
				fmngCoArtV.getjBtnLoaning().setEnabled(false);
				if(e.getClickCount()==2){   //if clicked twice
					noOfArtAfterReturn();
				}
			}
		});

		//clear button
		fmngCoArtV.getjBtnClearing().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				updatingPanelMthd();
			}
		});
	}

	//method for adding the data after the add button is clicked
	public void ConArticleInfoAddBtn() {
		ForMngCoArticleModel fmngCoArtlMd = new ForMngCoArticleModel(fmngCoArtV.getjTxfdArTtl(),fmngCoArtV.getjTxfdAuthr(),fmngCoArtV.getjTxfdEditorOfCoPd(),fmngCoArtV.getjTxfdYrOfPub(),fmngCoArtV.getjTxfdCoLoctn(),fmngCoArtV.getjTxfdPgNum(),fmngCoArtV.getjTxfdNoOfAr().getText(),fmngCoArtV.getjTxfdRese().getText());
		JOptionPane.showMessageDialog(null, "Conference Article Data saved successfully");
		updatingPanelMthd();
	}

	//method for editing the data after the edit button is clicked
	public void ConArticleInfoEditBtn() {
		ForMngCoArticleModel fmgCoArtlMdl = new ForMngCoArticleModel();
		fmgCoArtlMdl.mthdForEditConfArt(fmngCoArtV, rowOfCoArtTbl);
		updatingPanelMthd();
	}
	
	//method for deleting the data after the delete button is clicked
	public void ConArticleInfoDeleteBtn() {
		ForMngCoArticleModel fmgCoArtlMdl = new ForMngCoArticleModel();
		fmgCoArtlMdl.mthdForDeleteConfArt(rowOfCoArtTbl);
		JOptionPane.showMessageDialog(null, "Conference Article Data removed successfully");
		updatingPanelMthd();
	}

	//method for decreasing the number of articles after the loan out button is clicked
	public void noOfArtAfterLoan() {
		int noOfArtAvail = Integer.parseInt(fmngCoArtV.getjTxfdNoOfAr().getText());
		String newNoOfArtAvail;
		if(noOfArtAvail>0 && noOfArtAvail<=5) {
			newNoOfArtAvail = Integer.toString(noOfArtAvail-1);
			fmngCoArtV.getjTxfdNoOfAr().setText(newNoOfArtAvail);
			JOptionPane.showMessageDialog(null, "Conference Article loaned out");
			ConArticleInfoEditBtn();
		}
		else if(noOfArtAvail==0) {
			JOptionPane.showMessageDialog(null, "No Articles to loan out");
			ConArticleInfoEditBtn();
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid number of articles");
		}
	}

	//method for increasing the number of articles after the return button is clicked
	public void noOfArtAfterReturn() {
		int noOfArtAvail = Integer.parseInt(fmngCoArtV.getjTxfdNoOfAr().getText());
		String newNoOfArtAvail;
		if(noOfArtAvail==0 || noOfArtAvail<=5) {
			newNoOfArtAvail = Integer.toString(noOfArtAvail+1);
			fmngCoArtV.getjTxfdNoOfAr().setText(newNoOfArtAvail);
			JOptionPane.showMessageDialog(null, "Conference Article returned");
			ConArticleInfoEditBtn();
		}
		else if(noOfArtAvail==5) {
			fmngCoArtV.getjTxfdRese().setText(null);
			JOptionPane.showMessageDialog(null, "No Articles to return");
			ConArticleInfoEditBtn();
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
		ForMngCoArticleView viewOfMngConArt = new ForMngCoArticleView();	
		ForMngCoArticleController cntrlOfMngConArt = new ForMngCoArticleController(viewOfMngConArt);
		viewOfAdm.getjPnlForAdmHmBtwn().add(viewOfMngConArt);
		viewOfMngConArt.revalidate();
		viewOfMngConArt.repaint();	

		//this method is for closing all the windows except for the current window
		java.awt.Window winFrame[] = java.awt.Window.getWindows(); 
		for(int i=0;i<(winFrame.length)-1;i++){ 
			winFrame[i].dispose(); 
		}
	}
}