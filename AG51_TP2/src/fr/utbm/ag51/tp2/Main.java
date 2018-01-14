package fr.utbm.ag51.tp2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import fr.utbm.ag51.tp2.src.com.csvreader.*;
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		  // Création d'une file de priorité vide
		Random randomGenerator = new Random();
   int t= 100000;
   int val = 56;
		  FilePriorite fp = new FilePriorite(t);
		  ArrayList tb = new ArrayList(t);
		  for (int i = 0; i < t; i++) {
			  int randomInt = randomGenerator.nextInt(10000);
			  FilePriorite.ajouter(fp, randomInt);
			  tb.ajouterElement(randomInt);
			  
		  } 
		  long debut1 = System.nanoTime();
		  int tete = FilePriorite.retirer(fp);
		  int tp1 = (int) (System.nanoTime()-debut1); 
		  long debut2 = System.nanoTime();
		  tb.enleverElement(val);
		  int tp2 = (int) (System.nanoTime()-debut2); 
		  Excel p = new Excel();
		  p.Write(t,tp1, tp2);
			
    }
	
	}


