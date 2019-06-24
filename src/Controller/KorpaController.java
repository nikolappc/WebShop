package Controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Model.StavkaNarudzbine;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KorpaController implements Initializable {




    @FXML
    private ResourceBundle resources;

    
    
    @FXML
    private URL location;

    @FXML
    private VBox leviVBox;
    
    @FXML
    private Button lupa;

    @FXML
    private Button logo;
    
    @FXML
    private VBox desniVBox;

    @FXML
    private SplitPane splitPane1;

    public void pritisnutLogo() {
        /** Korisnik pritisnuo LOGO*/

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
            Parent root = (Parent) loader.load();

            MainController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }


    public void traziPritisnut() {
        /** Korisnik pritisnuo pretragu za proizvode */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Katalog.fxml"));
            Parent root = (Parent) loader.load();

            KatalogController pc = loader.getController();
            pc.prikaziSve();

            Main.scene.setRoot(root);
        }catch (Exception ex){}
    }

    public void nalogPritisnut() {
        /** Korisnik pritisnuo dugme za pregled svog naloga */

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\Prijava.fxml"));
            Parent root = (Parent) loader.load();

            PrijavaController pc = loader.getController();

            Main.scene.setRoot(root);

        }catch (Exception ex){ ex.printStackTrace();}
    }

   
    /* JEDNOG DANA MOZDA BUDE BILO POTREBNO KAD BUDE KONACNO SVE LEPO
    public void test2() {
    	if (Main.webshop.ulogovaniKorisnik == null)
    	{
    		desniVBox.getChildren().add(new Label("Nemate nista u korpi"));
    		return;
    	}
    	for (StavkaNarudzbine sn :Main.webshop.ulogovaniKorisnik.getKorpa().getStavkaNarudzbine()){
			HBox hb = new HBox();
			
			Label l = new Label("Naziv: " + sn.getProizvod().getNaziv());
			hb.getChildren().add(l);
			try {
				String url = sn.getProizvod().getSlike().iterator().next();
				Image image = new Image(new FileInputStream(url));
				hb.getChildren().add(new ImageView(image));
				
			}
			catch (Exception e) {
				hb.getChildren().add(new ImageView());
			}
			
			l = new Label("Kolicina: " + sn.getKolicina());
			hb.getChildren().add(l);
			
			l = new Label("Cena: " + sn.getCena());
			hb.getChildren().add(l);
			
			desniVBox.getChildren().add(hb);
		}
    }
     */
    public void test() {
    	
    	HBox hb = new HBox();
		hb.setSpacing(50);
		Label l = new Label("Naziv: Probam");
		hb.getChildren().add(l);
		try {
			
			hb.getChildren().add(new ImageView());
			
		}
		catch (Exception e) {
			System.out.println("probo");
		}
		
		l = new Label("Kolicina: neka");
		hb.getChildren().add(l);
		hb.getChildren().add(new ImageView());
		l = new Label("Cena: nema");
		hb.getChildren().add(l);
		desniVBox.getChildren().add(hb);
		
		hb = new HBox();
		hb.setSpacing(50);
		l = new Label("Naziv: Probam");
		hb.getChildren().add(l);
		try {
			
			hb.getChildren().add(new ImageView());
			
		}
		catch (Exception e) {
			System.out.println("probo");
		}
		
		l = new Label("Kolicina: neka");
		hb.getChildren().add(l);
		
		l = new Label("Cena: nema");
		hb.getChildren().add(l);
		desniVBox.getChildren().add(hb);
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		test();
	}
}
