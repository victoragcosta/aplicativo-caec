package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import basico.Estoque;
import basico.Produto;
import basico.TipoProduto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class AdicionaProduto {
	
	BufferedReader leitor;

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JTextField textFieldQuant;
	String[] tipos = {"Bebida", "Snack", "Outro"};
	String temp;
	String novoNome;
	String novoTipo;
	double novoPreco;
	int novaQuant;

	/**
	 * Launch the application.
	 */
	public void adicionarProduto(Estoque estoque) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionaProduto window = new AdicionaProduto(estoque);
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
	public AdicionaProduto(Estoque estoque) {
		initialize(estoque);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Estoque estoque) {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (frame.getWidth()/2);
		int yPos = (dim.height/2) - (frame.getHeight()/2);
		frame.setLocation(xPos, yPos);
		frame.getContentPane().setLayout(null);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(20, 6, 61, 16);
		frame.getContentPane().add(labelNome);
		
		JLabel labelPreco = new JLabel("Preço");
		labelPreco.setHorizontalAlignment(SwingConstants.CENTER);
		labelPreco.setBounds(248, 6, 61, 16);
		frame.getContentPane().add(labelPreco);
		
		JLabel labelQuantInicial = new JLabel("Quant Inicial");
		labelQuantInicial.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantInicial.setBounds(296, 6, 128, 16);
		frame.getContentPane().add(labelQuantInicial);
		
		JLabel labelTipo = new JLabel("Tipo");
		labelTipo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTipo.setBounds(436, 6, 61, 16);
		frame.getContentPane().add(labelTipo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(17, 21, 213, 26);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(253, 21, 56, 26);
		frame.getContentPane().add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		textFieldQuant = new JTextField();
		textFieldQuant.setColumns(10);
		textFieldQuant.setBounds(327, 21, 61, 26);
		frame.getContentPane().add(textFieldQuant);
		
		final JComboBox<String> comboBox = new JComboBox<String>(tipos);
		comboBox.setBounds(414, 22, 114, 27);
		frame.getContentPane().add(comboBox);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.setBounds(562, 21, 117, 29);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoTipo = (String) comboBox.getSelectedItem();
				boolean foundError = false;
				boolean aviso = false;
				
				try{
					novoNome = textFieldNome.getText();
					novoPreco = Double.parseDouble(textFieldPreco.getText()); 
					novaQuant = Integer.parseInt(textFieldQuant.getText());
					
					if(novoTipo.equals("Bebida") && estoque.quantBebidas == 9){
						aviso = true;
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Não é possível adicionar nova bebida, estoque cheio."
								, "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else if(novoTipo.equals("Snack") && estoque.quantSnacks == 18){
						aviso = true;
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Não é possível adicionar novo snack, estoque cheio."
								, "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else if(novoTipo.equals("Outro") && estoque.quantOutros == 9){
						aviso = true;
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Não é possível adicionar novo produto, estoque cheio."
								, "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					
					
					if(!foundError){
						try {
							if(novoTipo.equals("Bebida")){
								estoque.bebidas[estoque.quantBebidas] = new Produto(novoNome, novoPreco, novaQuant, TipoProduto.bebida);
							}
							else if(novoTipo.equals("Snack")){
								estoque.snacks[estoque.quantSnacks] = new Produto(novoNome, novoPreco, novaQuant, TipoProduto.snack);
							}
							else{
								estoque.outros[estoque.quantOutros] = new Produto(novoNome, novoPreco, novaQuant, TipoProduto.outro);
							}
						}
						catch(Exception e2){
							System.out.println("Deu ruim mané");
						}
					}
				}
				catch(NumberFormatException exception){
					if(!aviso){
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Entrada inválida. Cheque suas informações."
								, "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				} 
				if(!foundError){
					estoque.vendeEstoque();
					estoque.atualizarProdutos();
					JPanel frameDone = new JPanel();
					JOptionPane.showMessageDialog(frameDone ,"Inserção bem sucedida. Reinicie o aplicativo."
							, "FEITO", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
		    }
		});
		frame.getContentPane().add(buttonOk);
	}
}
