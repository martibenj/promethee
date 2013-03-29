package fr.bull.csg.promethee.ui;

import com.vaadin.addon.jpacontainer.EntityProvider;
import fr.bull.csg.promethee.model.Mantis;
import fr.bull.csg.promethee.persistence.ContainerFactory;
import fr.bull.csg.promethee.persistence.MantisEntityProvider;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import fr.bull.csg.promethee.views.DashboardVersionsView;
import fr.bull.csg.promethee.views.DetailBuildView;

/**
 * Controleur de la webapp.
 * @author Thomas Gueze
 */
@Configurable(preConstruction = true)
@Theme("promethee")
public class NavigatorUI extends UI
{
   /** Serial UID. */
   private static final long serialVersionUID = 5128534733434639978L;

   /** Nom Métier de la page principale de listing des versions en cours et de leurs états. */
   public static final String DASHBOARD_VERSIONS = "DashboardVersions";

   /** Nom Métier de la page de détail d'une version/build. */
   public static final String VUE_BUILD = "VUE_BUILD";

   /** Objet Vaadin servant de controleur technique Framework. */
   private Navigator navigator;

   /**
    * Mantis Container Factory
    */
   private ContainerFactory<Mantis> mantisContainerFactory;

   @Override
   protected void init(VaadinRequest request)
   {
      // Création du navigator
      navigator = new Navigator(this, this);

      // Création et enregistrement des Views
      navigator.addView(DASHBOARD_VERSIONS, new DashboardVersionsView());
      navigator.addView(VUE_BUILD, new DetailBuildView(mantisContainerFactory));

      // Lancement de la première View
      navigator.navigateTo(DASHBOARD_VERSIONS);
   }

    public void setEntityProvider(EntityProvider<Mantis> mantisContainerFactory) {
        this.mantisContainerFactory = new ContainerFactory<Mantis>(mantisContainerFactory, Mantis.class);
    }
}
