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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;


public class View extends JFrame{
	
	private JButton coton = new JButton(FinalVariables.Coton);
	private JButton synthetic = new JButton(FinalVariables.Synthetique);
	private JButton rugueux = new JButton(FinalVariables.Rugueux);
	private JButton desinfection = new JButton(FinalVariables.Desinfection);
	private JButton trempageEssorage = new JButton(FinalVariables.trempage);
	private JButton depart = new JButton("Départ");
	private JLabel voyantLumineux = new JLabel("Voyant Lumineux"); //voir pour mettre le voyant lumineux
	private JButton arret = new JButton("Arrêt");
	public  static JLabel affichage = new JLabel();
	public static JLabel temps = new JLabel("");
	
	
	private JLabel textEau = new JLabel("Volume d'eau : ");
	
	String[] petStrings = {"1","2","3","4","5","6","7","8","9","10"};
	
	private JComboBox volumeDEau = new JComboBox(petStrings);
	
	public View(){
		JPanel panelPrincipal = new JPanel();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(550, 150);
		
		panelPrincipal.add(coton);
		panelPrincipal.add(synthetic);
		panelPrincipal.add(rugueux);
		panelPrincipal.add(desinfection);
		panelPrincipal.add(trempageEssorage);
		panelPrincipal.add(textEau);
		panelPrincipal.add(volumeDEau);
		panelPrincipal.add(depart);
		panelPrincipal.add(voyantLumineux);
		panelPrincipal.add(arret);
		panelPrincipal.add(affichage);
		panelPrincipal.add(temps);
		
		this.add(panelPrincipal);
		
	}
	
	public void setVoyantLumineux(String string){
		this.voyantLumineux.setText(string);
	}
	
	void addListeners(
			ActionListener cotonListener,
			ActionListener rugueuxListener,
			ActionListener syntheticListener,
			ActionListener desinfectionListener,
			ActionListener trempageEssorageListener,
			ActionListener waterLevelListener,
			ActionListener departListener,
			ActionListener arretListener
			){
		
		coton.addActionListener(cotonListener);
		rugueux.addActionListener(rugueuxListener);
		synthetic.addActionListener(syntheticListener);
		desinfection.addActionListener(desinfectionListener);
		trempageEssorage.addActionListener(trempageEssorageListener);
		volumeDEau.addActionListener(waterLevelListener);
		depart.addActionListener(departListener);
		arret.addActionListener(arretListener);
	}
	
}
