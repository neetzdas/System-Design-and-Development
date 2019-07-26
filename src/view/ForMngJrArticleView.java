package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.ForMngJrArticleController;
import model.ForMngJrArticleModel;

public class ForMngJrArticleView extends JPanel {
	ForMngJrArticleModel fmjamdl = new ForMngJrArticleModel();

	private JPanel jPnlForManagingInfo;
	ImageIcon iconForPanel3, iconOfSearch;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelArTtl, jLbelAuthr, jLbelJrTtl, jLbelYrOfPub, jLbelVolNum, jLbelIssueNum, jLbelPgNum, jLbelNoOfAr, jLbelRese,jLbelErrorMsg,jLbelForSearch;
	private Border matteBrdr;
	private JTextField jTxfdArTtl, jTxfdAuthr, jTxfdJrTtl, jTxfdYrOfPub, jTxfdVolNum, jTxfdIssueNum, jTxfdPgNum, jTxfdRese, jTxfdNoOfAr,jTfdForSearch;

	private JButton jBtnAdding, jBtnModifying, jBtnRemoving, jBtnClearing, jBtnLoaning, jBtnReturning;

	private JTable jTblForJrArtView = new JTable();
	private JScrollPane jSpForJrArView = new JScrollPane();

	public ForMngJrArticleView() {
		setLayout(null);
		setBounds(0,0,1000, 475);

		matteBrdr = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE); //matte border for the panels

		iconForPanel3 = new ImageIcon("images/panel3.jpg");
		iconOfSearch = new ImageIcon("images/iconSearch.png");

		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 0, 1000, 475);
		add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);

		jLbelForSearch = new JLabel(iconOfSearch);
		jLbelForSearch.setBounds(745, 0, 45, 45);
		jLblBackgrdImg.add(jLbelForSearch);

		jTfdForSearch = new JTextField();
		jTfdForSearch.setBounds(786, 7, 200, 30);
		jTfdForSearch.setOpaque(false);
		jLblBackgrdImg.add(jTfdForSearch);
		jTfdForSearch.setForeground(Color.white);
		jTfdForSearch.addKeyListener(forSearch);

		jSpForJrArView = fmjamdl.layOutTbl();
		jSpForJrArView.setBounds(410, 45, 580, 423);
		jLblBackgrdImg.add(jSpForJrArView);
		jTblForJrArtView = fmjamdl.getjTblForJrArtMdl();

		createMngJrArticleView();
		ForMngJrArticleController fmjrCntrl = new ForMngJrArticleController(this);
		fmjrCntrl.infoSavingBtns();
		fmjrCntrl.dataSelection();
		setVisible(true);
	}

	public void createMngJrArticleView() {
		jPnlForManagingInfo = new JPanel(null);
		jPnlForManagingInfo.setBounds(5, 5, 400, 465);
		jLblBackgrdImg.add(jPnlForManagingInfo);
		jPnlForManagingInfo.setBorder(matteBrdr);
		jPnlForManagingInfo.setOpaque(false);

		jLbelTtl1 = new JLabel("DETAILS OF JOURNAL ARTICLES");
		jLbelTtl1.setBounds(410, 18, 220, 20);
		jLbelTtl1.setFont(new Font("Mistral",Font.PLAIN, 20));
		jLblBackgrdImg.add(jLbelTtl1);

		jLbelArTtl = new JLabel("Article Name");
		jLbelArTtl.setBounds(20, 10, 100, 25);
		jPnlForManagingInfo.add(jLbelArTtl);
		jLbelArTtl.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdArTtl = new JTextField();
		jTxfdArTtl.setBounds(185, 10, 200, 25);
		jPnlForManagingInfo.add(jTxfdArTtl);
		jTxfdArTtl.setOpaque(false);

		jLbelAuthr = new JLabel("Author/s");
		jLbelAuthr.setBounds(20, 45, 100, 25);
		jPnlForManagingInfo.add(jLbelAuthr);
		jLbelAuthr.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdAuthr = new JTextField();
		jTxfdAuthr.setBounds(185, 45, 200, 25);
		jPnlForManagingInfo.add(jTxfdAuthr);
		jTxfdAuthr.setOpaque(false);

		jLbelJrTtl = new JLabel("Journal Title");
		jLbelJrTtl.setBounds(20, 80, 100, 25);
		jPnlForManagingInfo.add(jLbelJrTtl);
		jLbelJrTtl.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdJrTtl = new JTextField();
		jTxfdJrTtl.setBounds(185, 80, 200, 25);
		jTxfdJrTtl.setOpaque(false);
		jPnlForManagingInfo.add(jTxfdJrTtl);

		jLbelYrOfPub = new JLabel("Year Of Publication");
		jLbelYrOfPub.setBounds(20, 115, 130, 25);
		jPnlForManagingInfo.add(jLbelYrOfPub);
		jLbelYrOfPub.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdYrOfPub = new JTextField();
		jTxfdYrOfPub.setBounds(185, 115, 200, 25);
		jPnlForManagingInfo.add(jTxfdYrOfPub);
		jTxfdYrOfPub.setOpaque(false);
		jTxfdYrOfPub.addKeyListener(numKey);

		jLbelVolNum = new JLabel("Volume No.");
		jLbelVolNum.setBounds(20, 150, 100, 25);
		jPnlForManagingInfo.add(jLbelVolNum);
		jLbelVolNum.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdVolNum = new JTextField();
		jTxfdVolNum.setBounds(185, 150, 200, 25);
		jPnlForManagingInfo.add(jTxfdVolNum);
		jTxfdVolNum.setOpaque(false);
		jTxfdVolNum.addKeyListener(numKey);

		jLbelIssueNum = new JLabel("Issue No.");
		jLbelIssueNum.setBounds(20, 185, 100, 25);
		jPnlForManagingInfo.add(jLbelIssueNum);
		jLbelIssueNum.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdIssueNum = new JTextField();
		jTxfdIssueNum.setBounds(185, 185, 200, 25);
		jPnlForManagingInfo.add(jTxfdIssueNum);
		jTxfdIssueNum.setOpaque(false);
		jTxfdIssueNum.addKeyListener(numKey);

		jLbelPgNum = new JLabel("Page No.");
		jLbelPgNum.setBounds(20, 220, 100, 25);
		jPnlForManagingInfo.add(jLbelPgNum);
		jLbelPgNum.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdPgNum = new JTextField();
		jTxfdPgNum.setBounds(185, 220, 200, 25);
		jPnlForManagingInfo.add(jTxfdPgNum);
		jTxfdPgNum.setOpaque(false);
		jTxfdPgNum.addKeyListener(numKey);

		jLbelNoOfAr = new JLabel("No. of Articles");
		jLbelNoOfAr.setBounds(20, 255, 150, 25);
		jPnlForManagingInfo.add(jLbelNoOfAr);
		jLbelNoOfAr.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdNoOfAr = new JTextField();
		jTxfdNoOfAr.setBounds(235, 255, 100, 25);
		jPnlForManagingInfo.add(jTxfdNoOfAr);
		jTxfdNoOfAr.setOpaque(false);
		jTxfdNoOfAr.addKeyListener(numKey);
		jTxfdNoOfAr.setText("5");

		jLbelRese = new JLabel("Loan Out To");
		jLbelRese.setBounds(20, 290, 150, 25);
		jPnlForManagingInfo.add(jLbelRese);
		jLbelRese.setFont(new Font("Mistral", Font.PLAIN, 20));
		jLbelRese.setVisible(false);

		jTxfdRese = new JTextField();
		jTxfdRese.setBounds(185, 290, 200, 25);
		jPnlForManagingInfo.add(jTxfdRese);
		jTxfdRese.setOpaque(false);
		jTxfdRese.setVisible(false);
		jTxfdRese.addKeyListener(numKey);

		jBtnAdding = new JButton("ADD");
		jBtnAdding.setBounds(30, 390, 100, 30);
		jBtnAdding.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnAdding);

		jBtnModifying = new JButton("MODIFY");
		jBtnModifying.setBounds(140, 390, 100, 30);
		jBtnModifying.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnModifying);
		jBtnModifying.setEnabled(false);

		jBtnRemoving = new JButton("REMOVE");
		jBtnRemoving.setBounds(250, 390, 100, 30);
		jBtnRemoving.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnRemoving);
		jBtnRemoving.setEnabled(false);

		jBtnLoaning = new JButton("LOAN OUT");
		jBtnLoaning.setBounds(30, 430, 100, 30);
		jBtnLoaning.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnLoaning);
		jBtnLoaning.setVisible(false);

		jBtnReturning = new JButton("RETURN");
		jBtnReturning.setBounds(140, 430, 100, 30);
		jBtnReturning.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnReturning);
		jBtnReturning.setVisible(false);

		jBtnClearing = new JButton("CLEAR");
		jBtnClearing.setBounds(250, 430, 100, 30);
		jBtnClearing.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnClearing);

		jLbelErrorMsg = new JLabel("");
		jLbelErrorMsg.setBounds(200, 293, 150, 25);
		jLbelErrorMsg.setForeground(Color.RED);
		jLbelErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jPnlForManagingInfo.add(jLbelErrorMsg);
	}

	//method for accepting only numeral values in the required textfields
	KeyListener numKey = new KeyListener() {
		public void keyTyped(java.awt.event.KeyEvent ket) {
			char chhhr = ket.getKeyChar();
			if(!(Character.isDigit(chhhr) 
					|| chhhr == KeyEvent.VK_SPACE 
					|| chhhr == KeyEvent.VK_MINUS 
					|| chhhr == KeyEvent.VK_COMMA
					|| chhhr == KeyEvent.VK_BACK_SPACE)) {
				ket.consume();
				jLbelErrorMsg.setText("Accepts Only Numbers");
			}
			else {
				jLbelErrorMsg.setText("");
			}
		}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
	};

	//method for search by sorting the rows of the table after entering keyword
	KeyListener forSearch = new KeyListener() {
		public void keyTyped(java.awt.event.KeyEvent ket) {}
		public void keyPressed(java.awt.event.KeyEvent keEt) {}
		public void keyReleased(java.awt.event.KeyEvent keEt) {
			DefaultTableModel defTblSearch = (DefaultTableModel)fmjamdl.getjTblForJrArtMdl().getModel();
			String keyWordForSearch = jTfdForSearch.getText();
			TableRowSorter<DefaultTableModel>  tblRowSort = new TableRowSorter<DefaultTableModel>(defTblSearch);
			fmjamdl.getjTblForJrArtMdl().setRowSorter(tblRowSort);
			tblRowSort.setRowFilter(RowFilter.regexFilter(keyWordForSearch));
		}
	};

	//method for setting the values of the rows from the table in the textfields after a row is selected
	public void setValuesInRow(String arNmOfJr,String authNmOfJr,String nmOfJr, String yrOfJr,String volOfJr,String issOfJr,String pgOfJr, String noOfJr, String nmOfRe) {
		jTxfdArTtl.setText(arNmOfJr);
		jTxfdAuthr.setText(authNmOfJr);
		jTxfdJrTtl.setText(nmOfJr);
		jTxfdYrOfPub.setText(yrOfJr);
		jTxfdVolNum.setText(volOfJr);
		jTxfdIssueNum.setText(issOfJr);
		jTxfdPgNum.setText(pgOfJr);
		jTxfdNoOfAr.setText(noOfJr);
		jTxfdRese.setText(nmOfRe);
	}

	//getter methods of the textfields and buttons and table
	public String getjTxfdArTtl() {
		return jTxfdArTtl.getText();
	}

	public String getjTxfdAuthr() {
		return jTxfdAuthr.getText();
	}

	public String getjTxfdJrTtl() {
		return jTxfdJrTtl.getText();
	}

	public String getjTxfdYrOfPub() {
		return jTxfdYrOfPub.getText();
	}

	public String getjTxfdVolNum() {
		return jTxfdVolNum.getText();
	}

	public String getjTxfdIssueNum() {
		return jTxfdIssueNum.getText();
	}

	public String getjTxfdPgNum() {
		return jTxfdPgNum.getText();
	}

	public JTextField getjTxfdNoOfAr() {
		return jTxfdNoOfAr;
	}

	public JLabel getjLbelRese() {
		return jLbelRese;
	}

	public JTextField getjTxfdRese() {
		return jTxfdRese;
	}

	public JButton getjBtnAdding() {
		return jBtnAdding;
	}

	public JButton getjBtnModifying() {
		return jBtnModifying;
	}

	public JButton getjBtnRemoving() {
		return jBtnRemoving;
	}

	public JButton getjBtnLoaning() {
		return jBtnLoaning;
	}

	public JButton getjBtnReturning() {
		return jBtnReturning;
	}

	public JButton getjBtnClearing() {
		return jBtnClearing;
	}

	public JTable getjTblForJrArtView() {
		return jTblForJrArtView;
	}	
}