package Model;


import View.Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Sadrzi staticke metode za pretragu svega sto se pretrazivavti moze
 */
public class Pretraga {

    /**
     * Trazenje korisnika na osnovu korisnickog imena, prvo trazi u listi kupaca
     * zatim u listi menadzera
     * @param kupci lista kupaca
     * @param korisnicko lista menadzera
     * @return objekat UlogovanKorisnik koji predstavlja ili kupca ili menadzera
     */
    public static UlogovaniKorisnik pretragaKupacaKorisnicko(Collection<Kupac> kupci,
            Collection<ContentMenadzer> menadzeri, String korisnicko){

        for(Kupac kupac : kupci){
            if(kupac.getKorIme().equals(korisnicko)){
                return kupac;
            }
        }

        for(ContentMenadzer cm : menadzeri){
            if(cm.getKorIme().equals(korisnicko)){
                return cm;
            }
        }
        return null;
    }

    /**
     * Pretrazuje kupce po email-u
     * @param kupci
     * @param email
     * @return kupac
     */
    public static Kupac pretragaKupacaEmail(Collection<Kupac> kupci, String email){
        for(Kupac kupac : kupci){
            if(kupac.getEmail().equals(email)){
                return kupac;
            }
        }
        return null;
    }


    /* Pretraga proizvoda */

    /**
     * Pretrazuje proizvode po svim atributima, cim nadje neko poklapanje
     * dodaje ga u listu i prelazi na sledeci proizvod
     * @param proizvodi lista svih proizvoda
     * @param parametar
     * @return
     */
    public static List<Proizvod> pretragaProizvoda(
            Collection<Proizvod> proizvodi, String parametar){

        List<Proizvod> rezultat = new ArrayList();

        parametar = parametar.toLowerCase();
        for(Proizvod proizvod: proizvodi){
            if (proizvod.getNaziv().toLowerCase().contains(parametar) ||
                    proizvod.getOpis().toLowerCase().contains(parametar)) {
                rezultat.add(proizvod);
                continue;
            }

            /*
            Ako nije naso poklapanje po opisu i nazivu
            onda proverava atribute kategorije
             */
            if(proizvodSadrziVrednost(proizvod, parametar)){
                proizvodi.add(proizvod);
            }
        }

        return rezultat;
    }

    /**
     * Pomocna metoda koja se koristi u pretragaProizvoda()
     * Proverava da li proizvod sadrzi parametar pretrage u
     * nekom od atributa koje je dobio od kategorije.
     * @param proizvod
     * @param parametar
     * @return
     */
    private static boolean proizvodSadrziVrednost(Proizvod proizvod, String parametar){
        Collection<String> listaAtributa = proizvod.getAtributi().keySet();
        for(String atribut: listaAtributa){
            // uzmima vrednost atributa
            if(proizvod.getAtributi().get(atribut).sadrziVrednost(parametar)){
                return true;
            }
        }
        return false;
    }

    /**
     * Pretrazuje proizvode po brendu.
     * @param proizvodi
     * @param parametar
     * @return
     */
    public static List<Proizvod> pretragaProizvodBrend(
            Collection<Proizvod> proizvodi, String parametar){

        parametar = parametar.toLowerCase();
        ArrayList<Proizvod> rezultat = new ArrayList();
        for(Proizvod proizvod: proizvodi){
            // moze da proizvood.getatribut da vrati null
            try{
                if(proizvod.getAtributVrednost("Brend").toLowerCase().equals(parametar)){
                    rezultat.add(proizvod);
                }
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }

        return rezultat;
    }

    /**
     * Vraca listu proizvoda koji pripadaju datoj kategoriji.
     * Ide samo do drugog nivoa kategorije nema ni jednog nizeg nivoa
     * @param kategorije
     * @param nazKategorije
     * @return
     */
    public static List<Proizvod> pretragaProzvodaKategorija(
            Collection<Kategorija> kategorije, String nazKategorije) {

        for (Kategorija k1 : kategorije) {
            for (Kategorija k2 : k1.getPodKategorija()) {
                if (k2.getNaziv().equals(nazKategorije)) {
                    return k2.getProizvodi();
                }
            }
        }

        return null;
    }



    /**
     * Vraca listu proizvoda koji pripadaju kategoriji na datoj putanji koja je predstavljena listom stringova
     * @param putanja
     * @return
     */
    public static List<Proizvod> pretraziKategorije(List<String> putanja) {
        return pretraziKategorijeRekurzivno(Main.webshop.getKategorije() ,putanja,0);
    }

    private static List<Proizvod> pretraziKategorijeRekurzivno(Collection<Kategorija> kategorije, List<String> putanja, int i) {
        if (i>=putanja.size()){
            return new LinkedList<>();
        }
        for (Kategorija k:kategorije){
            if (k.getNaziv().equals(putanja.get(i))){
                i++;
                if (i==putanja.size()){
                    return k.getProizvodi();
                }
                return pretraziKategorijeRekurzivno(k.getPodKategorija(),putanja,i);
            }
        }
        return new LinkedList<>();
    }

    /**
     * Trazi kategoriju sa datim nazivo
     * @param kategorije
     * @param naziv
     * @return vraca kategoriju ako postoji, null u suprotnom
     */
    public static Kategorija traziKategoriju(Collection<Kategorija> kategorije, String naziv){
        for(Kategorija k1: kategorije){
            if(k1.getNaziv().equals(naziv)){
                return k1;
            }

            for(Kategorija k2 : k1.getPodKategorija()){
                if(k2.getNaziv().equals(naziv)){
                    return k2;
                }
            }
        }

        return null;
    }

    /**
     * Prvo moram da pisem dokumentaciju da bih mogao da iskucam metodu
     * Pomocna metoda za pretragu narudzbine
     * @param NarudzbinaID
     * @return narudzbina
     */
    public static Narudzbina pretragaNarudzbine(int NarudzbinaID, List<Narudzbina> narudzbine) {
        for (Narudzbina narudzbina : narudzbine) {
            if(narudzbina.getID() == NarudzbinaID)
                return narudzbina;
        }

        return null;
    }
}

