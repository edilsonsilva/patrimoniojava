package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.Conexao;
import br.com.patrimonio.dao.DAOUsuario;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import br.com.patrimonio.pojo.Perfil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { Usuarios frame = new Usuarios();
	  frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	  }
	 

	/**
	 * Create the frame.
	 */
	public Usuarios() {
		setResizable(false);
		setTitle("Cadastrar Usuários");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Usuarios.class.getResource("/br/com/patrimonio/imagens/icons8-chamada-em-conferência-50.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeUsuario = new JLabel("Nome de Usuário:");
		lblNomeUsuario.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		lblNomeUsuario.setBounds(10, 11, 196, 22);
		contentPane.add(lblNomeUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 39, 414, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		lblEmail.setBounds(10, 80, 196, 22);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 108, 414, 30);
		contentPane.add(txtEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		lblSenha.setBounds(10, 149, 196, 22);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 175, 414, 30);
		contentPane.add(txtSenha);

		JLabel lblPerfil = new JLabel("Perfil:");
		lblPerfil.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		lblPerfil.setBounds(10, 216, 196, 22);
		contentPane.add(lblPerfil);

		JComboBox cbxPerfil = new JComboBox();
		cbxPerfil.setModel(new DefaultComboBoxModel(Perfil.values()));
		cbxPerfil.setBounds(10, 237, 414, 30);
		contentPane.add(cbxPerfil);

		JCheckBox chkAtivo = new JCheckBox("Usuário Ativo?");
		chkAtivo.setSelected(true);
		chkAtivo.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		chkAtivo.setBounds(6, 275, 259, 23);
		contentPane.add(chkAtivo);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setIcon(new ImageIcon(
				Usuarios.class.getResource("/br/com/patrimonio/imagens/icons8-adicionar-usuário-masculino-24.png")));
		btnCadastrar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnCadastrar.setBounds(6, 308, 418, 35);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Vamos instanciar a camada Pojo e passar os dados para
				// O usuário, por meio do comando set

				br.com.patrimonio.pojo.Usuarios us = new br.com.patrimonio.pojo.Usuarios();

				us.setNome(txtUsuario.getText());
				us.setEmail(txtEmail.getText());
				us.setSenha_hash(txtSenha.getText());
				us.setPerfil((Perfil) cbxPerfil.getSelectedItem());
				us.setAtivo(chkAtivo.isSelected());

				DAOUsuario dau = new DAOUsuario();
				String rs = dau.cadastrar(us);

				JOptionPane.showMessageDialog(null, rs, "Aviso", JOptionPane.INFORMATION_MESSAGE);
				txtUsuario.setText("");
				txtEmail.setText("");
				txtSenha.setText("");

			}
		});

	}

}
