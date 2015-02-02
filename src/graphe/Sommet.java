package graphe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sommet implements Serializable {
	String nom;
	List<Arc> entrant;
	List<Arc> sortant;
	Sommet parent;
	
	/**
	 * Constructeur d'un sommet de nom n. Initialization des deux listes
	 * des arcs vide.
	 * @param n pour nom
	 */
	public Sommet(String n){
		this.nom = n;
		this.entrant= new ArrayList<Arc>();
		this.sortant= new ArrayList<Arc>();
	}
	/**
	 * getter du nom de l'arc.
	 * @return nom
	 */
	public String getNom(){
		return this.nom;
	}
	/**
	 * getter des arcs entrants
	 * @return
	 */
	public List<Arc> getEntrant(){
		return this.entrant;
	}
	/**
	 * getter des arcs sortants
	 * @return
	 */
	public List<Arc> getSortant(){
		return this.sortant;
	}
	/**
	 * getter de tous les arcs adjacents au sommets
	 * @return
	 */
	public List<Arc> getAll(){
		List<Arc> all = new ArrayList<Arc>();
		all.addAll(this.entrant);
		all.addAll(this.sortant);
		return all;
	}
	/**
	 * Ajouter un arc a à la liste des arcs entrants.
	 * Cette procédure est faite pendant la création d'un arc.
	 * @param a
	 */
	public void addArcEntrant(Arc a){
		this.entrant.add(a);
		
	}
	/**
	 * Ajouter un arc a à la liste des arcs sortants.
	 * Cette procédure est faite pendant la création d'un arc.
	 * @param a
	 */
	public void addArcSortant(Arc a){
		this.sortant.add(a);
		
	}
	public String toString(){
		return "Sommet: "+ this.nom;
	}

}
