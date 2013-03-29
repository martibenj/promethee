package fr.bull.csg.promethee.ui;

import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UICreateEvent;
import com.vaadin.ui.UI;
import fr.bull.csg.promethee.model.Mantis;

/**
 * @author Thomas Gueze
 */
public class MantisUIProvider extends DefaultUIProvider {

    private NavigatorUI vaadinUI;

    private transient EntityProvider<Mantis> entityProvider;

    public MantisUIProvider(EntityProvider<Mantis> entityProvider) {
        this.entityProvider = entityProvider;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
        vaadinUI = new NavigatorUI();
        vaadinUI.setEntityProvider(entityProvider);
        return vaadinUI;
    }
}
