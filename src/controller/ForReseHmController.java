package controller;

import java.awt.event.*;

import javax.swing.JButton;

import model.*;
import view.*;

public class ForReseHmController {
	ForReseHmView frshv;

	public ForReseHmController(ForReseHmView frshv) {
		this.frshv = frshv;

		this.frshv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actE) {
				JButton jBtnLbl = (JButton) actE.getSource(); //getting the clicked button
				String jBtnLblName = jBtnLbl.getText(); //getting the name of the clicked button

				if(jBtnLblName.equals("JOURNAL ARTICLES")) {
					mthdForMngJArticles();
				}
				if(jBtnLblName.equals("CONFERENCE ARTICLES")) {
					mthdForMngCArticles();
				}
				if(jBtnLblName.equals("BOOK CHAPTERS")) {
					mthdForMngBChapters();
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

	//method for calling the panel of journal articles
	public void mthdForMngJArticles() {
		ForReseArticlesView frev = new ForReseArticlesView();
		frshv.mthdForPnlAdd(frev.jrList(), "");
		frshv.mthdForPnlChange("");
		ForReseJrArticlesController frjac = new ForReseJrArticlesController(frev,new ForReseJrArticlesModel());
	}
	
	//method for calling the panel of conference articles
	public void mthdForMngCArticles() {
		ForReseArticlesView frev = new ForReseArticlesView();
		frshv.mthdForPnlAdd(frev.confList(), "");
		frshv.mthdForPnlChange("");
		ForReseCoArticlesController frjac = new ForReseCoArticlesController(frev,new ForReseCoArticlesModel());
	}
	
	//method for calling the panel of book chapters
	public void mthdForMngBChapters() {
		ForReseArticlesView frev = new ForReseArticlesView();
		frshv.mthdForPnlAdd(frev.bkCpList(), "");
		frshv.mthdForPnlChange("");
		ForReseBkCpController frjac = new ForReseBkCpController(frev,new ForReseBkCpModel());
	}
	
	//method for signing out of the account
	public void mthdForSignout() {
		frshv.dispose();
		ForSigninController fsgic = new ForSigninController(new ForSignInView(), new ForSigninModel());
		fsgic.signInControl();
	}

	//method for returning to the home page of the researcher
	public void mthdForBack() {
		frshv.dispose();
		ForReseHmController frshc =  new ForReseHmController(new ForReseHmView());
	}

	//method for exiting the system
	public void mthdForClose() {
		System.exit(0);
	}
}