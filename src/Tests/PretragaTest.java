package Tests;

import Model.Pretraga;
import Model.Proizvod;
import Model.Webshop;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PretragaTest extends TestCase {

    @Test
    public void testPretragaProizvoda(){
        Webshop webshop = new Webshop();
        webshop.addProizvod(new Proizvod("naz", "opiscic nazi", null, "Sifra1"));
        webshop.addProizvod(new Proizvod("naziv", "opis", null, "sifra2"));
        List<Proizvod> rez  = Pretraga.pretragaProizvoda(webshop.proizvodi, "naz");
        assertEquals(2, rez.size());
    }
}
