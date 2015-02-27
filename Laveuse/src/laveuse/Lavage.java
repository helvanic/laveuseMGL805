package laveuse;

public class Lavage implements MachineState {

		
	WashingMachine washingMachine;
	int cycleTime = 60;
	
	public Lavage(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}
	
	
	public void startCycle(int cycleType) {
		System.out.println("Cycle Lavage already Started");
	}

	public void pauseCycle() {
		System.out.println("Pausing the machine");
		washingMachine.cyclePaused = true;
		washingMachine.setMachineState(washingMachine.getPause());
	}

	public void injectSavon() {
		if(washingMachine.WaterVolume>=20 && washingMachine.savonInjected==false){
			System.out.println("Injection Savon");
			washingMachine.savonInjected = true;
		}else if(washingMachine.WaterVolume<20){
			System.out.println("Pas assez d'eau");
		}else if(washingMachine.savonInjected==true){
			System.out.println("Savon déjà injecté ! ");
		}
	}

	public void injectJavel() {
		if(washingMachine.WaterVolume==100 && washingMachine.javelInjected==false){
			System.out.println("Injection Javellisant");
			washingMachine.javelInjected = true;
		}else if(washingMachine.WaterVolume<100){
			System.out.println("Pas assez d'eau");
		}else if(washingMachine.javelInjected==true){
			System.out.println("Javellisant déjà injecté ! ");
		}
	}

	public void injectAdoucisseur() {
		if((cycleTime-washingMachine.timeSinceStart)<=5 && washingMachine.AssouplisseurInjected==false){
			System.out.println("Injection Assouplisseur");
			washingMachine.AssouplisseurInjected = true;
		}else if((cycleTime-washingMachine.timeSinceStart)>5){
			System.out.println("Trop tôt !");
		}else if(washingMachine.AssouplisseurInjected==true){
			System.out.println("Assouplisseur déjà injecté ! ");
		}
	}

	public void stopCycle() {
		System.out.println("Impossible to stop the cycle if not already paused");
	}

	public void setTissueType(int tissueType) {
		System.out.println("Impossible during a cycle");
	}

	public void setCycleType(int cycleType) {
		System.out.println("Impossible during a cycle");
	}

	public void setWaterVolume(int volume) {
		System.out.println("Impossible during a cycle");
	}

}
