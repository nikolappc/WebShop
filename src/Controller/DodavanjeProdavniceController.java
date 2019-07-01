package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import Model.Prodavnica;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class DodavanjeProdavniceController implements Initializable{

	
	@FXML
	private TextField adresa;


	@FXML
	private TextField naziv;
	
	@FXML
	private ImageView slika;
	
	private String path;
	
    @FXML
    void odaberiSliku(ActionEvent event) {
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Odaberi sliku");
    	
    	fileChooser.getExtensionFilters().addAll(
    	         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    	File selectedFile = fileChooser.showOpenDialog(Main.window);
    	 
    	if(selectedFile == null){
    	     //No Directory selected
    	}else{
    		String inPath = selectedFile.getAbsolutePath();
    		String newPath = "./src/slike/slikeProdavnica/" + selectedFile.getName();
    		try {
				napraviKopiju(inPath, newPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		path = newPath;
    		Image im = new Image("file:" + newPath);
    		slika.setImage(im);
    	}
    }
	
    
    void napraviKopiju(String inP, String outP) throws IOException {
    	File in = new File(inP);
		File out = new File(outP);

		Files.copy(in.toPath(),out.toPath(),StandardCopyOption.REPLACE_EXISTING);
    }
    
    @FXML
    void potvrdi(ActionEvent event) {
    	naziv.setPromptText("");
		naziv.setStyle("-fx-text-box-border: grey;");
		adresa.setPromptText("");
		adresa.setStyle("-fx-text-box-border: grey;");
    	if(naziv.getText().equals("")) {
    		naziv.setPromptText("Polje je obavezno");
    		naziv.setStyle("-fx-text-box-border: red;");
    		return;
    	}
    	
    	if(adresa.getText().equals("")) {
    		adresa.setPromptText("Polje je obavezno");
    		adresa.setStyle("-fx-text-box-border: red;");
    		return;
    	}
    	
    	napraviProdavnicu();
    	promeniScenu();
    }
    
    private void promeniScenu() {
    	obavestenjeUspesno();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\AdminMain.fxml"));
    	Parent root;
		try {
			root = (Parent) loader.load();
			AdminKontroler pc = loader.getController();
	        Main.scene.setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private void obavestenjeUspesno() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Uspesno ste kreirali prodavnicu");
    	alert.setHeaderText(null);
    	alert.setContentText("Uspesno ste kreirali prodavnicu");

    	alert.showAndWait();
    }
    
    
    private void napraviProdavnicu() {
    	Prodavnica p = new Prodavnica(naziv.getText(), adresa.getText(), path);
    	Main.webshop.addProdavnica(p);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    
}
