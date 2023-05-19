package crud.dialogs;

import javaapplication2.MyMethods;
import javax.swing.JOptionPane;
import modules.ItemsC;
import modules.SuppSuppliesC;

public class ItemsD extends javax.swing.JDialog {

    String oldItemId;
    
    public ItemsD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);      
        initComponents();
        
        MyMethods.addEscapeListener( this );
        
        deleteBTN.setVisible( false );
        itemIdText.requestFocus();
    }
    
    public void dialogInitializer( String id, String desc, String pp, String wwp, String wp, String p ) {
        oldItemId = id;
        itemIdText.setText( id );
        descText.setText( desc );
        purchasPriceText.setText( pp );
        wswsPriceText.setText( wwp );
        wsPriceText.setText( wp );
        priceText.setText( p );
        
        submitBTN.setText( "تحديث" );
        deleteBTN.setVisible( true );
        
        this.setVisible( true );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descText = new javax.swing.JTextField();
        purchasPriceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        wswsPriceText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        wsPriceText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        deleteBTN = new javax.swing.JButton();
        submitBTN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        itemIdText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("الوصف: ");

        descText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextActionPerformed(evt);
            }
        });

        purchasPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purchasPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasPriceTextActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("شراء: ");

        wswsPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wswsPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wswsPriceTextActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("جملة الجملة: ");

        wsPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wsPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsPriceTextActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("جملة: ");

        priceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("قطاعي: ");

        deleteBTN.setBackground(java.awt.Color.red);
        deleteBTN.setText("حذف");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        submitBTN.setText("اضافة");
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("الباركود: ");

        itemIdText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIdTextActionPerformed(evt);
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
                        .addComponent(descText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(purchasPriceText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(priceText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(wsPriceText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(wswsPriceText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(submitBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBTN))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(itemIdText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(itemIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(purchasPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(wswsPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(wsPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBTN)
                    .addComponent(submitBTN))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void purchasPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasPriceTextActionPerformed
        // TODO add your handling code here:
        if ( ! purchasPriceText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل الشراء...", "خطاء", 2 );
            return;
        }
        
        wswsPriceText.requestFocus();
        setPriceInWswsWsP( Float.parseFloat( purchasPriceText.getText() ) );
    }//GEN-LAST:event_purchasPriceTextActionPerformed

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        int result = 0;
        
        if ( ! purchasPriceText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل الشراء...", "خطاء", 2 );
            return;
        }
        
        if ( ! wswsPriceText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل جملة الجملة...", "خطاء", 2 );
            return;
        }
        if ( ! wsPriceText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل الجملة...", "خطاء", 2 );
            return;
        }
        if ( ! priceText.getText().matches( "([0-9]*[.])?[0-9]+" ) ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيم صالحة فى حقل قطاعي...", "خطاء", 2 );
            return;
        }

        if ( submitBTN.getText() == "اضافة" ) {
            result = new ItemsC().insert( 
                    itemIdText.getText(), 
                    descText.getText(), 
                    Float.parseFloat( purchasPriceText.getText()), 
                    Float.parseFloat( wswsPriceText.getText()), 
                    Float.parseFloat( wsPriceText.getText()), 
                    Float.parseFloat( priceText.getText()) 
            );
        } else if ( submitBTN.getText() == "تحديث" ){
            result = new ItemsC().update(oldItemId, 
                    itemIdText.getText(), descText.getText(), 
                    Float.parseFloat( purchasPriceText.getText()), 
                    Float.parseFloat( priceText.getText()), 
                    Float.parseFloat( wsPriceText.getText()), 
                    Float.parseFloat( wswsPriceText.getText()) );

            this.dispose();
        }

        if ( result == -1 ) return;

        emptyFields();
    }//GEN-LAST:event_submitBTNActionPerformed

    void setPriceInWswsWsP( float purchasePrice) {
        if ( purchasePrice < 10 ) {
            wswsPriceText.setText( purchasePrice + purchasePrice * .4 + "" );
            wsPriceText.setText( purchasePrice + purchasePrice * .5 + "" );
            priceText.setText( purchasePrice + purchasePrice * .9 + "" );
        } else if ( purchasePrice < 20 ) {
            wswsPriceText.setText( purchasePrice + purchasePrice * .3 + "" );
            wsPriceText.setText( purchasePrice + purchasePrice * .5 + "" );
            priceText.setText( purchasePrice + purchasePrice * .7 + "" );
        } else if ( purchasePrice < 60 ) {
            wswsPriceText.setText( purchasePrice + purchasePrice * .25 + "" );
            wsPriceText.setText( purchasePrice + purchasePrice * .3 + "" );
            priceText.setText( purchasePrice + purchasePrice * .5 + "" );
        } else {
            wswsPriceText.setText( purchasePrice + purchasePrice * .15 + "" );
            wsPriceText.setText( purchasePrice + purchasePrice * .2 + "" );
            priceText.setText( purchasePrice + purchasePrice * .4 + "" );
        }
    }
    
    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:        
        new ItemsC().delete(oldItemId );
        
        dispose();
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void itemIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIdTextActionPerformed
        // TODO add your handling code here:
        descText.requestFocus();
    }//GEN-LAST:event_itemIdTextActionPerformed

    private void descTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextActionPerformed
        // TODO add your handling code here:
        purchasPriceText.requestFocus();
    }//GEN-LAST:event_descTextActionPerformed

    private void wswsPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wswsPriceTextActionPerformed
        // TODO add your handling code here:
        wsPriceText.requestFocus();
    }//GEN-LAST:event_wswsPriceTextActionPerformed

    private void wsPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsPriceTextActionPerformed
        // TODO add your handling code here:
        priceText.requestFocus();
    }//GEN-LAST:event_wsPriceTextActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
        submitBTNActionPerformed( evt );
    }//GEN-LAST:event_priceTextActionPerformed

    private void emptyFields() {
        itemIdText.requestFocus();
        
        itemIdText.setText( "" );
        descText.setText( "" );
        purchasPriceText.setText( "" );
        wswsPriceText.setText( "" );
        wsPriceText.setText( "" );
        priceText.setText( "" );
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
            java.util.logging.Logger.getLogger(ItemsD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ItemsD dialog = new ItemsD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField descText;
    private javax.swing.JTextField itemIdText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField priceText;
    private javax.swing.JTextField purchasPriceText;
    private javax.swing.JButton submitBTN;
    private javax.swing.JTextField wsPriceText;
    private javax.swing.JTextField wswsPriceText;
    // End of variables declaration//GEN-END:variables
}
