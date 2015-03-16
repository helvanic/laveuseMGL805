package laveuse;

public class Pause implements MachineState {

	WashingMachine washingMachine;
	
	public Pause(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	public void startCycle(int cycleType) {
		//System.out.println("Restarting the cycle");
		if(washingMachine.cycleType==1){
			washingMachine.timerCycle.restart();
			washingMachine.setMachineState(washingMachine.getLavage());
		}else if(washingMachine.cycleType==2){
			washingMachine.timerCycle.restart();
			washingMachine.setMachineState(washingMachine.getTrempageEssorage());
		}else{
			washingMachine.setMachineState(washingMachine.getVeille());
		}
	}

	public void pauseCycle() {
		//System.out.println("System already paused ! ");
	}

	public void injectSavon() {
		//System.out.println("Impossible during this state");
	}

	public void injectJavel() {
		//System.out.println("Impossible during this state");
	}

	public void injectAdoucisseur() {
		//System.out.println("Impossible during this state");
	}

	public void stopCycle() {
		View.affichage.setText(FinalVariables.vidanging);
		washingMachine.cycleType = 0;
		washingMachine.tissueType = 0;
		washingMachine.WaterVolume = 0;
		ViewVariables.savonInjecteValue.setText(FinalVariables.waiting);
		ViewVariables.javelInjecteValue.setText(FinalVariables.waiting);
		ViewVariables.adoucisseurInjecteValue.setText(FinalVariables.waiting);
		
		if(!washingMachine.cyclePlus){
			ViewVariables.tissuValue.setText(FinalVariables.waitingForChoice);
			ViewVariables.cycleValue.setText(FinalVariables.waitingForChoice);
		}
		
		washingMachine.waterSensor.timerVidange.start();
		washingMachine.temperatureSensor.timerCoolTemperature.start();
		washingMachine.setMachineState(washingMachine.getVeille());
	}

	public void setTissueType(int tissueType) {
		//System.out.println("Impossible in this state");
	}

	public void setCycleType(int cycleType) {
		//System.out.println("Impossible in this state");
	}

	public void setWaterVolume(double volume) {
		//System.out.println("Impossible in this state");
	}

}
