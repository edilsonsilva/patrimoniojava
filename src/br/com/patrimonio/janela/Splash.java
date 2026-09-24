package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;


public class Splash extends JFrame {

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
		frame.setBounds(100, 100, 535, 559);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/br/com/patrimonio/imagens/imgsplash1.png")));
		lblNewLabel.setBounds(0, 0, 686, 472);
		contentPane.add(lblNewLabel);
		
	
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 495, 499, 20);
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		contentPane.add(progressBar);
		
		frame.setVisible(true);
		
		try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100); // Pausa de 40ms para simular o carregamento (ajuste conforme necessário)
                progressBar.setValue(i);
                
                // Opcional: Mudar o texto dependendo do progresso
                //if (i == 30) titulo.setText("Carregando Banco de Dados...");
                //if (i == 70) titulo.setText("Iniciando Módulos...");
                //if (i == 90) titulo.setText("Quase lá...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Fecha a tela de Splash e inicia a aplicação principal
        frame.dispose();
        TelaPrincipal tp = new TelaPrincipal();
        tp.setVisible(true);

	}
}
