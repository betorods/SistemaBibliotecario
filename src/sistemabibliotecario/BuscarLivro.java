/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemabibliotecario;

import util.Conexao;
//import sistemabibliotecario.BuscaUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sistemabibliotecario.TelaPrincipal;

/**
 *
 * @author Alberto
 */
public class BuscarLivro extends javax.swing.JFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    
    public BuscarLivro() throws ClassNotFoundException {
        initComponents();
        conecta = Conexao.conexao();
       // listarLivros();
    }

    public void listarLivros(){
        String sql = "Select *from TBlivro order by idLivro Asc"; // order by codigo Desc ou Asc para ordenar
        try{
            pst = conecta.prepareStatement(sql);
            
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
         }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
      public void pesquisaLivro(){
        String sql = "Select idlivro,titulo,autor,edicao, editora, ano from TBlivro WHERE titulo like ?";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, tituloLivro.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }

      public void pesquisaLivro1(){
        String sql = "Select idlivro,titulo,autor,edicao, editora, ano from TBlivro WHERE idlivro like ?";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoLivro.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
      public void pesquisaLivro2(){
        String sql = "Select idlivro,titulo,autor,edicao, editora, ano from TBlivro WHERE autor like ?";
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, autorLivro.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            tabBuscLivro.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloLivro = new javax.swing.JTextField();
        autorLivro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoLivro = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        voltar1 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabBuscLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 150, 0, 0));
        setResizable(false);

        tituloLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloLivroActionPerformed(evt);
            }
        });
        tituloLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tituloLivroKeyReleased(evt);
            }
        });

        autorLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorLivroActionPerformed(evt);
            }
        });
        autorLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                autorLivroKeyReleased(evt);
            }
        });

        jLabel1.setText("Titulo:");

        jLabel2.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Formulario de Busca de Livro");

        jLabel4.setText("Codigo:");

        codigoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoLivroActionPerformed(evt);
            }
        });
        codigoLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoLivroKeyReleased(evt);
            }
        });

        salvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\disk.png")); // NOI18N
        salvar.setText("Editar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

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

        jScrollPane2.setViewportView(tabBuscLivro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(autorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(codigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tituloLivro)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salvar)
                                .addGap(18, 18, 18)
                                .addComponent(voltar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(limpar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, limpar, salvar, voltar1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(autorLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(codigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(voltar1)
                    .addComponent(salvar))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, limpar, salvar, voltar1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloLivroActionPerformed

    private void autorLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorLivroActionPerformed

    private void codigoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoLivroActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            new Cadastro.EditarLivros().show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_salvarActionPerformed

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        new sistemabibliotecario.TelaPrincipal().show();
        this.setVisible(false);
    }//GEN-LAST:event_voltar1ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        tituloLivro.setText("");
        codigoLivro.setText("");
        autorLivro.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tituloLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloLivroKeyReleased
        pesquisaLivro();
        codigoLivro.setText("");
        autorLivro.setText("");    
    }//GEN-LAST:event_tituloLivroKeyReleased

    private void autorLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorLivroKeyReleased
        pesquisaLivro2();
    }//GEN-LAST:event_autorLivroKeyReleased

    private void codigoLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoLivroKeyReleased
        pesquisaLivro1();
    }//GEN-LAST:event_codigoLivroKeyReleased

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
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BuscarLivro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BuscarLivro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autorLivro;
    private javax.swing.JTextField codigoLivro;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabBuscLivro;
    private javax.swing.JTextField tituloLivro;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables
}
