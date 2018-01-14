package fr.utbm.ag51.tp2;

class FilePriorite {
	
	  int taille; // Taille courante de la file de priorité
	  int[] tab; // Contenu de la file de priorité
	  /** 
	   * Constructeur de file d'une priorité vide.
	   */
	  FilePriorite(int t) {
	    taille = 0; // La taille initiale est 0
	    tab = new int[t];
	    // Il faut réserver la place du tableau de figures
	  }
	  /**
	   * Teste si la file est vide. 
	   */
	  static boolean estVide(FilePriorite fp) {
	    return fp.taille == 0;
	  }
	  /**
	   * Double la capacité du tableau contenu dans la file passée en argument.
	   */
	  static void etendre(FilePriorite fp) {
	    int[] tmp = new int[2 * fp.tab.length];
	    // Création d'un tableau de capacité double
	    System.arraycopy(fp.tab, 0, tmp, 0, fp.tab.length);
	    // Recopie l'ancien tableau dans le nouveau
	    fp.tab = tmp; // Mise à jour de la référence
	  }
	  
	  static void ajouter(FilePriorite fp, int f) {
	    if (fp.taille == fp.tab.length) { // Si la file est pleine
	      etendre(fp);
	    }
	    int pos = fp.taille;
	    fp.taille++;
	    // Remonter la figure à ajouter dans l'abre tant que la figure à la position
	    // d'insertion est moins profonde.
	    	    
	    while (pos != 0 && fp.tab[(pos - 1) / 2]<= f ) {
	      fp.tab[pos] = fp.tab[(pos - 1) / 2];
	      pos = (pos - 1) / 2;
	    }
	    fp.tab[pos] = f;
	  }
	  /**
	   * Retire la figure en tête de la file fp et la retourne.
	   */
	  static int retirer(FilePriorite fp) {
	    if (fp.taille == 0) {
	      throw new RuntimeException("Le tas est vide !");
	    }
	    int resultat = fp.tab[0];
	    fp.taille--;
	    int pos = 0;
	    // A partir de la racine, descendre la dernière figure de la file dans l'arbre
	    // tant qu'une des figure filles est plus profonde
	    while (true) {
	      int indiceGauche = 2 * pos + 1;
	      if (indiceGauche >= fp.taille) {
	        break;
	      }
	      int indiceDroit = indiceGauche + 1;
	      int indiceInsertion;
	      // Place dans indiceInsertion l'indice de la figure fille la plus profonde
	      if (indiceDroit < fp.taille
	        && fp.tab[indiceGauche]<= fp.tab[indiceDroit]) {
	        indiceInsertion = indiceDroit;
	      } else {
	        indiceInsertion = indiceGauche;
	      }
	      if (fp.tab[indiceInsertion] <= fp.tab[fp.taille]) {
	        break;
	      }
	      fp.tab[pos] = fp.tab[indiceInsertion];
	      pos = indiceInsertion;
	    }
	    fp.tab[pos] = fp.tab[fp.taille];
	    return resultat;
	  }
	  /**
	   * Affiche la liste des figures dans l'ordre du tableau.
	   */
	  static void afficher(FilePriorite fp) {
	    for (int i = 0; i < fp.taille; i++) {
	      System.out.print(fp.tab[i] + "|");
	     
	    }
	  }
	  /**
	   * Constructeur par recopie d'une autre file de priorité.
	   */
	  FilePriorite(FilePriorite fp) {
	    if ( fp == null ) {
	      taille = 0;
	      tab = new int[100];
	    } else {
	      taille = fp.taille;
	      tab = new int[fp.tab.length];
	      System.arraycopy(fp.tab, 0, tab, 0, fp.tab.length);
	    }
	  }
	  
	}

