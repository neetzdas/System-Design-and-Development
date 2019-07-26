package controller;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import view.*;
import model.*;

public class ForSigninController {
	ForSignInView fsinv;
	ForSigninModel fsinm;

	public ForSigninController(ForSignInView fsinv, ForSigninModel fsinm){
		this.fsinv = fsinv;
		this.fsinm = fsinm;
	}

	//method for calling buttons
	public void signInControl() {
		fsinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				JButton jBtnLbl = (JButton) actE.getSource(); //getting the clicked button
				String jBtnLblName = jBtnLbl.getText(); //getting the name of clicked button 

				//after sign in button is clicked
				if(jBtnLblName.equals("SIGN IN")) {
					String urNm = fsinv.getjTfdUsrnm().getText();
					String passwd = fsinv.getjPwdForSignin().getText();

					//if librarian is selected
					if(fsinv.getjRdBtnForLibrarian().isSelected()) {
						if (urNm.equals("library") && passwd.equals("fine")){
							JOptionPane.showMessageDialog(null, "Login successful!");
							fsinv.dispose();
							ForAdmHmController ahc = new ForAdmHmController(new ForAdmHmView());
						}
						else {
							JOptionPane.showMessageDialog(null, "Not logged in!Enter right credentials!");
						}
					}
					//if researcher is selected
					else if(fsinv.getjRdBtnForResearcher().isSelected()) {
						if(fsinm.reseSigninVerify(fsinv)) {
							String researcherName = fsinm.getReseNm();
							JOptionPane.showMessageDialog(null, researcherName+" ! You are logged in!" );
							fsinv.dispose();
							ForReseHmController  frhc = new ForReseHmController(new ForReseHmView());
						}
						else {
							JOptionPane.showMessageDialog(null, "Not logged in!Enter right credentials!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Please choose the user-type!");
					}
				}
				//after clear button is clicked, the textfields and buttons are cleared
				if(jBtnLblName.equals("CLEAR")) {
					fsinv.jTfdUsrnm.setText("");
					fsinv.jPwdForSignin.setText("");
					fsinv.jRdBtnForLibrarian.setSelected(false);
					fsinv.jRdBtnForResearcher.setSelected(false);
					fsinv.jRdBtnGp.clearSelection();
				}
				//after close button is clicked, the system exits
				if(jBtnLblName.equals("CLOSE")) {
					System.exit(0);	
				}
			}
		});
	}
}