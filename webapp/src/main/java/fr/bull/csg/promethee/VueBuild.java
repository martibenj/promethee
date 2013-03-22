package fr.bull.csg.promethee;

import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The Application's "main" class
 */
public class VueBuild extends VerticalLayout implements View
{
    public VueBuild() {
        HorizontalLayout layout = new HorizontalLayout();
        addComponent(layout);


        ComboBox branch = new ComboBox("Branche");
        branch.addItem("prod");
        branch.addItem("branch1");
        branch.addItem("branch2");
        branch.addItem("trunk");

        branch.setValue("trunk");
        branch.setImmediate(true);
        branch.setNullSelectionAllowed(false);

        final ComboBox version = new ComboBox();
        version.addItem("1");
        version.addItem("2");
        version.addItem("3");

        version.setValue("1");
        version.setNullSelectionAllowed(false);
//        version.setImmediate(true);
//        version.setCaption("version");

        branch.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if ("prod".equals(event.getProperty().getValue())) {
                    version.removeAllItems();
                    version.addItem("4");
                    version.addItem("5");
                    version.addItem("6");
                    version.setValue("4");
//                    version.setCaption("version");
                }
            }
        });

        layout.addComponent(branch);


        layout.addComponent(version);


        TextField textField = new TextField("Search");
        addComponent(textField);


        Table table = new Table();
        table.addContainerProperty("#Mantis", String.class, null);

        table.addContainerProperty("Type", String.class, null);
        table.addContainerProperty("Description", String.class, null);
        table.addContainerProperty("Chiffrage", String.class, null);
        table.addContainerProperty("Consomme", String.class, null);
        table.addContainerProperty("Etat", String.class, null);
        table.addContainerProperty("Affecte", String.class, null);
        table.addContainerProperty("Commentaire", String.class, null);

        List<Object[]> listeMantis = new ArrayList<Object[]>();
        listeMantis.add(new Object[]{"1", "correctif", "Mantis 1", "1", "0", "A traiter", "GFA", "commentaire"});
        listeMantis.add(new Object[]{"2", "correctif", "Mantis 2", "1", "0", "A traiter", "GFA", "commentaire"});
        listeMantis.add(new Object[]{"3", "evolution", "Mantis 3", "1", "0", "A traiter", "GFA", "commentaire"});
        listeMantis.add(new Object[]{"4", "correctif", "Mantis 4", "1", "0", "A traiter", "GFA", "commentaire"});
        listeMantis.add(new Object[]{"5", "correctif", "Mantis 5", "1", "0", "A traiter", "GFA", "commentaire"});
        listeMantis.add(new Object[]{"6", "evolution", "Mantis 6", "1", "0", "A traiter", "GFA", "commentaire"});

        int i = 0;
        for (Object[] mantis : listeMantis) {
            table.addItem(mantis, i);
            i++;
        }

        addComponent(table);

        Button button = new Button("vers seconde page", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(NavigatorUI.INDEX_BUILDS);
            }
        });

        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Bienvenue sur la page : " + event.getViewName());
    }

}
