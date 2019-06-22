/***********************************************************************
 * Module:  Kategorija.java
 * Author:  nklppc
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/
package Model;
import java.util.*;

/** @pdOid 4bdfe503-2aca-4c6c-b886-3a2641b9f53b */
public class Kategorija {
   /** @pdOid 31a852a1-044f-4fb8-bab5-23ea953a55b6 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=AtributKategorije assc=association24 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<AtributKategorije> atributKategorije;
   /** @pdRoleInfo migr=no name=Kategorija assc=association23 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Kategorija> PodKategorija;
   /** @pdRoleInfo migr=no name=Kategorija assc=association23 mult=0..1 side=A */
   public Kategorija NadKategorija;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<AtributKategorije> getAtributKategorije() {
      if (atributKategorije == null)
         atributKategorije = new java.util.HashSet<AtributKategorije>();
      return atributKategorije;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAtributKategorije() {
      if (atributKategorije == null)
         atributKategorije = new java.util.HashSet<AtributKategorije>();
      return atributKategorije.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAtributKategorije */
   public void setAtributKategorije(java.util.Collection<AtributKategorije> newAtributKategorije) {
      removeAllAtributKategorije();
      for (java.util.Iterator iter = newAtributKategorije.iterator(); iter.hasNext();)
         addAtributKategorije((AtributKategorije)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAtributKategorije */
   public void addAtributKategorije(AtributKategorije newAtributKategorije) {
      if (newAtributKategorije == null)
         return;
      if (this.atributKategorije == null)
         this.atributKategorije = new java.util.HashSet<AtributKategorije>();
      if (!this.atributKategorije.contains(newAtributKategorije))
         this.atributKategorije.add(newAtributKategorije);
   }
   
   /** @pdGenerated default remove
     * @param oldAtributKategorije */
   public void removeAtributKategorije(AtributKategorije oldAtributKategorije) {
      if (oldAtributKategorije == null)
         return;
      if (this.atributKategorije != null)
         if (this.atributKategorije.contains(oldAtributKategorije))
            this.atributKategorije.remove(oldAtributKategorije);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAtributKategorije() {
      if (atributKategorije != null)
         atributKategorije.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Kategorija> getPodKategorija() {
      if (PodKategorija == null)
         PodKategorija = new java.util.HashSet<Kategorija>();
      return PodKategorija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPodKategorija() {
      if (PodKategorija == null)
         PodKategorija = new java.util.HashSet<Kategorija>();
      return PodKategorija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPodKategorija */
   public void setPodKategorija(java.util.Collection<Kategorija> newPodKategorija) {
      removeAllPodKategorija();
      for (java.util.Iterator iter = newPodKategorija.iterator(); iter.hasNext();)
         addPodKategorija((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public void addPodKategorija(Kategorija newKategorija) {
      if (newKategorija == null)
         return;
      if (this.PodKategorija == null)
         this.PodKategorija = new java.util.HashSet<Kategorija>();
      if (!this.PodKategorija.contains(newKategorija))
      {
         this.PodKategorija.add(newKategorija);
         newKategorija.setNadKategorija(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removePodKategorija(Kategorija oldKategorija) {
      if (oldKategorija == null)
         return;
      if (this.PodKategorija != null)
         if (this.PodKategorija.contains(oldKategorija))
         {
            this.PodKategorija.remove(oldKategorija);
            oldKategorija.setNadKategorija((Kategorija)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPodKategorija() {
      if (PodKategorija != null)
      {
         Kategorija oldKategorija;
         for (java.util.Iterator iter = getIteratorPodKategorija(); iter.hasNext();)
         {
            oldKategorija = (Kategorija)iter.next();
            iter.remove();
            oldKategorija.setNadKategorija((Kategorija)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Kategorija getNadKategorija() {
      return NadKategorija;
   }
   
   /** @pdGenerated default parent setter
     * @param newKategorija */
   public void setNadKategorija(Kategorija newKategorija) {
      if (this.NadKategorija == null || !this.NadKategorija.equals(newKategorija))
      {
         if (this.NadKategorija != null)
         {
            Kategorija oldKategorija = this.NadKategorija;
            this.NadKategorija = null;
            oldKategorija.removePodKategorija(this);
         }
         if (newKategorija != null)
         {
            this.NadKategorija = newKategorija;
            this.NadKategorija.addPodKategorija(this);
         }
      }
   }

}