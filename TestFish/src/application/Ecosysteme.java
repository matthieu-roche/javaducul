package application;

import java.util.*;

public class Ecosysteme {

	private int[] taille_eco;
	private int ng; //nb grands requins
	private int np; //nb petits requins
	private int ns; //nb de sardines
	private int nc; //nb de crevettes
	private int nt; //nb de thons
	private int nb_tour; //nb de tours
	private LinkedList <Poisson> poissons; //liste des poissons

	
public Ecosysteme(int[] taille, int tours)
	  {
	    nb_tour = tours;
	    poissons = new LinkedList <Poisson>();
	    taille_eco = taille;

	  }


public int[] getTaille_eco() {
	return taille_eco;
}


public void setTaille_eco(int[] taille_eco) {
	this.taille_eco = taille_eco;
}



public int getNb_tour() {
	return nb_tour;
}


public void setNb_tour(int nb_tour) {
	this.nb_tour = nb_tour;
}


public LinkedList<Poisson> getPoissons() {
	return poissons;
}


public void setPoissons(LinkedList<Poisson> poissons) {
	this.poissons = poissons;
}
/* Pour les fontion add"Poisson":
 * Ces fonctions ajoutent un poisson d'un certain type a la liste de  poisson de l'écosystème
 * à une certaine position entrée en paramètre.
 * */


public void addSardine(int x, int y) {
	
	poissons.add(new Sardine(x, y, 5, 1, this));
	System.out.println("Une sardine a été ajoutée à la position" + x + "et" + y);
	
}

public void addMaquereau(int x, int y) {
	
	poissons.add(new Maquereau(x, y, 5, 2, this));
	System.out.println("Un maquereau a été ajouté à la position" + x + "et" + y);
	
}

public void addPRequin(int x, int y) {
	
	poissons.add(new PetitRequin(x, y, 5, 3, this));
	System.out.println("Un petit requin a été ajouté à la position" + x + "et" + y);
	
}

public void addCrevette(int x, int y) {
	
	poissons.add(new Crevette(x, y, 5, 0, this));
	System.out.println("Une crevette a été ajoutée à la position" + x + "et" + y);
	
}
public void addGRequin(int x, int y) {
	
	poissons.add(new GrandRequin(x, y, 5, 4, this));
	System.out.println("Un grand requin a été ajouté à la position" + x + "et" + y);
	
}

public void UnTour()
{for (int j=0; j<poissons.size(); j++)
	{Poisson bete = poissons.get(j); // chaque poisson bouge à chaque tour
	bete.bouger();	
	}
}



/** simulation de l'ecosysteme */
public void create(int tab[], int nbs, int nbm, int nbgr, int nbpt, int nbt)
{
	
    for (int i = 0; i < tab.length; i++)
    	{	
    	//genere un entier entre 0 et 49 inclus
		tab[0] = nbs;
		tab[1] = nbm;
		
		}
    for (int i=0 ; i<tab.length ; i++)
	{ System.out.print(tab[i]+" ");
	}
    
    System.out.println();
    
    }

public void simule()
{

 // for (int i=0 ; i<nb_tour ; i++)
    {
	//UnTour();
	System.out.println(poissons);
	System.out.println("je simule un tour");
    }
}






}

