/***********************************************************************
 * Module:  UlogovaniKorisnik.java
 * Author:  Stefan
 * Purpose: Defines the Class UlogovaniKorisnik
 ***********************************************************************/
package Model;
import java.util.*;

public class UlogovaniKorisnik {
   private String korIme;
   private String lozinka;
   private String ime;
   private String prezime;

   public UlogovaniKorisnik(){}

   public UlogovaniKorisnik(String korIme, String lozinka, String ime, String prezime) {
      this.korIme = korIme;
      this.lozinka = lozinka;
      this.ime = ime;
      this.prezime = prezime;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UlogovaniKorisnik that = (UlogovaniKorisnik) o;
      return Objects.equals(korIme, that.korIme);
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