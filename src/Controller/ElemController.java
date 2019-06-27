package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Isporucena;
import Model.Narudzbina;
import Model.Poslata;
import Model.StanjeNarudzbine;
import Model.Vracena;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ElemController implements Initializable {

	@FXML
    private ProgressBar bar;

    @FXML
    private Button poslata;

    @FXML
    private Label labela;

    @FXML
    private Button isporucena;

    @FXML
    private Button vratiDugme;

    
    private Narudzbina narudzbina;

    @FXML
    void vratiDugme(ActionEvent event) {

    }

    @FXML
    void poslataNarudzbina(ActionEvent event) {
    	narudzbina.zavrsenaFaktura();
    	promeniStanje((double) 1/2);
    }

    @FXML
    void isporucenaNarudzbina(ActionEvent event) {
    	narudzbina.porudzbinaStigla(true);
    	promeniStanje((double) 1);
    }
    
    
    void promeniStanje(double d) {
    	bar.setProgress(d);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	
	public void postaviLabelu(int a) {
		labela.setText("ID: " + a);
	}
	
	public void postaviStanje(StanjeNarudzbine s) {
		if (s instanceof Poslata) {
			poslata.setVisible(false);
			promeniStanje((double) 1/2);
		}
		else if (s instanceof Isporucena) {
			poslata.setVisible(false);
			isporucena.setVisible(false);
			labela.setText(labela.getText() + " Isporucena posiljka");			
			promeniStanje((double) 1);
		}
		else if (s instanceof Vracena) {
			promeniStanje((double) 1);
			labela.setText(labela.getText() + " Vracena posiljka");
		}
	}
	
	public void setNarudzbina(Narudzbina n) {
		this.narudzbina = n;
	}
}