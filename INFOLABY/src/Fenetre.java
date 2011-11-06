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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		String[] listeResol ={"DFS","BFS","Algorithme greedy", "Algorithme A*", "Escalade", "Recherche avec tabous", "Recuit simul�", "Algorithme g�n�tiques","Algorithme de colonies de fourmis", "Logique de prpositions","Logique de pr�dicats"};
		
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
		north.add(new JLabel("Nombre d'�chantillon"));
		north.add(new JLabel("Nombre d'individus"));
		north.add(new JLabel("Type de r�solution"));
		north.add(comboBoxNbE);
		north.add(comboBoxNbI);
		north.add(comboBoxTypeResolution);
		north.add(boutonLancer );
		north.add(boutonArreter);
		boutonArreter.setEnabled (false);
		boutonContinuer.setEnabled (false);
		north.add(boutonContinuer);
		
		label1.setHorizontalAlignment(JLabel.CENTER );
		label1.setPreferredSize(new Dimension(600,20));
		north2.setPreferredSize(new Dimension(600, 100));
		north2.setLayout(new BorderLayout());
		north2.add(label1 ,BorderLayout.NORTH);
		north2.add(north, BorderLayout.SOUTH);
		
		
		
		
		//Ce sont maintenant nos classes internes qui �coutent nos boutons
		
		south.setPreferredSize(new Dimension(600,100));
		south.setLayout(new GridLayout(4, 4 , 5 , 5));
		south.add (new JLabel("Num�ro Echantillon :"));
		south.add(labelE);
		south.add (new JLabel("Num�ro Individu :"));
		south.add(labelI);
		south.add (new JLabel("Distance :"));
		south.add(labelD);
		south.add (new JLabel("Cases explor�es :"));
		south.add(labelC);
		south.add (new JLabel("Moyenne temps de r�solution r�ussite �chantillon :"));
		south.add(labelM);
		south.add (new JLabel("Pourcentage de r�ussite :"));
		south.add(labelP);
		south.add (new JLabel("Crit�re 1 :"));
		south.add(labelC1);
		south.add (new JLabel("Crit�re 2 :"));
		south.add(labelC2);
	
		
		
		container.setBackground (Color.white);
		container.setLayout(new BorderLayout());
		container.add (north2, BorderLayout.NORTH);
		container.add (getPan(), BorderLayout.CENTER );
		container.add (south, BorderLayout.SOUTH);

		this.setContentPane(container);
		this.setVisible(true);
	}

	
	public boolean isAnimated() {
		return animated;
	}

	public void setAnimated(boolean animated) {
		this.animated = animated;
	}



	public Thread getT() {
		return t;
	}



	public void setT(Thread t) {
		this.t = t;
	}



	public Panneau getPan() {
		return pan;
	}

	public void setPan(Panneau pan) {
		this.pan = pan;
	}



	/**
	* Classe interne impl�mentant l'interface ItemListener
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
			
		label1.setText("action sur "+ comboBoxTypeResolution.getSelectedItem() +" dans type de r�solution "+comboBoxTypeResolution.getSelectedIndex() )  ;
		}
		}
	
	class BoutonLancerListener implements ActionListener{
		/**
		* Red�finition de la m�thode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
			boutonLancer.setEnabled (false);
			boutonArreter.setEnabled (true);
			comboBoxNbE.setEnabled (true);
			comboBoxNbI.setEnabled (true);
			comboBoxTypeResolution.setEnabled (true);
			
			switch(comboBoxNbE.getSelectedIndex()){
			case 0:
				getPan().setNbEchantillon(1);
				break;
			case 1:
				getPan().setNbEchantillon(2);
				break;
			case 2:
				getPan().setNbEchantillon(3);
				break;
			case 3:
				getPan().setNbEchantillon(4);
				break;
			case 4:
				getPan().setNbEchantillon(5);
				break;
			case 5:
				getPan().setNbEchantillon(6);
				break;
			case 6:
				getPan().setNbEchantillon(7);
				break;
			case 7:
				getPan().setNbEchantillon(8);
				break;
			case 8:
				getPan().setNbEchantillon(9);
				break;
			case 9:
				getPan().setNbEchantillon(10);
				break;
			}
			
			switch(comboBoxNbI.getSelectedIndex()){
			case 0:
				getPan().setNbIndividu(10);
				break;
			case 1:
				getPan().setNbIndividu(20);
				break;
			case 2:
				getPan().setNbIndividu(30);
				break;
			case 3:
				getPan().setNbIndividu(40);
				break;
			case 4:
				getPan().setNbIndividu(50);
				break;
			case 5:
				getPan().setNbIndividu(60);
				break;
			case 6:
				getPan().setNbIndividu(70);
				break;
			case 7:
				getPan().setNbIndividu(80);
				break;
			case 8:
				getPan().setNbIndividu(90);
				break;
			case 9:
				getPan().setNbIndividu(100);
				break;
			case 10:
				getPan().setNbIndividu(110);
				break;
			case 11:
				getPan().setNbIndividu(120);
				break;
			case 12:
				getPan().setNbIndividu(130);
				break;
			case 13:
				getPan().setNbIndividu(140);
				break;
			case 14:
				getPan().setNbIndividu(150);
				break;
			case 15:
				getPan().setNbIndividu(160);
				break;
			case 16:
				getPan().setNbIndividu(170);
				break;
			case 17:
				getPan().setNbIndividu(180);
				break;
			case 18:
				getPan().setNbIndividu(190);
				break;
			case 19:
				getPan().setNbIndividu(200);
				break;
			}
			
			
		label1.setText("Vous avez cliqu� sur le bouton Lancer");
		System.out.println("Parametres d'execution : NbE = "+comboBoxNbE.getSelectedItem()+"  NbI : "+comboBoxNbI.getSelectedItem()+ "  Algo  " +comboBoxTypeResolution.getSelectedItem());

		switch(comboBoxTypeResolution.getSelectedIndex()){
		case 0:
			getPan().BFS(3);
			break;
		
		
		case 1:
			getPan().BFS(3);
			break;
			
		case 2:
			break;
			
		case 3:
			break;
			
		case 4:
			break;
			
		case 5:
			break;
			
		case 6:
			break;
			
		case 7:
			break;
			
		case 8:
			break;
			
		case 9:
			break;
			
		case 10:
			break;
		}
		
		}
		}
	
	class BoutonArreterListener implements ActionListener{
		/**
		* Red�finition de la m�thode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
			boutonLancer.setEnabled (true);
			boutonArreter.setEnabled (false);
			comboBoxNbE.setEnabled (false);
			comboBoxNbI.setEnabled (false);
			comboBoxTypeResolution.setEnabled (false);
		label1.setText("Vous avez cliqu� sur le bouton Arreter");
		
		}
		}
	
	class BoutonContinuerListener implements ActionListener{
		/**
		* Red�finition de la m�thode actionPerformed
		*/
		public void actionPerformed (ActionEvent arg0) {
			boutonLancer.setEnabled (false);
		label1.setText("Vous avez cliqu� sur le bouton Continuer");

		}
		}
}
