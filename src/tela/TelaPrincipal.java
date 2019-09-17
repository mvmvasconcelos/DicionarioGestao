/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.Controlador;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Palavra;

/**
 *
 * @author vinicius
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private Controlador controlador = new Controlador();
    private ArrayList<Palavra> lista = new ArrayList<>();
    private DefaultTableModel tabela; //Cria modelo de tabela
    private int idTermoSelecionado;
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        criaLetrasAlfabeto();
        consultarLista();
    }
    
    //Consulta a lista de palavras
    private void consultarLista(){
        //Se a lista não estiver vazia
        lista = controlador.consultarTermo().getPalavra();
        Collections.sort(lista, Palavra.comparadorTermo);
        montaTabela();
    }
    
    //Consulta a lista de palavras por letra
    private void consultarLista(String palavra){
        if (palavra.length() > 0) {
            lista = controlador.consultarTermo(palavra).getPalavra(); 
            Collections.sort(lista, Palavra.comparadorTermo);
            //System.out.println("tamanho lista" + lista.size());
            montaTabela();
            if (palavra.length() == 1) {
                tabelaPrincipal.getColumnModel().getColumn(0).setHeaderValue("Termos iniciados com \"" + palavra + "\"");
            } else {
                tabelaPrincipal.getColumnModel().getColumn(0).setHeaderValue("Termos contendo \"" + palavra + "\"");                
            }
            tabelaPrincipal.getTableHeader().repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum termo digitado");
        }        
    }
    
    private void montaTabela(){
        if (lista.size() > 0) {
            //limparLista();
            //Recria a tabela caso ela tenha sido modificada            
            tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                     "Termos", "id"
                })
                {
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }}
            );
            //define a tabela com o mesmo modelo da tabelaListagem
            tabela = (DefaultTableModel) tabelaPrincipal.getModel();

            //Cria um objeto dadosLinha, onde cada posição é será coluna
            Object dadosLinha[] = new Object[2];
            //percorre o lista e popula as colunas de acordo com a posicao
            for (int i = 0; i < lista.size(); i++) {
                dadosLinha[0] = lista.get(i).getTermo();
                dadosLinha[1] = lista.get(i).getCodigo();
                //Adiciona os dados à linha na tabela
                tabela.addRow(dadosLinha);                
            }
            tabelaPrincipal.setAutoResizeMode(3);
            tabelaPrincipal.getColumnModel().getColumn(1).setMinWidth(0);
            tabelaPrincipal.getColumnModel().getColumn(1).setMaxWidth(0);
            jScrollPane1.getVerticalScrollBar().setValue(0);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum termo encontrado");
        }  
    }
    
    /** Recebe o id do termo selecionado na tabela e exibe as informações
     * 
     * @param id - retirado da coluna 1
     */
    private void selecionaTermo(int id){
        lblTermoSelecionado.setText(controlador.consultarTermo(id).getPalavra().get(0).getTermo());
        txtDefinicaoTermoSelecionado.setText("Definição:\n\n" 
                                             + controlador.consultarTermo(id).getPalavra().get(0).getDefinicao()
                                             + "\n\n_______________________________________________"
                                             + "\nFonte:\n\n"
                                             + controlador.consultarTermo(id).getPalavra().get(0).getFonte());
        txtDefinicaoTermoSelecionado.setCaretPosition(0);
    }
    
    private void criaLetrasAlfabeto(){
        //Define o painelLetras com layout fluido
        painelLetras.setLayout(new FlowLayout());
        //Força dimensão do painel
        painelLetras.setPreferredSize(new Dimension(780, 100));
        
        //Para cada letra do alfabeto
        for (int i = 0; i < controlador.getAlfabeto().length; i++) {
              //Converte em string
            String letra = String.valueOf(controlador.getAlfabeto()[i]);
            //Cria novo botão com texto da letra
            JButton botaoLetra = new JButton(letra);
            //Força dimensão do botão
            botaoLetra.setPreferredSize(new Dimension(50,40));
           
            //Adiciona botão ao painel
            painelLetras.add(botaoLetra); 
            
            //Adiciona listener para cada botão de letra
            botaoLetra.addActionListener((arg0) -> {
                consultarLista(letra);
            });
        }
        pack();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLetras = new javax.swing.JPanel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPrincipal = new javax.swing.JTable();
        painelDefinicao = new javax.swing.JPanel();
        lblTermoSelecionado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDefinicaoTermoSelecionado = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuArquivoNovo = new javax.swing.JMenuItem();
        menuArquivoListar = new javax.swing.JMenuItem();
        menuArquivoSair = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dicionário de Gestão");
        setMaximumSize(new java.awt.Dimension(800, 400));
        setMinimumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelLetras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelLetras.setMaximumSize(new java.awt.Dimension(780, 100));
        painelLetras.setMinimumSize(new java.awt.Dimension(780, 100));
        painelLetras.setPreferredSize(new java.awt.Dimension(780, 100));

        javax.swing.GroupLayout painelLetrasLayout = new javax.swing.GroupLayout(painelLetras);
        painelLetras.setLayout(painelLetrasLayout);
        painelLetrasLayout.setHorizontalGroup(
            painelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelLetrasLayout.setVerticalGroup(
            painelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        lblPesquisar.setText("Pesquisar");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Termo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPrincipal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPrincipal);
        if (tabelaPrincipal.getColumnModel().getColumnCount() > 0) {
            tabelaPrincipal.getColumnModel().getColumn(0).setResizable(false);
        }

        painelDefinicao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTermoSelecionado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblTermoSelecionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtDefinicaoTermoSelecionado.setEditable(false);
        txtDefinicaoTermoSelecionado.setColumns(20);
        txtDefinicaoTermoSelecionado.setLineWrap(true);
        txtDefinicaoTermoSelecionado.setRows(5);
        txtDefinicaoTermoSelecionado.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDefinicaoTermoSelecionado);

        javax.swing.GroupLayout painelDefinicaoLayout = new javax.swing.GroupLayout(painelDefinicao);
        painelDefinicao.setLayout(painelDefinicaoLayout);
        painelDefinicaoLayout.setHorizontalGroup(
            painelDefinicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDefinicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDefinicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTermoSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDefinicaoLayout.setVerticalGroup(
            painelDefinicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDefinicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTermoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        menuArquivo.setText("Arquivo");

        menuArquivoNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoNovo.setText("Novo Termo");
        menuArquivoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoNovo);

        menuArquivoListar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoListar.setText("Listar Tudo");
        menuArquivoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoListarActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoListar);

        menuArquivoSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoSair.setText("Sair");
        menuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoSair);

        menuBar.add(menuArquivo);

        menuAjuda.setText("Ajuda");

        menuAjudaSobre.setText("Sobre");
        menuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAjudaSobre);

        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelLetras, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblPesquisar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPesquisar))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDefinicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelDefinicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void menuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoSairActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        this.dispose();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_menuArquivoSairActionPerformed

    private void menuArquivoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoNovoActionPerformed
        TelaCadastroPalavra tela = new TelaCadastroPalavra();
        tela.setVisible(true);
    }//GEN-LAST:event_menuArquivoNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        consultarLista(txtPesquisar.getText());  
        txtPesquisar.setText("");        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPrincipalMouseClicked
        idTermoSelecionado = (int) tabelaPrincipal.getValueAt(tabelaPrincipal.getSelectedRow(), 1);
        if (evt.getClickCount() == 2) {
            //System.out.println("2 cliques " + idTermoSelecionado);            
        } else {
            selecionaTermo(idTermoSelecionado);
            //System.out.println("1 só " + idTermoSelecionado);
        }
    }//GEN-LAST:event_tabelaPrincipalMouseClicked

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtPesquisar.getText().isEmpty()) {
            consultarLista(txtPesquisar.getText());
            txtPesquisar.setText("");
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    private void menuArquivoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoListarActionPerformed
        consultarLista();
    }//GEN-LAST:event_menuArquivoListarActionPerformed

    private void menuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaSobreActionPerformed
        JOptionPane.showMessageDialog(this, "Dicionário de Gestão\n"
                + "Criado por Marcus Vasconcelos\n"
                + "2019");
    }//GEN-LAST:event_menuAjudaSobreActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblTermoSelecionado;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuAjudaSobre;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuArquivoListar;
    private javax.swing.JMenuItem menuArquivoNovo;
    private javax.swing.JMenuItem menuArquivoSair;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel painelDefinicao;
    private javax.swing.JPanel painelLetras;
    private javax.swing.JTable tabelaPrincipal;
    private javax.swing.JTextArea txtDefinicaoTermoSelecionado;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
