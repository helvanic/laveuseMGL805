package laveuse;

import laveuse.View;

public class Main {

	public static void main(String[] args) {
		
		ViewVariables theViewVariables  = new ViewVariables();
		theViewVariables.setVisible(true);
		
		View theView  = new View();
		theView.setVisible(true);
		
		WashingMachine washingMachine = new WashingMachine(theView, theViewVariables);
		}
}
