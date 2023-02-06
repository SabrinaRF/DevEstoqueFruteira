/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *Classe da interface de gerenciamento de notas fiscais
 * 
 */
public class InterfaceNotaFiscal extends javax.swing.JFrame {
    private GerenciarNotasFiscais listaDeNotasFiscais;
    
    private String modo;
    
    DefaultTableModel modelo = new DefaultTableModel();
     
    /**
     * Esse construtor é responsável por inicializar o componente da interface gráfica.Configurando 
     * o JcomboBox com a lista de produtos retornada pelo método getListProduto do objeto
     * gerenciarNotasFiscais.
     */
    public InterfaceNotaFiscal(GerenciarNotasFiscais listaDeNotasFiscais) {
        initComponents();
        this.listaDeNotasFiscais = listaDeNotasFiscais;
        
        //System.out.println("listaProduto " +  this.gerenciarNotasFiscais.getNProduto());
        ComboBoxModel comboBoxProduto = new DefaultComboBoxModel(listaDeNotasFiscais.getListsProduto().toArray());
        jComboBoxItem.setModel(comboBoxProduto);
      
        //listaDeNotasFiscais = new ArrayList();
        LoadTableNotafiscal();
        setLocationRelativeTo(null);
        modo="Navegar";
        ManipularInterface(); 
    }
   
    /*
    Esse método LoadTableNotafiscal é responsável por carregar a tabela de notas fiscais com as informações do 
    produto e suas informações na interface gráfica. Ele cria um modelo de tabela padrão com os títulos "Código",
    "data", "Nome", "Descrição", "quantidade" e "preço" e, em seguida, adiciona linhas à tabela com as informações
    das notas fiscais e produtos correspondentes. Se o produto não estiver disponível, ele adiciona uma linha com o
    texto "Produto não disponível". Finalmente, ele define o modelo criado como o modelo da tabela TabelaNF.
    */
    public void LoadTableNotafiscal(){
    DefaultTableModel novoModelo = new DefaultTableModel(new Object [] {"Código","data","cod item","Nome","Descrição","quantidade","preço"},0);

    //for(int i=0;i<listaDeNotasFiscais.getQuantElementos();i++){
        //if (listaDeNotasFiscais.get(i).getProduto() != null && listaDeNotasFiscais.get(i).getProduto().getNome() != null) {
        
        
        for(int i=0;i<listaDeNotasFiscais.size();i++){
            Object linha []=new Object[]{
                listaDeNotasFiscais.get(i).getCodNotaFiscal(),
                listaDeNotasFiscais.get(i).getData(),
                
                listaDeNotasFiscais.get(i).getProduto().getCodigo(),
                listaDeNotasFiscais.get(i).getProduto().getNome(),
                listaDeNotasFiscais.get(i).getProduto().getDescricao(),
                listaDeNotasFiscais.get(i).getProduto().getQuantidade(),
                listaDeNotasFiscais.get(i).getProduto().getPreco(),
                
                
            };
            novoModelo.addRow(linha);
        }
         TabelaNF.setModel(novoModelo);
    }
        
            /*Object linha []=new Object[]{
                listaDeNotasFiscais.get(i).getCodNotaFiscal(),
                listaDeNotasFiscais.get(i).getData(),
               listaDeNotasFiscais.get(i).getProduto().getNome(),
                listaDeNotasFiscais.get(i).getProduto().getDescricao(),
               listaDeNotasFiscais.get(i).getProduto().getPreco(),
                
            };
            novoModelo.addRow(linha);
              
        */
        
       // }
        //this.modelo=novoModelo;
        //TabelaNF.setModel(novoModelo);
         //else {
          //  Object linha []=new Object[]{
            //    listaDeNotasFiscais.get(i).getCodNotaFiscal(),
              //  listaDeNotasFiscais.get(i).getData(),
                //"Produto não disponível"
            //};
        //novoModelo.addRow(linha);
        
      //  }
    //}
    //}   
    
    
 
    
    /*  Este método é responsável por controlar a interface da classe, habilitando ou desabilitando 
        botões e caixas de texto de acordo com o modo atual (Navegar, Novo, Editar, Excluir, Seleção).
        Ele verifica o valor da variável "modo" e, dependendo do valor, habilita ou desabilita os componentes 
        da interface.
    */
    
    /**
     * Classe de manipulaçao da nota fiscal
     */
    public void ManipularInterface(){
        switch(modo){
            case "Navegar":
                botaoSalvarNF.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                caixaDeTextoNF.setEnabled(false);
                caixaDeTextoMes.setEnabled(false);
                caixaDeTextoAno.setEnabled(false);
                
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);               
                break;
            case "Novo":
                botaoSalvarNF.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                caixaDeTextoNF.setEnabled(true);
                caixaDeTextoMes.setEnabled(true);
                caixaDeTextoAno.setEnabled(true);
                
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false); 
                break;
            case "Editar":
                 botaoSalvarNF.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                caixaDeTextoNF.setEnabled(true);
                caixaDeTextoMes.setEnabled(true);
                caixaDeTextoAno.setEnabled(true);
                
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false); 
                break;
            case "Excluir":
                botaoSalvarNF.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                caixaDeTextoNF.setEnabled(false);
                caixaDeTextoMes.setEnabled(false);
               caixaDeTextoAno.setEnabled(false);
                
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false); 
                break;
                
            case "Selecao":
                botaoSalvarNF.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                caixaDeTextoNF.setEnabled(false);
                caixaDeTextoMes.setEnabled(false);
               caixaDeTextoAno.setEnabled(false);
                
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(true);
                BotaoExcluiRNF.setEnabled(true); 
                break;
        }
    }
    
    /*
     *  Este método salva as informações de uma nota fiscal. Se o modo for "Novo", ele cria uma
     *  nova nota fiscal com as informações inseridas pelo usuário, incluindo a data, o produto selecionado 
     *  e adiciona essa nota fiscal à lista de notas fiscais.     
     */

public void salvar() {
        if(modo.equals("Novo")){   
        try {
            NotaFiscal notaFiscal = new NotaFiscal();

            int codDaNotaFiscal = notaFiscal.getCodNotaFiscal();     
            int dia= Integer.parseInt( caixaDeTextoNF.getText());
            int mes = Integer.parseInt( caixaDeTextoMes.getText());
            int ano = Integer.parseInt( caixaDeTextoAno.getText());

            String data = dia+"/"+ mes +"/"+ ano;
            notaFiscal.setData(data);

            Produto selectProuto = (Produto)jComboBoxItem.getSelectedItem();
            notaFiscal.setProduto(selectProuto);
            
            listaDeNotasFiscais.addNotaFiscal(notaFiscal);

            //LoadTableNotafiscal();
            JOptionPane.showMessageDialog(null, "Nota adicionada!");

        
       } catch (Exception ex) {
                    Logger.getLogger(InterfaceProduto.class.getName()).log(Level.SEVERE,null, ex);
                }
            }else if (modo.equals("Editar")){
                try {
                    int index = TabelaNF.getSelectedRow();
                    
                    NotaFiscal g = listaDeNotasFiscais.getNotaFiscal(index);
                    
                    g.setData(caixaDeTextoNF.getText());
                    g.setData(caixaDeTextoMes.getText());
                    g.setData(caixaDeTextoAno.getText());
                    
                    
                    JOptionPane.showMessageDialog(null, "Produto modificado!");
                   
                } catch (Exception ex) {
                    Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            LoadTableNotafiscal();
            ManipularInterface();
            modo="Navegar";
            
           
        
   
    
    
    
    
    
    /*if(modo.equals("Novo")){
                try {
                    NotaFiscal notaFiscal = new NotaFiscal();
                    
                    
                    
                    int codDaNotaFiscal = notaFiscal.getCodNotaFiscal();
                    
                    int dia= Integer.parseInt( caixaDeTextoNF.getText());
                    int mes = Integer.parseInt( caixaDeTextoMes.getText());
                    int ano = Integer.parseInt( caixaDeTextoAno.getText());
                    
                    
                    String data = dia+"/"+ mes +"/"+ ano;
                    notaFiscal.setData(data);
                    
                    Produto selectProuto = (Produto)jComboBoxItem.getSelectedItem();
                    
                    
                    //listaDeNotasFiscais.getNotaFiscal(notaFiscal);
                    
                   listaDeNotasFiscais.addNotaFiscal(notaFiscal);
                  
                    JOptionPane.showMessageDialog(null, "Nota adicionada!");
                    LoadTableNotafiscal();
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, "Não foi possível salvar");
                   LoadTableNotafiscal();
                }
            }else if (modo.equals("Editar")){
                try {
                    int index = TabelaNF.getSelectedRow();
                    
                    NotaFiscal g = listaDeNotasFiscais.getNotaFiscal(index);
                    
                    g.setData(caixaDeTextoNF.getText());
                    g.setData(caixaDeTextoMes.getText());
                    g.setData(caixaDeTextoAno.getText());
                    
                    JOptionPane.showMessageDialog(null, "Produto modificado!");
                    LoadTableNotafiscal();
                } catch (Exception ex) {
                    Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
   
            modo="Navegar";
            ManipularInterface();
            LoadTableNotafiscal();
    */    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoNotaFiscal = new javax.swing.JLabel();
        MenuNotaFisca = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaNF = new javax.swing.JTable();
        BotaoCadastrarNF = new javax.swing.JButton();
        BotaoEditarNF = new javax.swing.JButton();
        BotaoExcluiRNF = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textoData = new javax.swing.JLabel();
        textoRelacaoItemNF = new javax.swing.JLabel();
        caixaDeTextoNF = new javax.swing.JTextField();
        botaoCancelarNF = new javax.swing.JButton();
        botaoSalvarNF = new javax.swing.JButton();
        textoDiaNF = new javax.swing.JLabel();
        textoMesNF = new javax.swing.JLabel();
        caixaDeTextoAno = new javax.swing.JTextField();
        textoAnoNF = new javax.swing.JLabel();
        caixaDeTextoMes = new javax.swing.JTextField();
        jComboBoxItem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoNotaFiscal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        textoNotaFiscal.setText("Cupom Fiscal");

        TabelaNF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "data", "cod item", "Nome do item", "Descrição", "Quantidade", "Preço"
            }
        ));
        TabelaNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaNFMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaNF);

        BotaoCadastrarNF.setText("Cadastrar nota");
        BotaoCadastrarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarNFActionPerformed(evt);
            }
        });

        BotaoEditarNF.setText("Editar nota");
        BotaoEditarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarNFActionPerformed(evt);
            }
        });

        BotaoExcluiRNF.setText("Excluir nota");
        BotaoExcluiRNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluiRNFActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar")));

        textoData.setText("Data");

        textoRelacaoItemNF.setText("Selecione o Item:");

        botaoCancelarNF.setText("Cancelar");
        botaoCancelarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarNFActionPerformed(evt);
            }
        });

        botaoSalvarNF.setText("Salvar ");
        botaoSalvarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarNFActionPerformed(evt);
            }
        });

        textoDiaNF.setText("Dia: ");

        textoMesNF.setText("Mês");

        textoAnoNF.setText("Ano");

        jComboBoxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(botaoSalvarNF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(botaoCancelarNF)
                .addGap(163, 163, 163))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoRelacaoItemNF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textoData)
                        .addGap(53, 53, 53)
                        .addComponent(textoDiaNF)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(caixaDeTextoNF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(textoMesNF)
                        .addGap(18, 18, 18)
                        .addComponent(caixaDeTextoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(textoAnoNF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caixaDeTextoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoData)
                    .addComponent(caixaDeTextoNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDiaNF)
                    .addComponent(textoMesNF)
                    .addComponent(caixaDeTextoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoAnoNF)
                    .addComponent(caixaDeTextoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoRelacaoItemNF)
                    .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelarNF)
                    .addComponent(botaoSalvarNF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("=========================================================================================");

        jLabel3.setText("Fruteira Alegrete");

        jLabel4.setText("Rua Freitas, 278 - CENTRO");

        jLabel5.setText("=========================================================================================");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotaoCadastrarNF)
                                .addGap(36, 36, 36)
                                .addComponent(BotaoEditarNF)
                                .addGap(47, 47, 47)
                                .addComponent(BotaoExcluiRNF))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoCadastrarNF)
                    .addComponent(BotaoEditarNF)
                    .addComponent(BotaoExcluiRNF))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        MenuNotaFisca.addTab("Nota fiscal", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        MenuNotaFisca.addTab("Valor total vendido", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(textoNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuNotaFisca, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(textoNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuNotaFisca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaNFMouseClicked
        // TODO add your handling code here:
    
        int index = TabelaNF.getSelectedRow();
        
        if (index>=0 && index<listaDeNotasFiscais.size()){
            NotaFiscal n=  listaDeNotasFiscais.get(index);
            
            caixaDeTextoNF.setText(n.getData());
            caixaDeTextoMes.setText(String.valueOf(n.getData()));
            caixaDeTextoAno.setText(String.valueOf(n.getData()));
    
            modo="Selecao";
            ManipularInterface();
        }
    }//GEN-LAST:event_TabelaNFMouseClicked

    private void BotaoCadastrarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarNFActionPerformed
        caixaDeTextoNF.setText("");
        caixaDeTextoMes.setText("");
        caixaDeTextoAno.setText("");
        
        //EstoqueProduto estoqueProduto = (EstoqueProduto)jComboBoxItem.getSelectedItem();
        modo="Novo";
        ManipularInterface(); 
    }//GEN-LAST:event_BotaoCadastrarNFActionPerformed

    private void BotaoEditarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarNFActionPerformed
        modo="Editar";
        ManipularInterface();

    }//GEN-LAST:event_BotaoEditarNFActionPerformed

    private void BotaoExcluiRNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluiRNFActionPerformed
          int index = TabelaNF.getSelectedRow();
        
        if (index>=0 && index<listaDeNotasFiscais.size()){
              try {
                  listaDeNotasFiscais.removeNotaFiscal(index);
              } catch (Exception ex) {
                  Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        LoadTableNotafiscal();
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_BotaoExcluiRNFActionPerformed

    private void botaoCancelarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarNFActionPerformed
        caixaDeTextoNF.setText("");
        caixaDeTextoMes.setText("");
        caixaDeTextoAno.setText("");
        
         //EstoqueProduto estoqueProduto = (EstoqueProduto)jComboBoxItem.getSelectedItem();
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_botaoCancelarNFActionPerformed

    private void botaoSalvarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarNFActionPerformed
       salvar();
       
        
    }//GEN-LAST:event_botaoSalvarNFActionPerformed

    private void jComboBoxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItemActionPerformed
  
    }//GEN-LAST:event_jComboBoxItemActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton BotaoCadastrarNF;
    private javax.swing.JButton BotaoEditarNF;
    private javax.swing.JButton BotaoExcluiRNF;
    private javax.swing.JTabbedPane MenuNotaFisca;
    private javax.swing.JTable TabelaNF;
    private javax.swing.JButton botaoCancelarNF;
    private javax.swing.JButton botaoSalvarNF;
    private javax.swing.JTextField caixaDeTextoAno;
    private javax.swing.JTextField caixaDeTextoMes;
    private javax.swing.JTextField caixaDeTextoNF;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel textoAnoNF;
    private javax.swing.JLabel textoData;
    private javax.swing.JLabel textoDiaNF;
    private javax.swing.JLabel textoMesNF;
    private javax.swing.JLabel textoNotaFiscal;
    private javax.swing.JLabel textoRelacaoItemNF;
    // End of variables declaration//GEN-END:variables

    private void LoadTableProduto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
