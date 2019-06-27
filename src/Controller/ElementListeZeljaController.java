package Controller;

import Model.Kupac;
import Model.Proizvod;
import Model.StavkaNarudzbine;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ElementListeZeljaController {

    @FXML
    private ImageView slika;

    @FXML
    private Label boja;

    @FXML
    private Label sifra;

    @FXML
    private Label cena,velicina;

    @FXML
    private Label imeProizvoda;

    private StavkaNarudzbine stavka;

    /**
     *  postavlja stavku iz liste zelja
     *  na ekran sa odgovarajucim vrednostima
     */
    public void postavi(StavkaNarudzbine s){
        stavka = s;

        slika.setImage(new Image(stavka.getProizvod().getSlike().get(1)));
        cena.setText(stavka.getProizvod().dajCenu() + " €");
        sifra.setText("Sifra: "+stavka.getProizvod().getSifra());
        boja.setText("Boja: "+stavka.getProizvod().getAtributVrednost("Boja"));
        velicina.setText("Velicina: "+stavka.getVelicina());
        imeProizvoda.setText(stavka.getProizvod().getNaziv());
    }

    /**
     * klikom na sliku proizvoda
     * dolazi do detaljnog prikaza za dati proizvod
     */
    @FXML
    void proizvodKliknut() {

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\Proizvod.fxml"));
            Parent root = (Parent) loader.load();

            ProizvodController mc = loader.getController();
            mc.postaviProizvod(stavka.getProizvod());

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}
    }


    /** brisanje stavke iz liste zelja korisnika*/
    @FXML
    void ukloniPritisnut( ) {

        Kupac kupac = (Kupac) Main.webshop.ulogovaniKorisnik;

        kupac.getListaZelja().izbaciProizvod(stavka);

        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\ListaZelja.fxml"));
            Parent root = (Parent) loader.load();

            ListaZeljaController mc = loader.getController();

            Main.scene.setRoot(root);

        } catch (Exception ex) {ex.printStackTrace();}

    }

    /**
     * korisnik prebacio stavku u korpu
     * stavka se sada brise iz liste zelja
     */
    @FXML
    void dodaoUKorpu() {
        ((Kupac) Main.webshop.ulogovaniKorisnik).getKorpa().dodajProizvod(stavka);

        ukloniPritisnut();

    }

}
