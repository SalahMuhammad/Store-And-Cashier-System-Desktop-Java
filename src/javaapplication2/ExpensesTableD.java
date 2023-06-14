package javaapplication2;

import classes.ExpensesO;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modules.ExpensesC;
import modules.SuppliersInfoC;

public class ExpensesTableD extends javax.swing.JDialog {

    String id;
    
    public ExpensesTableD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        payedText.requestFocus();
        
        expensesTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        MyMethods.addEscapeListener( this );
        MyMethods.createKeybindings( expensesTable );
        
        MyMethods.jTFRequestFocus( payedText, supplierName );
        MyMethods.jTFRequestFocus( supplierName, noteText);
        
        MyMethods.jTableHeaderRendererTextToCenter( expensesTable );
        MyMethods.jTableTextAlignment( expensesTable, JLabel.CENTER );
        MyMethods.jTableTextAlignment( totalstable, JLabel.CENTER );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        expensesTable = new javax.swing.JTable();
        filterText = new javax.swing.JTextField();
        totalstable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        payedText = new javax.swing.JTextField();
        supplierName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        submitBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        noteText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("المصروفات");
        setResizable(false);

        expensesTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        expensesTable.setForeground(java.awt.Color.blue);
        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ملاحظات", "اسم المورد", "التاريخ", "صرف", "المعرف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        expensesTable.setRowHeight(35);
        expensesTable.getTableHeader().setReorderingAllowed(false);
        expensesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expensesTableMouseClicked(evt);
            }
        });
        expensesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                expensesTableKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(expensesTable);
        if (expensesTable.getColumnModel().getColumnCount() > 0) {
            expensesTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            expensesTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            expensesTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            expensesTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            expensesTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        filterText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTextKeyReleased(evt);
            }
        });

        totalstable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalstable.setForeground(java.awt.Color.blue);
        totalstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "اجمالي"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalstable.setRowHeight(30);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("صرف: ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 6, 78, 38));

        payedText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        payedText.setForeground(java.awt.Color.blue);
        payedText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(payedText, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 6, 213, 38));

        supplierName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supplierName.setForeground(java.awt.Color.blue);
        supplierName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(supplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 213, 38));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("اسم المورد: ");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 6, 96, 38));

        submitBTN.setText("ادراج");
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });
        jPanel4.add(submitBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 94, 150, -1));

        deleteBTN.setText("حذف");
        deleteBTN.setEnabled(false);
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });
        jPanel4.add(deleteBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 94, 150, -1));

        noteText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noteText.setForeground(java.awt.Color.blue);
        noteText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteTextActionPerformed(evt);
            }
        });
        jPanel4.add(noteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 50, 213, 38));

        jLabel3.setBackground(new java.awt.Color(204, 0, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ملاحظات: ");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 50, 78, 38));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(filterText)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalstable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalstable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void tableAction() {
        int srow = expensesTable.getSelectedRow();
        
        id = expensesTable.getValueAt( srow, 4 ).toString();
        payedText.setText( expensesTable.getValueAt( srow, 3 ).toString() );
        try { supplierName.setText( expensesTable.getValueAt( srow, 1 ).toString() ); } catch ( NullPointerException ex ) {}
        noteText.setText( expensesTable.getValueAt( srow, 0 ).toString() );

        submitBTN.setText( "تحديث" );
        deleteBTN.setEnabled( true );
    }
    
    private void expensesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesTableMouseClicked
        // TODO add your handling code here:
        if ( evt.getClickCount() == 2 ) {
            tableAction();
        }
    }//GEN-LAST:event_expensesTableMouseClicked

    private void filterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyReleased
        // TODO add your handling code here:
        display( expensesTable, filterText.getText());

        MyMethods.onKeyDownTableRequestFocus( evt, expensesTable );
    }//GEN-LAST:event_filterTextKeyReleased

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        if ( ! payedText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            payedText.requestFocus();
            JOptionPane.showMessageDialog( this, "قيم غير صالحة فى حقل الصرف...", "خطاء", 2 );
            return;
        }

        int supp_id = new SuppliersInfoC().getSupplierID( supplierName.getText() );
        
        // message will be displayed from SuppliersInfoC()
        if ( supp_id == -1 && ! supplierName.getText().isEmpty() ) {
            supplierName.requestFocus();
            return;
        }
        
        int resutl = 1;
        if ( submitBTN.getText() == "ادراج" ) {
            new ExpensesC().insert( payedText.getText(), noteText.getText(), supp_id == -1 ? null : Integer.toString( supp_id ) );
        } else {
            new ExpensesC().update( payedText.getText(), noteText.getText(), supp_id == -1 ? null : Integer.toString( supp_id ), id );
        }
        
        if ( resutl == 1 ) {
            emptyText();
            
            display( expensesTable, filterText.getText() );
        }
    }//GEN-LAST:event_submitBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog( this, "هل انت متاكد من انك تريد حذف هذة المعاملة", "تاكيد", 0 );
        
        if ( result == JOptionPane.YES_OPTION ) {
            new ExpensesC().delete( id );
            
            display( expensesTable, filterText.getText() );
            
            emptyText();
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void expensesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expensesTableKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ) {
            payedText.requestFocus();
            
            tableAction();
        }
    }//GEN-LAST:event_expensesTableKeyReleased

    private void noteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteTextActionPerformed
        // TODO add your handling code here:
        submitBTNActionPerformed( null );
    }//GEN-LAST:event_noteTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<ExpensesO> list = new ArrayList<>();
        
//        ArrayList<ExpensesO> list = new ArrayList<>();
        for ( int i = 0; i < expensesTable.getRowCount(); i++ ) {
            int srow = expensesTable.getSelectedRow();
            
            expensesTable.getValueAt( i, 0).toString();
            System.out.println("");
                    
            list.add(
                new ExpensesO(
                    new BigDecimal( expensesTable.getValueAt( i, 3).toString() ), 
                    expensesTable.getValueAt( i, 0).toString()
                )
            );
        }
        
        MyMethods.runReport( "expenses", "expenses", "expenses", list);        
    }//GEN-LAST:event_jButton1ActionPerformed

    void emptyText() {
        payedText.requestFocus();
        
        payedText.setText( "" );
        noteText.setText( "" );
        supplierName.setText( "" );
        
        deleteBTN.setEnabled( false );
        
        submitBTN.setText( "ادراج" );
    }
    
    public void display( JTable t, String noteOrDate ) {
        ArrayList<ExpensesO> arr;
        BigDecimal total = new BigDecimal( 0 );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        if ( noteOrDate.trim().isEmpty() )
            return;
        
        arr = new ExpensesC().getAll( noteOrDate );
        Object[] row = new Object[5];
        for ( ExpensesO e : arr) {
            row[0] = e.note;
            row[1] = e.supplierName;
            row[2] = e.date;
            row[3] = e.pay;
            row[4] = e.id;

            total = total.add( new BigDecimal( row[3].toString() ) );
            
            model.addRow(row);
        }
        
        totalstable.setValueAt( total, 0, 0 );
    }
    
    public void init( String filter, String suppName ) {
        filterText.setText( filter );
        supplierName.setText( suppName );
        
        display( expensesTable, filterText.getText() );
        
        setVisible( true );
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
            java.util.logging.Logger.getLogger(ExpensesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpensesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpensesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpensesTableD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExpensesTableD dialog = new ExpensesTableD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable expensesTable;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField noteText;
    private javax.swing.JTextField payedText;
    private javax.swing.JButton submitBTN;
    private javax.swing.JTextField supplierName;
    private javax.swing.JTable totalstable;
    // End of variables declaration//GEN-END:variables
}
