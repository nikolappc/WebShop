/***********************************************************************
 * Module:  Webshop.java
 * Author:  MIjat
 * Purpose: Defines the Class Webshop
 ***********************************************************************/
package Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.*;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Webshop  {

   public UlogovaniKorisnik ulogovaniKorisnik;

   public static Pretraga pretraga;

   public Collection<ContentMenadzer> contentMenadzeri;
   public Collection<StavkaCenovnika> stavkeCenovnika;
   public Collection<Kategorija> kategorije;
   public Collection<Proizvod> proizvodi;
   public Collection<Kupac> kupci;
   public List<Narudzbina> narudzbine;
   public Collection<Prodavnica> prodavnice;

   public Webshop() {
      // TODO: ovde pozovi ucitavanje svega
   }

   /**
    * Prijavljuje korisnika
    * @param korisnicko
    * @param lozinka
    * @return true ako je uspeno prijavljen, false u suprotnom
    */
   public boolean prijava(String korisnicko, String lozinka){
      UlogovaniKorisnik korisnik =
              pretraga.pretragaKupacaKorisnicko(kupci, contentMenadzeri, korisnicko);

      if(korisnik != null && korisnik.getLozinka().equals(lozinka)){
         ulogovaniKorisnik = korisnik;
         return true;
      }

      return false;
   }
   // STAVKA CENOVNIKA

    public Collection<StavkaCenovnika> getStavkeCenovnika() {
        return stavkeCenovnika;
    }

    public void setStavkeCenovnika(Collection<StavkaCenovnika> stavkeCenovnika) {
        this.stavkeCenovnika = stavkeCenovnika;
    }

    public void addStavkaCenovnika(StavkaCenovnika stavka){
       if(stavka == null)
           return;
       if(this.stavkeCenovnika == null){
           this.stavkeCenovnika = new LinkedList<>();
       }
       if(!this.stavkeCenovnika.contains(stavka)){
           this.stavkeCenovnika.add(stavka);
       }
    }

    public void removeKategorija(StavkaCenovnika stavka) {
        if (stavka == null)
            return;
        if (this.kategorije != null)
            if (this.kategorije.contains(stavka))
                this.kategorije.remove(stavka);
    }

    public void removeAllStavkeCenovnika() {
        if (stavkeCenovnika != null)
            stavkeCenovnika.clear();
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

   public void setContentMenadzeri(Collection<ContentMenadzer> newContentMenadzeri) {
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

   public List<Narudzbina> getNarudzbine() {
      if (narudzbine == null)
         narudzbine = new LinkedList<Narudzbina>();
      return narudzbine;
   }

   public void setNarudzbine(List<Narudzbina> newNarudzbine) {
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
   
   
   //Prodavnice

   public Collection<Prodavnica> getProdavnice() {
      if (prodavnice == null)
         prodavnice = new java.util.HashSet<Prodavnica>();
      return prodavnice;
   }
   

   public void setProdavnice(Collection<Prodavnica> newprodavnice) {
      removeAllProdavnice();
      for (java.util.Iterator iter = newprodavnice.iterator(); iter.hasNext();)
         addProdavnica((Prodavnica)iter.next());
   }
   

   public void addProdavnica(Prodavnica newprodavnice) {
      if (newprodavnice == null)
         return;
      if (this.prodavnice == null)
         this.prodavnice = new java.util.HashSet<Prodavnica>();
      if (!this.prodavnice.contains(newprodavnice))
         this.prodavnice.add(newprodavnice);
   }
   
   
   public void removeProdavnice(Prodavnica oldprodavnice) {
      if (oldprodavnice == null)
         return;
      if (this.prodavnice != null)
         if (this.prodavnice.contains(oldprodavnice))
            this.prodavnice.remove(oldprodavnice);
   }
   
   public void removeAllProdavnice() {
      if (prodavnice != null)
         prodavnice.clear();
   }
   
   
}