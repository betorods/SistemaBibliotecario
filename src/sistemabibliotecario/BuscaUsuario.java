package sistemabibliotecario;

import Cadastro.EditarUsuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Alberto
 */
public class BuscaUsuario extends javax.swing.JFrame {
    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    

   public BuscaUsuario() throws ClassNotFoundException {
        initComponents();
        conecta = Conexao.conexao();
        listarUsuario();
     
    }
    public void listarUsuario(){
        String sql = "Select codigo, nome, cpf, endereco from TBusuario order by codigo Asc"; // order by codigo Desc ou Asc para ordenar
        try{
            pst = conecta.prepareStatement(sql);
            
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
         }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
   
    public void pesquisaUsuario(){
        String sql ="Select codigo, nome, cpf, endereco from TBusuario where nome like ?" ;
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, nomeUsuario.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
           // pst.setString(1, cpfUsuario.getText()+"%");
           // pst.setString(3, codigoUsuario.getText()+"%");
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void pesquisaUsuarioCpf(){
        String sql ="Select codigo, nome, cpf, endereco from TBusuario where cpf like ?" ;
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpfUsuario.getText()+"%");
           // pst.setString(3, codigoUsuario.getText()+"%");
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void pesquisaUsuarioCodigo(){
        String sql ="Select codigo, nome, cpf, endereco from TBusuario where codigo like ?" ;
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoUsuario.getText()+"%");
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    

    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeUsuario = new javax.swing.JTextField();
        cpfUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoUsuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaUsuario = new javax.swing.JTable();
        voltar1 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(400, 180, 0, 0));
        setResizable(false);

        nomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioActionPerformed(evt);
            }
        });
        nomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeUsuarioKeyReleased(evt);
            }
        });

        cpfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfUsuarioActionPerformed(evt);
            }
        });
        cpfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfUsuarioKeyReleased(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Formulario de Busca Usuário");

        jLabel4.setText("Código");

        codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoUsuarioActionPerformed(evt);
            }
        });
        codigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoUsuarioKeyReleased(evt);
            }
        });

        TabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaUsuario);

        voltar1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\door_out.png")); // NOI18N
        voltar1.setText("Voltar");
        voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar1ActionPerformed(evt);
            }
        });

        limpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\paintbrush.png")); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\cancel.png")); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        salvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\disk.png")); // NOI18N
        salvar.setText("Editar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nomeUsuario)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(limpar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(voltar1)
                    .addComponent(salvar))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, limpar, salvar, voltar1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioActionPerformed

    private void cpfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfUsuarioActionPerformed

    private void codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoUsuarioActionPerformed

    private void nomeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUsuarioKeyReleased
        pesquisaUsuario();
        cpfUsuario.setText("");
        codigoUsuario.setText("");
    }//GEN-LAST:event_nomeUsuarioKeyReleased

    private void cpfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfUsuarioKeyReleased
        pesquisaUsuarioCpf();
        nomeUsuario.setText("");
        codigoUsuario.setText("");
    }//GEN-LAST:event_cpfUsuarioKeyReleased

    private void codigoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoUsuarioKeyReleased
        pesquisaUsuarioCodigo();
        nomeUsuario.setText("");
        cpfUsuario.setText("");
    
    }//GEN-LAST:event_codigoUsuarioKeyReleased

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        new sistemabibliotecario.TelaPrincipal().show();
        this.setVisible(false);
    }//GEN-LAST:event_voltar1ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        nomeUsuario.setText("");
        codigoUsuario.setText("");
        cpfUsuario.setText("");

    }//GEN-LAST:event_limparActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaUsuarioMouseClicked

    }//GEN-LAST:event_TabelaUsuarioMouseClicked

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            new Cadastro.EditarUsuario().show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_salvarActionPerformed
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
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BuscaUsuario().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaUsuario;
    private javax.swing.JTextField codigoUsuario;
    private javax.swing.JTextField cpfUsuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JButton salvar;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables
}
