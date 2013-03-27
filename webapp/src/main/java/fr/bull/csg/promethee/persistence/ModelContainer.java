package fr.bull.csg.promethee.persistence;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Container;

/**
 * @author Thomas Gueze
 */
public class ModelContainer<T>
{

   private JPAContainer<T> jpaContainer;

   private ModelContainer(Class<T> clazz)
   {
      jpaContainer = JPAContainerFactory.make(clazz, "promethee");
      // EntityProvider e = new MantisEntityProvider();
      // jpaContainer.setEntityProvider(e);
   }

   public static <E> Container getModelContainer(Class<E> clazz)
   {
      return new ModelContainer<E>(clazz).getContainer();
   }

   public Container getContainer()
   {
      return jpaContainer;
   }
}
