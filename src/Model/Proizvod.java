/***********************************************************************
 * Module:  Proizvod.java
 * Author:  Stefan
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/
package Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Proizvod {
   private String naziv;
   private String opis;
   private int naStanju;
   private int kupljen;
   private int uListiZelja;
   private Date datumDodavanja;
   private String sifra;
   private Pol pol;
   private Collection<String> slike;

   public Proizvod(){}

   public Proizvod(String naziv, String opis, Date datumDodavanja, String sifra, Pol pol) {
      this.naziv = naziv;
      this.opis = opis;
      this.datumDodavanja = datumDodavanja;
      this.sifra = sifra;
      this.pol = pol;
   }

   public Proizvod(String naziv, String opis, int naStanju, int kupljen, int uListiZelja, Date datumDodavanja, String sifra, Pol pol, Collection<String> slike) {
      this.naziv = naziv;
      this.opis = opis;
      this.naStanju = naStanju;
      this.kupljen = kupljen;
      this.uListiZelja = uListiZelja;
      this.datumDodavanja = datumDodavanja;
      this.sifra = sifra;
      this.pol = pol;
      this.slike = slike;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Proizvod proizvod = (Proizvod) o;
      return Objects.equals(sifra, proizvod.sifra);
   }
   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }

   public String getOpis() {
      return opis;
   }

   public void setOpis(String opis) {
      this.opis = opis;
   }

   public int getNaStanju() {
      return naStanju;
   }

   public void setNaStanju(int naStanju) {
      this.naStanju = naStanju;
   }

   public int getKupljen() {
      return kupljen;
   }

   public void setKupljen(int kupljen) {
      this.kupljen = kupljen;
   }

   public int getuListiZelja() {
      return uListiZelja;
   }

   public void setuListiZelja(int uListiZelja) {
      this.uListiZelja = uListiZelja;
   }

   public Date getDatumDodavanja() {
      return datumDodavanja;
   }

   public void setDatumDodavanja(Date datumDodavanja) {
      this.datumDodavanja = datumDodavanja;
   }

   public String getSifra() {
      return sifra;
   }

   public void setSifra(String sifra) {
      this.sifra = sifra;
   }

   public Pol getPol() {
      return pol;
   }

   public void setPol(Pol pol) {
      this.pol = pol;
   }

   public Collection<String> getSlike() {
      return slike;
   }

   public void setSlike(Collection<String> slike) {
      this.slike = slike;
   }
}