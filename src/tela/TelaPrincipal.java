/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.Controlador;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    Controlador controlador = new Controlador();
    ArrayList<Palavra> lista = new ArrayList<>();
    DefaultTableModel tabela; //Cria modelo de tabela
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        criaLetrasAlfabeto();
        consultarLista();
       // adicionaQuebraDeLinha();
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
        lista = controlador.consultarTermo(palavra).getPalavra(); 
        Collections.sort(lista, Palavra.comparadorTermo);
        System.out.println("tamanho lista" + lista.size());
        montaTabela();  
    }
    
    private void montaTabela(){
        if (lista.size() > 0) {
            //limparLista();
            //Recria a tabela caso ela tenha sido modificada            
            tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                     "Termo", "Significado", "Fonte"
                })
                {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }}
            );
            //define a tabela com o mesmo modelo da tabelaListagem
            tabela = (DefaultTableModel) tabelaPrincipal.getModel();

            //Cria um objeto dadosLinha, onde cada posição é será coluna
            Object dadosLinha[] = new Object[3];
            //percorre o lista e popula as colunas de acordo com a posicao
            for (int i = 0; i < lista.size(); i++) {
                dadosLinha[0] = lista.get(i).getTermo();
                
                dadosLinha[1] = lista.get(i).getDefinicao();
                dadosLinha[2] = lista.get(i).getFonte();
                //Adiciona os dados à linha na tabela
                tabela.addRow(dadosLinha);
                /*if (lista.get(i).getDefinicao().length() > 78) {
                    
                    
                    
                    // current table column width in pixels
                    int colWidth = tabelaPrincipal.getColumnModel().getColumn(1).getWidth();

                    // set the text area width (height doesn't matter here)
                    setSize(new Dimension(colWidth, 1)); 

                    // get the text area preferred height and add the row margin
                    int height = getPreferredSize().height + tabelaPrincipal.getRowMargin();
                    
                    tabelaPrincipal.setRowHeight(i, height);
                }*/
            }
            tabelaPrincipal.setAutoResizeMode(3);
            tabelaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelaPrincipal.getColumnModel().getColumn(1).setPreferredWidth(350);
        } else { //Se estiver vazia, avisa o usuário
            //exibirMensagem();
            JOptionPane.showMessageDialog(this, "Nenhum termo encontrado");
        }  
    }
    
    private void adicionaQuebraDeLinha(){
        //158 caracteres
        String quebra = "É uma palavra com origem no latim, onde absens significa “estar fora, afastado ou ausente”. O absenteísmo consiste em se abster de alguma atividade ou função.";
        StringBuilder modificado = new StringBuilder(quebra);
        int tamanho = 0;
        if (quebra.length() > 78) {
            tamanho = (int)(quebra.length() / 78);
            System.out.println("tamanho " + quebra.length() + ", dá " + tamanho + " pedaços");
            for (int i = 1; i <= tamanho; i++) {
                modificado.insert(78*i+2, "<br/>");
            }
            
            JOptionPane.showMessageDialog(this, "<html>" + modificado + "</html>");
        }
    }
    
    private void criaLetrasAlfabeto(){
        //Define o painelLetras com layout fluido
        painelLetras.setLayout(new FlowLayout());
        //Força dimensão do painel
        painelLetras.setPreferredSize(new Dimension(788, 100));
        
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
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuArquivoNovo = new javax.swing.JMenuItem();
        menuArquivoSair = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 400));
        setMinimumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelLetras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelLetras.setMaximumSize(new java.awt.Dimension(788, 100));
        painelLetras.setMinimumSize(new java.awt.Dimension(788, 100));

        javax.swing.GroupLayout painelLetrasLayout = new javax.swing.GroupLayout(painelLetras);
        painelLetras.setLayout(painelLetrasLayout);
        painelLetrasLayout.setHorizontalGroup(
            painelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        painelLetrasLayout.setVerticalGroup(
            painelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        lblPesquisar.setText("Pesquisar");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Termo", "Significado", "Fonte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tabelaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tabelaPrincipal.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabelaPrincipal.getColumnModel().getColumn(2).setResizable(false);
        }

        menuArquivo.setText("Arquivo");

        menuArquivoNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoNovo.setText("Novo Termo");
        menuArquivoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoNovo);

        menuArquivoSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoSair.setText("Sair");
        menuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoSair);

        menuBar.add(menuArquivo);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPesquisar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(painelLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        JOptionPane.showMessageDialog(this, "Dicionário de Gestão");
    }//GEN-LAST:event_menuSobreMouseClicked

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
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPrincipalMouseClicked
        System.out.println("teste");        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPrincipalMouseClicked

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
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuArquivoNovo;
    private javax.swing.JMenuItem menuArquivoSair;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel painelLetras;
    private javax.swing.JTable tabelaPrincipal;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
