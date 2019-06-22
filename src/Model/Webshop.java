/***********************************************************************
 * Module:  Webshop.java
 * Author:  MIjat
 * Purpose: Defines the Class Webshop
 ***********************************************************************/
package Model;
import java.util.*;

public class Webshop extends ContentMenadzer {
   public StavkaCenovnika[] stavkaCenovnika;
   public java.util.Collection<Kategorija> kategorija;
   public java.util.Collection<Proizvod> proizvod;
   public java.util.Collection<Kupac> kupac;
   public java.util.Collection<Narudzbina> narudzbina;
   
   public boolean registracija() {
      // TODO: implement
      return false;
   }

   public boolean dodajProizvod() {
      // TODO: implement
      return false;
   }
   
   public boolean ukloniProizvod() {
      // TODO: implement
      return false;
   }
   
   public boolean izmeniProizvod() {
      // TODO: implement
      return false;
   }
   
   public boolean dodajKorisnika() {
      // TODO: implement
      return false;
   }
   
   public boolean ukloniKorisnika() {
      // TODO: implement
      return false;
   }
   
   public boolean izmeniKorisnika() {
      // TODO: implement
      return false;
   }
   
   public boolean dodajPorudzibinu() {
      // TODO: implement
      return false;
   }
   
   public boolean ukloniPorudzbinu() {
      // TODO: implement
      return false;
   }
   
   public boolean izmeniPorudzbinu() {
      // TODO: implement
      return false;
   }
   
   public Proizvod pretragaProizvoda() {
      // TODO: implement
      return null;
   }
   
   public Kupac pretragaKorisnika() {
      // TODO: implement
      return null;
   }
   
   public Narudzbina pretragaPorudzbina() {
      // TODO: implement
      return null;
   }
   
   public boolean dodajCenu() {
      // TODO: implement
      return false;
   }
   
   public boolean ukloniCenu() {
      // TODO: implement
      return false;
   }
   
   public boolean izmeniCenu() {
      // TODO: implement
      return false;
   }
   
   public StavkaCenovnika pretragaCena() {
      // TODO: implement
      return null;
   }
   
   
   public java.util.Collection<Kategorija> getKategorija() {
      if (kategorija == null)
         kategorija = new java.util.HashSet<Kategorija>();
      return kategorija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKategorija() {
      if (kategorija == null)
         kategorija = new java.util.HashSet<Kategorija>();
      return kategorija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKategorija */
   public void setKategorija(java.util.Collection<Kategorija> newKategorija) {
      removeAllKategorija();
      for (java.util.Iterator iter = newKategorija.iterator(); iter.hasNext();)
         addKategorija((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public void addKategorija(Kategorija newKategorija) {
      if (newKategorija == null)
         return;
      if (this.kategorija == null)
         this.kategorija = new java.util.HashSet<Kategorija>();
      if (!this.kategorija.contains(newKategorija))
         this.kategorija.add(newKategorija);
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removeKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.kategorija != null)
         if (this.kategorija.contains(oldKategorija))
            this.kategorija.remove(oldKategorija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKategorija() {
      if (kategorija != null)
         kategorija.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Proizvod> getProizvod() {
      if (proizvod == null)
         proizvod = new java.util.HashSet<Proizvod>();
      return proizvod;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvod() {
      if (proizvod == null)
         proizvod = new java.util.HashSet<Proizvod>();
      return proizvod.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProizvod */
   public void setProizvod(java.util.Collection<Proizvod> newProizvod) {
      removeAllProizvod();
      for (java.util.Iterator iter = newProizvod.iterator(); iter.hasNext();)
         addProizvod((Proizvod)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvod */
   public void addProizvod(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.proizvod == null)
         this.proizvod = new java.util.HashSet<Proizvod>();
      if (!this.proizvod.contains(newProizvod))
         this.proizvod.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.proizvod != null)
         if (this.proizvod.contains(oldProizvod))
            this.proizvod.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvod() {
      if (proizvod != null)
         proizvod.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Kupac> getKupac() {
      if (kupac == null)
         kupac = new java.util.HashSet<Kupac>();
      return kupac;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKupac() {
      if (kupac == null)
         kupac = new java.util.HashSet<Kupac>();
      return kupac.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKupac */
   public void setKupac(java.util.Collection<Kupac> newKupac) {
      removeAllKupac();
      for (java.util.Iterator iter = newKupac.iterator(); iter.hasNext();)
         addKupac((Kupac)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKupac */
   public void addKupac(Kupac newKupac) {
      if (newKupac == null)
         return;
      if (this.kupac == null)
         this.kupac = new java.util.HashSet<Kupac>();
      if (!this.kupac.contains(newKupac))
         this.kupac.add(newKupac);
   }
   
   /** @pdGenerated default remove
     * @param oldKupac */
   public void removeKupac(Kupac oldKupac) {
      if (oldKupac == null)
         return;
      if (this.kupac != null)
         if (this.kupac.contains(oldKupac))
            this.kupac.remove(oldKupac);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKupac() {
      if (kupac != null)
         kupac.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Narudzbina> getNarudzbina() {
      if (narudzbina == null)
         narudzbina = new java.util.HashSet<Narudzbina>();
      return narudzbina;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNarudzbina() {
      if (narudzbina == null)
         narudzbina = new java.util.HashSet<Narudzbina>();
      return narudzbina.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNarudzbina */
   public void setNarudzbina(java.util.Collection<Narudzbina> newNarudzbina) {
      removeAllNarudzbina();
      for (java.util.Iterator iter = newNarudzbina.iterator(); iter.hasNext();)
         addNarudzbina((Narudzbina)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNarudzbina */
   public void addNarudzbina(Narudzbina newNarudzbina) {
      if (newNarudzbina == null)
         return;
      if (this.narudzbina == null)
         this.narudzbina = new java.util.HashSet<Narudzbina>();
      if (!this.narudzbina.contains(newNarudzbina))
         this.narudzbina.add(newNarudzbina);
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbina */
   public void removeNarudzbina(Narudzbina oldNarudzbina) {
      if (oldNarudzbina == null)
         return;
      if (this.narudzbina != null)
         if (this.narudzbina.contains(oldNarudzbina))
            this.narudzbina.remove(oldNarudzbina);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbina() {
      if (narudzbina != null)
         narudzbina.clear();
   }

}