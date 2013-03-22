package fr.bull.csg.promethee;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author Thomas Gueze
 */
public class NavigatorUI extends UI {

    public static final String PREMIERE_PAGE = "Premiere Page";
    public static final String DEUXIEME_PAGE = "Deuxieme Page";

    Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(PREMIERE_PAGE, new PagePrincipale());
        navigator.addView(DEUXIEME_PAGE, new Page2());

        navigator.navigateTo(PREMIERE_PAGE);
    }
}
