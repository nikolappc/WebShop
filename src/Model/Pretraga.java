package Model;

import java.util.Collection;

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
}
