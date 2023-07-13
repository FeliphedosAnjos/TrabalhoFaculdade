
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Funcoes extends javax.swing.JFrame {

    public Funcoes() {
        initComponents();
        btnDeletar.setVisible(false);
        btnAlterar.setVisible(false);

    }

    public Funcoes(String categoria, String nome, String material, String skill, String operacao) {
        initComponents();
        cmbBox.setSelectedItem(categoria);
        txtNome.setText(nome);
        txtMaterial.setText(material);
        txtSkill.setText(skill);
        if (operacao.equals("deletar")) {
            btnSalvar.setVisible(false);
            btnAlterar.setVisible(false);
            
        } else if (operacao.equals("alterar")) {
            btnSalvar.setVisible(false);
            btnDeletar.setVisible(false);
            txtNome.setEnabled(false);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategoria = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblMaterial = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        lblSkill = new javax.swing.JLabel();
        txtSkill = new javax.swing.JTextField();
        cmbBox = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setTitle("Salvar");
        getContentPane().setLayout(null);

        lblCategoria.setText("Categoria");
        getContentPane().add(lblCategoria);
        lblCategoria.setBounds(51, 50, 100, 36);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(240, 104, 117, 36);

        lblMaterial.setText("Material");
        getContentPane().add(lblMaterial);
        lblMaterial.setBounds(51, 158, 100, 36);

        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(51, 104, 100, 36);

        txtMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaterialActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaterial);
        txtMaterial.setBounds(240, 158, 117, 36);

        lblSkill.setText("Skill");
        getContentPane().add(lblSkill);
        lblSkill.setBounds(51, 212, 100, 36);
        getContentPane().add(txtSkill);
        txtSkill.setBounds(240, 212, 117, 36);

        cmbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Espada", "Escudo", "Adaga", "Machado", "Lanca", "Arco" }));
        getContentPane().add(cmbBox);
        cmbBox.setBounds(240, 50, 117, 36);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(51, 302, 90, 52);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(159, 302, 90, 52);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(267, 302, 90, 52);

        setSize(new java.awt.Dimension(446, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaterialActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String c, n, m, s;
        c = cmbBox.getSelectedItem().toString();// aqui pega da caixa ja selecionado e tabem tranforma em string
        n = txtNome.getText();// aqui pega o nome
        m = txtMaterial.getText();//aqui pega o material
        s = txtSkill.getText();// aqui pega as skill

        if (c.isEmpty()) { // se categoria estiver vazio
            JOptionPane.showMessageDialog(null, "É obrigatório escolher a categoria");
            cmbBox.requestFocus();
            return; // stop
        }
        //3 Conectar no banco de dados
        try {
            //2 - Conectar no banco de dados sistemabd
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");
            //4 inserir os dados no banco de dados
            PreparedStatement st = conectado.prepareStatement("INSERT INTO equipamento VALUES(?,?,?,?);");
            st.setString(1, c);
            st.setString(2, n);
            st.setString(3, m);
            st.setString(4, s);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipamento Cadastrado");

            conectado.close();
            dispose();

            // 4.1 limpar os campos
            cmbBox.setSelectedIndex(0);
            txtNome.setText("");
            txtMaterial.setText("");
            txtSkill.setText("");
            cmbBox.requestFocus();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String c, n, m, s;
        c = cmbBox.getSelectedItem().toString();// aqui pega da caixa ja selecionado e tabem tranforma em string
        n = txtNome.getText();// aqui pega o nome
        m = txtMaterial.getText();//aqui pega o material
        s = txtSkill.getText();// aqui pega as skill

        if (c.isEmpty()) { // se categoria estiver vazio
            JOptionPane.showMessageDialog(null, "É obrigatório escolher a categoria");
            cmbBox.requestFocus();
            return; // stop
        }
        //3 Conectar no banco de dados
        try {
            //2 - Conectar no banco de dados sistemabd
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");
            //4 inserir os dados no banco de dados
            PreparedStatement st = conectado.prepareStatement("UPDATE equipamento SET categoria = ?, material = ?, skill = ? WHERE nome = ?");
            st.setString(1, c);
            st.setString(2, m);
            st.setString(3, s);
            st.setString(4, n);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipamento Alterado");

            conectado.close();
            dispose();

            // 4.1 limpar os campos
            cmbBox.setSelectedIndex(0);
            txtNome.setText("");
            txtMaterial.setText("");
            txtSkill.setText("");
            cmbBox.requestFocus();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        //1 - Perguntar se tem certeza que deseja excluir
        int resposta; // 0 - sim; 1 - nao; 
        resposta = JOptionPane.showConfirmDialog(null, "Confirma", "Confirmacao", 0);
        
                //1.1 - Se a resposta for sim
        if (resposta == 0) {
            //1.1.1 Obter o usuário no txtUsuario.
            String u = txtNome.getText();
            //1.1.2 - conectar com o banco de dados
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");
                //1.1.3 excluir o usuario do banco de dados
                PreparedStatement st = conectado.prepareStatement("DELETE FROM equipamento WHERE nome = ?");
                st.setString(1, u);
                st.executeUpdate(); // executa os comando INSERT, UPDATE, DELETE
                //1.1.4 Mostrar a mensagem informando sucesso na exclusão
                JOptionPane.showMessageDialog(null, "equipamento excluido");
                //  1.1.5 Desconectar
                dispose(); // aqui que fecha a tela
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Menssagem de erro:" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Menssagem de erro:" + ex.getMessage());
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbBox;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSkill;
    // End of variables declaration//GEN-END:variables
}
