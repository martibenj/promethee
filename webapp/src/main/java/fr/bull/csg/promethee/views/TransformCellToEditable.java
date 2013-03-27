package fr.bull.csg.promethee.views;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Field;

import fr.bull.csg.promethee.pojo.ColumnIdentifier;

import java.util.Map;

/**
 * @author Thomas Gueze
 */
public class TransformCellToEditable implements ItemClickEvent.ItemClickListener {

    private final Map<ColumnIdentifier, Field> fields;

    public TransformCellToEditable(Map<ColumnIdentifier, Field> tableFields) {
        fields = tableFields;
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        if (event.isDoubleClick())
        {
            ColumnIdentifier key = new ColumnIdentifier(event.getItemId(), event.getPropertyId());
            if (fields.containsKey(key)) {
                fields.get(key).setReadOnly(false);
            }
        }
    }
}
