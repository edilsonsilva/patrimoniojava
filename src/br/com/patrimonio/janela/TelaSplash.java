package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaSplash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					JFrame frame = new JFrame();
					
		
			
					frame.setType(Type.UTILITY);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 888, 700);
					
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		frame.setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		frame.setLocationRelativeTo(null);//Isso fará a tela abrir no centro do monitor
		frame.setUndecorated(true);//Tira as bordas e titulo da janela
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/fundosplash.png")));
		lblNewLabel.setBounds(0, 0, 872, 455);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Squash - Gestão de Patrimônio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 35));
		lblNewLabel_1.setBounds(121, 454, 661, 90);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLegenda = new JLabel("...");
		lblLegenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblLegenda.setBounds(267, 561, 367, 29);
		contentPane.add(lblLegenda);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(62, 101, 193));
		progressBar.setValue(30);
		progressBar.setBounds(120, 601, 661, 20);
		contentPane.add(progressBar);
		
		
		//Setar o fundo da tela como transparente. O comando new Color
		//aplicar uma nova cor em três posições e a quarta é a opacidade,
		//onde opacidade é o nível de transparência. Portanto,
		//os valores 0.0f são aplicados nas posições RGB->
		//R -> Red (vermelho)
		//G -> Green(verde)
		//B -> Blue(azul)
		//com seus respectivos valores variando entre 0.0 até 255.0.
		//São valores com casas decimais, por este motivo estamos usando
		//os números como float(f), então poderiamos ter, por exemplo
		//as cores ( 10.56f , 45.80f , 14.0f )
		frame.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
				
		
		frame.setVisible(true);
		
		try {
			for(int i = 0 ; i <= 100; i++) {
				Thread.sleep(200);
				progressBar.setValue(i);
				
				if( i < 30) {
					lblLegenda.setText("Carregando ... ");
				}
				else if( i < 60) {
					lblLegenda.setText("Carregando os modulos ... ");
				}
				else if( i < 80) {
					lblLegenda.setText("Carregando as configurações .... ");
				}
				else if( i < 90) {
					lblLegenda.setText("Iinciando a interface ... ");
				}
				else {
					lblLegenda.setText("Tudo Pronto!");
				}

			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		frame.dispose();
		TelaPrincipal tp = new TelaPrincipal();
		tp.setVisible(true);
		
		
		
	}
}



