package Model;

import java.util.ArrayList;
import java.util.Collection;
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
            String vrednostAtributa = proizvod.getAtributi().get(atribut).getVrednost().toLowerCase();
            if(vrednostAtributa.contains(parametar)){
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
    public static Collection<Proizvod> pretragaProizvodBrend(
            Collection<Proizvod> proizvodi, String parametar){

        ArrayList<Proizvod> rezultat = new ArrayList();
        for(Proizvod proizvod: proizvodi){
            // moze da proizvood.getatribut da vrati null
            try{
                if(proizvod.getAtribut("Brend").equals(parametar)){
                    rezultat.add(proizvod);
                }
            } catch(NullPointerException e){
                e.printStackTrace();
            }
        }

        return rezultat;
    }
}

