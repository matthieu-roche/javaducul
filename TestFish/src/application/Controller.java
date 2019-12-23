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
private Ecosysteme eco;


 //prend en argument l'écosystème


public Controller()
{
	taille[0] = 540;
	taille[1] = 300;
 eco = new Ecosysteme(taille, 10);
 
}

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
	System.out.println("L'application va se fermer");
	System.exit(0);
}



@FXML
ImageView imageId;



//public void addButton(Button button){
//	
//	AffichePoisson img_poisson = new AffichePoisson(a, b, int id, c, d);
//	pane1.getChildren().add(button); }


public void addButtonSardine(int args[]){
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
    eco.addSardine(a,b);
   
}
public void moveButtonSardine(int args[]){

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
//	if (args[0] - 30 < 0) 
//		{int a = 540;
//		tab[0] = a;}
//	if (args[0] - 30 > 540) 
//	{int a = 0;
//	tab[0] = a;}
//	else 
//		{int a = args[0] - 30;
//		tab[0] = a;}
//	
//	if (args[1] - 10 > 300) 
//	{int b = 0;
//	tab[1] = b;}
//	if (args[1] - 10 < 0) 
//	{int b = 300;
//	tab[1] = b;}
//else 
//	{int b = args[1] - 10;
//	tab[1] = b;}

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

public void changeScreenButtonPushed(ActionEvent event) throws IOException
{
    Parent Menu_creation = FXMLLoader.load(getClass().getResource("sample2.fxml"));
    Scene Menu_creation_scene = new Scene(Menu_creation);
    
    //This line gets the Stage information
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(Menu_creation_scene);
    window.show();
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
	

Button sound_button = new Button("MOVE");
sound_button.setStyle("-fx-background-color: #9ed7ef; ");
sound_button.setLayoutX(265);
sound_button.setLayoutY(340);
pane1.getChildren().add(sound_button);

sound_button.setOnAction( e -> {
	try {
		Move_poisson();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
} );

}



public void AjouterPoissons2(ActionEvent event) throws IOException
{
        try{
        	int max_x = 550;
        	int max_y = 300;
        	
        	
            this.ns = Integer.parseInt(Number_S.getText());
            System.out.println("interieur =" + this.ns);
            int nm = Integer.parseInt(Number_M.getText());
            int ngr = Integer.parseInt(Number_GR.getText());
            int npr = Integer.parseInt(Number_PR.getText());
            int nt = Integer.parseInt(Number_T.getText());
            int nc = Integer.parseInt(Number_C.getText());
    
            System.out.println("Vous avez ajouté " + ns + " Sardines");

            for (index = 0; index < ns ; index++) {
       
                int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonSardine(tab2);
                
                }
            
          
            
            
            for (index = 0; index < nm ; index++) {
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonMaquereau(tab2);
  
            }
            
            for (index = 0; index < ngr ; index++) {
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonGRequin(tab2);
            }
            
            for (index = 0; index < npr ; index++) {
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonPRequin(tab2);
            }          
//           
//            for (index = 0; index < nt ; index++) {
//            	int ale = rando.nextInt(max_x);
//            	int ale2 = rando.nextInt(max_y);
//            	tab2[0] = ale;
//            	tab2[1] = ale2;
//                addButtonThon(tab2);
//                }
//            
            for (index = 0; index < nc ; index++) {
            	int ale = rando.nextInt(max_x);
            	int ale2 = rando.nextInt(max_y);
            	tab2[0] = ale;
            	tab2[1] = ale2;
                addButtonCrevette(tab2);
                
            }
                
               hbox.getChildren().remove(Number_S);
               hbox.getChildren().remove(Number_M);
                hbox.getChildren().remove(Number_GR);
                hbox.getChildren().remove(Number_PR);
                hbox.getChildren().remove(Number_T);
               hbox.getChildren().remove(Number_C);
                vbox.getChildren().remove(bnt);
                
                créerboutonMOVE() ;

        }

        catch(NumberFormatException e){
            System.out.println("L'une de vos entrée n'est pas un nombre");
            
           
        }

        
    }


public void AjouterPoissons3(ActionEvent event) throws IOException {
	
	
    int ns = Integer.parseInt(Number_S.getText());
    int nm = Integer.parseInt(Number_M.getText());
    int ngr = Integer.parseInt(Number_GR.getText());
    int npr = Integer.parseInt(Number_PR.getText());
    int nt = Integer.parseInt(Number_T.getText());
    int nc = Integer.parseInt(Number_C.getText());
	
	int[] taille = new int[2];
	taille[0] = 540;
	taille[1] = 300;


	
}



public void Move_poisson() throws IOException {
	pane1.getChildren().clear();
	créerboutonMOVE() ;
	LinkedList <Poisson> POISSONS = eco.getPoissons();
	
	{for (int j=0; j<POISSONS.size(); j++)
		
	{
	Poisson bete = POISSONS.get(j);
	bete.bouger();
	tab = bete.find_pos_poisson(j);
	
	if (bete instanceof Sardine) {
	moveButtonSardine(tab);}
	if (bete instanceof Maquereau) {
		moveButtonMaquereau(tab);}
	if (bete instanceof PetitRequin) {
		moveButtonPRequin(tab);}
	
	if (bete instanceof GrandRequin) {
		moveButtonGRequin(tab);}
	
	if (bete instanceof Crevette) {
		moveButtonCrevette(tab);}
	
	}
	


	}

	eco.simule();
	
}


}




