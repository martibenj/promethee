package fr.bull.csg.promethee.persistence;

import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Container;

/**
 * Factory de Container
 * Construit des Container en utilisant le JPAContainer pour l'instant
 * @author Thomas Gueze
 */
public class ContainerFactory<T>
{
    /**
     * Nom de l'unite de persistence telle que définie dans le persistence.xml
     */
    public static final String PERSISTENCE_UNIT_NAME = "promethee";

    /**
     * Entity provider à utiliser par le container
     */
    private EntityProvider<T> entityProvider;

    /**
     * Classe à utiliser
     */
    private Class<T> clazz;

    public ContainerFactory(EntityProvider<T> entityProvider, Class<T> clazz) {
        this.entityProvider = entityProvider;
        this.clazz = clazz;
    }

    /**
     * @return retourne un container vaadin
     */
    public Container getModelContainer() {
        JPAContainer<T> jpaContainer = JPAContainerFactory.make(clazz, PERSISTENCE_UNIT_NAME);
        jpaContainer.setEntityProvider(entityProvider);
        return jpaContainer;
    }
}
