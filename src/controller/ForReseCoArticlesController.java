package controller;

import java.awt.event.*;

import model.ForReseCoArticlesModel;
import view.ForReseArticlesView;

public class ForReseCoArticlesController {
	ForReseArticlesView fReArV = new ForReseArticlesView();
	ForReseCoArticlesModel fReArMdl;
	
	public ForReseCoArticlesController(ForReseArticlesView frjav, ForReseCoArticlesModel frjam) {
		this.fReArV = frjav;
		this.fReArMdl = frjam;
	}
	
	public void reseCoBtns() {
		this.fReArV.getjBtnForViewHCo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fReArV.mthdForHCoScp();  //method called to view hired articles
			}
		});
		
		this.fReArV.getjBtnForViewFCo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEe) {
				fReArV.mthdForFCoScp();  //method called to view available articles
			}
		});
	}
}