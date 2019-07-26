package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import controller.ForMngResearcherController;
import model.ForMngResearcherModel;

public class ForMngResearcherView extends JPanel {
	ForMngResearcherModel fmgrmdl = new ForMngResearcherModel();

	private JPanel jPnlForManagingInfo;
	ImageIcon iconForPanel3, iconOfSearch;
	private JLabel jLblBackgrdImg, jLbelTtl1, jLbelReIdNo, jLbelReFullNm, jLbelReLtn, jLbelReGen, jLbelRePhn, jLbelReEmAds, jLbelReUsrNm,jLbelRePwd,jLbelErrorMsg,jLbelErrorMsg2, jLbelForSearch;
	private Border matteBrdr;
	private JTextField jTxfdReIdNo, jTxfdReFullNm, jTxfdReLtn, jTxfdRePhn, jTxfdReEmAds, jTxfdReUsrNm,jTxfdRePwd,jTfdForSearch;

	public JRadioButton jRdBtnForMale = new JRadioButton("Male");
	public JRadioButton jRdBtnForFemale = new JRadioButton("Female");
	public JRadioButton jRdBtnForOthers = new JRadioButton("Others");
	ButtonGroup jRdBtnGp = new ButtonGroup();

	private JButton jBtnAdding, jBtnModifying, jBtnRemoving, jBtnClearing;

	private JTable jTblForReView = new JTable();
	private JScrollPane jSpForReView = new JScrollPane();

	public ForMngResearcherView() {
		setLayout(null);
		setBounds(0,0,1000, 475);

		matteBrdr = BorderFactory.createMatteBorder(1,1,1,1,Color.WHITE); //matte border for the panels

		iconOfSearch = new ImageIcon("images/iconSearch.png");
		iconForPanel3 = new ImageIcon("images/panel3.jpg");
		
		jLblBackgrdImg = new JLabel(iconForPanel3);
		jLblBackgrdImg.setBounds(0, 0, 1000, 475);
		add(jLblBackgrdImg);
		jLblBackgrdImg.setBorder(matteBrdr);
		
		jLbelForSearch = new JLabel(iconOfSearch);
		jLbelForSearch.setBounds(775, 0, 45, 45);
		jLblBackgrdImg.add(jLbelForSearch);
		
		jTfdForSearch = new JTextField();
		jTfdForSearch.setBounds(816, 5, 170, 30);
		jTfdForSearch.setOpaque(false);
		jLblBackgrdImg.add(jTfdForSearch);
		jTfdForSearch.setForeground(Color.white);
		jTfdForSearch.addKeyListener(forSearch);

		jSpForReView = fmgrmdl.layOutTbl();
		jSpForReView.setBounds(410, 45, 580, 423);
		jLblBackgrdImg.add(jSpForReView);
		jTblForReView = fmgrmdl.getjTblForReMdl();

		createMngReseView();
		ForMngResearcherController fmgrct = new ForMngResearcherController(this);
		fmgrct.infoSavingBtns();
		fmgrct.dataSelection();
		setVisible(true);
	}

	public void createMngReseView() {
		jPnlForManagingInfo = new JPanel(null);
		jPnlForManagingInfo.setBounds(5, 5, 400, 465);
		jLblBackgrdImg.add(jPnlForManagingInfo);
		jPnlForManagingInfo.setBorder(matteBrdr);
		jPnlForManagingInfo.setOpaque(false);

		jLbelTtl1 = new JLabel("DETAILS OF RESEARCHERS");
		jLbelTtl1.setBounds(410, 15, 200, 20);
		jLbelTtl1.setFont(new Font("Mistral",Font.PLAIN, 22));
		jLblBackgrdImg.add(jLbelTtl1);

		jLbelReIdNo = new JLabel("Researcher Id");
		jLbelReIdNo.setBounds(20, 10, 100, 25);
		jPnlForManagingInfo.add(jLbelReIdNo);
		jLbelReIdNo.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdReIdNo = new JTextField();
		jTxfdReIdNo.setBounds(155, 10, 200, 25);
		jPnlForManagingInfo.add(jTxfdReIdNo);
		jTxfdReIdNo.setOpaque(false);
		jTxfdReIdNo.setEditable(false);
		try {
			if(fmgrmdl.getReseArrayList()!=null) {
				int lastRow = jTblForReView.getRowCount()-1;
				String researcherId = (String)jTblForReView.getValueAt(lastRow, 0);
				int reId = Integer.valueOf(researcherId)+1;
				jTxfdReIdNo.setText((Integer.toString(reId)));
			}
			else {
				jTxfdReIdNo.setText(Integer.toString(100));
			}
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			jTxfdReIdNo.setText(Integer.toString(100));
		}

		jLbelReFullNm = new JLabel("Full Name");
		jLbelReFullNm.setBounds(20, 55, 100, 25);
		jPnlForManagingInfo.add(jLbelReFullNm);
		jLbelReFullNm.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdReFullNm = new JTextField();
		jTxfdReFullNm.setBounds(155, 55, 200, 25);
		jPnlForManagingInfo.add(jTxfdReFullNm);
		jTxfdReFullNm.setOpaque(false);

		jLbelReGen = new JLabel("Gender");
		jLbelReGen.setBounds(20, 100, 100, 25);
		jPnlForManagingInfo.add(jLbelReGen);
		jLbelReGen.setFont(new Font("Mistral", Font.PLAIN, 20));

		jRdBtnForMale.setFont(new Font("Mistral", Font.PLAIN, 20));
		jRdBtnForMale.setBounds(155, 90, 80, 50);
		jRdBtnForMale.setOpaque(false);
		jRdBtnGp.add(jRdBtnForMale);
		jPnlForManagingInfo.add(jRdBtnForMale);
		jRdBtnForMale.setActionCommand("Male");

		jRdBtnForFemale.setFont(new Font("Mistral", Font.PLAIN, 20));
		jRdBtnForFemale.setBounds(220, 90, 80, 50);
		jRdBtnForFemale.setOpaque(false);
		jRdBtnGp.add(jRdBtnForFemale);
		jPnlForManagingInfo.add(jRdBtnForFemale);
		jRdBtnForFemale.setActionCommand("Female");

		jRdBtnForOthers.setFont(new Font("Mistral", Font.PLAIN, 20));
		jRdBtnForOthers.setBounds(305, 90, 130, 50);
		jRdBtnForOthers.setOpaque(false);
		jRdBtnGp.add(jRdBtnForOthers);
		jPnlForManagingInfo.add(jRdBtnForOthers);
		jRdBtnForOthers.setActionCommand("Others");

		jLbelReLtn = new JLabel("Address");
		jLbelReLtn.setBounds(20, 145, 100, 25);
		jPnlForManagingInfo.add(jLbelReLtn);
		jLbelReLtn.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdReLtn = new JTextField();
		jTxfdReLtn.setBounds(155, 145, 200, 25);
		jPnlForManagingInfo.add(jTxfdReLtn);
		jTxfdReLtn.setOpaque(false);

		jLbelRePhn = new JLabel("Phone No.");
		jLbelRePhn.setBounds(20, 190, 100, 25);
		jPnlForManagingInfo.add(jLbelRePhn);
		jLbelRePhn.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdRePhn = new JTextField();
		jTxfdRePhn.setBounds(155, 190, 200, 25);
		jPnlForManagingInfo.add(jTxfdRePhn);
		jTxfdRePhn.setOpaque(false);
		jTxfdRePhn.addKeyListener(numKey);

		jLbelReEmAds = new JLabel("Email");
		jLbelReEmAds.setBounds(20, 235, 100, 25);
		jPnlForManagingInfo.add(jLbelReEmAds);
		jLbelReEmAds.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdReEmAds = new JTextField();
		jTxfdReEmAds.setBounds(155, 235, 200, 25);
		jPnlForManagingInfo.add(jTxfdReEmAds);
		jTxfdReEmAds.setOpaque(false);

		jLbelReUsrNm = new JLabel("Username");
		jLbelReUsrNm.setBounds(20, 280, 100, 25);
		jPnlForManagingInfo.add(jLbelReUsrNm);
		jLbelReUsrNm.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdReUsrNm = new JTextField();
		jTxfdReUsrNm.setBounds(155, 280, 200, 25);
		jPnlForManagingInfo.add(jTxfdReUsrNm);
		jTxfdReUsrNm.setOpaque(false);

		jLbelRePwd = new JLabel("Password");
		jLbelRePwd.setBounds(20, 325, 100, 25);
		jPnlForManagingInfo.add(jLbelRePwd);
		jLbelRePwd.setFont(new Font("Mistral", Font.PLAIN, 20));

		jTxfdRePwd = new JTextField();
		jTxfdRePwd.setBounds(155, 325, 200, 25);
		jPnlForManagingInfo.add(jTxfdRePwd);
		jTxfdRePwd.setOpaque(false);

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

		jBtnClearing = new JButton("CLEAR");
		jBtnClearing.setBounds(140, 430, 100, 30);
		jBtnClearing.setFont(new Font("Mistral", Font.BOLD, 14));
		jPnlForManagingInfo.add(jBtnClearing);

		jLbelErrorMsg = new JLabel("");
		jLbelErrorMsg.setBounds(175, 215, 150, 25);
		jLbelErrorMsg.setForeground(Color.RED);
		jLbelErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jPnlForManagingInfo.add(jLbelErrorMsg);
		
		jLbelErrorMsg2 = new JLabel("");
		jLbelErrorMsg2.setBounds(635, 10, 150, 25);
		jLbelErrorMsg2.setForeground(Color.RED);
		jLbelErrorMsg2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLblBackgrdImg.add(jLbelErrorMsg2);
	}

	//method for accepting only numeral values in the required textfields
	KeyListener numKey = new KeyListener() {
		public void keyTyped(java.awt.event.KeyEvent ket) {
			char chhhr = ket.getKeyChar();
			if(!(Character.isDigit(chhhr) || chhhr == KeyEvent.VK_BACK_SPACE)) {
				ket.consume();
				jLbelErrorMsg.setText("Accepts Only Numbers");
			}
			else {
				jLbelErrorMsg.setText("");
			}
		}
		public void keyPressed(KeyEvent ket) {}
		public void keyReleased(KeyEvent ket) {}
	};

	//method for search by sorting the rows of the table after entering keyword(researcher Id)
	KeyListener forSearch = new KeyListener() {
			public void keyTyped(java.awt.event.KeyEvent ket) {
				char chhhr = ket.getKeyChar();
				if(!(Character.isDigit(chhhr) || chhhr == KeyEvent.VK_BACK_SPACE)) {
					ket.consume();
					jLbelErrorMsg2.setText("Enter Researcher Id only");
				}
				else {
					jLbelErrorMsg2.setText("");
				}
			}
		public void keyPressed(KeyEvent keEt) {}
		public void keyReleased(KeyEvent keEt) {
			DefaultTableModel defTblSearch = (DefaultTableModel)fmgrmdl.getjTblForReMdl().getModel();
			String keyWordForSearch = jTfdForSearch.getText();
			TableRowSorter<DefaultTableModel>  tblRowSort = new TableRowSorter<DefaultTableModel>(defTblSearch);
			fmgrmdl.getjTblForReMdl().setRowSorter(tblRowSort);
			tblRowSort.setRowFilter(RowFilter.regexFilter(keyWordForSearch));
		}
	};

	//method for setting the values of the rows from the table in the textfields after a row is selected
	public void setValuesInRow(String idOfRe, String nmOfRe,String adrOfRe, String phnOfRe, String emlOfRe, String usNmOfRe, String pswdOfRe ) {
		jTxfdReIdNo.setText(idOfRe);
		jTxfdReFullNm.setText(nmOfRe);
		jTxfdReLtn.setText(adrOfRe);
		jTxfdRePhn.setText(phnOfRe);
		jTxfdReEmAds.setText(emlOfRe);
		jTxfdReUsrNm.setText(usNmOfRe);
		jTxfdRePwd.setText(pswdOfRe);
	}

	//getter methods of the textfields and buttons and table
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

	public JTable getjTblForReView() {
		return jTblForReView;
	}

	public String getjTxfdReIdNo() {
		return jTxfdReIdNo.getText();
	}

	public String getjTxfdReFullNm() {
		return jTxfdReFullNm.getText();
	}

	public String getjTxfdReLtn() {
		return jTxfdReLtn.getText();
	}

	public String getjTxfdRePhn() {
		return jTxfdRePhn.getText();
	}

	public String getjTxfdReEmAds() {
		return jTxfdReEmAds.getText();
	}

	public ButtonGroup getjRdBtnGp() {
		return jRdBtnGp;
	}

	public String getjTxfdReUsrNm() {
		return jTxfdReUsrNm.getText();
	}

	public JTextField getjTxfdRePwd() {
		return jTxfdRePwd;
	}
}