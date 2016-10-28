package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;//Entrará no lugar dos vetores

import basico.Estoque;//Vai ser substituido por AcessoBDProdutos
import basico.AcessoBDProdutos;

import javax.swing.JPanel;
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
	private AcessoBDProdutos acessoBD;
	
	private ArrayList<JPanel> panelBebida = new ArrayList<JPanel>();
	private ArrayList<JPanel> panelSnack = new ArrayList<JPanel>();
	private ArrayList<JPanel> panelOutro = new ArrayList<JPanel>();
	
	private ArrayList<JLabel> labelBebida = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelSnack = new ArrayList<JLabel>();
	private ArrayList<JLabel> labelOutro = new ArrayList<JLabel>();
	
	private ArrayList<JToggleButton> toggleBebida = new ArrayList<JToggleButton>();
	private ArrayList<JToggleButton> toggleSnack = new ArrayList<JToggleButton>();
	private ArrayList<JToggleButton> toggleOutro = new ArrayList<JToggleButton>();

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
		this.acessoBD = estoque.getAcesso();
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
		
		for(int i = 0; i < acessoBD.getBebidas().size(); i++){
			if(acessoBD.getBebidas().get(i) != null){
				panelBebida.add(new JPanel());
				panelBebida.get(i).setBounds(0, 50*i, 175, 40);
				panelBebida.get(i).setLayout(null);
				panelBebida.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
				panelBebidas.add(panelBebida.get(i));
				
				labelBebida.add(new JLabel(acessoBD.getBebidas().get(i).getNome()));
				labelBebida.get(i).setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelBebida.get(i).setBounds(6, 6, 120, 26);
				panelBebida.get(i).add(labelBebida.get(i));
				
				toggleBebida.add(new JToggleButton());
				toggleBebida.get(i).setBounds(140, 8, 25, 25);
				panelBebida.get(i).add(toggleBebida.get(i));
			}
		}
		
		// SNACKS //
		//primeiro painel
		JPanel panelSnacks = new JPanel();
		panelSnacks.setBounds(190, 6, 175, 456);
		removeProduto.add(panelSnacks);
		panelSnacks.setLayout(null);
		
		for(int i = 0; i < acessoBD.getSnacks().size() && i < 9; i++){
			if(acessoBD.getSnacks().get(i) != null){
				panelSnack.add(new JPanel());
				panelSnack.get(i).setBounds(0, 50*i, 175, 40);
				panelSnack.get(i).setLayout(null);
				panelSnack.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
				panelSnacks.add(panelSnack.get(i));
				
				labelSnack.add(new JLabel(acessoBD.getSnacks().get(i).getNome()));
				labelSnack.get(i).setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelSnack.get(i).setBounds(6, 6, 120, 26);
				panelSnack.get(i).add(labelSnack.get(i));
				
				toggleSnack.add(new JToggleButton());
				toggleSnack.get(i).setBounds(140, 8, 25, 25);
				panelSnack.get(i).add(toggleSnack.get(i));
			}
		}
		
		//segundo painel
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setBounds(374, 6, 175, 456);
		removeProduto.add(panel2Snacks);
		panel2Snacks.setLayout(null);
		
		if(acessoBD.getSnacks().size() >= 10){
			for(int i = 9; i < estoque.quantSnacks; i++){
				if(acessoBD.getSnacks().get(i) != null){
					panelSnack.add(new JPanel());
					panelSnack.get(i).setBounds(0, 50*(i-9), 175, 40);
					panelSnack.get(i).setLayout(null);
					panelSnack.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
					panel2Snacks.add(panelSnack.get(i));
					
					labelSnack.add(new JLabel(acessoBD.getSnacks().get(i).getNome()));
					labelSnack.get(i).setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					labelSnack.get(i).setBounds(6, 6, 120, 26);
					panelSnack.get(i).add(labelSnack.get(i));
					
					toggleSnack.add(new JToggleButton());
					toggleSnack.get(i).setBounds(140, 8, 25, 25);
					panelSnack.get(i).add(toggleSnack.get(i));
				}
			}
		}
		
		// OUTROS //
		JPanel panelOutros = new JPanel();
		panelOutros.setBounds(564, 6, 175, 456);
		removeProduto.add(panelOutros);
		panelOutros.setLayout(null);
		
		for(int i = 0; i < acessoBD.getOutros().size(); i++){
			if(acessoBD.getOutros().get(i) != null){
				panelOutro.add(new JPanel());
				panelOutro.get(i).setBounds(0, 50*i, 175, 40);
				panelOutro.get(i).setLayout(null);
				panelOutro.get(i).setBorder(new LineBorder(new Color(0, 0, 0)));
				panelOutros.add(panelOutro.get(i));
				
				labelOutro.add(new JLabel(acessoBD.getOutros().get(i).getNome()));
				labelOutro.get(i).setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				labelOutro.get(i).setBounds(6, 6, 120, 26);
				panelOutro.get(i).add(labelOutro.get(i));
				
				toggleOutro.add(new JToggleButton());
				toggleOutro.get(i).setBounds(140, 8, 25, 25);
				panelOutro.get(i).add(toggleOutro.get(i));
			}
		}
		
		JButton button = new JButton("OK");
		button.setBounds(751, 397, 116, 54);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean foundError = false;
				
				int i = 0;
				while(toggleBebida.size() > 0){
					if(toggleBebida.get(0).isSelected())
						acessoBD.getBebidas().remove(i);
					else i++;
					toggleBebida.remove(0);
				}
				
				i = 0;
				while(toggleSnack.size() > 0){
					if(toggleSnack.get(0).isSelected())
						acessoBD.getSnacks().remove(i);
					else i++;
					toggleSnack.remove(0);
				}
				
				i = 0;
				while(toggleOutro.size() > 0){
					if(toggleOutro.get(0).isSelected())
						acessoBD.getOutros().remove(i);
					else i++;
					toggleOutro.remove(0);
				}
				
				if(!foundError){
					acessoBD.writeProdutos();
					
					JPanel frameDone = new JPanel();
					JOptionPane.showMessageDialog(frameDone ,"Remoção bem sucedida. Reinicie o aplicativo."
							, "FEITO", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
				
				estoque.atualizarValores();//compatibilidade com outras classes
				frame.dispose();
			}
		});
		removeProduto.add(button);
		
	}

}
