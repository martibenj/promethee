package fr.bull.csg.promethee.listener;

import com.vaadin.data.Property;
import com.vaadin.ui.AbstractSelect;

import java.util.List;
import java.util.Map;

/**
 * Property value change listener pour une boite de selection
 * Quand une valeur est changée, la liste est mise à jour avec les valeurs associées
 *
 * @author Thomas Gueze
 */
public class SelectValueChangeListener implements Property.ValueChangeListener
{

   private final AbstractSelect m_Select;

   private Map<String, List<String>> m_Valeurs;

   /**
    * @param p_Select  La boite de selection à valeurs dynamiques
    * @param p_Valeurs Les valeurs associées à la boite de sélection
    */
   public SelectValueChangeListener(AbstractSelect p_Select, Map<String, List<String>> p_Valeurs)
   {
      m_Select = p_Select;
      m_Valeurs = p_Valeurs;
   }

   @Override
   public void valueChange(Property.ValueChangeEvent event)
   {
      // Si la valeur selectionnée est présente dans la liste de valeurs dynamiques
      if (m_Valeurs.containsKey(event.getProperty().getValue()))
      {
         // On supprime les élements courants
         m_Select.removeAllItems();

         // On rajoute tous les élements associé à la valeur selectionnée
         for (String elem : m_Valeurs.get(event.getProperty().getValue()))
         {
            m_Select.addItem(elem);
         }

         // La valeur sélectionnée par défaut est la première de la liste
         m_Select.setValue(m_Valeurs.get(event.getProperty().getValue()).get(0));
      }
   }
}
