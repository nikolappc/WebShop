/***********************************************************************
 * Module:  Webshop.java
 * Author:  MIjat
 * Purpose: Defines the Class Webshop
 ***********************************************************************/
package Model;
import java.util.*;

public class Webshop  {
   public Collection<ContentMenadzer> contentMenadzeri;
   public Collection<StavkaCenovnika> stavkeCenovnika;
   public Collection<Kategorija> kategorije;
   public Collection<Proizvod> proizvodi;
   public Collection<Kupac> kupci;
   public Collection<Narudzbina> narudzbine;

   public Webshop() {
      // TODO: ovde pozovi ucitavanje svega
   }

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


   // KATEGORIJA

   public Collection<Kategorija> getKategorije() {
      if (kategorije == null)
         kategorije = new LinkedList<Kategorija>();
      return kategorije;
   }

   public void addKategorija(Kategorija newKategorija) {
      if (newKategorija == null)
         return;
      if (this.kategorije == null)
         this.kategorije = new LinkedList<Kategorija>();
      if (!this.kategorije.contains(newKategorija))
         this.kategorije.add(newKategorija);
   }

   public void removeKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.kategorije != null)
         if (this.kategorije.contains(oldKategorija))
            this.kategorije.remove(oldKategorija);
   }

   public void removeAllKategorije() {
      if (kategorije != null)
         kategorije.clear();
   }

   // PROIZVOD

   public Collection<Proizvod> getProizvodi() {
      if (proizvodi == null)
         proizvodi = new java.util.HashSet<Proizvod>();
      return proizvodi;
   }

   public void setProizvodi(Collection<Proizvod> newProizvod) {
      removeAllProizvod();
      for (java.util.Iterator iter = newProizvod.iterator(); iter.hasNext();)
         addProizvod((Proizvod)iter.next());
   }

   public void addProizvod(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.proizvodi == null)
         this.proizvodi = new LinkedList<Proizvod>();
      if (!this.proizvodi.contains(newProizvod))
         this.proizvodi.add(newProizvod);
   }

   public void removeProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.proizvodi != null)
         if (this.proizvodi.contains(oldProizvod))
            this.proizvodi.remove(oldProizvod);
   }

   public void removeAllProizvod() {
      if (proizvodi != null)
         proizvodi.clear();
   }

   // KUPAC

   public Collection<Kupac> getKupci() {
      if (kupci == null)
         kupci = new LinkedList<Kupac>();
      return kupci;
   }

   public void setKupci(Collection<Kupac> newKupci) {
      removeAllKupci();
      for (Iterator iter = newKupci.iterator(); iter.hasNext();)
         addKupac((Kupac)iter.next());
   }
   
   public void addKupac(Kupac newKupac) {
      if (newKupac == null)
         return;
      if (this.kupci == null)
         this.kupci = new LinkedList<Kupac>();
      if (!this.kupci.contains(newKupac))
         this.kupci.add(newKupac);
   }
   
   public void removeKupac(Kupac oldKupac) {
      if (oldKupac == null)
         return;
      if (this.kupci != null)
         if (this.kupci.contains(oldKupac))
            this.kupci.remove(oldKupac);
   }
   
   public void removeAllKupci() {
      if (kupci != null)
         kupci.clear();
   }

   // MENADZER

   public Collection<ContentMenadzer> getContentMenadzeri() {
      if (contentMenadzeri == null)
         contentMenadzeri = new LinkedList<ContentMenadzer>();
      return contentMenadzeri;
   }

   public void setContentMenadzeri(Collection<Kupac> newContentMenadzeri) {
      removeAllContentMenadzeri();
      for (java.util.Iterator iter = newContentMenadzeri.iterator(); iter.hasNext();)
         addContentMenadzer((ContentMenadzer)iter.next());
   }

   public void addContentMenadzer(ContentMenadzer contentMenadzer) {
      if (contentMenadzer == null)
         return;
      if (this.contentMenadzeri == null)
         this.contentMenadzeri = new LinkedList<ContentMenadzer>();
      if (!this.contentMenadzeri.contains(contentMenadzer))
         this.contentMenadzeri.add(contentMenadzer);
   }

   public void removeContentMenadzer(ContentMenadzer oldContentMenadzer) {
      if (oldContentMenadzer == null)
         return;
      if (this.contentMenadzeri != null)
         if (this.contentMenadzeri.contains(oldContentMenadzer))
            this.contentMenadzeri.remove(oldContentMenadzer);
   }

   public void removeAllContentMenadzeri() {
      if (contentMenadzeri != null)
         contentMenadzeri.clear();
   }

   // NARUDZBINA

   public Collection<Narudzbina> getNarudzbine() {
      if (narudzbine == null)
         narudzbine = new LinkedList<Narudzbina>();
      return narudzbine;
   }

   public void setNarudzbine(Collection<Narudzbina> newNarudzbine) {
      removeAllNarudzbine();
      for (java.util.Iterator iter = newNarudzbine.iterator(); iter.hasNext();)
         addNarudzbina((Narudzbina)iter.next());
   }
   
   public void addNarudzbina(Narudzbina newNarudzbina) {
      if (newNarudzbina == null)
         return;
      if (this.narudzbine == null)
         this.narudzbine = new LinkedList<Narudzbina>();
      if (!this.narudzbine.contains(newNarudzbina))
         this.narudzbine.add(newNarudzbina);
   }
   
   public void removeNarudzbina(Narudzbina oldNarudzbina) {
      if (oldNarudzbina == null)
         return;
      if (this.narudzbine != null)
         if (this.narudzbine.contains(oldNarudzbina))
            this.narudzbine.remove(oldNarudzbina);
   }
   
   public void removeAllNarudzbine() {
      if (narudzbine != null)
         narudzbine.clear();
   }

}