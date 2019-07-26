package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controller.*;
import model.*;

public class ForReseArticlesView {
	private JPanel jPnelForList = new JPanel(null);
	private JLabel jLbelForTitlList, jLblBackgrdImg;

	private JButton jBtnForViewHJr, jBtnForViewFJr, jBtnForViewHCo, jBtnForViewFCo, jBtnForViewHBkCp, jBtnForViewFBkCp;

	JScrollPane jScPForHJrList, jScPForFJrList, jScPForHCoList, jScPForFCoList, jScPForHBkCp, jScpForFBkCp;

	ImageIcon iconForPanel3;
	Border matteBrdr;

	private ForReseJrArticlesModel frjamdl = new ForReseJrArticlesModel();
	private ForReseCoArticlesModel frcamdl = new ForReseCoArticlesModel();
	private ForReseBkCpModel frbcmdl = new ForReseBkCpModel();

	public ForReseArticlesView() {
		jPnelForList.setLayout(null);
		jPnelForList.setBounds(0, 80, 900, 410);

		matteBrdr = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE); //matte border for the panels

		iconForPanel3 = new ImageIcon("images/panel3.jpg");
		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 0, 900, 410);
		jPnelForList.add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);

		jLbelForTitlList = new JLabel("");
		jLbelForTitlList.setFont(new Font("Mistral", Font.PLAIN, 25));
		jLbelForTitlList.setForeground(Color.white);
		jLbelForTitlList.setBounds(280, 70, 500, 30);
		jLblBackgrdImg.add(jLbelForTitlList);

		jPnelForList.setVisible(true);
	}

	//panel for the journal articles
	public JPanel jrList() {

		JPanel jPnelForJrBts = new JPanel(null);
		jPnelForJrBts.setBounds(10, 10, 830, 50);
		jPnelForJrBts.setOpaque(false);
		jPnelForJrBts.setBorder(matteBrdr);
		jLblBackgrdImg.add(jPnelForJrBts);

		jBtnForViewHJr = new JButton("VIEW HIRED ARTICLES");
		jBtnForViewHJr.setBounds(100, 10, 200, 30);
		jPnelForJrBts.add(jBtnForViewHJr);
		jBtnForViewHJr.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewHJr.setBackground(new Color(21, 34, 49));
		jBtnForViewHJr.setForeground(Color.WHITE);

		jBtnForViewFJr = new JButton("VIEW AVAILABLE ARTICLES");
		jBtnForViewFJr.setBounds(490, 10, 250, 30);
		jPnelForJrBts.add(jBtnForViewFJr);
		jBtnForViewFJr.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewFJr.setBackground(new Color(21, 34, 49));
		jBtnForViewFJr.setForeground(Color.WHITE);

		ForReseJrArticlesController frjacntrl = new ForReseJrArticlesController(this, frjamdl);
		frjacntrl.reseJrBtns();
		return jPnelForList;		
	}

	//method for viewing hired articles
	public void mthdForHScp() {
		try {
			jLbelForTitlList.setText("JOURNAL ARTCILES HIRED BY YOU");
			jScPForHJrList = new JScrollPane(frjamdl.getJrTbl());
			jScPForHJrList.setBounds(10, 100, 830, 300);
			jScPForHJrList.setOpaque(false);
			jScPForHJrList.getViewport().setOpaque(false);
			jScPForHJrList.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScPForHJrList);	
			jScPForFJrList.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	//method for viewing available articles
	public void mthdForFScp() {
		try {
			jLbelForTitlList.setText("AVAILABLE JOURNAL ARTICLES");
			jScPForFJrList = new JScrollPane(frjamdl.getJrTbl2());
			jScPForFJrList.setBounds(10, 100, 830, 300);
			jScPForFJrList.setOpaque(false);
			jScPForFJrList.getViewport().setOpaque(false);
			jScPForFJrList.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScPForFJrList);
			jScPForHJrList.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	public JButton getjBtnForViewHJr() {
		return jBtnForViewHJr;
	}

	public JButton getjBtnForViewFJr() {
		return jBtnForViewFJr;
	}

	//panel for the conference articles
	public JPanel confList() {

		JPanel jPnelForJrBts = new JPanel(null);
		jPnelForJrBts.setBounds(10, 10, 830, 50);
		jPnelForJrBts.setOpaque(false);
		jPnelForJrBts.setBorder(matteBrdr);
		jLblBackgrdImg.add(jPnelForJrBts);

		jBtnForViewHCo = new JButton("VIEW HIRED ARTICLES");
		jBtnForViewHCo.setBounds(100, 10, 200, 30);
		jPnelForJrBts.add(jBtnForViewHCo);
		jBtnForViewHCo.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewHCo.setBackground(new Color(21, 34, 49));
		jBtnForViewHCo.setForeground(Color.WHITE);

		jBtnForViewFCo = new JButton("VIEW AVAILABLE ARTICLES");
		jBtnForViewFCo.setBounds(490, 10, 250, 30);
		jPnelForJrBts.add(jBtnForViewFCo);
		jBtnForViewFCo.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewFCo.setBackground(new Color(21, 34, 49));
		jBtnForViewFCo.setForeground(Color.WHITE);

		ForReseCoArticlesController frjacntrl = new ForReseCoArticlesController(this, frcamdl);
		frjacntrl.reseCoBtns();
		return jPnelForList;		
	}

	//method for viewing hired articles
	public void mthdForHCoScp() {
		try {
			jLbelForTitlList.setText("CONFERENCE ARTCILES HIRED BY YOU");
			jScPForHCoList = new JScrollPane(frcamdl.getCoTbl());
			jScPForHCoList.setBounds(10, 100, 830, 300);
			jScPForHCoList.setOpaque(false);
			jScPForHCoList.getViewport().setOpaque(false);
			jScPForHCoList.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScPForHCoList);	
			jScPForFCoList.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	//method for viewing available articles
	public void mthdForFCoScp() {
		try {
			jLbelForTitlList.setText("AVAILABLE CONFERENCE ARTICLES");
			jScPForFCoList = new JScrollPane(frcamdl.getCoTbl2());
			jScPForFCoList.setBounds(10, 100, 830, 300);
			jScPForFCoList.setOpaque(false);
			jScPForFCoList.getViewport().setOpaque(false);
			jScPForFCoList.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScPForFCoList);
			jScPForHCoList.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	public JButton getjBtnForViewHCo() {
		return jBtnForViewHCo;
	}

	public JButton getjBtnForViewFCo() {
		return jBtnForViewFCo;
	}

	//panel for the book chapters
	public JPanel bkCpList() {

		JPanel jPnelForJrBts = new JPanel(null);
		jPnelForJrBts.setBounds(10, 10, 830, 50);
		jPnelForJrBts.setOpaque(false);
		jPnelForJrBts.setBorder(matteBrdr);
		jLblBackgrdImg.add(jPnelForJrBts);

		jBtnForViewHBkCp = new JButton("VIEW HIRED BOOK CHAPTERS");
		jBtnForViewHBkCp.setBounds(100, 10, 260, 30);
		jPnelForJrBts.add(jBtnForViewHBkCp);
		jBtnForViewHBkCp.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewHBkCp.setBackground(new Color(21, 34, 49));
		jBtnForViewHBkCp.setForeground(Color.WHITE);

		jBtnForViewFBkCp = new JButton("VIEW AVAILABLE BOOK CHAPTERS");
		jBtnForViewFBkCp.setBounds(490, 10, 250, 30);
		jPnelForJrBts.add(jBtnForViewFBkCp);
		jBtnForViewFBkCp.setFont(new Font("Mistral", Font.BOLD, 16));
		jBtnForViewFBkCp.setBackground(new Color(21, 34, 49));
		jBtnForViewFBkCp.setForeground(Color.WHITE);

		ForReseBkCpController frbcpcntrl = new ForReseBkCpController(this, frbcmdl);
		frbcpcntrl.reseBkCpBtns();
		return jPnelForList;		
	}

	//method for viewing hired chapters
	public void mthdForHBkCpScp() {
		try {
			jLbelForTitlList.setText("BOOK CHAPTERS HIRED BY YOU");
			jScPForHBkCp = new JScrollPane(frbcmdl.getBCpTbl());
			jScPForHBkCp.setBounds(10, 100, 830, 300);
			jScPForHBkCp.setOpaque(false);
			jScPForHBkCp.getViewport().setOpaque(false);
			jScPForHBkCp.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScPForHBkCp);	
			jScpForFBkCp.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	//method for viewing available chapters
	public void mthdForFBkCpScp() {
		try {
			jLbelForTitlList.setText("AVAILABLE BOOK CHAPTERS");
			jScpForFBkCp = new JScrollPane(frbcmdl.getBCpTbl2());
			jScpForFBkCp.setBounds(10, 100, 830, 300);
			jScpForFBkCp.setOpaque(false);
			jScpForFBkCp.getViewport().setOpaque(false);
			jScpForFBkCp.setBorder(matteBrdr);
			jLblBackgrdImg.add(jScpForFBkCp);
			jScPForHBkCp.setVisible(false);
		}
		catch(NullPointerException npe) {}
	}

	public JButton getjBtnForViewHBkCp() {
		return jBtnForViewHBkCp;
	}

	public JButton getjBtnForViewFBkCp() {
		return jBtnForViewFBkCp;
	}
}