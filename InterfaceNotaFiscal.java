

package devestoquefruteira.DevEstoqueFruteira;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    }

    
    public void LoadTableNotafiscal(){
    DefaultTableModel novoModelo = new DefaultTableModel(new Object [] {"Códido do produto","Nome do produto","Descriçãodo produto","Quantidade item","Preço do item"},0);
        for(int i=0;i<listaDeItem.size();i++){
            Object linha []=new Object[]{
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
    
    
    
    private void loadTableNotaFiscalRegistrada() {
    DefaultTableModel modelTabelaRegistrada = new DefaultTableModel(new Object [] {"Codigo da nota fiscal","data da nota fiscal","Códido do produto","Nome do produto","Descriçãodo produto","Quantidade item","Preço do item"},0);
   
for (NotaFiscal notaFiscal : listaDeNotasFiscais.getListaNota()) {
    for(Item item : notaFiscal.getListaItem()) {
    Object[] linha = { 
        notaFiscal.getCodNotaFiscal(), 
        notaFiscal.getData(),
        item.getProduto().getCodigo(),
        item.getProduto().getNome(),
        item.getProduto().getDescricao(),
        item.getQuantidade(),
        item.getPreco()
    
        
        
        };
        modelTabelaRegistrada.addRow(linha);
    }
    tabelaNotaFiscalRegistrada.setModel(modelTabelaRegistrada);
}
}
    
    public void ManipularInterface(){
        switch(modo){
            case "Navegar":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEnabled(false);
                TxtQtdDeItem.setEnabled(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                jComboBoxItem.setEnabled(false);
                break;
            case "Novo":
                botaoSalvarItem.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                jComboBoxItem.setEnabled(true);
                TxtQtdDeItem.setEnabled(true);
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                //jComboBoxItem.setEditable(false);
                break;
            case "Editar":
                 botaoSalvarItem.setEnabled(true);
                botaoCancelarNF.setEnabled(true);
                jComboBoxItem.setEnabled(true);
                TxtQtdDeItem.setEnabled(true);
                BotaoCadastrarNF.setEnabled(false);
                BotaoEditarNF.setEnabled(false);
                BotaoExcluiRNF.setEnabled(false);
                //jComboBoxItem.setEditable(false);
                break;
                
            
            case "Excluir":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEnabled(false);
                 TxtQtdDeItem.setEnabled(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(true);
                BotaoExcluiRNF.setEnabled(true);
                jComboBoxItem.setEnabled(false);
                break;
                
            case "Selecao":
                botaoSalvarItem.setEnabled(false);
                botaoCancelarNF.setEnabled(false);
                jComboBoxItem.setEditable(false);
                TxtQtdDeItem.setEnabled(false);
                BotaoCadastrarNF.setEnabled(true);
                BotaoEditarNF.setEnabled(true);
                BotaoExcluiRNF.setEnabled(true); 
                
                //jComboBoxItem.setEditable(true);
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        labelConsultarNF = new javax.swing.JPanel();
        jLabelTXTConsultarNF = new javax.swing.JLabel();
        pesquisarPorData = new javax.swing.JTextField();
        btnPesquisarNotaFiscal = new javax.swing.JButton();
        botaodeExcluirNotaFsical = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        caixaDeTextoConsultarNF1 = new javax.swing.JTextField();
        jPanelNFRegistrada = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaNotaFiscalRegistrada = new javax.swing.JTable();

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

        TxtQtdDeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtQtdDeItemActionPerformed(evt);
            }
        });

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
                        .addGap(27, 27, 27)
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
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecoItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarItem)
                    .addComponent(botaoCancelarNF))
                .addContainerGap(16, Short.MAX_VALUE))
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

        labelConsultarNF.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar notas fiscais"));
        labelConsultarNF.setToolTipText("");
        labelConsultarNF.setName(""); // NOI18N
        labelConsultarNF.setOpaque(false);

        jLabelTXTConsultarNF.setText("Código da nota fiscal:");

        pesquisarPorData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarPorDataActionPerformed(evt);
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

        botaodeExcluirNotaFsical.setText("Excluir");
        botaodeExcluirNotaFsical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaodeExcluirNotaFsicalActionPerformed(evt);
            }
        });

        jLabel6.setText("Pesquisar por data:");

        caixaDeTextoConsultarNF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaDeTextoConsultarNF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout labelConsultarNFLayout = new javax.swing.GroupLayout(labelConsultarNF);
        labelConsultarNF.setLayout(labelConsultarNFLayout);
        labelConsultarNFLayout.setHorizontalGroup(
            labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelConsultarNFLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labelConsultarNFLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(pesquisarPorData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(labelConsultarNFLayout.createSequentialGroup()
                        .addComponent(jLabelTXTConsultarNF)
                        .addGap(155, 155, 155)
                        .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaodeExcluirNotaFsical)
                            .addComponent(btnPesquisarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(labelConsultarNFLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(caixaDeTextoConsultarNF1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(396, Short.MAX_VALUE)))
        );
        labelConsultarNFLayout.setVerticalGroup(
            labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelConsultarNFLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTXTConsultarNF)
                    .addComponent(btnPesquisarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaodeExcluirNotaFsical)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pesquisarPorData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(labelConsultarNFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(labelConsultarNFLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(caixaDeTextoConsultarNF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConsultarNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelConsultarNF.getAccessibleContext().setAccessibleName("");

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
                    .addContainerGap(37, Short.MAX_VALUE)))
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
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(textoNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuNotaFisca, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaNFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaNFMouseClicked

        int index = TabelaNF.getSelectedRow();
        if (index>=0 && index<listaDeNotasFiscais.size()){ //ao selecionar ele para aqui
            try {
            NotaFiscal n=  listaDeNotasFiscais.get(index);
            
            Produto p =  n.getProduto();
            TxtQtdDeItem.setText(String.valueOf(p.getQuantidade())); 
            modo="Selecao";
            ManipularInterface();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
        }
    
    }//GEN-LAST:event_TabelaNFMouseClicked

    private void BotaoCadastrarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarNFActionPerformed
        TxtQtdDeItem.setText("");
        modo="Novo";
        ManipularInterface(); 
    }//GEN-LAST:event_BotaoCadastrarNFActionPerformed

    private void BotaoEditarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarNFActionPerformed
       
        
        
        
        modo="Editar";
        ManipularInterface();
        
 
    }//GEN-LAST:event_BotaoEditarNFActionPerformed

    private void BotaoExcluiRNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluiRNFActionPerformed

        int index = TabelaNF.getSelectedRow();
        if (index >= 0 && index < listaDeNotasFiscais.size()){
            NotaFiscal notaFiscal = listaDeNotasFiscais.get(index);
            int indexItem = jComboBoxItem.getSelectedIndex();
            if (indexItem >= 0) {
                Item item = notaFiscal.getListaItem().get(indexItem);
                try {
                    notaFiscal.removerItem(item);
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Problema ao remover o produto!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um item na lista para excluir");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma nota fiscal na lista para excluir o item");
        }
        LoadTableNotafiscal();
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_BotaoExcluiRNFActionPerformed

    private void botaoCancelarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarNFActionPerformed
        TxtQtdDeItem.setText("");
        modo="Navegar";
        ManipularInterface();
    }//GEN-LAST:event_botaoCancelarNFActionPerformed

    private void botaoSalvarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarItemActionPerformed
    if (modo.equals("Novo")) {
        try {
                Item item = new Item();
                Produto selectedProduto = (Produto) jComboBoxItem.getSelectedItem();
                item.setProduto(selectedProduto);
                int quantidade = Integer.parseInt(TxtQtdDeItem.getText());           
            if (quantidade < 0) {
                JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
            } else {
                item.setQuantidade(quantidade);
                double precoDoItem = item.calcularPrecoDoItem();
                listaDeItem.add(item);
                JOptionPane.showMessageDialog(null, "Item adicionado!");
                modo = "Navegar";
                ManipularInterface();
                TxtQtdDeItem.setText("");
                jComboBoxItem.setSelectedIndex(-1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, preencha todos os campos.");
        }
    } else if (modo.equals("Editar")) {
         try {
            int index = TabelaNF.getSelectedRow();
            Item item = listaDeItem.get(index);  
            Produto selectProduto = (Produto)jComboBoxItem.getSelectedItem();
            item.setProduto(selectProduto);
            int quantidade = Integer.parseInt(TxtQtdDeItem.getText());
        if (quantidade < 0) {
            JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
        } else {
            item.setQuantidade(quantidade);
            double precoDoItem = item.calcularPrecoDoItem();
            JOptionPane.showMessageDialog(null, "Item modificado!");
            modo = "Navegar";
            jComboBoxItem.setSelectedIndex(0);
            TxtQtdDeItem.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    LoadTableNotafiscal();
    BotaoEditarNF.setEnabled(true);
    BotaoExcluiRNF.setEnabled(true);

        
        
        
        
        
        
        /* if (modo.equals("Novo")) {
          try {
            Item item = new Item();
            Produto selectedProduto = (Produto) jComboBoxItem.getSelectedItem();
            item.setProduto(selectedProduto);
            int quantidade = Integer.parseInt(TxtQtdDeItem.getText());
            item.setQuantidade(quantidade);
            double precoDoItem = item.calcularPrecoDoItem();

            try {
                if(quantidade <0 ){
                 JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0.Adicione uma quantidade válida! ");
                
                }
                else {
 
              listaDeItem.add(item);
              JOptionPane.showMessageDialog(null, "Item adicionado!");
              modo = "Navegar";
              ManipularInterface();
              TxtQtdDeItem.setText("");
              jComboBoxItem.setSelectedIndex(-1);
                }
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
            }
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, preencha todos os campos.");
          }
        } else if (modo.equals("Editar")) {
         
            
            try {
                int index = TabelaNF.getSelectedRow();
                Item item = listaDeItem.get(index);  
                Produto selectProduto = (Produto)jComboBoxItem.getSelectedItem();
                item.setProduto(selectProduto);
                int quantidade = Integer.parseInt(TxtQtdDeItem.getText());
                item.setQuantidade(quantidade);
               

                    if(quantidade < 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
                    } else {
                    item.setQuantidade(quantidade);
                    double precoDoItem = item.calcularPrecoDoItem();
                    JOptionPane.showMessageDialog(null, "Item modificado!");
                    modo = "Navegar";
                    jComboBoxItem.setSelectedIndex(0);
                    TxtQtdDeItem.setText("");
                    }
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                /*double precoDoItem = item.calcularPrecoDoItem();
                
              
                if(quantidade <0 ){
                 JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0.Adicione uma quantidade válida! ");
                 
                }
                else {
                JOptionPane.showMessageDialog(null, "Item modificado!");
                        }
                
                
                
                
                
               modo="Navegar";
               jComboBoxItem.setSelectedIndex(0);
               TxtQtdDeItem.setText("");*/
   
            /*} catch (Exception ex) {
                //Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Ocorreu um erro, preencha todos os campos.");   
            }*/
       
        
        //modo="Navegar";
        //ManipularInterface();
/*
}   
            LoadTableNotafiscal();
                BotaoEditarNF.setEnabled(true);
                 BotaoExcluiRNF.setEnabled(true);*/
                 
        
        /*if (modo.equals("Novo")) {
        try {
            Item item = new Item();
            Produto selectedProduto = (Produto) jComboBoxItem.getSelectedItem();
            item.setProduto(selectedProduto);
            String quantidadeString = TxtQtdDeItem.getText();
            
            if (selectedProduto == null || quantidadeString == null || quantidadeString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha ou selecione todos os campos.");
                return;
            }   

            double quantidade = Double.parseDouble(quantidadeString);
            int quantidadeInt = Double.valueOf(quantidade).intValue();

                try{
                    if(quantidade <0){
                       JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
                     /*if( quantidade >0){
                        
                         item.setQuantidade(quantidadeInt);

                        double precoDoProduto = selectedProduto.getPreco();
                       
                        
                        double precoDoItem = quantidade * precoDoProduto;
                       // item.setPreco(precoDoItem);
                        
                        
   
                        } else {
                            item.setQuantidade(quantidadeInt);

                            double precoDoItem = item.calcularPrecoDoItem();

                            
                    
                    
                    
                    
                    
                    listaDeItem.add(item);
                    JOptionPane.showMessageDialog(null, "Item adicionado!");
                    modo = "Navegar";
                    ManipularInterface();
                    TxtQtdDeItem.setText("");
                    jComboBoxItem.setSelectedIndex(-1);
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informe apenas números na quantidade.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }
}

        
       else if (modo.equals("Editar")) {
        try {
            int index = TabelaNF.getSelectedRow();
                if (index < 0 || index >= listaDeItem.size()) {
                  JOptionPane.showMessageDialog(null, "Selecione um item da tabela.");
                  return;
                }
                Item item = listaDeItem.get(index);  
                Produto selectProduto = (Produto)jComboBoxItem.getSelectedItem();
                item.setProduto(selectProduto);
                
                if (selectProduto == null || TxtQtdDeItem.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha ou selecione todos os campos.");
                    return;
                }
                
                
                String quantidadeString = TxtQtdDeItem.getText();
                
                try{
                
                int quantidade  = Integer.parseInt(quantidadeString);
                //int quantidade = Integer.parseInt(TxtQtdDeItem.getText());

                    if (quantidade < 0) {
                        JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
                    } else {
                        item.setQuantidade(quantidade);
                        double precoDoItem = item.calcularPrecoDoItem();
                        JOptionPane.showMessageDialog(null, "Item modificado!");
                        modo = "Navegar";
                        jComboBoxItem.setSelectedIndex(0);
                        TxtQtdDeItem.setText("");
                    }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe apenas números na quantidade.");
        }  
                
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }         
    }

            LoadTableNotafiscal();
            BotaoEditarNF.setEnabled(true);
            BotaoExcluiRNF.setEnabled(true);

        
      
        
        */
        
        
        
        
        
        
        
      /*if (modo.equals("Novo")) {
       try {
 
            Produto selectedProduto = (Produto) jComboBoxItem.getSelectedItem();
            item.setProduto(selectedProduto);
            String quantidadeString = TxtQtdDeItem.getText();

            if (selectedProduto == null || quantidadeString == null || quantidadeString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha ou selecione todos os campos.");
                return;
            }*/

            
            
           /* Item item = new Item();
            Produto selectedProduto = (Produto) jComboBoxItem.getSelectedItem();
            item.setProduto(selectedProduto);
            
            
            String quantidadeString = TxtQtdDeItem.getText();
            if (selectedProduto == null || quantidadeString == null || quantidadeString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha ou selecione todos os campos.");
                 return;
            }   
            */
       
            
           /* try{
                int quantidade = Integer.parseInt(quantidadeString);
                if (quantidade < 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
                } else {

                    Item item = new Item(selectedProduto, quantidade,"");
                //double precoDoItem;
                //item.setProduto(selectedProduto);
                item.setQuantidade(quantidade);
           // double precoDoItem = item.calcularPrecoDoItem();
                
                
                /*if (selectedProduto instanceof ProdutoCategoriaPeso) {
                    precoDoItem = item.calcular();
                } else {
                    precoDoItem = item.calcular();
                }*/
                    
                   /* Item item = new Item();
                     item.setProduto(selectedProduto);
                     item.setQuantidade(quantidade);
                   
                    double precoDoItem ;*/
                    
                 
                  
                          
                    
                    

                    
                    /*listaDeItem.add(item);
                    JOptionPane.showMessageDialog(null, "Item adicionado!");
                    modo = "Navegar";
                    ManipularInterface();
                    TxtQtdDeItem.setText("");
                    jComboBoxItem.setSelectedIndex(-1);
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Informe apenas números na quantidade.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }
}

        
       else if (modo.equals("Editar")) {
        try {
            int index = TabelaNF.getSelectedRow();
                if (index < 0 || index >= listaDeItem.size()) {
                  JOptionPane.showMessageDialog(null, "Selecione um item da tabela.");
                  return;
                }
                Item item = listaDeItem.get(index);  
                Produto selectProduto = (Produto)jComboBoxItem.getSelectedItem();
                item.setProduto(selectProduto);
                
                if (selectProduto == null || TxtQtdDeItem.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha ou selecione todos os campos.");
                    return;
                }
                
                
                String quantidadeString = TxtQtdDeItem.getText();
                
                try{
                
                int quantidade  = Integer.parseInt(quantidadeString);
                //int quantidade = Integer.parseInt(TxtQtdDeItem.getText());

                    if (quantidade < 0) {
                        JOptionPane.showMessageDialog(null, "Quantidade não pode ser menor que 0. Adicione uma quantidade válida.");
                    } else {
                        item.setQuantidade(quantidade);
                        //double precoDoItem = item.calcularPrecoDoItem();
                        JOptionPane.showMessageDialog(null, "Item modificado!");
                        modo = "Navegar";
                        jComboBoxItem.setSelectedIndex(0);
                        TxtQtdDeItem.setText("");
                    }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe apenas números na quantidade.");
        }  
                
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }         
    }

            LoadTableNotafiscal();
            BotaoEditarNF.setEnabled(true);
            BotaoExcluiRNF.setEnabled(true);
*/
        
      
       
    }//GEN-LAST:event_botaoSalvarItemActionPerformed

    private void jComboBoxItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItemActionPerformed

    }//GEN-LAST:event_jComboBoxItemActionPerformed

    private void SalvarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarNotaFiscalActionPerformed
    
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
        /*DefaultTableModel modelo = (DefaultTableModel) TabelaNF.getModel();
     
    try {
       
                
            NotaFiscal notaFiscal = new NotaFiscal();
           
                if (listaDeItem == null || listaDeItem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum item adicionado na nota fiscal!");
                    return;
                }
            notaFiscal.setListaDeItens(listaDeItem);
                for(Item item: notaFiscal.getListaItem()){
                Produto produto = item.getProduto();
                    
                   
                    double quantidadeAtual = produto.getQuantidade();
                    int quantidadeVendida = item.getQuantidade();
                    int novaQuantidade = (int) (quantidadeAtual - quantidadeVendida);
                    produto.setQuantidade(novaQuantidade);
                    
                   
                }  
            System.out.println("Tamanho da lista de notas fiscais antes de adicionar nova nota: " + listaDeNotasFiscais.size()); //tirar
            listaDeNotasFiscais.addNotaFiscal(notaFiscal);
            System.out.println("Tamanho da lista de notas fiscais depois de adicionar nova nota: " + listaDeNotasFiscais.size());
           // System.out.println("estoque"+ produto.getQuantidade());
            LoadTableNotafiscal();
           // interfaceProduto.LoadTableEstoque();
            
            modelo.setRowCount(0);
            listaDeItem.clear();
            
            
            JOptionPane.showMessageDialog(null, "Nota fiscal salva com sucesso! E estoque modificado");
        }catch (Exception e) {
           
            Logger.getLogger(InterfaceNotaFiscal.class.getName()).log(Level.SEVERE,null, e);
        } */
    }//GEN-LAST:event_SalvarNotaFiscalActionPerformed

    private void BotaoMostrarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoMostrarNotasActionPerformed
   
                                                        
    GerenciarNotasFiscais gerenciarNotasFiscais = new GerenciarNotasFiscais();
  DefaultListModel<String> listModel = new DefaultListModel<>();
  
  if (listaDeNotasFiscais.getListaNota().isEmpty()) {
JOptionPane.showMessageDialog(null, "Não há notas fiscais cadastradas");
return;
}

  //for (NotaFiscal nota : gerenciarNotasFiscais.getListaNota()) {
    //String notaFiscal = "Código da nota fiscal: " + nota.getCodNotaFiscal() + "\n";
    
  //}


    listaNFModel.removeAllElements();
    for (NotaFiscal nota : listaDeNotasFiscais.getListaNota()) {
        
       
        String notaFiscal = "Código da nota fiscal: " + "\n"+ nota.getCodNotaFiscal() + "\n";       
       
        Date dataAtual = new Date();  //pega a data da máquina
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAtual);
        nota.setData(dataAtual);
        
        
        //listaDeNotasFiscais.getListaNota().add(nota);
        notaFiscal += "Data da nota fiscal: " + dataFormatada + "\n";
       
       
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

    private void pesquisarPorDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPorDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarPorDataActionPerformed

    private void btnPesquisarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarNotaFiscalActionPerformed
    
        try {
            String texto = pesquisarPorData.getText();
            
            int codigo;
            try {
                codigo = Integer.parseInt(texto);
                // Verifica se o código digitado é negativo
                if (codigo < 0) {
                    JOptionPane.showMessageDialog(null, "Código inválido! Por favor, informe um número positivo.");
                    return;
                }
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, informe um número.");
            return;
            }
            DefaultTableModel modeloConsultar = new DefaultTableModel(new Object [] {"Código da nota fiscal","data da nota fiscal","Codigo do produto", "Nome do produto","Descrição", "Quantidade","Preço do item"},0);
    
            boolean notaFiscalEncontrada = false;
            for(NotaFiscal nf: listaDeNotasFiscais.getListaNota()) {
                if (nf.getCodNotaFiscal() == codigo) {
                    notaFiscalEncontrada = true;
                    for(Item item : nf.getListaItem()) {
                        Object linha []=new Object[]{nf.getCodNotaFiscal(),nf.getData(),item.getProduto().getCodigo(),item.getProduto().getNome(),item.getProduto().getDescricao(), item.getQuantidade(), item.getPreco()};
                        modeloConsultar.addRow(linha);
                    }
                    break;
                }
            }
            if (!notaFiscalEncontrada) {
                JOptionPane.showMessageDialog(null, "Nota fiscal não encontrada.");
                return;
            }
        tabelaNotaFiscalRegistrada.setModel(modeloConsultar);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        LoadTableNotafiscal();
        //loadTableNotaFiscalRegistrada();
}
       
        
     
    }//GEN-LAST:event_btnPesquisarNotaFiscalActionPerformed

    private void tabelaNotaFiscalRegistradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNotaFiscalRegistradaMouseClicked
     

    }//GEN-LAST:event_tabelaNotaFiscalRegistradaMouseClicked

    private void botaodeExcluirNotaFsicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaodeExcluirNotaFsicalActionPerformed

        String codigoText = pesquisarPorData.getText();
    if (codigoText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, insira o código da nota fiscal");
        return;
    }
    int codigo = Integer.parseInt(codigoText);
    NotaFiscal notaFiscalParaExcluir = null;
  
    for (NotaFiscal nf : listaDeNotasFiscais.getListaNota()) {
        if (nf.getCodNotaFiscal() == codigo) {
            notaFiscalParaExcluir = nf;
            break;
        }
    }
  
    if (notaFiscalParaExcluir != null) {
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a nota fiscal " + notaFiscalParaExcluir.getCodNotaFiscal() + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            
            listaDeNotasFiscais.getListaNota().remove(notaFiscalParaExcluir);
            JOptionPane.showMessageDialog(null, "Nota fiscal excluída com sucesso");
            loadTableNotaFiscalRegistrada();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Nota fiscal não encontrada");
    }
      /*  int codigo = Integer.parseInt(caixaDeTextoConsultarNF.getText());
    NotaFiscal notaFiscalParaExcluir = null;
  
    for (NotaFiscal nf : listaDeNotasFiscais.getListaNota()) {
        if (nf.getCodNotaFiscal() == codigo) {
            notaFiscalParaExcluir = nf;
            break;
        }
    }
  
    if (notaFiscalParaExcluir != null) {
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a nota fiscal " + notaFiscalParaExcluir.getCodNotaFiscal() + "?");
        if (confirm == JOptionPane.YES_OPTION) {
            
            listaDeNotasFiscais.getListaNota().remove(notaFiscalParaExcluir);
            
            JOptionPane.showMessageDialog(null, "Nota fiscal excluída com sucesso");
           loadTableNotaFiscalRegistrada();
        }
        
        
        
    } else {
        JOptionPane.showMessageDialog(null, "Nota fiscal não encontrada");
    }
  */
  tabelaNotaFiscalRegistrada.setModel(new DefaultTableModel());
modo= "Navegar";
ManipularInterface();
    
     
        
        
     
  
    }//GEN-LAST:event_botaodeExcluirNotaFsicalActionPerformed

    private void TxtQtdDeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtQtdDeItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtQtdDeItemActionPerformed

    private void caixaDeTextoConsultarNF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaDeTextoConsultarNF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaDeTextoConsultarNF1ActionPerformed


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
    private javax.swing.JButton botaodeExcluirNotaFsical;
    private javax.swing.JButton btnPesquisarNotaFiscal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField caixaDeTextoConsultarNF1;
    private javax.swing.JTextField caixaPreencherData;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTextField pesquisarPorData;
    private javax.swing.JTable tabelaNotaFiscalRegistrada;
    private javax.swing.JLabel textoNotaFiscal;
    private javax.swing.JLabel textoRelacaoItemNF;
    private javax.swing.JLabel txtPrecoItem;
    // End of variables declaration//GEN-END:variables

    private void LoadTableProduto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
