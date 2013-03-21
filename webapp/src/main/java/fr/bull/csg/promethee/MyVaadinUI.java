package fr.bull.csg.promethee;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		GridLayout layout = new GridLayout(3, 3);

		setContent(layout);

		ComboBox branch = new ComboBox("Branche");
		branch.addItem("prod");
		branch.addItem("branch1");
		branch.addItem("trunk");

		layout.addComponent(branch);

		ComboBox version = new ComboBox("version");
		version.addItem("1");
		version.addItem("2");
		version.addItem("3");

		version.setValue("1");

		layout.addComponent(version);

		TextField textField = new TextField("Search");
		layout.addComponent(textField, 2, 1);

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
		listeMantis.add(new Object[] { "1", "correctif", "Mantis 1", "1", "0",
				"A traiter", "GFA", "commentaire" });
		listeMantis.add(new Object[] { "2", "correctif", "Mantis 2", "1", "0",
				"A traiter", "GFA", "commentaire" });
		listeMantis.add(new Object[] { "3", "evolution", "Mantis 3", "1", "0",
				"A traiter", "GFA", "commentaire" });
		listeMantis.add(new Object[] { "4", "correctif", "Mantis 4", "1", "0",
				"A traiter", "GFA", "commentaire" });
		listeMantis.add(new Object[] { "5", "correctif", "Mantis 5", "1", "0",
				"A traiter", "GFA", "commentaire" });
		listeMantis.add(new Object[] { "6", "evolution", "Mantis 6", "1", "0",
				"A traiter", "GFA", "commentaire" });

		int i = 0;
		for (Object[] mantis : listeMantis) {
			table.addItem(mantis, i);
			i++;
		}

		layout.addComponent(table, 2, 2);
	}

}
