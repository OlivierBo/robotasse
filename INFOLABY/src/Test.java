
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		Chemin ch=new Chemin();
		
		for(int i=0;i<5;i++){
			System.out.println("X = "+ch.getDeplacement()[i][0]+"Y = "+ch.getDeplacement()[i][1]);
		}
		System.out.println(ch.getNbcases());
		System.out.println(ch.getDeplacement().length);
		
		System.out.println(fenetre.getPan().getN_Echantillon().getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[1][1]);
		
		int[][] dep={{1,1},{1,2},{1,3},{1,4},{1,5},{2,5},{3,5},{4,5},{5,5},{5,6},{5,7},{4,7},{3,7}};
		
		fenetre.getPan().getN_Echantillon().getEchantillon(1).getIndividu(1).getChemin().setDeplacement(dep);
		System.out.println(fenetre.getPan().getN_Echantillon().getEchantillon(1).getIndividu(1).getChemin().getDeplacement()[1][1]);
		try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		int[][] dep2={{1,1},{2,1},{3,1},{3,2},{3,3},{4,3},{5,3},{6,3},{7,3},{7,4},{7,5},{8,5},{9,5},{9,4}};
		fenetre.getPan().getN_Echantillon().getEchantillon(1).getIndividu(1).getChemin().setDeplacement(dep2);
		fenetre.getPan().repaint();
	}

}
