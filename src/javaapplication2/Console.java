package javaapplication2;

import java.awt.CardLayout;
import Methods.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//import raven.glasspanepopup.glassPanePopup;

public class Console extends javax.swing.JFrame {

    CardLayout cardLayout;
    public Console() {
        initComponents();
        
        itemsTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        countTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        suppInvTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        suppInfoTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        orderItemsTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        itemsFiterText.requestFocus();
        cardLayout = ( CardLayout ) cardPanel.getLayout();
        
//        new ItemsMethods().display( null, itemsTable, null );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        itemsBTN = new javax.swing.JButton();
        suppInfoBTN = new javax.swing.JButton();
        suppInvBTN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        warehouseBTN = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        itemsPanel = new javax.swing.JPanel();
        itemsFiterText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        suppInfoPanel = new javax.swing.JPanel();
        suppInfoFiterText1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        suppInfoTable = new javax.swing.JTable();
        suppInvPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        countTable = new javax.swing.JTable();
        suppInvFilterText = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        suppInvTable = new javax.swing.JTable();
        imgLabel = new javax.swing.JLabel();
        itemsOrdersPanel = new javax.swing.JPanel();
        ordersItemsFilterText = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        orderItemsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("وحدة التحكم");

        itemsBTN.setText("الاصناف");
        itemsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsBTNActionPerformed(evt);
            }
        });

        suppInfoBTN.setText("الموردين");
        suppInfoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppInfoBTNActionPerformed(evt);
            }
        });

        suppInvBTN.setText("الفواتير");
        suppInvBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppInvBTNActionPerformed(evt);
            }
        });

        jButton1.setText("عودة للخلف");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        warehouseBTN.setText("طلب اصناف");
        warehouseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addComponent(warehouseBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(suppInvBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suppInfoBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemsBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemsBTN)
                .addGap(18, 18, 18)
                .addComponent(suppInfoBTN)
                .addGap(18, 18, 18)
                .addComponent(suppInvBTN)
                .addGap(18, 18, 18)
                .addComponent(warehouseBTN)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardPanel.setLayout(new java.awt.CardLayout());

        itemsFiterText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itemsFiterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemsFiterTextKeyReleased(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        itemsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemsTable.setForeground(java.awt.Color.blue);
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "البار كود", "الوصف", "الشراء", "جملة الجملة", "الجملة", "قطاعي", "قطع المخزن", "قطع المحل"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.setRowHeight(30);
        itemsTable.getTableHeader().setReorderingAllowed(false);
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);
        if (itemsTable.getColumnModel().getColumnCount() > 0) {
            itemsTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        javax.swing.GroupLayout itemsPanelLayout = new javax.swing.GroupLayout(itemsPanel);
        itemsPanel.setLayout(itemsPanelLayout);
        itemsPanelLayout.setHorizontalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemsFiterText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
        );
        itemsPanelLayout.setVerticalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemsFiterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardPanel.add(itemsPanel, "card2");

        suppInfoFiterText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        suppInfoFiterText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                suppInfoFiterText1KeyReleased(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        suppInfoTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suppInfoTable.setForeground(java.awt.Color.blue);
        suppInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "الاسم", "رقم الهاتف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppInfoTable.setRowHeight(30);
        suppInfoTable.getTableHeader().setReorderingAllowed(false);
        suppInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suppInfoTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(suppInfoTable);

        javax.swing.GroupLayout suppInfoPanelLayout = new javax.swing.GroupLayout(suppInfoPanel);
        suppInfoPanel.setLayout(suppInfoPanelLayout);
        suppInfoPanelLayout.setHorizontalGroup(
            suppInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppInfoFiterText1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(suppInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(suppInfoPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        suppInfoPanelLayout.setVerticalGroup(
            suppInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppInfoFiterText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addGroup(suppInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suppInfoPanelLayout.createSequentialGroup()
                    .addContainerGap(47, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        cardPanel.add(suppInfoPanel, "card3");

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        countTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        countTable.setForeground(java.awt.Color.blue);
        countTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "الوصف", "عدد القطع"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        countTable.setRowHeight(30);
        countTable.getTableHeader().setReorderingAllowed(false);
        countTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                countTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(countTable);
        if (countTable.getColumnModel().getColumnCount() > 0) {
            countTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        suppInvFilterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                suppInvFilterTextKeyReleased(evt);
            }
        });

        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane4MouseClicked(evt);
            }
        });

        suppInvTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suppInvTable.setForeground(java.awt.Color.blue);
        suppInvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "التاريخ", "سعر الفاتورة", "ملاحظات", "اسم المورد"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppInvTable.setRowHeight(30);
        suppInvTable.getTableHeader().setReorderingAllowed(false);
        suppInvTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suppInvTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(suppInvTable);
        if (suppInvTable.getColumnModel().getColumnCount() > 0) {
            suppInvTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            suppInvTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout suppInvPanelLayout = new javax.swing.GroupLayout(suppInvPanel);
        suppInvPanel.setLayout(suppInvPanelLayout);
        suppInvPanelLayout.setHorizontalGroup(
            suppInvPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppInvPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suppInvPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suppInvFilterText)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addGroup(suppInvPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        suppInvPanelLayout.setVerticalGroup(
            suppInvPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppInvPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(suppInvFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(suppInvPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suppInvPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(suppInvPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        cardPanel.add(suppInvPanel, "card4");

        ordersItemsFilterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ordersItemsFilterTextKeyReleased(evt);
            }
        });

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        orderItemsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        orderItemsTable.setForeground(java.awt.Color.blue);
        orderItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "الوصف", "صرف", "التاريخ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderItemsTable.setRowHeight(30);
        orderItemsTable.getTableHeader().setReorderingAllowed(false);
        orderItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                orderItemsTableMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(orderItemsTable);
        if (orderItemsTable.getColumnModel().getColumnCount() > 0) {
            orderItemsTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            orderItemsTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout itemsOrdersPanelLayout = new javax.swing.GroupLayout(itemsOrdersPanel);
        itemsOrdersPanel.setLayout(itemsOrdersPanelLayout);
        itemsOrdersPanelLayout.setHorizontalGroup(
            itemsOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsOrdersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ordersItemsFilterText, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
        );
        itemsOrdersPanelLayout.setVerticalGroup(
            itemsOrdersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsOrdersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ordersItemsFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        cardPanel.add(itemsOrdersPanel, "card5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMousePressed
        // TODO add your handling code here:
        setCardPanelPanelsVisibleToFalse();
        new ItemsPanelMethods().tableMousePressed( evt, itemsTable, suppInvTable, countTable, suppInvPanel, itemsFiterText );
    }//GEN-LAST:event_itemsTableMousePressed

    private void itemsFiterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemsFiterTextKeyReleased
        // TODO add your handling code here:
        if ( itemsFiterText.getText().isEmpty() ) {
            ( ( DefaultTableModel ) itemsTable.getModel() ).setRowCount( 0 );
            return;
        }

        new ItemsPanelMethods().fiterTextKeyReleased( itemsFiterText, itemsTable );
        
        MyMethods.onKeyDownTableRequestFocus( evt, itemsTable );
    }//GEN-LAST:event_itemsFiterTextKeyReleased

    private void suppInfoFiterText1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppInfoFiterText1KeyReleased
        // TODO add your handling code here:
        if ( suppInfoFiterText1.getText().isEmpty() ) {
            ( ( DefaultTableModel ) suppInfoTable.getModel() ).setRowCount( 0 );
            return;
        }
        
        new SuppInfoPanelMethods().fiterTextKeyReleased( suppInfoFiterText1, suppInfoTable );
        
        MyMethods.onKeyDownTableRequestFocus( evt, suppInfoTable );
    }//GEN-LAST:event_suppInfoFiterText1KeyReleased

    private void suppInfoTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppInfoTableMousePressed
        new SuppInfoPanelMethods().tableMousePressed( evt, suppInfoTable, suppInfoFiterText1 );
    }//GEN-LAST:event_suppInfoTableMousePressed

    private void countTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countTableMousePressed
        // TODO add your handling code here:
        if ( suppInvTable.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog( this, "لم يتم تحديد فاتورة...", "خطاء", 2 );
            return;
        }
        
        new SuppSuppliesPanelMethods().tableMousePressed( evt, countTable, suppInvTable );
    }//GEN-LAST:event_countTableMousePressed

    private void suppInfoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppInfoBTNActionPerformed
        // TODO add your handling code here:
        setCardPanelPanelsVisibleToFalse();
        suppInfoPanel.setVisible( true );
        
        suppInfoFiterText1.requestFocus();
    }//GEN-LAST:event_suppInfoBTNActionPerformed

    private void itemsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsBTNActionPerformed
        // TODO add your handling code here:
        setCardPanelPanelsVisibleToFalse();
        itemsPanel.setVisible( true );
        
        itemsFiterText.requestFocus();
    }//GEN-LAST:event_itemsBTNActionPerformed

    private void suppInvFilterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppInvFilterTextKeyReleased
        // TODO add your handling code here:
        if ( suppInvFilterText.getText().isEmpty() ){
            ( ( DefaultTableModel ) suppInvTable.getModel() ).setRowCount( 0 );
            return;
        }
        
        new SuppliersInvPanelMethods().fiterTextKeyReleased( suppInvFilterText, suppInvTable );
        
        MyMethods.onKeyDownTableRequestFocus( evt, suppInvTable );
    }//GEN-LAST:event_suppInvFilterTextKeyReleased

    private void suppInvBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppInvBTNActionPerformed
        // TODO add your handling code here:
        setCardPanelPanelsVisibleToFalse();
        suppInvPanel.setVisible( true );
        
        suppInvFilterText.requestFocus();
    }//GEN-LAST:event_suppInvBTNActionPerformed

    private void suppInvTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppInvTableMousePressed
        // TODO add your handling code here:
        new SuppliersInvPanelMethods().tableMousePressed(evt, suppInvTable, countTable, imgLabel, suppInvFilterText );
    }//GEN-LAST:event_suppInvTableMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new JavaApplication2().frame.setVisible( true );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ordersItemsFilterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ordersItemsFilterTextKeyReleased
        // TODO add your handling code here:
        if ( ordersItemsFilterText.getText().isEmpty() ) {
            ( ( DefaultTableModel ) orderItemsTable.getModel() ).setRowCount(0);
            return;
        }
        
        new ItemsOrdersPanelMethods().fiterTextKeyReleased( ordersItemsFilterText.getText(), orderItemsTable );    
        
        MyMethods.onKeyDownTableRequestFocus( evt, orderItemsTable );
    }//GEN-LAST:event_ordersItemsFilterTextKeyReleased

    private void orderItemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderItemsTableMousePressed
        // TODO add your handling code here:
        new ItemsOrdersPanelMethods().tableMousePressed( evt, orderItemsTable, ordersItemsFilterText.getText() );
    }//GEN-LAST:event_orderItemsTableMousePressed

    private void warehouseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseBTNActionPerformed
        // TODO add your handling code here:
        setCardPanelPanelsVisibleToFalse();
        itemsOrdersPanel.setVisible( true );
        
        ordersItemsFilterText.requestFocus();
    }//GEN-LAST:event_warehouseBTNActionPerformed

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        // TODO add your handling code here:
        new ItemsOrdersPanelMethods().rightClickAction( evt, orderItemsTable, ordersItemsFilterText.getText() );
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
        if ( suppInvTable.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog( this, "لم يتم تحديد فاتورة...", "خطاء", 2 );
            return;
        }
        
        new SuppSuppliesPanelMethods().rightClickEvent(evt, countTable, suppInvTable );
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
        new SuppInfoPanelMethods().righClickAction( evt, suppInfoTable, suppInfoFiterText1 );
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jScrollPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4MouseClicked
        // TODO add your handling code here:
        new SuppliersInvPanelMethods().tableSingleClickEvent(evt, suppInvTable, countTable, suppInvFilterText );
    }//GEN-LAST:event_jScrollPane4MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        new ItemsPanelMethods().rightClickEvent( evt, itemsTable, itemsFiterText );
    }//GEN-LAST:event_jScrollPane1MouseClicked
    
    private void setCardPanelPanelsVisibleToFalse() {
//        ArrayList<JPanel> caraPanelsList = new ArrayList();
        itemsPanel.setVisible( false );
        suppInfoPanel.setVisible( false );
        suppInvPanel.setVisible( false );
        itemsOrdersPanel.setVisible( false );
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
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Console().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JTable countTable;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton itemsBTN;
    private javax.swing.JTextField itemsFiterText;
    private javax.swing.JPanel itemsOrdersPanel;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JTable itemsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable orderItemsTable;
    private javax.swing.JTextField ordersItemsFilterText;
    private javax.swing.JButton suppInfoBTN;
    private javax.swing.JTextField suppInfoFiterText1;
    private javax.swing.JPanel suppInfoPanel;
    private javax.swing.JTable suppInfoTable;
    private javax.swing.JButton suppInvBTN;
    private javax.swing.JTextField suppInvFilterText;
    private javax.swing.JPanel suppInvPanel;
    private javax.swing.JTable suppInvTable;
    private javax.swing.JButton warehouseBTN;
    // End of variables declaration//GEN-END:variables
}
