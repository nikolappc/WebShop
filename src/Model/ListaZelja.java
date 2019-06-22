/***********************************************************************
 * Module:  ListaZelja.java
 * Author:  Stefan
 * Purpose: Defines the Class ListaZelja
 ***********************************************************************/

import java.util.*;

/** @pdOid 7272fa98-cc38-43f9-9a78-4d5fc5f792b0 */
public class ListaZelja {
   /** @pdRoleInfo migr=no name=Proizvod assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Proizvod> proizvod;
   
   /** @pdOid b044451d-56d2-4b43-b589-ef0518c94d15 */
   public void dodajProizvod() {
      // TODO: implement
   }
   
   /** @pdOid 865b2772-d698-4f97-b9f6-15d7e9b1fddf */
   public void obrisiProizvod() {
      // TODO: implement
   }
   
   /** @pdOid d104d1dc-1ffc-4c40-96fa-1b5b6571b4bc */
   public void obavestiOPopustu() {
      // TODO: implement
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

}