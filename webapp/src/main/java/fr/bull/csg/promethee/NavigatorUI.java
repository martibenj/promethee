package fr.bull.csg.promethee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * @author Thomas Gueze
 */
@Configurable(preConstruction = true)
@Theme("promethee")
public class NavigatorUI extends UI
{

   public static final String INDEX_BUILDS = "IndexBuilds";

   public static final String VUE_BUILD = "VUE_BUILD";

   @Autowired
   private Dummy m_dummy;

   Navigator navigator;

   @Override
   protected void init(VaadinRequest request)
   {

      SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
      final Dummy bean = (Dummy) helper.getBean("dummy");
      System.out.println("1=" + bean.dumbdumb());

      System.out.println("2=" + m_dummy.dumbdumb());
      getPage().setTitle("Navigation Example");

      // Create a navigator to control the views
      navigator = new Navigator(this, this);

      // Create and register the views
      navigator.addView(INDEX_BUILDS, new IndexBuilds());
      navigator.addView(VUE_BUILD, new VueBuild());

      navigator.navigateTo(INDEX_BUILDS);
   }
}
