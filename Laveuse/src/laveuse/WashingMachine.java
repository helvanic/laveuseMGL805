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

	WaterSensor waterSensor = new WaterSensor(this);
	TemperatureSensor temperatureSensor = new TemperatureSensor(this);
	
	/*Choix préalable des values*/
	String cycleTypeName = "";
	double WaterVolume = 1.0;
	int cycleType = 0;
	int tissueType = 0;
	int tempMax = 90;
	int tempMin = 20;
	int cadenceLavage = 0;
	int rotationEss = 0;
	int timeLav = 0;
	int timeEss = 0;
	
	/*Current values*/
	int currentWaterVolume = 0;
	int cycleTime = 0;
	int currentTemp = 0;
	int currentCadLavage = 0;
	int currentRotEss = 0;
	
	/*gestion du fonctionnement*/
	boolean cyclePlus = false;
	boolean cyclePaused = false;
	boolean savonClosed = true;
	boolean javelClosed = true;
	boolean assouplisseurClosed = true;
	
	


	final Timer timerCycle= new Timer(1000,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			/*seconde--;
			if(seconde==0)
			{
				seconde=60;*/
			if(View.voyantLumineux.getText().equals("Voyant")){
				View.voyantLumineux.setText("En cours");
			}else{
				cycleTime-=1;
			}
			View.temps.setText("("+cycleTime+"min)");
			if (cycleTime<=5 && assouplisseurClosed){
				injectAdoucisseur();
				assouplisseurClosed = false;
			} else if (cycleTime<=0){
				arretMachine();
			}
			//}
		}
	});
	
	private View theView;
	private ViewVariables theViewVariables;

	
	public WashingMachine(View newView, ViewVariables newViewVariables){
		
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
	
	private void arretMachine() {
		timerCycle.stop();
		pauseCycle();
		waterSensor.tissuSupplementaire = tissueType;
		stopCycle();		
	}
	
	/*méthodes qui envoie sur la méthode du machine state*/
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
	public void setWaterVolume(double volume){
		machineState.setWaterVolume(volume);
	};
	
	public MachineState getVeille(){return veille;}
	public MachineState getPause(){return pause;}
	public MachineState getLavage(){return lavage;}
	public MachineState getTrempageEssorage(){return trempageEssorage;}
	
	/*Action des boutons*/
	
	class cotonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==1){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==1){
				setTissueType(0);
				cyclePlus = false;
			}else if (cycleType==2 && tissueType!=1){
				setTissueType(1);
				cyclePlus = true;
			} else {
				setCycleType(1);
				setTissueType(1);
			}
			//System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}

	class syntheticListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==2){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==2){
				setTissueType(0);
				cyclePlus = false;
			}else if (cycleType==2 && tissueType!=2){
				setTissueType(2);
				cyclePlus = true;
			}else{
				setCycleType(1);
				setTissueType(2);
			}
			//System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}
	
	class rugueuxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==3){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==3){
				setTissueType(0);
				cyclePlus = false;
			}else if (cycleType==2 && tissueType!=3){
				setTissueType(3);
				cyclePlus = true;
			}else{
				setCycleType(1);
				setTissueType(3);
			}
			//System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}
	
	class desinfectionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (cycleType==1 && tissueType==4){
				setCycleType(0);
				setTissueType(0);
			}else if (cycleType==2 && tissueType==4){
				setTissueType(0);
				cyclePlus = false;
			}else if (cycleType==2 && tissueType!=4){
				setTissueType(4);
				cyclePlus = true;
			}else{
				setCycleType(1);
				setTissueType(4);
			}
			//System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}
		
	}
	
	class trempageEssorageListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			/* gérer l'indépendance du bouton */
			if (cycleType==2 && tissueType == 0){
				setCycleType(0);
			}else if (cycleType==2 && tissueType!=0){
				setCycleType(1);
				cyclePlus = false;
			}else{
				if(tissueType!=0){
					cyclePlus = true;
				}
				setCycleType(2);				
			}
			//System.out.println("cycle "+Integer.toString(cycleType)+" et Tissue "+Integer.toString(tissueType) + " Temps :"+Integer.toString(cycleTime));
		}	
	}
	
	class waterLevelListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JComboBox cb = (JComboBox) arg0.getSource();
			int chosenLevel = Integer.parseInt((String) cb.getSelectedItem());
			//System.out.println(chosenLevel);
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
