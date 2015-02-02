package graphe;

import java.io.Serializable;

/**
 * La classe Arc permet la création de liason entre deux sommets
 * appelés début et fin.
 * @author Coyotito
 *
 */
public class Arc implements Serializable {
	private Sommet debut;
	private Sommet fin;
	private int valuation;
	//int capacite;
	//int flux;
	/**
	 * Constructeur de l'arc d'un sommet début à un sommet fin
	 * @param d
	 * @param f
	 */
	public Arc(Sommet d, Sommet f){
		this.debut = d;
		d.addArcSortant(this);
		this.fin = f;
		f.addArcEntrant(this);
		this.valuation = 1;// par défaut
	}
	/**
	 * getter sommet début
	 * @return sommet
	 */
	public Sommet getDebut(){
		return this.debut;
	}
	/**
	 * getter du sommet fin
	 * @return sommet
	 */
	public Sommet getFin(){
		return this.fin;
	}
	/**
	 * setter valuation de l'arc
	 * @param v
	 * @throws Exception
	 */
	public void setValuation(int v) throws Exception{
		if(v>0){
			this.valuation=v;
		} else {
			throw new Exception("v a une valeur négative");
		}
	}
	/**
	 * getter de valuation
	 * @return valuation de l'arc
	 */
	public int getValuation(){
		return this.valuation;
	}
	public String toString(){
		return debut.toString()+ " arc vers le "+ fin.toString()+" : "+this.valuation;
	}
	
}
