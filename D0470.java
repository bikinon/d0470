/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d0470;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author master
 */
public class D0470 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public D0470() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        wsz = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dsz = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFilePathName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dimtype = new javax.swing.JComboBox<>();
        blksz = new javax.swing.JLabel();
        createDxf = new javax.swing.JButton();
        r2r2upint = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBlkSz = new javax.swing.JButton();
        lsz = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cflutetype = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtLidFlap = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FEFCO 0470");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Flute:");

        wsz.setText("300");

        jLabel5.setText("x");

        dsz.setText("200");

        jLabel6.setText("x");

        txtFilePathName.setText("aa0470.dxf");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("File Name:");

        dimtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID: Internal Dimensions", "BB: Bend to Bend", "OD: Outside Dimensions" }));
        dimtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimtypeActionPerformed(evt);
            }
        });

        blksz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        blksz.setText("1up Blank Size:");

        createDxf.setText("Create DXF Drawing");
        createDxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDxfActionPerformed(evt);
            }
        });

        r2r2upint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r2r2upint.setText("Multi Up:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Dim Type:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0470", "0470 P/S & T/S" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Style:");

        btnBlkSz.setText("Calc Blank Size");
        btnBlkSz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlkSzActionPerformed(evt);
            }
        });

        lsz.setText("350");
        lsz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lszActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Pack Size:");

        cflutetype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E 2mm", "B 3mm", "C 5mm", "D (M, R, S) 2.5mm", "EB 5mm", "F 1mm", "G (N) 0.6mm", "BC 7mm" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Lid Tab:");

        txtLidFlap.setText("35");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(createDxf, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(btnBlkSz, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r2r2upint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blksz, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lsz, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wsz, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dsz, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLidFlap, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cflutetype, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFilePathName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimtype, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dimtype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lsz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(wsz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dsz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtLidFlap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFilePathName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cflutetype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addComponent(blksz)
                .addGap(18, 18, 18)
                .addComponent(r2r2upint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBlkSz, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createDxf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public double idLength = 0;
  public double idWidth = 0;
  public double idDepth = 0;
  public double odLength = 0;
  public double odWidth = 0;
  public double odDepth = 0;
  // end attributes
  
  
  
    private void dimtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dimtypeActionPerformed

    private void createDxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDxfActionPerformed
        String flute = (String) cflutetype.getSelectedItem();
        flute = flute.substring(0, 2).trim();
        
        this.getSizes();  // Get ID / OD sizes
        String outputDxfData = "";

        draw0470 oDxf = new draw0470();

        oDxf.xabs = 0;
        oDxf.yabs = 0;
        oDxf.l = this.idLength;
        oDxf.w = this.idWidth;
        oDxf.d = this.idDepth;
        oDxf.tuckflap = Double.parseDouble(this.txtLidFlap.getText());
        int slotVal = 0; // Rounded Ends - No point in other slot types with this design
//        if (this.cmbSlotType.getSelectedItem().toString() == "Square Ends") {
//            slotVal = 1; // Square Ends
//        } else if (this.cmbSlotType.getSelectedItem().toString() == "U Cut") {
//            slotVal = 2; // U Cut
//        }
        oDxf.slotType = slotVal;

        oDxf.unit = "M";
        oDxf.style = "";
        oDxf.flute = flute;
        oDxf.CUT = "CUT";
        oDxf.CREASE = "CREASE";
        oDxf.dxf = ""; // Output File's contents
        oDxf.dxfxmax = "0";
        oDxf.dxfymax = "0";

        oDxf.Xaxis = 1; // Direction of X axis +1 or -1
        oDxf.Yaxis = 1; // Direction of Y axis +1 or -1
        oDxf.allowanceSetup();

        outputDxfData = oDxf.Draw0470();

        String outputDir = ""; // "/home/tim/NetBeansProjects/T0427/src/t0427/"; // "../temp/";
        File f = new File(outputDir + txtFilePathName.getText());
        if(f.exists() && !f.isDirectory()) {
            f.delete();
        }
        String outputDxfFile = outputDir + txtFilePathName.getText(); // "testfilel.dxf"; // "/var/www/temp/testfilel.dxf";

        BufferedWriter writer = null; // Note outside try block
        try {
            //create a file
            File newDxfFile = new File(outputDxfFile);

            writer = new BufferedWriter(new FileWriter(newDxfFile));
            writer.write(outputDxfData);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }

        JOptionPane.showMessageDialog(null, "Saved: " + outputDxfFile);
    }//GEN-LAST:event_createDxfActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnBlkSzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlkSzActionPerformed
        String flute = (String) cflutetype.getSelectedItem();
        flute = flute.substring(0, 2).trim();
        
        this.getSizes();  // Get ID / OD sizes
        draw0470 oDxf = new draw0470();
        oDxf.unit = "M";
        oDxf.flute = flute;
        oDxf.l = this.idLength;
        oDxf.w = this.idWidth;
        oDxf.d = this.idDepth;
        oDxf.tuckflap = Double.parseDouble(this.txtLidFlap.getText());
        
        oDxf.allowanceSetup();

        System.out.println("1up Blank Size: " + oDxf.blks1 +  " x " + oDxf.blkn2);
        BoardSz oMc = new BoardSz();
        oMc.blkS1 = oDxf.blks1;
        oMc.blkN2 = oDxf.blkn2;
        oMc.blkInsetN2 = oDxf.blkn2; //375;
        oMc.diecutter = "Elite";
        oMc.asymmetrical = false;
        String msg = oMc.CalcR2R();

        blksz.setText("1up Blank Size: " + oDxf.blks1 +  " x " + oDxf.blkn2);
        //r2r2upint.setText("INTERLOCK: " +  + oDxf.noUpS1 + "up " + oDxf.interlockblks1 + " x " + oDxf.interlockblkn2 + " " + oDxf.noUpN2 + "up");
        r2r2upint.setText(msg);

        // r2r2upint.setText("INTERLOCK: " +  + oDxf.noUpS1 + "up " + oDxf.interlockblks1 + " x " + oDxf.interlockblkn2 + " " + oDxf.noUpN2 + "up");
    }//GEN-LAST:event_btnBlkSzActionPerformed


  public void getSizes() {
    double l = Double.parseDouble(lsz.getText());
    double w = Double.parseDouble(wsz.getText());
    double d = Double.parseDouble(dsz.getText());
    double lengthPlus = 0; // Bulge Figures
    double widthPlus = 0;
    double depthPlus = 0;
    String flute = (String) cflutetype.getSelectedItem();
    flute = flute.substring(0, 2).trim();
    
    // Get Allowances
    draw0470 oDxf = new draw0470();
    oDxf.l = 0;
    oDxf.w = 0;
    oDxf.d = 0;
    oDxf.flute = flute;
    oDxf.allowanceSetup();
    
    if (dimtype.getSelectedItem() == "ID: Internal Dimensions") {
      this.idLength = l; 
      this.idWidth = w;
      this.idDepth = d;   
    } else if (dimtype.getSelectedItem() == "OD: Outside Dimensions") {      
      if (cflutetype.getSelectedItem().toString() == "B") {   // put Bulge figres here later if necessary
      } else if(cflutetype.getSelectedItem().toString() == "C") {
      } else if(cflutetype.getSelectedItem().toString() == "BC") {  
      } else { // E flute  
      } // end if  
      this.idLength = l - oDxf.l1 - oDxf.dmain - lengthPlus; // Assumes TOE section is Size given - dmain is the board Caliper here
      this.idWidth = w - oDxf.w2 - oDxf.dmain - widthPlus;  // dmain is the board Caliper here
      this.idDepth = d - oDxf.dmain - oDxf.dmain - depthPlus;
      
    } else { // Bend to Bend
      this.idLength = l - oDxf.l1; // dmain is the board Caliper here
      this.idWidth = w - oDxf.w1;
      this.idDepth = d - oDxf.dmain;      
    } 
    // Find O/D
    this.odLength = this.idLength + oDxf.l1 + oDxf.dmain + lengthPlus; // dmain is the board Caliper here
    this.odWidth = this.idWidth + oDxf.w2 + oDxf.dmain + widthPlus;
    this.odDepth = this.idDepth + oDxf.dmain + oDxf.dmain + depthPlus;
    
    parcelSizes oBjt = new parcelSizes();
    oBjt.odLength = this.odLength;
    oBjt.odWidth = this.odWidth;
    oBjt.odDepth = this.odDepth;
    oBjt.checkSizes();
    
  } // getSizes
 
    
    
    private void lszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lszActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lszActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(D0470.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D0470.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D0470.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D0470.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D0470().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blksz;
    private javax.swing.JButton btnBlkSz;
    private javax.swing.JComboBox<String> cflutetype;
    private javax.swing.JButton createDxf;
    private javax.swing.JComboBox<String> dimtype;
    private javax.swing.JTextField dsz;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lsz;
    private javax.swing.JLabel r2r2upint;
    private javax.swing.JTextField txtFilePathName;
    private javax.swing.JTextField txtLidFlap;
    private javax.swing.JTextField wsz;
    // End of variables declaration//GEN-END:variables
}