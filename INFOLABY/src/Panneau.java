

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

	public class Panneau extends JPanel{
	
	private N_echantillon n_echantillon=new N_echantillon(1,1);
	
	private int c=32; // Taille cellule
	
	public void paintComponent(Graphics g){
		//On décide d'une couleur de fond pour notre rectangle
		g.setColor(Color.white);
		//On dessine celui-ci afin qu'il prenne tout la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (int x=0; x<n_echantillon.getEchantillon(1).getIndividu(1).labyrinthe.n(); x++){
			for (int y=0; y<n_echantillon.getEchantillon(1).getIndividu(1).labyrinthe.n(); y++) {
				if (n_echantillon.getEchantillon(1).getIndividu(1).labyrinthe.estMur(x,y)) {
				    g.setColor(Color.gray);
				    g.fillRect(x*c, y*c, c, c);
				}
				if (n_echantillon.getEchantillon(1).getIndividu(1).labyrinthe.estDepart(x,y)) {
				    g.setColor(Color.green);
				    g.fillRect(x*c, y*c, c, c);
				}
				if (n_echantillon.getEchantillon(1).getIndividu(1).labyrinthe.estArrivee(x,y)) {
				    g.setColor(Color.red);
				    g.fillRect(x*c, y*c, c, c);
				}
			}
		}
		    
	}
	

}
