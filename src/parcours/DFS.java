package parcours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import graphe.Arc;
import graphe.Graphe;
import graphe.Sommet;

public class DFS {
	static HashMap<Sommet,Sommet> parent= new HashMap<Sommet,Sommet>();
	static Sommet fermeturePremier;
	
	public static HashMap<Sommet,Sommet> dfs_parent(Graphe g){
		
		for(Sommet s:g.getSommets()){
			if(!(parent.containsKey(s))){
				parent.put(s, null);
				
				dfs_visit(s, s.getSortant());
			}
		}
		return parent;
	}
	/**
	 * parent = {s: none}
	 * dfs_visit(v, adj.s)
	 * 	for v in adj.s :
	 * 	if v not in parent :
	 * 		parent[v]=s
	 * 		dfs_visit(v, adj.s)
	 * 
	 * @param s
	 * @param marked
	 */
	public static void dfs_visit(Sommet s, List<Arc> tovisit){

		for(Arc a: tovisit){
			//System.out.println("arc:"+a.toString());
			Sommet actuel = a.getFin();
			//System.out.println("Sommet actuel:"+ actuel);
			if(!(parent.containsKey(actuel))){
				parent.put(actuel,s);
				//System.out.println("Sommet marké dans dfs_visite:"+actuel);
				dfs_visit(actuel,actuel.getSortant());
			}
		}
		
		
	}
	public static void topological_sort(Graphe g){
		
	}
		
}

	
