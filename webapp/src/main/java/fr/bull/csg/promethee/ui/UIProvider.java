package fr.bull.csg.promethee.ui;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UICreateEvent;
import com.vaadin.ui.UI;
import fr.bull.csg.promethee.persistence.MantisEntityProvider;

/**
 * @author Thomas Gueze
 */
public class UIProvider extends DefaultUIProvider {

    private NavigatorUI vaadinUI;

    private transient MantisEntityProvider myEjb;

    public UIProvider(MantisEntityProvider myEjb) {
        this.myEjb = myEjb;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
        vaadinUI = new NavigatorUI();
        vaadinUI.setMyEjb(myEjb);
        return vaadinUI;
    }
}
