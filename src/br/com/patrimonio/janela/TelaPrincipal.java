package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Sistema Gestão de Patrimônio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Obter a resolução da tela
		 Dimension tamanho = getSize();		 		
		
		setBounds(100, 100, 1920, 300);
		
		//Abrir a tela sempre maximizada
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setMnemonic('c');
		menuBar.add(mnCadastrar);
		
		JMenuItem itemUsuario = new JMenuItem("Usuário");
		itemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Usuarios formUsuario = new Usuarios();
				formUsuario.setVisible(true);
				
				
			}
		});
		itemUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnCadastrar.add(itemUsuario);
		
		JMenuItem itemCursos = new JMenuItem("Cursos");
		itemCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
				
			}
		});
		itemCursos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnCadastrar.add(itemCursos);
		
		JMenuItem itemLocais = new JMenuItem("Locais");
		itemLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locais formLocais = new Locais();
				formLocais.setVisible(true);
			}
		});
		mnCadastrar.add(itemLocais);
		
		JMenuItem itemCategorias = new JMenuItem("Categorias");
		itemCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Categorias formCategorias = new Categorias();
				formCategorias.setVisible(true);
				
			}
		});
		mnCadastrar.add(itemCategorias);
		
		JMenuItem itemPatrimonio = new JMenuItem("Patrimônio");
		itemPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patrimonio formPatrimonio = new Patrimonio();
				formPatrimonio.setVisible(true);
				
				
			}
		});
		mnCadastrar.add(itemPatrimonio);
		
		JMenuItem itemMovimentacao = new JMenuItem("Movimentação");
		itemMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Movimentacoes formMov = new Movimentacoes();
				formMov.setVisible(true);
				
			}
		});
		mnCadastrar.add(itemMovimentacao);
		
		JMenuItem itemBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
		itemBaixarPatrimonio.setForeground(Color.WHITE);
		itemBaixarPatrimonio.setBackground(Color.RED);
		mnCadastrar.add(itemBaixarPatrimonio);
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setMnemonic('s');
		menuBar.add(mnConsulta);
		
		JMenu itemListarTudo = new JMenu("Listar tudo");
		mnConsulta.add(itemListarTudo);
		
		JMenuItem itemLstUsuario = new JMenuItem("Usuário");
		itemListarTudo.add(itemLstUsuario);
		
		JMenuItem itemLstCursos = new JMenuItem("Cursos");
		itemLstCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ListarCursos().setVisible(true);
				
			}
		});
		itemListarTudo.add(itemLstCursos);
		
		JMenuItem itemLstPatrimonio = new JMenuItem("Patrimônio");
		itemListarTudo.add(itemLstPatrimonio);
		
		JMenu itemPesquisarPorId = new JMenu("Pesquisar Por Id");
		mnConsulta.add(itemPesquisarPorId);
		
		JMenuItem itemPorIdMovimentacao = new JMenuItem("Movimentação");
		itemPesquisarPorId.add(itemPorIdMovimentacao);
		
		JMenuItem itemPorIdBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
		itemPesquisarPorId.add(itemPorIdBaixarPatrimonio);
		
		JSeparator separator = new JSeparator();
		mnConsulta.add(separator);
		
		JMenu itemConsultaUsuario = new JMenu("Usuário Por ...   ");
		mnConsulta.add(itemConsultaUsuario);
		
		JMenuItem itemConsultaPerfil = new JMenuItem("Perfil");
		itemConsultaUsuario.add(itemConsultaPerfil);
		
		JMenuItem itemConsultaEmail = new JMenuItem("E-Mail");
		itemConsultaUsuario.add(itemConsultaEmail);
		
		JSeparator separator_1 = new JSeparator();
		mnConsulta.add(separator_1);
		
		JMenu itemConsultaMovimentacao = new JMenu("Movimentação");
		mnConsulta.add(itemConsultaMovimentacao);
		
		JMenuItem itemConsultaTipo = new JMenuItem("Tipo");
		itemConsultaMovimentacao.add(itemConsultaTipo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//getWidth()->Pegar a largura da janela
		//getHeight()->Pegar a altura da janela
		contentPane.setBounds(0,0,1920,1000);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, getWidth(), 25);
		contentPane.add(toolBar);
		
		JButton btnAbrirUsuario = new JButton("");
		btnAbrirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuarios formUsuario = new Usuarios();
				formUsuario.setVisible(true);
			}
		});
		btnAbrirUsuario.setToolTipText("Abrir formulário de usuário");
		btnAbrirUsuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/b_usradd.png")));
		toolBar.add(btnAbrirUsuario);
		
		JButton btnAbrirCursos = new JButton("");
		btnAbrirCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
				
			}
		});
		btnAbrirCursos.setToolTipText("Abrir formulário de Cursos");
		btnAbrirCursos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/b_bookmark.png")));
		toolBar.add(btnAbrirCursos);
		
		JButton btnAbrirLocais = new JButton("");
		btnAbrirLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Locais frmLocais = new Locais();
				frmLocais.setVisible(true);
				
			}
		});
		btnAbrirLocais.setToolTipText("Abrir formulário de Locais");
		btnAbrirLocais.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/object_address.png")));
		toolBar.add(btnAbrirLocais);
		
		JButton btnAbrirCategoria = new JButton("");
		btnAbrirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorias formCategoria = new Categorias();
				formCategoria.setVisible(true);
			}
		});
		btnAbrirCategoria.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/icons8-adicionar-propriedade-24.png")));
		toolBar.add(btnAbrirCategoria);


	}
}
