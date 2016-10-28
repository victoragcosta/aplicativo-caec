package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basico.Estoque;
import basico.Produto;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class RemoveProduto {

	private JFrame frame;
	private JPanel removeProduto;
	private Estoque estoque;
	
	private JPanel[] panelBebida = new JPanel[30];
	private JPanel[] panelSnack = new JPanel[30];
	private JPanel[] panelOutro = new JPanel[30];
	
	private JLabel[] labelBebida = new JLabel[30];
	private JLabel[] labelSnack = new JLabel[30];
	private JLabel[] labelOutro = new JLabel[30];
	
	private JToggleButton[] toggleBebida = new JToggleButton[30];
	private JToggleButton[] toggleSnack = new JToggleButton[30];
	private JToggleButton[] toggleOutro = new JToggleButton[30];

	/**
	 * Launch the application.
	 */
	public void removerProduto(Estoque estoque) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveProduto window = new RemoveProduto(estoque);
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
	public RemoveProduto(Estoque estoque) {
		this.estoque = estoque;
		System.out.println("Adoro chocolate");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 490);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (frame.getWidth()/2);
		int yPos = (dim.height/2) - (frame.getHeight()/2);
		frame.setLocation(xPos, yPos);
		
		removeProduto = new JPanel();
		removeProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(removeProduto);
		removeProduto.setLayout(null);
		
		// BEBIDAS //
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBounds(6, 6, 175, 456);
		removeProduto.add(panelBebidas);
		panelBebidas.setLayout(null);
		
		for(int i = 0; i < estoque.quantBebidas; i++){
			if(estoque.bebidas[i] != null){
				panelBebida[i] = new JPanel();
				panelBebida[i].setBounds(0, 50*i, 175, 40);
				panelBebida[i].setLayout(null);
				panelBebida[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panelBebidas.add(panelBebida[i]);
				
				labelBebida[i] = new JLabel(estoque.bebidas[i].getNome());
				labelBebida[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelBebida[i].setBounds(6, 6, 120, 26);
				panelBebida[i].add(labelBebida[i]);
				
				toggleBebida[i] = new JToggleButton();
				toggleBebida[i].setBounds(140, 8, 25, 25);
				panelBebida[i].add(toggleBebida[i]);
			}
		}
		
		// SNACKS //
		//primeiro painel
		JPanel panelSnacks = new JPanel();
		panelSnacks.setBounds(190, 6, 175, 456);
		removeProduto.add(panelSnacks);
		panelSnacks.setLayout(null);
		
		for(int i = 0; i < estoque.quantSnacks && i < 9; i++){
			if(estoque.snacks[i] != null){
				panelSnack[i] = new JPanel();
				panelSnack[i].setBounds(0, 50*i, 175, 40);
				panelSnack[i].setLayout(null);
				panelSnack[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panelSnacks.add(panelSnack[i]);
				
				labelSnack[i] = new JLabel(estoque.snacks[i].getNome());
				labelSnack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelSnack[i].setBounds(6, 6, 120, 26);
				panelSnack[i].add(labelSnack[i]);
				
				toggleSnack[i] = new JToggleButton();
				toggleSnack[i].setBounds(140, 8, 25, 25);
				panelSnack[i].add(toggleSnack[i]);
			}
		}
		
		//segundo painel
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setBounds(374, 6, 175, 456);
		removeProduto.add(panel2Snacks);
		panel2Snacks.setLayout(null);
		
		if(estoque.quantSnacks >= 10){
			for(int i = 9; i < estoque.quantSnacks; i++){
				if(estoque.snacks[i] != null){
					panelSnack[i] = new JPanel();
					panelSnack[i].setBounds(0, 50*(i-9), 175, 40);
					panelSnack[i].setLayout(null);
					panelSnack[i].setBorder(new LineBorder(new Color(0, 0, 0)));
					panel2Snacks.add(panelSnack[i]);
					
					labelSnack[i] = new JLabel(estoque.snacks[i].getNome());
					labelSnack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelSnack[i].setBounds(6, 6, 120, 26);
					panelSnack[i].add(labelSnack[i]);
					
					toggleSnack[i] = new JToggleButton();
					toggleSnack[i].setBounds(140, 8, 25, 25);
					panelSnack[i].add(toggleSnack[i]);
				}
			}
		}
		
		// OUTROS //
		JPanel panelOutros = new JPanel();
		panelOutros.setBounds(564, 6, 175, 456);
		removeProduto.add(panelOutros);
		panelOutros.setLayout(null);
		
		for(int i = 0; i < estoque.quantOutros; i++){
			if(estoque.outros[i] != null){
				panelOutro[i] = new JPanel();
				panelOutro[i].setBounds(0, 50*i, 175, 40);
				panelOutro[i].setLayout(null);
				panelOutro[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panelOutros.add(panelOutro[i]);
				
				labelOutro[i] = new JLabel(estoque.outros[i].getNome());
				labelOutro[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelOutro[i].setBounds(6, 6, 120, 26);
				panelOutro[i].add(labelOutro[i]);
				
				toggleOutro[i] = new JToggleButton();
				toggleOutro[i].setBounds(140, 8, 25, 25);
				panelOutro[i].add(toggleOutro[i]);
			}
		}
		
		JButton button = new JButton("OK");
		button.setBounds(751, 397, 116, 54);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean foundError = false;
				
				Produto[] novoBebidas = new Produto[30];
				Produto[] novoSnacks = new Produto[30];
				Produto[] novoOutros = new Produto[30];
				
				int j = 0;
				for(int i = 0; i < estoque.quantBebidas; i++){
					try{
						if(!toggleBebida[i].isSelected()){
							novoBebidas[j] = estoque.bebidas[i];
							j++;
						}
					}
					catch(Exception eita){
						eita.printStackTrace();
					}
				}
				for(int i = 0; i < j; i++){
					estoque.bebidas[i] = novoBebidas[i];
				}
				estoque.quantBebidas = j;
				
				j = 0;
				for(int i = 0; i < estoque.quantSnacks; i++){
					try{
						if(!toggleSnack[i].isSelected()){
							novoSnacks[j] = estoque.snacks[i];
							j++;
						}
					}
					catch(Exception eita){
						eita.printStackTrace();
					}
				}
				for(int i = 0; i < j; i++){
					estoque.snacks[i] = novoSnacks[i];
				}
				estoque.quantSnacks = j;
				
				j = 0;
				for(int i = 0; i < estoque.quantOutros; i++){
					try{
						if(!toggleOutro[i].isSelected()){
							novoOutros[j] = estoque.outros[i];
							j++;
						}
					}
					catch(Exception eita){
						eita.printStackTrace();
					}
				}
				for(int i = 0; i < j; i++){
					estoque.outros[i] = novoOutros[i];
				}
				estoque.quantOutros = j;
				
				if(!foundError){
					estoque.vendeEstoque();//atualiza o BD
					
					JPanel frameDone = new JPanel();
					JOptionPane.showMessageDialog(frameDone ,"Inserção bem sucedida. Reinicie o aplicativo."
							, "FEITO", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
				
				estoque.atualizarValores();
				frame.dispose();
			}
		});
		removeProduto.add(button);
		
	}

}
