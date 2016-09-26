package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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

import basico.Estoque;
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
		frame.setBounds(100, 100, 700, 75);
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
				String listaTemp = new String();
				boolean foundError = false;
				boolean aviso = false;
				
				
				try{
					File arquivoProdutos = new File("texto.txt");
					leitor = new BufferedReader(new FileReader(arquivoProdutos));
					
					int percorre = 0;
					String informacaoProduto = leitor.readLine();
					String informacaoAtualizada;
					String preco;
					String quantidade;
					
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
					
					while(informacaoProduto != null){
						String[] produtoTemp = informacaoProduto.split(", ");
						
						if(produtoTemp[3].equals("bebida")){
							try{
								preco = String.valueOf(estoque.bebidas[percorre].getPreco());
								quantidade = String.valueOf(estoque.bebidas[percorre].getQuantidade());
								informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", bebida");
								listaTemp += (informacaoAtualizada + "\n");

								percorre++;
								if(percorre == estoque.quantBebidas){
									if(estoque.quantBebidas < 9 && novoTipo.equals("Bebida")){
										listaTemp += (novoNome + ", " + novoPreco + ", " + novaQuant + ", bebida\n");
									}
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
							preco = String.valueOf(estoque.snacks[percorre].getPreco());
							quantidade = String.valueOf(estoque.snacks[percorre].getQuantidade());
							informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", snack");
							listaTemp += (informacaoAtualizada + "\n");

							percorre++;
							if(percorre == estoque.quantSnacks){
								if(estoque.quantSnacks < 18 && novoTipo.equals("Snack")){
									listaTemp += (novoNome + ", " + novoPreco + ", " + novaQuant + ", snack\n");
								}
								percorre = 0;
							}
						}
						
						if(produtoTemp[3].equals("outro")){
							preco = String.valueOf(estoque.outros[percorre].getPreco());
							quantidade = String.valueOf(estoque.outros[percorre].getQuantidade());
							informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", outro");
							listaTemp += (informacaoAtualizada + "\n");

							percorre++;
							
							if(percorre == estoque.quantOutros){
								if(estoque.quantOutros < 9 && novoTipo.equals("Outro")){
									listaTemp += (novoNome + ", " + novoPreco + ", " + novaQuant + ", outro\n");
								}
								percorre = 0;
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
				catch(NumberFormatException exception){
					if(!aviso){
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Entrada inválida. Cheque suas informações."
								, "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				} 
				catch(FileNotFoundException e1){
					foundError = true;
					System.out.println("Couldn't Find File");
					System.exit(0);
				}
				catch(IOException e2){
					foundError = true;
					System.out.println("IO Error");
					System.exit(0);
				}
				if(!foundError){
					estoque.atualizarValores();
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
