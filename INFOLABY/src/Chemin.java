
public class Chemin {
	
	private int deplacement[][]; // Deplacement par coordonn�es 1er �l�ment : ligne ; 2nd �l�ment : colonne
	
	private int nbcases; // Nombre de cases explor�es
	
	// Constructeur
	public Chemin(){
		int i=0;
		setDeplacement(new int[200][2]);
		
		getDeplacement()[0][0]=2;
		getDeplacement()[0][1]=2;
		updateNbcase();
		
		
	}
	
	
	// Accesseurs
	public int getNbcases(){
		return nbcases;
	}
	
	public boolean existeDeja(int x, int y){
		return false;
	}
	
	public void updateNbcase(){
		int i=0;
		while(i<this.getDeplacement().length && (this.getDeplacement()[i][0]!=0 && this.getDeplacement()[i][1]!=0) ){
			i++;
		}
		this.nbcases=i;
	}


	public int[][] getDeplacement() {
		return deplacement;
	}


	public void setDeplacement(int deplacement[][]) {
		this.deplacement = deplacement;
	}

}
