package graphe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Graphe extends Observable implements Serializable  {
	String nomGraphe;
	ArrayList<Sommet> sommets;
	ArrayList<Arc> arcs;
	int[][] matrice;
	/**
	 * Constructeur par défaut
	 */
	public Graphe(){
		this.sommets = new ArrayList<Sommet>();
		this.arcs = new ArrayList<Arc>();
		this.matrice = null;
	}
	/**
	 * 
	 * @param m
	 * @throws Exception
	 */
	public Graphe(int[][] m, String nom) throws Exception{
		this.nomGraphe = nom;
		
		this.sommets = new ArrayList<Sommet>();
		this.arcs = new ArrayList<Arc>();
		this.matrice = m;
		this.construireGraphe(m);
	}
	/**
	 * 
	 * @param m
	 */
	public void construireGraphe(int[][] m){
		//ajouter les sommets
		for(int i =1; i<=m.length; i++){
			String nom = "s" +Integer.toString(i);
			//System.out.println(nom);
			Sommet actuel = new Sommet(nom);
			this.sommets.add(actuel);
		}
		//ajouter les arcs
		
		for(int i =0; i<=m.length-1; i++){
			//sommet debut i
			
			for(int j=0; j<=m[i].length-1; j++){
				//sommet fin j
				int valuation = m[i][j];
				//si le nombre d'arcs de m[i][j] est supérieur à 0
				if(valuation >= 1){
					
					Arc actuel = new Arc(this.sommets.get(i),this.sommets.get(j));
					try{
						actuel.setValuation(m[i][j]);
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
					
					this.arcs.add(actuel);
				}
			}
		}
		
	}
	/**
	 * 
	 * @return
	 */
	public List<Arc> getArcs(){
		return this.arcs;
	}
	/**
	 * 
	 * @return
	 */
	public List<Sommet> getSommets(){
		return this.sommets;
	}
	/**
	 * 
	 */
	public int[][] getMatrice(){
		return this.matrice;
	}
	/**
	 * @return 
	 */
	public String toString(){
		String toReturn = "Le graphe: " + this.nomGraphe +"\n";
		for(Arc a: arcs){
			toReturn += "\t"+a.toString()+"\n";
		}
		return toReturn;
	}
	
	public Graphe inverser()throws Exception{
		int[][] matriceInv = new int[this.matrice.length][this.matrice.length];
		for(int i=0; i <this.matrice.length; i++){
			for(int j=0; j<this.matrice.length; j++){
				matriceInv[j][i]= this.matrice[i][j];
			}
		}
		try{	
			Graphe inv = new Graphe(matriceInv, "Le graphe inversé");
			return inv;
		}catch(Exception e){
			throw new Exception();
		}
	}

}

