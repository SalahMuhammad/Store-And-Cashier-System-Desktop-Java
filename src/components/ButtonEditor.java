package components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton btn;
    private String lbl;
    private boolean clicked;

    public ButtonEditor( JTextField txt ) {
        super( txt );
        
        btn = new JButton();
        
        btn.setOpaque( true );
        btn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    
    // override couple of methods

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // set text to button, set clicked to true, then return the btn object
        lbl = ( value == null ) ? "" : value.toString();
        btn.setText( lbl );
        clicked = true;
        return btn;
    }
    
    // if button cell value changes, if clicked that is
    @Override
    public Object getCellEditorValue() {
        if ( clicked ) {
            JOptionPane.showMessageDialog( btn, lbl + " Clicked" );
        }
        
        clicked = false;
        
        return new String( lbl );
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
