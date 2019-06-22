package model;

import java.util.Objects;

public abstract class Korisnik  {
    private String korIme;
    private String lozinka;
    private String ime;
    private String prezime;

    public Korisnik(){
    }

    public Korisnik(String korIme, String lozinka, String ime, String prezime){
        this.korIme = korIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Korisnik(Korisnik other){
        this.korIme = other.korIme;
        this.lozinka = other.lozinka;
        this.ime = other.ime;
        this.prezime = other.prezime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(korIme, korisnik.korIme) &&
                Objects.equals(lozinka, korisnik.lozinka) &&
                Objects.equals(ime, korisnik.ime) &&
                Objects.equals(prezime, korisnik.prezime);
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
