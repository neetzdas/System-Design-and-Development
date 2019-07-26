package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import model.ForSigninModel;

public class ForReseHmView extends JFrame{
	private JPanel jPnlForReseHmUp, jPnlForReseHmBtwn, jPnlForReseHmDown, jPnlFor;
	ImageIcon iconForPanel3, titleIcon, iconJournalImg, iconBookImg, iconConfImg;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelTtl2, jLbelWel, jLbelJournal, jLbelBook, jLbelConf;
	private Border matteBrdr;
	private JButton jBtnForJourAr, jBtnForConfAr, jBtnForBookCh, jBtnForSignOut, jBtnBack, jBtnClose;

	//using cardLayout to change the panel of the researcher pages after logged in
	private CardLayout pnlCardL = new CardLayout();
	
	public ForReseHmView() {
		setSize(850, 550);
		getContentPane().setLayout(null);
		setTitle("Northampton Research Centre - Researcher Home Page");
		titleIcon = new ImageIcon("images/iconForTitle.png");
		setIconImage(titleIcon.getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		//images and their locations
		iconForPanel3 = new ImageIcon("images/panel3.jpg");
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

		//the first panel with royal blue color
		jPnlForReseHmUp = new JPanel(null);
		jPnlForReseHmUp.setBounds(0, 0, 850, 80);
		getContentPane().add(jPnlForReseHmUp);
		jPnlForReseHmUp.setBackground(new Color(21, 34, 49));
		jPnlForReseHmUp.setBorder(matteBrdr);
		jPnlForReseHmUp.setLayout(null);

		//title of the research center added in the first panel
		jLbelTtl1 = new JLabel("NORTHAMPTON RESEARCH CENTER");
		jLbelTtl1.setBounds(250, 5, 500, 40);
		jPnlForReseHmUp.add(jLbelTtl1);
		jLbelTtl1.setFont(new Font("Mistral", Font.BOLD, 32));
		jLbelTtl1.setForeground(Color.WHITE);

		//second title in the first panel
		jLbelTtl2 = new JLabel("RESEARCH ARTICLE MANAGEMENT SYSTEM");
		jLbelTtl2.setBounds(295, 50, 500, 20);
		jPnlForReseHmUp.add(jLbelTtl2);
		jLbelTtl2.setFont(new Font("Mistral", Font.BOLD, 20));
		jLbelTtl2.setForeground(Color.WHITE);

		//the second panel with background image
		jPnlForReseHmBtwn = new JPanel(pnlCardL);
		jPnlForReseHmBtwn.setBounds(0, 70, 900, 410);
		getContentPane().add(jPnlForReseHmBtwn);
		jPnlForReseHmBtwn.add(researcherHomePg(), "");
		pnlCardL.show(jPnlForReseHmBtwn, "");

		//the third panel with royal blue color
		jPnlForReseHmDown = new JPanel(null);
		jPnlForReseHmDown.setBounds(0, 480, 900, 70);
		getContentPane().add(jPnlForReseHmDown);
		jPnlForReseHmDown.setBackground(new Color( 21, 34, 49));
		jPnlForReseHmDown.setBorder(matteBrdr);

		jBtnForSignOut = new JButton("SIGN OUT");
		jBtnForSignOut.setBounds(90, 18, 100, 31);
		jBtnForSignOut.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForReseHmDown.add(jBtnForSignOut);

		jBtnBack = new JButton("BACK");
		jBtnBack.setBounds(360, 18, 100, 31);
		jBtnBack.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForReseHmDown.add(jBtnBack);

		jBtnClose = new JButton("CLOSE");
		jBtnClose.setBounds(630, 18, 100, 31);
		jBtnClose.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForReseHmDown.add(jBtnClose);
	}

	//this is the panel when signed in to the account of researcher
	public JPanel researcherHomePg() {
		JPanel jPnlForReseSignedIn = new JPanel(); 

		//background image added in the second panel
		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 70, 900, 370);
		jPnlForReseSignedIn.add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);

		jLbelWel = new JLabel("Welcome " + ForSigninModel.researcherNm );
		jLbelWel.setBounds(680, 15, 270, 40);
		jLblBackgrdImg.add(jLbelWel);
		jLbelWel.setFont(new Font("Mistral",Font.BOLD, 35));
		
		jLbelJournal =new JLabel(iconJournalImg);
		jLbelJournal.setBounds(450, 30, 150, 150);
		jLblBackgrdImg.add(jLbelJournal);

		jBtnForJourAr = new JButton("JOURNAL ARTICLES");
		jBtnForJourAr.setBounds(450, 170, 160, 30);
		jLblBackgrdImg.add(jBtnForJourAr);
		jBtnForJourAr.setFont(new Font("Mistral", Font.BOLD, 14));

		jLbelConf =new JLabel(iconConfImg);
		jLbelConf.setBounds(690, 100, 150, 150);
		jLblBackgrdImg.add(jLbelConf);

		jBtnForConfAr = new JButton("CONFERENCE ARTICLES");
		jBtnForConfAr.setBounds(690, 240, 165, 30);
		jLblBackgrdImg.add(jBtnForConfAr);
		jBtnForConfAr.setFont(new Font("Mistral", Font.BOLD, 14));

		jLbelBook =new JLabel(iconBookImg);
		jLbelBook.setBounds(950, 170, 150, 150);
		jLblBackgrdImg.add(jLbelBook);

		jBtnForBookCh = new JButton("BOOK CHAPTERS");
		jBtnForBookCh.setBounds(950, 310, 160, 30);
		jLblBackgrdImg.add(jBtnForBookCh);
		jBtnForBookCh.setFont(new Font("Mistral", Font.BOLD, 14));

		return jPnlForReseSignedIn;
	}
	
		//method to return the current running frame
		public JFrame returnCurrFrame() {
			return (JFrame) getContentPane();
		}
		
		//it adds the new panel in the panel jPnlForReseHmBtwn
		public void mthdForPnlAdd(JPanel jPnlOfRese, String pnlNameOfRese) {
			jPnlForReseHmBtwn.add(jPnlOfRese, pnlNameOfRese);
		}

		//it is the method for changing panels 
		public void mthdForPnlChange(String pnlNameOfRese) {
			pnlCardL.show(jPnlForReseHmBtwn, pnlNameOfRese);
		}
		
		//method for the actionListener of the buttons
		public void addActionListener(ActionListener actl) {
			jBtnForJourAr.addActionListener(actl);
			jBtnForConfAr.addActionListener(actl);
			jBtnForBookCh.addActionListener(actl);
			jBtnForSignOut.addActionListener(actl);
			jBtnBack.addActionListener(actl);
			jBtnClose.addActionListener(actl);
		}
}