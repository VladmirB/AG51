package fr.utbm.ag51.tp2;

public class ArrayList {
	private int[] donnees;
	private int nbElements;

	public ArrayList(int t){
		//On initialise notre tableau de donnees en lui donnant une taille egale a capaciteInitiale
		donnees = (int[]) new int[t];
		//On initialise la nombre d'elements a 0
		nbElements = 0;
	}


	
	
	public void ajouterElement(int elt){
		//Si le tableau contenant les donnees est plein, alors on l'agrandit
		if(donnees.length == nbElements){
			int nouveauNbElements = nbElements* 3/2 + 1;
			int[] tempDonnees = donnees;
			donnees = (int[]) new int[nouveauNbElements];
			System.arraycopy(tempDonnees, 0, donnees, 0, nbElements);
		}
		
		//On ajoute le nouvel element au tableau
		donnees[nbElements] = elt;
		nbElements++;
	}
	public int definirElement(int indice, int elt) throws IndexOutOfBoundsException{
		if(indice < 0 || indice > nbElements){
			throw new IndexOutOfBoundsException();
		}
		
		int ancienElt = obtenirElement(indice);
		donnees[indice] = elt;
		
		return ancienElt;
	}
	
	public boolean enleverElement(int elt){
		for(int i = 0; i < nbElements; i++){
			if(donnees[i]==elt){
				//On décale vers la gauche tous les éléments situés après l'élément supprimé
				System.arraycopy(donnees, i+1, donnees, i, nbElements - i - 1);
				nbElements--;
				return true;
			}
		}
		
		return false;
	}
	public int obtenirElement(int indice) throws IndexOutOfBoundsException{
		if(indice < 0 || indice > nbElements){
			throw new IndexOutOfBoundsException();
		}		
		return donnees[indice];
	}
	
	public void viderListe(){
		//Nous assignons la valeur null a l'ensemble des elements de la liste
		for(int i = 0; i < nbElements; i++){
			donnees[i] = 0;
		}
		
		//On retablit le nb d'elements de la liste a 0
		nbElements = 0;
	}
	public String toString(){
		String s = "";
		for(int i = 0; i < nbElements - 1; i++){
			s += donnees[i]+", ";
		}
		if(nbElements > 0){
			s += donnees[nbElements-1];
		}
		
		return s;
	}
}
