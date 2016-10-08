package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import basico.Estoque;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cleaner extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Estoque estoque = new Estoque();
	int a = 0;

	int[] clicaBebida = new int[7];	
	int[] clicaSnack = new int[7];
	int[] clicaOutro = new int[7];
	
	JPanel[] panelBebida = new JPanel[7];
	JButton[] button1Bebida = new JButton[7];
	JLabel[] labelBebida = new JLabel[7];
	JButton[] button2Bebida = new JButton[7];
	
	JPanel[] panelSnack = new JPanel[7];
	JButton[] button1Snack = new JButton[7];
	JLabel[] labelSnack = new JLabel[7];
	JButton[] button2Snack = new JButton[7];
	
	JPanel[] panelOutro = new JPanel[7];
	JButton[] button1Outro = new JButton[7];
	JLabel[] labelOutro = new JLabel[7];
	JButton[] button2Outro = new JButton[7];
	
	JTextArea[] textAreaBebida = new JTextArea[7];
	JTextArea[] textAreaSnack = new JTextArea[7];
	JTextArea[] textAreaOutro = new JTextArea[7];
	JTextArea textAreaPedidos;

	
	private JPanel contentPane;
	//private JDialog verificaVenda;
	//private JDialog verificaEstoque;
	
	double precoTotal = 0;
	int limpaTela = 0;
	String pluralidade;

	static String filePath;
	static File randomFile;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Date time = new Date();
		SimpleDateFormat formated = 
				new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.E");
		randomFile = new File("Produtos."+ formated.format(time) + ".txt");
		try{
			randomFile.createNewFile();
			filePath = randomFile.getCanonicalPath();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cleaner frame = new Cleaner();
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
	public Cleaner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 780);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setTitle("Interface Vendas CAEC - versão (0.0.2.0.0)");
		
		for(int i = 0; i < 7; i++){
			clicaBebida[i] = 0;
			clicaSnack[i] = 0;
			clicaOutro[i] = 0;
		}
		
		///// 			PAINEL BEBIDAS			//////
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBorder(new LineBorder(Color.BLACK));
		panelBebidas.setBounds(6, 6, 250, 730);
		contentPane.add(panelBebidas);
		panelBebidas.setLayout(null);
		
		
		JLabel labelBebidas = new JLabel("Bebidas");
		labelBebidas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		labelBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		labelBebidas.setBounds(6, 6, 238, 25);
		panelBebidas.add(labelBebidas);
		
		
		
		///// 			BEBIDAS 			//////
		for (a = 0; a < 7; a++) {
			panelBebida[a] = new JPanel();
			panelBebida[a].setBorder(new LineBorder(new Color(64, 64, 64)));
			panelBebida[a].setBounds(6, (40 + 70*a), 238, 60);
			panelBebidas.add(panelBebida[0]);
			panelBebida[a].setLayout(null);
			button1Bebida[a] = new JButton("-");
			button1Bebida[a].setFont(new Font("LiSong Pro", Font.PLAIN, 20));
			button1Bebida[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[a] > 0){
						clicaBebida[a]--;
						textAreaBebida[a].setText(clicaBebida[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button1Bebida[a].setBounds(6, 7, 47, 47);
			panelBebida[a].add(button1Bebida[a]);
			labelBebida[a] = new JLabel((a+1) + " - " + estoque.bebidas[a].getNome());
			labelBebida[a].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[a].setBounds(49, 12, 140, 20);
			panelBebida[a].add(labelBebida[a]);
			labelBebida[a].setHorizontalAlignment(SwingConstants.CENTER);
			button2Bebida[a] = new JButton("+");
			button2Bebida[a].setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			button2Bebida[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[a].getQuantidade() > clicaBebida[a]){
						clicaBebida[a]++;
						textAreaBebida[a].setText(clicaBebida[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button2Bebida[a].setBounds(185, 7, 47, 47);
			panelBebida[a].add(button2Bebida[a]);
			textAreaBebida[a] = new JTextArea();
			textAreaBebida[a].setEditable(false);
			textAreaBebida[a].setText(clicaBebida[a] + "");
			textAreaBebida[a].setBackground(SystemColor.window);
			textAreaBebida[a].setBounds(113, 38, 16, 16);
			panelBebida[a].add(textAreaBebida[a]);
		}
		
		
		
		///// 			PAINEL SNACKS			//////
		JPanel panelSnacks = new JPanel();
		panelSnacks.setLayout(null);
		panelSnacks.setBorder(new LineBorder(Color.BLACK));
		panelSnacks.setBounds(268, 6, 250, 730);
		contentPane.add(panelSnacks);
		
		JLabel labelSnacks = new JLabel("Snacks");
		labelSnacks.setVerticalAlignment(SwingConstants.TOP);
		labelSnacks.setHorizontalAlignment(SwingConstants.CENTER);
		labelSnacks.setFont(new Font("Maven Pro", Font.PLAIN, 25));
		labelSnacks.setBounds(6, 6, 238, 25);
		panelSnacks.add(labelSnacks);
		
		
		
		///// 			SNACKS 			//////
		labelSnack[0] = new JLabel("Q - " + estoque.snacks[0].getNome());
		labelSnack[1] = new JLabel("A - " + estoque.snacks[1].getNome());
		labelSnack[2] = new JLabel("Z -  " + estoque.snacks[2].getNome());
		labelSnack[3] = new JLabel("W -  " + estoque.snacks[3].getNome());
		labelSnack[4] = new JLabel("S -  " + estoque.snacks[4].getNome());
		labelSnack[5] = new JLabel("X -  " + estoque.snacks[5].getNome());
		labelSnack[6] = new JLabel("E -  " + estoque.snacks[6].getNome());
		
		for (a = 0; a < 7; a++) {
			panelSnack[a] = new JPanel();
			panelSnack[a].setLayout(null);
			panelSnack[a].setBorder(new LineBorder(Color.DARK_GRAY));
			panelSnack[a].setBounds(6, (40 + 70*a), 238, 60);
			panelSnacks.add(panelSnack[a]);
			
			button1Snack[a] = new JButton("-");
			button1Snack[a].setFont(new Font("LiSong Pro", Font.PLAIN, 70));
			button1Snack[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[a] > 0){
						clicaSnack[a]--;
						textAreaSnack[a].setText(clicaSnack[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button1Snack[a].setBounds(6, 7, 47, 47);
			panelSnack[a].add(button1Snack[a]);
			
			labelSnack[a].setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack[a].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[a].setBounds(49, 12, 140, 20);
			panelSnack[a].add(labelSnack[a]);
			
			button2Snack[a] = new JButton("+");
			button2Snack[a].setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button2Snack[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[a].getQuantidade() > clicaSnack[a]){
						clicaSnack[a]++;
						textAreaSnack[a].setText(clicaSnack[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button2Snack[a].setBounds(185, 7, 47, 47);
			panelSnack[a].add(button2Snack[a]);
			
			textAreaSnack[a] = new JTextArea();
			textAreaSnack[a].setEditable(false);
			textAreaSnack[a].setText(clicaSnack[a] + "");
			textAreaSnack[a].setBackground(SystemColor.window);
			textAreaSnack[a].setBounds(113, 38, 16, 16);
			panelSnack[a].add(textAreaSnack[a]);
		}
		
		
		
		///// 			PAINEL OUTROS			//////
		JPanel panelOutros = new JPanel();
		panelOutros.setLayout(null);
		panelOutros.setBorder(new LineBorder(Color.BLACK));
		panelOutros.setBounds(530, 6, 250, 730);
		contentPane.add(panelOutros);
		
		JLabel labelOutros = new JLabel("Outros");
		labelOutros.setVerticalAlignment(SwingConstants.TOP);
		labelOutros.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutros.setFont(new Font("Maven Pro", Font.PLAIN, 25));
		labelOutros.setBounds(6, 6, 238, 25);
		panelOutros.add(labelOutros);
		
		
		
		///// 			OUTROS 			//////	
		//labelOutro[0] = new JLabel("R -  " + estoque.outros[0].getNome());
		
		for (a = 0; a < 7; a++) {
			panelOutro[a] = new JPanel();
			panelOutro[a].setLayout(null);
			panelOutro[a].setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro[a].setBounds(6, (40 + 70*a), 238, 60);
			panelOutros.add(panelOutro[a]);
			
			button1Outro[a] = new JButton("-");
			button1Outro[a].setFont(new Font("LiSong Pro", Font.PLAIN, 70));
			button1Outro[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[a] > 0){
						clicaOutro[a]--;
						textAreaOutro[a].setText(clicaOutro[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button1Outro[a].setBounds(6, 7, 47, 47);
			panelOutro[a].add(button1Outro[a]);
			
			labelOutro[a] = new JLabel("R -  " + estoque.outros[0].getNome());
			labelOutro[a].setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro[a].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[a].setBounds(49, 12, 140, 20);
			panelOutro[a].add(labelOutro[a]);
			
			button2Outro[a] = new JButton("+");
			button2Outro[a].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[a].getQuantidade() > clicaOutro[a]){
						clicaOutro[a]++;
						textAreaOutro[a].setText(clicaOutro[a] + "");
						atualizaPedido();
						focusContentPane();
					}
				}
			});
			button2Outro[a].setBounds(185, 7, 47, 47);
			panelOutro[a].add(button2Outro[a]);
			
			textAreaOutro[a] = new JTextArea();
			textAreaOutro[a].setEditable(false);
			textAreaOutro[a].setText("0");
			textAreaOutro[a].setBackground(SystemColor.window);
			textAreaOutro[a].setBounds(113, 38, 16, 16);
			panelOutro[a].add(textAreaOutro[a]);
		}
		
		
		
		///// 			PAINEL PEDIDO			//////
		JPanel panelPedido = new JPanel();
		panelPedido.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPedido.setBounds(792, 6, 182, 106);
		contentPane.add(panelPedido);
		panelPedido.setLayout(new BorderLayout(0, 0));
		
		textAreaPedidos = new JTextArea();
		textAreaPedidos.setEditable(false);
		textAreaPedidos.setText("Pedido:\n");
		JScrollPane scrollbar = new JScrollPane(textAreaPedidos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelPedido.add(scrollbar);
		
		
		
		///// 			PAINEL FINALIZA			//////
		JPanel panelFinaliza = new JPanel();
		panelFinaliza.setBorder(new LineBorder(Color.BLACK));
		panelFinaliza.setBounds(792, 124, 182, 127);
		contentPane.add(panelFinaliza);
		panelFinaliza.setLayout(null);
		
		JButton buttonConcluir = new JButton("Concluir");
		buttonConcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 7; i++){
					estoque.bebidas[i].vendeProduto(clicaBebida[i]);
					estoque.snacks[i].vendeProduto(clicaSnack[i]);
					estoque.outros[i].vendeProduto(clicaOutro[i]);
					clicaBebida[i] = 0;
					clicaSnack[i] = 0;
					clicaOutro[i] = 0;
					limpaTela = 1;
					atualizaPedido();
					
					limpaTela = 0;
					textAreaBebida[i].setText(clicaBebida[i] + "");
					textAreaSnack[i].setText(clicaSnack[i] + "");
					textAreaOutro[i].setText(clicaOutro[i] + "");
					focusContentPane();
				}
			}
		});
		buttonConcluir.setBounds(6, 6, 172, 59);
		panelFinaliza.add(buttonConcluir);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 7; i++){
					clicaBebida[i] = 0;
					clicaSnack[i] = 0;
					clicaOutro[i] = 0;
					limpaTela = 1;
					atualizaPedido();
					limpaTela = 0;
					for(int a = 0; a < 7; a++){
						textAreaBebida[a].setText(clicaBebida[a] + "");
						textAreaSnack[a].setText(clicaSnack[a] + "");
						textAreaOutro[a].setText(clicaOutro[a] + "");
					}
					focusContentPane();
				}
			}
		});
		buttonCancelar.setBounds(6, 77, 172, 42);
		panelFinaliza.add(buttonCancelar);
		
		
		
		///// 			PAINEL MUDANCAS			//////
		JPanel panelMudancas = new JPanel();
		panelMudancas.setBorder(new LineBorder(Color.BLACK));
		panelMudancas.setBounds(792, 388, 182, 164);
		contentPane.add(panelMudancas);
		panelMudancas.setLayout(null);
		
		JButton buttonRelatorio = new JButton("Gera Relatórios");
		buttonRelatorio.setBounds(6, 6, 172, 29);
		panelMudancas.add(buttonRelatorio);
		
		JButton buttonMudaPreco = new JButton("Muda Preços");
		buttonMudaPreco.setBounds(6, 47, 172, 29);
		panelMudancas.add(buttonMudaPreco);
		
		JButton buttonVerifica = new JButton("Verifica Estoque");
		buttonVerifica.setBounds(6, 86, 172, 29);
		panelMudancas.add(buttonVerifica);
		
		JButton buttonReestoque = new JButton("Reestoque");
		buttonReestoque.setBounds(6, 127, 172, 29);
		panelMudancas.add(buttonReestoque);
		
		focusContentPane();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyChar() == '1' && estoque.bebidas[0].getQuantidade() > clicaBebida[0]){
					 clicaBebida[0]++;
					 textAreaBebida[0].setText(clicaBebida[0]+ "");
					 atualizaPedido();
		    	  }
				 if(e.getKeyChar() == '2' && estoque.bebidas[1].getQuantidade() > clicaBebida[1]){
					 clicaBebida[1]++;
					 textAreaBebida[1].setText(clicaBebida[1] + "");
					 atualizaPedido();
		    	  }
				 if(e.getKeyChar() == '3' && estoque.bebidas[2].getQuantidade() > clicaBebida[2]){
					 clicaBebida[2]++;
					 textAreaBebida[2].setText(clicaBebida[2] + "");
					 atualizaPedido();
		    	  }
				 if(e.getKeyChar() == '4' && estoque.bebidas[3].getQuantidade() > clicaBebida[3]){
					 clicaBebida[3]++;
					 textAreaBebida[3].setText(clicaBebida[3] + "");
					 atualizaPedido();
		    	  }
				 if(e.getKeyChar() == '5' && estoque.bebidas[4].getQuantidade() > clicaBebida[4]){
					 clicaBebida[4]++;
					 textAreaBebida[4].setText(clicaBebida[4] + "");
					 atualizaPedido();
		    	  }
				 if(e.getKeyChar() == '6' && estoque.bebidas[5].getQuantidade() > clicaBebida[5]){
					 clicaBebida[5]++;
					 textAreaBebida[5].setText(clicaBebida[5] + "");
					 atualizaPedido();
		    	  }
			}
		});
	}
	
	public void focusContentPane(){
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		contentPane.requestFocusInWindow();
	}
	
	public void atualizaPedido(){
		textAreaPedidos.setText("Pedido:\n");
		precoTotal = 0;
		for(int i = 0; i < 7; i++){
			if(clicaBebida[i] > 0 && i != 5){
				pluralidade = (clicaBebida[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaBebida[i] + " " + estoque.bebidas[i].getNome() + pluralidade + 
						" - R$ " + clicaBebida[i]*estoque.bebidas[i].getPreco()+ "\n");
				precoTotal +=  clicaBebida[i]*estoque.bebidas[i].getPreco();
			}
			else if(clicaBebida[i] > 0 && i == 5){
				textAreaPedidos.append(clicaBebida[i] + " " + estoque.bebidas[i].getNome() + 
						" - R$ " + clicaBebida[i]*estoque.bebidas[i].getPreco()+ "\n");
				precoTotal +=  clicaBebida[i]*estoque.bebidas[i].getPreco();
			}
		}
		
		for(int i = 0; i < 7; i++){
			if(clicaSnack[i] > 0 && i != 0){
				pluralidade = (clicaSnack[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaSnack[i] + " " + estoque.snacks[i].getNome() + pluralidade + 
						" - R$ " + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
				precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
			}
			else if(clicaSnack[i] > 0 && i == 0){
				if(clicaSnack[0] > 1){
					textAreaPedidos.append(clicaSnack[i] + " Amendoins - R$ " 
							 + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
					precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
				}
				else{
					textAreaPedidos.append(clicaSnack[i] + " " + estoque.snacks[i].getNome() + 
							" - R$ " + clicaSnack[i]*estoque.snacks[i].getPreco()+ "\n");
					precoTotal +=  clicaSnack[i]*estoque.snacks[i].getPreco();
				}
			}
		}
		
		for(int i = 0; i < 7; i++){
			if(clicaOutro[i] > 0){
				pluralidade = (clicaOutro[i] > 1 ? "s" : "");
				textAreaPedidos.append(clicaOutro[i] + " " + estoque.outros[i].getNome() + pluralidade + 
						" - R$ " + clicaOutro[i]*estoque.outros[i].getPreco()+ "\n");
				precoTotal +=  clicaOutro[i]*estoque.outros[i].getPreco();
			}
		}
		if(limpaTela == 0 && precoTotal != 0){
			textAreaPedidos.append("Total: R$ " + precoTotal);
		}
	}
}
