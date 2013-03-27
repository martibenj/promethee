package fr.bull.csg.promethee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import fr.bull.csg.promethee.beans.ListeurVersions;
import fr.bull.csg.promethee.views.DashboardVersions;

/**
 * @author Thomas Gueze
 */
@Component
@Scope("prototype")
@Theme("promethee")
public class NavigatorUI extends UI
{
   /** Serial UID. */
   private static final long serialVersionUID = 3800400020780939588L;

   @Autowired
   private transient ApplicationContext applicationContext;

   @Autowired
   private ListeurVersions m_listeurVersions;

   public static final String DASHBOARD_VERSIONS = "DashboardVersions";

   public static final String VUE_BUILD = "VUE_BUILD";

   private Navigator m_navigator;

   @Override
   protected void init(VaadinRequest request)
   {
      m_listeurVersions.listerLesVersionsDisponibles();
      getPage().setTitle("POC Prométhée");

      // Create a navigator to control the views
      m_navigator = new Navigator(this, this);

      // Create and register the views
      m_navigator.addView(DASHBOARD_VERSIONS, new DashboardVersions());
      m_navigator.addView(VUE_BUILD, new VueBuild());

      m_navigator.navigateTo(DASHBOARD_VERSIONS);
   }
}
