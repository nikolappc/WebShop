package Dialog;

import java.util.ArrayList;
import java.util.Optional;

import Model.Kupac;
import View.Main;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class DialogInfo {
	
	public String ime;
	public String prezime;
	public String adresa;
	
	public DialogInfo() {
		
	}
	
	public boolean start() {
		while(true) {
			try {


				Dialog<ArrayList<String>> dialog = new Dialog<>();
				dialog.setTitle("Informacije primaoca");
				dialog.setHeaderText("Informacije primaoca");
		
				// Set the button types.
				ButtonType potvrdaButtonType = new ButtonType("Potvrdi", ButtonData.OK_DONE);
				ButtonType odustaniButtonType = new ButtonType("Odusatani", ButtonData.CANCEL_CLOSE);
				dialog.getDialogPane().getButtonTypes().addAll(potvrdaButtonType, odustaniButtonType);
				
				// Create the username and password labels and fields.
				GridPane grid = new GridPane();
				grid.setHgap(10);
				grid.setVgap(10);
				grid.setPadding(new Insets(20, 150, 10, 10));

				Kupac k = (Kupac) Main.webshop.ulogovaniKorisnik;
				TextField ime = new TextField();
				ime.setText(k.getIme());
				TextField prezime =  new TextField();
				prezime.setText(k.getPrezime());
				TextField adresa =  new TextField();
				adresa.setText(k.getAdresa());
		
				grid.add(new Label("Ime:"), 0, 0);
				grid.add(ime, 1, 0);
				grid.add(new Label("Prezime:"), 0, 1);
				grid.add(prezime, 1, 1);
				grid.add(new Label("Adresa:"), 0, 2);
				grid.add(adresa, 1, 2);
		
		
		
				dialog.getDialogPane().setContent(grid);
				/*
				 * 
				// Request focus on the username field by default.
				Platform.runLater(() -> ime.requestFocus());
				 */
		
				// Convert the result to a username-password-pair when the login button is clicked.
				dialog.setResultConverter(dialogButton -> {
				    if (dialogButton == potvrdaButtonType) {
				    	ArrayList<String> lista = new ArrayList<String>();
				    	lista.add(ime.getText());
				    	lista.add(prezime.getText());
				    	lista.add(adresa.getText());
				        return lista ;
				    }
				    return null;
				});
		
			
				Optional<ArrayList<String>> result = dialog.showAndWait();
				
				if (result == null)
					return false;
				ArrayList<String> lista = result.get();
				
				if(!checkParams(lista)) {
					this.ime = lista.get(0);
					this.prezime = lista.get(1);
					this.adresa = lista.get(2);
					return true;
				}
			
			}catch (Exception e) {
				return false;
			}
		}
	}
	
	private boolean checkParams(ArrayList<String> lista) {
		return (lista.get(0).equals("") || lista.get(1).equals("") || lista.get(2).equals("") );
	}
}
