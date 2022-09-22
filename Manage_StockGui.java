/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobile.shop.GUI;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import mobile.shop.Dao.ManageCategoryDao;
import mobile.shop.Dao.ManageProductDao;
import mobile.shop.bean.Categorysbean;
import mobile.shop.Dao.ManageStockDao;
import mobile.shop.bean.Productbean; 

/**
 *
 * @author Dipak
 */
public class Manage_StockGui extends javax.swing.JInternalFrame {
         public static Categorysbean cat;
         public static Productbean products;
         //public static Productbean product;
         
    /**
     * Creates new form Menu1
     */
    public Manage_StockGui() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui =(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
          showTable();
      
       // this.setLocation(0,0);
        
            

    }
    public void showTable()
    {
         DefaultTableModel Df =(DefaultTableModel)jTable1.getModel();
         Df.setRowCount(0);
         ManageStockDao m = new ManageStockDao();
        
         m.getDetails();
         
         for(int j=0;j<ManageStockDao.p_id.size() && j<ManageStockDao.coloumncount;j++){
            // for(int i=1;i< ManageStockDao.coloumncount;i++){
            Vector v = new Vector();    
                v.add(ManageStockDao.p_id.get(j));
                
                 v.add(ManageStockDao.p_Name.get(j));
                 v.add(ManageStockDao.p_quantity.get(j));
                 
             //}
             Df.addRow(v);
         }
             
 
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        combocat = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        combocat8 = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        combocat9 = new javax.swing.JComboBox();
        quntity = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Addbtn = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setForeground(java.awt.Color.black);

        jPanel1.setBackground(new java.awt.Color(131, 169, 215));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Available Stock");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel48.setText("Select Category");

        combocat.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        combocat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        combocat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combocatFocusGained(evt);
            }
        });
        combocat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                combocatMouseEntered(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel35.setText("Select Sub Category");

        combocat8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        combocat8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        combocat8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combocat8FocusGained(evt);
            }
        });
        combocat8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                combocat8MouseEntered(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel36.setText("Select Product");

        combocat9.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        combocat9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        combocat9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocat9ItemStateChanged(evt);
            }
        });
        combocat9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combocat9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combocat9FocusLost(evt);
            }
        });
        combocat9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combocat9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                combocat9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                combocat9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combocat9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combocat9MouseReleased(evt);
            }
        });
        combocat9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocat9ActionPerformed(evt);
            }
        });

        quntity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quntity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel23.setText("Enter Quantiy");

        Addbtn.setBackground(new java.awt.Color(16, 72, 119));
        Addbtn.setBorder(null);
        Addbtn.setForeground(new java.awt.Color(16, 72, 119));
        Addbtn.setText("Add");
        Addbtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        Addbtn.setkBackGroundColor(new java.awt.Color(16, 72, 119));
        Addbtn.setkBorderRadius(35);
        Addbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Addbtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        Addbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        Addbtn.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        Addbtn.setkPressedColor(new java.awt.Color(0, 204, 204));
        Addbtn.setkSelectedColor(new java.awt.Color(16, 72, 119));
        Addbtn.setkStartColor(new java.awt.Color(0, 51, 255));
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Id", "Product Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Add New Stock");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(combocat8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quntity, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combocat9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(combocat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combocat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(combocat8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(combocat9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(quntity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1059, 607);
    }// </editor-fold>//GEN-END:initComponents

    private void combocatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combocatFocusGained
      
        ManageCategoryDao m=new ManageCategoryDao();
      combocat.removeAllItems();
       m.getCategory();
       
        for(int i=0;i<m.cate.size();i++)
        {

            combocat.addItem(m.cate.get(i));
        }
               
    }//GEN-LAST:event_combocatFocusGained

    private void combocatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_combocatMouseEntered

    private void combocat8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combocat8FocusGained
        cat = new Categorysbean();
      cat.setCategory_Title((String)combocat.getSelectedItem()); 
      combocat8.removeAllItems();
       ManageStockDao m=new  ManageStockDao();
        ManageStockDao.sub.clear();
         m.getSpecificSubcat();
         for(int i=0;i<ManageStockDao.sub.size();i++)
           {
               
                combocat8.addItem(ManageStockDao.sub.get(i));
           }      

    }//GEN-LAST:event_combocat8FocusGained

    private void combocat8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_combocat8MouseEntered

    private void combocat9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocat9ItemStateChanged

    }//GEN-LAST:event_combocat9ItemStateChanged

    private void combocat9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combocat9FocusGained
               combocat9.removeAllItems();
        cat.setSub_Category_Title((String)combocat8.getSelectedItem());
            ManageStockDao m=new  ManageStockDao();
           ManageStockDao.products.clear();
           m.getproductnames();
         for(int i=0;i<ManageStockDao.products.size();i++)
           {
               
                combocat9.addItem(ManageStockDao.products.get(i));
           }       
    }//GEN-LAST:event_combocat9FocusGained

    private void combocat9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combocat9FocusLost

    }//GEN-LAST:event_combocat9FocusLost

    private void combocat9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat9MouseClicked

    }//GEN-LAST:event_combocat9MouseClicked

    private void combocat9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat9MouseEntered

    }//GEN-LAST:event_combocat9MouseEntered

    private void combocat9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_combocat9MouseExited

    private void combocat9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat9MousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_combocat9MousePressed

    private void combocat9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combocat9MouseReleased

    }//GEN-LAST:event_combocat9MouseReleased

    private void combocat9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocat9ActionPerformed
      
    }//GEN-LAST:event_combocat9ActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
          products = new Productbean();
          products.setName((String)combocat9.getSelectedItem());
          products.setQuantity(Integer.parseInt(quntity.getText()));
          ManageStockDao m = new ManageStockDao();
          m.UpdateStock();
          showTable();
          
      
          
    }//GEN-LAST:event_AddbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Addbtn;
    private javax.swing.JComboBox combocat;
    private javax.swing.JComboBox combocat8;
    private javax.swing.JComboBox combocat9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField quntity;
    // End of variables declaration//GEN-END:variables
}
