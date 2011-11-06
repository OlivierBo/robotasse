

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

	public class Panneau extends JPanel implements Resolution{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	private N_echantillon n_echantillon=new N_echantillon(1,1);
	private int c=32; // Taille cellule
	private int nbIndividu;
	private int nbEchantillon;
	private String typeResol;
	private int numeroIndividu;
	private int numeroEchantillon;
	private float distanceCible=(float) 0.0;
	private int caseExplorees;
	private float moyenneTempsResolution;
	private float pourcentageReussite;
	private float critere1;
	private float critere2;
	

	public void paintComponent(Graphics g){
		//On d�cide d'une couleur de fond pour notre rectangle
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
		int[][] dep=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getDeplacement();
		n_echantillon.getEchantillon(1).getIndividu(1).getChemin().updateNbcase();
		int ndep=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getNbcases();
		int xd;
		int yd;
		g.setColor(Color.blue);
		for(int i=0; i< (ndep-1); i++){
			xd=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[i][0];
			yd=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[i][1];
			g.fillRect(xd*c+c/4, yd*c+c/4, c/2, c/2);
		}
		g.setColor(Color.green);
		xd=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[ndep-1][0];
		yd=n_echantillon.getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[ndep-1][1];
		g.fillRect(xd*c+c/4, yd*c+c/4, c/2, c/2);
		    
	}

	public N_echantillon getN_Echantillon(){
		return n_echantillon;
	}

	public int getNbIndividu() {
		return nbIndividu;
	}


	public void setNbIndividu(int nbIndividu) {
		this.nbIndividu = nbIndividu;
	}


	public int getNumeroIndividu() {
		return numeroIndividu;
	}


	public void setNumeroIndividu(int numeroIndividu) {
		this.numeroIndividu = numeroIndividu;
	}


	public int getNumeroEchantillon() {
		return numeroEchantillon;
	}


	public void setNumeroEchantillon(int numeroEchantillon) {
		this.numeroEchantillon = numeroEchantillon;
	}


	public float getDistanceCible() {
		return distanceCible;
	}


	public void setDistanceCible(float distanceCible) {
		this.distanceCible = distanceCible;
	}


	public int getCaseExplorees() {
		return caseExplorees;
	}


	public void setCaseExplorees(int caseExplorees) {
		this.caseExplorees = caseExplorees;
	}


	public float getMoyenneTempsResolution() {
		return moyenneTempsResolution;
	}


	public void setMoyenneTempsResolution(float moyenneTempsResolution) {
		this.moyenneTempsResolution = moyenneTempsResolution;
	}


	public float getPourcentageReussite() {
		return pourcentageReussite;
	}


	public void setPourcentageReussite(float pourcentageReussite) {
		this.pourcentageReussite = pourcentageReussite;
	}


	public float getCritere1() {
		return critere1;
	}


	public void setCritere1(float critere1) {
		this.critere1 = critere1;
	}


	public float getCritere2() {
		return critere2;
	}


	public void setCritere2(float critere2) {
		this.critere2 = critere2;
	}



	public int getNbEchantillon() {
		return nbEchantillon;
	}



	public void setNbEchantillon(int nbEchantillon) {
		this.nbEchantillon = nbEchantillon;
	}



	public String getTypeResol() {
		return typeResol;
	}



	public void setTypeResol(String typeResol) {
		this.typeResol = typeResol;
	}



	@Override
	public void BFS(int nbIndividu) {
		
		
	}



	@Override
	public void DFS(int nbIndividu) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void AlgorithmeGreedy(int nbIndividu) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void AlgorithmeA(int nbIndividu) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void Escalade() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void RechercheAvecTabous() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void RecuitSimule() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void AlgorithmeGenetique() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void AlgorithmeColonieFourmis() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void LogiqueDeProposition() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void LogiqueDePredicats() {
		// TODO Auto-generated method stub
		
	}
	

	
}
