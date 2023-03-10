/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sabrina
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private EstoqueProduto listaProduto;
    private GerenciarNotasFiscais gerenciarNotasFiscais;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(EstoqueProduto listaProduto, GerenciarNotasFiscais gerenciarNotasFiscais) {
        initComponents();
        this.listaProduto=listaProduto;
        this.gerenciarNotasFiscais = gerenciarNotasFiscais;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        addProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addNotaFiscal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRUTEIRA");
        setBackground(new java.awt.Color(182, 235, 116));

        jPanel1.setBackground(new java.awt.Color(182, 235, 116));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("FRUTEIRA");

        jMenuBar1.setBackground(new java.awt.Color(51, 102, 0));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 0), new java.awt.Color(0, 102, 51)));
        jMenuBar1.setForeground(new java.awt.Color(0, 102, 51));
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setFocusCycleRoot(true);
        jMenuBar1.setMargin(new java.awt.Insets(2, 2, 2, 0));

        jMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jMenu1.setForeground(new java.awt.Color(0, 51, 0));
        jMenu1.setText("Estoque");
        jMenu1.setAutoscrolls(true);

        addProduto.setText("Produto");
        addProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(addProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Notas Fiscais");

        addNotaFiscal.setText("Nota Fiscal");
        addNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNotaFiscalActionPerformed(evt);
            }
        });
        jMenu2.add(addNotaFiscal);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProdutoActionPerformed
        // TODO add your handling code here:
        InterfaceProduto interfaceProduto = new InterfaceProduto(listaProduto);
        interfaceProduto.setVisible(true);
    }//GEN-LAST:event_addProdutoActionPerformed

    private void addNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNotaFiscalActionPerformed
        // TODO add your handling code here:
        InterfaceNotaFiscal interfaceNotaFiscal =  new InterfaceNotaFiscal(gerenciarNotasFiscais, listaProduto);
        interfaceNotaFiscal.setVisible(true);
    }//GEN-LAST:event_addNotaFiscalActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Produto> produto = new ArrayList<>();
                ArrayList<NotaFiscal> listaNF = new ArrayList<>();
                
            
                new MenuPrincipal(new EstoqueProduto(produto), new GerenciarNotasFiscais(listaNF, produto)).setVisible(true);
            
               
            
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNotaFiscal;
    private javax.swing.JMenuItem addProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
