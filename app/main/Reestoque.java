package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import basico.Estoque;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Reestoque {

	BufferedReader leitor;
	
	JPanel[] panelBebida = new JPanel[30];
	JPanel[] panelSnack = new JPanel[30];
	JPanel[] panelOutro = new JPanel[30];
	
	JLabel[] labelBebida = new JLabel[30];
	JLabel[] labelSnack = new JLabel[30];
	JLabel[] labelOutro = new JLabel[30];
	
	JTextField[] textFieldBebida = new JTextField[30];
	JTextField[] textFieldSnack = new JTextField[30];
	JTextField[] textFieldOutro = new JTextField[30];
	
	private JFrame frame;
	private JPanel mudaPreco;

	/**
	 * Launch the application.
	 */
	public void reestocar(Estoque estoque) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reestoque window = new Reestoque(estoque);
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
	public Reestoque(Estoque estoque) {
		System.out.println("Manda Nudes");
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
		
		for(int i = 0; i < estoque.quantBebidas; i++){
			panelBebida[i] = new JPanel();
			panelBebida[i].setBounds(0, 50*i, 175, 40);
			panelBebida[i].setLayout(null);
			panelBebida[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelBebidas.add(panelBebida[i]);
			
			labelBebida[i] = new JLabel(estoque.bebidas[i].getNome());
			labelBebida[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelBebida[i].setBounds(6, 6, 120, 26);
			panelBebida[i].add(labelBebida[i]);
			
			textFieldBebida[i] = new JTextField("0");
			textFieldBebida[i].setBounds(128, 7, 40, 26);
			panelBebida[i].add(textFieldBebida[i]);
		}
		
		JPanel panelSnacks = new JPanel();
		panelSnacks.setBounds(190, 6, 175, 456);
		panelSnacks.setLayout(null);
		mudaPreco.add(panelSnacks);
		
		for(int i = 0; i < estoque.quantSnacks && i < 9; i++){
			panelSnack[i] = new JPanel();
			panelSnack[i].setBounds(0, 50*i, 175, 40);
			panelSnack[i].setLayout(null);
			panelSnack[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSnacks.add(panelSnack[i]);
			
			labelSnack[i] = new JLabel(estoque.snacks[i].getNome());
			labelSnack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelSnack[i].setBounds(6, 6, 120, 26);
			panelSnack[i].add(labelSnack[i]);
			
			textFieldSnack[i] = new JTextField("0");
			textFieldSnack[i].setBounds(128, 7, 40, 26);
			panelSnack[i].add(textFieldSnack[i]);
		}
		
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setBounds(374, 6, 175, 456);
		panel2Snacks.setLayout(null);
		mudaPreco.add(panel2Snacks);
		
		if(estoque.quantSnacks >= 10){
			for(int i = 9; i < estoque.quantSnacks; i++){
				panelSnack[i] = new JPanel();
				panelSnack[i].setBounds(0, 50*(i-9), 175, 40);
				panelSnack[i].setLayout(null);
				panelSnack[i].setBorder(new LineBorder(new Color(0, 0, 0)));
				panel2Snacks.add(panelSnack[i]);
				
				labelSnack[i] = new JLabel(estoque.snacks[i].getNome());
				labelSnack[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelSnack[i].setBounds(6, 6, 120, 26);
				panelSnack[i].add(labelSnack[i]);
				
				textFieldSnack[i] = new JTextField("0");
				textFieldSnack[i].setBounds(128, 7, 40, 26);
				panelSnack[i].add(textFieldSnack[i]);
			}
		}
		
		JPanel panelOutros = new JPanel();
		panelOutros.setBounds(564, 6, 175, 456);
		panelOutros.setLayout(null);
		mudaPreco.add(panelOutros);
		
		for(int i = 0; i < estoque.quantOutros; i++){
			panelOutro[i] = new JPanel();
			panelOutro[i].setBounds(0, 50*i, 175, 40);
			panelOutro[i].setLayout(null);
			panelOutro[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelOutros.add(panelOutro[i]);
			
			labelOutro[i] = new JLabel(estoque.outros[i].getNome());
			labelOutro[i].setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			labelOutro[i].setBounds(6, 6, 120, 26);
			panelOutro[i].add(labelOutro[i]);
			
			textFieldOutro[i] = new JTextField("0");
			textFieldOutro[i].setBounds(128, 7, 40, 26);
			panelOutro[i].add(textFieldOutro[i]);
		}
		
		JButton button = new JButton("OK");
		button.setBounds(751, 397, 116, 54);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean foundError = false;
				
				//Bebidas
				for(int percorre = 0; percorre < textFieldBebida.length && percorre < estoque.quantBebidas; percorre++){
					if(textFieldBebida[percorre].getText().equals("")){
						textFieldBebida[percorre].setText(estoque.bebidas[percorre].getQuantidade() + "");
					}
					try{
						int adicionado = Integer.parseInt(textFieldBebida[percorre].getText());
						estoque.bebidas[percorre].addQuantidade(adicionado);	
					}
					catch(NumberFormatException exception){
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Insira números em todas as lacunas"
								, "AVISO", JOptionPane.WARNING_MESSAGE);
						break;
					}	
				}
				//Snacks
				for(int percorre = 0; percorre < textFieldSnack.length && percorre < estoque.quantSnacks; percorre++){
					if(textFieldSnack[percorre].getText().equals("")){
						textFieldSnack[percorre].setText(estoque.snacks[percorre].getQuantidade() + "");
					}
					try{
						int adicionado = Integer.parseInt(textFieldSnack[percorre].getText());
						estoque.snacks[percorre].addQuantidade(adicionado);	
					}
					catch(NumberFormatException exception){
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Insira números em todas as lacunas"
								, "AVISO", JOptionPane.WARNING_MESSAGE);
						break;
					}	
				}
				//Outros
				for(int percorre = 0; percorre < textFieldOutro.length && percorre < estoque.quantOutros; percorre++){
					if(textFieldOutro[percorre].getText().equals("")){
						textFieldOutro[percorre].setText(estoque.outros[percorre].getQuantidade() + "");
					}
					try{
						int adicionado = Integer.parseInt(textFieldOutro[percorre].getText());
						estoque.outros[percorre].addQuantidade(adicionado);	
					}
					catch(NumberFormatException exception){
						foundError = true;
						JPanel frameWarning = new JPanel();
						JOptionPane.showMessageDialog(frameWarning ,"Insira números em todas as lacunas"
								, "AVISO", JOptionPane.WARNING_MESSAGE);
						break;
					}	
				}
				
				if(!foundError){
					estoque.vendeEstoque();//atualiza o BD
				}
				
				estoque.atualizarValores();
				frame.dispose();
			}
		});
		mudaPreco.add(button);
		
		JTextPane textPaneAviso = new JTextPane();
		textPaneAviso.setEditable(false);
		textPaneAviso.setBackground(SystemColor.window);
		textPaneAviso.setText("Certifique-se de que todos os valores são inteiros.\n");
		textPaneAviso.setBounds(754, 6, 110, 128);
		mudaPreco.add(textPaneAviso);
	}
}
