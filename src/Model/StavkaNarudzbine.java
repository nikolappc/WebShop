/***********************************************************************
 * Module:  StavkaNarudzbine.java
 * Author:  Stefan
 * Purpose: Defines the Class StavkaNarudzbine
 ***********************************************************************/
package Model;
import java.util.*;

public class StavkaNarudzbine {
   private int kolicina;
   private double cena;
   private Proizvod proizvod;

   public StavkaNarudzbine() {}

   public StavkaNarudzbine(int kolicina, double cena, Proizvod proizvod) {
      this.kolicina = kolicina;
      this.cena = cena;
      this.proizvod = proizvod;
   }

   public int getKolicina() {
      return kolicina;
   }

   public void setKolicina(int kolicina) {
      this.kolicina = kolicina;
   }

   public double getCena() {
      return cena;
   }

   public void setCena(double cena) {
      this.cena = cena;
   }

   public Proizvod getProizvod() {
      return proizvod;
   }

   public void setProizvod(Proizvod proizvod) {
      this.proizvod = proizvod;
   }
}