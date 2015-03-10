package laveuse;

public class TrempageEssorage implements MachineState {

	WashingMachine washingMachine;
	int cycleTime = 30;
	
	public TrempageEssorage(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}	
	
	public void startCycle(int cycleType) {
		//System.out.println("Cycle Trempage Essorage already Started");
	}

	public void pauseCycle() {
		//System.out.println("Pausing the machine");
		View.affichage.setText(FinalVariables.pause);
		washingMachine.cyclePaused = true;
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {
		//System.out.println("Impossible during this cycle");
	}

	public void injectJavel() {
		//System.out.println("Impossible during this cycle");
	}

	public void injectAdoucisseur() {
		//System.out.println("Impossible during this cycle");
	}

	public void stopCycle() {
		//System.out.println("Impossible to stop the cycle if not already paused");
	}

	public void setTissueType(int tissueType) {
		//System.out.println("Impossible during a cycle");
	}

	public void setCycleType(int cycleType) {
		//System.out.println("Impossible during a cycle");
	}

	public void setWaterVolume(int volume) {
		//System.out.println("Impossible during a cycle");
	}

}
