package laveuse;

public class Pause implements MachineState {

	WashingMachine washingMachine;
	
	public Pause(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	public void startCycle(int cycleType) {
		System.out.println("Restarting the cycle");
		if(washingMachine.cycleType==1){
			washingMachine.setMachineState(washingMachine.getLavage());
		}else if(washingMachine.cycleType==2){
			washingMachine.setMachineState(washingMachine.getTrempageEssorage());
		}else{
			washingMachine.setMachineState(washingMachine.getVeille());
		}
	}

	public void pauseCycle() {
		System.out.println("System already paused ! ");
	}

	public void injectSavon() {
		System.out.println("Impossible during this state");
	}

	public void injectJavel() {
		System.out.println("Impossible during this state");
	}

	public void injectAdoucisseur() {
		System.out.println("Impossible during this state");
	}

	public void stopCycle() {
		washingMachine.cycleType = 1;
		washingMachine.tissueType = 0;
		washingMachine.cyclePaused = false;
		washingMachine.javelInjected = false;
		washingMachine.AssouplisseurInjected = false;
		washingMachine.savonInjected = false;
		washingMachine.timeSinceStart = 0;
		washingMachine.WaterVolume = 0;
		System.out.println("Every single value set to 0 & false, stopping the machine now");
		washingMachine.setMachineState(washingMachine.getVeille());
	}

	public void setTissueType(int tissueType) {
		System.out.println("Impossible in this state");
	}

	public void setCycleType(int cycleType) {
		System.out.println("Impossible in this state");
	}

	public void setWaterVolume(int volume) {
		System.out.println("Impossible in this state");
	}

}
