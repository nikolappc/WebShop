/***********************************************************************
 * Module:  Korpa.java
 * Author:  Dusan
 * Purpose: Defines the Class Korpa
 ***********************************************************************/
package Model;
import java.util.*;

/** @pdOid c9c9ddf4-4e3f-45b1-a180-dacf92f4fbf1 */
public class Korpa {
   /** @pdRoleInfo migr=no name=Narudzbina assc=association38 mult=0..1 */
   public Narudzbina narudzbina;
   /** @pdRoleInfo migr=no name=StavkaNarudzbine assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<StavkaNarudzbine> stavkaNarudzbine;
   /** @pdRoleInfo migr=no name=Kupac assc=association7 mult=0..1 side=A */
   public Kupac kupac;
   
   /** @pdOid 68b4056a-f7a9-4464-92e0-32236b2ccd38 */
   public boolean dodajProizvod() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 80e18eff-f504-4d12-9f14-b4d0f40f7a09 */
   public boolean ukloniProizvod() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid 2a5db91d-c4cf-407e-9cfd-f85449467fd2 */
   public boolean izmeniKolicinuZaProizvod() {
      // TODO: implement
      return false;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<StavkaNarudzbine> getStavkaNarudzbine() {
      if (stavkaNarudzbine == null)
         stavkaNarudzbine = new java.util.HashSet<StavkaNarudzbine>();
      return stavkaNarudzbine;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavkaNarudzbine() {
      if (stavkaNarudzbine == null)
         stavkaNarudzbine = new java.util.HashSet<StavkaNarudzbine>();
      return stavkaNarudzbine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavkaNarudzbine */
   public void setStavkaNarudzbine(java.util.Collection<StavkaNarudzbine> newStavkaNarudzbine) {
      removeAllStavkaNarudzbine();
      for (java.util.Iterator iter = newStavkaNarudzbine.iterator(); iter.hasNext();)
         addStavkaNarudzbine((StavkaNarudzbine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaNarudzbine */
   public void addStavkaNarudzbine(StavkaNarudzbine newStavkaNarudzbine) {
      if (newStavkaNarudzbine == null)
         return;
      if (this.stavkaNarudzbine == null)
         this.stavkaNarudzbine = new java.util.HashSet<StavkaNarudzbine>();
      if (!this.stavkaNarudzbine.contains(newStavkaNarudzbine))
         this.stavkaNarudzbine.add(newStavkaNarudzbine);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbine */
   public void removeStavkaNarudzbine(StavkaNarudzbine oldStavkaNarudzbine) {
      if (oldStavkaNarudzbine == null)
         return;
      if (this.stavkaNarudzbine != null)
         if (this.stavkaNarudzbine.contains(oldStavkaNarudzbine))
            this.stavkaNarudzbine.remove(oldStavkaNarudzbine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavkaNarudzbine() {
      if (stavkaNarudzbine != null)
         stavkaNarudzbine.clear();
   }

}