package main;

import controller.*;
import model.*;
import view.*;

public class PrimeProcedure {
	public static void main(String[] args) {
		ForSignInView fsiv = new ForSignInView();
		ForSigninController fsic = new ForSigninController(fsiv, new ForSigninModel());
		fsic.signInControl();
		fsiv.pack();	
	}
}
