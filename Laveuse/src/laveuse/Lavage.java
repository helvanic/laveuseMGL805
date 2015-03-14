package laveuse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Lavage implements MachineState {

		
	WashingMachine washingMachine;
	
	public Lavage(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	public void startCycle(int cycleType) {
		//washingMachine.timerCycle.restart();
	}

	public void pauseCycle() {
		View.affichage.setText(FinalVariables.pause);
		washingMachine.cyclePaused = true;
		washingMachine.timerRemplissage.stop();
		washingMachine.timerCycle.stop();
		washingMachine.timerTemperature.stop();
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {
		System.out.println(FinalVariables.savonInjection);
	}

	public void injectJavel() {
		System.out.println(FinalVariables.javelInjection);
	}

	public void injectAdoucisseur() {
		System.out.println(FinalVariables.assouplisseurInjection);
	}

	public void stopCycle() {
		//arrêt de ce que la machine est en train de faire à rajouter
	}

	public void setTissueType(int tissueType) {}

	public void setCycleType(int cycleType) {}

	public void setWaterVolume(double volume) {}

}
