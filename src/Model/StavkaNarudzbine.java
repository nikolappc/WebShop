/***********************************************************************
 * Module:  StavkaNarudzbine.java
 * Author:  Stefan
 * Purpose: Defines the Class StavkaNarudzbine
 ***********************************************************************/
package Model;
import java.util.*;

public class StavkaNarudzbine {
   private int kolicina;
   private int cena;
   private Proizvod proizvod;
   private String velicina;

   public StavkaNarudzbine() {}

   public StavkaNarudzbine(int kolicina, int cena, Proizvod proizvod, String velicina) {
      this.kolicina = kolicina;
      this.cena = cena;
      this.proizvod = proizvod;
      this.velicina = velicina;
   }


   public int getKolicina() {
      return kolicina;
   }

   public void setKolicina(int kolicina) {
      this.kolicina = kolicina;

   }

   public int getCena() {
      return cena;
   }

   public void setCena(int cena) {
      this.cena = cena;
   }

   public Proizvod getProizvod() {
      return proizvod;
   }

   public void setProizvod(Proizvod proizvod) {
      this.proizvod = proizvod;
   }

   public String getVelicina() {return velicina;}

   public void setVelicina(String nova) { velicina = nova;}

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      StavkaNarudzbine stavka = (StavkaNarudzbine) o;

      return stavka.proizvod == proizvod && stavka.getVelicina() == velicina;
   }
}