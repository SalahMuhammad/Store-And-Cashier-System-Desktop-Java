package crud.dialogs;

import classes.SalesInvoicesO;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import javaapplication2.MyMethods;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modules.SalesInvoicesC;

public class SalesInvoicesD extends javax.swing.JDialog {

    public int invoiceId;
    public Timestamp date;
    
    public SalesInvoicesD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        invoiceId = 0;
        invoicesTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        MyMethods.addEscapeListener( this );
        
        MyMethods.createKeybindings( invoicesTable );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        deleteBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoices");
        setResizable(false);

        invoicesTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        invoicesTable.setForeground(java.awt.Color.blue);
        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "التاريخ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoicesTable.setRowHeight(30);
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        invoicesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoicesTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(invoicesTable);
        if (invoicesTable.getColumnModel().getColumnCount() > 0) {
            invoicesTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        filterText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTextKeyReleased(evt);
            }
        });

        deleteBTN.setText("حذف");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(deleteBTN)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 92, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteBTN)
                .addContainerGap(363, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyReleased
        // TODO add your handling code here:      
        if ( evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP ) {
            if ( invoicesTable.getRowCount() > 0 ) {
                invoicesTable.requestFocus();
            }
        }
        
        if ( filterText.getText().isEmpty() ) {
            ( ( DefaultTableModel ) invoicesTable.getModel() ).setRowCount( 0 );
            return;
        }
        
        display( filterText.getText() );
    }//GEN-LAST:event_filterTextKeyReleased

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        if ( invoicesTable.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog( this, "لم يتم اختيار فاتورة...", "اخطار", 2 );
            return;
        }
        
        int response = JOptionPane.showConfirmDialog( null, "هل انت متاكد من انك تريد حذف هذة الفاتروة !؟", "تاكيد", 0 );    
        if ( response != JOptionPane.YES_OPTION ) return;
        
        new SalesInvoicesC().delete( ( int ) invoicesTable.getValueAt( invoicesTable.getSelectedRow(), 0 ) );
        
        display( filterText.getText() );
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicesTableMouseClicked
        // TODO add your handling code here:
        if ( evt.getClickCount() == 2 ) {
            action();
        }
    }//GEN-LAST:event_invoicesTableMouseClicked

    void action() {
        int selectedRow = invoicesTable.getSelectedRow();
            
        invoiceId = ( int ) invoicesTable.getValueAt( selectedRow, 0 );
        date = ( Timestamp ) invoicesTable.getValueAt( selectedRow, 1 );

        this.dispose(); 
    }
    
    private void invoicesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoicesTableKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ) {
            if ( invoicesTable.getSelectedRow() >= 0 ) {
                    action();
            }
        }
    }//GEN-LAST:event_invoicesTableKeyReleased
    
    public void display( String invoiceid ) {
        ArrayList<SalesInvoicesO> list = new SalesInvoicesC().getInvoices( invoiceid );
        
        DefaultTableModel model = (DefaultTableModel) invoicesTable.getModel();
        model.setRowCount( 0 );
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).id;
            row[1] = list.get(i).date;

            model.addRow(row);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesInvoicesD dialog = new SalesInvoicesD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBTN;
    private javax.swing.JTextField filterText;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
