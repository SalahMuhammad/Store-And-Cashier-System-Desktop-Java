package crud.dialogs;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javaapplication2.MyMethods;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modules.SuppliersInfoC;
import modules.SuppliersInvC;

public class SuppliersInvD extends javax.swing.JDialog {
    
    InputStream inputStream = null;
    
    int id;

    public SuppliersInvD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        MyMethods.addEscapeListener( this );
        
        deleteBTN.setVisible( false );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        browseBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        suppNameText = new javax.swing.JTextField();
        invPriceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        submitBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        noteText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        browseBTN.setText("تحديد صورة الفاتورة");
        browseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBTNActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("اسم المورد: ");

        suppNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        suppNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppNameTextActionPerformed(evt);
            }
        });

        invPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invPriceTextActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("اجمالي سعر الفتورة: ");

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

        noteText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteTextActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ملاحظة: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(noteText)
                            .addComponent(submitBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(browseBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(suppNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(invPriceText))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(browseBTN)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBTN)
                    .addComponent(deleteBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        submitAction();
    }//GEN-LAST:event_submitBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog( this, "هل انت متاكد من حذف هذة الفتورة مع الاصناف الموجودة بها ؟", "تاكيد", 0 );
        
        if ( result == JOptionPane.YES_OPTION ) {
            new SuppliersInvC().delete( id );
                
            dispose();
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void invPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invPriceTextActionPerformed
        // TODO add your handling code here:
        noteText.requestFocus();
    }//GEN-LAST:event_invPriceTextActionPerformed

    private void suppNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppNameTextActionPerformed
        // TODO add your handling code here:
        invPriceText.requestFocus();
    }//GEN-LAST:event_suppNameTextActionPerformed

    private void browseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBTNActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null);
        if (response == fileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();

            displayImageInLabel( imgLabel, path );

            File f = new File( path );
            try {
                inputStream = new FileInputStream( f );
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog( this, "لم يتم العثور على الصورة...", "اخطار", 2 );
            }
        }
    }//GEN-LAST:event_browseBTNActionPerformed

    private void noteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteTextActionPerformed
        // TODO add your handling code here:
        submitAction();
    }//GEN-LAST:event_noteTextActionPerformed

    public void displayImageInLabel( JLabel label, String path ) {
        ImageIcon imageIcon = new ImageIcon( path );
        Image img = imageIcon.getImage().getScaledInstance(
                label.getWidth(), 
                label.getHeight(), 
                Image.SCALE_SMOOTH
        );

        label.setIcon( new ImageIcon(img) );
    }
    
    void submitAction() {
        int result = 0;
        
        if( ! invPriceText.getText().matches( "\\d+") ) {
           JOptionPane.showMessageDialog( this, "سعر الفاتورة غير صحيح...", "اخطار", 2);
           return;
        }
        
        int suppID = new SuppliersInfoC().getSupplierID( suppNameText.getText() );
            
        if ( suppID == -1 ) {
            JOptionPane.showMessageDialog( this, "هذا المورد غير موجود...", "اخطار", 2 );
            return;
        }
        
        if ( submitBTN.getText() == "اضافة" ) {            
            result = new SuppliersInvC().insert( inputStream, suppID, Integer.parseInt( invPriceText.getText() ), noteText.getText() );
        } else if ( submitBTN.getText() == "تحديث" ){
            new SuppliersInvC().update( id , inputStream, Integer.parseInt( invPriceText.getText() ), suppID, noteText.getText() );
            this.dispose();
        }
        
        if ( result == -1 ) return;

        emptyFields();
    }
    
    public void initialze( int id, byte[] bytes, String supplierName, String invPrice, String note) {
        this.id = id;
        setTitle( "فاتورة " + supplierName );
        
        invPriceText.requestFocus();
        
        suppNameText.setText( supplierName );
        invPriceText.setText( invPrice );
        noteText.setText( note );
        submitBTN.setText( "تحديث");
        
        deleteBTN.setVisible( true );

        try {
            ImageIcon ii = new ImageIcon ( 
            new ImageIcon( bytes ).getImage()
                .getScaledInstance( imgLabel.getWidth(), imgLabel.getHeight(), java.awt.Image.SCALE_SMOOTH ) 
            );
            imgLabel.setIcon( ii );
            inputStream = new ByteArrayInputStream( bytes );
        } catch ( NullPointerException ex ) {}

        this.setVisible( true );
    }
    
    private void emptyFields() {
        invPriceText.requestFocus();
        
//        suppNameText.setText( "" );
        invPriceText.setText( "" );
        noteText.setText( "" );
        imgLabel.setIcon( null );
        
        try {
            inputStream.close();
            inputStream = null;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog( this , ex, "Error", 2 );
        } catch ( NullPointerException ex ) {
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
            java.util.logging.Logger.getLogger(SuppliersInvD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuppliersInvD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuppliersInvD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuppliersInvD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SuppliersInvD dialog = new SuppliersInvD(new javax.swing.JFrame(), true);
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

    public JTextField getSuppNameText() {
        return suppNameText;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseBTN;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JTextField invPriceText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField noteText;
    private javax.swing.JButton submitBTN;
    private javax.swing.JTextField suppNameText;
    // End of variables declaration//GEN-END:variables
}
