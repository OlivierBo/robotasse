
public class Echantillon {
	
	private Individu individus[]; // Tableau des individus de l'échantillon
	
	private int nbIndividu; // Nombre d'individu dans l'échantillon

	//Constructeur
	public Echantillon(int n){
		System.out.println("Creation echantillon");
		individus= new Individu [n];
		for(int i=0;i<n;i++){
			individus[i] = new Individu();	
			}
	}
	
	
	
	//Accesseurs
	public int getNbIndividu(){
		return nbIndividu;
	}
	
	public Individu getIndividu(int n){
		return individus[n-1];
	}
	
	public void setNbIndividu(int n){
		this.nbIndividu=n;
	}

}
