/***********************************************************************
 * Module:  VrednostAtributa.java
 * Author:  nklppc
 * Purpose: Defines the Class VrednostAtributa
 ***********************************************************************/
package Model;
import java.util.*;

public class VrednostAtributa {
   private Object vrednost;
   private TipAtributa tip;
   private Collection<Proizvod> proizvodi;
   private AtributKategorije atributKategorije;

   public VrednostAtributa() {}

   public VrednostAtributa(Object vrednost, TipAtributa tip, Collection<Proizvod> proizvodi, AtributKategorije atributKategorije) {
      this.vrednost = vrednost;
      this.tip = tip;
      this.proizvodi = proizvodi;
      this.atributKategorije = atributKategorije;
   }

   public Object getVrednost() {
      return vrednost;
   }

   public void setVrednost(Object vrednost) {
      this.vrednost = vrednost;
   }

   public TipAtributa getTip() {
      return tip;
   }

   public void setTip(TipAtributa tip) {
      this.tip = tip;
   }

   public Collection<Proizvod> getProizvodi() {
      return proizvodi;
   }

   public void setProizvodi(Collection<Proizvod> proizvodi) {
      this.proizvodi = proizvodi;
   }

   public AtributKategorije getAtributKategorije() {
      return atributKategorije;
   }

   public void setAtributKategorije(AtributKategorije atributKategorije) {
      this.atributKategorije = atributKategorije;
   }
}