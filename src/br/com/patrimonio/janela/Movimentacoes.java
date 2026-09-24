package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOPatrimonio;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.TipoMovimentacao;

public class Movimentacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtResponsavel;
	private JTextField txtDataPrevistaRetorno;
	private JTextField txtDataEfetivaRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimentacoes frame = new Movimentacoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Movimentacoes() {
		
		
		DAOPatrimonio daoP = new DAOPatrimonio();
		DAOUsuario daoU = new DAOUsuario();
			
		
		setResizable(false);
		setTitle("Cadastro de Movimentações");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 904, 805);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Movimentacoes.class.getResource("/br/com/patrimonio/imagens/movimentacoes.png")));
		lblNewLabel.setBounds(0, 0, 891, 244);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Movimentação de Patrimônio");
		lblNewLabel_1.setBackground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 30));
		lblNewLabel_1.setBounds(28, 242, 850, 85);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(2, 339, 885, 427);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione o Patrimônio:");
		lblNewLabel_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 20, 225, 24);
		panel.add(lblNewLabel_2);
		
		List<br.com.patrimonio.pojo.Patrimonio> lst = daoP.listar();
		
		
		JComboBox<br.com.patrimonio.pojo.Patrimonio> cbxPatrimonio = new JComboBox();
		cbxPatrimonio.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxPatrimonio.setBounds(221, 20, 277, 30);
		
		for(br.com.patrimonio.pojo.Patrimonio p:lst) {
			cbxPatrimonio.addItem(p);
		}
		
		
		panel.add(cbxPatrimonio);
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Usuário:");
		lblNewLabel_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(508, 21, 97, 24);
		panel.add(lblNewLabel_2_1);
		
		List<br.com.patrimonio.pojo.Usuarios> us = daoU.listaAtivos();
		
		
		JComboBox<br.com.patrimonio.pojo.Usuarios> cbxUsuario = new JComboBox();
		cbxUsuario.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxUsuario.setBounds(588, 20, 277, 30);
		
		for(br.com.patrimonio.pojo.Usuarios u:us) {
			cbxUsuario.addItem(u);
		}
		
		
		panel.add(cbxUsuario);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo de Movimentação:");
		lblNewLabel_2_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(10, 64, 225, 24);
		panel.add(lblNewLabel_2_2);
		
		JComboBox cbxTipoMovimentacao = new JComboBox();
		cbxTipoMovimentacao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxTipoMovimentacao.setModel(new DefaultComboBoxModel(TipoMovimentacao.values()));
		cbxTipoMovimentacao.setBounds(221, 61, 644, 30);
		panel.add(cbxTipoMovimentacao);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Responsável Destino:");
		lblNewLabel_2_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(10, 108, 225, 24);
		panel.add(lblNewLabel_2_2_1);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(221, 102, 644, 30);
		panel.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Data Prevista de Retorno:");
		lblNewLabel_2_2_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1.setBounds(10, 157, 225, 24);
		panel.add(lblNewLabel_2_2_1_1);
		
		txtDataPrevistaRetorno = new JTextField();
		txtDataPrevistaRetorno.setColumns(10);
		txtDataPrevistaRetorno.setBounds(221, 151, 225, 30);
		panel.add(txtDataPrevistaRetorno);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Data Efetiva de Retorno:");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_1.setBounds(461, 157, 225, 24);
		panel.add(lblNewLabel_2_2_1_1_1);
		
		txtDataEfetivaRetorno = new JTextField();
		txtDataEfetivaRetorno.setColumns(10);
		txtDataEfetivaRetorno.setBounds(672, 151, 193, 30);
		panel.add(txtDataEfetivaRetorno);
		
		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("Observações:");
		lblNewLabel_2_2_1_1_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_2.setBounds(10, 204, 225, 24);
		panel.add(lblNewLabel_2_2_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 242, 865, 114);
		panel.add(scrollPane);
		
		JTextArea txtObservacoes = new JTextArea();
		scrollPane.setViewportView(txtObservacoes);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		btnCadastrar.setBounds(578, 367, 297, 38);
		panel.add(btnCadastrar);

	}
}
