package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import basico.Produto;

public class InterfaceGrafica extends JFrame {
	
	Produto[] estoque = new Produto[3];
	JButton[] buttonArray = new JButton[3];

	Produto bebida1 = new Produto("Coca Cola", 2.5, 3, basico.TipoProduto.bebida);
	Produto bebida2 = new Produto("Guaraná", 3, 5, basico.TipoProduto.bebida);
	Produto bebida3 = new Produto("Pepsi", 3, 5, basico.TipoProduto.bebida);

	int clicaBotao1;
	int clicaBotao2;
	int clicaBotao3;
	int clicaBotao4;
	int clicaBotao5;
	int clicaBotao6;
	int clicaBotao7;
	int clicaBotao8;
	
	JLabel label1 = new JLabel("Bebidas");
	JLabel label2 = new JLabel("Comida");
	JLabel label3 = new JLabel("Outros");
	JLabel label4 = new JLabel("Opções");	
	
	JButton button1 = new JButton(bebida1.getNome());
	JButton button2 = new JButton(bebida2.getNome());
	JButton button3 = new JButton(bebida3.getNome());
	JButton button4 = new JButton("Cancelar ultimo pedido");
	JButton button5 = new JButton("Cancelar todo o pedido");
	
	JTextArea textArea1;
	
	public InterfaceGrafica(){
//		for (int i = 0; i < 3; i++){
//			buttonArray[i] = new JButton(estoque[i].getNome());
//		}
		
		//////      CRIAÇÃO PAINEL     ///////
		this.setSize(1080, 700);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Interface Vendas CAEC - versão (0.0.0.0.1)");
		JPanel thePanel = new JPanel();
		
		/////         ADDERS        /////
		ListenForButton listen = new ListenForButton();
		button1.addActionListener(listen);
		button2.addActionListener(listen);
//		thePanel.add(label1);
//		thePanel.add(label2);
//		thePanel.add(label3);
//		thePanel.add(label4);
		thePanel.add(button1);
		thePanel.add(button2);
		thePanel.add(button3);
		
		textArea1 = new JTextArea(20, 15);		
		textArea1.setText("Pedido:\n");
		textArea1.setLineWrap(true);	
		textArea1.setWrapStyleWord(true);	
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);				
		thePanel.add(scrollbar1);
		this.add(thePanel);
		this.setVisible(true);
		 
	 }	
	
	//////             LISTENERS         /////////
	private class ListenForButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == button1){
				if(bebida1.getQuantidade() <= 0){
					textArea1.append("Não há " + bebida1.getNome() + " suficiente no estoque.\n");
					//textArea1.setText("Pedido:\n");
				}
				else{
					clicaBotao1++;
					textArea1.append(clicaBotao1 + " " + bebida1.getNome()+"\n");
					//bebida1.vendeProduto();
				}
				
				
			}
			else if(e.getSource() == button2){
				if(bebida2.getQuantidade() <= 0){
					textArea1.append("Não há " + bebida2.getNome() + " suficiente no estoque\n");
				}
				else{
					clicaBotao2++;
					textArea1.append(clicaBotao2 + " " + bebida2.getNome()+"\n");
					//bebida2.vendeProduto();
				}
				
				
			}
			
		}
	}
	
	public void geraPedido(){
		
	}

	public static void main(String[] args) {
		new InterfaceGrafica();

	}
	private static final long serialVersionUID = 1L;
}
