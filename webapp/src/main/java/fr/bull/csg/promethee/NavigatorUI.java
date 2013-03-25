package fr.bull.csg.promethee;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author Thomas Gueze
 */
@Theme("promethee")
public class NavigatorUI extends UI {

    public static final String INDEX_BUILDS = "IndexBuilds";
    public static final String VUE_BUILD = "VUE_BUILD";

    Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(INDEX_BUILDS, new IndexBuilds());
        navigator.addView(VUE_BUILD, new VueBuild());

        navigator.navigateTo(INDEX_BUILDS);
    }
}
