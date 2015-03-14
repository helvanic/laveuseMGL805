package laveuse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TemperatureSensor {

	WashingMachine washingMachine;
	
	public TemperatureSensor(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}	
	
	final Timer timerTemperature= new Timer(200,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			if(washingMachine.currentTemp<=((washingMachine.tempMax+washingMachine.tempMin)/2)){
				washingMachine.currentTemp++;
			}
			View.temperature.setText("Température : "+washingMachine.currentTemp);
		}
	});
	
	final Timer timerCoolTemperature= new Timer(200,new ActionListener()
	{
		public void actionPerformed(ActionEvent e1)
		{
			washingMachine.currentTemp--;
			if(washingMachine.currentTemp>=0){
				View.temperature.setText("Température : "+washingMachine.currentTemp);
			}else{
				View.temperature.setText("Température : ");
				timerCoolTemperature.stop();
			}
			
		}
	});
}
