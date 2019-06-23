package Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PrijavaController implements Initializable {



    @FXML
    private ComboBox<String> polComboBox;

    @FXML
    private SplitPane splitPane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SplitPane.Divider divider = splitPane.getDividers().get(0);
        divider.positionProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldvalue, Number newvalue )
            {
                divider.setPosition(0.5);
            }
        });

        polComboBox.getItems().clear();
        polComboBox.getItems().addAll("Muski","Zenski");

    }

    @FXML
    void stistuoPrijava(ActionEvent event) {

    }

    @FXML
    void stisnuoZabroavljenaSifra(ActionEvent event) {

    }

    @FXML
    void stisnuoRegistracija(ActionEvent event) {

    }

    @FXML
    void traziPritisnut(ActionEvent event) {

    }

    @FXML
    void pritisnutLogo(ActionEvent event) {

    }

    @FXML
    void nalogPritisnut(ActionEvent event){

    }





}
