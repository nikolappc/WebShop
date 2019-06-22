package model;

import java.util.LinkedList;
import java.util.List;

public class WebShop {
    List<Kupac> kupci;

    public WebShop(){
        kupci = new LinkedList<Kupac>();
    }
    
    public List<Kupac> pretragaKupaca(String atribut, String parametar) {
        List<Kupac> rezultat = new LinkedList();
        switch (atribut) {
            case "Korisnicko":
                pretragaPoKorImenu(parametar, rezultat);
            case "Ime":
                pretragaPoImenu(parametar, rezultat);
                break;
            case "Prezime":
                pretragaPoPrezimenu(parametar, rezultat);
                break;
            case "Email":
                pretragaPoMailu(parametar, rezultat);
                break;
            case "Adresa":
                pretragaPoAdresi(parametar, rezultat);
                break;
        }

        return rezultat;
    }

    public void pretragaPoKorImenu(
            String korIme, List<Kupac> rezultat){

        for(Kupac kupac : kupci){
            if(kupac.getKorIme().equals(korIme)){
                rezultat.add(kupac);
            }
        }
    }

    public void pretragaPoImenu(
            String ime, List<Kupac> rezultat){
        for(Kupac kupac: kupci){
            if(kupac.getIme().equals(ime)){
                kupci.add(kupac);
            }
        }
    }

    public void pretragaPoPrezimenu(
            String prezime, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getPrezime().equals(prezime)){
                rezultat.add(kupac);
            }
        }
    }

    public void pretragaPoMailu(String email, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getEmail().equals(email)){
                rezultat.add(kupac);
            }
        }
    }

    public void pretragaPoAdresi(String adresa, List<Kupac> rezultat){
        for(Kupac kupac : kupci){
            if(kupac.getAdresa().equals(adresa)){
                rezultat.add(kupac);
            }
        }
    }

}