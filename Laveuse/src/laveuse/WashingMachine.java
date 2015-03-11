package laveuse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.Timer;

public class WashingMachine {

	MachineState veille;
	MachineState pause;
	MachineState lavage;
	MachineState trempageEssorage;
	
	MachineState machineState;
	
	int WaterVolume = 0;
	int cycleType = 0;
	int tissueType = 0;
	int tempMax;
	int tempMin;
	int cadenceLavage;
	int timeLav;
	int timeEss;
	int cycleTime;
	int rotationEss;
	boolean cyclePaused = false;
	boolean savonClosed = true;
	boolean javelClosed = false;
	boolean assouplisseurClosed = false;
	
	private int seconde = 60;
	final Timer timer1= new Timer(1000,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			seconde--;
			if(seconde==0)
			{
				seconde=60;
				cycleTime--;
				View.temps.setText("("+cycleTime+"min)");
				if (cycleTime==0){
					//vidange et remise en veille et arrêt du timer
				}
			}
		}
	});
	
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
		
		machineState = veille;
		
	}
	
	/*           State methods                  */
	void setMachineState(MachineState newState){
		machineState = newState;
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
	
	public MachineState getVeille(){return veille;}
	public MachineState getPause(){return pause;}
	public MachineState getLavage(){return lavage;}
	public MachineState getTrempageEssorage(){return trempageEssorage;}
	
	/*          View Listeners Methods     */
	
	class cotonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==1){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==1){
				setTissueType(0);
			}else if (cycleType==2 && tissueType!=1){
				setTissueType(1);
			} else {
				setCycleType(1);
				setTissueType(1);
			}
			System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}

	class syntheticListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==2){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==2){
				setTissueType(0);
			}else if (cycleType==2 && tissueType!=2){
				setTissueType(2);
			}else{
				setCycleType(1);
				setTissueType(2);
			}
			System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}
	
	class rugueuxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==3){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==3){
				setTissueType(0);
			}else if (cycleType==2 && tissueType!=3){
				setTissueType(3);
			}else{
				setCycleType(1);
				setTissueType(3);
			}
			System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}
	
	class desinfectionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==4){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==4){
				setTissueType(0);
			}else if (cycleType==2 && tissueType!=4){
				setTissueType(4);
			}else{
				setCycleType(1);
				setTissueType(4);
			}
			System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}
		
	}
	
	class trempageEssorageListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			/* gérer l'indépendance du bouton */
			if (cycleType==2 && tissueType == 0){
				setCycleType(0);
			}else if (cycleType==2 && tissueType!=0){
				setCycleType(1);
			}else{
				setCycleType(2);
			}
			System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
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
