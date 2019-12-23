package application;

import java.util.LinkedList;
import java.util.*;
public abstract class Poisson {
	
	private int x; //Position
	private int y; // Position
	private int cap; //Capacité = stockage de nourriture
	private int faim; //Ou ils en sont en terme de nourriture dans leur ventre
	private int vitesse; //vitesse de déplacement
	private int direction;//direction de déplacement
	private int taille; //Taille du poisson
	private int caractere; //agressivité, douceur etc.. du poisson
	// ajouter l'environnement 
	private Ecosysteme ecosys; //Liste constituant l'ecosystème
	
	
	//int alea = new rando.nextInt(max-min+1) + min; // renvoie un nombre aléatoire entre min et max

	public Poisson(int abs, int ord, int t, int cara, int v, int dir, int capa, Ecosysteme eco) {
	        
	    taille = t;
	    caractere = cara;
	    vitesse = v;
	    direction = dir;
	    cap = capa;
	    ecosys = eco;
	    x = abs;
	    y = ord;
	    
	    
//	    int min = 0;
//	    int maxX = eco.getTaille_eco()[0];
//	    int maxY = eco.getTaille_eco()[1];
//	    
//	    x = new Random().nextInt(maxX-min+1) + min;
//	    y = new Random().nextInt(maxY-min+1) + min;
//	    System.out.println("Création d'un poisson en ["+x+","+y+"] !");  
	    
	}
	public abstract void manger();
	public abstract void bouger();
	
	public int observer()
	{//System.out.println("Poisson observe !"); 
	
	int pos = 0 ;
	int[] coord = new int[2];
	
	int dist = 100000; //Grande valeur pour initialisation du minimum
	for (int j=0;j<ecosys.getPoissons().size();j++){
		Poisson voisin = ecosys.getPoissons().get(j);
		int d = Math.abs(this.x-voisin.x) + Math.abs(this.y-voisin.y);
		if (d < dist ) {if (this != voisin){
		dist = d;
		pos = j;
		}}
	}
	
	Poisson voisin = ecosys.getPoissons().get(pos);
	coord[0] = voisin.getAbs();
	coord[1] = voisin.getOrd();
	
	//System.out.println("le poisson le plus proche se trouve en ["+coord[0]+","+coord[1]+"] !");
	
	return pos;
	
	
	
	}
	
	public int[] find_pos_poisson(int j ) {
		
		
		int[] tab = new int [2];
		int a = getAbs();
		int b = getOrd();
		System.out.println("posx vaut " + a + " posy vaut " + b );
		
		tab[0]=a;
		tab[1] = b;
		return tab;
		
	}
	
	

//	public void Observer(LinkedList <Poisson> poisson) {
//		//Si le poisson de la liste est a une distance d < 1 
//		// Renvoie les voisins les plus proches
//	
//	public void Viser(LinkedList <Poisson> poisson) { //prend en arguemnt une liste de poisson generé par Observer
//			//Si le poisson de la liste est a une distance d < 1 
//			// Renvoie les voisins les plus proches
//		

	public int getAbs() {
		return x;
	}


	public void setAbs(int x) {
		this.x = x;
	}


	public int getOrd() {
		return y;
	}


	public void setOrd(int y) {
		this.y = y;
	}


	public int getCap() {
		return cap;
	}


	public void setCap(int cap) {
		this.cap = cap;
	}


	public int getFaim() {
		return faim;
	}


	public void setFaim(int faim) {
		this.faim = faim;
	}


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}


	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	} 

	public String toString() {
		return "je suis en " + x + "," + y + "je peux rester "+faim+" tours sans manger, j'ai une vitesse de "+vitesse+" et j ai une direction de "+direction+" , un caractere de "+caractere+" \n";
				
				
	}
	
}

