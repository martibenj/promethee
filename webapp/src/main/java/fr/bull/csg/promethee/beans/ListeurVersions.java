package fr.bull.csg.promethee.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Bean relativement inutile actuellement, servant uniquement au POC d'intégration de Spring dans Vaadin.
 * @author martiben
 */
@Component
public class ListeurVersions
{
   /**
    * Liste des versions disponibles.
    * @return La liste des versions disponibles
    */
   public List<String> listerLesVersionsDisponibles()
   {
      List<String> result = new ArrayList<String>();
      result.add("trunk V4 (4.13.1)");
      result.add("trunk V5 (5.2.0)");
      result.add("prod 4.12.6");
      return result;
   }
}
