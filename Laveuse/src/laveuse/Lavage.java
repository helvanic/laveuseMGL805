package laveuse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Lavage implements MachineState {

		
	WashingMachine washingMachine;
	
	
	public Lavage(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	public void startCycle(int cycleType) {}

	public void pauseCycle() {
		View.affichage.setText(FinalVariables.pause);
		washingMachine.cyclePaused = true;
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {}

	public void injectJavel() {}

	public void injectAdoucisseur() {}

	public void stopCycle() {}

	public void setTissueType(int tissueType) {}

	public void setCycleType(int cycleType) {}

	public void setWaterVolume(int volume) {}

}
