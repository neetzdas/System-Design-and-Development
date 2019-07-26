package controller;

import java.awt.event.*;

import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

import view.*;
import model.*;
import controller.*;

public class ForMngResearcherController {
	ForMngResearcherView fmngrv;
	JTable jTblForReC = new JTable();
	private int rowOfReTbl;

	public ForMngResearcherController(ForMngResearcherView fmngrv) {
		this.fmngrv = fmngrv;
	}

	//method to select the row of the table
	public void dataSelection() {
		jTblForReC = fmngrv.getjTblForReView();
		jTblForReC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTblForReC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				fmngrv.getjBtnAdding().setEnabled(false);
				fmngrv.getjBtnModifying().setEnabled(true);
				fmngrv.getjBtnRemoving().setEnabled(true);

				String idOfRese, nmOfRese, genOfRese, adrOfRese, phnOfRese, emlOfRese, usNmOfRese, pswdOfRese;
				rowOfReTbl = jTblForReC.getSelectedRow();
				idOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 0);
				nmOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 1);
				genOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 2);
				if(genOfRese.equals("Male")) {
					fmngrv.jRdBtnForMale.setSelected(true);
				}
				else if(genOfRese.equals("Female")) {
					fmngrv.jRdBtnForFemale.setSelected(true);
				}
				else {
					fmngrv.jRdBtnForOthers.setSelected(true);
				}
				adrOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 3);
				phnOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 4);
				emlOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 5);
				usNmOfRese = (String) jTblForReC.getValueAt(rowOfReTbl, 6);
				pswdOfRese =  jTblForReC.getValueAt(rowOfReTbl, 7).toString();
				fmngrv.setValuesInRow(idOfRese, nmOfRese, adrOfRese, phnOfRese, emlOfRese, usNmOfRese, pswdOfRese); //setting the values of the respective row in the textfields
			}
		});
	}

	//method for buttons
	public void infoSavingBtns() {
		String validateEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; //checking the email format
		//add button method
		fmngrv.getjBtnAdding().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				if(fmngrv.getjTxfdReFullNm().isEmpty()
						|| fmngrv.getjRdBtnGp().isSelected(null)
						|| fmngrv.getjTxfdReLtn().isBlank() 
						|| fmngrv.getjTxfdRePhn().isBlank()
						|| fmngrv.getjTxfdReEmAds().isEmpty()
						|| fmngrv.getjTxfdReUsrNm().isEmpty()
						|| fmngrv.getjTxfdRePwd().getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else if(!fmngrv.getjTxfdReEmAds().matches(validateEmail)){
					JOptionPane.showMessageDialog(null, "Wrong email format!");
				}
				else {
					researcherInfoAddBtn();
				}
			}
		});

		//edit button method
		fmngrv.getjBtnModifying().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				if(fmngrv.getjTxfdReFullNm().isEmpty()
						|| fmngrv.getjRdBtnGp().isSelected(null)
						|| fmngrv.getjTxfdReLtn().isBlank() 
						|| fmngrv.getjTxfdRePhn().isBlank()
						|| fmngrv.getjTxfdReEmAds().isEmpty()
						|| fmngrv.getjTxfdReUsrNm().isEmpty()
						|| fmngrv.getjTxfdRePwd().getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Incomplete data!");
				}
				else if(!fmngrv.getjTxfdReEmAds().matches(validateEmail)){ //validating the email
					JOptionPane.showMessageDialog(null, "Wrong email format!");
				}
				else {
					researcherInfoEditBtn();
				}
			}
		});

		//delete button method
		fmngrv.getjBtnRemoving().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				JOptionPane.showMessageDialog(null, "Check if the researcher has returned all the articles");
				int deleteConfm = JOptionPane.showConfirmDialog(fmngrv, "ARE YOU SURE?", "CONFIRM",
						JOptionPane.YES_NO_OPTION);
				if (deleteConfm == 0) {
					researcherInfoDeleteBtn();
				}
			}
		});

		//reset button method
		fmngrv.getjBtnClearing().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				updatingPanelMthd();
			}
		});
	}

	//method for adding the data after the add button is clicked
	public void researcherInfoAddBtn() {
		ForMngResearcherModel fmngrm = new ForMngResearcherModel(fmngrv.getjTxfdReIdNo(), fmngrv.getjTxfdReFullNm(),fmngrv.getjRdBtnGp().getSelection().getActionCommand().toString(),fmngrv.getjTxfdReLtn(),fmngrv.getjTxfdRePhn(),fmngrv.getjTxfdReEmAds(),fmngrv.getjTxfdReUsrNm(),fmngrv.getjTxfdRePwd().getText().toCharArray());
		JOptionPane.showMessageDialog(null, "Researcher Data saved successfully");
		updatingPanelMthd();
	}

	//method for editing the data after the edit button is clicked
	public void researcherInfoEditBtn() {
		ForMngResearcherModel fmnrm = new ForMngResearcherModel();
		fmnrm.mthdForEditRe(fmngrv, rowOfReTbl);
		JOptionPane.showMessageDialog(null, "Researcher Data modified successfully");
		updatingPanelMthd();
	}

	//method for deleting the data after the delete button is clicked
	public void researcherInfoDeleteBtn() {
		ForMngResearcherModel fmnrm = new ForMngResearcherModel();
		fmnrm.mthdForDeleteRe(rowOfReTbl);
		JOptionPane.showMessageDialog(null, "Researcher Data removed successfully");
		updatingPanelMthd();
	}

	//this method is for refreshing the table after adding, modifying and deleting.
	public void updatingPanelMthd() {
		//again creating the frame of admin so that the panel of researcher can also be repainted. 
		ForAdmHmView viewOfAdm = new ForAdmHmView();
		ForAdmHmController cntrlOfAdm = new ForAdmHmController(viewOfAdm);
		viewOfAdm.getjPnlForAdmHmBtwn().removeAll();

		//the panel of researcher is repainted.
		ForMngResearcherView viewOfMngRe = new ForMngResearcherView();	
		ForMngResearcherController cntrlOfMngRe = new ForMngResearcherController(viewOfMngRe);
		viewOfAdm.getjPnlForAdmHmBtwn().add(viewOfMngRe);
		viewOfMngRe.revalidate();
		viewOfMngRe.repaint();	

		//this method is for closing all the windows except for the current window
		java.awt.Window winFrame[] = java.awt.Window.getWindows(); 
		for(int i=0;i<(winFrame.length)-1;i++){ 
			winFrame[i].dispose(); 
		}
	}
}