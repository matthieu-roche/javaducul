package application;

import java.util.LinkedList;
import java.util.*;
public abstract class Poisson {
	

	
	private int x; //Position
	private int y; // Position
	private int cap; //Capacit� = stockage de nourriture
	private int faim; //Ou ils en sont en terme de nourriture dans leur ventre
	private int vitesse; //vitesse de d�placement
	private int direction;//direction de d�placement
	private int taille; //Taille du poisson
	private int caractere; //agressivit�, douceur etc.. du poisson
	// ajouter l'environnement 
	private Ecosysteme ecosys; //Liste constituant l'ecosyst�me
	
	
	//int alea = new rando.nextInt(max-min+1) + min; // renvoie un nombre al�atoire entre min et max

	public Poisson(int abs, int ord, int t, int cara, int v, int dir, int capa, Ecosysteme eco) {
	        
	    taille = t;
	    //caractere = cara; // ne sert a rien
	    vitesse = v;
	    direction = dir; // ne sert a rien pour l'instant non plus
	    cap = capa;
	    ecosys = eco;
	    x = abs;
	    y = ord;
	    faim = cap; // au debut les poissons n'ont pas faim. Leur ventre est rempli donc la variable faim
	    			// est initialis�e a la capacit� de stockage du poisson.
	    
	    
	    
//	    int min = 0;
//	    int maxX = eco.getTaille_eco()[0];
//	    int maxY = eco.getTaille_eco()[1];
//	    
//	    x = new Random().nextInt(maxX-min+1) + min;
//	    y = new Random().nextInt(maxY-min+1) + min;
//	    System.out.println("Cr�ation d'un poisson en ["+x+","+y+"] !");  
	    
	}
	public abstract void bouger2();
	
	public void manger2(Poisson voisin)
	{
		System.out.println("Un poisson est mang� !"); 
		ecosys.getPoissons().remove(voisin);
		setFaim(this.cap); // on remet le compteur faim du poisson au max (capacit�)
	}
	
	
//	public int observer()
//	{//System.out.println("Poisson observe !"); 
//	
//	int pos = 0 ;
//	int[] coord = new int[2];
//	
//	int dist = 100000; //Grande valeur pour initialisation du minimum
//	for (int j=0;j<ecosys.getPoissons().size();j++){
//		Poisson voisin = ecosys.getPoissons().get(j);
//		int d = Math.abs(this.x-voisin.x) + Math.abs(this.y-voisin.y);
//		if (d < dist) {if (this != voisin){
//		dist = d;
//		pos = j;
//		}}
//		}
//	
//	Poisson voisin = ecosys.getPoissons().get(pos);
//	coord[0] = voisin.getAbs();
//	coord[1] = voisin.getOrd();
//	
//	
//	if ( this.caractere > voisin.caractere) {
//	System.out.println("le poisson le plus proche se trouve en ["+coord[0]+","+coord[1]+"] !");
//	return pos;}
//	
//	else { 
//		System.out.println("le poisson le plus proche n'est pas mangeable !");
//	return 0;
//	}
//	
//	}
	
	public Poisson observer2()
	{//System.out.println("Poisson observe !"); 
	
	int pos = 0 ;
	int[] coord = new int[2];
	
	int dist = 100000; //Grande valeur pour initialisation du minimum
	for (int j=0;j<ecosys.getPoissons().size();j++){
		Poisson voisin = ecosys.getPoissons().get(j);
		int d = Math.abs(this.x-voisin.x) + Math.abs(this.y-voisin.y);
		if (d < dist) {if (this != voisin){
		dist = d;
		pos = j;
		}}
		}
	
	Poisson voisin = ecosys.getPoissons().get(pos);
	coord[0] = voisin.getAbs();
	coord[1] = voisin.getOrd();
	System.out.println("le poisson le plus proche se trouve en ["+coord[0]+","+coord[1]+"] !");
	return voisin;
	
	}
	
	
//	
//	public void viser()
//	{//System.out.println("Poisson observe !"); 
//	
//	int pos = 0 ;
//	int[] coord = new int[2];
//	
//	int dist = 100000; //Grande valeur pour initialisation du minimum
//	for (int j=0;j<ecosys.getPoissons().size();j++){
//		Poisson voisin = ecosys.getPoissons().get(j);
//		int d = Math.abs(this.x-voisin.x) + Math.abs(this.y-voisin.y);
//
//		if (d < dist && d < 10) {if (this != voisin){ // Cette condition est a verifier.. je n'arrive pas !
//		dist = d;
//		System.out.println(dist);
//		pos = j;
//		}}
//	}
//	
//	Poisson voisin = ecosys.getPoissons().get(pos);
//	coord[0] = voisin.getAbs();
//	coord[1] = voisin.getOrd();
//
//	
//	if ( this.caractere > voisin.caractere) {
//	System.out.println("le poisson ["+coord[0]+","+coord[1]+"] va etre mang�!");
//	ecosys.getPoissons().remove(voisin);}
//	
//	else { 
//		System.out.println("le poisson le plus proche n'est pas mangeable ou trop loin !");
//
//	}
//	
//	}
	
	
	
	
	
	
	public int[] find_pos_poisson(int j ) {
		
		
		int[] tab = new int [2];
		int a = getAbs();
		int b = getOrd();
		System.out.println("Nouvelle position  [" + a + " , " + b + "]" );
		
		tab[0]=a;
		tab[1] = b;
		return tab;
		
	}
	
	

//	public void Observer(LinkedList <Poisson> poisson) {
//		//Si le poisson de la liste est a une distance d < 1 
//		// Renvoie les voisins les plus proches
//	
//	public void Viser(LinkedList <Poisson> poisson) { //prend en arguemnt une liste de poisson gener� par Observer
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
	
	public Ecosysteme getEco() {
		return ecosys;
	}
	public String toString() {
		return "je suis en " + x + "," + y + "je peux rester "+faim+" tours sans manger, j'ai une vitesse de "+vitesse+" et j ai une direction de "+direction+" , un caractere de "+caractere+" \n";
				
				
	}
	
}

