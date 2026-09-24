package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOCurso;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Usuarios;


public class Cursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCurso;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cursos frame = new Cursos();
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
	public Cursos() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cursos.class.getResource("/br/com/patrimonio/imagens/icons8-pirâmide-do-louvre-48.png")));
		setTitle("Cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/icons8-pirâmide-do-louvre-48.png")));
		lblNewLabel.setBounds(10, 0, 53, 74);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cursos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 64, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 434, 74);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do Curso:");
		lblNewLabel_2.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 90, 366, 21);
		contentPane.add(lblNewLabel_2);
		
		txtNomeCurso = new JTextField();
		txtNomeCurso.setBounds(10, 122, 414, 32);
		contentPane.add(txtNomeCurso);
		txtNomeCurso.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sigla:");
		lblNewLabel_2_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 165, 126, 21);
		contentPane.add(lblNewLabel_2_1);
		
		txtSigla = new JTextField();
		txtSigla.setColumns(10);
		txtSigla.setBounds(10, 197, 126, 32);
		contentPane.add(txtSigla);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Criado Por:");
		lblNewLabel_2_1_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(146, 165, 126, 21);
		contentPane.add(lblNewLabel_2_1_1);
		
		DAOUsuario dau = new DAOUsuario();
			
		//A JComboBox foi tipada como Usuarios para
		//receber apenas objeto usuarios completo
		//com todos os seus dados.
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setBounds(146, 197, 278, 32);
		contentPane.add(cbxCriadoPor);
		
		//Criamos uma lista de usuários que retorna do método
		//listaAtivos da classe DAOUsuario. Aqui estamos passado
		//todos os usuários retornados para a lista lst que 
		//está tipada como Usuarios, assim ela recebe apenas
		//dados de usuários
		List<Usuarios> lst = dau.listaAtivos();
		//A estrutura for está pegando um item por vez dentro de 
		//lst e passa para a variável us. O item que está sendo 
		//passado é um usuário completo. Depois de passado para a 
		//variável us, estamos adicionando à JComboBox o usuário 
		//com todos os seus dados.
		for (Usuarios us : lst) {
			cbxCriadoPor.addItem(us);
		}
		
		
		JButton btnCadastrar = new JButton("Cadastrar Curso");
		
		btnCadastrar.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/patrimonio/imagens/icons8-adicionar-propriedade-24.png")));
		btnCadastrar.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 15));
		btnCadastrar.setBounds(10, 253, 414, 32);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Cursos e Instância da classe DAO
				br.com.patrimonio.pojo.Cursos curso = new br.com.patrimonio.pojo.Cursos();
				DAOCurso dc = new DAOCurso();
				
				curso.setNome(txtNomeCurso.getText());
				curso.setSigla(txtSigla.getText());
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				curso.setCriado_por(u.getId());
				
				String m = dc.cadastrar(curso);
				JOptionPane.showMessageDialog(null, m);
			}
		});		
		
	}
}
