package application;

public class Appli {
	public static void main(String[] args) {
		int[] taille = new int[2];
		taille[0] = 540;
		taille[1] = 300;
		Controller c = new Controller();
		Ecosysteme eco = new Ecosysteme(taille,10);
		
	}

}
