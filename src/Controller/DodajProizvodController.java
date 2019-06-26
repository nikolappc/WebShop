package Controller;

import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DodajProizvodController implements Initializable {


    @FXML
    private void dodavanjeSlikePritisnuo(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File fajl = fileChooser.showOpenDialog(Main.window);
        String imeProizvoda = fajl.getName();
        System.out.println(imeProizvoda);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
