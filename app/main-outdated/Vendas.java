package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import basico.Estoque;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vendas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Estoque estoque = new Estoque();

	int[] clicaBebida = new int[9];	
	int[] clicaSnack = new int[18];
	int[] clicaOutro = new int[9];
	
	private String pedidoCompleto = new String();
	
	JTextArea[] textAreaBebida = new JTextArea[9];
	JTextArea[] textAreaSnack = new JTextArea[18];
	JTextArea[] textAreaOutro = new JTextArea[9];
	JTextArea textAreaPedidos;

	
	private JPanel contentPane;
	//private JDialog verificaVenda;
	//private JDialog verificaEstoque;
	
	double precoTotal = 0;
	int limpaTela = 0;
	String pluralidade;

	static String filePath;
	static File randomFile;
	private Reestoque reestoque;
	private MudaPreco mudaPreco;
	private AdicionaProduto adicionaProduto;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		Date time = new Date();
//		SimpleDateFormat formated = 
//				new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.E");
//		randomFile = new File("Produtos."+ formated.format(time) + ".txt");
//		try{
//			randomFile.createNewFile();
//			filePath = randomFile.getCanonicalPath();
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
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
	public Vendas() {
		setTitle("Interface Vendas CAEC - versão (0.2.8.0)");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1250, 730);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		for(int i = 0; i < 9; i++){
			clicaBebida[i] = 0;
			clicaSnack[i] = 0;
			clicaSnack[2*i] = 0;
			clicaOutro[i] = 0;
		}
		
		
		
		///// 			PAINEL BEBIDAS			//////
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBackground(SystemColor.window);
		panelBebidas.setLayout(null);
		panelBebidas.setBorder(new LineBorder(Color.BLACK));
		panelBebidas.setBounds(6, 6, 250, 690);
		contentPane.add(panelBebidas);
		
		
		
		JLabel labelBebidas = new JLabel("Bebidas");
		labelBebidas.setBackground(SystemColor.window);
		labelBebidas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		labelBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		labelBebidas.setBounds(6, 6, 238, 25);
		panelBebidas.add(labelBebidas);
		
		
		
		///// 			BEBIDA 1			//////
		if(estoque.quantBebidas >= 1){
			JPanel panelBebida1 = new JPanel();
			panelBebida1.setBackground(SystemColor.window);
			panelBebida1.setLayout(null);
			panelBebida1.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida1.setBounds(6, 43, 238, 60);
			panelBebidas.add(panelBebida1);
			
			JButton button1Bebida1 = new JButton("-");
			button1Bebida1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida1.setBounds(0, 0, 53, 60);
			button1Bebida1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[0] > 0){
						clicaBebida[0]--;
						textAreaBebida[0].setText(clicaBebida[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida1.add(button1Bebida1);
			
			JLabel labelBebida1 = new JLabel("1 - " + estoque.bebidas[0].getNome());
			labelBebida1.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida1.setBounds(49, 12, 140, 20);
			panelBebida1.add(labelBebida1);
			
			JButton button2Bebida1 = new JButton("+");
			button2Bebida1.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida1.setBounds(185, 0, 53, 60);
			button2Bebida1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[0].getQuantidade() > clicaBebida[0]){
						clicaBebida[0]++;
						textAreaBebida[0].setText(clicaBebida[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida1.add(button2Bebida1);
			
			textAreaBebida[0] = new JTextArea();
			textAreaBebida[0].setEditable(false);
			textAreaBebida[0].setText(clicaBebida[0] + "");
			textAreaBebida[0].setBackground(SystemColor.window);
			textAreaBebida[0].setBounds(113, 38, 16, 16);
			panelBebida1.add(textAreaBebida[0]);
		}
		
		
		
		///// 			BEBIDA 2			//////
		if(estoque.quantBebidas >= 2){
			JPanel panelBebida2 = new JPanel();
			panelBebida2.setBackground(SystemColor.window);
			panelBebida2.setLayout(null);
			panelBebida2.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida2.setBounds(6, 115, 238, 60);
			panelBebidas.add(panelBebida2);
			
			JButton button1Bebida2 = new JButton("-");
			button1Bebida2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida2.setBounds(0, 0, 53, 60);
			button1Bebida2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[1] > 0){
						clicaBebida[1]--;
						textAreaBebida[1].setText(clicaBebida[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida2.add(button1Bebida2);
			
			JLabel labelBebida2 = new JLabel("2 - " + estoque.bebidas[1].getNome());
			labelBebida2.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida2.setBounds(49, 12, 140, 20);
			panelBebida2.add(labelBebida2);
			
			JButton button2Bebida2 = new JButton("+");
			button2Bebida2.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida2.setBounds(185, 0, 53, 60);
			button2Bebida2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[1].getQuantidade() > clicaBebida[1]){
						clicaBebida[1]++;
						textAreaBebida[1].setText(clicaBebida[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida2.add(button2Bebida2);
			
			textAreaBebida[1] = new JTextArea();
			textAreaBebida[1].setEditable(false);
			textAreaBebida[1].setText(clicaBebida[1] + "");
			textAreaBebida[1].setBackground(SystemColor.window);
			textAreaBebida[1].setBounds(113, 38, 16, 16);
			panelBebida2.add(textAreaBebida[1]);
		}
		
		
		
		///// 			BEBIDA 3			//////		
		if(estoque.quantBebidas >= 3){
			JPanel panelBebida3 = new JPanel();
			panelBebida3.setBackground(SystemColor.window);
			panelBebida3.setLayout(null);
			panelBebida3.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida3.setBounds(6, 187, 238, 60);
			panelBebidas.add(panelBebida3);
			
			JButton button1Bebida3 = new JButton("-");
			button1Bebida3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida3.setBounds(0, 0, 53, 60);
			button1Bebida3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[2] > 0){
						clicaBebida[2]--;
						textAreaBebida[2].setText(clicaBebida[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida3.add(button1Bebida3);
			
			JLabel labelBebida3 = new JLabel("3 - " + estoque.bebidas[2].getNome());
			labelBebida3.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida3.setBounds(49, 12, 140, 20);
			panelBebida3.add(labelBebida3);
			
			JButton button2Bebida3 = new JButton("+");
			button2Bebida3.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida3.setBounds(185, 0, 53, 60);
			button2Bebida3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[2].getQuantidade() > clicaBebida[2]){
						clicaBebida[2]++;
						textAreaBebida[2].setText(clicaBebida[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida3.add(button2Bebida3);
			
			textAreaBebida[2] = new JTextArea();
			textAreaBebida[2].setEditable(false);
			textAreaBebida[2].setText(clicaBebida[2] + "");
			textAreaBebida[2].setBackground(SystemColor.window);
			textAreaBebida[2].setBounds(113, 38, 16, 16);
			panelBebida3.add(textAreaBebida[2]);
		}
		
		
		
		///// 			BEBIDA 4			//////		
		if(estoque.quantBebidas >= 4){
			JPanel panelBebida4 = new JPanel();
			panelBebida4.setBackground(SystemColor.window);
			panelBebida4.setLayout(null);
			panelBebida4.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida4.setBounds(6, 259, 238, 60);
			panelBebidas.add(panelBebida4);
			
			JButton button1Bebida4 = new JButton("-");
			button1Bebida4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida4.setBounds(0, 0, 53, 60);
			button1Bebida4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[3] > 0){
						clicaBebida[3]--;
						textAreaBebida[3].setText(clicaBebida[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida4.add(button1Bebida4);
			
			JLabel labelBebida4 = new JLabel("4 - " + estoque.bebidas[3].getNome());
			labelBebida4.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida4.setBounds(49, 12, 140, 20);
			panelBebida4.add(labelBebida4);
			
			JButton button2Bebida4 = new JButton("+");
			button2Bebida4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[3].getQuantidade() > clicaBebida[3]){
						clicaBebida[3]++;
						textAreaBebida[3].setText(clicaBebida[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button2Bebida4.setBounds(185, 0, 53, 60);
			panelBebida4.add(button2Bebida4);
			
			textAreaBebida[3] = new JTextArea();
			textAreaBebida[3].setEditable(false);
			textAreaBebida[3].setText(clicaBebida[3] + "");
			textAreaBebida[3].setBackground(SystemColor.window);
			textAreaBebida[3].setBounds(113, 38, 16, 16);
			panelBebida4.add(textAreaBebida[3]);
		}
		
		
		
		
		///// 			BEBIDA 5			//////
		if(estoque.quantBebidas >= 5){
			JPanel panelBebida5 = new JPanel();
			panelBebida5.setBackground(SystemColor.window);
			panelBebida5.setLayout(null);
			panelBebida5.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida5.setBounds(6, 331, 238, 60);
			panelBebidas.add(panelBebida5);
			
			JButton button1Bebida5 = new JButton("-");
			button1Bebida5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida5.setBounds(0, 0, 53, 60);
			button1Bebida5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[4] > 0){
						clicaBebida[4]--;
						textAreaBebida[4].setText(clicaBebida[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida5.add(button1Bebida5);
			
			JLabel labelBebida5 = new JLabel("5 - " + estoque.bebidas[4].getNome());
			labelBebida5.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida5.setBounds(49, 12, 140, 20);
			panelBebida5.add(labelBebida5);
			
			JButton button2Bebida5 = new JButton("+");
			button2Bebida5.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida5.setBounds(185, 0, 53, 60);
			button2Bebida5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[4].getQuantidade() > clicaBebida[4]){
						clicaBebida[4]++;
						textAreaBebida[4].setText(clicaBebida[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			
			panelBebida5.add(button2Bebida5);
			
			textAreaBebida[4] = new JTextArea();
			textAreaBebida[4].setEditable(false);
			textAreaBebida[4].setText(clicaBebida[4] + "");
			textAreaBebida[4].setBackground(SystemColor.window);
			textAreaBebida[4].setBounds(113, 38, 16, 16);
			panelBebida5.add(textAreaBebida[4]);
		}
		
		
		
		///// 			BEBIDA 6			//////
		if(estoque.quantBebidas >= 6){
			JPanel panelBebida6 = new JPanel();
			panelBebida6.setBackground(SystemColor.window);
			panelBebida6.setLayout(null);
			panelBebida6.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida6.setBounds(6, 403, 238, 60);
			panelBebidas.add(panelBebida6);
			
			JButton button1Bebida6 = new JButton("-");
			button1Bebida6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida6.setBounds(0, 0, 53, 60);
			button1Bebida6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[5] > 0){
						clicaBebida[5]--;
						textAreaBebida[5].setText(clicaBebida[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida6.add(button1Bebida6);
			
			JLabel labelBebida6 = new JLabel("6 - " + estoque.bebidas[5].getNome());
			labelBebida6.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida6.setBounds(49, 12, 140, 20);
			panelBebida6.add(labelBebida6);
			
			JButton button2Bebida6 = new JButton("+");
			button2Bebida6.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida6.setBounds(185, 0, 53, 60);
			button2Bebida6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[5].getQuantidade() > clicaBebida[5]){
						clicaBebida[5]++;
						textAreaBebida[5].setText(clicaBebida[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida6.add(button2Bebida6);
			
			textAreaBebida[5] = new JTextArea();
			textAreaBebida[5].setEditable(false);
			textAreaBebida[5].setText(clicaBebida[5] + "");
			textAreaBebida[5].setBackground(SystemColor.window);
			textAreaBebida[5].setBounds(113, 38, 16, 16);
			panelBebida6.add(textAreaBebida[5]);
		}
		
		
		
		
		///// 			BEBIDA 7			//////
		if(estoque.quantBebidas >= 7){
			JPanel panelBebida7 = new JPanel();
			panelBebida7.setBackground(SystemColor.window);
			panelBebida7.setLayout(null);
			panelBebida7.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida7.setBounds(6, 475, 238, 60);
			panelBebidas.add(panelBebida7);
			
			JButton button1Bebida7 = new JButton("-");
			button1Bebida7.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida7.setBounds(0, 0, 53, 60);
			button1Bebida7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[6] > 0){
						clicaBebida[6]--;
						textAreaBebida[6].setText(clicaBebida[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida7.add(button1Bebida7);
			
			JLabel labelBebida7 = new JLabel("7 - " + estoque.bebidas[6].getNome());
			labelBebida7.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida7.setBounds(49, 12, 140, 20);
			panelBebida7.add(labelBebida7);
			
			JButton button2Bebida7 = new JButton("+");
			button2Bebida7.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida7.setBounds(185, 0, 53, 60);
			button2Bebida7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[6].getQuantidade() > clicaBebida[6]){
						clicaBebida[6]++;
						textAreaBebida[6].setText(clicaBebida[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida7.add(button2Bebida7);
			
			textAreaBebida[6] = new JTextArea();
			textAreaBebida[6].setEditable(false);
			textAreaBebida[6].setText(clicaBebida[6] + "");
			textAreaBebida[6].setBackground(SystemColor.window);
			textAreaBebida[6].setBounds(113, 38, 16, 16);
			panelBebida7.add(textAreaBebida[6]);
		}
		
		
		
		///// 			BEBIDA 8			//////
		if(estoque.quantBebidas >= 8){
			JPanel panelBebida8 = new JPanel();
			panelBebida8.setBackground(SystemColor.window);
			panelBebida8.setLayout(null);
			panelBebida8.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida8.setBounds(6, 547, 238, 60);
			panelBebidas.add(panelBebida8);
			
			JButton button1Bebida8 = new JButton("-");
			button1Bebida8.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida8.setBounds(0, 0, 53, 60);
			button1Bebida8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[7] > 0){
						clicaBebida[7]--;
						textAreaBebida[7].setText(clicaBebida[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida8.add(button1Bebida8);
			
			JLabel labelBebida8 = new JLabel("8 - " + estoque.bebidas[7].getNome());
			labelBebida8.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida8.setBounds(49, 12, 140, 20);
			panelBebida8.add(labelBebida8);
			
			JButton button2Bebida8 = new JButton("+");
			button2Bebida8.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida8.setBounds(185, 0, 53, 60);
			button2Bebida8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[7].getQuantidade() > clicaBebida[7]){
						clicaBebida[7]++;
						textAreaBebida[7].setText(clicaBebida[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida8.add(button2Bebida8);
			
			textAreaBebida[7] = new JTextArea();
			textAreaBebida[7].setEditable(false);
			textAreaBebida[7].setText(clicaBebida[7] + "");
			textAreaBebida[7].setBackground(SystemColor.window);
			textAreaBebida[7].setBounds(113, 38, 16, 16);
			panelBebida8.add(textAreaBebida[7]);
		}
		
		
		
		///// 			BEBIDA 9			//////
		if(estoque.quantBebidas >= 9){
			JPanel panelBebida9 = new JPanel();
			panelBebida9.setBackground(SystemColor.window);
			panelBebida9.setLayout(null);
			panelBebida9.setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida9.setBounds(6, 619, 238, 60);
			panelBebidas.add(panelBebida9);
			
			JButton button1Bebida9 = new JButton("-");
			button1Bebida9.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida9.setBounds(0, 0, 53, 60);
			button1Bebida9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[8] > 0){
						clicaBebida[8]--;
						textAreaBebida[8].setText(clicaBebida[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida9.add(button1Bebida9);
			
			JLabel labelBebida9 = new JLabel("9 - " + estoque.bebidas[8].getNome());
			labelBebida9.setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida9.setBounds(49, 12, 140, 20);
			panelBebida9.add(labelBebida9);
			
			JButton button2Bebida9 = new JButton("+");
			button2Bebida9.setMargin(new Insets(0, 0, 0, 0));
			button2Bebida9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida9.setBounds(185, 0, 53, 60);
			button2Bebida9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[8].getQuantidade() > clicaBebida[8]){
						clicaBebida[8]++;
						textAreaBebida[8].setText(clicaBebida[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida9.add(button2Bebida9);
			
			textAreaBebida[8] = new JTextArea();
			textAreaBebida[8].setEditable(false);
			textAreaBebida[8].setText(clicaBebida[8] + "");
			textAreaBebida[8].setBackground(SystemColor.window);
			textAreaBebida[8].setBounds(113, 38, 16, 16);
			panelBebida9.add(textAreaBebida[8]);
		}
		
		
		
		///// 			PAINEL SNACKS			//////
		JPanel panelSnacks = new JPanel();
		panelSnacks.setBackground(SystemColor.window);
		panelSnacks.setLayout(null);
		panelSnacks.setBorder(new LineBorder(Color.BLACK));
		panelSnacks.setBounds(266, 6, 250, 690);
		contentPane.add(panelSnacks);
		
		JLabel labelSnacks = new JLabel("Snacks");
		labelSnacks.setBackground(SystemColor.window);
		labelSnacks.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		labelSnacks.setHorizontalAlignment(SwingConstants.CENTER);
		labelSnacks.setBounds(6, 6, 238, 25);
		panelSnacks.add(labelSnacks);
		
		
		
		///// 			SNACK 1			//////
		if(estoque.quantSnacks >= 1){
			JPanel panelSnack1 = new JPanel();
			panelSnack1.setBackground(SystemColor.window);
			panelSnack1.setLayout(null);
			panelSnack1.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack1.setBounds(6, 43, 238, 60);
			panelSnacks.add(panelSnack1);
			
			JButton button1Snack1 = new JButton("-");
			button1Snack1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack1.setBounds(0, 0, 53, 60);
			button1Snack1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[0] > 0){
						clicaSnack[0]--;
						textAreaSnack[0].setText(clicaSnack[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack1.add(button1Snack1);
			
			JLabel labelSnack1 = new JLabel("Q - " + estoque.snacks[0].getNome());
			labelSnack1.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack1.setBounds(49, 12, 140, 20);
			panelSnack1.add(labelSnack1);
			
			JButton button2Snack1 = new JButton("+");
			button2Snack1.setMargin(new Insets(0, 0, 0, 0));
			button2Snack1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack1.setBounds(185, 0, 53, 60);
			button2Snack1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[0].getQuantidade() > clicaSnack[0]){
						clicaSnack[0]++;
						textAreaSnack[0].setText(clicaSnack[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack1.add(button2Snack1);
			
			textAreaSnack[0] = new JTextArea();
			textAreaSnack[0].setEditable(false);
			textAreaSnack[0].setText(clicaSnack[0] + "");
			textAreaSnack[0].setBackground(SystemColor.window);
			textAreaSnack[0].setBounds(113, 38, 16, 16);
			panelSnack1.add(textAreaSnack[0]);
		}
		
		
		
		///// 			SNACK 2			//////
		if(estoque.quantSnacks >= 2){
			JPanel panelSnack2 = new JPanel();
			panelSnack2.setBackground(SystemColor.window);
			panelSnack2.setLayout(null);
			panelSnack2.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack2.setBounds(6, 115, 238, 60);
			panelSnacks.add(panelSnack2);
			
			JButton button1Snack2 = new JButton("-");
			button1Snack2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack2.setBounds(0, 0, 53, 60);
			button1Snack2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[1] > 0){
						clicaSnack[1]--;
						textAreaSnack[1].setText(clicaSnack[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			
			panelSnack2.add(button1Snack2);
			
			JLabel labelSnack2 = new JLabel("A - " + estoque.snacks[1].getNome());
			labelSnack2.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack2.setBounds(49, 12, 140, 20);
			panelSnack2.add(labelSnack2);
			
			JButton button2Snack2 = new JButton("+");
			button2Snack2.setMargin(new Insets(0, 0, 0, 0));
			button2Snack2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack2.setBounds(185, 0, 53, 60);
			button2Snack2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[1].getQuantidade() > clicaSnack[1]){
						clicaSnack[1]++;
						textAreaSnack[1].setText(clicaSnack[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			
			panelSnack2.add(button2Snack2);
			
			textAreaSnack[1] = new JTextArea();
			textAreaSnack[1].setEditable(false);
			textAreaSnack[1].setText(clicaSnack[1] + "");
			textAreaSnack[1].setBackground(SystemColor.window);
			textAreaSnack[1].setBounds(113, 38, 16, 16);
			panelSnack2.add(textAreaSnack[1]);
		}
		
		
		
		///// 			SNACK 3			//////
		if(estoque.quantSnacks >= 3){
			JPanel panelSnack3 = new JPanel();
			panelSnack3.setBackground(SystemColor.window);
			panelSnack3.setLayout(null);
			panelSnack3.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack3.setBounds(6, 187, 238, 60);
			panelSnacks.add(panelSnack3);
			
			JButton button1Snack3 = new JButton("-");
			button1Snack3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[2] > 0){
						clicaSnack[2]--;
						textAreaSnack[2].setText(clicaSnack[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button1Snack3.setBounds(0, 0, 53, 60);
			panelSnack3.add(button1Snack3);
			
			JLabel labelSnack3 = new JLabel("Z -  " + estoque.snacks[2].getNome());
			labelSnack3.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack3.setBounds(49, 12, 140, 20);
			panelSnack3.add(labelSnack3);
			
			JButton button2Snack3 = new JButton("+");
			button2Snack3.setMargin(new Insets(0, 0, 0, 0));
			button2Snack3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack3.setBounds(185, 0, 53, 60);
			button2Snack3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[2].getQuantidade() > clicaSnack[2]){
						clicaSnack[2]++;
						textAreaSnack[2].setText(clicaSnack[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack3.add(button2Snack3);
			
			textAreaSnack[2] = new JTextArea();
			textAreaSnack[2].setEditable(false);
			textAreaSnack[2].setText(clicaSnack[2] + "");
			textAreaSnack[2].setBackground(SystemColor.window);
			textAreaSnack[2].setBounds(113, 38, 16, 16);
			panelSnack3.add(textAreaSnack[2]);
		}
		
		
		
		///// 			SNACK 4			//////
		if(estoque.quantSnacks >= 4){
			JPanel panelSnack4 = new JPanel();
			panelSnack4.setBackground(SystemColor.window);
			panelSnack4.setLayout(null);
			panelSnack4.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack4.setBounds(6, 259, 238, 60);
			panelSnacks.add(panelSnack4);
			
			JButton button1Snack4 = new JButton("-");
			button1Snack4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack4.setBounds(0, 0, 53, 60);
			button1Snack4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[3] > 0){
						clicaSnack[3]--;
						textAreaSnack[3].setText(clicaSnack[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack4.add(button1Snack4);
			
			JLabel labelSnack4 = new JLabel("W -  " + estoque.snacks[3].getNome());
			labelSnack4.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack4.setBounds(49, 12, 140, 20);
			panelSnack4.add(labelSnack4);
			
			JButton button2Snack4 = new JButton("+");
			button2Snack4.setMargin(new Insets(0, 0, 0, 0));
			button2Snack4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack4.setBounds(185, 0, 53, 60);
			button2Snack4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[3].getQuantidade() > clicaSnack[3]){
						clicaSnack[3]++;
						textAreaSnack[3].setText(clicaSnack[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack4.add(button2Snack4);
			
			textAreaSnack[3] = new JTextArea();
			textAreaSnack[3].setEditable(false);
			textAreaSnack[3].setText("0");
			textAreaSnack[3].setBackground(SystemColor.window);
			textAreaSnack[3].setBounds(113, 38, 16, 16);
			panelSnack4.add(textAreaSnack[3]);
		}
		
		
		
		///// 			SNACK 5			//////
		if(estoque.quantSnacks >= 5){
			JPanel panelSnack5 = new JPanel();
			panelSnack5.setBackground(SystemColor.window);
			panelSnack5.setLayout(null);
			panelSnack5.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack5.setBounds(6, 331, 238, 60);
			panelSnacks.add(panelSnack5);
			
			JButton button1Snack5 = new JButton("-");
			button1Snack5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack5.setBounds(0, 0, 53, 60);
			button1Snack5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[4] > 0){
						clicaSnack[4]--;
						textAreaSnack[4].setText(clicaSnack[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack5.add(button1Snack5);
			
			JLabel labelSnack5 = new JLabel("S -  " + estoque.snacks[4].getNome());
			labelSnack5.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack5.setBounds(49, 12, 140, 20);
			panelSnack5.add(labelSnack5);
			
			JButton button2Snack5 = new JButton("+");
			button2Snack5.setMargin(new Insets(0, 0, 0, 0));
			button2Snack5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack5.setBounds(185, 0, 53, 60);
			button2Snack5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[4].getQuantidade() > clicaSnack[4]){
						clicaSnack[4]++;
						textAreaSnack[4].setText(clicaSnack[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack5.add(button2Snack5);
			
			textAreaSnack[4] = new JTextArea();
			textAreaSnack[4].setEditable(false);
			textAreaSnack[4].setText(clicaSnack[4] + "");
			textAreaSnack[4].setBackground(SystemColor.window);
			textAreaSnack[4].setBounds(113, 38, 16, 16);
			panelSnack5.add(textAreaSnack[4]);
		}
		
		
		
		///// 			SNACK 6			//////
		if(estoque.quantSnacks >= 6){
			JPanel panelSnack6 = new JPanel();
			panelSnack6.setBackground(SystemColor.window);
			panelSnack6.setLayout(null);
			panelSnack6.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack6.setBounds(6, 403, 238, 60);
			panelSnacks.add(panelSnack6);
			
			JButton button1Snack6 = new JButton("-");
			button1Snack6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack6.setBounds(0, 0, 53, 60);
			button1Snack6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[5] > 0){
						clicaSnack[5]--;
						textAreaSnack[5].setText(clicaSnack[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack6.add(button1Snack6);
			
			JLabel labelSnack6 = new JLabel("X -  " + estoque.snacks[5].getNome());
			labelSnack6.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack6.setBounds(49, 12, 140, 20);
			panelSnack6.add(labelSnack6);
			
			JButton button2Snack6 = new JButton("+");
			button2Snack6.setMargin(new Insets(0, 0, 0, 0));
			button2Snack6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack6.setBounds(185, 0, 53, 60);
			button2Snack6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[5].getQuantidade() > clicaSnack[5]){
						clicaSnack[5]++;
						textAreaSnack[5].setText(clicaSnack[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack6.add(button2Snack6);
			
			textAreaSnack[5] = new JTextArea();
			textAreaSnack[5].setEditable(false);
			textAreaSnack[5].setText(clicaSnack[6] + "");
			textAreaSnack[5].setBackground(SystemColor.window);
			textAreaSnack[5].setBounds(113, 38, 16, 16);
			panelSnack6.add(textAreaSnack[5]);
		}
		
		
		
		///// 			SNACK 7			//////
		if(estoque.quantSnacks >= 7){
			JPanel panelSnack7 = new JPanel();
			panelSnack7.setBackground(SystemColor.window);
			panelSnack7.setLayout(null);
			panelSnack7.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack7.setBounds(6, 475, 238, 60);
			panelSnacks.add(panelSnack7);
			
			JButton button1Snack7 = new JButton("-");
			button1Snack7.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack7.setBounds(0, 0, 53, 60);
			button1Snack7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[6] > 0){
						clicaSnack[6]--;
						textAreaSnack[6].setText(clicaSnack[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack7.add(button1Snack7);
			
			JLabel labelSnack7 = new JLabel("E -  " + estoque.snacks[6].getNome());
			labelSnack7.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack7.setBounds(49, 12, 140, 20);
			panelSnack7.add(labelSnack7);
			
			JButton button2Snack7 = new JButton("+");
			button2Snack7.setMargin(new Insets(0, 0, 0, 0));
			button2Snack7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack7.setBounds(185, 0, 53, 60);
			button2Snack7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[6].getQuantidade() > clicaSnack[6]){
						clicaSnack[6]++;
						textAreaSnack[6].setText(clicaSnack[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack7.add(button2Snack7);
			
			textAreaSnack[6] = new JTextArea();
			textAreaSnack[6].setEditable(false);
			textAreaSnack[6].setText(clicaSnack[6] + "");
			textAreaSnack[6].setBackground(SystemColor.window);
			textAreaSnack[6].setBounds(113, 38, 16, 16);
			panelSnack7.add(textAreaSnack[6]);
		}
		
		
		
		///// 			SNACK 8			//////
		if(estoque.quantSnacks >= 8){
			JPanel panelSnack8 = new JPanel();
			panelSnack8.setBackground(SystemColor.window);
			panelSnack8.setLayout(null);
			panelSnack8.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack8.setBounds(6, 547, 238, 60);
			panelSnacks.add(panelSnack8);
			
			JButton button1Snack8 = new JButton("-");
			button1Snack8.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack8.setBounds(0, 0, 53, 60);
			button1Snack8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[7] > 0){
						clicaSnack[7]--;
						textAreaSnack[7].setText(clicaSnack[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack8.add(button1Snack8);
			
			JLabel labelSnack8 = new JLabel("D - " + estoque.snacks[7].getNome());
			labelSnack8.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack8.setBounds(49, 12, 140, 20);
			panelSnack8.add(labelSnack8);
			
			JButton button2Snack8 = new JButton("+");
			button2Snack8.setMargin(new Insets(0, 0, 0, 0));
			button2Snack8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack8.setBounds(185, 0, 53, 60);
			button2Snack8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[7].getQuantidade() > clicaSnack[7]){
						clicaSnack[7]++;
						textAreaSnack[7].setText(clicaSnack[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack8.add(button2Snack8);
			
			textAreaSnack[7] = new JTextArea();
			textAreaSnack[7].setEditable(false);
			textAreaSnack[7].setText(clicaSnack[7] + "");
			textAreaSnack[7].setBackground(SystemColor.window);
			textAreaSnack[7].setBounds(113, 38, 16, 16);
			panelSnack8.add(textAreaSnack[7]);
		}
		
		
		
		///// 			SNACK 9			//////
		if(estoque.quantSnacks >= 9){
			JPanel panelSnack9 = new JPanel();
			panelSnack9.setBackground(SystemColor.window);
			panelSnack9.setLayout(null);
			panelSnack9.setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack9.setBounds(6, 619, 238, 60);
			panelSnacks.add(panelSnack9);
			
			JButton button1Snack9 = new JButton("-");
			button1Snack9.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack9.setBounds(0, 0, 53, 60);
			button1Snack9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[8] > 0){
						clicaSnack[8]--;
						textAreaSnack[8].setText(clicaSnack[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack9.add(button1Snack9);
			
			JLabel labelSnack9 = new JLabel("C - " + estoque.snacks[8].getNome());
			labelSnack9.setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack9.setBounds(49, 12, 140, 20);
			panelSnack9.add(labelSnack9);
			
			JButton button2Snack9 = new JButton("+");
			button2Snack9.setMargin(new Insets(0, 0, 0, 0));
			button2Snack9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack9.setBounds(185, 0, 53, 60);
			button2Snack9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[8].getQuantidade() > clicaSnack[8]){
						clicaSnack[8]++;
						textAreaSnack[8].setText(clicaSnack[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack9.add(button2Snack9);
			
			textAreaSnack[8] = new JTextArea();
			textAreaSnack[8].setEditable(false);
			textAreaSnack[8].setText(clicaSnack[8] + "");
			textAreaSnack[8].setBackground(SystemColor.window);
			textAreaSnack[8].setBounds(113, 38, 16, 16);
			panelSnack9.add(textAreaSnack[8]);
		}
		
		
		
		///// 			PAINEL SNACKS 2			//////
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setBackground(SystemColor.window);
		panel2Snacks.setLayout(null);
		panel2Snacks.setBorder(new LineBorder(Color.BLACK));
		panel2Snacks.setBounds(526, 6, 250, 690);
		contentPane.add(panel2Snacks);
		
		JLabel label2Snacks = new JLabel("Snacks");
		label2Snacks.setBackground(SystemColor.window);
		label2Snacks.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label2Snacks.setHorizontalAlignment(SwingConstants.CENTER);
		label2Snacks.setBounds(6, 6, 238, 25);
		panel2Snacks.add(label2Snacks);
		
		
		
		///// 			SNACK2 1 		//////
		if(estoque.quantSnacks >= 10){
			JPanel panel2Snack1 = new JPanel();
			panel2Snack1.setBackground(SystemColor.window);
			panel2Snack1.setLayout(null);
			panel2Snack1.setBorder(new LineBorder(new Color(64, 64, 64)));
			panel2Snack1.setBounds(6, 43, 238, 60);
			panel2Snacks.add(panel2Snack1);
			
			JButton button1_2Snack1 = new JButton("-");
			button1_2Snack1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack1.setBounds(0, 0, 53, 60);
			button1_2Snack1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[9] > 0){
						clicaSnack[9]--;
						textAreaSnack[9].setText(clicaSnack[9] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack1.add(button1_2Snack1);
			
			JLabel label2Snack1 = new JLabel("R - " + estoque.snacks[9].getNome());
			label2Snack1.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack1.setBounds(49, 12, 140, 20);
			panel2Snack1.add(label2Snack1);
			
			JButton button2_2Snack1 = new JButton("+");
			button2_2Snack1.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack1.setBounds(185, 0, 53, 60);
			button2_2Snack1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[9].getQuantidade() > clicaSnack[9]){
						clicaSnack[9]++;
						textAreaSnack[9].setText(clicaSnack[9] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack1.add(button2_2Snack1);
			
			textAreaSnack[9] = new JTextArea();
			textAreaSnack[9].setEditable(false);
			textAreaSnack[9].setText(clicaSnack[9] + "");
			textAreaSnack[9].setBackground(SystemColor.window);
			textAreaSnack[9].setBounds(113, 38, 16, 16);
			panel2Snack1.add(textAreaSnack[9]);
		}
		
		
		
		///// 			SNACK2 2 		//////
		if(estoque.quantSnacks >= 11){
			JPanel panel2Snack2 = new JPanel();
			panel2Snack2.setBackground(SystemColor.window);
			panel2Snack2.setLayout(null);
			panel2Snack2.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack2.setBounds(6, 115, 238, 60);
			panel2Snacks.add(panel2Snack2);
			
			JButton button1_2Snack2 = new JButton("-");
			button1_2Snack2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack2.setBounds(0, 0, 53, 60);
			button1_2Snack2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[10] > 0){
						clicaSnack[10]--;
						textAreaSnack[10].setText(clicaSnack[10] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack2.add(button1_2Snack2);
			
			JLabel label2Snack2 = new JLabel("F - " + estoque.snacks[10].getNome());
			label2Snack2.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack2.setBounds(49, 12, 140, 20);
			panel2Snack2.add(label2Snack2);
			
			JButton button2_2Snack2 = new JButton("+");
			button2_2Snack2.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack2.setBounds(185, 0, 53, 60);
			button2_2Snack2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[10].getQuantidade() > clicaSnack[10]){
						clicaSnack[10]++;
						textAreaSnack[10].setText(clicaSnack[10] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack2.add(button2_2Snack2);
			
			textAreaSnack[10] = new JTextArea();
			textAreaSnack[10].setEditable(false);
			textAreaSnack[10].setText(clicaSnack[10] + "");
			textAreaSnack[10].setBackground(SystemColor.window);
			textAreaSnack[10].setBounds(113, 38, 16, 16);
			panel2Snack2.add(textAreaSnack[10]);
		}
		
		
		
		///// 			SNACK2 3 		//////
		if(estoque.quantSnacks >= 12){
			JPanel panel2Snack3 = new JPanel();
			panel2Snack3.setBackground(SystemColor.window);
			panel2Snack3.setLayout(null);
			panel2Snack3.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack3.setBounds(6, 187, 238, 60);
			panel2Snacks.add(panel2Snack3);
			
			JButton button1_2Snack3 = new JButton("-");
			button1_2Snack3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack3.setBounds(0, 0, 53, 60);
			button1_2Snack3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[11] > 0){
						clicaSnack[11]--;
						textAreaSnack[11].setText(clicaSnack[11] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack3.add(button1_2Snack3);
			
			JLabel label2Snack3 = new JLabel("V - " + estoque.snacks[11].getNome());
			label2Snack3.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack3.setBounds(49, 12, 140, 20);
			panel2Snack3.add(label2Snack3);
			
			JButton button2_2Snack3 = new JButton("+");
			button2_2Snack3.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack3.setBounds(185, 0, 53, 60);
			button2_2Snack3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[11].getQuantidade() > clicaSnack[11]){
						clicaSnack[11]++;
						textAreaSnack[11].setText(clicaSnack[11] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack3.add(button2_2Snack3);
			
			textAreaSnack[11] = new JTextArea();
			textAreaSnack[11].setEditable(false);
			textAreaSnack[11].setText(clicaSnack[11] + "");
			textAreaSnack[11].setBackground(SystemColor.window);
			textAreaSnack[11].setBounds(113, 38, 16, 16);
			panel2Snack3.add(textAreaSnack[11]);
		}
		
		
		
		///// 			SNACK2 4 		//////
		if(estoque.quantSnacks >= 13){
			JPanel panel2Snack4 = new JPanel();
			panel2Snack4.setBackground(SystemColor.window);
			panel2Snack4.setLayout(null);
			panel2Snack4.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack4.setBounds(6, 259, 238, 60);
			panel2Snacks.add(panel2Snack4);
			
			JButton button1_2Snack4 = new JButton("-");
			button1_2Snack4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack4.setBounds(0, 0, 53, 60);
			button1_2Snack4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[12] > 0){
						clicaSnack[12]--;
						textAreaSnack[12].setText(clicaSnack[12] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack4.add(button1_2Snack4);
			
			JLabel label2Snack4 = new JLabel("T - " + estoque.snacks[12].getNome());
			label2Snack4.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack4.setBounds(49, 12, 140, 20);
			panel2Snack4.add(label2Snack4);
			
			JButton button2_2Snack4 = new JButton("+");
			button2_2Snack4.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack4.setBounds(185, 0, 53, 60);
			button2_2Snack4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[12].getQuantidade() > clicaSnack[12]){
						clicaSnack[12]++;
						textAreaSnack[12].setText(clicaSnack[12] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack4.add(button2_2Snack4);
			
			textAreaSnack[12] = new JTextArea();
			textAreaSnack[12].setEditable(false);
			textAreaSnack[12].setText(clicaSnack[12] + "");
			textAreaSnack[12].setBackground(SystemColor.window);
			textAreaSnack[12].setBounds(113, 38, 16, 16);
			panel2Snack4.add(textAreaSnack[12]);
		}
		
		
		
		///// 			SNACK2 5 		//////
		if(estoque.quantSnacks >= 14){
			JPanel panel2Snack5 = new JPanel();
			panel2Snack5.setBackground(SystemColor.window);
			panel2Snack5.setLayout(null);
			panel2Snack5.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack5.setBounds(6, 331, 238, 60);
			panel2Snacks.add(panel2Snack5);
			
			JButton button1_2Snack5 = new JButton("-");
			button1_2Snack5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack5.setBounds(0, 0, 53, 60);
			button1_2Snack5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[13] > 0){
						clicaSnack[13]--;
						textAreaSnack[13].setText(clicaSnack[13] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack5.add(button1_2Snack5);
			
			JLabel label2Snack5 = new JLabel("G - " + estoque.snacks[13].getNome());
			label2Snack5.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack5.setBounds(49, 12, 140, 20);
			panel2Snack5.add(label2Snack5);
			
			JButton button2_2Snack5 = new JButton("+");
			button2_2Snack5.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack5.setBounds(185, 0, 53, 60);
			button2_2Snack5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[13].getQuantidade() > clicaSnack[13]){
						clicaSnack[13]++;
						textAreaSnack[13].setText(clicaSnack[13] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack5.add(button2_2Snack5);
			
			textAreaSnack[13] = new JTextArea();
			textAreaSnack[13].setEditable(false);
			textAreaSnack[13].setText(clicaSnack[13] + "");
			textAreaSnack[13].setBackground(SystemColor.window);
			textAreaSnack[13].setBounds(113, 38, 16, 16);
			panel2Snack5.add(textAreaSnack[13]);
		}
		
		
		
		///// 			SNACK2 6 		//////
		if(estoque.quantSnacks >= 15){
			JPanel panel2Snack6 = new JPanel();
			panel2Snack6.setBackground(SystemColor.window);
			panel2Snack6.setLayout(null);
			panel2Snack6.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack6.setBounds(6, 403, 238, 60);
			panel2Snacks.add(panel2Snack6);
			
			JButton button1_2Snack6 = new JButton("-");
			button1_2Snack6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack6.setBounds(0, 0, 53, 60);
			button1_2Snack6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[14] > 0){
						clicaSnack[14]--;
						textAreaSnack[14].setText(clicaSnack[14] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack6.add(button1_2Snack6);
			
			JLabel label2Snack6 = new JLabel("B - " + estoque.snacks[14].getNome());
			label2Snack6.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack6.setBounds(49, 12, 140, 20);
			panel2Snack6.add(label2Snack6);
			
			JButton button2_2Snack6 = new JButton("+");
			button2_2Snack6.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack6.setBounds(185, 0, 53, 60);
			button2_2Snack6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[14].getQuantidade() > clicaSnack[14]){
						clicaSnack[14]++;
						textAreaSnack[14].setText(clicaSnack[14] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack6.add(button2_2Snack6);
			
			textAreaSnack[14] = new JTextArea();
			textAreaSnack[14].setEditable(false);
			textAreaSnack[14].setText(clicaSnack[14] + "");
			textAreaSnack[14].setBackground(SystemColor.window);
			textAreaSnack[14].setBounds(113, 38, 16, 16);
			panel2Snack6.add(textAreaSnack[14]);
		}
		
		
		
		///// 			SNACK2 7 		//////
		if(estoque.quantSnacks >= 16){
			JPanel panel2Snack7 = new JPanel();
			panel2Snack7.setBackground(SystemColor.window);
			panel2Snack7.setLayout(null);
			panel2Snack7.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack7.setBounds(6, 475, 238, 60);
			panel2Snacks.add(panel2Snack7);
			
			JButton button1_2Snack7 = new JButton("-");
			button1_2Snack7.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack7.setBounds(0, 0, 53, 60);
			panel2Snack7.add(button1_2Snack7);
			
			JLabel label2Snack7 = new JLabel("Y - " + estoque.snacks[15].getNome());
			label2Snack7.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack7.setBounds(49, 12, 140, 20);
			panel2Snack7.add(label2Snack7);
			
			JButton button2_2Snack7 = new JButton("+");
			button2_2Snack7.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack7.setBounds(185, 0, 53, 60);
			button2_2Snack7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[15].getQuantidade() > clicaSnack[15]){
						clicaSnack[15]++;
						textAreaSnack[15].setText(clicaSnack[15] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack7.add(button2_2Snack7);
			
			textAreaSnack[15] = new JTextArea();
			textAreaSnack[15].setEditable(false);
			textAreaSnack[15].setText(clicaSnack[15] + "");
			textAreaSnack[15].setBackground(SystemColor.window);
			textAreaSnack[15].setBounds(113, 38, 16, 16);
			panel2Snack7.add(textAreaSnack[15]);
		}
		
		
		
		///// 			SNACK2 8 		//////
		if(estoque.quantSnacks >= 17){
			JPanel panel2Snack8 = new JPanel();
			panel2Snack8.setBackground(SystemColor.window);
			panel2Snack8.setLayout(null);
			panel2Snack8.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack8.setBounds(6, 547, 238, 60);
			panel2Snacks.add(panel2Snack8);
			
			JButton button1_2Snack8 = new JButton("-");
			button1_2Snack8.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack8.setBounds(0, 0, 53, 60);
			button1_2Snack8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[16] > 0){
						clicaSnack[16]--;
						textAreaSnack[16].setText(clicaSnack[16] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack8.add(button1_2Snack8);
			
			JLabel label2Snack8 = new JLabel("H - " + estoque.snacks[16].getNome());
			label2Snack8.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack8.setBounds(49, 12, 140, 20);
			panel2Snack8.add(label2Snack8);
			
			JButton button2_2Snack8 = new JButton("+");
			button2_2Snack8.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack8.setBounds(185, 0, 53, 60);
			button2_2Snack8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[16].getQuantidade() > clicaSnack[16]){
						clicaSnack[16]++;
						textAreaSnack[16].setText(clicaSnack[16] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack8.add(button2_2Snack8);
			
			textAreaSnack[16] = new JTextArea();
			textAreaSnack[16].setEditable(false);
			textAreaSnack[16].setText(clicaSnack[16] + "");
			textAreaSnack[16].setBackground(SystemColor.window);
			textAreaSnack[16].setBounds(113, 38, 16, 16);
			panel2Snack8.add(textAreaSnack[16]);
		}
		
		
		
		///// 			SNACK2 9 		//////
		if(estoque.quantSnacks >= 18){
			JPanel panel2Snack9 = new JPanel();
			panel2Snack9.setBackground(SystemColor.window);
			panel2Snack9.setLayout(null);
			panel2Snack9.setBorder(new LineBorder(Color.DARK_GRAY));
			panel2Snack9.setBounds(6, 547, 238, 60);
			panel2Snacks.add(panel2Snack9);
			
			JButton button1_2Snack9 = new JButton("-");
			button1_2Snack9.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1_2Snack9.setBounds(0, 0, 53, 60);
			button1_2Snack9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[17] > 0){
						clicaSnack[17]--;
						textAreaSnack[17].setText(clicaSnack[17] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack9.add(button1_2Snack9);
			
			JLabel label2Snack9 = new JLabel("H - " + estoque.snacks[17].getNome());
			label2Snack9.setHorizontalAlignment(SwingConstants.CENTER);
			label2Snack9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			label2Snack9.setBounds(49, 12, 140, 20);
			panel2Snack9.add(label2Snack9);
			
			JButton button2_2Snack9 = new JButton("+");
			button2_2Snack9.setMargin(new Insets(0, 0, 0, 0));
			button2_2Snack9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2_2Snack9.setBounds(185, 0, 53, 60);
			button2_2Snack9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[17].getQuantidade() > clicaSnack[17]){
						clicaSnack[17]++;
						textAreaSnack[17].setText(clicaSnack[17] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panel2Snack9.add(button2_2Snack9);
			
			textAreaSnack[17] = new JTextArea();
			textAreaSnack[17].setEditable(false);
			textAreaSnack[17].setText(clicaSnack[16] + "");
			textAreaSnack[17].setBackground(SystemColor.window);
			textAreaSnack[17].setBounds(113, 38, 16, 16);
			panel2Snack9.add(textAreaSnack[17]);
		}
		
		
		
		///// 			PAINEL OUTROS			//////
		JPanel panelOutros = new JPanel();
		panelOutros.setBackground(SystemColor.window);
		panelOutros.setLayout(null);
		panelOutros.setBorder(new LineBorder(Color.BLACK));
		panelOutros.setBounds(786, 6, 250, 690);
		contentPane.add(panelOutros);
		
		JLabel labelOutros = new JLabel("Outros");
		labelOutros.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutros.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		labelOutros.setBounds(6, 6, 238, 25);
		panelOutros.add(labelOutros);
		
		
		
		///// 			OUTRO 1			//////		
		if(estoque.quantOutros >= 1){
			JPanel panelOutro1 = new JPanel();
			panelOutro1.setBackground(SystemColor.window);
			panelOutro1.setLayout(null);
			panelOutro1.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro1.setBounds(6, 43, 238, 60);
			panelOutros.add(panelOutro1);
			
			JButton button1Outro1 = new JButton("-");
			button1Outro1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro1.setBounds(0, 0, 53, 60);
			button1Outro1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[0] > 0){
						clicaOutro[0]--;
						textAreaOutro[0].setText(clicaOutro[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro1.add(button1Outro1);
			
			JLabel labelOutro1 = new JLabel("U -  " + estoque.outros[0].getNome());
			labelOutro1.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro1.setBounds(49, 12, 140, 20);
			panelOutro1.add(labelOutro1);
			
			JButton button2Outro1 = new JButton("+");
			button2Outro1.setMargin(new Insets(0, 0, 0, 0));
			button2Outro1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro1.setBounds(185, 0, 53, 60);
			button2Outro1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[0].getQuantidade() > clicaOutro[0]){
						clicaOutro[0]++;
						textAreaOutro[0].setText(clicaOutro[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro1.add(button2Outro1);
			
			textAreaOutro[0] = new JTextArea();
			textAreaOutro[0].setEditable(false);
			textAreaOutro[0].setText(clicaOutro[0] + "");
			textAreaOutro[0].setBackground(SystemColor.window);
			textAreaOutro[0].setBounds(113, 38, 16, 16);
			panelOutro1.add(textAreaOutro[0]);
		}
		
		
		
		///// 			OUTRO 2			//////
		if(estoque.quantOutros >= 2){
			JPanel panelOutro2 = new JPanel();
			panelOutro2.setBackground(SystemColor.window);
			panelOutro2.setLayout(null);
			panelOutro2.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro2.setBounds(6, 115, 238, 60);
			panelOutros.add(panelOutro2);
			
			JButton button1Outro2 = new JButton("-");
			button1Outro2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro2.setBounds(0, 0, 53, 60);
			button1Outro2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[1] > 0){
						clicaOutro[1]--;
						textAreaOutro[1].setText(clicaOutro[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro2.add(button1Outro2);
			
			JLabel labelOutro2 = new JLabel("J -  " + estoque.outros[1].getNome());
			labelOutro2.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro2.setBounds(49, 12, 140, 20);
			panelOutro2.add(labelOutro2);
			
			JButton button2Outro2 = new JButton("+");
			button2Outro2.setMargin(new Insets(0, 0, 0, 0));
			button2Outro2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro2.setBounds(185, 0, 53, 60);
			button2Outro2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[1].getQuantidade() > clicaOutro[1]){
						clicaOutro[1]++;
						textAreaOutro[1].setText(clicaOutro[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro2.add(button2Outro2);
			
			textAreaOutro[1] = new JTextArea();
			textAreaOutro[1].setEditable(false);
			textAreaOutro[1].setText(clicaOutro[1] + "");
			textAreaOutro[1].setBackground(SystemColor.window);
			textAreaOutro[1].setBounds(113, 38, 16, 16);
			panelOutro2.add(textAreaOutro[1]);
		}
		
		
		
		///// 			OUTRO 3			//////
		if(estoque.quantOutros >= 3){
			JPanel panelOutro3 = new JPanel();
			panelOutro3.setBackground(SystemColor.window);
			panelOutro3.setLayout(null);
			panelOutro3.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro3.setBounds(6, 187, 238, 60);
			panelOutros.add(panelOutro3);
			
			JButton button1Outro3 = new JButton("-");
			button1Outro3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro3.setBounds(0, 0, 53, 60);
			button1Outro3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[2] > 0){
						clicaOutro[2]--;
						textAreaOutro[2].setText(clicaOutro[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro3.add(button1Outro3);
			
			JLabel labelOutro3 = new JLabel("M - " + estoque.outros[2].getNome());
			labelOutro3.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro3.setBounds(49, 12, 140, 20);
			panelOutro3.add(labelOutro3);
			
			JButton button2Outro3 = new JButton("+");
			button2Outro3.setMargin(new Insets(0, 0, 0, 0));
			button2Outro3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro3.setBounds(185, 0, 53, 60);
			button2Outro3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[2].getQuantidade() > clicaOutro[2]){
						clicaOutro[2]++;
						textAreaOutro[2].setText(clicaOutro[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button2Outro3.setBounds(185, 0, 53, 60);
			panelOutro3.add(button2Outro3);
			
			textAreaOutro[2] = new JTextArea();
			textAreaOutro[2].setEditable(false);
			textAreaOutro[2].setText(clicaOutro[2] + "");
			textAreaOutro[2].setBackground(SystemColor.window);
			textAreaOutro[2].setBounds(113, 38, 16, 16);
			panelOutro3.add(textAreaOutro[2]);
		}
		
		
		
		///// 			OUTRO 4			//////
		if(estoque.quantOutros >= 4){
			JPanel panelOutro4 = new JPanel();
			panelOutro4.setBackground(SystemColor.window);
			panelOutro4.setLayout(null);
			panelOutro4.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro4.setBounds(6, 259, 238, 60);
			panelOutros.add(panelOutro4);
			
			JButton button1Outro4 = new JButton("-");
			button1Outro4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro4.setBounds(0, 0, 53, 60);
			button1Outro4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[3] > 0){
						clicaOutro[3]--;
						textAreaOutro[3].setText(clicaOutro[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro4.add(button1Outro4);
			
			JLabel labelOutro4 = new JLabel("I - " + estoque.outros[3].getNome());
			labelOutro4.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro4.setBounds(49, 12, 140, 20);
			panelOutro4.add(labelOutro4);
			
			JButton button2Outro4 = new JButton("+");
			button2Outro4.setMargin(new Insets(0, 0, 0, 0));
			button2Outro4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro4.setBounds(185, 0, 53, 60);
			button2Outro4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[3].getQuantidade() > clicaOutro[3]){
						clicaOutro[3]++;
						textAreaOutro[3].setText(clicaOutro[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro4.add(button2Outro4);
			
			textAreaOutro[3] = new JTextArea();
			textAreaOutro[3].setEditable(false);
			textAreaOutro[3].setText(clicaOutro[3] + "");
			textAreaOutro[3].setBackground(SystemColor.window);
			textAreaOutro[3].setBounds(113, 38, 16, 16);
			panelOutro4.add(textAreaOutro[3]);
		}
		
		
		
		///// 			OUTRO 5			//////
		if(estoque.quantOutros >= 5){
			JPanel panelOutro5 = new JPanel();
			panelOutro5.setBackground(SystemColor.window);
			panelOutro5.setLayout(null);
			panelOutro5.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro5.setBounds(6, 331, 238, 60);
			panelOutros.add(panelOutro5);
			
			JButton button1Outro5 = new JButton("-");
			button1Outro5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro5.setBounds(0, 0, 53, 60);
			button1Outro5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[4] > 0){
						clicaOutro[4]--;
						textAreaOutro[4].setText(clicaOutro[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro5.add(button1Outro5);
			
			JLabel labelOutro5 = new JLabel("K - " + estoque.outros[4].getNome());
			labelOutro5.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro5.setBounds(49, 12, 140, 20);
			panelOutro5.add(labelOutro5);
			
			JButton button2Outro5 = new JButton("+");
			button2Outro5.setMargin(new Insets(0, 0, 0, 0));
			button2Outro5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro5.setBounds(185, 0, 53, 60);
			button2Outro5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[4].getQuantidade() > clicaOutro[4]){
						clicaOutro[4]++;
						textAreaOutro[4].setText(clicaOutro[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button2Outro5.setBounds(185, 0, 53, 60);
			panelOutro5.add(button2Outro5);
			
			textAreaOutro[4] = new JTextArea();
			textAreaOutro[4].setEditable(false);
			textAreaOutro[4].setText(clicaOutro[4] + "");
			textAreaOutro[4].setBackground(SystemColor.window);
			textAreaOutro[4].setBounds(113, 38, 16, 16);
			panelOutro5.add(textAreaOutro[4]);
		}
		
		
		
		///// 			OUTRO 6			//////
		if(estoque.quantOutros >= 6){
			JPanel panelOutro6 = new JPanel();
			panelOutro6.setBackground(SystemColor.window);
			panelOutro6.setLayout(null);
			panelOutro6.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro6.setBounds(6, 403, 238, 60);
			panelOutros.add(panelOutro6);
			
			JButton button1Outro6 = new JButton("-");
			button1Outro6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro6.setBounds(0, 0, 53, 60);
			button1Outro6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[5] > 0){
						clicaOutro[5]--;
						textAreaOutro[5].setText(clicaOutro[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro6.add(button1Outro6);
			
			JLabel labelOutro6 = new JLabel("O - " + estoque.outros[5].getNome());
			labelOutro6.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro6.setBounds(49, 12, 140, 20);
			panelOutro6.add(labelOutro6);
			
			JButton button2Outro6 = new JButton("+");
			button2Outro6.setMargin(new Insets(0, 0, 0, 0));
			button2Outro6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro6.setBounds(185, 0, 53, 60);
			button2Outro6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[5].getQuantidade() > clicaOutro[5]){
						clicaOutro[5]++;
						textAreaOutro[5].setText(clicaOutro[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro6.add(button2Outro6);
			
			textAreaOutro[5] = new JTextArea();
			textAreaOutro[5].setEditable(false);
			textAreaOutro[5].setText(clicaOutro[5] + "");
			textAreaOutro[5].setBackground(SystemColor.window);
			textAreaOutro[5].setBounds(113, 38, 16, 16);
			panelOutro6.add(textAreaOutro[5]);
		}
		
		
		
		///// 			OUTRO 7			//////
		if(estoque.quantOutros >= 7){
			JPanel panelOutro7 = new JPanel();
			panelOutro7.setBackground(SystemColor.window);
			panelOutro7.setLayout(null);
			panelOutro7.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro7.setBounds(6, 475, 238, 60);
			panelOutros.add(panelOutro7);
			
			JButton button1Outro7 = new JButton("-");
			button1Outro7.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro7.setBounds(0, 0, 53, 60);
			button1Outro7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[6] > 0){
						clicaOutro[6]--;
						textAreaOutro[6].setText(clicaOutro[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro7.add(button1Outro7);
			
			JLabel labelOutro7 = new JLabel("L - " + estoque.outros[6].getNome());
			labelOutro7.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro7.setBounds(49, 12, 140, 20);
			panelOutro7.add(labelOutro7);
			
			JButton button2Outro7 = new JButton("+");
			button2Outro7.setMargin(new Insets(0, 0, 0, 0));
			button2Outro7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro7.setBounds(185, 0, 53, 60);
			button2Outro7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[6].getQuantidade() > clicaOutro[6]){
						clicaOutro[6]++;
						textAreaOutro[6].setText(clicaOutro[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro7.add(button2Outro7);
			
			textAreaOutro[6] = new JTextArea();
			textAreaOutro[6].setEditable(false);
			textAreaOutro[6].setText(clicaOutro[6] + "");
			textAreaOutro[6].setBackground(SystemColor.window);
			textAreaOutro[6].setBounds(113, 38, 16, 16);
			panelOutro7.add(textAreaOutro[6]);
		}
		
		
		
		///// 			OUTRO 8			//////
		if(estoque.quantOutros >= 8){
			JPanel panelOutro8 = new JPanel();
			panelOutro8.setBackground(SystemColor.window);
			panelOutro8.setLayout(null);
			panelOutro8.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro8.setBounds(6, 547, 238, 60);
			panelOutros.add(panelOutro8);
			
			JButton button1Outro8 = new JButton("-");
			button1Outro8.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro8.setBounds(0, 0, 53, 60);
			button1Outro8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[7] > 0){
						clicaOutro[7]--;
						textAreaOutro[7].setText(clicaOutro[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro8.add(button1Outro8);
			
			JLabel labelOutro8 = new JLabel("P - " + estoque.outros[7].getNome());
			labelOutro8.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro8.setBounds(49, 12, 140, 20);
			panelOutro8.add(labelOutro8);
			
			JButton button2Outro8 = new JButton("+");
			button2Outro8.setMargin(new Insets(0, 0, 0, 0));
			button2Outro8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro8.setBounds(185, 0, 53, 60);
			button2Outro8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[7].getQuantidade() > clicaOutro[7]){
						clicaOutro[7]++;
						textAreaOutro[7].setText(clicaOutro[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro8.add(button2Outro8);
			
			textAreaOutro[7] = new JTextArea();
			textAreaOutro[7].setEditable(false);
			textAreaOutro[7].setText(clicaOutro[7] + "");
			textAreaOutro[7].setBackground(SystemColor.window);
			textAreaOutro[7].setBounds(113, 38, 16, 16);
			panelOutro8.add(textAreaOutro[7]);
		}
		
		
		
		///// 			OUTRO 9			//////
		if(estoque.quantOutros >= 9){
			JPanel panelOutro9 = new JPanel();
			panelOutro9.setLayout(null);
			panelOutro9.setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro9.setBounds(6, 619, 238, 60);
			panelOutros.add(panelOutro9);
			
			JButton button1Outro9 = new JButton("-");
			button1Outro9.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro9.setBounds(0, 0, 53, 60);
			button1Outro9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[8] > 0){
						clicaOutro[8]--;
						textAreaOutro[8].setText(clicaOutro[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro9.add(button1Outro9);
			
			JLabel labelOutro9 = new JLabel("0 - " + estoque.outros[8].getNome());
			labelOutro9.setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro9.setBounds(49, 12, 140, 20);
			panelOutro9.add(labelOutro9);
			
			JButton button2Outro9 = new JButton("+");
			button2Outro9.setMargin(new Insets(0, 0, 0, 0));
			button2Outro9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro9.setBounds(185, 0, 53, 60);
			button2Outro9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[8].getQuantidade() > clicaOutro[8]){
						clicaOutro[8]++;
						textAreaOutro[8].setText(clicaOutro[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro9.add(button2Outro9);
			
			textAreaOutro[8] = new JTextArea();
			textAreaOutro[8].setEditable(false);
			textAreaOutro[8].setText(clicaOutro[8] + "");
			textAreaOutro[8].setBackground(SystemColor.window);
			textAreaOutro[8].setBounds(113, 38, 16, 16);
			panelOutro9.add(textAreaOutro[8]);
		}
		
		
		
		///// 			PAINEL PEDIDO			//////
		JPanel panelPedido = new JPanel();
		panelPedido.setBackground(SystemColor.window);
		panelPedido.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPedido.setBounds(1056, 6, 182, 350);
		contentPane.add(panelPedido);
		panelPedido.setLayout(new BorderLayout(0, 0));
		
		textAreaPedidos = new JTextArea();
		textAreaPedidos.setEditable(false);
		textAreaPedidos.setText("Pedido:\n");
		JScrollPane scrollbar = new JScrollPane(textAreaPedidos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		focusContentPane();
		panelPedido.add(scrollbar);
		
		
		///// 			PAINEL FINALIZA			//////
		JPanel panelFinaliza = new JPanel();
		panelFinaliza.setBackground(SystemColor.window);
		panelFinaliza.setBorder(new LineBorder(Color.BLACK));
		panelFinaliza.setBounds(1056, 365, 182, 127);
		contentPane.add(panelFinaliza);
		panelFinaliza.setLayout(null);
		
		///// 			BOTAO CONCLUI			//////
		JButton buttonConcluir = new JButton("Concluir");
		buttonConcluir.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		buttonConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < estoque.quantBebidas; i++){
					estoque.bebidas[i].vendeProduto(clicaBebida[i]);
					clicaBebida[i] = 0;
					textAreaBebida[i].setText(clicaBebida[i] + "");
				}
				for(int i = 0; i < estoque.quantSnacks; i++){
					estoque.snacks[i].vendeProduto(clicaSnack[i]);
					clicaSnack[i] = 0;
					textAreaSnack[i].setText(clicaSnack[i] + "");
				}
				for(int i = 0; i < estoque.quantOutros; i++){
					estoque.outros[i].vendeProduto(clicaOutro[i]);
					clicaOutro[i] = 0;
					textAreaOutro[i].setText(clicaOutro[i] + "");
				}
				System.out.println(pedidoCompleto);
				limpaTela = 1;
				mostraPedido();
				limpaTela = 0;
				estoque.vendeEstoque();
				focusContentPane();
			}
		});
		buttonConcluir.setBounds(6, 6, 172, 59);
		panelFinaliza.add(buttonConcluir);
		
		///// 			BOTAO CANCELA			//////
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(6, 77, 172, 42);
		buttonCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < estoque.quantBebidas; i++){
					clicaBebida[i] = 0;
					textAreaBebida[i].setText(clicaBebida[i] + "");
				}
				for(int i = 0; i < estoque.quantSnacks; i++){
					clicaSnack[i] = 0;
					textAreaSnack[i].setText(clicaSnack[i] + "");
				}
				for(int i = 0; i < estoque.quantOutros; i++){
					clicaOutro[i] = 0;
					textAreaOutro[i].setText(clicaOutro[i] + "");
				}
				limpaTela = 1;
				mostraPedido();
				limpaTela = 0;
				focusContentPane();
			}
		});
		panelFinaliza.add(buttonCancelar);
		
		
		
		///// 			PAINEL MUDANCAS			//////
		JPanel panelMudancas = new JPanel();
		panelMudancas.setLayout(null);
		panelMudancas.setBackground(SystemColor.window);
		panelMudancas.setBorder(new LineBorder(Color.BLACK));
		panelMudancas.setBounds(1056, 500, 182, 196);
		contentPane.add(panelMudancas);
		
		
		
		///// 			BOTAO REESTOQUE			//////
		JButton buttonReestoque = new JButton("Reestoque");
		buttonReestoque.setBounds(6, 0, 170, 51);
		buttonReestoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reestoque = new Reestoque(estoque);
				reestoque.reestocar(estoque);
				focusContentPane();
			}
		});
		panelMudancas.add(buttonReestoque);
		
		
		
		///// 			BOTAO VER ESTOQUE			//////
		JButton buttonVerEstoque = new JButton("Verifica Estoque");
		buttonVerEstoque.setBounds(6, 49, 170, 36);
		buttonVerEstoque.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void mouseClicked(MouseEvent e) {
				JPanel frame = new JPanel();
				JList list = new JList();
				
				DefaultListModel listModel = new DefaultListModel();
				String temp = new String();
				int verificador = 0;
				
				listModel.addElement("Bebidas:");
				for(int a = 0; a < estoque.quantBebidas; a++){
					temp = (estoque.bebidas[a].getQuantidade() + " " + estoque.bebidas[a].getNome());
					listModel.addElement(temp);
				}
				if(estoque.quantBebidas <= 7){
					verificador = (7 - estoque.quantBebidas);
				}
				else if(estoque.quantBebidas <= 9){
					verificador = (15 - estoque.quantBebidas);
				}
				for(int a = 0; a < verificador; a++){
					listModel.addElement("\n");
				}
				
				listModel.addElement("Snacks:");
				for(int a = 0; a < estoque.quantSnacks; a++){
					temp = (estoque.snacks[a].getQuantidade() + " " +  estoque.snacks[a].getNome());
					listModel.addElement(temp);
				}
				if(estoque.quantSnacks <= 7){
					verificador = (7 - estoque.quantSnacks);
				}
				else if(estoque.quantSnacks <= 15){
					verificador = (15 - estoque.quantSnacks);
				}
				else if(estoque.quantSnacks <= 23){
					verificador = (23 - estoque.quantSnacks);
				}
				for(int a = 0; a < verificador; a++){
					listModel.addElement("\n");
				}
				
				listModel.addElement("Outros:");
				for(int a = 0; a < estoque.quantOutros; a++){
					temp = (estoque.outros[a].getQuantidade() + " " +  estoque.outros[a].getNome());
					listModel.addElement(temp);
				}
				
				list = new JList(listModel);
				
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.VERTICAL_WRAP);				
				JOptionPane.showMessageDialog(frame ,list, "Estoque", JOptionPane.PLAIN_MESSAGE);
				focusContentPane();
				
			}
		});
		panelMudancas.add(buttonVerEstoque);
		
		
		
		///// 			BOTAO MUDAPRECO			//////
		JButton buttonMudaPreco = new JButton("Muda Preços");
		buttonMudaPreco.setBounds(6, 97, 172, 30);
		buttonMudaPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudaPreco = new MudaPreco(estoque);
				mudaPreco.mudarPreco(estoque);
				focusContentPane();
			}
		});
		panelMudancas.add(buttonMudaPreco);
		
		
		
		///// 			BOTAO ADICIONA			//////
		JButton buttonAdiciona = new JButton("Adiciona Produto");
		buttonAdiciona.setBounds(6, 128, 172, 30);
		buttonAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionaProduto = new AdicionaProduto(estoque);
				adicionaProduto.adicionarProduto(estoque);
				focusContentPane();
			}
		});
		panelMudancas.add(buttonAdiciona);
		
		
		///// 			BOTAO REMOVE			//////
		JButton buttonRemoveProduto = new JButton("Remove Produto");
		buttonRemoveProduto.setBounds(6, 160, 172, 30);
		buttonRemoveProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				focusContentPane();
			}
		});
		panelMudancas.add(buttonRemoveProduto);
		
		///// 			KEYLISTENERS			//////
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(estoque.quantBebidas >= 1){
					if(estoque.bebidas[0].getQuantidade() > clicaBebida[0]
							&& e.getKeyChar() == '1'){
						clicaBebida[0]++;
						textAreaBebida[0].setText(clicaBebida[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 2){
					if(estoque.bebidas[1].getQuantidade() > clicaBebida[1]
							&& e.getKeyChar() == '2'){
						clicaBebida[1]++;
						textAreaBebida[1].setText(clicaBebida[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 3){
					if(estoque.bebidas[2].getQuantidade() > clicaBebida[2]
							&& e.getKeyChar() == '3'){
						clicaBebida[2]++;
						textAreaBebida[2].setText(clicaBebida[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 4){
					if(estoque.bebidas[3].getQuantidade() > clicaBebida[3]
							&& e.getKeyChar() == '4'){
						clicaBebida[3]++;
						textAreaBebida[3].setText(clicaBebida[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 5){
					if(estoque.bebidas[4].getQuantidade() > clicaBebida[4]
							&& e.getKeyChar() == '5'){
						clicaBebida[4]++;
						textAreaBebida[4].setText(clicaBebida[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 6){
					if(estoque.bebidas[5].getQuantidade() > clicaBebida[5]
							&& e.getKeyChar() == '6'){
						clicaBebida[5]++;
						textAreaBebida[5].setText(clicaBebida[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 7){
					if(estoque.bebidas[6].getQuantidade() > clicaBebida[6]
							&& e.getKeyChar() == '7'){
						clicaBebida[6]++;
						textAreaBebida[6].setText(clicaBebida[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 8){
					if(estoque.bebidas[7].getQuantidade() > clicaBebida[7]
							&& e.getKeyChar() == '8'){
						clicaBebida[7]++;
						textAreaBebida[7].setText(clicaBebida[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantBebidas >= 9){
					if(estoque.bebidas[8].getQuantidade() > clicaBebida[8]
							&& e.getKeyChar() == '9'){
						clicaBebida[8]++;
						textAreaBebida[8].setText(clicaBebida[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 1){
					if(estoque.snacks[0].getQuantidade() > clicaSnack[0]
							&& e.getKeyChar() == 'q'){
						clicaSnack[0]++;
						textAreaSnack[0].setText(clicaSnack[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 2){
					if(estoque.snacks[1].getQuantidade() > clicaSnack[1]
							&& e.getKeyChar() == 'a'){
						clicaSnack[1]++;
						textAreaSnack[1].setText(clicaSnack[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 3){
					if(estoque.snacks[2].getQuantidade() > clicaSnack[2]
							&& e.getKeyChar() == 'z'){
						clicaSnack[2]++;
						textAreaSnack[2].setText(clicaSnack[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 4){
					if(estoque.snacks[3].getQuantidade() > clicaSnack[3]
							&& e.getKeyChar() == 'w'){
						clicaSnack[3]++;
						textAreaSnack[3].setText(clicaSnack[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 5){
					if(estoque.snacks[4].getQuantidade() > clicaSnack[4]
							&& e.getKeyChar() == 's'){
						clicaSnack[4]++;
						textAreaSnack[4].setText(clicaSnack[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 6){
					if(estoque.snacks[5].getQuantidade() > clicaSnack[5]
							&& e.getKeyChar() == 'x'){
						clicaSnack[5]++;
						textAreaSnack[5].setText(clicaSnack[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 7){
					if(estoque.snacks[6].getQuantidade() > clicaSnack[6]
							&& e.getKeyChar() == 'e'){
						clicaSnack[6]++;
						textAreaSnack[6].setText(clicaSnack[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 8){
					if(estoque.snacks[7].getQuantidade() > clicaSnack[7]
							&& e.getKeyChar() == 'd'){
						clicaSnack[7]++;
						textAreaSnack[7].setText(clicaSnack[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 9){
					if(estoque.snacks[8].getQuantidade() > clicaSnack[8]
							&& e.getKeyChar() == 'c'){
						clicaSnack[8]++;
						textAreaSnack[8].setText(clicaSnack[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 10){
					if(estoque.snacks[9].getQuantidade() > clicaSnack[9]
							&& e.getKeyChar() == 'r'){
						clicaSnack[9]++;
						textAreaSnack[9].setText(clicaSnack[9] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 11){
					if(estoque.snacks[10].getQuantidade() > clicaSnack[10]
							&& e.getKeyChar() == 'f'){
						clicaSnack[10]++;
						textAreaSnack[10].setText(clicaSnack[10] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 12){
					if(estoque.snacks[11].getQuantidade() > clicaSnack[11]
							&& e.getKeyChar() == 'v'){
						clicaSnack[11]++;
						textAreaSnack[11].setText(clicaSnack[11] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 13){
					if(estoque.snacks[12].getQuantidade() > clicaSnack[12]
							&& e.getKeyChar() == 't'){
						clicaSnack[12]++;
						textAreaSnack[12].setText(clicaSnack[12] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 14){
					if(estoque.snacks[13].getQuantidade() > clicaSnack[13]
							&& e.getKeyChar() == 'g'){
						clicaSnack[13]++;
						textAreaSnack[13].setText(clicaSnack[13] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 15){
					if(estoque.snacks[14].getQuantidade() > clicaSnack[14]
							&& e.getKeyChar() == 'b'){
						clicaSnack[14]++;
						textAreaSnack[14].setText(clicaSnack[14] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 16){
					if(estoque.snacks[15].getQuantidade() > clicaSnack[15]
							&& e.getKeyChar() == 'y'){
						clicaSnack[15]++;
						textAreaSnack[15].setText(clicaSnack[15] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 17){
					if(estoque.snacks[16].getQuantidade() > clicaSnack[16]
							&& e.getKeyChar() == 'h'){
						clicaSnack[16]++;
						textAreaSnack[16].setText(clicaSnack[16] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantSnacks >= 18){
					if(estoque.snacks[1].getQuantidade() > clicaSnack[1]
							&& e.getKeyChar() == 'n'){
						clicaSnack[1]++;
						textAreaSnack[1].setText(clicaSnack[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 1){
					if(estoque.outros[0].getQuantidade() > clicaOutro[0]
							&& e.getKeyChar() == 'u'){
						clicaOutro[0]++;
						textAreaOutro[0].setText(clicaOutro[0] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 2){
					if(estoque.outros[1].getQuantidade() > clicaOutro[1]
							&& e.getKeyChar() == 'j'){
						clicaOutro[1]++;
						textAreaOutro[1].setText(clicaOutro[1] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 3){
					if(estoque.outros[2].getQuantidade() > clicaOutro[2]
							&& e.getKeyChar() == 'm'){
						clicaOutro[2]++;
						textAreaOutro[2].setText(clicaOutro[2] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 4){
					if(estoque.outros[3].getQuantidade() > clicaOutro[3]
							&& e.getKeyChar() == 'i'){
						clicaOutro[3]++;
						textAreaOutro[3].setText(clicaOutro[3] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 5){
					if(estoque.outros[4].getQuantidade() > clicaOutro[4]
							&& e.getKeyChar() == 'k'){
						clicaOutro[4]++;
						textAreaOutro[4].setText(clicaOutro[4] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 6){
					if(estoque.outros[5].getQuantidade() > clicaOutro[5]
							&& e.getKeyChar() == 'o'){
						clicaOutro[5]++;
						textAreaOutro[5].setText(clicaOutro[5] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 7){
					if(estoque.outros[6].getQuantidade() > clicaOutro[6]
							&& e.getKeyChar() == 'l'){
						clicaOutro[6]++;
						textAreaOutro[6].setText(clicaOutro[6] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 8){
					if(estoque.outros[7].getQuantidade() > clicaOutro[7]
							&& e.getKeyChar() == 'p'){
						clicaOutro[7]++;
						textAreaOutro[7].setText(clicaOutro[7] + "");
						mostraPedido();
						focusContentPane();
					}
				}
				if(estoque.quantOutros >= 9){
					if(estoque.outros[8].getQuantidade() > clicaOutro[8]
							&& e.getKeyChar() == '0'){
						clicaOutro[8]++;
						textAreaOutro[8].setText(clicaOutro[8] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			}
		});
	}
	
	public void focusContentPane(){
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		contentPane.requestFocusInWindow();
	}
	
	public void mostraPedido(){
		textAreaPedidos.setText("Pedido:\n");
		precoTotal = 0;
		for(int i = 0; i < estoque.quantBebidas; i++){
			if(clicaBebida[i] > 0 && !(estoque.bebidas[i].getNome().endsWith("s") || estoque.bebidas[i].getNome().endsWith("m"))){
				pluralidade = (clicaBebida[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaBebida[i] + " " + estoque.bebidas[i].getNome() + pluralidade + 
						" - R$ " + clicaBebida[i]*estoque.bebidas[i].getPreco()+ "\n");
				precoTotal +=  clicaBebida[i]*estoque.bebidas[i].getPreco();
			}
			else if(clicaBebida[i] > 0 && (estoque.bebidas[i].getNome().endsWith("s"))){
				textAreaPedidos.append(clicaBebida[i] + " " + estoque.bebidas[i].getNome() + 
						" - R$ " + clicaBebida[i]*estoque.bebidas[i].getPreco()+ "\n");
				precoTotal +=  clicaBebida[i]*estoque.bebidas[i].getPreco();
			}
			else if(clicaBebida[i] > 0 && (estoque.bebidas[i].getNome().endsWith("m"))){
				pluralidade = (clicaBebida[i] > 1 ? "ns" : "m");
				textAreaPedidos.append(clicaBebida[i] + " " +  estoque.bebidas[i].getNome().substring(0, estoque.bebidas[i].getNome().length()-1) +
						pluralidade + " - R$ " + clicaBebida[i]*estoque.bebidas[i].getPreco()+ "\n");
				precoTotal +=  clicaBebida[i]*estoque.bebidas[i].getPreco();
			}
		}
		
		for(int i = 0; i < estoque.quantSnacks; i++){
			if(clicaSnack[i] > 0 && !(estoque.snacks[i].getNome().endsWith("s") || estoque.snacks[i].getNome().endsWith("m"))){
				pluralidade = (clicaSnack[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaSnack[i] + " " + estoque.snacks[i].getNome() + pluralidade + 
						" - R$ " + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
				precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
			}
			else if(clicaSnack[i] > 0 && (estoque.snacks[i].getNome().endsWith("s"))){
				textAreaPedidos.append(clicaSnack[i] + " " + estoque.snacks[i].getNome() + 
						" - R$ " + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
				precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
			}
			else if(clicaSnack[i] > 0 && (estoque.snacks[i].getNome().endsWith("m"))){
				pluralidade = (clicaSnack[i] > 1 ? "ns" : "m");
				textAreaPedidos.append(clicaSnack[i] + " " +  estoque.snacks[i].getNome().substring(0, estoque.snacks[i].getNome().length()-1) +
						pluralidade + " - R$ " + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
				precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
			}
		}
		
		for(int i = 0; i < estoque.quantOutros; i++){
			if(clicaOutro[i] > 0 && !(estoque.outros[i].getNome().endsWith("s") || estoque.outros[i].getNome().endsWith("m"))){
				pluralidade = (clicaOutro[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaOutro[i] + " " + estoque.outros[i].getNome() + pluralidade + 
						" - R$ " + clicaOutro[i]*estoque.outros[i].getPreco()+ "\n");
				precoTotal +=  clicaOutro[i]*estoque.outros[i].getPreco();
			}
			else if(clicaOutro[i] > 0 && (estoque.outros[i].getNome().endsWith("s"))){
				textAreaPedidos.append(clicaOutro[i] + " " + estoque.outros[i].getNome() + 
						" - R$ " + clicaOutro[i]*estoque.outros[i].getPreco()+ "\n");
				precoTotal +=  clicaOutro[i]*estoque.outros[i].getPreco();
			}
			else if(clicaOutro[i] > 0 && (estoque.outros[i].getNome().endsWith("m"))){
				pluralidade = (clicaOutro[i] > 1 ? "ns" : "m");
				textAreaPedidos.append(clicaOutro[i] + " " +  estoque.outros[i].getNome().substring(0, estoque.outros[i].getNome().length()-1) +
						pluralidade + " - R$ " + clicaOutro[i]*estoque.outros[i].getPreco()+ "\n");
				precoTotal +=  clicaOutro[i]*estoque.outros[i].getPreco();
			}
		}
		
		if(limpaTela == 0 && precoTotal != 0){
			textAreaPedidos.append("Total: R$ " + precoTotal);
		}
		
		pedidoCompleto = textAreaPedidos.getText();
	}
}
