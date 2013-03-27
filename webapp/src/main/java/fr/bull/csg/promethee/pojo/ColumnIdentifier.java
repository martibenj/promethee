package fr.bull.csg.promethee.pojo;

/**
 * @author Thomas Gueze
 */
public class ColumnIdentifier
{
   private Object itemId;

   private Object propertyId;

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
