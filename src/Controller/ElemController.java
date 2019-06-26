package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class ElemController implements Initializable {

    @FXML
    private ProgressBar bar;

    @FXML
    private Button poslata;

    @FXML
    private Button isporucena;

    @FXML
    void poslataNarudzbina(ActionEvent event) {
    	promeniStanje((double) 1.0/3.0);
    }

    @FXML
    void isporucenaNarudzbina(ActionEvent event) {
    	promeniStanje((double) 2.0/3.0);
    }
    
    
    void promeniStanje(double d) {
    	bar.setProgress(d);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}