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
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CarregaImagem extends JFrame {
	private static CarregaImagem frame;
	private JLabel imagemCarregada;

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

	public CarregaImagem() {
		setTitle("Visualizador de Imagens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		imagemCarregada = new JLabel("");
		imagemCarregada.setBounds(0, 22, 434, 239);
		contentPane.add(imagemCarregada);
		
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 434, 22);
		contentPane.add(menu);
		
		JMenu arquivo = new JMenu("Arquivo");
		menu.add(arquivo);
		
		JMenuItem opcaoSelecionaArquivo = new JMenuItem("Seleciona Arquivo");
		opcaoSelecionaArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregaImagem();
			}
		});
		
		JMenuItem opcaoFecharJanela = new JMenuItem("Fechar Janela");
		opcaoFecharJanela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encerraAplicacao();
			}
		});
		
		arquivo.add(opcaoSelecionaArquivo);
		arquivo.add(opcaoFecharJanela);
	}

	public void carregaImagem() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.showOpenDialog(frame);
				
		try {
			imagemCarregada.setIcon(new ImageIcon(ImageIO.read(jFileChooser.getSelectedFile()).getScaledInstance(
					imagemCarregada.getWidth(), imagemCarregada.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e1) {
			e1.printStackTrace();
			}		
		}
		
	public void encerraAplicacao() {
		System.exit(0); 
	}
}