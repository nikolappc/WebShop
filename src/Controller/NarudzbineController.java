package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NarudzbineController implements Initializable {

	
	@FXML
	private VBox vBox;
	
    
    public Parent test() throws Exception {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\N.fxml"));
        Parent root = (Parent) loader.load();
        NarudzbineController pc = loader.getController();
        return root;
    }
	
	private void proba() {
		for (int i = 0; i < 3; i++) {			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ElemNarudzbine.fxml"));
	            HBox hb = (HBox) loader.load();
	            vBox.getChildren().add(hb);
	            
			}catch (Exception e) {
				System.out.println("Neradi");
			}
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		proba();
	}

}
