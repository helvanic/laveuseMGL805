package laveuse;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;


public class ViewVariables extends JFrame{	
	
	public static JLabel savonInjecte = new JLabel("Savon : ");
	public static JLabel savonInjecteValue = new JLabel(FinalVariables.waiting);
	public static JLabel javelInjecte = new JLabel("Javelissant : ");
	public static JLabel javelInjecteValue = new JLabel(FinalVariables.waiting);
	public static JLabel adoucisseurInjecte = new JLabel("Adoucisseur : ");
	public static JLabel adoucisseurInjecteValue = new JLabel(FinalVariables.waiting);
	public static JLabel tissu = new JLabel("Tissu : ");
	public static JLabel tissuValue = new JLabel(FinalVariables.waitingForChoice);
	public static JLabel apm = new JLabel("APM (agitation) : ");
	public static JLabel apmValue = new JLabel(FinalVariables.waiting);
	public static JLabel tpm = new JLabel("TPM (tour) : ");
	public static JLabel tpmValue = new JLabel(FinalVariables.waiting);
	
	public ViewVariables(){
		JPanel panelPrincipal = new JPanel();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 250);
		panelPrincipal.setLayout(new GridLayout(6, 2));
		
		/*1ère ligne*/
		panelPrincipal.add(savonInjecte);
		panelPrincipal.add(savonInjecteValue);
		/*2ème ligne*/
		panelPrincipal.add(javelInjecte);
		panelPrincipal.add(javelInjecteValue);
		/*3ème ligne*/
		panelPrincipal.add(adoucisseurInjecte);
		panelPrincipal.add(adoucisseurInjecteValue);
		/*4ème ligne*/
		panelPrincipal.add(tissu);
		panelPrincipal.add(tissuValue);
		/*5ème ligne*/
		panelPrincipal.add(apm);
		panelPrincipal.add(apmValue);
		/*6ème ligne*/
		panelPrincipal.add(tpm);
		panelPrincipal.add(tpmValue);
	
		this.add(panelPrincipal);
		
	}	
}
