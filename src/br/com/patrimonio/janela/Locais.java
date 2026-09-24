package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOLocais;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Usuarios;

public class Locais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locais frame = new Locais();
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
	public Locais() {
		setResizable(false);
		setTitle("Cadastro de Locais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1017, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Local:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel.setBounds(-17, 107, 216, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrioDoLocal = new JLabel("Descrição do Local:");
		lblDescrioDoLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrioDoLocal.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblDescrioDoLocal.setBounds(-17, 159, 216, 26);
		contentPane.add(lblDescrioDoLocal);
		
		JLabel lblCriadoPor = new JLabel("Criado Por:");
		lblCriadoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCriadoPor.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblCriadoPor.setBounds(-17, 313, 216, 26);
		contentPane.add(lblCriadoPor);
		
		txtNome = new JTextField();
		txtNome.setBounds(209, 107, 330, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 159, 330, 135);
		contentPane.add(scrollPane);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setBounds(209, 313, 330, 30);
		contentPane.add(cbxCriadoPor);
		DAOUsuario dau = new DAOUsuario();
		List<Usuarios> lst = dau.listaAtivos();
		
		for(Usuarios us : lst) {
			cbxCriadoPor.addItem(us);
		}
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		btnCadastrar.setBounds(349, 366, 190, 30);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("Locais");
		lblNewLabel_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 640, 84);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Locais.class.getResource("/br/com/patrimonio/imagens/locais.png")));
		lblNewLabel_2.setBounds(507, 11, 504, 493);
		contentPane.add(lblNewLabel_2);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.com.patrimonio.pojo.Locais lo = new br.com.patrimonio.pojo.Locais();
				lo.setNome(txtNome.getText());
				lo.setDescricao(txtDescricao.getText());
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				lo.setCriado_por(u.getId());
				
				DAOLocais dal = new DAOLocais();
				String m = dal.cadastrar(lo);
				JOptionPane.showMessageDialog(null, m);
			}
		});
		
		

	}
}
