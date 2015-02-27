package laveuse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class WashingMachine {

	MachineState veille;
	MachineState pause;
	MachineState lavage;
	MachineState trempageEssorage;
	MachineState desinfection;
	
	MachineState machineState;
	
	int WaterVolume = 0;
	int cycleType = 1;
	int tissueType = 0;
	int timeSinceStart = 0;
	boolean cyclePaused = false;
	boolean savonInjected = false;
	boolean javelInjected = false;
	boolean AssouplisseurInjected = false;
	
	
	private View theView;
	
	public WashingMachine(View newView){
		
		this.theView = newView;
		this.theView.addListeners(
				new cotonListener(),
				new rugueuxListener(),
				new syntheticListener(),
				new desinfectionListener(),
				new trempageEssorageListener(),
				new waterLevelListener(),
				new departListener(),
				new arretListener()
				);
		veille = new Veille(this);
		pause = new Pause(this);
		lavage = new Lavage(this);
		trempageEssorage = new TrempageEssorage(this);
		desinfection = new Desinfection(this);
		
		machineState = veille;
		
	}
	
	/*           State methods                  */
	void setMachineState(MachineState newState){
		machineState = newState;
	}
	
	public void setTimeSinceStart(int newTimeSinceStart){
		timeSinceStart = newTimeSinceStart;
	}
	
	public void startCycle(int cycleType){
		machineState.startCycle(cycleType);
	};
	public void pauseCycle(){
		machineState.pauseCycle();
	};
	public void injectSavon(){
		machineState.injectSavon();
	};
	public void injectJavel(){
		machineState.injectJavel();
	};
	public void injectAdoucisseur(){
		machineState.injectAdoucisseur();
	};
	public void stopCycle(){
		machineState.stopCycle();
	};
	public void setTissueType(int tissueType){
		machineState.setTissueType(tissueType);
	};
	public void setCycleType(int cycleType){
		machineState.setCycleType(cycleType);
	};
	public void setWaterVolume(int volume){
		machineState.setWaterVolume(volume);
	};
	
	public int convertWaterLevelFromUI(){
		return 1;
	}
	
	public int convertWaterLevelFromSensor(){
		return 1;
	}
	
	public int convertTemperatureFromSensor(){
		return 1;
	}
	
	public MachineState getVeille(){return veille;}
	public MachineState getPause(){return pause;}
	public MachineState getLavage(){return lavage;}
	public MachineState getTrempageEssorage(){return trempageEssorage;}
	public MachineState getDesinfection(){return desinfection;}
	
	/*          View Listeners Methods     */
	
	class cotonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setTissueType(1);
		}	
	}

	class syntheticListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setTissueType(2);
		}	
	}
	
	class rugueuxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setTissueType(3);
		}	
	}
	
	class desinfectionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setCycleType(3);
		}
		
	}
	
	class trempageEssorageListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			switch(cycleType){
			case 1:
				setCycleType(2);
				break;
			case 2:
				setCycleType(1);
				break;
			case 3:
				setCycleType(2);
				break;
			default :
				break;
			}
			//Penser à rajouter le mode désinfection ! C'est bon ! 
		}	
	}
	
	class waterLevelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			//Rien pour l'instant
			JComboBox cb = (JComboBox) arg0.getSource();
			int chosenLevel = Integer.parseInt((String) cb.getSelectedItem());
			System.out.println(chosenLevel);
			setWaterVolume(chosenLevel);
		}	
	}
	
	class departListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			cyclePaused = false;
			startCycle(cycleType);
		}	
	}
	
	class arretListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(cyclePaused){
				stopCycle();
			}else{
				pauseCycle();
			}
		}	
	}
	
	
	
}
