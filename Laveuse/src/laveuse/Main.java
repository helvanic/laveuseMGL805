package laveuse;

import laveuse.View;

public class Main {

	public static void main(String[] args) {
		
		View theView  = new View();
		theView.setVisible(true);
		
		ViewVariables theViewVariables  = new ViewVariables();
		theViewVariables.setVisible(true);
		
		WashingMachine washingMachine = new WashingMachine(theView, theViewVariables);
		}
}
