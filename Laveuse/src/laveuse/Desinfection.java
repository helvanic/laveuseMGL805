package laveuse;

public class Desinfection implements MachineState{

	WashingMachine washingMachine;
	int cycleTime = 45;
		
	public Desinfection(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}	
	
	public void startCycle(int cycleType) {
		//System.out.println("Cycle Desinfection already Started");
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

	@Override
	public void stopCycle() {
		//System.out.println("Impossible to stop the cycle if not already paused");		
	}

	@Override
	public void setTissueType(int tissueType) {
		//System.out.println("Impossible during a cycle");
	}

	@Override
	public void setCycleType(int cycleType) {
		//System.out.println("Impossible during a cycle");
	}

	@Override
	public void setWaterVolume(int volume) {
		//System.out.println("Impossible during a cycle");
	}

}
