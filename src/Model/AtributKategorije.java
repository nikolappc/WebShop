/***********************************************************************
 * Module:  AtributKategorije.java
 * Author:  nklppc
 * Purpose: Defines the Class AtributKategorije
 ***********************************************************************/

import java.util.*;

/** @pdOid 0bd49725-06f1-44ba-9642-9bc2ac07a83c */
public class AtributKategorije {
   /** @pdOid 1d0f579a-97b2-4242-aea1-8fd95200a927 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=VrednostAtributa assc=association27 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<VrednostAtributa> vrednostAtributa;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<VrednostAtributa> getVrednostAtributa() {
      if (vrednostAtributa == null)
         vrednostAtributa = new java.util.HashSet<VrednostAtributa>();
      return vrednostAtributa;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorVrednostAtributa() {
      if (vrednostAtributa == null)
         vrednostAtributa = new java.util.HashSet<VrednostAtributa>();
      return vrednostAtributa.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newVrednostAtributa */
   public void setVrednostAtributa(java.util.Collection<VrednostAtributa> newVrednostAtributa) {
      removeAllVrednostAtributa();
      for (java.util.Iterator iter = newVrednostAtributa.iterator(); iter.hasNext();)
         addVrednostAtributa((VrednostAtributa)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newVrednostAtributa */
   public void addVrednostAtributa(VrednostAtributa newVrednostAtributa) {
      if (newVrednostAtributa == null)
         return;
      if (this.vrednostAtributa == null)
         this.vrednostAtributa = new java.util.HashSet<VrednostAtributa>();
      if (!this.vrednostAtributa.contains(newVrednostAtributa))
      {
         this.vrednostAtributa.add(newVrednostAtributa);
         newVrednostAtributa.setAtributKategorije(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldVrednostAtributa */
   public void removeVrednostAtributa(VrednostAtributa oldVrednostAtributa) {
      if (oldVrednostAtributa == null)
         return;
      if (this.vrednostAtributa != null)
         if (this.vrednostAtributa.contains(oldVrednostAtributa))
         {
            this.vrednostAtributa.remove(oldVrednostAtributa);
            oldVrednostAtributa.setAtributKategorije((AtributKategorije)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllVrednostAtributa() {
      if (vrednostAtributa != null)
      {
         VrednostAtributa oldVrednostAtributa;
         for (java.util.Iterator iter = getIteratorVrednostAtributa(); iter.hasNext();)
         {
            oldVrednostAtributa = (VrednostAtributa)iter.next();
            iter.remove();
            oldVrednostAtributa.setAtributKategorije((AtributKategorije)null);
         }
      }
   }

}