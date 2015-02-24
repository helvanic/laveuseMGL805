package laveuse;

import laveuse.View;

public class TestWashingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		View theView  = new View();
		theView.setVisible(true);
		
		WashingMachine washingMachine = new WashingMachine(theView);
		
//		washingMachine.startCycle(washingMachine.cycleType);
//		System.out.println("-------------------------");
//		washingMachine.setCycleType(2);
//		washingMachine.startCycle(washingMachine.cycleType);
//		washingMachine.setTissueType(1);
//		washingMachine.startCycle(washingMachine.cycleType);
//		washingMachine.injectSavon();
//		washingMachine.startCycle(washingMachine.cycleType);
//		washingMachine.setCycleType(1);
//		System.out.println("-------------------------");
//		washingMachine.pauseCycle();
//		washingMachine.injectSavon();
//		washingMachine.startCycle(washingMachine.cycleType);
//		washingMachine.pauseCycle();
//		System.out.println("-------------------------");
//		washingMachine.stopCycle();
//		System.out.println("Cycle Type : "+washingMachine.cycleType);
//		System.out.println("Tissue Type : "+washingMachine.tissueType);
//		System.out.println("Paused  : "+washingMachine.cyclePaused);
//		System.out.println("Time Since Start : "+washingMachine.timeSinceStart);
	}

}
