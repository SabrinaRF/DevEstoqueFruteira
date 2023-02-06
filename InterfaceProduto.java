/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * Classe da interface de gerenciamento de produtos
 */
public class InterfaceProduto extends javax.swing.JFrame {
    private EstoqueProduto listaProduto;
    private String modo;
   
    /**
     * Creates new form InterfaceProduto
     */
    public InterfaceProduto(EstoqueProduto listaProduto) {
        initComponents();
        this.listaProduto=listaProduto;
        
        modo="Navegar";
        ManipularInterface();
    }
    /**
     * Classe responsavel pelo carregamenro da tabela de produtos
     */
    public void LoadTableProduto(){
        DefaultTableModel modeloProduto = new DefaultTableModel(new Object [] {"Código","Nome", "Descrição","Quantidade", "Preço"},0);

            for(int i=0;i<listaProduto.size();i++){
                
                Object linha []=new Object[]{listaProduto.get(i).getCodigo(),listaProduto.get(i).getNome(),listaProduto.get(i).getDescricao(), listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco()};
                modeloProduto.addRow(linha);
            }
            tblProduto.setModel(modeloProduto);
    }
    /**
     * Classe responsável pelo carregamento da tabela de estoque
     */
    public void LoadTableEstoque(){
        DefaultTableModel modeloProduto = new DefaultTableModel(new Object [] {"Código","Nome", "Descrição","Quantidade", "Preço"},0);

            for(int i=0;i<listaProduto.size();i++){
                
                Object linha []=new Object[]{listaProduto.get(i).getCodigo(),listaProduto.get(i).getNome(),listaProduto.get(i).getDescricao(), listaProduto.get(i).getQuantidade(), listaProduto.get(i).getPreco()};
                modeloProduto.addRow(linha);
            }
            tblProdutoEstoque.setModel(modeloProduto);
    }
    
    /**
     * Classe pela manipulaçãoda interface de produtos
     */
    public void ManipularInterface(){
        switch(modo){
            case "Navegar":
                btnSalvarProduto.setEnabled(false);
                btnCancelarProduto.setEnabled(false);
                txtNome.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtQuantidade.setEnabled(false);
                txtPreco.setEnabled(false);
                btnNovoProduto.setEnabled(true);
                btnEditarProduto.setEnabled(false);
                btnExcluirProduto.setEnabled(false);               
                break;
            case "Novo":
                btnSalvarProduto.setEnabled(true);
                btnCancelarProduto.setEnabled(true);
                txtNome.setEnabled(true);
                txtDescricao.setEnabled(true);
                txtQuantidade.setEnabled(true);
                txtPreco.setEnabled(true);
                btnNovoProduto.setEnabled(false);
                btnEditarProduto.setEnabled(false);
                btnExcluirProduto.setEnabled(false); 
                break;
            case "Editar":
                btnSalvarProduto.setEnabled(true);
                btnCancelarProduto.setEnabled(true);
                txtNome.setEnabled(true);
                txtDescricao.setEnabled(true);
                txtQuantidade.setEnabled(true);
                txtPreco.setEnabled(true);
                btnNovoProduto.setEnabled(false);
                btnEditarProduto.setEnabled(false);
                btnExcluirProduto.setEnabled(false); 
                break;
            case "Excluir":
                btnSalvarProduto.setEnabled(false);
                btnCancelarProduto.setEnabled(false);
                txtNome.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtQuantidade.setEnabled(false);
                txtPreco.setEnabled(false);
                btnNovoProduto.setEnabled(true);
                btnEditarProduto.setEnabled(false);
                btnExcluirProduto.setEnabled(false);
                break;
            case "Selecao":
                btnSalvarProduto.setEnabled(false);
                btnCancelarProduto.setEnabled(false);
                txtNome.setEnabled(false);
                txtDescricao.setEnabled(false);
                txtQuantidade.setEnabled(false);
                txtPreco.setEnabled(false);
                btnNovoProduto.setEnabled(true);
                btnEditarProduto.setEnabled(true);
                btnExcluirProduto.setEnabled(true); 
                break;
        
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnNovoProduto = new javax.swing.JButton();
        btnEditarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        btnCancelarProduto = new javax.swing.JButton();
        btnSalvarProduto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProdutoEstoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Controle de Estoque de Produto");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Descrição", "Quantidade", "Preço"
            }
        ));
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduto);

        btnNovoProduto.setText("Novo");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnEditarProduto.setText("Editar");
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar")));

        nome.setText("Nome: ");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Quantidade: ");

        jLabel5.setText("Preço:");

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        btnCancelarProduto.setText("Cancelar");
        btnCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProdutoActionPerformed(evt);
            }
        });

        btnSalvarProduto.setText("Salvar ");
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnSalvarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarProduto)
                .addGap(163, 163, 163))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarProduto)
                    .addComponent(btnSalvarProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNovoProduto)
                                .addGap(204, 204, 204)
                                .addComponent(btnEditarProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluirProduto))
                            .addComponent(jScrollPane2))
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProduto)
                    .addComponent(btnEditarProduto)
                    .addComponent(btnExcluirProduto))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Produto", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de produtos"));

        jLabel2.setText("Código:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de produtos"));

        tblProdutoEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Descrição", "Quantidade", "Preço"
            }
        ));
        tblProdutoEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoEstoqueMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProdutoEstoque);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Estoque de Produtos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed
/**
 * Método referente ao botão ded editar produtos
 * @param evt 
 */
    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
        // TODO add your handling code here:
        modo="Editar";
        ManipularInterface();
    }//GEN-LAST:event_btnEditarProdutoActionPerformed
/**
 * Método referente ao botão de excluir produtos
 * @param evt 
 */
    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        // TODO add your handling code here:
        int index = tblProduto.getSelectedRow();
        
        if (index>=0 && index<listaProduto.size()){
            try {
                listaProduto.removeProduto(index);
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Problema ao remover o produto!");
            }
        }
        LoadTableProduto();
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed
/**
 * Método referente ao botão de cadastrar novo produto
 * @param evt 
 */
    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        txtDescricao.setText("");
        txtQuantidade.setText("");
        txtPreco.setText("");
        modo="Novo";
        ManipularInterface();
    }//GEN-LAST:event_btnNovoProdutoActionPerformed
/**
 * Método referente ao botão de cancelar a operação
 * @param evt 
 */
    private void btnCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProdutoActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        txtDescricao.setText("");
        txtQuantidade.setText("");
        txtPreco.setText("");
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_btnCancelarProdutoActionPerformed
/**
 * Método referente ao botão de salvar novo produto
 * @param evt 
 */
    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProdutoActionPerformed
        // TODO add your handling code here:
        if(modo.equals("Novo")){
            try {

                    Produto p = new Produto("banana", "fruta", 0, 0);
                    
                    String nome =txtNome.getText();
                    String descricao = txtDescricao.getText();
                    int quantidade = Integer.parseInt(txtQuantidade.getText());
                    double preco = Double.parseDouble(txtPreco.getText());
                    
                    try {
                        p.setNome(nome);
                        System.out.println(nome);
                        try {
                            p.setDescricao(descricao); 
                            try {
                            p.setQuantidade(quantidade);
                                try{
                                    p.setPreco(preco);

                                    listaProduto.addProduto(p);

                                    JOptionPane.showMessageDialog(null, "Produto adicionado!");
                                    modo="Navegar";
                                    ManipularInterface();
                                    txtNome.setText("");
                                    txtDescricao.setText("");
                                    txtQuantidade.setText("");
                                    txtPreco.setText("");
                                } catch(Exception e){
                                    JOptionPane.showMessageDialog(null,e.getMessage());
                                    txtPreco.setText("");
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                                txtQuantidade.setText("");
                            }
                        } catch (Exception e){
                            JOptionPane.showMessageDialog(null,e.getMessage());
                        }   
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro, preencha todos os campos.");
                }
                
        }else if(modo.equals("Editar")){
            try {
                int index = tblProduto.getSelectedRow();
                
                Produto p = listaProduto.getProduto(index);
                
                try {
                    p.setNome(txtNome.getText());  
                    try{
                        p.setDescricao(txtDescricao.getText()); 
                        try {
                            p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                            try {
                                p.setPreco(Double.valueOf(txtPreco.getText())); 
                               
                                JOptionPane.showMessageDialog(null, "Produto modificado!");
                                modo="Navegar";
                                ManipularInterface();
                                txtNome.setText("");
                                txtDescricao.setText("");
                                txtQuantidade.setText("");
                                txtPreco.setText("");
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());            
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());            
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage()); 
                    }
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage()); 
                }
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,"Ocorreu um erro, preencha todos os campos.");          
            }
        }
        LoadTableProduto();
        LoadTableEstoque();
        
    }//GEN-LAST:event_btnSalvarProdutoActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        // TODO add your handling code here:
        int index = tblProduto.getSelectedRow();
        
        if (index>=0 && index<listaProduto.size()){
            try {
                Produto p =  listaProduto.getProduto(index);
                
                txtNome.setText(p.getNome());
                txtDescricao.setText(String.valueOf(p.getDescricao()));
                txtQuantidade.setText(String.valueOf(p.getQuantidade()));
                txtPreco.setText(String.valueOf(p.getPreco()));
                
                modo="Selecao";
                ManipularInterface();
            } catch (Exception ex) {
                Logger.getLogger(InterfaceProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(txtCodigo.getText());

        for(int i=0; i< listaProduto.size();i++){
            try {
                if(listaProduto.getProduto(codigo).getCodigo() == codigo){
                    System.out.println(codigo+"\n");
                    System.out.println(listaProduto.getProduto(codigo).getCodigo());
                    try {
                        listaProduto.getProduto(codigo);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            LoadTableEstoque();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblProdutoEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoEstoqueMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProdutoEstoqueMouseClicked

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
            java.util.logging.Logger.getLogger(InterfaceProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarProduto;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel nome;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTable tblProdutoEstoque;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
