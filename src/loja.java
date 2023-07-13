
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class loja extends javax.swing.JFrame {

    public loja() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEspada = new javax.swing.JButton();
        btnLanca = new javax.swing.JButton();
        btnEscudo = new javax.swing.JButton();
        btnAdaga = new javax.swing.JButton();
        btnMachado = new javax.swing.JButton();
        btnArco = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mntCadastra = new javax.swing.JMenuItem();
        mntAlterar = new javax.swing.JMenuItem();
        mntDeletar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja");
        getContentPane().setLayout(null);

        btnEspada.setText("Espada");
        btnEspada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEspada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEspada);
        btnEspada.setBounds(30, 30, 90, 66);

        btnLanca.setText("Lança");
        btnLanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLanca);
        btnLanca.setBounds(490, 30, 90, 66);

        btnEscudo.setText("Escudo");
        btnEscudo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEscudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscudoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEscudo);
        btnEscudo.setBounds(140, 30, 90, 66);

        btnAdaga.setText("Adaga");
        btnAdaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdagaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdaga);
        btnAdaga.setBounds(250, 30, 90, 66);

        btnMachado.setText("Machado");
        btnMachado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMachadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnMachado);
        btnMachado.setBounds(380, 30, 90, 66);

        btnArco.setText("Arco");
        btnArco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArcoActionPerformed(evt);
            }
        });
        getContentPane().add(btnArco);
        btnArco.setBounds(600, 30, 90, 66);

        tblEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Nome", "Material", "Skill"
            }
        ));
        jScrollPane1.setViewportView(tblEstoque);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 660, 370);

        jMenu1.setText("File");

        mntCadastra.setText("Cadastra");
        mntCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntCadastraActionPerformed(evt);
            }
        });
        jMenu1.add(mntCadastra);

        mntAlterar.setText("Alterar");
        mntAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntAlterarActionPerformed(evt);
            }
        });
        jMenu1.add(mntAlterar);

        mntDeletar.setText("Deletar");
        mntDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntDeletarActionPerformed(evt);
            }
        });
        jMenu1.add(mntDeletar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(740, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEspadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspadaActionPerformed
        try {
            String e;
            e = btnEspada.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, e);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnEspadaActionPerformed

    private void btnLancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancaActionPerformed
        try {
            String l;
            l = btnLanca.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, l);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnLancaActionPerformed

    private void btnEscudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscudoActionPerformed
        try {
            String es;
            es = btnEscudo.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, es);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEscudoActionPerformed

    private void btnAdagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdagaActionPerformed
        try {
            String a;
            a = btnAdaga.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, a);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdagaActionPerformed

    private void btnMachadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMachadoActionPerformed
        try {
            String m;
            m = btnMachado.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, m);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnMachadoActionPerformed

    private void btnArcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArcoActionPerformed
        try {
            String a;
            a = btnArco.getActionCommand().toString();

            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");

            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE categoria = ?");
            st.setString(1, a);
            ResultSet resultado = st.executeQuery();

            //3 - Carregar os usuários na tabela tblUsuarios
            DefaultTableModel tblModelo;
            tblModelo = (DefaultTableModel) tblEstoque.getModel();
            tblModelo.setRowCount(0);
            //fazer até chegar no final da tabela (enquanto tiver próximo usuário)
            while (resultado.next()) {
                Object dados[] = {
                    resultado.getString("categoria"),
                    resultado.getString("nome"),
                    resultado.getString("material"),
                    resultado.getString("skill")
                };
                tblModelo.addRow(dados);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnArcoActionPerformed

    private void mntDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntDeletarActionPerformed
        Funcoes("deletar");
    }//GEN-LAST:event_mntDeletarActionPerformed

    private void mntCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntCadastraActionPerformed
        Funcoes tela;
        tela = new Funcoes();
        tela.setVisible(true);
    }//GEN-LAST:event_mntCadastraActionPerformed

    private void mntAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntAlterarActionPerformed
        Funcoes("alterar");
    }//GEN-LAST:event_mntAlterarActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loja().setVisible(true);
            }
        });
    }

    private void Funcoes(String operacao) {

        String u;
        u = JOptionPane.showInputDialog("Digite o nome do equipamento " + operacao);
        if (u == null) {
            return;// stop
        }
        try {
            //1 - Conectar ao Banco de Dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "@55fuLl55@");
            //2 - Busca os usuários pelo cargo selecioando (SELECT)
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM equipamento WHERE nome = ?");
            st.setString(1, u);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                //Pega o nome e o cargo que veio na consulta ao banco de dados
                String categoria, nome, material, skill;
                categoria = resultado.getString("categoria");
                nome = resultado.getString("nome");
                material = resultado.getString("material");
                skill = resultado.getString("skill");
                //Abrir o formulário Menu.java
                Funcoes tela;
                tela = new Funcoes(categoria, nome, material, skill, operacao);
                tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "equipamento nao inserido");
            }
            //5 - Desconectar.
            conectado.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver não está na library");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Você errou nos dados da conexão com o banco de dados");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdaga;
    private javax.swing.JButton btnArco;
    private javax.swing.JButton btnEscudo;
    private javax.swing.JButton btnEspada;
    private javax.swing.JButton btnLanca;
    private javax.swing.JButton btnMachado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mntAlterar;
    private javax.swing.JMenuItem mntCadastra;
    private javax.swing.JMenuItem mntDeletar;
    private javax.swing.JTable tblEstoque;
    // End of variables declaration//GEN-END:variables

}
