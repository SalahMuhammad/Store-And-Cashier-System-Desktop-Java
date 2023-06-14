package javaapplication2;

import Methods.CustomersPanelMethods;
import Methods.SalesPanelMethods;
import classes.ItemsO;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modules.ItemsC;
import modules.SalesC;
import modules.SalesInvoicesC;

public class Sales extends javax.swing.JFrame {
    
    BigDecimal wsPrice = new BigDecimal(0);
    BigDecimal price = new BigDecimal(0);
    
    public Sales() {
        initComponents();
        
        // set frame to fit screen
        setExtendedState( JFrame.MAXIMIZED_BOTH );
        
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher( new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                ctrlHotKeys( e );
                
                shiftHotKeys( e );
                
                return false;
            }
        });
        
        customerIdLabel.setText( null );

        descText.requestFocus();
        
        calculateTotals(salesTable, itemsCountLabel, totalLabel );
        
        // tables text alignment
        MyMethods.jTableTextAlignment( salesTable, JLabel.CENTER );
        MyMethods.jTableTextAlignment( customersTable, JLabel.CENTER );
        
        MyMethods.jTableHeaderRendererTextToCenter( salesTable );
        MyMethods.jTableHeaderRendererTextToCenter( customersTable );
        
        salesTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        customersTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        // to forbid enter from go to next line
        MyMethods.createKeybindings( customersTable );
        MyMethods.createKeybindings( salesTable );
        
        // when pressed ented in first field second field request focus
        MyMethods.jTFRequestFocus( descText, qtyText2 );
        MyMethods.jTFRequestFocus( qtyText2, priceText1 );
        MyMethods.jTFRequestFocus( payText, noteText );
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        customerIdLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
        dateLabel = new javax.swing.JLabel();
        submitBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        descText = new javax.swing.JTextField();
        priceText1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        qtyText2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        wsPriceRadop = new javax.swing.JRadioButton();
        priceRadio = new javax.swing.JRadioButton();
        specialRadio = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        addBTN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        invoicesBTN = new javax.swing.JButton();
        resetBTN = new javax.swing.JButton();
        expensesBTN = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        cashCheckbox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        payText = new javax.swing.JTextField();
        itemsCountLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        noteText = new javax.swing.JTextField();
        nameBTN = new javax.swing.JButton();
        customersPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        customersFilterText = new javax.swing.JTextField();
        backBTN = new javax.swing.JButton();

        customerIdLabel.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("المبيعات");

        jPanel2.setLayout(new java.awt.CardLayout());

        salesTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salesTable.setForeground(java.awt.Color.blue);
        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "الاجمالي", "الكمية", "سعر القطعة", "الوصف", "الباركود", "المعرف"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTable.setRowHeight(35);
        salesTable.getTableHeader().setReorderingAllowed(false);
        salesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesTableMouseClicked(evt);
            }
        });
        salesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salesTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(salesTable);
        if (salesTable.getColumnModel().getColumnCount() > 0) {
            salesTable.getColumnModel().getColumn(3).setPreferredWidth(400);
        }

        dateLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dateLabel.setForeground(java.awt.Color.blue);
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        submitBTN.setText("اضافة الفاتورة");
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("سعر القطعة:");

        descText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descText.setForeground(java.awt.Color.blue);
        descText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTextActionPerformed(evt);
            }
        });

        priceText1.setEditable(false);
        priceText1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceText1.setForeground(java.awt.Color.blue);
        priceText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceText1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("الوصف: ");

        qtyText2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qtyText2.setForeground(java.awt.Color.blue);
        qtyText2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("العدد: ");

        buttonGroup1.add(wsPriceRadop);
        wsPriceRadop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        wsPriceRadop.setText("جملة");
        wsPriceRadop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wsPriceRadop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsPriceRadopActionPerformed(evt);
            }
        });

        buttonGroup1.add(priceRadio);
        priceRadio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceRadio.setSelected(true);
        priceRadio.setText("قطاعي");
        priceRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(specialRadio);
        specialRadio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialRadio.setText("خاص");
        specialRadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        specialRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wsPriceRadop, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialRadio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qtyText2)
                    .addComponent(priceText1)
                    .addComponent(descText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyText2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceText1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(priceRadio)
                        .addGap(18, 18, 18)
                        .addComponent(wsPriceRadop)
                        .addGap(18, 18, 18)
                        .addComponent(specialRadio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addBTN.setText("اضافة ");
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        jButton1.setText("وحدة التحكم");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        invoicesBTN.setText("الفواتير");
        invoicesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesBTNActionPerformed(evt);
            }
        });

        resetBTN.setText("اعادة ضبط");
        resetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTNActionPerformed(evt);
            }
        });

        expensesBTN.setText("المصروفات");
        expensesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expensesBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBTN)
                .addGap(18, 18, 18)
                .addComponent(resetBTN)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(invoicesBTN)
                .addGap(36, 36, 36)
                .addComponent(expensesBTN)
                .addGap(103, 103, 103))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN)
                    .addComponent(invoicesBTN)
                    .addComponent(jButton1)
                    .addComponent(resetBTN)
                    .addComponent(expensesBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cashCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cashCheckbox.setSelected(true);
        cashCheckbox.setText("نقدا");
        cashCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cashCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashCheckboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("مدفوع: ");

        payText.setEditable(false);
        payText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        payText.setForeground(java.awt.Color.blue);
        payText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        itemsCountLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        itemsCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ملاحظات:");

        noteText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        noteText.setForeground(java.awt.Color.blue);
        noteText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteTextActionPerformed(evt);
            }
        });

        nameBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameBTN.setForeground(java.awt.Color.blue);
        nameBTN.setText("اسم العميل: غير محدد");
        nameBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameBTNActionPerformed(evt);
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
                        .addComponent(itemsCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cashCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payText, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(noteText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashCheckbox))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(itemsCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(noteText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(submitBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitBTN)
                .addContainerGap())
        );

        jPanel2.add(salesPanel, "card2");

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        customersTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customersTable.setForeground(java.awt.Color.blue);
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المعرف", "الاسم", "ارقام الهاتف", "دين"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersTable.setRowHeight(35);
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersTableMouseClicked(evt);
            }
        });
        customersTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customersTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(customersTable);
        if (customersTable.getColumnModel().getColumnCount() > 0) {
            customersTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        customersFilterText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customersFilterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customersFilterTextKeyReleased(evt);
            }
        });

        backBTN.setText("عودة");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addComponent(customersFilterText, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(backBTN)))
                .addContainerGap())
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customersFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(customersPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void descTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTextActionPerformed
        // TODO add your handling code here:
        SalesItemsTableD it = new SalesItemsTableD( this, true );
        it.getDescText().setText( descText.getText() );
        
        it.setVisible( true );
        
        try {
            descText.setText( it.itemsObject.getDescription() );
            priceText1.setText( it.itemsObject.getPrice().toString() );

            wsPrice = it.itemsObject.getWs_price();
            price   = it.itemsObject.getPrice();
            
            priceText1.setEditable( false );
            priceRadio.setSelected( true );
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
        
//        priceText1.setText( priceText1.getText().isEmpty() ? "0" : null );
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
        model.addRow( new Object[]{ qty * Float.parseFloat( priceText1.getText() ), qtyText2.getText(), priceText1.getText(), descText.getText(), itemId, "" } );
        
        calculateTotals(salesTable, itemsCountLabel, totalLabel );
        
        emptyFields();
    }//GEN-LAST:event_addBTNActionPerformed

    // check if item exists in jtable
    boolean isItemExistsInJTable( JTable t, String itemId ) {
        for ( int i = 0; i < t.getRowCount(); i++ ) {
            if ( t.getValueAt( i, 4 ).equals( itemId ) )
                return true;
        }
        
        return false;
    }
    
    void calculateTotals( JTable t, JLabel count, JLabel total ) {
        float totalPrice = 0;
        int itemsCount = 0;
        
        for ( int i = 0; i < t.getRowCount(); i++ ) {
            totalPrice += Float.parseFloat( t.getValueAt( i, 0 ).toString() );
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
        
        price = null;
        wsPrice = null;
        priceRadio.setSelected( true );
        
        priceText1.setEditable( false );
    }
    
    private void salesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTableMouseClicked
        // TODO add your handling code here:
        if ( evt.getClickCount() == 2 ) {
            ItemsO i = new ItemsC().getItemPrice( salesTable.getValueAt( salesTable.getSelectedRow(), 4 ).toString() );
            price = i.getPrice();
            wsPrice = i.getWs_price();
            
            SalesPanelMethods.tableDoubleClickOrEnterAction( salesTable, price, wsPrice, descText, qtyText2, priceText1, priceRadio, wsPriceRadop, specialRadio );

            calculateTotals( salesTable, itemsCountLabel, totalLabel );
        }
    }//GEN-LAST:event_salesTableMouseClicked

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        // TODO add your handling code here:
        if ( ! payText.getText().matches( "([0-9]*[.])?[0-9]+") && ! cashCheckbox.isSelected() ) {
            JOptionPane.showMessageDialog( this, "قيم غير صالحة فى حقل الدفع...", "خطاء", 2 );
            payText.setText( "" );
            payText.requestFocus();
            return;
        }

        if ( ! payText.getText().isEmpty() && Float.parseFloat( payText.getText() ) == 1 ) {
            JOptionPane.showMessageDialog( this, "اقل قيمة مسوح بها فى حقل الدفع هي 2...", "خطاء", 2 );
            return;
        }
        
        if ( ( cashCheckbox.isSelected() || customerIdLabel.getText() == null ) && salesTable.getRowCount() <= 0 ) {
            JOptionPane.showMessageDialog( this, "يجب تحديد العميل والمبلغ المدفوع فى حال اضافة فاتورة تحصيل فقط او فارغة...", "خطاء", 2 );
            return;
        }
        
        if ( ! cashCheckbox.isSelected() && customerIdLabel.getText() == null && salesTable.getRowCount() > 0 ) {
            JOptionPane.showMessageDialog( this, "يجب تحديد العميل فى حال الدفع الاجل...", "خطاء", 2 );
            return;
        }
        
        add();
    }//GEN-LAST:event_submitBTNActionPerformed

    private void add() {
        String payed = cashCheckbox.isSelected() 
            ? "1"
            : payText.getText();
        
        int invoiceId = new SalesInvoicesC().insert2( customerIdLabel.getText(), payed, noteText.getText() );
        
        if ( salesTable.getRowCount() < 1 && invoiceId != -1 ) {
            JOptionPane.showMessageDialog( this, "تم ادراج فاتورة التحصيل بنجاح..." );
            resetBTNActionPerformed( null );
            return;
        }
        
        String values = "";
        for ( int i = 0; i < salesTable.getRowCount(); i++ ) {
//            if ( salesTable.getValueAt( i, 0 ).toString().isEmpty() ) {
                values += "( null, " 
                    + salesTable.getValueAt( i, 4 ).toString() + ", " 
                    + invoiceId + ", "
                    + salesTable.getValueAt( i, 2 ).toString() + ", "
                    + salesTable.getValueAt( i, 1 ).toString() + ")";

                if ( i != salesTable.getRowCount() - 1 )
                    values += ", ";
//            }
        }

        if ( new SalesC().insert( values ) >= 1  ) {
            JOptionPane.showMessageDialog( this, "تم ادراج الفاتورة بنجاح...");
        } else 
            return;
        
        resetBTNActionPerformed( null );
    }
    
    private void invoicesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesBTNActionPerformed
        // TODO add your handling code here:
        resetBTNActionPerformed( null );
        
        SalesInvoicesTableD salesInvoices = new SalesInvoicesTableD( this, true );
        salesInvoices.setVisible( true );
        
        if ( salesInvoices.invoiceId > 0 ) {
//            invoiceIdLabel.setText( Integer.toString( salesInvoices.invoiceId ) );

            payText.setText( salesInvoices.pay );
            nameBTN.setText( "اسم العميل: " + salesInvoices.name );
            noteText.setText( salesInvoices.note );
            SalesPanelMethods.displaySalesTransactions( salesTable, Integer.toString( salesInvoices.invoiceId ), dateLabel);
            
            calculateTotals( salesTable, itemsCountLabel, totalLabel );
            
            noteText.setEnabled( false );
            submitBTN.setEnabled( false );
            payText.setEnabled( false );
            nameBTN.setEnabled( false );
        }
    }//GEN-LAST:event_invoicesBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Console().setVisible( true );
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void customersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseClicked
        // TODO add your handling code here:
        CustomersPanelMethods.tableMouseClicked( evt, customersTable, customersFilterText.getText(), salesPanel, customersPanel, customerIdLabel, nameBTN );
    }//GEN-LAST:event_customersTableMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
        CustomersPanelMethods.customersRightClickEvent(evt);
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void customersFilterTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersFilterTextKeyReleased
        // TODO add your handling code here:
        CustomersPanelMethods.displayCustomers( customersTable, customersFilterText.getText() );
        
        MyMethods.onKeyDownTableRequestFocus( evt, customersTable );
    }//GEN-LAST:event_customersFilterTextKeyReleased

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        // TODO add your handling code here:
        salesPanel.setVisible( true );
        customersPanel.setVisible( false );
        
        customerIdLabel.setText( null );
        nameBTN.setText( "اسم العميل: غير محدد" );
    }//GEN-LAST:event_backBTNActionPerformed

    private void customersTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersTableKeyReleased
        // TODO add your handling code here:
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER && customersTable.getSelectedRow() >= 0 ) {
            CustomersPanelMethods.tableAction( salesPanel, customersPanel, customersTable, customerIdLabel, nameBTN );
        }
    }//GEN-LAST:event_customersTableKeyReleased

    private void resetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTNActionPerformed
        // TODO add your handling code here:
        emptyFields();
        
        submitBTN.setEnabled( true );
        payText.setEnabled( true );
        nameBTN.setEnabled( true );
        noteText.setEnabled( true );
        
        customerIdLabel.setText( null );
        nameBTN.setText( "اسم العميل: غير محدد" );
        
        ( ( DefaultTableModel ) salesTable.getModel() ).setRowCount( 0 );
        calculateTotals( salesTable, itemsCountLabel, totalLabel );
        
        dateLabel.setText( "" );
        
        noteText.setText( "" );
        payText.setText( "" );
        payText.setEditable( false );
        cashCheckbox.setSelected( true );
        
        price = null;
        wsPrice = null;
        priceRadio.setSelected( true );
    }//GEN-LAST:event_resetBTNActionPerformed

    private void priceRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceRadioActionPerformed
        // TODO add your handling code here:
        priceText1.setEditable( false );
        priceText1.setText( price.toString() );
    }//GEN-LAST:event_priceRadioActionPerformed

    private void wsPriceRadopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsPriceRadopActionPerformed
        // TODO add your handling code here:
        priceText1.setEditable( false );
        priceText1.setText( wsPrice.toString() );
    }//GEN-LAST:event_wsPriceRadopActionPerformed

    private void specialRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialRadioActionPerformed
        // TODO add your handling code here:
        priceText1.setEditable( true );
        priceText1.setText( "" );
        priceText1.requestFocus();
    }//GEN-LAST:event_specialRadioActionPerformed

    private void cashCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashCheckboxActionPerformed
        // TODO add your handling code here:
        if ( cashCheckbox.isSelected() ) {
            payText.setEditable( false );
            payText.setText( "" );
        } else {
            payText.setEditable( true );
            payText.requestFocus();
            
        }
    }//GEN-LAST:event_cashCheckboxActionPerformed

    private void noteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteTextActionPerformed
        // TODO add your handling code here:
        submitBTNActionPerformed( null );
    }//GEN-LAST:event_noteTextActionPerformed

    private void nameBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameBTNActionPerformed
        // TODO add your handling code here:
        salesPanel.setVisible( false );
        customersPanel.setVisible( true );
        
        customersFilterText.requestFocus();
    }//GEN-LAST:event_nameBTNActionPerformed

    boolean isCtrlPressed = true;
    /**
     * set price radios selection
     * 1 setPrice radio selection
     * 2 setwsPrice radio selection
     * 3 setSpecialPrice Radio Selection
     * a descText will request focus
     * 
     * @param evt 
     */
    public void ctrlHotKeys( KeyEvent evt ) {
        if ( evt.isControlDown() ) {
            
//            System.out.println("ssssss");
//            if ( evt.getKeyCode() == KeyEvent.VK_S) {
//                System.out.println("ffffff");
//            }
            switch( evt.getKeyCode() ) {
//                case KeyEvent.VK_S:
//                    System.out.println("aaaaaaaaaa");
////                    isCtrlPressed = false;
//                        if ( priceRadio.isSelected() ) {
////                            isCtrlPressed = false;
//                            wsPriceRadop.setSelected( true );
//                            wsPriceRadopActionPerformed( null );
//                        } else if ( wsPriceRadop.isSelected() ) {
////                            isCtrlPressed = false;
//                            specialRadio.setSelected( true );
//                            specialRadioActionPerformed( null );
//                        } else {
//                            isCtrlPressed = false;
//                            priceRadio.setSelected( true );
//                            priceRadioActionPerformed(null );
//                        }
////                        isCtrlPressed = false;
//                    System.out.println("aaaaaaaaaa");
//                        try {
//                            Runnable r = new Runnable() {
//                                @Override
//                                public void run() {
//                                    isCtrlPressed = true;
//                                }
//                            };
//                            Thread t = new Thread( r );
//                            t.start();
//                        } catch ( Exception ex) {
//                            JOptionPane.showMessageDialog( this, ex, "error", 0 );
//                        }
//                        
////                        break;
//                    break;
                    
//                    priceRadio.setSelected( true );
//                    priceRadioActionPerformed(null );
//                    break;
//                case KeyEvent.VK_2:
//                    wsPriceRadop.setSelected( true );
//                    wsPriceRadopActionPerformed( null );
//                    break;
//                case KeyEvent.VK_3:
//                    specialRadio.setSelected( true );
//                    specialRadioActionPerformed( null );
//                    break;
                case KeyEvent.VK_A:
                    descText.requestFocus();
                    break;
                case KeyEvent.VK_T:
                    if ( salesTable.getRowCount() >= 1 ) {
                        salesTable.setRowSelectionInterval( 0, 0 );
                        salesTable.requestFocus();
                    }
                    break;
//                case KeyEvent.VK_L:
//                    expensesBTNActionPerformed( null );
//                    break;
            }
            isCtrlPressed = false;
        }
        
    }
    
    boolean isShiftPressed = true;
    /**
     * enter insert invoice
     * 
     * @param evt 
     */
    public void shiftHotKeys( KeyEvent evt ) {
        if ( evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_ENTER && isShiftPressed ) {
            isShiftPressed = false;
            submitBTNActionPerformed( null );
            
            try {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        isShiftPressed = true;
                    }
                };
                Thread t = new Thread( r );
                t.start();
            } catch ( Exception ex) {
                JOptionPane.showMessageDialog( this, ex, "error", 0 );
            }
        }
    }
    
    private void priceText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceText1ActionPerformed
        // TODO add your handling code here:
        addBTNActionPerformed( null );
    }//GEN-LAST:event_priceText1ActionPerformed

    private void salesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salesTableKeyReleased
        // TODO add your handling code here:
       if ( evt.getKeyCode() == KeyEvent.VK_ENTER && salesTable.getSelectedRow() != -1 ) {
            ItemsO i = new ItemsC().getItemPrice( salesTable.getValueAt( salesTable.getSelectedRow(), 4 ).toString() );
            price = i.getPrice();
            wsPrice = i.getWs_price();

            SalesPanelMethods.tableDoubleClickOrEnterAction( salesTable, price, wsPrice, descText, qtyText2, priceText1, priceRadio, wsPriceRadop, specialRadio );

            calculateTotals( salesTable, itemsCountLabel, totalLabel );
       }
    }//GEN-LAST:event_salesTableKeyReleased

    private void expensesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expensesBTNActionPerformed
        // TODO add your handling code here:
        new ExpensesTableD( this, true ).init( "12", "" );
    }//GEN-LAST:event_expensesBTNActionPerformed
   
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
    private javax.swing.JButton backBTN;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cashCheckbox;
    private javax.swing.JLabel customerIdLabel;
    private javax.swing.JTextField customersFilterText;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JTable customersTable;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField descText;
    private javax.swing.JButton expensesBTN;
    private javax.swing.JButton invoicesBTN;
    private javax.swing.JLabel itemsCountLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nameBTN;
    private javax.swing.JTextField noteText;
    private javax.swing.JTextField payText;
    private javax.swing.JRadioButton priceRadio;
    private javax.swing.JTextField priceText1;
    private javax.swing.JTextField qtyText2;
    private javax.swing.JButton resetBTN;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JTable salesTable;
    private javax.swing.JRadioButton specialRadio;
    private javax.swing.JButton submitBTN;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JRadioButton wsPriceRadop;
    // End of variables declaration//GEN-END:variables
}
