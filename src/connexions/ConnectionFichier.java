package connexions;

//import iPane.ES;

import java.io.*;


public class ConnectionFichier<TypeStructure> {
	
	private String nomPhysique; //nom du fichier avec lequel on peut travailler
	
	/**
	 * constructeur avec param
	 * @param nomPhysique
	 */
	public ConnectionFichier(String nomPhysique)
	{
		this.nomPhysique= nomPhysique;
	}
	/**
	 * constructeur par d�ffaut
	 */
	public ConnectionFichier()
	{}
	/**
	 * getter du nom physique qui lie le logiciel avec le fichier
	 * @return
	 */
	public String getNomPhysique() {
		return nomPhysique;
	}
	/**
	 * setter du nomPhysique qui lie le logiciel avec le fichier
	 * @param nomPhysique
	 */
	public void setNomPhysique(String nomPhysique) {
		this.nomPhysique = nomPhysique;
	}
	/**
	 * m�thode de lecture du fichier qui suvegarde la structure sur laquelle ont veut travailler
	 * @return
	 */
	public TypeStructure lire()
	{
		TypeStructure tab = null;
		try {
			FileInputStream fis = new FileInputStream(this.nomPhysique) ;
			ObjectInputStream fichIn = new ObjectInputStream(fis);
			
			tab = (TypeStructure)fichIn.readObject();
			fichIn.close();
		} catch (FileNotFoundException e ) {
			//ES.affiche("lecture fichier","nouveau fichier � cr�er");
		} catch (IOException e){
			//ES.affiche("lecture fichier","problem de lecture");
		} catch (ClassNotFoundException e) {
			//ES.affiche("lecture fichier","le type de la structure n'est pas compatible avec le fichier");
		}
		return tab;
	}
	
	/**
	 * m�thode d'�criture de la structure qui a �t� travailler dnas le fichier
	 * consiste � sauvegarder une nouvelle version de cette structure et � �ffacer la plus ancienne
	 * @return
	 */
	public void ecrire(TypeStructure tab)
	{
		
		try {
			
			FileOutputStream fos = new FileOutputStream(this.nomPhysique);
			ObjectOutputStream fichOut = new ObjectOutputStream(fos);
			fichOut.writeObject((TypeStructure)tab);
			//ES.affiche("�criture fichier","** SAUVEGARDE du FICHIER ** "+nomPhysique);
			fichOut.close();
		} catch (FileNotFoundException e ) {
			//ES.affiche("�criture fichier","nouveau fichier � cr�er");
		} catch (IOException e){
			//ES.affiche("�criture fichier","problem d'ecriture");
		} 
	}
	
	


}