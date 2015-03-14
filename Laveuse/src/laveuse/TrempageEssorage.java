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
		washingMachine.waterSensor.timerRemplissage.stop();
		washingMachine.temperatureSensor.timerTemperature.stop();
		washingMachine.cyclePaused = true;
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {if(washingMachine.savonClosed){washingMachine.savonClosed=true;}}

	public void injectJavel() {if(washingMachine.savonClosed){washingMachine.javelClosed=true;}}

	public void injectAdoucisseur() {if(washingMachine.savonClosed){washingMachine.assouplisseurClosed=true;}}

	public void stopCycle() {}

	public void setTissueType(int tissueType) {}

	public void setCycleType(int cycleType) {}

	public void setWaterVolume(double volume) {}

}
