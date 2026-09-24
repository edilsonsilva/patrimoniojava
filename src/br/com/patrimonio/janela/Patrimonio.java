package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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

import br.com.patrimonio.dao.DAOCategorias;
import br.com.patrimonio.dao.DAOCurso;
import br.com.patrimonio.dao.DAOLocais;
import br.com.patrimonio.dao.DAOPatrimonio;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Categorias;
import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Locais;
import br.com.patrimonio.pojo.Status;
import br.com.patrimonio.pojo.Usuarios;

public class Patrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroTombamento;
	private JTextField txtNomePatrimonio;
	private JTextField txtValorAquisicao;
	private JTextField txtDataAquisicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimonio frame = new Patrimonio();
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
	public Patrimonio() {
		
		DAOUsuario dau = new DAOUsuario();
		DAOCategorias dac = new DAOCategorias();
		DAOCurso daoc = new DAOCurso();
		DAOLocais dal = new DAOLocais();
		
		
		
		
		
		setTitle("Cadastro de Patrimônio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1273, 871);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/patrimonio/imagens/backfundo3.png")));
		lblNewLabel.setBounds(-1, 0, 1046, 258);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Novo Patrimônio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 40));
		lblNewLabel_1.setBounds(9, 267, 1029, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número do Tombamento");
		lblNewLabel_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(29, 360, 240, 36);
		contentPane.add(lblNewLabel_2);
		
		txtNumeroTombamento = new JTextField();
		txtNumeroTombamento.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtNumeroTombamento.setBounds(255, 365, 240, 30);
		contentPane.add(txtNumeroTombamento);
		txtNumeroTombamento.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome do Patrimônio");
		lblNewLabel_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(527, 360, 196, 36);
		contentPane.add(lblNewLabel_2_1);
		
		txtNomePatrimonio = new JTextField();
		txtNomePatrimonio.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtNomePatrimonio.setColumns(10);
		txtNomePatrimonio.setBounds(712, 365, 513, 30);
		contentPane.add(txtNomePatrimonio);
		
		JLabel lblNewLabel_2_2 = new JLabel("Descrição do Patrimônio");
		lblNewLabel_2_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(452, 479, 240, 36);
		contentPane.add(lblNewLabel_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 526, 1196, 151);
		contentPane.add(scrollPane);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		scrollPane.setViewportView(txtDescricao);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Curso");
		lblNewLabel_2_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(394, 426, 101, 36);
		contentPane.add(lblNewLabel_2_2_1);
		
		List<Cursos> lstCursos = daoc.listar();
		
		JComboBox<Cursos> cbxCurso = new JComboBox();
		cbxCurso.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxCurso.setBounds(452, 428, 338, 36);
		
		for(Cursos cs : lstCursos) {
			cbxCurso.addItem(cs);
		}		
		contentPane.add(cbxCurso);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Local");
		lblNewLabel_2_2_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1.setBounds(832, 426, 101, 36);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		List<Locais> lstLocais = dal.listar();
		
		JComboBox<Locais> cbxLocal = new JComboBox();
		cbxLocal.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxLocal.setBounds(887, 428, 338, 36);
		
		for(Locais loc : lstLocais) {
			cbxLocal.addItem(loc);
		}
		
		contentPane.add(cbxLocal);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Categoria");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_1.setBounds(29, 426, 101, 36);
		contentPane.add(lblNewLabel_2_2_1_1_1);
		
		List<Categorias> lstCat = dac.listar();		
		
		
		JComboBox<Categorias> cbxCategoria = new JComboBox();
		cbxCategoria.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxCategoria.setBounds(115, 428, 252, 36);
		
		for(Categorias ct : lstCat) {
			cbxCategoria.addItem(ct);
		}
		contentPane.add(cbxCategoria);
		
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Status");
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_1_1.setBounds(29, 688, 101, 36);
		contentPane.add(lblNewLabel_2_2_1_1_1_1);
		
		JComboBox cbxStatus = new JComboBox();
		cbxStatus.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxStatus.setModel(new DefaultComboBoxModel(Status.values()));
		cbxStatus.setBounds(88, 690, 252, 36);
		contentPane.add(cbxStatus);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1 = new JLabel("Criado Por");
		lblNewLabel_2_2_1_1_1_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_1_1_1.setBounds(385, 688, 101, 36);
		contentPane.add(lblNewLabel_2_2_1_1_1_1_1);
		
		
		List<Usuarios> lstUsuarios = dau.listaAtivos();
		
		
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		cbxCriadoPor.setBounds(483, 690, 252, 36);
		
		for(Usuarios us:lstUsuarios) {
			cbxCriadoPor.addItem(us);
		}
		
		
		contentPane.add(cbxCriadoPor);
		
		JLabel lblNewLabel_2_3 = new JLabel("Valor da Aquisição");
		lblNewLabel_2_3.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(776, 688, 179, 36);
		contentPane.add(lblNewLabel_2_3);
		
		txtValorAquisicao = new JTextField();
		txtValorAquisicao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtValorAquisicao.setColumns(10);
		txtValorAquisicao.setBounds(935, 688, 290, 30);
		contentPane.add(txtValorAquisicao);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Data da Aquisição");
		lblNewLabel_2_3_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_3_1.setBounds(29, 750, 179, 36);
		contentPane.add(lblNewLabel_2_3_1);
		
		txtDataAquisicao = new JTextField();
		txtDataAquisicao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		txtDataAquisicao.setColumns(10);
		txtDataAquisicao.setBounds(189, 755, 178, 30);
		contentPane.add(txtDataAquisicao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		btnCadastrar.setBounds(807, 752, 418, 36);
		contentPane.add(btnCadastrar);
		
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				br.com.patrimonio.pojo.Patrimonio pat = new br.com.patrimonio.pojo.Patrimonio();
				DAOPatrimonio daoP = new DAOPatrimonio();
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();			
				Cursos cur = (Cursos)cbxCurso.getSelectedItem();
				Categorias cat = (Categorias)cbxCategoria.getSelectedItem();
				Locais loc = (Locais)cbxLocal.getSelectedItem();
				
				
				String status_selecionado = cbxStatus.getSelectedItem().toString();
				Object st_select = "";
				if(status_selecionado == "Em_Manutenção") {
					st_select = "Em Manutenção";
				}
				else if(status_selecionado == "BaixadoInativo") {
					st_select = "Baixado/Inativo";
				}
				else {
					st_select = cbxStatus.getSelectedItem();
				}
				
				pat.setNumero_tombamento(txtNumeroTombamento.getText());
				pat.setNome(txtNomePatrimonio.getText());
				pat.setDescricao(txtDescricao.getText());
				pat.setCriado_por(u.getId());
				pat.setCurso_id(cur.getId());
				pat.setCategoria_id(cat.getId());
				pat.setLocais_id(loc.getId());
				pat.setStatus( (Status) (st_select));
				pat.setValor_aquisicao(Double.valueOf(txtValorAquisicao.getText()));
				pat.setData_aquisicao(Date.valueOf(txtDataAquisicao.getText()));
				
				String m = daoP.cadastrar(pat);
				JOptionPane.showMessageDialog(null, m);
				
				
			}
		});		
		

	}
}


