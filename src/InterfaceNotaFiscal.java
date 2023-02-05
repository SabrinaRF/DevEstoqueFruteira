/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//package devestoquefruteira.DevEstoqueFruteira;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

public class InterfaceNotaFiscal extends javax.swing.JFrame {
    private GerenciarNotasFiscais listaDeNotasFiscais;
    private EstoqueProduto estoque;
    private InterfaceProduto interfaceProduto;
    List<Item>listaDeItem;
    private String modo;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultListModel<String> listaNFModel = new DefaultListModel<>();
    private JList<String> mostrarLista2 = new JList<>(listaNFModel);
     DefaultListModel modeloLista = new DefaultListModel();
    /**
     * Esse construtor é responsável por inicializar o componente da interface gráfica.Configurando 
     * o JcomboBox com a lista de produtos retornada pelo método getListProduto do objeto
     * gerenciarNotasFiscais.
     */
    public InterfaceNotaFiscal(GerenciarNotasFiscais listaDeNotasFiscais, EstoqueProduto estoque) {
        initComponents();
        this.listaDeNotasFiscais = listaDeNotasFiscais;
        this.estoque = estoque;
        listaDeItem = new ArrayList<Item>();
     
        ComboBoxModel comboBoxProduto = new DefaultComboBoxModel(listaDeNotasFiscais.getListsProduto().toArray());
        jComboBoxItem.setModel(comboBoxProduto);
     
        LoadTableNotafiscal();
        setLocationRelativeTo(null);
        modo="Navegar";
        ManipularInterface(); 
        caixaDeTextoConsultarNF.setEnabled(false);
    }
   
    /*
    Esse método LoadTableNotafiscal é responsável por carregar a tabela de notas fiscais com as informações do 
    produto e suas informações na interface gráfica. Ele cria um modelo de tabela padrão com os títulos "Código",
    "data", "Nome", "Descrição", "quantidade" e "preço" e, em seguida, adiciona linhas à tabela com as informações
    das notas fiscais e produtos correspondentes. Se o produto não estiver disponível, ele adiciona uma linha com o
    texto "Produto não disponível". Finalmente, ele define o modelo criado como o modelo da tabela TabelaNF.
    */
    public void LoadTableNotafiscal(){
    DefaultTableModel novoModelo = new DefaultTableModel(new Object [] {"Códido do produto","Nome do produto","Descriçãodo produto","Quantidade item","Preço do item"},0);

    //for(int i=0;i<listaDeNotasFiscais.getQuantElementos();i++){
        //if (listaDeNotasFiscais.get(i).getProduto() != null && listaDeNotasFiscais.get(i).getProduto().getNome() != null) {
        
        
        for(int i=0;i<listaDeItem.size();i++){
            Object linha []=new Object[]{
                //listaDeNotasFiscais.get(i).getCodNotaFiscal(),
                
                //listaDeNotasFiscais.get(i).getData(),
                
                
                listaDeItem.get(i).getProduto().getCodigo(),
                listaDeItem.get(i).getProduto().getNome(),
                listaDeItem.get(i).getProduto().getDescricao(),
                listaDeItem.get(i).getQuantidade(),
                listaDeItem.get(i).calcularPrecoDoItem(),
                
                
              
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
    
    
    public void ManipularInterface(){
        switch(modo){
            case "Navegar":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                break;
            case "Novo":
                botaoSalvarItem.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                jComboBoxItem.setEditable(true);
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                break;
            case "Editar":
                 botaoSalvarItem.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                jComboBoxItem.setEditable(true);
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                break;
                
            
            case "Excluir":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                break;
                
            case "Selecao":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(true);
                BotaoExcluiRNF.setEnabled(true); 
                jComboBoxItem.setEditable(true);
                break;
        }
    }
    
    
    /*
      Codigo para fazer as exception depois     
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
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        textoNotaFiscal = new javax.swing.JLabel();
        MenuNotaFisca = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaNF = new javax.swing.JTable();
        BotaoCadastrarNF = new javax.swing.JButton();
        BotaoEditarNF = new javax.swing.JButton();
        BotaoExcluiRNF = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textoRelacaoItemNF = new javax.swing.JLabel();
        botaoCancelarNF = new javax.swing.JButton();
        botaoSalvarItem = new javax.swing.JButton();
        jComboBoxItem = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        TxtQtdDeItem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecoItem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SalvarNotaFiscal = new javax.swing.JButton();
        caixaPreencherData = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BotaoMostrarNotas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarLista = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanelNFRegistrada = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaNotaFiscalRegistrada = new javax.swing.JTable();
        labelConsultarNF = new javax.swing.JPanel();
        jLabelTXTConsultarNF = new javax.swing.JLabel();
        caixaDeTextoConsultarNF = new javax.swing.JTextField();
        btnPesquisarNotaFiscal = new javax.swing.JButton();
        opcaoCodigo = new javax.swing.JRadioButton();
        opcaoData = new javax.swing.JRadioButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenuItem3.setText("jMenuItem3");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoNotaFiscal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        textoNotaFiscal.setText(" nota fiscal");

        TabelaNF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código do produto", "Nome do  produto", "Descrição do produto", "Quantidade Item", "Preço do Item"
            }
        ));
        TabelaNF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaNFMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaNF);

        BotaoCadastrarNF.setText("Cadastrar Item");
        BotaoCadastrarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarNFActionPerformed(evt);
            }
        });

        BotaoEditarNF.setText("Editar Item");
        BotaoEditarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarNFActionPerformed(evt);
            }
        });

        BotaoExcluiRNF.setText("Excluir item");
        BotaoExcluiRNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluiRNFActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar")));

        textoRelacaoItemNF.setText("Selecione o Produto");

        botaoCancelarNF.setText("Cancelar");
        botaoCancelarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarNFActionPerformed(evt);
            }
        });

        botaoSalvarItem.setText("Salvar  Item");
        botaoSalvarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarItemActionPerformed(evt);
            }
        });

        jComboBoxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxItemActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade item");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoRelacaoItemNF, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtQtdDeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPrecoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(botaoSalvarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(botaoCancelarNF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addComponent(jComboBoxItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoRelacaoItemNF)
                    .addComponent(jComboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtQtdDeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecoItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarItem)
                    .addComponent(botaoCancelarNF))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setText("=========================================================================================");

        jLabel3.setText("Fruteira Alegrete");

        jLabel4.setText("Rua Freitas, 278 - CENTRO");

        jLabel5.setText("=========================================================================================");

        SalvarNotaFiscal.setText("Salvar Nota Fiscal");
        SalvarNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarNotaFiscalActionPerformed(evt);
            }
        });

        labelData.setText("Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelData)
                                        .addGap(29, 29, 29)
                                        .addComponent(caixaPreencherData, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(SalvarNotaFiscal))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalvarNotaFiscal)
                    .addComponent(caixaPreencherData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelData))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        MenuNotaFisca.addTab("Criar nota fiscal", jPanel1);

        BotaoMostrarNotas.setText("Mostrar Notas");
        BotaoMostrarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoMostrarNotasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(mostrarLista);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(BotaoMostrarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BotaoMostrarNotas)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        MenuNotaFisca.addTab("Vizualizar nota fiscal", jPanel3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );

        jPanelNFRegistrada.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas fiscais regristradas"));
        jPanelNFRegistrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelaNotaFiscalRegistrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código da nota fiscal", "data da nota fiscal", "Codigo do produto", "Nome do produto", "Descrição do produto", "Quantidade", "Preço do item"
            }
        ));
        tabelaNotaFiscalRegistrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaNotaFiscalRegistradaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaNotaFiscalRegistrada);

        javax.swing.GroupLayout jPanelNFRegistradaLayout = new javax.swing.GroupLayout(jPanelNFRegistrada);
        jPanelNFRegistrada.setLayout(jPanelNFRegistradaLayout);
        jPanelNFRegistradaLayout.setHorizontalGroup(
            jPanelNFRegistradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNFRegistradaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNFRegistradaLayout.setVerticalGroup(
            jPanelNFRegistradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNFRegistradaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jPanelNFRegistrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(658, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(jPanelNFRegistrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE)))
        );

        MenuNotaFisca.addTab("Pesquisar notas", jPanel4);

        labelConsultarNF.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar notas fiscais"));
        labelConsultarNF.setToolTipText("");
        labelConsultarNF.setName(""); // NOI18N
        labelConsultarNF.setOpaque(false);

        jLabelTXTConsultarNF.setText("Código da nota fiscal:");

        caixaDeTextoConsultarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaDeTextoConsultarNFActionPerformed(evt);
            }
        });

        btnPesquisarNotaFiscal.setBackground(new java.awt.Color(255, 204, 204));
        btnPesquisarNotaFiscal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPesquisarNotaFiscal.setForeground(new java.awt.Color(153, 0, 0));
        btnPesquisarNotaFiscal.setText("Pesquisar");
        btnPesquisarNotaFiscal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        btnPesquisarNotaFiscal.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnPesquisarNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarNotaFiscalActionPerformed(evt);
            }
        });

        buttonGroup1.add(opcaoCodigo);
        opcaoCodigo.setText("Consultar por código");
        opcaoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoCodigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(opcaoData);
        opcaoData.setText("Consultar por data");
        opcaoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout labelConsultarNFLayout = new javax.swing.GroupLayout(labelConsultarNF);
        labelConsultarNF.setLayout(labelConsultarNFLayout);
        labelConsultarNFLayout.setHorizontalGroup(
            labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelConsultarNFLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcaoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcaoData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaDeTextoConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
            .addGroup(labelConsultarNFLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabelTXTConsultarNF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        labelConsultarNFLayout.setVerticalGroup(
            labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelConsultarNFLayout.createSequentialGroup()
                .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labelConsultarNFLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(opcaoCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(opcaoData)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelConsultarNFLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaDeTextoConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)))
                .addComponent(jLabelTXTConsultarNF)
                .addContainerGap())
        );

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuNotaFisca, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(textoNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(labelConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuNotaFisca, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelConsultarNF.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaNFMouseClicked
        // TODO add your handling code here:
    
        int index = TabelaNF.getSelectedRow();
        
        if (index>=0 && index<listaDeNotasFiscais.size()){
            NotaFiscal n=  listaDeNotasFiscais.get(index);
            
             modo="Selecao";
            ManipularInterface();
        }
    }//GEN-LAST:event_TabelaNFMouseClicked

    private void BotaoCadastrarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarNFActionPerformed
        NotaFiscal notaFiscal = new NotaFiscal();
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
        //caixaDeTextoNF.setText("");
        //caixaDeTextoMes.setText("");
        //caixaDeTextoAno.setText("");
        
         //EstoqueProduto estoqueProduto = (EstoqueProduto)jComboBoxItem.getSelectedItem();
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_botaoCancelarNFActionPerformed

    private void botaoSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarItemActionPerformed
   /*  if(modo.equals("Novo")){   */
        try {
            Item item = new Item();
            Produto selectProuto = (Produto)jComboBoxItem.getSelectedItem();
            item.setProduto(selectProuto);
  
            int quantidade = Integer.parseInt( TxtQtdDeItem.getText());
            
            item.setQuantidade(quantidade);
            double precoDoItem = item.calcularPrecoDoItem();

            listaDeItem.add(item);
           
            JOptionPane.showMessageDialog(null, "Item adicionado!");

        
       } catch (Exception ex) {
                    Logger.getLogger(InterfaceProduto.class.getName()).log(Level.SEVERE,null, ex);
                }
           /* }else if (modo.equals("Editar")){
                try {
                    int index = TabelaNF.getSelectedRow();
                    
                    NotaFiscal g = listaDeNotasFiscais.getNotaFiscal(index);
                    
                   // g.setData(caixaDeTextoNF.getText());
                    //g.setData(caixaDeTextoMes.getText());
                  //  g.setData(caixaDeTextoAno.getText());
                    
                    
                    JOptionPane.showMessageDialog(null, "Produto modificado!");
                   
                } catch (Exception ex) {
                    Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
                }
        }*/
            LoadTableNotafiscal();
            modo="Navegar";
            ManipularInterface();
            
        // caixaDeTextoNF.setText("");
          //  caixaDeTextoMes.setText("");
           // caixaDeTextoAno.setText("");
            
           
        
    }//GEN-LAST:event_botaoSalvarItemActionPerformed

    private void jComboBoxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItemActionPerformed

    }//GEN-LAST:event_jComboBoxItemActionPerformed

    private void SalvarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarNotaFiscalActionPerformed
    DefaultTableModel modelo = (DefaultTableModel) TabelaNF.getModel();
     Produto produto = new Produto();
    try {
        
            NotaFiscal notaFiscal = new NotaFiscal();
           
                if (listaDeItem == null || listaDeItem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum item adicionado na nota fiscal!");
                    return;
                }
            notaFiscal.setListaDeItens(listaDeItem);
                for(Item item: notaFiscal.getListaItem()){
                    produto = item.getProduto();
                    double quantidadeAtual = produto.getQuantidade();
                    int quantidadeVendida = item.getQuantidade();
                    int novaQuantidade = (int) (quantidadeAtual - quantidadeVendida);
                    produto.setQuantidade(novaQuantidade);
                    
                }  
            System.out.println("Tamanho da lista de notas fiscais antes de adicionar nova nota: " + listaDeNotasFiscais.size()); //tirar
            listaDeNotasFiscais.addNotaFiscal(notaFiscal);
            System.out.println("Tamanho da lista de notas fiscais depois de adicionar nova nota: " + listaDeNotasFiscais.size());
            System.out.println("estoque"+ produto.getQuantidade());
            LoadTableNotafiscal();
           // interfaceProduto.LoadTableEstoque();
            
            modelo.setRowCount(0);
            listaDeItem.clear();
            
            
            JOptionPane.showMessageDialog(null, "Nota fiscal salva com sucesso! E estoque modificado");
        }catch (Exception e) {
           
            Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE,null, e);
        } 
    }//GEN-LAST:event_SalvarNotaFiscalActionPerformed

    private void BotaoMostrarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoMostrarNotasActionPerformed
   
                                                        
    GerenciarNotasFiscais gerenciarNotasFiscais = new GerenciarNotasFiscais();
  DefaultListModel<String> listModel = new DefaultListModel<>();

  for (NotaFiscal nota : gerenciarNotasFiscais.getListaNota()) {
    String notaFiscal = "Código da nota fiscal: " + nota.getCodNotaFiscal() + "\n";
    //listModel.addElement(notaFiscal);
  }

  //mostrarLista.setModel(listModel);

    listaNFModel.removeAllElements();
    for (NotaFiscal nota : listaDeNotasFiscais.getListaNota()) {
        String notaFiscal = "Código da nota fiscal: " + "\n"+ nota.getCodNotaFiscal() + "\n";       
       
        Date dataAtual = new Date();  //pega a data da máquina
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAtual);
        nota.setData(dataAtual);
        
        
        //listaDeNotasFiscais.getListaNota().add(nota);
        notaFiscal += "Data da nota fiscal: " + dataFormatada + "\n";
        //listModel.addElement(notaFiscal);
        
        //notaFiscal += "Data da nota fiscal: " + dataFormatada + "\n";
        
        //notaFiscal += "Data da nota fiscal: " + nota.getData() + "\n";  //data antiga
        notaFiscal += "Itens da nota fiscal: \n";
        for (Item item : nota.getListaItem()) {
            notaFiscal += "Código do produto: " + item.getProduto().getCodigo() + "\n";
            notaFiscal += "Nome do produto: " + item.getProduto().getNome() + "\n";
            notaFiscal += "Descrição do produto: " + item.getProduto().getDescricao() + "\n";
            notaFiscal += "Quantidade: " + item.getQuantidade() + "\n";
            notaFiscal += "Preço do item: " + item.calcularPrecoDoItem() + "\n";
        }
        listaNFModel.addElement(notaFiscal);
    }
    
    mostrarLista.setModel(listaNFModel);
    
    JScrollPane scrollPane = new JScrollPane(mostrarLista2);
    JOptionPane.showMessageDialog(null, scrollPane, "Notas Fiscais", JOptionPane.PLAIN_MESSAGE);
        
        
        
    }//GEN-LAST:event_BotaoMostrarNotasActionPerformed

    private void caixaDeTextoConsultarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaDeTextoConsultarNFActionPerformed
      
    }//GEN-LAST:event_caixaDeTextoConsultarNFActionPerformed

    private void btnPesquisarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarNotaFiscalActionPerformed
        
        DefaultTableModel modeloConsultar = new DefaultTableModel(new Object [] {"Código da nota fiscal","data da nota fiscal","Codigo do produto", "Nome do produto","Descrição", "Quantidade","Preço do item"},0);
        if(opcaoCodigo.isSelected()){
            
            int codigo = Integer.parseInt(caixaDeTextoConsultarNF.getText());
            try {

                  /* percorrendo a lista de notas fiscais através do for-each, verificando se o código da nota 
                fiscal na lista atual é igual ao código informado pelo usuário. Se for 
                verdadeiro, ele entra em outro loop for-each, onde percorre a lista de itens da nota 
                fiscal encontrada, break finaliza o loop mais externo, uma vez que a nota fiscal já foi encontrada e processada.*/
                for(NotaFiscal nf: listaDeNotasFiscais.getListaNota()){
                    if(nf.getCodNotaFiscal() == codigo){
                        for(Item item : nf.getListaItem()){
                            Object linha []=new Object[]{nf.getCodNotaFiscal(),nf.getData(),item.getProduto().getCodigo(),item.getProduto().getNome(),item.getProduto().getDescricao(), item.getQuantidade(), item.getPreco()};

                            modeloConsultar.addRow(linha);
                        }
                        break;
                    }
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Produto não encontrado");
                LoadTableNotafiscal();
            }
            tabelaNotaFiscalRegistrada.setModel(modeloConsultar);
            
        }else{
            String data = caixaDeTextoConsultarNF.getText();
            try {
               for(NotaFiscal nf: listaDeNotasFiscais.getListaNota()){
                    if(nf.getData().equals(data)){
                        for(Item item : nf.getListaItem()){
                            Object linha []=new Object[]{nf.getCodNotaFiscal(),nf.getData(),item.getProduto().getCodigo(),item.getProduto().getNome(),item.getProduto().getDescricao(), item.getQuantidade(), item.getPreco()};

                            modeloConsultar.addRow(linha);
                        }
                        break;
                    }
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Produto não encontrado");
                LoadTableNotafiscal();
            }
        }
       
        
        
    }//GEN-LAST:event_btnPesquisarNotaFiscalActionPerformed

    private void tabelaNotaFiscalRegistradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNotaFiscalRegistradaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaNotaFiscalRegistradaMouseClicked

    private void opcaoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoCodigoActionPerformed
        caixaDeTextoConsultarNF.setEnabled(true);   
    }//GEN-LAST:event_opcaoCodigoActionPerformed

    private void opcaoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoDataActionPerformed
        caixaDeTextoConsultarNF.setEnabled(true);      
    }//GEN-LAST:event_opcaoDataActionPerformed


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
    private javax.swing.JButton BotaoMostrarNotas;
    private javax.swing.JTabbedPane MenuNotaFisca;
    private javax.swing.JButton SalvarNotaFiscal;
    private javax.swing.JTable TabelaNF;
    private javax.swing.JTextField TxtQtdDeItem;
    private javax.swing.JButton botaoCancelarNF;
    private javax.swing.JButton botaoSalvarItem;
    private javax.swing.JButton btnPesquisarNotaFiscal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JTextField caixaDeTextoConsultarNF;
    private javax.swing.JTextField caixaPreencherData;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTXTConsultarNF;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelNFRegistrada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel labelConsultarNF;
    private javax.swing.JLabel labelData;
    private javax.swing.JList<String> mostrarLista;
    private javax.swing.JRadioButton opcaoCodigo;
    private javax.swing.JRadioButton opcaoData;
    private javax.swing.JTable tabelaNotaFiscalRegistrada;
    private javax.swing.JLabel textoNotaFiscal;
    private javax.swing.JLabel textoRelacaoItemNF;
    private javax.swing.JLabel txtPrecoItem;
    // End of variables declaration//GEN-END:variables

    private void LoadTableProduto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
