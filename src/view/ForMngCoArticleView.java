package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import controller.ForMngCoArticleController;
import model.ForMngCoArticleModel;

public class ForMngCoArticleView extends JPanel {
	ForMngCoArticleModel fmcamdl = new ForMngCoArticleModel();
	
	private JPanel jPnlForManagingInfo;
	ImageIcon iconForPanel3, iconOfSearch;;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelArTtl, jLbelAuthr, jLbelEditorOfCoPd, jLbelYrOfPub, jLbelCoLoctn, jLbelPgNum, jLbelNoOfAr, jLbelRese,jLbelErrorMsg, jLbelForSearch;
	private Border matteBrdr;
	private JTextField jTxfdArTtl, jTxfdAuthr, jTxfdEditorOfCoPd, jTxfdYrOfPub, jTxfdCoLoctn, jTxfdIssueNum, jTxfdPgNum,jTxfdRese, jTxfdNoOfAr, jTfdForSearch;
	
	private JButton jBtnAdding, jBtnModifying, jBtnRemoving, jBtnClearing,jBtnLoaning, jBtnReturning;
	
	private JTable jTblForConArtView = new JTable();
	private JScrollPane jSpForConArView = new JScrollPane();
	
	public ForMngCoArticleView() {
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
		
		jSpForConArView = fmcamdl.layOutTbl();
		jSpForConArView.setBounds(410, 45, 580, 423);
		jLblBackgrdImg.add(jSpForConArView);
		jTblForConArtView = fmcamdl.getjTblForConArtMdl();
		
		createMngConfArticleView();
		ForMngCoArticleController fmCfArtCntrl = new ForMngCoArticleController(this);
		fmCfArtCntrl.infoSavingBtns();
		fmCfArtCntrl.dataSelection();
		setVisible(true);
	}
	
	public void createMngConfArticleView() {
		jPnlForManagingInfo = new JPanel(null);
		jPnlForManagingInfo.setBounds(5, 5, 400, 465);
		jLblBackgrdImg.add(jPnlForManagingInfo);
		jPnlForManagingInfo.setBorder(matteBrdr);
		jPnlForManagingInfo.setOpaque(false);
		
		jLbelTtl1 = new JLabel("DETAILS OF CONFERENCE ARTICLES");
		jLbelTtl1.setBounds(410, 18, 250, 20);
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
		jLbelAuthr.setBounds(20, 55, 100, 25);
		jPnlForManagingInfo.add(jLbelAuthr);
		jLbelAuthr.setFont(new Font("Mistral", Font.PLAIN, 20));
		
		jTxfdAuthr = new JTextField();
		jTxfdAuthr.setBounds(185, 55, 200, 25);
		jPnlForManagingInfo.add(jTxfdAuthr);
		jTxfdAuthr.setOpaque(false);
		
		jLbelEditorOfCoPd = new JLabel("Editor/s");
		jLbelEditorOfCoPd.setBounds(20, 100, 100, 25);
		jPnlForManagingInfo.add(jLbelEditorOfCoPd);
		jLbelEditorOfCoPd.setFont(new Font("Mistral", Font.PLAIN, 20));
		
		jTxfdEditorOfCoPd = new JTextField();
		jTxfdEditorOfCoPd.setBounds(185, 100, 200, 25);
		jTxfdEditorOfCoPd.setOpaque(false);
		jPnlForManagingInfo.add(jTxfdEditorOfCoPd);
		
		jLbelYrOfPub = new JLabel("Year Of Publication");
		jLbelYrOfPub.setBounds(20, 145, 130, 25);
		jPnlForManagingInfo.add(jLbelYrOfPub);
		jLbelYrOfPub.setFont(new Font("Mistral", Font.PLAIN, 20));
		
		jTxfdYrOfPub = new JTextField();
		jTxfdYrOfPub.setBounds(185, 145, 200, 25);
		jPnlForManagingInfo.add(jTxfdYrOfPub);
		jTxfdYrOfPub.setOpaque(false);
		jTxfdYrOfPub.addKeyListener(numKey);
		
		jLbelCoLoctn = new JLabel("Location Of Conference");
		jLbelCoLoctn.setBounds(20, 190, 155, 25);
		jPnlForManagingInfo.add(jLbelCoLoctn);
		jLbelCoLoctn.setFont(new Font("Mistral", Font.PLAIN, 20));
		
		jTxfdCoLoctn = new JTextField();
		jTxfdCoLoctn.setBounds(185, 190, 200, 25);
		jPnlForManagingInfo.add(jTxfdCoLoctn);
		jTxfdCoLoctn.setOpaque(false);
		
		jLbelPgNum = new JLabel("Page No.");
		jLbelPgNum.setBounds(20, 235, 100, 25);
		jPnlForManagingInfo.add(jLbelPgNum);
		jLbelPgNum.setFont(new Font("Mistral", Font.PLAIN, 20));
		
		jTxfdPgNum = new JTextField();
		jTxfdPgNum.setBounds(185, 235, 200, 25);
		jPnlForManagingInfo.add(jTxfdPgNum);
		jTxfdPgNum.setOpaque(false);
		jTxfdPgNum.addKeyListener(numKey);
		
		jLbelNoOfAr = new JLabel("No. of Articles");
		jLbelNoOfAr.setBounds(20, 280, 150, 25);
		jPnlForManagingInfo.add(jLbelNoOfAr);
		jLbelNoOfAr.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdNoOfAr = new JTextField();
		jTxfdNoOfAr.setBounds(235, 280, 100, 25);
		jPnlForManagingInfo.add(jTxfdNoOfAr);
		jTxfdNoOfAr.setOpaque(false);
		jTxfdNoOfAr.addKeyListener(numKey);
		jTxfdNoOfAr.setText("5");

		jLbelRese = new JLabel("Loan Out To");
		jLbelRese.setBounds(20, 325, 150, 25);
		jPnlForManagingInfo.add(jLbelRese);
		jLbelRese.setFont(new Font("Mistral", Font.PLAIN, 20));
		jLbelRese.setVisible(false);

		jTxfdRese = new JTextField();
		jTxfdRese.setBounds(185, 325, 200, 25);
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
		jLbelErrorMsg.setBounds(200, 355, 150, 25);
		jLbelErrorMsg.setForeground(Color.RED);
		jLbelErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		public void keyPressed(KeyEvent keEt) {}
		public void keyReleased(KeyEvent keEt) {
			DefaultTableModel defTblSearch = (DefaultTableModel)fmcamdl.getjTblForConArtMdl().getModel();
			String keyWordForSearch = jTfdForSearch.getText();
			TableRowSorter<DefaultTableModel>  tblRowSort = new TableRowSorter<DefaultTableModel>(defTblSearch);
			fmcamdl.getjTblForConArtMdl().setRowSorter(tblRowSort);
			tblRowSort.setRowFilter(RowFilter.regexFilter(keyWordForSearch));
		}
	};
	
	//method for setting the values of the rows from the table in the textfields after a row is selected
	public void setValuesInRow(String arNmOfCon,String authNmOfCon,String editOfCon, String yrOfCon,String loctOfCon,String pgOfCon, String noOfCon, String nmOfRe) {
		jTxfdArTtl.setText(arNmOfCon);
		jTxfdAuthr.setText(authNmOfCon);
		jTxfdEditorOfCoPd.setText(editOfCon);
		jTxfdYrOfPub.setText(yrOfCon);
		jTxfdCoLoctn.setText(loctOfCon);
		jTxfdPgNum.setText(pgOfCon);
		jTxfdNoOfAr.setText(noOfCon);
		jTxfdRese.setText(nmOfRe);
	}
	
	//getter methods of the textfields and buttons and table
	public String getjTxfdArTtl() {
		return jTxfdArTtl.getText();
	}

	public String getjTxfdAuthr() {
		return jTxfdAuthr.getText();
	}

	public String getjTxfdEditorOfCoPd() {
		return jTxfdEditorOfCoPd.getText();
	}

	public String getjTxfdYrOfPub() {
		return jTxfdYrOfPub.getText();
	}

	public String getjTxfdCoLoctn() {
		return jTxfdCoLoctn.getText();
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

	public JButton getjBtnClearing() {
		return jBtnClearing;
	}

	public JButton getjBtnLoaning() {
		return jBtnLoaning;
	}

	public JButton getjBtnReturning() {
		return jBtnReturning;
	}

	public JTable getjTblForConArtView() {
		return jTblForConArtView;
	}
}