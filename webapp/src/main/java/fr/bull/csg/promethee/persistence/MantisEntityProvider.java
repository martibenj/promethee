package fr.bull.csg.promethee.persistence;

import javax.ejb.Stateless;

import fr.bull.csg.promethee.pojo.Mantis;

/**
 * @author Thomas Gueze
 */
@Stateless
public class MantisEntityProvider extends EjbEntityProvider<Mantis> {

    public MantisEntityProvider() {
        super(Mantis.class);
    }

}
