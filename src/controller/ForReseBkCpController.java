package controller;

import java.awt.event.*;

import model.ForReseBkCpModel;
import view.ForReseArticlesView;

public class ForReseBkCpController {
	ForReseArticlesView fReArV;
	ForReseBkCpModel fReBpMdl;
	
	public ForReseBkCpController(ForReseArticlesView frjav, ForReseBkCpModel frbpm) {
		this.fReArV = frjav;
		this.fReBpMdl = frbpm;
	}
	
	public void reseBkCpBtns() {
		this.fReArV.getjBtnForViewHBkCp().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEe) {
				fReArV.mthdForHBkCpScp();  //method called to view hired chapters
			}
		});
		
		this.fReArV.getjBtnForViewFBkCp().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEe) {
				fReArV.mthdForFBkCpScp();  //method called to view available articles
			}
		});
	}
}