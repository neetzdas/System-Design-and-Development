package model;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import view.*;

public class ForSigninModel  {
	private String usrNmForSignin;
	char[] pswdForSignin;

	public static String researcherNm;
	public static String researcherId;

	public ForSigninModel() {}

	public String getusrNmForSignin() {
		return usrNmForSignin;
	}
	public void setusrNmForSignin(String usrNmForSignin) {
		this.usrNmForSignin = usrNmForSignin;
	}
	public char[] getPswdForSignin() {
		return pswdForSignin;
	}
	public void setPswdForSignin(char[] psdForSignIn) {
		this.pswdForSignin = psdForSignIn;
	}

	//verifying the login of the researcher
	public boolean reseSigninVerify(ForSignInView fsiv)
	{
		boolean forSignin= false;
		ArrayList<ForMngResearcherModel> rese = null;
		String nameOfFile = "documents/researcherDetails".concat(".dat");
		try {
			FileInputStream fisOfSignIn = new FileInputStream(nameOfFile);
			ObjectInputStream oisOfSignIn = new ObjectInputStream(fisOfSignIn);
			Object objt = oisOfSignIn.readObject();
			rese = (ArrayList<ForMngResearcherModel>) objt;

			//loop used for checking the entered username and password with the saved ones in the files
			for (int i = 0; i < rese.size(); i++) {
				setusrNmForSignin(rese.get(i).getUsNmOfRe());
				setPswdForSignin(rese.get(i).getPsdOfRe());
				setReseNm(rese.get(i).getNmOfRe());
				setReseId(rese.get(i).getIdOfRe());
				if(forSignin=signInVerify(fsiv.getjTfdUsrnm().getText(),fsiv.getjPwdForSignin().getPassword()))
					break;
			}
			oisOfSignIn.close(); 
		}
		catch (Exception e) {}
		return forSignin;
	}

	//checking the username and password entered with the saved ones
	public boolean signInVerify(String usrNmForSignin, char[] psdForSignin) {
		String uesn= getusrNmForSignin();
		char[] pdsn = getPswdForSignin();
		if(uesn.equals(usrNmForSignin)) {
			if(Arrays.equals(pdsn,psdForSignin)) { //using array for password
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}

	//setting the name of the researcher who has logged in
	public void setReseNm(String reseNm) { 
		this.researcherNm = reseNm;
	}

	//getting the name of the researcher who has logged in
	public String getReseNm() {
		return this.researcherNm;
	}

	//setting the id of the researcher who has logged in
	public void setReseId(String reseId) { 
		this.researcherId = reseId;
	}

	//getting the name of the researcher who has logged in
	public String getReseId() {
		return this.researcherId;
	}
}