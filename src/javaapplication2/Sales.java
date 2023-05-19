package javaapplication2;

import classes.SalesO;
import classes.SalesOO;
import crud.dialogs.SalesD;
import crud.dialogs.SalesInvoicesD;
import crud.dialogs.SalesItemsD;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modules.ItemsC;
import modules.SalesC;
import modules.SalesInvoicesC;

public class Sales extends javax.swing.JFrame {
    
    public Sales() {
        initComponents();

        descText.requestFocus();
        calculateTotals(salesTable, itemsCountLabel, totalLabel );
        MyMethods.jTableTextAlignment( salesTable, JLabel.CENTER );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invoiceIdLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        descText = new javax.swing.JTextField();
        qtyText2 = new javax.swing.JTextField();
        priceText1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        dateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addBTN = new javax.swing.JButton();
        submitBTN = new javax.swing.JButton();
        invoicesBTN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        itemsCountLabel = new javax.swing.JLabel();

        invoiceIdLabel.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("المبيعات");

        salesTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        salesTable.setForeground(java.awt.Color.blue);
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "الباركود", "الوصف", "سعر القطعة", "الكمية", "الاجمالي"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTable.setRowHeight(30);
        salesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesTable);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        descText.setForeground(java.awt.Color.black);
        descText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextActionPerformed(evt);
            }
        });

        qtyText2.setForeground(java.awt.Color.black);
        qtyText2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qtyText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyText2ActionPerformed(evt);
            }
        });

        priceText1.setForeground(java.awt.Color.black);
        priceText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("العدد: ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("سعر القطعة: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("الوصف: ");

        addBTN.setText("اضافة ");
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        submitBTN.setText("اضافة الفاتورة");
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });

        invoicesBTN.setText("الفواتير");
        invoicesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesBTNActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        itemsCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(qtyText2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(priceText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addBTN)
                                .addGap(18, 18, 18)
                                .addComponent(invoicesBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(77, 77, 77)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(itemsCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN)
                    .addComponent(invoicesBTN)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemsCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitBTN)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void descTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextActionPerformed
        // TODO add your handling code here:
        SalesItemsD it = new SalesItemsD( this, true );
        it.getDescText().setText( descText.getText() );
        
        it.setVisible( true );
        
        try {
            qtyText2.requestFocus();
            
            descText.setText( it.itemsObject.getDescription() );
            priceText1.setText( Float.toString( it.itemsObject.getPrice() ) );

            jComboBox1.removeAllItems();
            DefaultComboBoxModel model = ( DefaultComboBoxModel ) jComboBox1.getModel();
            model.addElement("قطاعي - " + it.itemsObject.getPrice() );
            model.addElement("جملة - " + it.itemsObject.getWs_price() );

            jComboBox1.setModel( model );
        } catch ( NullPointerException ex ) {}
    }//GEN-LAST:event_descTextActionPerformed

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        // TODO add your handling code here:
        ItemsC i = new ItemsC();
        String itemId = i.getItemId( descText.getText() );
        int qty;
        int centerStock;
        
        if ( itemId == null ) {
            JOptionPane.showMessageDialog( this, "هذا الصنف غير موجود", "خطاء", 2 );
            return;
        }
        
        if ( isItemExistsInJTable(salesTable, itemId ) ) {
            JOptionPane.showMessageDialog( this, "هذا الصنف موجود بالفعل...", "خطاء", 2 );
            return;
        }
        
        qtyText2.setText( qtyText2.getText().isEmpty() ? "1" : qtyText2.getText() );
        if ( ! qtyText2.getText().matches( "[0-9]+") ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صحيحة فى حقل العدد", "اخطار", 2 );
            return;
        }
        
        if ( ! priceText1.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل السعر...", "خطاء", 2 );
            return;
        }
        
        qty = Integer.parseInt( qtyText2.getText() );

        centerStock = i.getCenterStock( itemId );
        if ( centerStock < qty ) {
            JOptionPane.showMessageDialog( this, "لا يوجد ما يكفي من القطع..\nالمتاح: " + centerStock, "خطاء", 2 );
            return;
        }
        
        DefaultTableModel model = ( DefaultTableModel ) salesTable.getModel();
        model.addRow( new Object[]{ "", itemId, descText.getText(), priceText1.getText(), qtyText2.getText(), qty * Float.parseFloat( priceText1.getText() ) } );
        
        calculateTotals(salesTable, itemsCountLabel, totalLabel );
        
        emptyFields();
    }//GEN-LAST:event_addBTNActionPerformed

    // check if item exists in jtable
    boolean isItemExistsInJTable( JTable t, String itemId ) {
        for ( int i = 0; i < t.getRowCount(); i++ ) {
            if ( t.getValueAt( i, 1 ).equals( itemId ) )
                return true;
        }
        
        return false;
    }
    
    void calculateTotals( JTable t, JLabel count, JLabel total ) {
        float totalPrice = 0;
        int itemsCount = 0;
        
        for ( int i = 0; i < t.getRowCount(); i++ ) {
            totalPrice += Float.parseFloat( t.getValueAt( i, 5 ).toString() );
            itemsCount += 1;
        }
        
        total.setText( "الاجمالي: " + totalPrice );
        count.setText( "عدد الاصناف: " + itemsCount );
    }
    
    private void emptyFields() {
        descText.requestFocus();
        
        qtyText2.setText( "" );
        priceText1.setText( "" );
        descText.setText( "" );
        
        try {
            DefaultComboBoxModel model = ( DefaultComboBoxModel ) jComboBox1.getModel();
            model.removeAllElements();
            jComboBox1.setModel( model );
        } catch (Exception e) {}
    }
    
    private void qtyText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyText2ActionPerformed
        // TODO add your handling code here:
        addBTNActionPerformed( null );
    }//GEN-LAST:event_qtyText2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        priceText1.setText( jComboBox1.getSelectedItem().toString().split( "-" )[1].trim() );
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void salesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTableMouseClicked
        // TODO add your handling code here:
        if ( evt.getClickCount() == 2 ) {
            int sRow = salesTable.getSelectedRow();
        
            if ( salesTable.getValueAt( sRow, 0 ) == "" ) {
                qtyText2.setText( salesTable.getValueAt( sRow, 4 ).toString() );
                priceText1.setText( salesTable.getValueAt( sRow, 3 ).toString() );
                descText.setText( salesTable.getValueAt( sRow, 2 ).toString() );
                
                ( ( DefaultTableModel ) salesTable.getModel() ).removeRow( sRow );

                calculateTotals( salesTable, itemsCountLabel, totalLabel );
                
                descText.requestFocus();

                return;
            }

            SalesD salesDialog = new SalesD( this, true );

            salesDialog.initialize( 
                Integer.parseInt( salesTable.getValueAt( sRow, 0 ).toString() ), // sales transaction id
                salesTable.getValueAt( sRow, 2 ).toString(), // description
                salesTable.getValueAt( sRow, 3 ).toString(), // price
                salesTable.getValueAt( sRow, 4 ).toString() // qty
            );

            ( ( DefaultTableModel ) salesTable.getModel() ).setRowCount( 0 );
            dateLabel.setText( "" );

            display( Integer.parseInt( invoiceIdLabel.getText() ), dateLabel );
            
            calculateTotals( salesTable, itemsCountLabel, totalLabel );
        }
    }//GEN-LAST:event_salesTableMouseClicked

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        if ( salesTable.getRowCount() < 1 ) {
            JOptionPane.showMessageDialog( this, "لم يتم اختيار صنف...", "خطاء", 2 );
            return;
        }
        
        add();
        
        ( ( DefaultTableModel ) salesTable.getModel() ).setRowCount( 0 );
        emptyFields();
        dateLabel.setText( "" );
    }//GEN-LAST:event_submitBTNActionPerformed
    
    private void add() {
        int invoiceId = invoiceIdLabel.getText().equals("0") 
                ? new SalesInvoicesC().insert() 
                : Integer.parseInt( invoiceIdLabel.getText() );
        String values = "";

        for ( int i = 0; i < salesTable.getRowCount(); i++ ) { 
            if ( salesTable.getValueAt( i, 0 ).toString().isEmpty() ) {
                values += "( null, " 
                    + salesTable.getValueAt( i, 1 ).toString() + ", " 
                    + invoiceId + ", "
                    + salesTable.getValueAt( i, 3 ).toString() + ", "
                    + salesTable.getValueAt( i, 4 ).toString() + ")";

                if ( i != salesTable.getRowCount() - 1 )
                    values += ", ";
            }
        }

        if ( new SalesC().insert( values ) == 1  )
            JOptionPane.showMessageDialog( this, "تم ادراج الفاتورة بنجاح...");
        
        invoiceIdLabel.setText( "0" );
    }
    
    private void invoicesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesBTNActionPerformed
        // TODO add your handling code here:
        dateLabel.setText("");
        ( ( DefaultTableModel ) salesTable.getModel() ).setRowCount( 0 );
        
        SalesInvoicesD salesInvoices = new SalesInvoicesD( this, true );
        salesInvoices.setVisible( true );
        
        if ( salesInvoices.invoiceId > 0 ) {
            invoiceIdLabel.setText( Integer.toString( salesInvoices.invoiceId ) );
            
            display( salesInvoices.invoiceId, dateLabel );
            
            calculateTotals( salesTable, itemsCountLabel, totalLabel );
        }
    }//GEN-LAST:event_invoicesBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new JavaApplication2().frame.setVisible( true );
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void display( int invoiceid, JLabel dateLabel ) {
        SalesOO obj = new SalesC().getAll( "si.id=" + invoiceid );
        
        if ( obj == null ) return;
        
        ArrayList<SalesO> arr   = obj.listData;
        Timestamp date          = obj.date;
        
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        model.setRowCount( 0 );
        Object[] row = new Object[6];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).getItemId();
            row[2] = arr.get(i).getDesc();
            row[3] = arr.get(i).price;
            row[4] = arr.get(i).qty;
            row[5] = arr.get(i).price * arr.get(i).qty;

            model.addRow(row);
        }

        dateLabel.setText( date.toString() );  
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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBTN;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField descText;
    private javax.swing.JLabel invoiceIdLabel;
    private javax.swing.JButton invoicesBTN;
    private javax.swing.JLabel itemsCountLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priceText1;
    private javax.swing.JTextField qtyText2;
    private javax.swing.JTable salesTable;
    private javax.swing.JButton submitBTN;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
