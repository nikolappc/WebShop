package model;

import java.util.LinkedList;
import java.util.List;

public class WebShop {
    List<Korisnik> korisnici;
    List<Kupac> kupci;

    public WebShop(){
        kupci = new LinkedList<Kupac>();
    }

    boolean dodajKorisnika(Korisnik korisnik) {
        if (korisnici.contains(korisnici)) {
            return false;
        }

        korisnici.add(korisnik);
        return true;
    }

    boolean ukloniKorisnika(Korisnik korisnik) {
        int index = korisnici.indexOf(korisnik);

        if (index > 0) {
            korisnici.remove(index);
            return true;
        }

        return false;
    }

    List<Kupac> pretragaKupaca(String atribut) {
        List<Kupac> rezultat = new LinkedList();
        switch (atribut) {
            case "Korisnicko":
                break;
            case "Ime":
                break;
            case "Prezime":
                break;
            case "Email":
                break;
            case "Adresa":
                break;
        }

        return rezultat;
    }

    void pretragaPoKorImenu(
            String korIme, List<Kupac> rezultat){

        for(Kupac kupac : kupci){
            if(kupac.getKorIme().equals(korIme)){
                rezultat.add(kupac);
            }
        }
    }

    void pretragaPoImenu(
            String ime, List<Kupac> rezultat){
        for(Kupac kupac: kupci){
            if(kupac.getIme().equals(ime)){
                kupci.add(kupac);
            }
        }
    }

    void pretragaPoPrezimenu(
            String prezime, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getPrezime().equals(prezime)){
                rezultat.add(kupac);
            }
        }
    }

    void pretragaPoMailu(String email, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getEmail().equals(email)){
                rezultat.add(kupac);
            }
        }
    }

    void pretragaPoAdresi(String adresa, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getAdresa().equals(adresa)){
                rezultat.add(kupac);
            }
        }
    }

}