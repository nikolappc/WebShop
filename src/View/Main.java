package View;

import Controller.MainController;
import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;


public class Main extends Application {


    public static Stage window;
    public static Scene scene;

    // Glavna instanca WebSHop-a
    public static Webshop webshop;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("PRODAVNICA ");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\glavni.fxml"));
        Parent root = (Parent) loader.load();

        /** BACICE GRESKU AKO SE NE LOADUJE GLAVNI*/
        MainController mc = loader.getController();

        scene = new Scene(root, 1000, 800);

        window.setScene(scene);

        window.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // Upisuje WebShop u JSon
        writeWebShop();
    }

    public static void main(String[] args) {
//        webshop = new Webshop();
//        parseData(webshop);
//        parseUsers();
        //Ucitava WebShop
        loadWebShop();
        launch(args);
    }

    static void loadWebShop() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            webshop = mapper.readValue(new File("Proizvodi\\webshop.json"), Webshop.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeWebShop() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("Proizvodi\\webshop.json"), webshop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void parseUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader("Proizvodi\\kupci.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");
                Kupac kupac = new Kupac(params[0], params[1], params[2], params[3], "", "");
                webshop.addKupac(kupac);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("Proizvodi\\managers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");
                ContentMenadzer menadzer = new ContentMenadzer(params[0], params[1], params[2], params[3]);
                webshop.addContentMenadzer(menadzer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void parseData(Webshop webshop) {
        Kategorija nadKategorija = null, podKategorija = null;

        try (BufferedReader br = new BufferedReader(new FileReader("Proizvodi\\muski.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() <= 1) {
                    continue;
                }
                String[] s = line.trim().split(" ");
                String[] s1 = s[0].split("\\.");
                switch (s1.length) {
                    case 1: {
                        nadKategorija = new Kategorija(s[1].toLowerCase());
                        webshop.addKategorija(nadKategorija);
                        break;
                    }
                    case 2: {
                        podKategorija = new Kategorija(s[1].toLowerCase());
                        if (nadKategorija != null) {
                            nadKategorija.dodajPodKategorija(podKategorija);
                        }
                        podKategorija.setNadKategorija(nadKategorija);
                        break;

                    }
                    case 3: {
                        AtributKategorije atr;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 2; i < s.length; ++i) {
                            stringBuilder.append(s[i]);
                            stringBuilder.append(' ');
                        }
                        String name = stringBuilder.toString().trim();
                        line = br.readLine();
                        String id = line.split(":")[1].trim();

                        line = br.readLine();
                        String brendName = line.split(":")[1].trim();


                        line = br.readLine();
                        String boje = line.split(":")[1].trim();


                        line = br.readLine();

                        int cena = Integer.parseInt(line.split(":")[1].trim());


                        line = br.readLine();
                        String velicine = line.split(":")[1];


                        line = br.readLine();
                        String opis = line.split(":")[1].trim();

                        Proizvod p = new Proizvod(name, opis, new Date(), id, Pol.M);

                        if (podKategorija != null) {
                            podKategorija.dodajProizvod(p);
                        }

                        StavkaCenovnika stavkaCenovnika = new StavkaCenovnika(new Date(), null, cena, 0, p);
                        webshop.addStavkaCenovnika(stavkaCenovnika);


                        Atribut atri;
                        if (podKategorija != null) {
                            atri = podKategorija.napraviAtribut("Velicine",velicine);
                            p.dodajAtribut(atri);
                            atri = podKategorija.napraviAtribut("Brend",brendName);
                            p.dodajAtribut(atri);
                            atri = podKategorija.napraviAtribut("Boja",boje);
                            p.dodajAtribut(atri);
                        }

                        webshop.addProizvod(p);
                        break;
                    }
                    default:

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
