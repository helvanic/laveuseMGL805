package laveuse;

public class Veille implements MachineState {

	WashingMachine washingMachine;
	
	private String tissueTypeName(){
		
		String tissueTypeName = "";
		switch(washingMachine.tissueType){
			case 1:
				tissueTypeName = "Coton";
				break;
			case 2:
				tissueTypeName = "Synthétique";
				break;
			case 3:
				tissueTypeName = "Rugueux";
				break;
			default:
				tissueTypeName = "Pas de tissu sélectionné";
				break;
		}
		return tissueTypeName;	
	}
	
private String cycleTypeName(){
		
		String cycleTypeName = "";
		switch(washingMachine.cycleType){
			case 1:
				cycleTypeName = "Lavage";
				break;
			case 2:
				cycleTypeName = "Trempage Essorage";
				break;
			case 3:
				cycleTypeName = "Désinfection";
				break;
			default:
				cycleTypeName = "Pas de tissu sélectionné";
				break;
		}
		return cycleTypeName;	
	}
	
	public Veille(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	@Override
	public void startCycle(int cycleType) {
		if(washingMachine.tissueType!=0){
			switch(cycleType){
			case 1:
				System.out.println("Démarrage du lavage du tissu "+tissueTypeName());
				washingMachine.setMachineState(washingMachine.getLavage());
				break;
			case 2:
				System.out.println("Démarrage du trempage essorage du tissu "+tissueTypeName());
				washingMachine.setMachineState(washingMachine.getTrempageEssorage());
				break;
			case 3:
				System.out.println("Démarrage de la désinfection du tissu "+tissueTypeName());
				washingMachine.setMachineState(washingMachine.getTrempageEssorage());
				break;
			default:
				System.out.println("Démarrage du lavage (par défault) du tissu "+tissueTypeName());
				washingMachine.setMachineState(washingMachine.getLavage());
				break;
			}
		}else{
			System.out.println("Choose a tissue type first !");
		}
	}

	@Override
	public void pauseCycle() {
		// TODO Auto-generated method stub
		System.out.println("You can't pause a cycle that hasn't begun !");
	}

	@Override
	public void injectSavon() {
		// TODO Auto-generated method stub
		System.out.println("Impossible");
	}

	@Override
	public void injectJavel() {
		// TODO Auto-generated method stub
		System.out.println("Impossible");
	}

	@Override
	public void injectAdoucisseur() {
		// TODO Auto-generated method stub
		System.out.println("Impossible");
	}

	@Override
	public void stopCycle() {
		// TODO Auto-generated method stub
		System.out.println("The cycle hasn't even started yet !");
	}

	@Override
	public void setTissueType(int tissueType) {
		// TODO Auto-generated method stub
		switch(tissueType){
		case 1:
			washingMachine.tissueType = 1;
			System.out.println("Tissu sélectionné : "+tissueTypeName());
			break;
		case 2: 
			washingMachine.tissueType = 2;
			System.out.println("Tissu sélectionné : "+tissueTypeName());
			break;
		case 3:
			washingMachine.tissueType = 3;
			System.out.println("Tissu sélectionné : "+tissueTypeName());
			break;
		default : 
			washingMachine.tissueType = 0;
			System.out.println("Tissu sélectionné : "+tissueTypeName());
			break;
		}
	}

	@Override
	public void setCycleType(int cycleType) {
		// TODO Auto-generated method stub
		switch(cycleType){
		case 1:
			washingMachine.cycleType = 1;
			System.out.println("Cycle sélectionné : "+cycleTypeName());
			break;
		case 2:
			washingMachine.cycleType = 2;
			System.out.println("Cycle sélectionné : "+cycleTypeName());
			break;
		case 3:
			washingMachine.cycleType = 3;
			System.out.println("Cycle sélectionné : "+cycleTypeName());
			break;
		default:
			washingMachine.cycleType = 0;
			System.out.println("Sélectionnez d'abord un type de tissu");
			break;
		}
	}

	@Override
	public void setWaterVolume(int volume) {
		// TODO Auto-generated method stub
		washingMachine.WaterVolume = volume;
		System.out.println("Volume d'eau sélectionné : "+washingMachine.WaterVolume);
	}

}
