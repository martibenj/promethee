package fr.bull.csg.promethee.pojo;

/**
 * Identifiant d'une colonne dans un tableau.
 * @author Thomas Gueze
 */
public class ColumnIdentifier
{
   /** Colonne dans la table. */
   private Object itemId;

   /** Ligne dans la table. */
   private Object propertyId;

   /**
    * Constructeur.
    * @param itemId Colonne dans la table
    * @param propertyId Ligne dans la table
    */
   public ColumnIdentifier(Object itemId, Object propertyId)
   {
      this.itemId = itemId;
      this.propertyId = propertyId;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      ColumnIdentifier that = (ColumnIdentifier) o;

      return that.itemId.equals(itemId) && that.propertyId.equals(propertyId);
   }

   @Override
   public int hashCode()
   {
      int result = itemId != null ? itemId.hashCode() : 0;
      result = 31 * result + (propertyId != null ? propertyId.hashCode() : 0);
      return result;
   }
}
