package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import basico.Estoque;
import basico.Produto;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class MudaPreco {

	BufferedReader leitor;
	
	JPanel[] panelBebida = new JPanel[9];
	JPanel[] panelSnack = new JPanel[18];
	JPanel[] panelOutro = new JPanel[9];
	
	JLabel[] labelBebida = new JLabel[9];
	JLabel[] labelSnack = new JLabel[18];
	JLabel[] labelOutro = new JLabel[9];
	
	JTextField[] textFieldBebida = new JTextField[9];
	JTextField[] textFieldSnack = new JTextField[18];
	JTextField[] textFieldOutro = new JTextField[9];
	
	private JFrame frame;
	private JPanel mudaPreco;

	/**
	 * Launch the application.
	 */
	public void mudarPreco(Estoque estoque) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudaPreco window = new MudaPreco(estoque);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MudaPreco(Estoque estoque) {
		initialize(estoque);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Estoque estoque) {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 490);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (frame.getWidth()/2);
		int yPos = (dim.height/2) - (frame.getHeight()/2);
		frame.setLocation(xPos, yPos);
		
		
		mudaPreco = new JPanel();
		mudaPreco.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(mudaPreco);
		mudaPreco.setLayout(null);
		
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBounds(6, 6, 175, 456);
		mudaPreco.add(panelBebidas);
		panelBebidas.setLayout(null);
		
		if(estoque.quantBebidas >= 1){
			panelBebida[0] = new JPanel();
			panelBebida[0].setBounds(0, 0, 175, 40);
			panelBebida[0].setLayout(null);
			panelBebida[0].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[0]);
			
			labelBebida[0] = new JLabel(estoque.bebidas[0].getNome());
			labelBebida[0].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[0].setBounds(6, 6, 120, 26);
			panelBebida[0].add(labelBebida[0]);
			
			textFieldBebida[0] = new JTextField(estoque.bebidas[0].getPreco() + "");
			textFieldBebida[0].setBounds(128, 7, 40, 26);
			panelBebida[0].add(textFieldBebida[0]);
		}
		
		if(estoque.quantBebidas >= 2){
			panelBebida[1] = new JPanel();
			panelBebida[1].setBounds(0, 50, 175, 40);
			panelBebida[1].setLayout(null);
			panelBebida[1].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[1]);
			
			labelBebida[1] = new JLabel(estoque.bebidas[1].getNome());
			labelBebida[1].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[1].setBounds(6, 6, 120, 26);
			panelBebida[1].add(labelBebida[1]);
			
			textFieldBebida[1] = new JTextField(estoque.bebidas[1].getPreco() + "");
			textFieldBebida[1].setBounds(128, 7, 40, 26);
			panelBebida[1].add(textFieldBebida[1]);
		}
		
		if(estoque.quantBebidas >= 3){
			panelBebida[2] = new JPanel();
			panelBebida[2].setBounds(0, 100, 175, 40);
			panelBebida[2].setLayout(null);
			panelBebida[2].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[2]);
			
			labelBebida[2] = new JLabel(estoque.bebidas[2].getNome());
			labelBebida[2].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[2].setBounds(6, 6, 120, 26);
			panelBebida[2].add(labelBebida[2]);
			
			textFieldBebida[2] = new JTextField(estoque.bebidas[2].getPreco() + "");
			textFieldBebida[2].setBounds(128, 7, 40, 26);
			panelBebida[2].add(textFieldBebida[2]);
		}
		
		if(estoque.quantBebidas >= 4){
			panelBebida[3] = new JPanel();
			panelBebida[3].setBounds(0, 150, 175, 40);
			panelBebida[3].setLayout(null);
			panelBebida[3].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[3]);
			
			labelBebida[3] = new JLabel(estoque.bebidas[3].getNome());
			labelBebida[3].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[3].setBounds(6, 6, 120, 26);
			panelBebida[3].add(labelBebida[3]);
			
			textFieldBebida[3] = new JTextField(estoque.bebidas[3].getPreco() + "");
			textFieldBebida[3].setBounds(128, 7, 40, 26);
			panelBebida[3].add(textFieldBebida[3]);
		}
		
		if(estoque.quantBebidas >= 5){
			panelBebida[4] = new JPanel();
			panelBebida[4].setBounds(0, 200, 175, 40);
			panelBebida[4].setLayout(null);
			panelBebida[4].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[4]);
			
			labelBebida[4] = new JLabel(estoque.bebidas[4].getNome());
			labelBebida[4].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[4].setBounds(6, 6, 120, 26);
			panelBebida[4].add(labelBebida[4]);
			
			textFieldBebida[4] = new JTextField(estoque.bebidas[4].getPreco() + "");
			textFieldBebida[4].setBounds(128, 7, 40, 26);
			panelBebida[4].add(textFieldBebida[4]);
		}
		
		if(estoque.quantBebidas >= 6){
			panelBebida[5] = new JPanel();
			panelBebida[5].setBounds(0, 250, 175, 40);
			panelBebida[5].setLayout(null);
			panelBebida[5].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[5]);
			
			labelBebida[5] = new JLabel(estoque.bebidas[5].getNome());
			labelBebida[5].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[5].setBounds(6, 6, 120, 26);
			panelBebida[5].add(labelBebida[5]);
			
			textFieldBebida[5] = new JTextField(estoque.bebidas[5].getPreco() + "");
			textFieldBebida[5].setBounds(128, 7, 40, 26);
			panelBebida[5].add(textFieldBebida[5]);
		}
		
		if(estoque.quantBebidas >= 7){
			panelBebida[6] = new JPanel();
			panelBebida[6].setBounds(0, 300, 175, 40);
			panelBebida[6].setLayout(null);
			panelBebida[6].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[6]);
			
			labelBebida[6] = new JLabel(estoque.bebidas[6].getNome());
			labelBebida[6].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[6].setBounds(6, 6, 120, 26);
			panelBebida[6].add(labelBebida[6]);
			
			textFieldBebida[6] = new JTextField(estoque.bebidas[6].getPreco() + "");
			textFieldBebida[6].setBounds(128, 7, 40, 26);
			panelBebida[6].add(textFieldBebida[6]);
		}
		
		if(estoque.quantBebidas >= 8){
			panelBebida[7] = new JPanel();
			panelBebida[7].setBounds(0, 350, 175, 40);
			panelBebida[7].setLayout(null);
			panelBebida[7].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[7]);
			
			labelBebida[7] = new JLabel(estoque.bebidas[7].getNome());
			labelBebida[7].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[7].setBounds(6, 6, 120, 26);
			panelBebida[7].add(labelBebida[7]);
			
			textFieldBebida[7] = new JTextField(estoque.bebidas[7].getPreco() + "");
			textFieldBebida[7].setBounds(128, 7, 40, 26);
			panelBebida[7].add(textFieldBebida[7]);
		}
		
		if(estoque.quantBebidas >= 9){
			panelBebida[8] = new JPanel();
			panelBebida[8].setBounds(0, 400, 175, 40);
			panelBebida[8].setLayout(null);
			panelBebida[8].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[8]);
			
			labelBebida[8] = new JLabel(estoque.bebidas[8].getNome());
			labelBebida[8].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[8].setBounds(6, 6, 120, 26);
			panelBebida[8].add(labelBebida[8]);
			
			textFieldBebida[8] = new JTextField(estoque.bebidas[8].getPreco() + "");
			textFieldBebida[8].setBounds(128, 7, 40, 26);
			panelBebida[8].add(textFieldBebida[8]);
		}
		
		
		
		JPanel panelSnacks = new JPanel();
		panelSnacks.setBounds(190, 6, 175, 456);
		panelSnacks.setLayout(null);
		mudaPreco.add(panelSnacks);
		
		if(estoque.quantSnacks >= 1){
			panelSnack[0] = new JPanel();
			panelSnack[0].setBounds(0, 0, 175, 40);
			panelSnack[0].setLayout(null);
			panelSnack[0].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[0]);
			
			labelSnack[0] = new JLabel(estoque.snacks[0].getNome());
			labelSnack[0].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[0].setBounds(6, 6, 120, 26);
			panelSnack[0].add(labelSnack[0]);
			
			textFieldSnack[0] = new JTextField(estoque.snacks[0].getPreco() + "");
			textFieldSnack[0].setBounds(128, 7, 40, 26);
			panelSnack[0].add(textFieldSnack[0]);
		}
		
		if(estoque.quantSnacks >= 2){
			panelSnack[1] = new JPanel();
			panelSnack[1].setBounds(0, 50, 175, 40);
			panelSnack[1].setLayout(null);
			panelSnack[1].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[1]);
			
			labelSnack[1] = new JLabel(estoque.snacks[1].getNome());
			labelSnack[1].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[1].setBounds(6, 6, 120, 26);
			panelSnack[1].add(labelSnack[1]);
			
			textFieldSnack[1] = new JTextField(estoque.snacks[1].getPreco() + "");
			textFieldSnack[1].setBounds(128, 7, 40, 26);
			panelSnack[1].add(textFieldSnack[1]);
		}
		if(estoque.quantSnacks >= 3){
			panelSnack[2] = new JPanel();
			panelSnack[2].setBounds(0, 100, 175, 40);
			panelSnack[2].setLayout(null);
			panelSnack[2].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[2]);
			
			labelSnack[2] = new JLabel(estoque.snacks[2].getNome());
			labelSnack[2].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[2].setBounds(6, 6, 120, 26);
			panelSnack[2].add(labelSnack[2]);
			
			textFieldSnack[2] = new JTextField(estoque.snacks[2].getPreco() + "");
			textFieldSnack[2].setBounds(128, 7, 40, 26);
			panelSnack[2].add(textFieldSnack[2]);
		}
		if(estoque.quantSnacks >= 4){
			panelSnack[3] = new JPanel();
			panelSnack[3].setBounds(0, 150, 175, 40);
			panelSnack[3].setLayout(null);
			panelSnack[3].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[3]);
			
			labelSnack[3] = new JLabel(estoque.snacks[3].getNome());
			labelSnack[3].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[3].setBounds(6, 6, 120, 26);
			panelSnack[3].add(labelSnack[3]);
			
			textFieldSnack[3] = new JTextField(estoque.snacks[3].getPreco() + "");
			textFieldSnack[3].setBounds(128, 7, 40, 26);
			panelSnack[3].add(textFieldSnack[3]);
		}
		if(estoque.quantSnacks >= 5){
			panelSnack[4] = new JPanel();
			panelSnack[4].setBounds(0, 200, 175, 40);
			panelSnack[4].setLayout(null);
			panelSnack[4].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[4]);
			
			labelSnack[4] = new JLabel(estoque.snacks[4].getNome());
			labelSnack[4].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[4].setBounds(6, 6, 120, 26);
			panelSnack[4].add(labelSnack[4]);
			
			textFieldSnack[4] = new JTextField(estoque.snacks[4].getPreco() + "");
			textFieldSnack[4].setBounds(128, 7, 40, 26);
			panelSnack[4].add(textFieldSnack[4]);
		}
		if(estoque.quantSnacks >= 6){
			panelSnack[5] = new JPanel();
			panelSnack[5].setBounds(0, 250, 175, 40);
			panelSnack[5].setLayout(null);
			panelSnack[5].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[5]);
			
			labelSnack[5] = new JLabel(estoque.snacks[5].getNome());
			labelSnack[5].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[5].setBounds(6, 6, 120, 26);
			panelSnack[5].add(labelSnack[5]);
			
			textFieldSnack[5] = new JTextField(estoque.snacks[5].getPreco() + "");
			textFieldSnack[5].setBounds(128, 7, 40, 26);
			panelSnack[5].add(textFieldSnack[5]);
		}
		if(estoque.quantSnacks >= 7){
			panelSnack[6] = new JPanel();
			panelSnack[6].setBounds(0, 300, 175, 40);
			panelSnack[6].setLayout(null);
			panelSnack[6].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[6]);
			
			labelSnack[6] = new JLabel(estoque.snacks[6].getNome());
			labelSnack[6].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[6].setBounds(6, 6, 120, 26);
			panelSnack[6].add(labelSnack[6]);
			
			textFieldSnack[6] = new JTextField(estoque.snacks[6].getPreco() + "");
			textFieldSnack[6].setBounds(128, 7, 40, 26);
			panelSnack[6].add(textFieldSnack[6]);
		}
		if(estoque.quantSnacks >= 8){
			panelSnack[7] = new JPanel();
			panelSnack[7].setBounds(0, 350, 175, 40);
			panelSnack[7].setLayout(null);
			panelSnack[7].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[7]);
			
			labelSnack[7] = new JLabel(estoque.snacks[7].getNome());
			labelSnack[7].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[7].setBounds(6, 6, 120, 26);
			panelSnack[7].add(labelSnack[7]);
			
			textFieldSnack[7] = new JTextField(estoque.snacks[7].getPreco() + "");
			textFieldSnack[7].setBounds(128, 7, 40, 26);
			panelSnack[7].add(textFieldSnack[7]);
		}
		if(estoque.quantSnacks >= 9){
			panelSnack[8] = new JPanel();
			panelSnack[8].setBounds(0, 400, 175, 40);
			panelSnack[8].setLayout(null);
			panelSnack[8].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[8]);
			
			labelSnack[8] = new JLabel(estoque.snacks[8].getNome());
			labelSnack[8].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[8].setBounds(6, 6, 120, 26);
			panelSnack[8].add(labelSnack[8]);
			
			textFieldSnack[8] = new JTextField(estoque.snacks[8].getPreco() + "");
			textFieldSnack[8].setBounds(128, 7, 40, 26);
			panelSnack[8].add(textFieldSnack[8]);
		}
		
		
		
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setBounds(374, 6, 175, 456);
		panel2Snacks.setLayout(null);
		mudaPreco.add(panel2Snacks);
		
		if(estoque.quantSnacks >= 10){
			panelSnack[9] = new JPanel();
			panelSnack[9].setBounds(0, 0, 175, 40);
			panelSnack[9].setLayout(null);
			panelSnack[9].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[9]);
			
			labelSnack[9] = new JLabel(estoque.snacks[9].getNome());
			labelSnack[9].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[9].setBounds(6, 6, 120, 26);
			panelSnack[9].add(labelSnack[9]);
			
			textFieldSnack[9] = new JTextField(estoque.snacks[9].getPreco() + "");
			textFieldSnack[9].setBounds(128, 7, 40, 26);
			panelSnack[9].add(textFieldSnack[9]);
		}
		if(estoque.quantSnacks >= 11){
			panelSnack[10] = new JPanel();
			panelSnack[10].setBounds(0, 50, 175, 40);
			panelSnack[10].setLayout(null);
			panelSnack[10].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[10]);
			
			labelSnack[10] = new JLabel(estoque.snacks[10].getNome());
			labelSnack[10].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[10].setBounds(6, 6, 120, 26);
			panelSnack[10].add(labelSnack[10]);
			
			textFieldSnack[10] = new JTextField(estoque.snacks[10].getPreco() + "");
			textFieldSnack[10].setBounds(128, 7, 40, 26);
			panelSnack[10].add(textFieldSnack[10]);
		}
		
		if(estoque.quantSnacks >= 12){
			panelSnack[11] = new JPanel();
			panelSnack[11].setBounds(0, 100, 175, 40);
			panelSnack[11].setLayout(null);
			panelSnack[11].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[11]);
			
			labelSnack[11] = new JLabel(estoque.snacks[11].getNome());
			labelSnack[11].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[11].setBounds(6, 6, 120, 26);
			panelSnack[11].add(labelSnack[11]);
			
			textFieldSnack[11] = new JTextField(estoque.snacks[11].getPreco() + "");
			textFieldSnack[11].setBounds(128, 7, 40, 26);
			panelSnack[11].add(textFieldSnack[11]);
		}
		if(estoque.quantSnacks >= 13){
			panelSnack[12] = new JPanel();
			panelSnack[12].setBounds(0, 150, 175, 40);
			panelSnack[12].setLayout(null);
			panelSnack[12].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[12]);
			
			labelSnack[12] = new JLabel(estoque.snacks[12].getNome());
			labelSnack[12].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[12].setBounds(6, 6, 120, 26);
			panelSnack[12].add(labelSnack[12]);
			
			textFieldSnack[12] = new JTextField(estoque.snacks[12].getPreco() + "");
			textFieldSnack[12].setBounds(128, 7, 40, 26);
			panelSnack[12].add(textFieldSnack[12]);
		}
		if(estoque.quantSnacks >= 14){
			panelSnack[13] = new JPanel();
			panelSnack[13].setBounds(0, 200, 175, 40);
			panelSnack[13].setLayout(null);
			panelSnack[13].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[13]);
			
			labelSnack[13] = new JLabel(estoque.snacks[13].getNome());
			labelSnack[13].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[13].setBounds(6, 6, 120, 26);
			panelSnack[13].add(labelSnack[13]);
			
			textFieldSnack[13] = new JTextField(estoque.snacks[13].getPreco() + "");
			textFieldSnack[13].setBounds(128, 7, 40, 26);
			panelSnack[13].add(textFieldSnack[13]);
		}
		if(estoque.quantSnacks >= 15){
			panelSnack[14] = new JPanel();
			panelSnack[14].setBounds(0, 250, 175, 40);
			panelSnack[14].setLayout(null);
			panelSnack[14].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[14]);
			
			labelSnack[14] = new JLabel(estoque.snacks[14].getNome());
			labelSnack[14].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[14].setBounds(6, 6, 120, 26);
			panelSnack[14].add(labelSnack[14]);
			
			textFieldSnack[14] = new JTextField(estoque.snacks[14].getPreco() + "");
			textFieldSnack[14].setBounds(128, 7, 40, 26);
			panelSnack[14].add(textFieldSnack[14]);
		}
		if(estoque.quantSnacks >= 16){
			panelSnack[15] = new JPanel();
			panelSnack[15].setBounds(0, 300, 175, 40);
			panelSnack[15].setLayout(null);
			panelSnack[15].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[15]);
			
			labelSnack[15] = new JLabel(estoque.snacks[15].getNome());
			labelSnack[15].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[15].setBounds(6, 6, 120, 26);
			panelSnack[15].add(labelSnack[15]);
			
			textFieldSnack[15] = new JTextField(estoque.snacks[15].getPreco() + "");
			textFieldSnack[15].setBounds(128, 7, 40, 26);
			panelSnack[15].add(textFieldSnack[15]);
		}
		if(estoque.quantSnacks >= 17){
			panelSnack[16] = new JPanel();
			panelSnack[16].setBounds(0, 350, 175, 40);
			panelSnack[16].setLayout(null);
			panelSnack[16].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[16]);
			
			labelSnack[16] = new JLabel(estoque.snacks[16].getNome());
			labelSnack[16].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[16].setBounds(6, 6, 120, 26);
			panelSnack[16].add(labelSnack[16]);
			
			textFieldSnack[16] = new JTextField(estoque.snacks[16].getPreco() + "");
			textFieldSnack[16].setBounds(128, 7, 40, 26);
			panelSnack[16].add(textFieldSnack[16]);
		}
		if(estoque.quantSnacks >= 18){
			panelSnack[17] = new JPanel();
			panelSnack[17].setBounds(0, 400, 175, 40);
			panelSnack[17].setLayout(null);
			panelSnack[17].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel2Snacks.add(panelSnack[17]);
			
			labelSnack[17] = new JLabel(estoque.snacks[17].getNome());
			labelSnack[17].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[17].setBounds(6, 6, 120, 26);
			panelSnack[17].add(labelSnack[17]);
			
			textFieldSnack[17] = new JTextField(estoque.snacks[17].getPreco() + "");
			textFieldSnack[17].setBounds(128, 7, 40, 26);
			panelSnack[17].add(textFieldSnack[17]);
		}
		
		
		
		JPanel panelOutros = new JPanel();
		panelOutros.setBounds(564, 6, 175, 456);
		panelOutros.setLayout(null);
		mudaPreco.add(panelOutros);
		
		if(estoque.quantOutros >= 1){
			panelOutro[0] = new JPanel();
			panelOutro[0].setBounds(0, 0, 175, 40);
			panelOutro[0].setLayout(null);
			panelOutro[0].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[0]);
			
			labelOutro[0] = new JLabel(estoque.outros[0].getNome());
			labelOutro[0].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[0].setBounds(6, 6, 120, 26);
			panelOutro[0].add(labelOutro[0]);
			
			textFieldOutro[0] = new JTextField(estoque.outros[0].getPreco() + "");
			textFieldOutro[0].setBounds(128, 7, 40, 26);
			panelOutro[0].add(textFieldOutro[0]);
		}
		if(estoque.quantOutros >= 2){
			panelOutro[1] = new JPanel();
			panelOutro[1].setBounds(0, 50, 175, 40);
			panelOutro[1].setLayout(null);
			panelOutro[1].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[1]);
			
			labelOutro[1] = new JLabel(estoque.outros[1].getNome());
			labelOutro[1].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[1].setBounds(6, 6, 120, 26);
			panelOutro[1].add(labelOutro[1]);
			
			textFieldOutro[1] = new JTextField(estoque.outros[1].getPreco() + "");
			textFieldOutro[1].setBounds(128, 7, 40, 26);
			panelOutro[1].add(textFieldOutro[1]);
		}
		if(estoque.quantOutros >= 3){
			panelOutro[2] = new JPanel();
			panelOutro[2].setBounds(0, 100, 175, 40);
			panelOutro[2].setLayout(null);
			panelOutro[2].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[2]);
			
			labelOutro[2] = new JLabel(estoque.outros[2].getNome());
			labelOutro[2].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[2].setBounds(6, 6, 120, 26);
			panelOutro[2].add(labelOutro[2]);
			
			textFieldOutro[2] = new JTextField(estoque.outros[2].getPreco() + "");
			textFieldOutro[2].setBounds(128, 7, 40, 26);
			panelOutro[2].add(textFieldOutro[2]);
		}
		if(estoque.quantOutros >= 4){
			panelOutro[3] = new JPanel();
			panelOutro[3].setBounds(0, 150, 175, 40);
			panelOutro[3].setLayout(null);
			panelOutro[3].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[3]);
			
			labelOutro[3] = new JLabel(estoque.outros[3].getNome());
			labelOutro[3].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[3].setBounds(6, 6, 120, 26);
			panelOutro[3].add(labelOutro[3]);
			
			textFieldOutro[3] = new JTextField(estoque.outros[3].getPreco() + "");
			textFieldOutro[3].setBounds(128, 7, 40, 26);
			panelOutro[3].add(textFieldOutro[3]);
		}
		if(estoque.quantOutros >= 5){
			panelOutro[4] = new JPanel();
			panelOutro[4].setBounds(0, 200, 175, 40);
			panelOutro[4].setLayout(null);
			panelOutro[4].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[4]);
			
			labelOutro[4] = new JLabel(estoque.outros[4].getNome());
			labelOutro[4].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[4].setBounds(6, 6, 120, 26);
			panelOutro[4].add(labelOutro[4]);
			
			textFieldOutro[4] = new JTextField(estoque.outros[4].getPreco() + "");
			textFieldOutro[4].setBounds(128, 7, 40, 26);
			panelOutro[4].add(textFieldOutro[4]);
		}
		if(estoque.quantOutros >= 6){
			panelOutro[5] = new JPanel();
			panelOutro[5].setBounds(0, 250, 175, 40);
			panelOutro[5].setLayout(null);
			panelOutro[5].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[5]);
			
			labelOutro[5] = new JLabel(estoque.outros[5].getNome());
			labelOutro[5].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[5].setBounds(6, 6, 120, 26);
			panelOutro[5].add(labelOutro[5]);
			
			textFieldOutro[5] = new JTextField(estoque.outros[5].getPreco() + "");
			textFieldOutro[5].setBounds(128, 7, 40, 26);
			panelOutro[5].add(textFieldOutro[5]);
		}
		if(estoque.quantOutros >= 7){
			panelOutro[6] = new JPanel();
			panelOutro[6].setBounds(0, 300, 175, 40);
			panelOutro[6].setLayout(null);
			panelOutro[6].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[6]);
			
			labelOutro[6] = new JLabel(estoque.outros[6].getNome());
			labelOutro[6].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[6].setBounds(6, 6, 120, 26);
			panelOutro[6].add(labelOutro[6]);
			
			textFieldOutro[6] = new JTextField(estoque.outros[6].getPreco() + "");
			textFieldOutro[6].setBounds(128, 7, 40, 26);
			panelOutro[6].add(textFieldOutro[6]);
		}
		if(estoque.quantOutros >= 8){
			panelOutro[7] = new JPanel();
			panelOutro[7].setBounds(0, 350, 175, 40);
			panelOutro[7].setLayout(null);
			panelOutro[7].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[7]);
			
			labelOutro[7] = new JLabel(estoque.outros[7].getNome());
			labelOutro[7].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[7].setBounds(6, 6, 120, 26);
			panelOutro[7].add(labelOutro[7]);
			
			textFieldOutro[7] = new JTextField(estoque.outros[7].getPreco() + "");
			textFieldOutro[7].setBounds(128, 7, 40, 26);
			panelOutro[7].add(textFieldOutro[7]);
		}
		if(estoque.quantOutros >= 9){
			panelOutro[8] = new JPanel();
			panelOutro[8].setBounds(0, 400, 175, 40);
			panelOutro[8].setLayout(null);
			panelOutro[8].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[8]);
			
			labelOutro[8] = new JLabel(estoque.outros[8].getNome());
			labelOutro[8].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[8].setBounds(6, 6, 120, 26);
			panelOutro[8].add(labelOutro[8]);
			
			textFieldOutro[8] = new JTextField(estoque.outros[8].getPreco() + "");
			textFieldOutro[8].setBounds(128, 7, 40, 26);
			panelOutro[8].add(textFieldOutro[8]);
		}
		
		JButton button = new JButton("OK");
		button.setBounds(751, 397, 116, 54);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listaTemp = new String();
				boolean foundError = false;
				try{
					File arquivoProdutos = new File("texto.txt");
					//File arquivoTemp = new File("textoTemp.txt");
					//File arquivoRel = new File("Relatorio.txt");
					
					leitor = new BufferedReader(new FileReader(arquivoProdutos));
					
					int percorre = 0;
					String informacaoProduto = leitor.readLine();
					String informacaoAtualizada;
					String preco;
					String quantidade;
					
					while(informacaoProduto != null){
						String[] produtoTemp = informacaoProduto.split(", ");
						
						if(produtoTemp[3].equals("bebida")){
							if(textFieldBebida[percorre].getText().equals("")){
								textFieldBebida[percorre].setText(estoque.bebidas[percorre].getPreco() + "");
							}
							try{
								double novoPreco = Double.parseDouble(textFieldBebida[percorre].getText());
								preco = String.valueOf(novoPreco);
								quantidade = String.valueOf(estoque.bebidas[percorre].getQuantidade());
								informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", bebida");
								listaTemp += (informacaoAtualizada + "\n");

								percorre++;
								if(percorre == estoque.quantBebidas-1){
									percorre = 0;
								}
							}
							catch(NumberFormatException exception){
								foundError = true;
								JPanel frameWarning = new JPanel();
								JOptionPane.showMessageDialog(frameWarning ,"Insira números em todas as lacunas"
										, "AVISO", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
						
						if(produtoTemp[3].equals("snack")){
							if(textFieldSnack[percorre].getText().equals("")){
								textFieldSnack[percorre].setText(estoque.snacks[percorre].getPreco() + "");
							}
							try{
								double novoPreco = Double.parseDouble(textFieldSnack[percorre].getText());
								preco = String.valueOf(novoPreco);
								quantidade = String.valueOf(estoque.snacks[percorre].getQuantidade());
								informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", snack");
								listaTemp += (informacaoAtualizada + "\n");
								percorre++;
								if(percorre == estoque.quantSnacks-1){
									percorre = 0;
								}
							}
							catch(NumberFormatException exception){
								foundError = true;
								JPanel frameWarning = new JPanel();
								JOptionPane.showMessageDialog(frameWarning ,"Insira inteiros em todas as lacunas"
										, "AVISO", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
						
						if(produtoTemp[3].equals("outro")){
							if(textFieldOutro[percorre].getText().equals("")){
								textFieldOutro[percorre].setText(estoque.outros[percorre].getPreco() + "");
							}
							try{
								double novoPreco = Double.parseDouble(textFieldOutro[percorre].getText());
								preco = String.valueOf(novoPreco);
								quantidade = String.valueOf(estoque.outros[percorre].getQuantidade());
								informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", outro");
								listaTemp += (informacaoAtualizada + "\n");
								percorre++;
								if(percorre == estoque.quantOutros-1){
									percorre = 0;
								}
							}
							catch(NumberFormatException exception){
								foundError = true;
								JPanel frameWarning = new JPanel();
								JOptionPane.showMessageDialog(frameWarning ,"Insira inteiros em todas as lacunas"
										, "AVISO", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
						informacaoProduto = leitor.readLine();
					}
					if(!foundError){
						try (Writer escritor = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream(arquivoProdutos)))) {
							escritor.write(listaTemp);
						}
					}
				}
				catch(FileNotFoundException e1){
					System.out.println("Couldn't Find File");
					System.exit(0);
				}
				catch(IOException e2){
					System.out.println("IO Error");
					System.exit(0);
				}
				estoque.atualizarValores();
				frame.dispose();
			}
		});
		mudaPreco.add(button);
		
		JTextPane textPaneAviso = new JTextPane();
		textPaneAviso.setEditable(false);
		textPaneAviso.setBackground(SystemColor.window);
		textPaneAviso.setText("Certifique-se de que todos os valores são inteiros com casa decimal dividida por ponto final.\n");
		textPaneAviso.setBounds(754, 6, 110, 128);
		mudaPreco.add(textPaneAviso);
	}
}
