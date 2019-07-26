package controller;

import java.awt.event.*;

import javax.swing.*;

import model.ForSigninModel;
import view.*;

public class ForAdmHmController {
	ForAdmHmView fadhv;

	public ForAdmHmController(ForAdmHmView fadhv) {
		this.fadhv = fadhv;

		this.fadhv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				JButton jBtnLbl = (JButton) actE.getSource(); //getting the clicked button
				String jBtnLblName = jBtnLbl.getText(); //getting the name of the clickedd button

				if(jBtnLblName.equals("MANAGE RESEARCHER")) {
					fadhv.mthdForMngResearcher();
				}
				if(jBtnLblName.equals("JOURNAL ARTICLES")) {
					fadhv.mthdForMngJArticles();
				}
				if(jBtnLblName.equals("CONFERENCE ARTICLES")) {
					fadhv.mthdForMngCArticles();
				}
				if(jBtnLblName.equals("BOOK CHAPTERS")) {
					fadhv.mthdForMngBChapters();
				}
				if(jBtnLblName.equals("SIGN OUT")) {
					mthdForSignout();
				}
				if(jBtnLblName.equals("BACK")) {
					mthdForBack();
				}
				if(jBtnLblName.contentEquals("CLOSE")) {
					mthdForClose();
				}
			}
		});		
	}

	//method for signing out of the accounts
	public void mthdForSignout() {
		fadhv.dispose();
		ForSigninController fsgic = new ForSigninController(new ForSignInView(), new ForSigninModel());
		fsgic.signInControl();
	}

	//method for going to the homepage of the librarian
	public void mthdForBack() {
		fadhv.dispose();
		ForAdmHmController fadhmc =  new ForAdmHmController(new ForAdmHmView());
	}

	//method for exiting the system
	public void mthdForClose() {
		System.exit(0);
	}
}