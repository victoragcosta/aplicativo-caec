package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

import javax.swing.JButton;
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
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vendas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Estoque estoque = new Estoque();

	int[] clicaBebida = new int[30];	
	int[] clicaSnack = new int[30];
	int[] clicaOutro = new int[30];
	
	private String pedidoCompleto = new String();
	
	JTextArea[] textAreaBebida = new JTextArea[30];
	JTextArea[] textAreaSnack = new JTextArea[30];
	JTextArea[] textAreaOutro = new JTextArea[30];
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
	private RemoveProduto removeProduto;
	
	
	
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
		
		

		///// 			BEBIDAS			//////
		JPanel[] panelBebida = new JPanel[estoque.quantBebidas];
		JButton[] button1Bebida = new JButton[estoque.quantBebidas];
		JLabel[] labelBebida = new JLabel[estoque.quantBebidas];
		JButton[] button2Bebida = new JButton[estoque.quantBebidas];
		for(int i = 0; i < estoque.quantBebidas;i++){
			panelBebida[i] = new JPanel();
			panelBebida[i].setBackground(SystemColor.window);
			panelBebida[i].setLayout(null);
			panelBebida[i].setBorder(new LineBorder(Color.DARK_GRAY));
			panelBebida[i].setBounds(6, 43+72*i, 238, 60);
			
			button1Bebida[i] = new JButton("-");
			button1Bebida[i].setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Bebida[i].setBounds(0, 0, 53, 60);
			final int j = i;
			contentPane.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(estoque.bebidas[j].getQuantidade() > clicaBebida[j]
							&& Integer.valueOf(e.getKeyChar())-48 == j+1 ){
						clicaBebida[j]++;
						textAreaBebida[j].setText(clicaBebida[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button1Bebida[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaBebida[j] > 0){
						clicaBebida[j]--;
						textAreaBebida[j].setText(clicaBebida[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida[i].add(button1Bebida[i]);
			
			labelBebida[i] = new JLabel((i+1)+" - " + estoque.bebidas[i].getNome());
			labelBebida[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelBebida[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[i].setBounds(49, 12, 140, 20);
			panelBebida[i].add(labelBebida[i]);
			
			button2Bebida[i] = new JButton("+");
			button2Bebida[i].setMargin(new Insets(0, 0, 0, 0));
			button2Bebida[i].setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Bebida[i].setBounds(185, 0, 53, 60);
			button2Bebida[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.bebidas[j].getQuantidade() > clicaBebida[j]){
						clicaBebida[j]++;
						textAreaBebida[j].setText(clicaBebida[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelBebida[i].add(button2Bebida[i]);
			
			textAreaBebida[i] = new JTextArea();
			textAreaBebida[i].setEditable(false);
			textAreaBebida[i].setText(clicaBebida[i] + "");
			textAreaBebida[i].setBackground(SystemColor.window);
			textAreaBebida[i].setBounds(113, 38, 16, 16);
			panelBebida[i].add(textAreaBebida[i]);
			panelBebidas.add(panelBebida[i]);
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
		

		///// 			SNACKS			//////
		JPanel[] panelSnack = new JPanel[estoque.quantSnacks];
		JButton[] button1Snack = new JButton[estoque.quantSnacks];
		JLabel[] labelSnack = new JLabel[estoque.quantSnacks];
		JButton[] button2Snack = new JButton[estoque.quantSnacks];
		for(int i = 0; i < estoque.quantSnacks; i++){
			panelSnack[i] = new JPanel();
			panelSnack[i].setBackground(SystemColor.window);
			panelSnack[i].setLayout(null);
			panelSnack[i].setBorder(new LineBorder(Color.DARK_GRAY));
			
			button1Snack[i] = new JButton("-");
			button1Snack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Snack[i].setBounds(0, 0, 53, 60);
			final int j = i;
			contentPane.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(estoque.snacks[j].getQuantidade() > clicaSnack[j]
							&& Integer.valueOf(e.getKeyChar())-97 == j ){
						clicaSnack[j]++;
						textAreaSnack[j].setText(clicaSnack[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button1Snack[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaSnack[j] > 0){
						clicaSnack[j]--;
						textAreaSnack[j].setText(clicaSnack[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack[i].add(button1Snack[i]);
			
			labelSnack[i] = new JLabel((char)(i+97)+" - " + estoque.snacks[i].getNome());
			labelSnack[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelSnack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[i].setBounds(49, 12, 140, 20);
			panelSnack[i].add(labelSnack[i]);
			
			button2Snack[i] = new JButton("+");
			button2Snack[i].setMargin(new Insets(0, 0, 0, 0));
			button2Snack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Snack[i].setBounds(185, 0, 53, 60);
			button2Snack[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.snacks[j].getQuantidade() > clicaSnack[j]){
						clicaSnack[j]++;
						textAreaSnack[j].setText(clicaSnack[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelSnack[i].add(button2Snack[i]);
			
			textAreaSnack[i] = new JTextArea();
			textAreaSnack[i].setEditable(false);
			textAreaSnack[i].setText(clicaSnack[i] + "");
			textAreaSnack[i].setBackground(SystemColor.window);
			textAreaSnack[i].setBounds(113, 38, 16, 16);
			panelSnack[i].add(textAreaSnack[i]);
			if(i<9){
				panelSnack[i].setBounds(6, 43+72*i, 238, 60);
				panelSnacks.add(panelSnack[i]);
			}else{
				panelSnack[i].setBounds(6, 43+72*(i-9), 238, 60);
				panel2Snacks.add(panelSnack[i]);
			}
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
		
		

		JPanel[] panelOutro = new JPanel[estoque.quantOutros];
		JButton[] button1Outro = new JButton[estoque.quantOutros];
		JLabel[] labelOutro = new JLabel[estoque.quantOutros];
		JButton[] button2Outro = new JButton[estoque.quantOutros];
		///// 			OUTRO 1			//////		
		for(int i = 0; i < estoque.quantOutros; i++){
			panelOutro[i] = new JPanel();
			panelOutro[i].setBackground(SystemColor.window);
			panelOutro[i].setLayout(null);
			panelOutro[i].setBorder(new LineBorder(Color.DARK_GRAY));
			panelOutro[i].setBounds(6, 43+72*i, 238, 60);
			panelOutros.add(panelOutro[i]);
			
			button1Outro[i] = new JButton("-");
			button1Outro[i].setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			button1Outro[i].setBounds(0, 0, 53, 60);
			final int j = i;
			contentPane.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(estoque.outros[j].getQuantidade() > clicaOutro[j]
							&& Integer.valueOf(e.getKeyChar())-115 == j ){
						clicaOutro[j]++;
						textAreaOutro[j].setText(clicaOutro[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			button1Outro[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(clicaOutro[j] > 0){
						clicaOutro[j]--;
						textAreaOutro[j].setText(clicaOutro[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro[i].add(button1Outro[i]);
			
			labelOutro[i] = new JLabel((char)(i+115)+" -  " + estoque.outros[i].getNome());
			labelOutro[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelOutro[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[i].setBounds(49, 12, 140, 20);
			panelOutro[i].add(labelOutro[i]);
			
			button2Outro[i] = new JButton("+");
			button2Outro[i].setMargin(new Insets(0, 0, 0, 0));
			button2Outro[i].setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			button2Outro[i].setBounds(185, 0, 53, 60);
			button2Outro[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(estoque.outros[j].getQuantidade() > clicaOutro[j]){
						clicaOutro[j]++;
						textAreaOutro[j].setText(clicaOutro[j] + "");
						mostraPedido();
						focusContentPane();
					}
				}
			});
			panelOutro[i].add(button2Outro[i]);
			
			textAreaOutro[i] = new JTextArea();
			textAreaOutro[i].setEditable(false);
			textAreaOutro[i].setText(clicaOutro[i] + "");
			textAreaOutro[i].setBackground(SystemColor.window);
			textAreaOutro[i].setBounds(113, 38, 16, 16);
			panelOutro[i].add(textAreaOutro[i]);
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
				removeProduto = new RemoveProduto(estoque);
				removeProduto.removerProduto(estoque);
				focusContentPane();
			}
		});
		panelMudancas.add(buttonRemoveProduto);
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
