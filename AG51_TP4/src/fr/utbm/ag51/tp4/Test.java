package fr.utbm.ag51.tp4;

import java.util.*;

import fr.utbm.ag51.tp4.Excel;
public class Test {
	private static void usage(){
		System.out.println("Usage : Test");
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				if (args.length !=0)
				    usage();
				else {
				    Random alea = new Random();
				    int t = 10000;
				    Graphe[] sommet = new Graphe[t];
				    // creation des sommets
				    for (int i=0; i<sommet.length; i++){
					sommet[i] = new Graphe(i,alea.nextInt(10));
				    }
				    // creation aleatoire des aretes
				    for (int i=0; i<sommet.length; i++)
					for (int j=i+1; j<sommet.length; j++)
					    if (alea.nextBoolean()){
						Graphe.arete(sommet[i],sommet[j]);
					    }
				    // parcours profondeur des sommets
				    
				    long debut1 = System.nanoTime();
				    Graphe.parcoursProfondeur(Arrays.asList(sommet));
				    int tp1 = (int) (System.nanoTime()-debut1);
				    // parcours profondeur des sommets
				   
				    long debut2 = System.nanoTime();
				    Graphe.parcoursLargeur(Arrays.asList(sommet));
				    int tp2 = (int) (System.nanoTime()-debut2);
				    Excel p = new Excel();
					p.Write(t,tp1, tp2);
					System.out.print("done");
				    
	}

	}
}
