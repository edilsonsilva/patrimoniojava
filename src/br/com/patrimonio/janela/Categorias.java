package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOCategorias;

public class Categorias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
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
	public Categorias() {
				
		setResizable(false);
		setTitle("Cadastrar Categorias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Categorias.class.getResource("/br/com/patrimonio/imagens/cateogira.png")));
		lblNewLabel.setBounds(433, 11, 310, 365);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Categorais");
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 347, 76);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome da Categoria:");
		lblNewLabel_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 98, 248, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNomeCategoria = new JTextField();
		txtNomeCategoria.setBounds(10, 118, 413, 30);
		contentPane.add(txtNomeCategoria);
		txtNomeCategoria.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Descrição da Categoria:");
		lblNewLabel_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 163, 248, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 413, 164);
		contentPane.add(scrollPane);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		btnCadastrar.setBounds(10, 373, 413, 30);
		contentPane.add(btnCadastrar);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				br.com.patrimonio.pojo.Categorias cat = new br.com.patrimonio.pojo.Categorias();
				cat.setNome(txtNomeCategoria.getText());
				cat.setDescricao(txtDescricao.getText());
				
				DAOCategorias dcat = new DAOCategorias();
				String m = dcat.cadastrar(cat);
				JOptionPane.showMessageDialog(null, m);
				
				
				
				
			}
		});
		
		
		

	}
}
