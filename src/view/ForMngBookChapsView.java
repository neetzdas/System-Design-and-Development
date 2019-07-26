package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import controller.ForMngBookChapsController;
import model.ForMngBookChapsModel;

public class ForMngBookChapsView extends JPanel {
	ForMngBookChapsModel fmbkcmdl = new ForMngBookChapsModel();
	
	private JPanel jPnlForManagingInfo;
	ImageIcon iconForPanel3, iconOfSearch;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelBkChap, jLbelAuthr, jLbelEditorOfBk, jLbelYrOfPub, jLbelPlaceOfPubn, jLbelPublisher, jLbelPgNum,jLbelNoOfBks, jLbelRese,jLbelErrorMsg,jLbelForSearch;
	private Border matteBrdr;
	private JTextField jTxfdBkChap, jTxfdAuthr, jTxfdEditorOfBk, jTxfdYrOfPub, jTxfdPlaceOfPubn, jTxfdPublisher, jTxfdPgNum,jTxfdRese, jTxfdNoOfBks,jTfdForSearch;

	private JButton jBtnAdding, jBtnModifying, jBtnRemoving, jBtnClearing, jBtnLoaning, jBtnReturning;

	private JTable jTblForBkChapsView = new JTable();
	private JScrollPane jSpForBkChapsView = new JScrollPane();

	public ForMngBookChapsView() {
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

		jSpForBkChapsView = fmbkcmdl.layOutTbl();
		jSpForBkChapsView.setBounds(410, 45, 580, 423);
		jLblBackgrdImg.add(jSpForBkChapsView);
		jTblForBkChapsView = fmbkcmdl.getjTblForBkCharMdl();

		createMngBoChapView();
		ForMngBookChapsController fmBkCpCntrl = new ForMngBookChapsController(this);
		fmBkCpCntrl.infoSavingBtns();
		fmBkCpCntrl.dataSelection();
		setVisible(true);
	}

	public void createMngBoChapView() {
		jPnlForManagingInfo = new JPanel(null);
		jPnlForManagingInfo.setBounds(5, 5, 400, 465);
		jLblBackgrdImg.add(jPnlForManagingInfo);
		jPnlForManagingInfo.setBorder(matteBrdr);
		jPnlForManagingInfo.setOpaque(false);

		jLbelTtl1 = new JLabel("DETAILS OF BOOK CHAPTERS");
		jLbelTtl1.setBounds(410, 18, 250, 20);
		jLbelTtl1.setFont(new Font("Mistral",Font.PLAIN, 20));
		jLblBackgrdImg.add(jLbelTtl1);

		jLbelBkChap = new JLabel("Book Chapter Title");
		jLbelBkChap.setBounds(20, 10, 130, 25);
		jPnlForManagingInfo.add(jLbelBkChap);
		jLbelBkChap.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdBkChap = new JTextField();
		jTxfdBkChap.setBounds(185, 10, 200, 25);
		jPnlForManagingInfo.add(jTxfdBkChap);
		jTxfdBkChap.setOpaque(false);

		jLbelAuthr = new JLabel("Author/s");
		jLbelAuthr.setBounds(20, 45, 100, 25);
		jPnlForManagingInfo.add(jLbelAuthr);
		jLbelAuthr.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdAuthr = new JTextField();
		jTxfdAuthr.setBounds(185, 45, 200, 25);
		jPnlForManagingInfo.add(jTxfdAuthr);
		jTxfdAuthr.setOpaque(false);

		jLbelEditorOfBk = new JLabel("Editor/s");
		jLbelEditorOfBk.setBounds(20, 80, 100, 25);
		jPnlForManagingInfo.add(jLbelEditorOfBk);
		jLbelEditorOfBk.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdEditorOfBk = new JTextField();
		jTxfdEditorOfBk.setBounds(185, 80, 200, 25);
		jTxfdEditorOfBk.setOpaque(false);
		jPnlForManagingInfo.add(jTxfdEditorOfBk);

		jLbelYrOfPub = new JLabel("Year Of Publication");
		jLbelYrOfPub.setBounds(20, 115, 130, 25);
		jPnlForManagingInfo.add(jLbelYrOfPub);
		jLbelYrOfPub.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdYrOfPub = new JTextField();
		jTxfdYrOfPub.setBounds(185, 115, 200, 25);
		jPnlForManagingInfo.add(jTxfdYrOfPub);
		jTxfdYrOfPub.setOpaque(false);
		jTxfdYrOfPub.addKeyListener(numKey);

		jLbelPlaceOfPubn = new JLabel("Place Of Publication");
		jLbelPlaceOfPubn.setBounds(20, 150, 140, 25);
		jPnlForManagingInfo.add(jLbelPlaceOfPubn);
		jLbelPlaceOfPubn.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdPlaceOfPubn = new JTextField();
		jTxfdPlaceOfPubn.setBounds(185, 150, 200, 25);
		jPnlForManagingInfo.add(jTxfdPlaceOfPubn);
		jTxfdPlaceOfPubn.setOpaque(false);

		jLbelPublisher = new JLabel("Publisher");
		jLbelPublisher.setBounds(20, 185, 100, 25);
		jPnlForManagingInfo.add(jLbelPublisher);
		jLbelPublisher.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdPublisher = new JTextField();
		jTxfdPublisher.setBounds(185, 185, 200, 25);
		jPnlForManagingInfo.add(jTxfdPublisher);
		jTxfdPublisher.setOpaque(false);

		jLbelPgNum = new JLabel("Page No.");
		jLbelPgNum.setBounds(20, 220, 100, 25);
		jPnlForManagingInfo.add(jLbelPgNum);
		jLbelPgNum.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdPgNum = new JTextField();
		jTxfdPgNum.setBounds(185, 220, 200, 25);
		jPnlForManagingInfo.add(jTxfdPgNum);
		jTxfdPgNum.setOpaque(false);
		jTxfdPgNum.addKeyListener(numKey);

		jLbelNoOfBks = new JLabel("No. of Book Chapters");
		jLbelNoOfBks.setBounds(20, 255, 170, 25);
		jPnlForManagingInfo.add(jLbelNoOfBks);
		jLbelNoOfBks.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdNoOfBks = new JTextField();
		jTxfdNoOfBks.setBounds(235, 255, 100, 25);
		jPnlForManagingInfo.add(jTxfdNoOfBks);
		jTxfdNoOfBks.setOpaque(false);
		jTxfdNoOfBks.addKeyListener(numKey);
		jTxfdNoOfBks.setText("5");

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
		public void keyPressed(KeyEvent keEt) {}
		public void keyReleased(KeyEvent keEt) {
			DefaultTableModel defTblSearch = (DefaultTableModel)fmbkcmdl.getjTblForBkCharMdl().getModel();
			String keyWordForSearch = jTfdForSearch.getText();
			TableRowSorter<DefaultTableModel>  tblRowSort = new TableRowSorter<DefaultTableModel>(defTblSearch);
			fmbkcmdl.getjTblForBkCharMdl().setRowSorter(tblRowSort);
			tblRowSort.setRowFilter(RowFilter.regexFilter(keyWordForSearch));
		}
	};
	
	//method for setting the values of the rows from the table in the textfields after a row is selected
	public void setValuesInRow(String bkChpNm,String authNmOfbkChp,String editrOfBk, String publYear,String pubLtn,String publrOfBk,String pgOfbkChp, String noOfBooks, String nmOfRe) {
		jTxfdBkChap.setText(bkChpNm);
		jTxfdAuthr.setText(authNmOfbkChp);
		jTxfdEditorOfBk.setText(editrOfBk);
		jTxfdYrOfPub.setText(publYear);
		jTxfdPlaceOfPubn.setText(pubLtn);
		jTxfdPublisher.setText(publrOfBk);
		jTxfdPgNum.setText(pgOfbkChp);
		jTxfdNoOfBks.setText(noOfBooks);
		jTxfdRese.setText(nmOfRe);
	}

	//getter methods of the textfields and buttons and table
	public String getjTxfdBkChap() {
		return jTxfdBkChap.getText();
	}

	public String getjTxfdAuthr() {
		return jTxfdAuthr.getText();
	}

	public String getjTxfdEditorOfBk() {
		return jTxfdEditorOfBk.getText();
	}

	public String getjTxfdYrOfPub() {
		return jTxfdYrOfPub.getText();
	}

	public String getjTxfdPlaceOfPubn() {
		return jTxfdPlaceOfPubn.getText();
	}

	public String getjTxfdPublisher() {
		return jTxfdPublisher.getText();
	}

	public String getjTxfdPgNum() {
		return jTxfdPgNum.getText();
	}

	public JTextField getjTxfdNoOfBks() {
		return jTxfdNoOfBks;
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

	public JTable getjTblForBkChapsView() {
		return jTblForBkChapsView;
	}
}