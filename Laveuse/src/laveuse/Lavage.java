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
		ViewVariables.apmValue.setText("0");
		ViewVariables.tpmValue.setText("0");
		washingMachine.waterSensor.timerRemplissage.stop();
		washingMachine.timerCycle.stop();
		washingMachine.temperatureSensor.timerTemperature.stop();
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {
		//System.out.println(FinalVariables.savonInjection);
		ViewVariables.savonInjecteValue.setText(FinalVariables.injected);
	}

	public void injectJavel() {
		//System.out.println(FinalVariables.javelInjection);
		ViewVariables.javelInjecteValue.setText(FinalVariables.injected);
	}

	public void injectAdoucisseur() {
		//System.out.println(FinalVariables.assouplisseurInjection);
		ViewVariables.adoucisseurInjecteValue.setText(FinalVariables.injected);
	}

	public void stopCycle() {}

	public void setTissueType(int tissueType) {}

	public void setCycleType(int cycleType) {}

	public void setWaterVolume(double volume) {}

}
