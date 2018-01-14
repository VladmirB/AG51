package fr.utbm.ag51.tp1;

import fr.utbm.ag51.tp1.Excel;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		  
		Random randomGenerator = new Random();
		int t = 20000;
		 int [] a  =  new  int [t];
		for (  int  i  =  0 ;  i < t ;  i ++ ) 
		{
			int randomInt = randomGenerator.nextInt(10000);
		    a[i]  =  randomInt;
		} 
		Initialisation(a,t);
		
		long debut1 = System.nanoTime();
		Tri_selection(a);
		  int tp1 = (int) (System.nanoTime()-debut1);
		  
		  long debut2 = System.nanoTime();
		  Tri_insertion(a);
		  int tp2 = (int) (System.nanoTime()-debut2); 
	
		  
		  long debut3 = System.nanoTime();
		  Tri_bulles(a);
		  int tp3 = (int) (System.nanoTime()-debut3); 
		  
		  long debut4 = System.nanoTime();
		  Tri_shell(a);
		  int tp4 = (int) (System.nanoTime()-debut4); 
		  
		 
		  long debut5 = System.nanoTime();
		  triRapide(a);
		  int tp5 = (int) (System.nanoTime()-debut5); 
		  
		  long debut6 = System.nanoTime();
		  triFusion(a,0,t-1);
		  int tp6 = (int) (System.nanoTime()-debut6); 
		  
		  long debut7 = System.nanoTime();
		  TriParTas(a);
		  int tp7 = (int) (System.nanoTime()-debut7); 
		   
		  Excel p1 = new Excel();
		  p1.Write(t,tp1, tp2,tp3,tp4,tp5,tp6,tp7);
		  System.out.println("hello");
	}
	static void  Initialisation   (int[] tab,int taille )  
	 {
	   // remplissage aléatoire du tableau 
	   int  n  =  taille ;
	  
	 }

	public static void Tri_selection(int[] tab){
		int  n  =  tab.length - 1 ;
		  for (  int  i  =  1 ;  i  <=  n - 1 ;  i ++ )
		  {  // recommence une sous-suite 
		    int  m  =  i ;  // élément frontière ai = table[ i ]
		    for (  int  j  =  i + 1 ;  j  <=  n ;  j ++ )    // (ai+1, a2, ... , an) 
		     if ( tab[ j ]  <  tab[ m ] )  // aj = nouveau minimum partiel
		      m  =  j  ;  // indice mémorisé
		    int  temp  =  tab[ m ] ;
		    tab[ m ]  =  tab[ i ] ;
		    tab[ i ] =  temp ;              
		  } 
		
	}
	
public static void Tri_bulles(int[] tab){
	int longueur=tab.length;
    boolean permut;
    do
	{
        // hypothèse : le tableau est trié
        permut=false;
        for (int i=0 ; i<longueur-1 ; i++)
        {
            // Teste si 2 éléments successifs sont dans le bon ordre ou non
            if (tab[i] > tab[i+1])
            {
                // s'ils ne le sont pas on échange leurs positions
                //la méthode echanger doit être implémenté
            	Echange(tab[i],tab[i+1]);
                permut=true;
            }
        }
    }
    while(permut);
		
	}
public static void Tri_insertion(int[] tab){
	int cpt;
    int element;
    int tailleLogique= tab.length;
 
    for (int i = 1; i < tailleLogique ; i++)
    {    
        element = tab[i];
        cpt = i - 1;
        while (cpt >= 0 && tab[cpt] > element)
        {
           tab[cpt + 1] = tab[cpt];
           cpt--;
        }
        tab[cpt + 1] = element;
    }
}
public static void Tri_shell(int[] tab){
	 int longueur=tab.length;
     int n=0;
     
     while(n<longueur)
         {
         n=3*n+1;
         }
     
     while(n!=0)
         {
         n=n/3;
         for (int i=n;i<longueur;i++)
             {
             int valeur=tab[i];
             int j=i;

             while((j>(n-1)) && (tab[j-n]>valeur))
                 {
                 tab[j]=tab[j-n];
                 j=j-n;
                 }
             tab[j]=valeur;
             }
         }
     
     }

public static void triRapide(int tableau[])
{
int longueur=tableau.length;
triRapide(tableau,0,longueur-1);
}

private static int partition(int tableau[],int deb,int fin)
{
int compt=deb;
int pivot=tableau[deb];

for(int i=deb+1;i<=fin;i++)
    {
    if (tableau[i]<pivot)
        {
        compt++;
        Echange(tableau[compt],tableau[i]);
        }
    }
Echange(tableau[deb],tableau[compt]);
return(compt);
}

private static void triRapide(int tableau[],int deb,int fin)
{
if(deb<fin)
    {
    int positionPivot=partition(tableau,deb,fin);
    triRapide(tableau,deb,positionPivot-1);
    triRapide(tableau,positionPivot+1,fin);
    }
}

public static void triFusion(int[] tab,int début, int fin){
	int milieu;
	if(début < fin)
	{
		milieu = (début+fin) / 2;
		triFusion(tab, début, milieu);
		triFusion(tab, milieu + 1, fin);
		fusionner (tab, début, milieu, fin);
	}
}
public static void fusionner (int tab[], int début, int milieu, int fin)
{
	int [] old_tab = (int[]) tab.clone(); 
        // tab.clone est tres gourmand en temps d'execution surtout dans un algo recursif
        // il faudrait passer par un tableau temporaire pour stocker les données triées.
        // puis recopier la partie triée a la fin de la méthode.

	int i1 = début; //indice dans la première moitié de old_tab
	int i2 = milieu + 1; // indice dans la deuxième moitié de old_tab
	int i = début; //indice dans le tableau tab

	while (i1 <= milieu && i2 <= fin)
	{
		//quelle est la plus petite tête de liste?
		if(old_tab[i1] <= old_tab[i2])
		{
			tab[i] = old_tab[i1];
			i1++;
		}
		else
		{
			tab[i] = old_tab[i2];
			i2++;
		}
		i++;
	}
	if (i <= fin)
	{
		while(i1 <= milieu)  // le reste de la première moitié
		{
			tab[i] = old_tab[i1];
			i1++;
			i++;
		}
		while(i2 <= fin) // le reste de la deuxième moitié
		{
			tab[i] = old_tab[i2];
			i2++;
			i++;
		}
	}
}
private static void Echange( int a, int b)
{
    int swap = a;
    a = b;
    b = swap;
}


private static void Tamiser(int[] arbre, int noeud, int n)
{
    int k = noeud;
    int j = 2 * k;

    while (j <= n)
    {
        if ((j < n) && (arbre[j] < arbre[j + 1]))
            j++;

        if (arbre[k] < arbre[j])
        {
            Echange( arbre[k],arbre[j]);
            k = j;
            j = 2 * k;
        }
        else
            break;
    }
}

public static void TriParTas(int[] tab)
{
    for (int i = tab.length >> 1; i >= 0; i--)
        Tamiser(tab, i, tab.length - 1);

    for (int i = tab.length - 1; i >= 1; i--)
    {
        Echange(tab[i], tab[0]);
        Tamiser(tab, 0, i - 1);
    }
}
}
