import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();
	private JComboBox comboBoxNbE = new JComboBox();
	private JComboBox comboBoxNbI = new JComboBox();
	private JComboBox comboBoxTypeResolution = new JComboBox();
	private JButton boutonLancer = new JButton("Lancer");
	private JButton boutonArreter = new JButton("Arreter");
	private JButton boutonContinuer = new JButton("Continuer");
	private JPanel container = new JPanel();
	private JPanel south = new JPanel();
	private JPanel north2 = new JPanel();
	private JPanel north = new JPanel();
	private JLabel label1 = new JLabel("");
	private JLabel labelE = new JLabel("0");
	private JLabel labelI = new JLabel("0");
	private JLabel labelD = new JLabel("0");
	private JLabel labelC = new JLabel("0");
	private JLabel labelM = new JLabel("0");
	private JLabel labelP = new JLabel("0");
	private JLabel labelC1 = new JLabel("0");
	private JLabel labelC2 = new JLabel("0");
	
	
	private boolean animated = true;
	private Thread t;
	
	public Fenetre(){
		
		this.setTitle("Resolution Labyrinthe - Projet Informatique");
		this.setSize(600, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		String[] listeE={"1","2","3","4","5","6","7","8","9","10"};
		String[] listeI={"10","20","30","40","50","60","70","80","90","100","110","120","130","140","150","160","170","180","190","200"};
		String[] listeResol ={"DFS","BFS","Algorithme greedy", "Algorithme A*", "Escalade", "Recherche avec tabous", "Recuit simulé", "Algorithme génétiques","Algorithme de colonies de fourmis", "Logique de prpositions","Logique de prédicats"};
		
		// Ecoute des commandes

		comboBoxNbE = new JComboBox(listeE);
		comboBoxNbI = new JComboBox(listeI);
		comboBoxTypeResolution = new JComboBox(listeResol);
		
		comboBoxNbE.addActionListener(new ItemActionNbE());
		comboBoxNbE.setPreferredSize(new Dimension(60,20));
		comboBoxNbE.setForeground (Color.blue);
		
		comboBoxNbI.addActionListener(new ItemActionNbI());
		comboBoxNbI.setPreferredSize(new Dimension(60,20));
		comboBoxNbI.setForeground (Color.blue);
		
		comboBoxTypeResolution.addActionListener(new ItemActionResol());
		comboBoxTypeResolution.setPreferredSize(new Dimension(150,20));
		comboBoxTypeResolution.setForeground (Color.blue);
		
		boutonLancer.addActionListener(new BoutonLancerListener());
		boutonArreter.addActionListener(new BoutonArreterListener());
		boutonContinuer.addActionListener(new BoutonContinuerListener());
		
		
		// Placement des commande du haut
		north.setPreferredSize(new Dimension(600, 80));
		north.setLayout(new GridLayout(3, 3 , 5 , 5));
		north.add(new JLabel("Nombre d'échantillon"));
		north.add(new JLabel("Nombre d'individus"));
		north.add(new JLabel("Type de résolution"));
		north.add(comboBoxNbE);
		north.add(comboBoxNbI);
		north.add(comboBoxTypeResolution);
		north.add(boutonLancer );
		north.add(boutonArreter);
		boutonArreter.setEnabled (false);
		north.add(boutonContinuer);
		
		label1.setHorizontalAlignment(JLabel.CENTER );
		label1.setPreferredSize(new Dimension(600,20));
		north2.setPreferredSize(new Dimension(600, 100));
		north2.setLayout(new BorderLayout());
		north2.add(label1 ,BorderLayout.NORTH);
		north2.add(north, BorderLayout.SOUTH);
		
		
		
		
		//Ce sont maintenant nos classes internes qui écoutent nos boutons
		
		south.setPreferredSize(new Dimension(600,100));
		south.setLayout(new GridLayout(4, 4 , 5 , 5));
		south.add (new JLabel("Numéro Echantillon :"));
		south.add(labelE);
		south.add (new JLabel("Numéro Individu :"));
		south.add(labelI);
		south.add (new JLabel("Distance :"));
		south.add(labelD);
		south.add (new JLabel("Cases explorées :"));
		south.add(labelC);
		south.add (new JLabel("Moyenne temps de résolution réussite échantillon :"));
		south.add(labelM);
		south.add (new JLabel("Pourcentage de réussite :"));
		south.add(labelP);
		south.add (new JLabel("Critère 1 :"));
		south.add(labelC1);
		south.add (new JLabel("Critère 2 :"));
		south.add(labelC2);
	
		
		
		container.setBackground (Color.white);
		container.setLayout(new BorderLayout());
		container.add (north2, BorderLayout.NORTH);
		container.add (pan, BorderLayout.CENTER );
		container.add (south, BorderLayout.SOUTH);

		this.setContentPane(container);
		this.setVisible(true);
	}

	
	
	/**
	* Classe interne implémentant l'interface ItemListener
	*/

	class ItemActionNbE implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
		label1.setText("action sur "+ comboBoxNbE.getSelectedItem() +" dans Nbe Echantillon") ;
		
		}
		}
	
	class ItemActionNbI implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
		label1.setText("action sur "+ comboBoxNbI.getSelectedItem() +" dans nombre individu " ) ;
		}
		}
	
	class ItemActionResol implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
		label1.setText("action sur "+ comboBoxTypeResolution.getSelectedItem() +" dans type de résolution " )  ;
		}
		}
	
	class BoutonLancerListener implements ActionListener{
		/**
		* Redéfinition de la méthode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
		label1.setText("Vous avez cliqué sur le bouton Lancer");

		}
		}
	
	class BoutonArreterListener implements ActionListener{
		/**
		* Redéfinition de la méthode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
		label1.setText("Vous avez cliqué sur le bouton Arreter");
		
		}
		}
	
	class BoutonContinuerListener implements ActionListener{
		/**
		* Redéfinition de la méthode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
		label1.setText("Vous avez cliqué sur le bouton Continuer");
		
		}
		}
}
