package gestionnaires;

import java.util.Map.Entry;

import parcours.DFS;
import graphe.Graphe;
import graphe.Sommet;


public class Client {

	public static void main(String[] args) {
		
		GestionGraphe GG = new GestionGraphe("fichierDeGraphe");
		
		int[][] matrice = {{0,1,1,0},{1,0,1,0},{0,0,0,0},{0,1,0,0}};
		String nom="Graphe simple";
		
		Graphe g = GG.creationGraphe(matrice, nom);
		GG.print(g);
		for(Entry<Sommet, Sommet> ss:DFS.dfs_parent(g).entrySet()){
			System.out.println(ss.getValue()+"est le parent de "+ss.getKey());
		}
		
		
		//GG.print(GG.inverser(g));
		//DFS.depthFistSearch(GG.inverser(g));



	}

}
