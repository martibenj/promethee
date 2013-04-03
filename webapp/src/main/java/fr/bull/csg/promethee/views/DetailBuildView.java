package fr.bull.csg.promethee.views;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import fr.bull.csg.promethee.listener.SelectValueChangeListener;
import fr.bull.csg.promethee.listener.TransformCellToEditable;
import fr.bull.csg.promethee.model.Mantis;
import fr.bull.csg.promethee.persistence.ContainerFactory;
import fr.bull.csg.promethee.pojo.ColumnIdentifier;
import fr.bull.csg.promethee.ui.NavigatorUI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page de détail d'une version/build.
 *
 * @author Thomas Gueze
 */
public class DetailBuildView extends VerticalLayout implements View
{
   /**
    * Serial UID.
    */
   private static final long serialVersionUID = -3581253796593740550L;

   /**
    * Constructeur.
    */
   public DetailBuildView(ContainerFactory<Mantis> mantisContainerFactory)
   {
      setSizeUndefined();
      HorizontalLayout horizontalLayout = new HorizontalLayout();
      addComponent(horizontalLayout);

      ComboBox branch = new ComboBox();
      branch.addItem("prod");
      branch.addItem("branch1");
      branch.addItem("branch2");
      branch.addItem("trunk");

      branch.setValue("trunk");
      branch.setImmediate(true);
      branch.setNullSelectionAllowed(false);
      branch.setStyleName("selectBox");

      final ComboBox version = new ComboBox();
      version.addItem("1");
      version.addItem("2");
      version.addItem("3");

      version.setValue("1");
      version.setNullSelectionAllowed(false);
      version.setStyleName("selectBox");

      Map<String, List<String>> selectBoxChangesValues = new HashMap<String, List<String>>();
      selectBoxChangesValues.put("trunk", Arrays.asList("1", "2", "3"));
      selectBoxChangesValues.put("prod", Arrays.asList("4", "5", "6"));
      selectBoxChangesValues.put("branch1", Arrays.asList("7", "8", "9"));

      branch.addValueChangeListener(new SelectValueChangeListener(version, selectBoxChangesValues));

      horizontalLayout.addComponent(branch);
      horizontalLayout.addComponent(version);
      setMargin(true);

      TextField textField = new TextField("Search");
      textField.setStyleName("search");
      addComponent(textField);
      setComponentAlignment(textField, Alignment.TOP_RIGHT);

      Table table = new Table();
      table.setPageLength(0);
      table.setSizeUndefined();
      table.setContainerDataSource(mantisContainerFactory.getModelContainer());
      table.setColumnCollapsingAllowed(true);

      table.setImmediate(true);
      final Map<ColumnIdentifier, Field> tableFields = new HashMap<ColumnIdentifier, Field>();
      TableFieldFactory fieldFactory = new TableFieldFactory()
      {
         /** Serial UID. */
         private static final long serialVersionUID = 2404377481412862197L;

         @Override
         public Field<?> createField(Container container, Object itemId, Object propertyId, Component uiContext)
         {
            final TextField field = new TextField((String) propertyId);
            field.setImmediate(true);
            tableFields.put(new ColumnIdentifier(itemId, propertyId), field);
            field.setReadOnly(true);
            field.addValueChangeListener(new Property.ValueChangeListener()
            {
               /** Serial UID. */
               private static final long serialVersionUID = 1507880582120630053L;

               @Override
               public void valueChange(Property.ValueChangeEvent event)
               {
                  field.setReadOnly(true);
               }
            });
            return field;
         }
      };
      table.setTableFieldFactory(fieldFactory);

      table.setEditable(true);
      table.addItemClickListener(new TransformCellToEditable(tableFields));
      addComponent(table);

      Button button = new Button("vers seconde page", new Button.ClickListener()
      {
         /** Serial UID. */
         private static final long serialVersionUID = 8866649906609256903L;

         @Override
         public void buttonClick(Button.ClickEvent event)
         {
            getUI().getNavigator().navigateTo(NavigatorUI.DASHBOARD_VERSIONS);
         }
      });
      addComponent(button);
   }

   @Override
   public void enter(ViewChangeListener.ViewChangeEvent event)
   {
      // Notification.show("Bienvenue sur la page : " + event.getViewName());
   }
}
