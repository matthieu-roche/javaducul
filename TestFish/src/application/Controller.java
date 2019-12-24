package application;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	

int[] taille = new int [2]; 
int index ;
int target = 6;
int[] tab2 = new int [40];
int[] tab = new int [40];
public int ns = 0;
private static Random rando = new Random();
private Ecosysteme eco; //prend en argument l'écosystème


public Controller()
{
	/* On créé un controller qui est relié a un écosystème eco 
	 * 
	 * */
	
	taille[0] = 540;
	taille[1] = 300;
 eco = new Ecosysteme(taille, 10);
 
}


/* Toutes ces varibles FXML permettent de relier le code "Controller"
 * à Scene Builder, donc aux fenetres de l'IHM. C'est à dire que si on modifie 
 * dans le code le pane pane1 par exemple, cela va affecter le pane1 de l'IHM.
 * */

@FXML
GridPane button_grid2;

@FXML
Pane pane1;


@FXML
TextField Number_S;

@FXML
TextField Number_M;

@FXML
TextField Number_GR;

@FXML
TextField Number_PR;

@FXML
TextField Number_T;

@FXML
TextField Number_C;

@FXML
HBox hbox;

@FXML
Label Nb_Sardine;

@FXML
Button bnt;

@FXML
VBox vbox;



public void exit(ActionEvent event) {
/* Cette fonction ne sert a rien pour l'instant, à faire a la fin éventuellement
 * 
 * 
 * */
	System.out.println("L'application va se fermer");
	System.exit(0);
}


@FXML
ImageView imageId;


//////////////////////////////////////////////////////////////////////////////////

/* Pour les fontion addButton"Poisson" :
 * 
 * Ces fonctions servent à ajouter une icone "poisson" sur la fenetre de l'IHM. Elles sont utiles en début de jeu 
 * lorsque le joueur choisi son aquarium.
 * Elles pourraient être utile aussi si on ajoutait l'option "Reproduction"
 * à notre aquarium.. Ce qu'on fera peut-etre par la suite

Pour un commentaire ligne à ligne du code, referez vous à la fonction "addButtonSardine"
 * */

/////////////////////////////////////////////////////////////////////////////////


/* Pour les fontion moveButton"Poisson" :
 * 
 * Ces fonctions servent à faire bouger les icones "poissons" sur la fenetre de l'IHM, suivant ce que simule Ecosysteme. Elles sont appelées  
 lorsque le joueur clique sur le bouton "MOVE". (elles sont appelées dans la fonction Move_Poissons associée 
 au boutton MOVE.

 Cette fonction se présente de la même manière que addButton"Poisson", sauf qu'elle ne créée pas de poissons
 supplémentaire dans l'écosystème. 
  */

/////////////////////////////////////////////////////////////////////////////////

public void addButtonSardine(int args[]){
	
	/* Cette fonction sert à ajouter une icone sardine sur la fenetre de l'IHM. */
	
	int a = args[0];
	int b = args[1];

	Image image = new Image(getClass().getResourceAsStream("product_sardine.png")); //On récupère l'image Sardine
	ImageView iv1=new ImageView(image); //Ce format est necessaire pour ajouter l'image au boutton
    iv1.setFitHeight(20); //Taille de l'image définit en testant plusieurs fois
    iv1.setFitWidth(30);
    Button sound_button = new Button(""); //On créé un nouveau boutton
    sound_button.setGraphic(iv1); // On lui ajoute l'image 
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); "); //On met le fond du button transparent 
    sound_button.setLayoutX(a); //Le boutton sera positionné en (a,b)
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button); //On ajoute à la liste des widgets du pane le button "sound_button"
    eco.addSardine(a,b);  //Et enfin on ajoute une sardine à l'écosystème !!
   
}
public void moveButtonSardine(int args[]){

	/* Cette fonction se présente de la même manière que addButtonSardine, sauf qu'elle ne créée pas de poissons
	 * supplémentaire dans l'écosystème. */
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("product_sardine.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(20);
    iv1.setFitWidth(30);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
    
   
}

public void addButtonMaquereau(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("maqro.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(30);
    iv1.setFitWidth(40);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
    eco.addMaquereau(a,b);
   
}
public void moveButtonMaquereau(int args[]){
	int[] tab = new int [2];

	tab[0] = args[0] - 5;
	tab[1] = args[1] - 3;
	Image image = new Image(getClass().getResourceAsStream("maqro.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(30);
    iv1.setFitWidth(40);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(tab[0]);
    sound_button.setLayoutY(tab[1]);
    pane1.getChildren().add(sound_button);
   
}

public void addButtonGRequin(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("Grequin.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(30);
    iv1.setFitWidth(30);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
    eco.addGRequin(a,b);
   
}
public void moveButtonGRequin(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("Grequin.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(30);
    iv1.setFitWidth(30);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
   
}

public void addButtonPRequin(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("Prequin.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(25);
    iv1.setFitWidth(40);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
    eco.addPRequin(a,b);
    
}
public void moveButtonPRequin(int args[]){
	int a = args[0] ;
	int b = args[1] ;
	Image image = new Image(getClass().getResourceAsStream("Prequin.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(25);
    iv1.setFitWidth(40);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
   
    
}

public void addButtonThon(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("product_thon.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(35);
    iv1.setFitWidth(45);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
   
    
}

public void addButtonCrevette(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("crevette.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(20);
    iv1.setFitWidth(30);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);
    eco.addCrevette(a,b);
}
public void moveButtonCrevette(int args[]){
	int a = args[0];
	int b = args[1];
	Image image = new Image(getClass().getResourceAsStream("crevette.png"));
	ImageView iv1=new ImageView(image);
    iv1.setFitHeight(20);
    iv1.setFitWidth(30);
    Button sound_button = new Button("");
    sound_button.setGraphic(iv1);
    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
    sound_button.setLayoutX(a);
    sound_button.setLayoutY(b);
    pane1.getChildren().add(sound_button);  

}


/* Pour les fonctions changeScreenButton :
 * 
 * Ces fonctions servent à passer d'une scene à une autre. Elles sont appelées
 * par le fait de cliquer sur un bouton

  */
public void changeScreenButtonPushed(ActionEvent event) throws IOException
{
    Parent Menu_creation = FXMLLoader.load(getClass().getResource("sample2.fxml")); //On associe le parent Menu_creation au fichier FXML "sample2"
    Scene Menu_creation_scene = new Scene(Menu_creation); //On creer une nouvelle scene à ce parent
    
    //Cette ligne récupere les informations concernant la Stage
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(Menu_creation_scene); //On set la nouvelle scene. > Elle devient la scene courante
    window.show(); //On l'ouvre
}

public void changeScreenButtonPushed2(ActionEvent event) throws IOException
{
    Parent Choix_poissons = FXMLLoader.load(getClass().getResource("sample5.fxml"));
    Scene Choix_poissons_scene = new Scene(Choix_poissons);
    
    //This line gets the Stage information
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(Choix_poissons_scene);
    window.show();
}

public void créerboutonMOVE() {
	/* Cette fonction sert a creer un bouton MOVE. 
	 * Ce bouton sert a faire bouger les poissons
	 * Le bouton move est créer et ajouté sur le pane une fois que les poissons ont été placé par l'utilisateur 
	 * 
	 * 
	 * Cependant, a chaque tour, l'ensemble des widget du Pane est effacé, puis réaffiché avec les nouvelles
	 * positions de chaque poissons
	 * 
	 * Ainsi, à chaque tour, il faut recreer un bouton MOVE, d'ou l'interet d'avoir une fonction 
	 * pour cela !
	  */

Button sound_button = new Button("MOVE"); 
sound_button.setStyle("-fx-background-color: #9ed7ef; "); //On set la couleur du fond à bleu
sound_button.setLayoutX(265); //On positionne le bouton
sound_button.setLayoutY(340);
pane1.getChildren().add(sound_button); //On l'ajoute au pane

sound_button.setOnAction( e -> {
	try {
		Move_poisson();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
} ); //On associe le bouton à la fonction Move_poissons

}





public void AjouterPoissons2(ActionEvent event) throws IOException
{
	/* 
	 *AjouterPoissons2 sert a ajouter les poissons en prenant 
	 *en compte les nombres rentrés par l'utilisateur 
	 *dans les textfield 
	 *==> Elle est appelé lorsque l'on appuie sur le bouton "play"
	 *

	  */ 
	try{
        	int max_x = 550; //C'est le bord du pane
        	int max_y = 300;
        	
        	
            this.ns = Integer.parseInt(Number_S.getText()); //On transforme en entier la chaine de caractere correspondant au nombre dans le textfield
            int nm = Integer.parseInt(Number_M.getText());
            int ngr = Integer.parseInt(Number_GR.getText());
            int npr = Integer.parseInt(Number_PR.getText());
            int nt = Integer.parseInt(Number_T.getText());
            int nc = Integer.parseInt(Number_C.getText());
    

            for (index = 0; index < ns ; index++) { //On ajoute autant de sardine que demandé
       
                int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonSardine(tab2); //La position de la sardine sera completement aléatoire
                
                }
            
          
            
            
            for (index = 0; index < nm ; index++) { //On ajoute autant de maquereau que demandé
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonMaquereau(tab2); //La position du maquereau sera completement aléatoire
  
            }
            
            for (index = 0; index < ngr ; index++) { //Pareil pour les grands requins
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonGRequin(tab2);
            }
            
            for (index = 0; index < npr ; index++) {//Pareil pour les petits requins
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonPRequin(tab2);
            }          
//           
//            for (index = 0; index < nt ; index++) {//Pareil pour les thons
//            	int ale = rando.nextInt(max_x);
//            	int ale2 = rando.nextInt(max_y);
//            	tab2[0] = ale;
//            	tab2[1] = ale2;
//                addButtonThon(tab2);
//                }
//            
            for (index = 0; index < nc ; index++) { //Pareil pour les crevettes
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonCrevette(tab2);
                
            }
                
               hbox.getChildren().remove(Number_S); //On retire les textfields, on ne doit plus y avoir acces une fois les poissons generés
               hbox.getChildren().remove(Number_M);
                hbox.getChildren().remove(Number_GR);
                hbox.getChildren().remove(Number_PR);
                hbox.getChildren().remove(Number_T);
               hbox.getChildren().remove(Number_C);
                vbox.getChildren().remove(bnt);
                
                créerboutonMOVE() ; //On creer un bouton move pour pouvoir par la suite bouger les poissons
                						//Ce bouton MOVE est connecté a la fonction MovePoissons

        }

        catch(NumberFormatException e){
            System.out.println("L'une de vos entrée n'est pas un nombre");
          
           
        }

        
    }




public void Move_poisson() throws IOException {
	/* 
	 *La fonction Move_poissons déplace les poissons sur le pane
	 *(deplace = efface les poissons et les remet a la bonne position)
	 *Elle est appelée par le bouton Move
	 *Elle fait le lien avec Ecosystème, puis qu'elle place les poissons suivant 
	 *la position données par la fonction bouge de chaque poissons
	  */ 
	pane1.getChildren().clear(); //On efface tout le pane
	créerboutonMOVE() ; //On remet un bouton MOVE
	LinkedList <Poisson> POISSONS = eco.getPoissons(); //POISSONS = on recupere la liste de poissons de l'ecosystème
	
	{for (int j=0; j<POISSONS.size(); j++) //On parcours la liste de poissons
		
	{
	Poisson bete = POISSONS.get(j); //On regarde la bete d'indice j
	bete.bouger(); //On la fait bouger
	bete.manger(); //On la fait manger 

	tab = bete.find_pos_poisson(j); //On determine la nouvelle position de la bete j apres ces actions => newpos = tab
	
	if (bete instanceof Sardine) {
		moveButtonSardine(tab)  ;} //Si c'est une sardine, on la place à la position tab
	if (bete instanceof Maquereau) {
		moveButtonMaquereau(tab);}//Si c'est un maquereau, on le place à la position tab
	if (bete instanceof PetitRequin) {
		moveButtonPRequin(tab);}//Si c'est un petit requin, on le place à la position tab
	
	if (bete instanceof GrandRequin) {
		moveButtonGRequin(tab);} //Si c'est un grand requin, on le place à la position tab
	
	if (bete instanceof Crevette) {
		moveButtonCrevette(tab);}//Si c'est une crevette, on le place à la position tab
	
	}
	

	}

//	eco.simule();
	
}


}




