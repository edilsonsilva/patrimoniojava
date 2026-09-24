package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.patrimonio.dao.DAOCurso;
import javax.swing.JLabel;
import java.awt.Font;
import java.lang.classfile.instruction.BranchInstruction;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField txtIdCurso;
	private JSeparator separator;
	private JTable tableCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCursos frame = new ListarCursos();
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
	public ListarCursos() {
		setTitle("Listar Cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 946, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Listar Cursos");
		lblNewLabel.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 0, 910, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o código do curso:");
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 80, 235, 30);
		contentPane.add(lblNewLabel_1);
		
		txtIdCurso = new JTextField();
		txtIdCurso.setBounds(222, 80, 425, 30);
		contentPane.add(txtIdCurso);
		txtIdCurso.setColumns(10);
		
		JButton btnRealizarBusca = new JButton("Realizar a busca");
		btnRealizarBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cx = txtIdCurso.getText();
				
				if(cx.equals("") || cx==null) {
					carregarCursos(0);
				}
				else {
					carregarCursos(Integer.parseInt(cx));
				}
				
			}
		});
		btnRealizarBusca.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		btnRealizarBusca.setBounds(652, 80, 268, 30);
		contentPane.add(btnRealizarBusca);
		
		separator = new JSeparator();
		separator.setBounds(20, 57, 900, 2);
		contentPane.add(separator);
		
		carregarCursos(0);
		
		
	}
	
	public void carregarCursos(Integer id) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 910, 366);
		contentPane.add(scrollPane);
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id","Nome do Curso","Sigla do Curso","Criado Por","Criado Em"};
		
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dados na nossa JTable. O Modelo de dados organiza as informações que 
		//serão apresentadas
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		//Instância da classe DAOCurso
		DAOCurso dc = new DAOCurso();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		
		List<br.com.patrimonio.pojo.Cursos> lc;
		br.com.patrimonio.pojo.Cursos cs;
		
		if( id == 0 ) {
			lc = dc.listar();
			for(br.com.patrimonio.pojo.Cursos cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getSigla(),
						cr.getCriado_por(),
						cr.getCriado_em()
				};
				model.addRow(dados);
			}
		}
		else {
			cs = dc.listarID(id);
			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getSigla(),
					cs.getCriado_por(),
					cs.getCriado_em()
			};
			model.addRow(dados);
		}
		
		
		
		
		//adicionar o modelo de dados com colunas a JTable
		tableCurso = new JTable(model);
		scrollPane.setViewportView(tableCurso);
	}
}




