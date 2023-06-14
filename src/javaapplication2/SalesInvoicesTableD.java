package javaapplication2;

import classes.SalesInvoicesO;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modules.SalesInvoicesC;

public class SalesInvoicesTableD extends javax.swing.JDialog {

    public int invoiceId;
    public String date;
    public String name = "";
    public String note = "";
    public String pay  = "";
    
    public SalesInvoicesTableD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        invoiceId = 0;
        
        invoicesTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        MyMethods.addEscapeListener( this );
        
        MyMethods.createKeybindings( invoicesTable );
        MyMethods.jTableTextAlignment( invoicesTable, JLabel.CENTER );
        MyMethods.jTableTextAlignment( totalstable, JLabel.CENTER );
        
        MyMethods.jTableHeaderRendererTextToCenter( invoicesTable );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        deleteBTN = new javax.swing.JButton();
        totalstable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("الفواتير");
        setResizable(false);

        invoicesTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoicesTable.setForeground(java.awt.Color.blue);
        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "اجمالي", "متبقي", "مدفوع", "ملاحظات", "التاريخ", "اسم العميل", "المعرف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoicesTable.setRowHeight(35);
        invoicesTable.getTableHeader().setReorderingAllowed(false);
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
            invoicesTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            invoicesTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            invoicesTable.getColumnModel().getColumn(5).setPreferredWidth(200);
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

        totalstable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalstable.setForeground(java.awt.Color.blue);
        totalstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "اجمالي", "متبقي"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalstable.setRowHeight(30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addComponent(totalstable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(filterText)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBTN)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBTN)
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalstable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if ( filterText.getText().isEmpty() ) {
            ( ( DefaultTableModel ) invoicesTable.getModel() ).setRowCount( 0 );
            return;
        }
        
        display( filterText.getText() );
        
        MyMethods.onKeyDownTableRequestFocus( evt, invoicesTable );
    }//GEN-LAST:event_filterTextKeyReleased

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        if ( invoicesTable.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog( this, "لم يتم اختيار فاتورة...", "اخطار", 2 );
            return;
        }
        
        int response = JOptionPane.showConfirmDialog( null, "هل انت متاكد من انك تريد حذف هذة الفاتروة !؟", "تاكيد", 0 );    
        if ( response != JOptionPane.YES_OPTION ) return;
        
        new SalesInvoicesC().delete( ( int ) invoicesTable.getValueAt( invoicesTable.getSelectedRow(), 6 ) );
        
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
            
        invoiceId = ( int ) invoicesTable.getValueAt( selectedRow, 6 );
        date = invoicesTable.getValueAt( selectedRow, 4 ).toString();
        try {
            note = invoicesTable.getValueAt( selectedRow, 3 ).toString();
            pay = invoicesTable.getValueAt( selectedRow, 2 ).toString();
            name = invoicesTable.getValueAt( selectedRow, 5 ).toString();
        } catch (Exception e) {}

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
        Object[] row = new Object[7];
        
        BigDecimal totalPayed = new BigDecimal( 0 );
        BigDecimal totalLeft = new BigDecimal( 0 );
        
        model.setRowCount( 0 );
        for (int i = 0; i < list.size(); i++) {
            
            row[0] = list.get(i).total;
            row[1] = ! list.get(i).total.equals( 1 )
                    ? list.get(i).total.subtract( ( list.get(i).payed.equals( 1 ) ? list.get(i).total : list.get(i).payed ) )
                    : 0;
            row[2] = list.get(i).payed;
            row[3] = list.get(i).note;
            row[4] = list.get(i).date;
            row[5] = list.get(i).customerName;
            row[6] = list.get(i).id;
            
            totalPayed = totalPayed.add( new BigDecimal( row[2].toString() ) );
            totalLeft = totalLeft.add( new BigDecimal( row[1].toString() ) );

            model.addRow(row);
        }
        
        totalstable.setValueAt( "اجمالي مدفوع: " + totalPayed, 0, 1 );
        totalstable.setValueAt( "اجمالي متبقي: " + totalLeft, 0, 0 );
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
            java.util.logging.Logger.getLogger(SalesInvoicesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoicesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesInvoicesTableD dialog = new SalesInvoicesTableD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable totalstable;
    // End of variables declaration//GEN-END:variables
}
