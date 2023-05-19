package components;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    
    // constructor
    public ButtonRenderer() {
        setOpaque( true );
    }
    
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        // Set Passed Object As Button Text
        setText( ( obj == null ) ? "" : obj.toString() );
        
        return this;
    }
}