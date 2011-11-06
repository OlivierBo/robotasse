
public class Echantillon {
	
	private Individu individus[]; // Tableau des individus de l'�chantillon
	
	private int nbIndividu; // Nombre d'individu dans l'�chantillon
	
	private int tempsResolution;

	//Constructeur
	public Echantillon(int n){
		System.out.println("Creation echantillon");
		individus= new Individu [n];
		for(int i=0;i<n;i++){
			individus[i] = new Individu();	
			}
		nbIndividu=n;
		setTempsResolution(0);
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



	public int getTempsResolution() {
		return tempsResolution;
	}



	public void setTempsResolution(int tempsResolution) {
		this.tempsResolution = tempsResolution;
	}

}
