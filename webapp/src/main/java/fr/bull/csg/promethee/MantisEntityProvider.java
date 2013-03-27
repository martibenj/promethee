package fr.bull.csg.promethee;

import javax.ejb.Stateless;

/**
 * @author Thomas Gueze
 */
@Stateless
public class MantisEntityProvider extends EjbEntityProvider<Mantis> {

    public MantisEntityProvider() {
        super(Mantis.class);
    }

}
