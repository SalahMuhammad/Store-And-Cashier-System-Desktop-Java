package crud.dialogs;

import javaapplication2.SalesItemsTableD;
import classes.SuppSuppliesO;
import java.math.BigDecimal;
import javaapplication2.MyMethods;
import javax.swing.JOptionPane;
import modules.ItemsC;
import modules.SuppSuppliesC;

public class SuppSuppliesD extends javax.swing.JDialog {
    
    public int id = -1;
    int oldCount;
    String oldItemId;
    public int suppInvId;
    ItemsC i = new ItemsC();
    
    public SuppSuppliesD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        MyMethods.addEscapeListener( this );
        
        MyMethods.jTFRequestFocus( countText, priceText );
        
//        menu.add( listPanel );
        deleteBTN.setVisible( false );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        descText = new javax.swing.JTextField();
        countText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submitBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        updateItemsPriceCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("الاعداد");
        setResizable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("الوصف: ");

        descText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextActionPerformed(evt);
            }
        });
        descText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTextKeyReleased(evt);
            }
        });

        countText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("العدد: ");

        submitBTN.setText("اضافة");
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });

        deleteBTN.setBackground(java.awt.Color.red);
        deleteBTN.setText("حذف");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("سعر الشراء: ");

        priceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        updateItemsPriceCheckbox.setText("تحديث الاسعار فى جدول الاصناف");
        updateItemsPriceCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateItemsPriceCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(submitBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBTN))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(countText)
                                    .addComponent(priceText)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(updateItemsPriceCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBTN)
                    .addComponent(deleteBTN))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void descTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextActionPerformed
        // TODO add your handling code here:
        SalesItemsTableD it = new SalesItemsTableD( null, true );
        it.getDescText().setText( descText.getText() );
        
        it.setVisible( true );
        
        try {
            countText.requestFocus();
            
            descText.setText( it.itemsObject.getDescription() );
        } catch ( NullPointerException ex ) {}
    }//GEN-LAST:event_descTextActionPerformed

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        submitAction();
    }//GEN-LAST:event_submitBTNActionPerformed

    void submitAction() {
        int result = -1;
        
        String itemId = i.getItemId( descText.getText() );
        
        if ( itemId == null ) {
            JOptionPane.showMessageDialog( this, "هذا الصنف غير موجود...", "خطاء", 2 );
            descText.requestFocus();
            return;
        }
        
        if ( !countText.getText().matches("[0-9]+") ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيمة صحيحة فى حقل العدد...", "خطاء", 2 );
            return;
        }       
        
        if ( !priceText.getText().matches("([0-9]*[.])?[0-9]+") ) {
            JOptionPane.showMessageDialog( this, "يرجي ادخال قيمة صحيحة فى حقل السعر...", "خطاء", 2 );
            return;
        }       
        
        if ( submitBTN.getText() == "اضافة" ) {
            result = new SuppSuppliesC().insert( 
                itemId,
                priceText.getText(),
                countText.getText(), 
                Integer.toString( suppInvId )
            );
        } else if ( submitBTN.getText() == "تحديث" ) {
            result = new SuppSuppliesC().update(
                itemId,
                countText.getText(),
                priceText.getText(),
                Integer.toString( id )
            );
        }

        if ( result == 1 ) {
            if ( updateItemsPriceCheckbox.isSelected() ) {
                float price = Float.parseFloat( priceText.getText() );
                String wswsPrice;
                String wsPrice;
                String p;

                if ( price < 10 ) {
                    wswsPrice   = price + price * .4 + "";
                    wsPrice     = price + price * .5 + "";
                    p           = price + price * .9 + "";
                } else if ( price < 20 ) {
                    wswsPrice   = price + price * .3 + "";
                    wsPrice     = price + price * .4 + "";
                    p           = price + price * .7 + "";
                } else if ( price < 60 ) {
                    wswsPrice   = price + price * .25 + "";
                    wsPrice     = price + price * .3 + "";
                    p           = price + price * .5 + "";
                } else {
                    wswsPrice   = price + price * .15 + "";
                    wsPrice     = price + price * .2 + "";
                    p           = price + price * .4 + "";
                }
            
                new ItemsC().updatePrices(
                    priceText.getText(), 
                    p,
                    wsPrice,
                    wswsPrice,
                    itemId
                );
            }
            
            if ( submitBTN.getText().equals( "اضافة" ) )
                emptyFields();
            else if ( submitBTN.getText().equals( "تحديث" ) )
                this.dispose();
        }
    }
    
    public void initialze( int id ) {
        this.id = id;
        
        SuppSuppliesO obj = new SuppSuppliesC().getSingleItem( id );
        
        descText.setEnabled( false );
        
        oldCount = obj.count;
        oldItemId = obj.itemId;
        descText.setText( obj.desc );
        countText.setText( Integer.toString( obj.count ) );
        priceText.setText( obj.price + "" );
        
        
        submitBTN.setText( "تحديث");
        deleteBTN.setVisible( true ); 
        
        setVisible( true );
    }
    
    private void descTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTextKeyReleased
        // TODO add your handling code here:
//        switch ( evt.getKeyCode() ) {
//            case KeyEvent.VK_BACK_SPACE:
//                break;
//            case KeyEvent.VK_ENTER:
//                descText.setText( descText.getText() );
//                break;
//            default:
//                EventQueue.invokeLater( new Runnable() {
//                    @Override
//                    public void run() {
//                        autoCompleat( descText.getText() );
//                    }
//                });
//        }
    }//GEN-LAST:event_descTextKeyReleased

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        int warehouseStock = i.getWarehouseStock( oldItemId );
            
        if ( warehouseStock - oldCount < 0 ) {
            JOptionPane.showMessageDialog( this, "لا يوجد ما يكفي من القطع...", "خطاء", 2 );
            return;
        }
        
        new SuppSuppliesC().delete( id );
        
        dispose();
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
        submitBTNActionPerformed( null );
    }//GEN-LAST:event_priceTextActionPerformed

//    private void autoCompleat( String text) {
//        ArrayList<ItemsO> arr = new ItemsC().getAllForSearchText( descText.getText() );
//        
//        String compleate = "";
//        int start = text.length();
//        int last = text.length();
//        int a;
//        
//        for ( int i = 0; i < arr.size(); i++ ) {
//            if ( arr.get(i).getDescription().startsWith( text ) ) {
//                compleate = arr.get(i).getDescription();
//                last = compleate.length();
//                break;
//            }
//        }
//
//        if ( last > start ) {
//            descText.setText( compleate );
//            descText.setCaretPosition( last );
//            descText.moveCaretPosition( start );
//        }
//    }
    
    private void emptyFields() {
        descText.requestFocus();
        
        descText.setText( "" );
        countText.setText( "" );
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
            java.util.logging.Logger.getLogger(SuppSuppliesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuppSuppliesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuppSuppliesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuppSuppliesD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SuppSuppliesD dialog = new SuppSuppliesD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton deleteBTN;
    private javax.swing.JTextField descText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField priceText;
    private javax.swing.JButton submitBTN;
    private javax.swing.JCheckBox updateItemsPriceCheckbox;
    // End of variables declaration//GEN-END:variables
}
