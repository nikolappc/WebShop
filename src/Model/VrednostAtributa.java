/***********************************************************************
 * Module:  VrednostAtributa.java
 * Author:  nklppc
 * Purpose: Defines the Class VrednostAtributa
 ***********************************************************************/

import java.util.*;

/** @pdOid b8adf0ea-3d19-4048-bbb2-39a742989cd4 */
public class VrednostAtributa {
   /** @pdOid 03434c74-0b6d-490e-90d5-1418fa7db5bb */
   private java.lang.Object vrednost;
   /** @pdOid 52d09928-979b-413c-881e-253e90503f52 */
   private TipAtributa tip;
   
   /** @pdRoleInfo migr=no name=Proizvod assc=association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Proizvod> proizvod;
   /** @pdRoleInfo migr=no name=AtributKategorije assc=association27 mult=1..1 side=A */
   public AtributKategorije atributKategorije;
   
   
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
   /** @pdGenerated default parent getter */
   public AtributKategorije getAtributKategorije() {
      return atributKategorije;
   }
   
   /** @pdGenerated default parent setter
     * @param newAtributKategorije */
   public void setAtributKategorije(AtributKategorije newAtributKategorije) {
      if (this.atributKategorije == null || !this.atributKategorije.equals(newAtributKategorije))
      {
         if (this.atributKategorije != null)
         {
            AtributKategorije oldAtributKategorije = this.atributKategorije;
            this.atributKategorije = null;
            oldAtributKategorije.removeVrednostAtributa(this);
         }
         if (newAtributKategorije != null)
         {
            this.atributKategorije = newAtributKategorije;
            this.atributKategorije.addVrednostAtributa(this);
         }
      }
   }

}