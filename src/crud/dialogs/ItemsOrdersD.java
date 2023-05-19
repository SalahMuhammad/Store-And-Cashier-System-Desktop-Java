package crud.dialogs;

import javaapplication2.MyMethods;
import javax.swing.JOptionPane;
import modules.ItemsC;
import modules.ItemsOrdersC;

public class ItemsOrdersD extends javax.swing.JDialog {

    int id;
    String oldItemId;
    int oldCount;
    
    public ItemsOrdersD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        MyMethods.addEscapeListener( this );
        
        jButton2.setVisible( false );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        countText = new javax.swing.JTextField();
        submitText = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("طلب اصناف من المخزن");
        setResizable(false);

        descText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("الوصف: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("صرف: ");

        countText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countTextActionPerformed(evt);
            }
        });

        submitText.setText("اضافة");
        submitText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTextActionPerformed(evt);
            }
        });

        jButton2.setText("حذف");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(submitText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(countText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitText)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void descTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextActionPerformed
        // TODO add your handling code here:
        SalesItemsD it = new SalesItemsD( null, true );
        it.getDescText().setText( descText.getText() );
        
        it.setVisible( true );
        
        try {
            countText.requestFocus();
            
            descText.setText( it.itemsObject.getDescription() );
        } catch ( NullPointerException ex ) {}
    }//GEN-LAST:event_descTextActionPerformed

    private void countTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countTextActionPerformed
        // TODO add your handling code here:
        submitTextActionPerformed( evt );
    }//GEN-LAST:event_countTextActionPerformed

    private void submitTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTextActionPerformed
        // TODO add your handling code here:
        String itemId = new ItemsC().getItemId( descText.getText() );
        
        if ( ! countText.getText().matches("\\d+") ) {
            JOptionPane.showMessageDialog( this, "قيم غير صالحة...", "خطاء", 2 );
            return;
        }
        
        int count = Integer.parseInt( countText.getText() );
        ItemsC itemsC = new ItemsC();
        int warehouseStock;
        
        int result = 0;
        if ( submitText.getText() == "اضافة" ) {
            warehouseStock = itemsC.getWarehouseStock( itemId );
            
            if ( count > warehouseStock ) {
                JOptionPane.showMessageDialog( this, "لا يوجد ما يكفي من القطع.", "خطاء", 2 );
                return;
            }
            
            result = new ItemsOrdersC().insert( itemId, count );
        }
        else {
            int centerStock = itemsC.getCenterStock( oldItemId );
            warehouseStock = itemsC.getWarehouseStock( oldItemId );
            
            if ( count > ( warehouseStock + oldCount ) 
                    || 0 > centerStock - oldCount + count 
                    || ( ! oldItemId.equals( itemId ) && ( 0 > centerStock - oldCount || warehouseStock < oldCount ) ) ) {
                JOptionPane.showMessageDialog( this, "لا يوجد ما يكفى من القطع.\n" + "قطع المخزن: " + warehouseStock + "\nقطع المحل: " + centerStock, "خطاء", 2 );
                return;
            }

            result = new ItemsOrdersC().update( id, itemId, count );
            
            this.dispose();
        }
        
        if ( result != 1 )                
            return;
        
        emptyText();
    }//GEN-LAST:event_submitTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int centerStock = new ItemsC().getCenterStock(oldItemId );
        
        if ( centerStock - oldCount < 0 ) {
            JOptionPane.showMessageDialog( this, "لا يوجد ما يكفى من القطع.\nقطع المحل: " + centerStock, "خطاء", 2 );
            return;
        }
        
        int response = JOptionPane.showConfirmDialog( this, "هل انت متاكد من حذف هذة المعاملة...", "تاكيد", 0 );
        
        if ( response == JOptionPane.YES_OPTION ) {
            new ItemsOrdersC().delete( id );
            
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void init( int id, String desc, String qty ) {
        descText.requestFocus();
        
        oldItemId = new ItemsC().getItemId( desc );
        oldCount = Integer.parseInt( qty );
        
        this.id = id;
        descText.setText( desc );
        countText.setText( qty );
        
        jButton2.setVisible( true );
        submitText.setText( "تحديث" );
        
        this.setVisible( true );
    }
    
    void emptyText() {
        descText.requestFocus();
        
        descText.setText( "" );
        countText.setText( "" );
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
            java.util.logging.Logger.getLogger(ItemsOrdersD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsOrdersD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsOrdersD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsOrdersD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ItemsOrdersD dialog = new ItemsOrdersD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField countText;
    private javax.swing.JTextField descText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submitText;
    // End of variables declaration//GEN-END:variables
}
