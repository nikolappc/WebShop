/***********************************************************************
 * Module:  Kupac.java
 * Author:  Dusan
 * Purpose: Defines the Class Kupac
 ***********************************************************************/

import java.util.*;

/** @pdOid 68e97356-f155-4498-a901-fe9c3d9eb569 */
public class Kupac extends UlogovaniKorisnik {
   /** @pdOid b7306781-c211-4821-a98b-04fec46ada41 */
   private String adresa;
   /** @pdOid 7b4e5e73-09d5-4e24-8382-389ea339c355 */
   private String email;
   
   /** @pdRoleInfo migr=no name=Korpa assc=association7 mult=* */
   public Korpa[] korpa;
   /** @pdRoleInfo migr=no name=ListaZelja assc=association18 mult=0..1 */
   public ListaZelja listaZelja;
   
   /** @pdOid 878d5312-76da-447d-9bae-e2b5ad90bdfc */
   public void naruci() {
      // TODO: implement
   }

}