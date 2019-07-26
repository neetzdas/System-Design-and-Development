package controller;

import java.awt.event.*;

import model.ForReseJrArticlesModel;
import view.ForReseArticlesView;

public class ForReseJrArticlesController {
	ForReseArticlesView fReArV;
	ForReseJrArticlesModel fReArMdl;
	
	public ForReseJrArticlesController(ForReseArticlesView frjav, ForReseJrArticlesModel frjam) {
		this.fReArV = frjav;
		this.fReArMdl = frjam;
	}
	
	public void reseJrBtns() {
		this.fReArV.getjBtnForViewHJr().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEe) {
				fReArV.mthdForHScp(); //method called to view hired articles
			}
		});
		
		this.fReArV.getjBtnForViewFJr().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEe) {
				fReArV.mthdForFScp(); //method called to view available articles
			}
		});
	}
}