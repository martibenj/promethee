package fr.bull.csg.promethee;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Thomas Gueze
 */
public class IndexBuilds extends VerticalLayout implements View {

    public IndexBuilds() {
        ComboBox branch = new ComboBox("Branche");
        branch.addItem("prod");
        branch.addItem("branch1");
        branch.addItem("branch2");
        branch.addItem("trunk");

        addComponent(branch);

        Button button = new Button("vers page principale", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(NavigatorUI.VUE_BUILD);
            }
        });
        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Bienvenue sur la page : " + event.getViewName());
    }
}
