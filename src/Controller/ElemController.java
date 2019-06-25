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
    private Button dugme;

    @FXML
    void promeniStanje(ActionEvent event) {
    	bar.setProgress(bar.getProgress() + (double)1/3);
    	dugme.setDisable(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}