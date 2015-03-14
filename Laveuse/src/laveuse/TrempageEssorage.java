package laveuse;

public class TrempageEssorage implements MachineState {

	WashingMachine washingMachine;
	int cycleTime = 30;
	
	public TrempageEssorage(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}	
	
	public void startCycle(int cycleType) {}

	public void pauseCycle() {
		View.affichage.setText(FinalVariables.pause);
		washingMachine.timerCycle.stop();
		washingMachine.timerRemplissage.stop();
		washingMachine.timerTemperature.stop();
		washingMachine.cyclePaused = true;
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {}

	public void injectJavel() {}

	public void injectAdoucisseur() {}

	public void stopCycle() {}

	public void setTissueType(int tissueType) {}

	public void setCycleType(int cycleType) {}

	public void setWaterVolume(double volume) {}

}
