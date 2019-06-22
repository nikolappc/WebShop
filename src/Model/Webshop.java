/***********************************************************************
 * Module:  Webshop.java
 * Author:  MIjat
 * Purpose: Defines the Class Webshop
 ***********************************************************************/
package Model;
import java.util.*;

/** @pdOid a1b0bfae-b37a-43c7-9d63-ec8199eae1fb */
public class Webshop extends ContentMenadzer {
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association16 mult=0..* */
   public StavkaCenovnika[] stavkaCenovnika;
   /** @pdRoleInfo migr=no name=Kategorija assc=association26 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Kategorija> kategorija;
   /** @pdRoleInfo migr=no name=Proizvod assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Proizvod> proizvod;
   /** @pdRoleInfo migr=no name=Kupac assc=association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Kupac> kupac;
   /** @pdRoleInfo migr=no name=Narudzbina assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Narudzbina> narudzbina;
   
   /** @pdOid 5edccd0e-9940-4b84-b08b-328f0b74ff5c */
   public boolean registracija() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid f7beba29-8a95-4de6-bcc4-d839dc0e13ef */
   public boolean dodajProizvod() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 5f3ab7a3-58eb-4171-92a5-cab3884bc7c4 */
   public boolean ukloniProizvod() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 1c841193-6fbb-4473-88e1-22bb0c59a469 */
   public boolean izmeniProizvod() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid c353a4e4-00c0-406a-92ae-84a36265ca18 */
   public boolean dodajKorisnika() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 226e83d2-468f-4532-b5c7-6faa21f7d0a8 */
   public boolean ukloniKorisnika() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 0a354fb3-0e24-4197-8bc4-19a9a7d93ef2 */
   public boolean izmeniKorisnika() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 8eca95cd-d574-4782-a805-66950a090b4f */
   public boolean dodajPorudzibinu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 2c3eee00-ffa4-4783-b710-71a4329e00bc */
   public boolean ukloniPorudzbinu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid aee93ad4-ba52-4a85-b955-f2a6b2cd6420 */
   public boolean izmeniPorudzbinu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid a62ac9e6-596f-4922-9e05-e7c9181ace60 */
   public Proizvod pretragaProizvoda() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 84316a1a-98b1-42c5-bdf8-42c57d2aae9f */
   public Kupac pretragaKorisnika() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid c2261783-04cd-4f43-a78a-587b16905821 */
   public Narudzbina pretragaPorudzbina() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 13a8ef45-e432-473b-bb69-2822e588ff55 */
   public boolean dodajCenu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid e997da29-f9c3-441b-8ae9-dd782ca8600e */
   public boolean ukloniCenu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 4f46c9ba-bdd7-4330-8b5c-d69336061d2f */
   public boolean izmeniCenu() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid d7be7282-9421-4584-b608-bd85d14fbdc0 */
   public StavkaCenovnika pretragaCena() {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
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