
public class Individu{

	public char[][] map; //Matrice qui sera visualis�e
	
	protected Chemin chemin = new Chemin();	// Chemin de l'individu
	
	protected Labyrinthe labyrinthe=new Labyrinthe();
	
	//Constructeur
	public Individu(){
		System.out.println("creation indi");
		this.map=labyrinthe.murs;
	}
	
	// Accesseurs
	public Chemin getChemin(){
		return chemin;
		
	}

	
}
