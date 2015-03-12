package laveuse;

public interface MachineState {
	
	void startCycle(int cycleType);
	void pauseCycle();
	void injectSavon();
	void injectJavel();
	void injectAdoucisseur();
	void stopCycle();
	void setTissueType(int tissueType);
	void setCycleType(int cycleType);
	void setWaterVolume(double volume);
	
	
}

