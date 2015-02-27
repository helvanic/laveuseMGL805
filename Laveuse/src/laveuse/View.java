package laveuse;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class View extends JFrame{
	
	private JButton coton = new JButton("Coton");
	private JButton synthetic = new JButton("Synthétique");
	private JButton rugueux = new JButton("Rugueux");
	private JButton desinfection = new JButton("Desinfection");
	private JButton trempageEssorage = new JButton("Trempage Essorage");
	private JButton depart = new JButton("Départ");
	private JLabel voyantLumineux = new JLabel("Voyant Lumineux");
	private JButton arret = new JButton("Arrêt");
	
	
	private JLabel textEau = new JLabel("Volume d'eau : ");
	
	String[] petStrings = {"0","10","20","30","40","50","60","70","80","90","100"};
	
	private JComboBox volumeDEau = new JComboBox(petStrings);
	
	public View(){
		JPanel panelPrincipal = new JPanel();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(550, 120);
		
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
