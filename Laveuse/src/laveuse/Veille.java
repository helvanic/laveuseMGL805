package laveuse;

public class Veille implements MachineState {

	WashingMachine washingMachine;
	
private String cycleTypeName(){
		
		String cycleTypeName = "";
		switch(washingMachine.cycleType){
			case 1:
			switch(washingMachine.tissueType){
				case 1:
					cycleTypeName = FinalVariables.Coton;
					break;
				case 2:
					cycleTypeName = FinalVariables.Synthetique;
					break;
				case 3:
					cycleTypeName = FinalVariables.Rugueux;
					break;
				case 4:
					cycleTypeName = FinalVariables.Desinfection;
					break;
				default:
					break;
			}
			break;
			case 2:
				switch(washingMachine.tissueType){
				case 1:
					cycleTypeName = FinalVariables.Cotonplus;
					break;
				case 2:
					cycleTypeName = FinalVariables.Synthétiqueplus;
					break;
				case 3:
					cycleTypeName = FinalVariables.Rugueuxplus;
					break;
				case 4:
					cycleTypeName = FinalVariables.Desinfectionplus;
					break;
				default:
					cycleTypeName = FinalVariables.trempage;
					break;
			}
			break;
			default:
				break;
		}
		return cycleTypeName;	
	}

public int[] caracycle(){
	
	int tempMax = 90;
	int tempMin = 20;
	int cadenceLavage = 0;
	int rotationEss = 0;
	int timeLav = 0;
	int timeEss = 0;
	int cycleTime = 0;
	int cycleTimeTotal = 0;
	
	switch(washingMachine.cycleType){
		case 1:
		switch(washingMachine.tissueType){
			case 1:
				tempMin = 40;
				tempMax = 50;
				cadenceLavage = 10;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime;
				break;
			case 2:
				tempMin = 50;
				tempMax = 60;
				cadenceLavage = 15;
				rotationEss = 10;
				timeLav = 30;
				timeEss = 5;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime;
				break;
			case 3:
				tempMin = 30;
				tempMax = 40;
				cadenceLavage = 8;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime;
				break;
			case 4:
				tempMin = 85;
				tempMax = 90;
				cadenceLavage = 10;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime;
				break;
			default:
				break;
		}
		break;
		case 2:
			switch(washingMachine.tissueType){
			case 1:
				tempMin = 40;
				tempMax = 50;
				cadenceLavage = 10;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime +30;
				break;
			case 2:
				tempMin = 50;
				tempMax = 60;
				cadenceLavage = 15;
				rotationEss = 10;
				timeLav = 30;
				timeEss = 5;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime +30;
				break;
			case 3:
				tempMin = 30;
				tempMax = 40;
				cadenceLavage = 8;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime +30;
				break;
			case 4:
				tempMin = 85;
				tempMax = 90;
				cadenceLavage = 10;
				rotationEss = 20;
				timeLav = 45;
				timeEss = 10;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime +30;
				break;
			default:
				tempMin = 20;
				tempMax = 30;
				cadenceLavage = 0;
				rotationEss = 30;
				timeLav = 10;
				timeEss = 15;
				cycleTime = timeLav + timeEss;
				cycleTimeTotal = cycleTime;
				break;
			}	
			break;
		default:
			break;
	}
	return new int[]{tempMin,tempMax,cadenceLavage,rotationEss,timeLav,timeEss,cycleTime,cycleTimeTotal};	
}
	
	public Veille(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	@Override
	public void setWaterVolume(double volume) {
		washingMachine.WaterVolume = volume;
	}
	
	@Override
	public void startCycle(int cycleType) {
		washingMachine.savonClosed=true;
		washingMachine.javelClosed=true;
		washingMachine.assouplisseurClosed=true;
			switch(cycleType){
			case 1:
				/*faire le remplissage*/
				washingMachine.waterSensor.timerRemplissage.start();
				washingMachine.temperatureSensor.timerTemperature.start();
				washingMachine.setMachineState(washingMachine.getLavage());
				washingMachine.timerCycle.start();
				break;
			case 2:
				/*faire le remplissage*/
				washingMachine.temperatureSensor.timerTemperature.start();
				washingMachine.waterSensor.timerRemplissage.start();
				washingMachine.setMachineState(washingMachine.getTrempageEssorage());
				washingMachine.timerCycle.start();
				break;
			default:
				View.affichage.setText("Choisir un cycle");
				break;
			}
	}

	@Override
	public void pauseCycle() {}

	@Override
	public void injectSavon() {}

	@Override
	public void injectJavel() {}

	@Override
	public void injectAdoucisseur() {}

	@Override
	public void stopCycle() {}

	@Override
	public void setTissueType(int tissueType) {
		int [] donnees = new int[6];
		switch(tissueType){
		case 1:
			washingMachine.tissueType = 1;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			if(washingMachine.cyclePlus){
				washingMachine.cycleTime = 30;
			}else{
				washingMachine.cycleTime = donnees[6];
			}
			
			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			View.temps.setText("("+donnees[7]+"min)");
			break;
		case 2: 
			washingMachine.tissueType = 2;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			if(washingMachine.cyclePlus){
				washingMachine.cycleTime = 30;
			}else{
				washingMachine.cycleTime = donnees[6];
			}

			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			View.temps.setText("("+donnees[7]+"min)");
			break;
		case 3:
			washingMachine.tissueType = 3;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			if(washingMachine.cyclePlus){
				washingMachine.cycleTime = 30;
			}else{
				washingMachine.cycleTime = donnees[6];
			}

			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			View.temps.setText("("+donnees[7]+"min)");
			break;
		case 4:
			washingMachine.tissueType = 4;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			if(washingMachine.cyclePlus){
				washingMachine.cycleTime = 30;
			}else{
				washingMachine.cycleTime = donnees[6];
			}

			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			View.temps.setText("("+donnees[7]+"min)");
			break;
		default : 
			washingMachine.tissueType = 0;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			washingMachine.cycleTime = donnees[6];

			washingMachine.cycleTypeName = cycleTypeName();
			View.affichage.setText(cycleTypeName());
			if (cycleTypeName().equals("")){
				View.temps.setText("");
			}else{
				View.temps.setText("("+donnees[7]+"min)");
			}
			break;
		}
	}

	@Override
	public void setCycleType(int cycleType) {
		int [] donnees = new int[6];
		switch(cycleType){
		case 1:
			washingMachine.cycleType = 1;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			washingMachine.cycleTime = donnees[6];

			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			View.temps.setText("("+Integer.toString(donnees[7])+"min)");
			break;
		case 2:
			washingMachine.cycleType = 2;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			washingMachine.cycleTime = 30;
			
			washingMachine.cycleTypeName = cycleTypeName(); 
			View.affichage.setText(washingMachine.cycleTypeName);
			
			View.temps.setText("("+Integer.toString(donnees[7])+"min)");
			break;
		default:
			washingMachine.cycleType = 0;
			donnees = caracycle();
			
			washingMachine.tempMax = donnees[0];
			washingMachine.tempMin = donnees[1];
			washingMachine.cadenceLavage = donnees[2];
			washingMachine.rotationEss = donnees[3];
			washingMachine.timeLav = donnees[4];
			washingMachine.timeEss = donnees[5];
			washingMachine.cycleTime = donnees[6];

			View.affichage.setText("");
			View.temps.setText("");
			break;
		}
	}

}
