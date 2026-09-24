package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaixasPatrimoniais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaixasPatrimoniais frame = new BaixasPatrimoniais();
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
	public BaixasPatrimoniais() {
		setTitle("Baixas Patrimoniais");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BaixasPatrimoniais.class.getResource("/br/com/patrimonio/imagens/baixa_patrimonial3.png")));
		lblNewLabel.setBounds(0, 0, 517, 513);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Baixa Patrimonial");
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 30));
		lblNewLabel_1.setBounds(524, 0, 723, 97);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(527, 71, 710, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione o Patrimônio:");
		lblNewLabel_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(537, 82, 257, 30);
		contentPane.add(lblNewLabel_2);
		
		JComboBox cbxPatrimonio = new JComboBox();
		cbxPatrimonio.setBounds(534, 110, 703, 30);
		contentPane.add(cbxPatrimonio);
		
		JLabel lblNewLabel_2_1 = new JLabel("Selecione o Usuário:");
		lblNewLabel_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(537, 152, 257, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JComboBox cbxPatrimonio_1 = new JComboBox();
		cbxPatrimonio_1.setBounds(534, 180, 349, 30);
		contentPane.add(cbxPatrimonio_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Selecione o Tipo de Baixa:");
		lblNewLabel_2_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(896, 151, 257, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JComboBox cbxPatrimonio_1_1 = new JComboBox();
		cbxPatrimonio_1_1.setBounds(893, 179, 344, 30);
		contentPane.add(cbxPatrimonio_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Escreva o Motivo:");
		lblNewLabel_2_1_2.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1_2.setBounds(537, 221, 257, 30);
		contentPane.add(lblNewLabel_2_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(534, 249, 700, 122);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Valor Recuperado:");
		lblNewLabel_2_1_2_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(537, 382, 257, 30);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		textField.setBounds(534, 412, 260, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Documento Comprobatório:");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 15));
		lblNewLabel_2_1_2_1_1.setBounds(807, 382, 257, 30);
		contentPane.add(lblNewLabel_2_1_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(804, 412, 433, 30);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Cadastrar a Baixa do Patrimônio");
		
		btnNewButton.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 15));
		btnNewButton.setBounds(804, 466, 433, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		

	}
}
