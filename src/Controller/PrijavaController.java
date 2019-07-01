package Controller;

import Model.ContentMenadzer;
import Model.Kupac;
import Model.Pretraga;
import Model.UlogovaniKorisnik;
import View.Main;
import com.sun.mail.smtp.SMTPTransport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



import static View.Main.webshop;

public class PrijavaController implements Initializable {


    // za registraciju
    @FXML
    private TextField imeReg;
    @FXML
    private TextField prezimeReg;
    @FXML
    private TextField emailReg;
    @FXML
    private TextField korisnickoReg;
    @FXML
    private TextField lozinkaReg;
    @FXML
    private TextField pLoznikaReg;
    @FXML
    private TextField adresaReg;
    @FXML
    private TextField brTelefonaReg;
    @FXML
    private ComboBox<String> polComboBox;
    @FXML
    private Label porukaReg;

    @FXML
    private TextField korisnickoPrijava;
    @FXML
    private TextField lozinkaPrijava;
    @FXML
    private Label porukaPrijava;

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
    void stistuoPrijava() {
        ArrayList<TextField> polja = new ArrayList<TextField>(
                Arrays.asList(korisnickoPrijava, lozinkaPrijava));
        porukaPrijava.setText("");

        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);
        // ovo znaci da nije uneo sva polja
        if(polja.size() > 0){
            return;
        }
        
        if(korisnickoPrijava.getText().equals("admin") && lozinkaPrijava.getText().equals("admin")){
        	try {
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\AdminMain.fxml"));
                Parent root = (Parent) loader.load();
                AdminKontroler pc = loader.getController();
                Main.scene.setRoot(root);
                Main.webshop.ulogovaniKorisnik.setKorIme("admin");
                return;
        	}catch (Exception e) {
                e.printStackTrace();
			}
        }

        if(Main.webshop.prijava(korisnickoPrijava.getText(), lozinkaPrijava.getText())){
            try{
                if(Main.webshop.ulogovaniKorisnik instanceof Kupac){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\glavni.fxml"));
                    Parent root = (Parent) loader.load();
                    MainController pc = loader.getController();
                    Main.scene.setRoot(root);
                }else if(webshop.ulogovaniKorisnik instanceof ContentMenadzer){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\View\\MenadzerMain.fxml"));
                    Parent root = (Parent) loader.load();
                    MenadzerKontroler pc = loader.getController();
                    Main.scene.setRoot(root);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            porukaPrijava.setText("Pogresno korisnicko ili lozinka");
        }
    }


    /**
     * Poziva se kada korisnik klikne na dugme Registracija
     * Validuje korisnicki unos i kreira novi nalog ako je
     * unos validan.
     * @param event
     */
    @FXML
    void stisnuoRegistracija(ActionEvent event) {
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(imeReg, prezimeReg, emailReg, korisnickoReg, pLoznikaReg, lozinkaReg));
        porukaReg.setText("");
        resetujBojePolja(polja);
        proveraPraznine(polja);
        oznaciPolja(polja);

        // ovo znaci da nije popunio sva polja
        if(polja.size() > 0){
            return;
        }

        // validacija polja
        boolean ok = proveraEmail();
        ok = (proveraKorisnickog() && ok);
        ok = (proveraLoznike() && ok);
        ok = (proveraBrTelefona() && ok);

        // proveri da li je izabro pol
        if(polComboBox.getValue()==null){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Izaberite pol."));
            ok = false;
        }

        if(ok){
            // dodaj kupca
            Main.webshop.addKupac(new Kupac(korisnickoReg.getText(), lozinkaReg.getText(), imeReg.getText(), prezimeReg.getText(), adresaReg.getText(), emailReg.getText()));

            // ociti polja
            resetujSvaPoljaRegistracije();

            // obavesti korisnika
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nalog uspesno kreiran.");
            alert.setHeaderText("Uspesno ste se registrovali.");
            alert.setContentText("Sada probajte da se prijavite.");
            alert.showAndWait();
        }
    }


    /**
     * Resetuje polja registracije
     */
    private void resetujSvaPoljaRegistracije(){
        ArrayList<TextField> polja = new ArrayList(
                Arrays.asList(imeReg, prezimeReg, emailReg, korisnickoReg,
                              pLoznikaReg, lozinkaReg, adresaReg, brTelefonaReg));
        for(TextField polje : polja){
            polje.setText("");
        }

    }


    /**
     * Proverava validnost i jednistvenost maila
     * i prikazuje odgovarajuce poruke u slucaju da
     * nesto nije u redu.
     * @return true ako je sve ok, false u suprotnom
     */
    private boolean proveraEmail(){
        boolean ok = true;
        // provera validnosti maila
        if(!emailReg.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
            porukaReg.setText("Email nije dobar.");
            emailReg.setStyle("-fx-text-box-border: red;");
            ok = false;
        }

        // proveri jednistvenost maila.
        Kupac kupac = Pretraga.pretragaKupacaEmail(Main.webshop.kupci, emailReg.getText());
        if(kupac != null){
            porukaReg.setText("Email je zauzet.");
            emailReg.setStyle("-fx-text-box-border: red;");
            ok = false;
        }

        return ok;
    }


    /**
     * Proverava jedinstvenost korisnickog
     * @return true ako je ne postoji vec, false  u suprotnom
     */
    private boolean proveraKorisnickog(){
        UlogovaniKorisnik korisnik = Pretraga.pretragaKupacaKorisnicko(
                Main.webshop.kupci, webshop.contentMenadzeri, korisnickoReg.getText());

        if(korisnik != null){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(),"Korisnicko vec postoji."));
            korisnickoReg.setStyle("-fx-text-box-border: red;");
            return false;
        }

        return true;
    }


    /**
     * Uporedjuje loznike
     * @return true ako se poklapaju, false u suprotnom
     */
    private boolean proveraLoznike(){
        if(!lozinkaReg.getText().equals(pLoznikaReg.getText())){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Lozinke se ne poklapaju"));
            lozinkaReg.setStyle("-fx-text-box-border: red;");
            pLoznikaReg.setStyle("-fx-text-box-border: red;");
            return false;
        }
        return true;
    }


    /**
     * Proverava validnost broja telefona
     * @return
     */
    private boolean proveraBrTelefona(){
        if(!brTelefonaReg.getText().matches("^[+]*[0-9]*$")){
            porukaReg.setText(String.format("%s %s", porukaReg.getText(), "Pogresan br tel."));
            brTelefonaReg.setStyle("-fx-text-box-border: red;");
            return false;
        }

        return true;
    }


    /**
     * Proverava da li je uneo text u polja.
     * @param polja - polja koja treba da proveri
     * @return ne vraca nista, radi na prosledjenoj
     * listi
     */
    private void proveraPraznine(ArrayList<TextField> polja){
        for(int i = 0; i < polja.size(); i++){
            if(!polja.get(i).getText().isEmpty()) {
                polja.remove(i);
                i--;
            }
        }
    }


    /**
     * Oznacava zadata polja da su obavezna
     * @param polja lista polja
     */
    private void oznaciPolja(ArrayList<TextField> polja){
        for(TextField polje : polja){
            polje.setStyle("-fx-text-box-border: red;");
            polje.setPromptText("Polje je obavezno.");
        }
    }


    /**
     * Resetuje boje zadatim poljima
     * @param polja - lista polja
     */
    private void resetujBojePolja(ArrayList<TextField> polja){
        for(TextField polje: polja){
            polje.setStyle("");
        }
    }


    /** Zaboravljena sifra */
    @FXML
    void stisnuoZabroavljenaSifra(ActionEvent event) {

        UlogovaniKorisnik u_korisnik = new UlogovaniKorisnik();
        String to = "";
        boolean found = false;
        for(ContentMenadzer c : webshop.getContentMenadzeri()){
            if(c.getKorIme().equals(korisnickoPrijava.getText())){
                to = c.getEmail();
                u_korisnik = c;
                found = true;
                break;
            }
        }

        for(Kupac k : webshop.getKupci()){
            if(k.getKorIme().equals(korisnickoPrijava.getText())){
                to = k.getEmail();
                found = true;
                u_korisnik = k;
                break;
            }
        }

        if(!found){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zaboravljena sifra");
            alert.setHeaderText(null);
            if(korisnickoPrijava.getText().trim().equals(""))
                alert.setContentText("Unesite korisnicko ime prvo");
            else
                alert.setContentText("Ne postoji korisnik sa tim korisnickim imenom!");

            alert.showAndWait();
            return;
        }

        String subject = "Zaboravljena sifra na LOGO LLC";

        // Sadrzaj poruke
        Random r = new Random();
        int sifra = Math.abs(r.nextInt() % 98999 + 10000);
        String content = "Vas kod za log in je: " +sifra;

        posaljiMail(to, subject, content);

        //ako prodje proveru uloguj korisnika
        if(provera(sifra+"", u_korisnik,to))
            stistuoPrijava();
    }


    /**
     * Salje email
     * @param to - adresa na koju salje
     * @param subject - naslov emaila
     * @param content - sadrzaj poruke
     */
    private void posaljiMail( String to, String subject, String content){

        String from = "logollc@yahoo.com";
        String pass ="simsprojekat";
        String host = "smtp.mail.yahoo.com";

        Properties properties = System.getProperties();
        // postavka za mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getDefaultInstance(properties);

        try{

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Naslov poruke
            message.setSubject(subject);

            // Sadrzaj poruke
            message.setText(content);

            // Posalji poruku
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Mail poslat");

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    /**
     * Proverava da li je korisnik uneo dobar kod
     * @param kod - tacan kod
     * @param u - korisnik
     * @param mail - korisnikov mail
     * @return true ako jeste, false ako nije
     */
    private boolean provera(String kod, UlogovaniKorisnik u, String mail){

        for(int i = 0; i < 3; i++) {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Pokusaj "+(i+1)+"/3");
            dialog.setHeaderText("Autentifikacioni kod je poslat na: " + mail);
            dialog.setContentText("Molimo Vas unesite poslati kod:");

            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().trim().equals(kod)) {
                korisnickoPrijava.setText(u.getKorIme());
                lozinkaPrijava.setText(u.getLozinka());
                return true;

            }
        }

        return false;

    }
}
