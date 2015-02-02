package graphe;

import java.io.Serializable;

/**
 * La classe Arc permet la cr�ation de liason entre deux sommets
 * appel�s d�but et fin.
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
	 * Constructeur de l'arc d'un sommet d�but � un sommet fin
	 * @param d
	 * @param f
	 */
	public Arc(Sommet d, Sommet f){
		this.debut = d;
		d.addArcSortant(this);
		this.fin = f;
		f.addArcEntrant(this);
		this.valuation = 1;// par d�faut
	}
	/**
	 * getter sommet d�but
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
			throw new Exception("v a une valeur n�gative");
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
