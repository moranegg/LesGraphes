package gestionnaires;

import parcours.DFS;
import graphe.Graphe;
import graphe.Sommet;
import connexions.ConnectionFichier;

public class GestionGraphe {
	ConnectionFichier<Graphe> fichierGraphe;
	
	
	public GestionGraphe(){
		
	}
	
	/**
	 * constructeur avec param
	 * @param nomFichierFacture
	 */
	public GestionGraphe(String nomFichierGraphe)
	{
		fichierGraphe = new  ConnectionFichier<Graphe>(nomFichierGraphe);
	}
	/**
	 * lecture du fichier qui sauvgarde la table des factures
	 * @return
	 */
	public Graphe lire()
	{
		Graphe g =  fichierGraphe.lire();
		if (g==null) g = new Graphe();
		return g;
	}
	/**
	 * ecriture de la table des factures en param dans le fichier des factures
	 * @param tabFact
	 */
	public void ecrire(Graphe g)
	{
		fichierGraphe.ecrire(g);
	}
	
	public Graphe creationGraphe(int[][] matrice, String nom){
		try{
			int vertical= matrice.length;
			
			for(int i =0; i<matrice.length; i++){
				if(!(vertical == matrice[i].length)){
					throw new Exception("La matrice n'est pas une matrice carré");
				}
			}
			Graphe g = new Graphe(matrice, nom);
			ecrire(g);
			return g;
		}catch(Exception e){
			System.out.print("there is a problem :"+ e.getMessage());
			return null;
		}
	}
	public void modifierGraphe(){
		//à compléter
	}
	public void supprimerGrpahe(){
		//à compléter
	}
	public void CFC(Graphe g){
		//depth first search
		//Sommet[] fermeture = DFS.depthFistSearch(g);
		//System.out.println("fermeture: "+fermeture[0]);
		
	}
	public void print(Graphe g){
		System.out.print(g.toString());
	}
	public Graphe inverser(Graphe g){
		try{
			return g.inverser();
		}catch(Exception e){
			return g;
		}
	}

}
