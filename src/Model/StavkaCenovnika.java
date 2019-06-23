/***********************************************************************
 * Module:  StavkaCenovnika.java
 * Author:  MIjat
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/
package Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StavkaCenovnika {
   private Date datPoc;
   private Date datZav;
   private double cena;
   private double pupust;
   private Proizvod proizvod;

   public StavkaCenovnika() {}

   public StavkaCenovnika(Date datPoc, Date datZav, double cena, double pupust, Proizvod proizvod) {
      this.datPoc = datPoc;
      this.datZav = datZav;
      this.cena = cena;
      this.pupust = pupust;
      this.proizvod = proizvod;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      StavkaCenovnika that = (StavkaCenovnika) o;
      return Objects.equals(datPoc, that.datPoc) &&
              Objects.equals(proizvod, that.proizvod);
   }

   public Date getDatPoc() {
      return datPoc;
   }

   public void setDatPoc(Date datPoc) {
      this.datPoc = datPoc;
   }

   public Date getDatZav() {
      return datZav;
   }

   public void setDatZav(Date datZav) {
      this.datZav = datZav;
   }

   public double getCena() {
      return cena;
   }

   public void setCena(double cena) {
      this.cena = cena;
   }

   public double getPupust() {
      return pupust;
   }

   public void setPupust(double pupust) {
      this.pupust = pupust;
   }

   public Proizvod getProizvod() {
      return proizvod;
   }

   public void setProizvod(Proizvod proizvod) {
      this.proizvod = proizvod;
   }
}