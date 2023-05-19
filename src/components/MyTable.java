package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MyTable extends JTable implements TableCellRenderer {
    
    public DefaultTableModel model;
    
    public MyTable( String[] columnNames ) {
        model = new DefaultTableModel( null, columnNames );
        setModel( model );
        setRowHeight( 30 );
        setForeground( Color.BLUE );
        setFont( new Font( "Serif", Font.BOLD, 12 ) );
        // align celles values
        ((DefaultTableCellRenderer) getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        return this;
    }
    
}
