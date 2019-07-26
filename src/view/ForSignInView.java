package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class ForSignInView extends JFrame {
	private JPanel jPnlOfFull, jPnlOfUp, jPnlOfBtwn, jPnlOfDown, jPnlOfCnts;
	ImageIcon iconForPanel3, iconReCentre, titleIcon, iconImgLibra, iconImgRese;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelTtl2, jLbelSign, jLbelReCeIcon,  jLbelUsrnm, jLbelPwd, jLbelForType, jLbelIconLibra, jLbelIconRese;
	private Border matteBrdr;
	public JTextField jTfdUsrnm;
	public JPasswordField jPwdForSignin;

	public JRadioButton jRdBtnForLibrarian = new JRadioButton("Librarian");
	public JRadioButton  jRdBtnForResearcher = new JRadioButton("Researcher");
	public ButtonGroup jRdBtnGp = new ButtonGroup();

	private JButton jBtnForSignin, jBtnClear, jBtnClose;

	public ForSignInView() {
		setSize(700, 500);
		setTitle("Northampton Research Centre - Sign in Page");
		titleIcon = new ImageIcon("images/iconForTitle.png");
		setIconImage(titleIcon.getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		//images and their locations
		iconForPanel3 = new ImageIcon("images/panel3.jpg");
		iconReCentre = new ImageIcon("images/researchCenter.png");
		iconImgLibra = new ImageIcon("images/librarian.png");
		iconImgRese = new ImageIcon("images/researcher.png");
		
		matteBrdr = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE); //matte border for the panels

		//calling designGUI method
		designGUI();
		setVisible(true);

	}
	private void designGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container BkgrdCon= getContentPane();

		//the first panel with full size of frame
		jPnlOfFull = new JPanel(null);
		jPnlOfFull.setPreferredSize(new Dimension(700, 500));
		BkgrdCon.add(jPnlOfFull);

		//the second panel with royal blue color added in first panel 
		jPnlOfUp = new JPanel(null);
		jPnlOfUp.setBounds(0, 0, 700, 80);
		jPnlOfFull.add(jPnlOfUp);
		jPnlOfUp.setBackground(new Color(21, 34, 49));
		jPnlOfUp.setBorder(matteBrdr);

		//title of the research center added in the second panel
		jLbelTtl1 = new JLabel("NORTHAMPTON RESEARCH CENTER");
		jLbelTtl1.setBounds(180, 10, 500, 40);
		jPnlOfUp.add(jLbelTtl1);
		jLbelTtl1.setFont(new Font("Mistral", Font.BOLD, 30));
		jLbelTtl1.setForeground(Color.WHITE);

		//second title in the second panel
		jLbelTtl2 = new JLabel("RESEARCH ARTICLE MANAGEMENT SYSTEM");
		jLbelTtl2.setBounds(225, 55, 500, 20);
		jPnlOfUp.add(jLbelTtl2);
		jLbelTtl2.setFont(new Font("Mistral", Font.BOLD, 18));
		jLbelTtl2.setForeground(Color.WHITE);

		//the third panel with background image added in the first panel 
		jPnlOfBtwn = new JPanel(null);
		jPnlOfBtwn.setBounds(0, 80, 700, 360);
		jPnlOfFull.add(jPnlOfBtwn);

		//background image added in the third panel
		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 0, 700, 360);
		jPnlOfBtwn.add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);

		//icon image of research center
		jLbelReCeIcon = new JLabel(iconReCentre);
		jLbelReCeIcon.setBounds(10, 40, 250, 250);
		jLblBackgrdImg.add(jLbelReCeIcon);

		//the fourth panel with royal blue color added in the first panel 
		jPnlOfDown = new JPanel(null);
		jPnlOfDown.setBounds(0, 440, 700, 60);
		jPnlOfFull.add(jPnlOfDown);
		jPnlOfDown.setBackground(new Color( 21, 34, 49));
		jPnlOfDown.setBorder(matteBrdr);

		//the fifth panel added in the third panel with sign in contents
		jPnlOfCnts = new JPanel(null);
		jPnlOfCnts.setBounds(270, 40, 410, 300);
		jLblBackgrdImg.add(jPnlOfCnts);
		jPnlOfCnts.setOpaque(false);
		jPnlOfCnts.setBorder(matteBrdr);

		jLbelSign = new JLabel("SIGN IN TO YOUR ACCOUNT");
		jLbelSign.setBounds(250, 8, 250, 25);
		jLbelSign.setFont(new Font("Mistral", Font.ROMAN_BASELINE, 25));
		jLblBackgrdImg.add(jLbelSign);
		
		//contents of the fifth panel
		jLbelUsrnm = new JLabel("Username:");
		jLbelUsrnm.setFont(new Font("Mistral", Font.PLAIN, 25));
		jLbelUsrnm.setBounds(40, 35, 185, 31);
		jPnlOfCnts.add(jLbelUsrnm);

		jTfdUsrnm = new JTextField();
		jTfdUsrnm.setBounds(200, 30, 190, 31);
		jTfdUsrnm.setOpaque(false);
		jPnlOfCnts.add(jTfdUsrnm);

		jLbelPwd = new JLabel("Password:");
		jLbelPwd.setFont(new Font("Mistral", Font.PLAIN, 25));
		jLbelPwd.setBounds(40, 95, 185, 31);
		jPnlOfCnts.add(jLbelPwd);

		jPwdForSignin = new JPasswordField();
		jPwdForSignin.setBounds(200, 90, 190, 31);
		jPwdForSignin.setOpaque(false);
		jPnlOfCnts.add(jPwdForSignin);

		//radio buttons to choose the types of users to log in to the account
		jRdBtnForLibrarian.setFont(new Font("Mistral", Font.PLAIN, 25));
		jRdBtnForLibrarian.setBounds(30, 150, 100, 50);
		jRdBtnForLibrarian.setOpaque(false);
		jPnlOfCnts.add(jRdBtnForLibrarian);
		jRdBtnGp.add(jRdBtnForLibrarian);
		jRdBtnForLibrarian.setActionCommand("Librarian");

		//icon image of the admin
		jLbelIconLibra = new JLabel(iconImgLibra);
		jLbelIconLibra.setBounds(125, 120, 100, 100);
		jPnlOfCnts.add(jLbelIconLibra);

		jRdBtnForResearcher.setFont(new Font("Mistral", Font.PLAIN, 25));
		jRdBtnForResearcher.setBounds(215, 150, 130, 50);
		jRdBtnForResearcher.setOpaque(false);
		jPnlOfCnts.add(jRdBtnForResearcher);
		jRdBtnGp.add(jRdBtnForResearcher);
		jRdBtnForResearcher.setActionCommand("Researcher");

		//icon image of researcher
		jLbelIconRese = new JLabel(iconImgRese);
		jLbelIconRese.setBounds(310, 120, 100, 100);
		jPnlOfCnts.add(jLbelIconRese);

		jBtnForSignin = new JButton("SIGN IN");
		jBtnForSignin.setBounds(140, 230, 100, 31);
		jBtnForSignin.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlOfCnts.add(jBtnForSignin);
		
		jBtnClear = new JButton("CLEAR");
		jBtnClear.setBounds(250, 230, 100, 31);
		jBtnClear.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlOfCnts.add(jBtnClear);
	
		jBtnClose = new JButton("CLOSE");
		jBtnClose.setBounds(580, 10, 100, 31);
		jBtnClose.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlOfDown.add(jBtnClose);
	}
	
	//getter methods for textfields and radio buttons
	public JTextField getjTfdUsrnm() {
		return jTfdUsrnm;
	}

	public JPasswordField getjPwdForSignin() {
		return jPwdForSignin;
	}

	public JRadioButton getjRdBtnForLibrarian() {
		return jRdBtnForLibrarian;
	}

	public JRadioButton getjRdBtnForResearcher() {
		return jRdBtnForResearcher;
	}

	public ButtonGroup getjRdBtnGp() {
		return jRdBtnGp;
	}

	//method for buttons with actionlistener
	public void addActionListener(ActionListener actl) {
		jBtnForSignin.addActionListener(actl);
		jBtnClear.addActionListener(actl);
		jBtnClose.addActionListener(actl);
	}
	
}