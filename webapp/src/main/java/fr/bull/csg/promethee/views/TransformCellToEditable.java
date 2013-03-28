package fr.bull.csg.promethee.views;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Field;

import fr.bull.csg.promethee.pojo.ColumnIdentifier;

import java.util.Map;

/**
 * Listener commun aux cellules d'un tableau pour les rendre éditables.
 * @author Thomas Gueze
 */
@SuppressWarnings("rawtypes")
public class TransformCellToEditable implements ItemClickEvent.ItemClickListener
{

   /** Serial UID. */
   private static final long serialVersionUID = -6474502703947873628L;

   /** Mapping des champs. */
   private final Map<ColumnIdentifier, Field> fields;

   /**
    * Constructeur.
    * @param tableFields Mapping des champs
    */
   public TransformCellToEditable(Map<ColumnIdentifier, Field> tableFields)
   {
      fields = tableFields;
   }

   /** La gestion de l'event par le listener. */
   @Override
   public void itemClick(ItemClickEvent event)
   {
      if (event.isDoubleClick())
      {
         ColumnIdentifier key = new ColumnIdentifier(event.getItemId(), event.getPropertyId());
         if (fields.containsKey(key))
         {
            fields.get(key).setReadOnly(false);
         }
      }
   }
}
