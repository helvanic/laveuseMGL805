package laveuse;

import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class WaterSensor {
	
	WashingMachine washingMachine;
	
	public WaterSensor(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}	
	
	final Timer timerRemplissage= new Timer(100,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			washingMachine.currentWaterVolume+=1;
			View.waterLevel.setValue(washingMachine.currentWaterVolume);
			
			if (washingMachine.tissueType == 4){
				if(washingMachine.currentWaterVolume==(washingMachine.WaterVolume*5)){
					washingMachine.javelClosed = false;
					washingMachine.injectJavel();
					timerRemplissage.stop();
					washingMachine.timerCycle.start();
				}else if(washingMachine.currentWaterVolume>=(0.2*(washingMachine.WaterVolume*5)) && washingMachine.savonClosed){
					washingMachine.savonClosed = false;
					washingMachine.injectSavon();
				}
			}else{
				if(washingMachine.currentWaterVolume==(washingMachine.WaterVolume*10)){
					washingMachine.javelClosed = false;
					washingMachine.injectJavel();
					timerRemplissage.stop();
					washingMachine.timerCycle.start();
				}else if(washingMachine.currentWaterVolume>=(0.2*(washingMachine.WaterVolume*10)) && washingMachine.savonClosed){
					washingMachine.savonClosed = false;
					washingMachine.injectSavon();
				}
			}
		}
	});
	final Timer timerVidange= new Timer(100,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			washingMachine.currentWaterVolume-=1;
			View.waterLevel.setValue(washingMachine.currentWaterVolume);
			
			if(washingMachine.currentWaterVolume<=0){
				View.affichage.setText(FinalVariables.vidanged);
				washingMachine.currentWaterVolume = 0;
				timerVidange.stop();
			}
		}
	});
	
	
}
