package pacote;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;

public class CarregaImagem extends JFrame {

	private JPanel contentPane;
	private static CarregaImagem frame;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmSelecionaArquivo;
	private JMenuItem mntmFecharJanela;
	private JLabel lblImagem;

	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CarregaImagem();
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
	
	
	public CarregaImagem() {
		setTitle("Visualizador de Imagens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBarra = new JMenuBar();
		menuBarra.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		//opçoes do menu
		mnArquivo = new JMenu("Arquivo");
		menuBarra.add(mnArquivo);
		mntmSelecionaArquivo = new JMenuItem("Seleciona Arquivo");
		mntmSelecionaArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						imagem();
				}
			});
		mnArquivo.add(mntmSelecionaArquivo);
		mntmFecharJanela = new JMenuItem("Fechar Janela");
		mntmFecharJanela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		mnArquivo.add(mntmFecharJanela);
		
		lblImagem = new JLabel(""); //label vazio para setar a imagem dentro
		lblImagem.setBounds(0, 22, 434, 239);
		contentPane.add(lblImagem); //a imagem vai aparecer dentro do contentPane
	}
<<<<<<< Updated upstream
	
	
	//função para leitura da imagem
		public void imagem() {
			JFileChooser jf = new JFileChooser(); //abre a janela de seleção de imagens
			jf.showOpenDialog(frame);
				
				try {
					//deixando o tamanho da imagem do tamanho do label
					//utilizando o ImageIO paraleitura da imagem colorida 
					lblImagem.setIcon(new ImageIcon(ImageIO.read(jf.getSelectedFile()).getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), BufferedImage.TYPE_INT_RGB)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}		
=======

	public void carregaImagem() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.showOpenDialog(frame);
		//função para leitura da imagem colorida		
		try {
			imagemCarregada.setIcon(new ImageIcon(ImageIO.read(jFileChooser.getSelectedFile()).getScaledInstance(
					imagemCarregada.getWidth(), imagemCarregada.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e1) {
			e1.printStackTrace();
			}		
>>>>>>> Stashed changes
		}
		
		//função para sai da aplicação
		public void close() {
			System.exit(0); //fechar jfilechooser e encerrar o programa
		}
	
}