package fr.bull.csg.promethee.persistence;

import javax.ejb.Stateless;

import fr.bull.csg.promethee.model.Mantis;

/**
 * @author Thomas Gueze
 */
@Stateless
public class MantisEntityProvider extends EjbEntityProvider<Mantis>
{
   /** Constructeur. */
   public MantisEntityProvider()
   {
      super(Mantis.class);
   }

}
