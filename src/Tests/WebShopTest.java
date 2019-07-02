package Tests;

import Controller.PrijavaController;
import Model.Kupac;
import Model.UlogovaniKorisnik;
import Model.Webshop;
import javafx.scene.control.TextField;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class WebShopTest extends TestCase {
    private Webshop webshop;
    private String korIme = "korIme";
    private String loznika = "loznika";
    private Kupac kupac;


    @Before
    public void setUp() throws Exception {
        webshop = new Webshop();
        kupac = new Kupac(korIme, loznika, "ime", "prezime", "adresa", "email");
        webshop.addKupac(kupac);
    }

    @Test
    public void testPrijava(){
        webshop.prijava(korIme, loznika);
        assertEquals(webshop.getUlogovaniKorisnik(), kupac);

    }

    @Test
    public void testRegistracija(){
        Kupac noviKupac = new Kupac(korIme, "sifra", "ie", "prez", "adresa", "mail");
        assertFalse(webshop.addKupac(kupac));
    }

}
