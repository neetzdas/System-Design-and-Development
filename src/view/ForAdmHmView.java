package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ForAdmHmView extends JFrame{
	private JPanel jPnlOfFull, jPnlForAdmHmUp, jPnlForAdmHmDown, jPnlForAdmHmBtwn;
	ImageIcon iconForPanel3, titleIcon, iconRserchrImg, iconJournalImg, iconBookImg, iconConfImg;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelTtl2, jLbelWel, jLbelRserchr, jLbelJournal, jLbelBook, jLbelConf;
	private Border matteBrdr;

	private JButton jBtnForResearcher, jBtnForJourAr, jBtnForConfAr, jBtnForBookCh, jBtnForSignOut, jBtnBack, jBtnClose;

	public ForAdmHmView() {
		setSize(1000, 600);
		setTitle("Northampton Research Centre - Admin Home Page");
		titleIcon = new ImageIcon("images/iconForTitle.png");
		setIconImage(titleIcon.getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		//images and their locations
		iconForPanel3 = new ImageIcon("images/panel3.jpg");
		iconRserchrImg = new ImageIcon("images/researchers.png");
		iconJournalImg = new ImageIcon("images/journals.png");
		iconConfImg = new ImageIcon("images/conference.png");
		iconBookImg = new ImageIcon("images/books.png");

		matteBrdr = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE); //matte border for the panels

		//calling designGUI method
		designGUI();
		setVisible(true);

	}

	private void designGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//the first panel with full size of frame
		jPnlOfFull = new JPanel(null);
		jPnlOfFull.setPreferredSize(new Dimension(1000, 600));
		getContentPane().add(jPnlOfFull);

		//the second panel with royal blue color added in first panel 
		jPnlForAdmHmUp = new JPanel(null);
		jPnlForAdmHmUp.setBounds(0, 0, 1000, 80);
		jPnlOfFull.add(jPnlForAdmHmUp);
		jPnlForAdmHmUp.setBackground(new Color(21, 34, 49));
		jPnlForAdmHmUp.setBorder(matteBrdr);

		//title of the research center added in the second panel
		jLbelTtl1 = new JLabel("NORTHAMPTON RESEARCH CENTER");
		jLbelTtl1.setBounds(330, 10, 500, 40);
		jPnlForAdmHmUp.add(jLbelTtl1);
		jLbelTtl1.setFont(new Font("Mistral", Font.BOLD, 30));
		jLbelTtl1.setForeground(Color.WHITE);

		//second title in the second panel
		jLbelTtl2 = new JLabel("RESEARCH ARTICLE MANAGEMENT SYSTEM");
		jLbelTtl2.setBounds(375, 55, 500, 20);
		jPnlForAdmHmUp.add(jLbelTtl2);
		jLbelTtl2.setFont(new Font("Mistral", Font.BOLD, 18));
		jLbelTtl2.setForeground(Color.WHITE);

		//the third panel with background image added in the first panel 
		jPnlForAdmHmBtwn = new JPanel(null);
		jPnlForAdmHmBtwn.setBounds(0, 80, 1000, 475);
		jPnlOfFull.add(jPnlForAdmHmBtwn);

		//background image added in the third panel
		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 0, 1000, 475);
		jPnlForAdmHmBtwn.add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);

		//the fourth panel with royal blue color added in the first panel 
		jPnlForAdmHmDown = new JPanel(null);
		jPnlForAdmHmDown.setBounds(0, 555, 1000, 55);
		jPnlOfFull.add(jPnlForAdmHmDown);
		jPnlForAdmHmDown.setBackground(new Color( 21, 34, 49));
		jPnlForAdmHmDown.setBorder(matteBrdr);

		jLbelWel = new JLabel("WELCOME LIBRARIAN");
		jLbelWel.setBounds(370, 20, 270, 35);
		jLblBackgrdImg.add(jLbelWel);
		jLbelWel.setFont(new Font("Mistral", Font.BOLD, 34));

		jLbelRserchr =new JLabel(iconRserchrImg);
		jLbelRserchr.setBounds(50, 40, 150, 150);
		jLblBackgrdImg.add(jLbelRserchr);

		jBtnForResearcher =  new JButton("MANAGE RESEARCHER");
		jBtnForResearcher.setBounds(50, 180, 160, 30);
		jLblBackgrdImg.add(jBtnForResearcher);
		jBtnForResearcher.setFont(new Font("Mistral", Font.BOLD, 14));

		jLbelConf =new JLabel(iconConfImg);
		jLbelConf.setBounds(300, 180, 150, 150);
		jLblBackgrdImg.add(jLbelConf);

		jBtnForConfAr = new JButton("CONFERENCE ARTICLES");
		jBtnForConfAr.setBounds(300, 330, 165, 30);
		jLblBackgrdImg.add(jBtnForConfAr);
		jBtnForConfAr.setFont(new Font("Mistral", Font.BOLD, 14));

		jLbelJournal =new JLabel(iconJournalImg);
		jLbelJournal.setBounds(550, 180, 150, 150);
		jLblBackgrdImg.add(jLbelJournal);

		jBtnForJourAr = new JButton("JOURNAL ARTICLES");
		jBtnForJourAr.setBounds(550, 330, 160, 30);
		jLblBackgrdImg.add(jBtnForJourAr);
		jBtnForJourAr.setFont(new Font("Mistral", Font.BOLD, 14));

		jLbelBook =new JLabel(iconBookImg);
		jLbelBook.setBounds(800, 40, 150, 150);
		jLblBackgrdImg.add(jLbelBook);

		jBtnForBookCh = new JButton("BOOK CHAPTERS");
		jBtnForBookCh.setBounds(800, 180, 160, 30);
		jLblBackgrdImg.add(jBtnForBookCh);
		jBtnForBookCh.setFont(new Font("Mistral", Font.BOLD, 14));

		jBtnForSignOut = new JButton("SIGN OUT");
		jBtnForSignOut.setBounds(250, 8, 100, 30);
		jBtnForSignOut.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForAdmHmDown.add(jBtnForSignOut);

		jBtnBack = new JButton("BACK");
		jBtnBack.setBounds(450, 8, 100, 30);
		jBtnBack.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForAdmHmDown.add(jBtnBack);

		jBtnClose = new JButton("CLOSE");
		jBtnClose.setBounds(650, 8, 100, 30);
		jBtnClose.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForAdmHmDown.add(jBtnClose);
	}

	//method for buttons with actionlistener
	public void addActionListener(ActionListener actl) {
		jBtnForResearcher.addActionListener(actl);
		jBtnForJourAr.addActionListener(actl);
		jBtnForConfAr.addActionListener(actl);
		jBtnForBookCh.addActionListener(actl);
		jBtnForSignOut.addActionListener(actl);
		jBtnBack.addActionListener(actl);
		jBtnClose.addActionListener(actl);
	}

	//method for changing panels with the home page of the librarian
	public void mthdForMngResearcher() {
		jPnlForAdmHmBtwn.removeAll();
		revalidate();
		repaint();
		ForMngResearcherView fmrv = new ForMngResearcherView();
		jPnlForAdmHmBtwn.add(fmrv);
	}

	public void mthdForMngCArticles() {
		jPnlForAdmHmBtwn.removeAll();
		revalidate();
		repaint();
		ForMngCoArticleView fmcav =  new ForMngCoArticleView();
		jPnlForAdmHmBtwn.add(fmcav);
	}

	public void mthdForMngJArticles() {
		jPnlForAdmHmBtwn.removeAll();
		revalidate();
		repaint();
		ForMngJrArticleView fmjav = new ForMngJrArticleView();
		jPnlForAdmHmBtwn.add(fmjav);
	}

	public void mthdForMngBChapters() {
		jPnlForAdmHmBtwn.removeAll();
		revalidate();
		repaint();
		ForMngBookChapsView fmbcv = new ForMngBookChapsView();
		jPnlForAdmHmBtwn.add(fmbcv);
	}

	public JPanel getjPnlForAdmHmBtwn() {
		return jPnlForAdmHmBtwn;
	}
}