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

public int Tempscycle(){
	
	int Tempscycle = 0;
	switch(washingMachine.cycleType){
		case 1:
		switch(washingMachine.tissueType){
			case 1:
				Tempscycle = 55;
				break;
			case 2:
				Tempscycle = 35;
				break;
			case 3:
				Tempscycle = 55;
				break;
			case 4:
				Tempscycle = 55;
				break;
			default:
				break;
		}
		break;
		case 2:
			switch(washingMachine.tissueType){
			case 1:
				Tempscycle = 85;
				break;
			case 2:
				Tempscycle = 65;
				break;
			case 3:
				Tempscycle = 85;
				break;
			case 4:
				Tempscycle = 85;
				break;
			default:
				Tempscycle = 25;
				break;
		}
		break;
		default:
			break;
	}
	return Tempscycle;	
}
	
	public Veille(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	@Override
	public void setWaterVolume(int volume) {
		washingMachine.WaterVolume = volume;
	}
	
	@Override
	public void startCycle(int cycleType) {
			switch(cycleType){
			case 1:
				washingMachine.setMachineState(washingMachine.getLavage());
				washingMachine.timer1.start();
				break;
			case 2:
				washingMachine.setMachineState(washingMachine.getTrempageEssorage());
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
		switch(tissueType){
		case 1:
			washingMachine.tissueType = 1;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		case 2: 
			washingMachine.tissueType = 2;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		case 3:
			washingMachine.tissueType = 3;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		case 4:
			washingMachine.tissueType = 4;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		default : 
			washingMachine.tissueType = 0;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			if (cycleTypeName().equals("")){
				View.temps.setText("");
			}else{
				View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			}
			break;
		}
	}

	@Override
	public void setCycleType(int cycleType) {
		switch(cycleType){
		case 1:
			washingMachine.cycleType = 1;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		case 2:
			washingMachine.cycleType = 2;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText(cycleTypeName());
			View.temps.setText("("+Integer.toString(Tempscycle())+"min)");
			break;
		default:
			washingMachine.cycleType = 0;
			washingMachine.cycleTime = Tempscycle();
			View.affichage.setText("");
			View.temps.setText("");
			break;
		}
	}

}
