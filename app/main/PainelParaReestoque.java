package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import basico.Estoque;

public class PainelParaReestoque {

	private JFrame frame;
	private JPanel reestoque;
	
	Estoque estoque = new Estoque();
	
	private JTextField textFieldBebida1;
	private JTextField textFieldBebida2;
	private JTextField textFieldBebida3;
	private JTextField textFieldBebida4;
	private JTextField textFieldBebida5;
	private JTextField textFieldBebida6;
	private JTextField textFieldBebida7;
	private JTextField textFieldBebida8;
	private JTextField textFieldBebida9;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;

	/**
	 * Launch the application.
	 */
	public static void reestocar(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelParaReestoque window = new PainelParaReestoque();
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
	public PainelParaReestoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		reestoque = new JPanel();
		reestoque.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(reestoque);
		reestoque.setLayout(null);
		
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBounds(6, 6, 175, 456);
		reestoque.add(panelBebidas);
		panelBebidas.setLayout(null);
		
		JPanel panelBebida1 = new JPanel();
		panelBebida1.setBounds(0, 0, 175, 40);
		panelBebidas.add(panelBebida1);
		panelBebida1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBebida1.setLayout(null);
		
		JLabel labelBebida1 = new JLabel();
		labelBebida1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida1.setBounds(6, 6, 120, 26);
		panelBebida1.add(labelBebida1);
		
		textFieldBebida1 = new JTextField();
		textFieldBebida1.setBounds(138, 7, 30, 26);
		panelBebida1.add(textFieldBebida1);
		textFieldBebida1.setColumns(10);
		
		JPanel panelBebida2 = new JPanel();
		panelBebida2.setBounds(0, 50, 175, 40);
		panelBebidas.add(panelBebida2);
		panelBebida2.setLayout(null);
		panelBebida2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida2 = new JLabel("Continentinho");
		labelBebida2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida2.setBounds(6, 6, 120, 26);
		panelBebida2.add(labelBebida2);
		
		textFieldBebida2 = new JTextField();
		textFieldBebida2.setColumns(10);
		textFieldBebida2.setBounds(138, 7, 30, 26);
		panelBebida2.add(textFieldBebida2);
		
		JPanel panelBebida3 = new JPanel();
		panelBebida3.setBounds(0, 100, 175, 40);
		panelBebidas.add(panelBebida3);
		panelBebida3.setLayout(null);
		panelBebida3.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida3 = new JLabel("Continentinho");
		labelBebida3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida3.setBounds(6, 6, 120, 20);
		panelBebida3.add(labelBebida3);
		
		textFieldBebida3 = new JTextField();
		textFieldBebida3.setColumns(10);
		textFieldBebida3.setBounds(138, 7, 30, 20);
		panelBebida3.add(textFieldBebida3);
		
		JPanel panelBebida4 = new JPanel();
		panelBebida4.setBounds(0, 150, 175, 40);
		panelBebidas.add(panelBebida4);
		panelBebida4.setLayout(null);
		panelBebida4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida4 = new JLabel("Continentinho");
		labelBebida4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida4.setBounds(6, 6, 120, 26);
		panelBebida4.add(labelBebida4);
		
		textFieldBebida4 = new JTextField();
		textFieldBebida4.setColumns(10);
		textFieldBebida4.setBounds(138, 7, 30, 26);
		panelBebida4.add(textFieldBebida4);
		
		JPanel panelBebida5 = new JPanel();
		panelBebida5.setBounds(0, 208, 175, 40);
		panelBebidas.add(panelBebida5);
		panelBebida5.setLayout(null);
		panelBebida5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida5 = new JLabel("Continentinho");
		labelBebida5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida5.setBounds(6, 6, 120, 26);
		panelBebida5.add(labelBebida5);
		
		textFieldBebida5 = new JTextField();
		textFieldBebida5.setColumns(10);
		textFieldBebida5.setBounds(138, 7, 30, 26);
		panelBebida5.add(textFieldBebida5);
		
		JPanel panelBebida6 = new JPanel();
		panelBebida6.setBounds(0, 260, 175, 40);
		panelBebidas.add(panelBebida6);
		panelBebida6.setLayout(null);
		panelBebida6.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida6 = new JLabel("Continentinho");
		labelBebida6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida6.setBounds(6, 6, 120, 26);
		panelBebida6.add(labelBebida6);
		
		textFieldBebida6 = new JTextField();
		textFieldBebida6.setColumns(10);
		textFieldBebida6.setBounds(138, 7, 30, 26);
		panelBebida6.add(textFieldBebida6);
		
		JPanel panelBebida7 = new JPanel();
		panelBebida7.setBounds(0, 312, 175, 40);
		panelBebidas.add(panelBebida7);
		panelBebida7.setLayout(null);
		panelBebida7.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida7 = new JLabel("Continentinho");
		labelBebida7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida7.setBounds(6, 6, 120, 26);
		panelBebida7.add(labelBebida7);
		
		textFieldBebida7 = new JTextField();
		textFieldBebida7.setColumns(10);
		textFieldBebida7.setBounds(138, 7, 30, 26);
		panelBebida7.add(textFieldBebida7);
		
		JPanel panelBebida8 = new JPanel();
		panelBebida8.setBounds(0, 364, 175, 40);
		panelBebidas.add(panelBebida8);
		panelBebida8.setLayout(null);
		panelBebida8.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida8 = new JLabel("Continentinho");
		labelBebida8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida8.setBounds(6, 6, 120, 26);
		panelBebida8.add(labelBebida8);
		
		textFieldBebida8 = new JTextField();
		textFieldBebida8.setColumns(10);
		textFieldBebida8.setBounds(138, 7, 30, 26);
		panelBebida8.add(textFieldBebida8);
		
		JPanel panelBebida9 = new JPanel();
		panelBebida9.setBounds(0, 416, 175, 40);
		panelBebidas.add(panelBebida9);
		panelBebida9.setLayout(null);
		panelBebida9.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelBebida9 = new JLabel("Continentinho");
		labelBebida9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelBebida9.setBounds(6, 6, 120, 26);
		panelBebida9.add(labelBebida9);
		
		textFieldBebida9 = new JTextField();
		textFieldBebida9.setColumns(10);
		textFieldBebida9.setBounds(138, 7, 30, 26);
		panelBebida9.add(textFieldBebida9);
		
		JPanel panelSnacks = new JPanel();
		panelSnacks.setLayout(null);
		panelSnacks.setBounds(190, 6, 175, 456);
		reestoque.add(panelSnacks);
		
		JPanel panelSnack1 = new JPanel();
		panelSnack1.setLayout(null);
		panelSnack1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack1.setBounds(0, 0, 175, 40);
		panelSnacks.add(panelSnack1);
		
		JLabel label_1 = new JLabel("Continentinho");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(6, 6, 120, 26);
		panelSnack1.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 7, 30, 26);
		panelSnack1.add(textField_2);
		
		JPanel panelSnack2 = new JPanel();
		panelSnack2.setLayout(null);
		panelSnack2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack2.setBounds(0, 52, 175, 40);
		panelSnacks.add(panelSnack2);
		
		JLabel label_2 = new JLabel("Continentinho");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_2.setBounds(6, 6, 120, 26);
		panelSnack2.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(138, 7, 30, 26);
		panelSnack2.add(textField_3);
		
		JPanel panelSnack3 = new JPanel();
		panelSnack3.setLayout(null);
		panelSnack3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack3.setBounds(0, 104, 175, 40);
		panelSnacks.add(panelSnack3);
		
		JLabel label_3 = new JLabel("Continentinho");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_3.setBounds(6, 6, 120, 26);
		panelSnack3.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(138, 7, 30, 26);
		panelSnack3.add(textField_4);
		
		JPanel panelSnack4 = new JPanel();
		panelSnack4.setLayout(null);
		panelSnack4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack4.setBounds(0, 156, 175, 40);
		panelSnacks.add(panelSnack4);
		
		JLabel label_11 = new JLabel("Continentinho");
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_11.setBounds(6, 6, 120, 26);
		panelSnack4.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(138, 7, 30, 26);
		panelSnack4.add(textField_12);
		
		JPanel panelSnack5 = new JPanel();
		panelSnack5.setLayout(null);
		panelSnack5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack5.setBounds(0, 208, 175, 40);
		panelSnacks.add(panelSnack5);
		
		JLabel label_12 = new JLabel("Continentinho");
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_12.setBounds(6, 6, 120, 26);
		panelSnack5.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(138, 7, 30, 26);
		panelSnack5.add(textField_13);
		
		JPanel panelSnack6 = new JPanel();
		panelSnack6.setLayout(null);
		panelSnack6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack6.setBounds(0, 260, 175, 40);
		panelSnacks.add(panelSnack6);
		
		JLabel label_13 = new JLabel("Continentinho");
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_13.setBounds(6, 6, 120, 26);
		panelSnack6.add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(138, 7, 30, 26);
		panelSnack6.add(textField_14);
		
		JPanel panelSnack7 = new JPanel();
		panelSnack7.setLayout(null);
		panelSnack7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack7.setBounds(0, 312, 175, 40);
		panelSnacks.add(panelSnack7);
		
		JLabel label_14 = new JLabel("Continentinho");
		label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_14.setBounds(6, 6, 120, 26);
		panelSnack7.add(label_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(138, 7, 30, 26);
		panelSnack7.add(textField_15);
		
		JPanel panelSnack8 = new JPanel();
		panelSnack8.setLayout(null);
		panelSnack8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack8.setBounds(0, 364, 175, 40);
		panelSnacks.add(panelSnack8);
		
		JLabel label_15 = new JLabel("Continentinho");
		label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_15.setBounds(6, 6, 120, 26);
		panelSnack8.add(label_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(138, 7, 30, 26);
		panelSnack8.add(textField_16);
		
		JPanel panelSnack9 = new JPanel();
		panelSnack9.setLayout(null);
		panelSnack9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSnack9.setBounds(0, 416, 175, 40);
		panelSnacks.add(panelSnack9);
		
		JLabel label_16 = new JLabel("Continentinho");
		label_16.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_16.setBounds(6, 6, 120, 26);
		panelSnack9.add(label_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(138, 7, 30, 26);
		panelSnack9.add(textField_17);
		
		JPanel panel2Snacks = new JPanel();
		panel2Snacks.setLayout(null);
		panel2Snacks.setBounds(380, 6, 175, 456);
		reestoque.add(panel2Snacks);
		
		JPanel panel2Snack1 = new JPanel();
		panel2Snack1.setLayout(null);
		panel2Snack1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack1.setBounds(0, 0, 175, 40);
		panel2Snacks.add(panel2Snack1);
		
		JLabel label_17 = new JLabel("Continentinho");
		label_17.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_17.setBounds(6, 6, 120, 26);
		panel2Snack1.add(label_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(138, 7, 30, 26);
		panel2Snack1.add(textField_18);
		
		JPanel panel2Snack2 = new JPanel();
		panel2Snack2.setLayout(null);
		panel2Snack2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack2.setBounds(0, 52, 175, 40);
		panel2Snacks.add(panel2Snack2);
		
		JLabel label_18 = new JLabel("Continentinho");
		label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_18.setBounds(6, 6, 120, 26);
		panel2Snack2.add(label_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(138, 7, 30, 26);
		panel2Snack2.add(textField_19);
		
		JPanel panel2Snack3 = new JPanel();
		panel2Snack3.setLayout(null);
		panel2Snack3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack3.setBounds(0, 104, 175, 40);
		panel2Snacks.add(panel2Snack3);
		
		JLabel label_19 = new JLabel("Continentinho");
		label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_19.setBounds(6, 6, 120, 26);
		panel2Snack3.add(label_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(138, 7, 30, 26);
		panel2Snack3.add(textField_20);
		
		JPanel panel2Snack4 = new JPanel();
		panel2Snack4.setLayout(null);
		panel2Snack4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack4.setBounds(0, 156, 175, 40);
		panel2Snacks.add(panel2Snack4);
		
		JLabel label_20 = new JLabel("Continentinho");
		label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_20.setBounds(6, 6, 120, 26);
		panel2Snack4.add(label_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(138, 7, 30, 26);
		panel2Snack4.add(textField_21);
		
		JPanel panel2Snack5 = new JPanel();
		panel2Snack5.setLayout(null);
		panel2Snack5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack5.setBounds(0, 208, 175, 40);
		panel2Snacks.add(panel2Snack5);
		
		JLabel label_21 = new JLabel("Continentinho");
		label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_21.setBounds(6, 6, 120, 26);
		panel2Snack5.add(label_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(138, 7, 30, 26);
		panel2Snack5.add(textField_22);
		
		JPanel panel2Snack6 = new JPanel();
		panel2Snack6.setLayout(null);
		panel2Snack6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack6.setBounds(0, 260, 175, 40);
		panel2Snacks.add(panel2Snack6);
		
		JLabel label_22 = new JLabel("Continentinho");
		label_22.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_22.setBounds(6, 6, 120, 26);
		panel2Snack6.add(label_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(138, 7, 30, 26);
		panel2Snack6.add(textField_23);
		
		JPanel panel2Snack7 = new JPanel();
		panel2Snack7.setLayout(null);
		panel2Snack7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack7.setBounds(0, 312, 175, 40);
		panel2Snacks.add(panel2Snack7);
		
		JLabel label_23 = new JLabel("Continentinho");
		label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_23.setBounds(6, 6, 120, 26);
		panel2Snack7.add(label_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(138, 7, 30, 26);
		panel2Snack7.add(textField_24);
		
		JPanel panel2Snack8 = new JPanel();
		panel2Snack8.setLayout(null);
		panel2Snack8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack8.setBounds(0, 364, 175, 40);
		panel2Snacks.add(panel2Snack8);
		
		JLabel label_24 = new JLabel("Continentinho");
		label_24.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_24.setBounds(6, 6, 120, 26);
		panel2Snack8.add(label_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(138, 7, 30, 26);
		panel2Snack8.add(textField_25);
		
		JPanel panel2Snack9 = new JPanel();
		panel2Snack9.setLayout(null);
		panel2Snack9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2Snack9.setBounds(0, 416, 175, 40);
		panel2Snacks.add(panel2Snack9);
		
		JLabel label_25 = new JLabel("Continentinho");
		label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_25.setBounds(6, 6, 120, 26);
		panel2Snack9.add(label_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(138, 7, 30, 26);
		panel2Snack9.add(textField_26);
		
		JPanel panelOutros = new JPanel();
		panelOutros.setLayout(null);
		panelOutros.setBounds(567, 6, 175, 456);
		reestoque.add(panelOutros);
		
		JPanel panelOutro1 = new JPanel();
		panelOutro1.setLayout(null);
		panelOutro1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro1.setBounds(0, 0, 175, 40);
		panelOutros.add(panelOutro1);
		
		JLabel label_26 = new JLabel("Continentinho");
		label_26.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_26.setBounds(6, 6, 120, 26);
		panelOutro1.add(label_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(138, 7, 30, 26);
		panelOutro1.add(textField_27);
		
		JPanel panelOutro2 = new JPanel();
		panelOutro2.setLayout(null);
		panelOutro2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro2.setBounds(0, 52, 175, 40);
		panelOutros.add(panelOutro2);
		
		JLabel label_27 = new JLabel("Continentinho");
		label_27.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_27.setBounds(6, 6, 120, 26);
		panelOutro2.add(label_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(138, 7, 30, 26);
		panelOutro2.add(textField_28);
		
		JPanel panelOutro3 = new JPanel();
		panelOutro3.setLayout(null);
		panelOutro3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro3.setBounds(0, 104, 175, 40);
		panelOutros.add(panelOutro3);
		
		JLabel label_28 = new JLabel("Continentinho");
		label_28.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_28.setBounds(6, 6, 120, 26);
		panelOutro3.add(label_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(138, 7, 30, 26);
		panelOutro3.add(textField_29);
		
		JPanel panelOutro4 = new JPanel();
		panelOutro4.setLayout(null);
		panelOutro4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro4.setBounds(0, 156, 175, 40);
		panelOutros.add(panelOutro4);
		
		JLabel label_29 = new JLabel("Continentinho");
		label_29.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_29.setBounds(6, 6, 120, 26);
		panelOutro4.add(label_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(138, 7, 30, 26);
		panelOutro4.add(textField_30);
		
		JPanel panelOutro5 = new JPanel();
		panelOutro5.setLayout(null);
		panelOutro5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro5.setBounds(0, 208, 175, 40);
		panelOutros.add(panelOutro5);
		
		JLabel label_30 = new JLabel("Continentinho");
		label_30.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_30.setBounds(6, 6, 120, 26);
		panelOutro5.add(label_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(138, 7, 30, 26);
		panelOutro5.add(textField_31);
		
		JPanel panelOutro6 = new JPanel();
		panelOutro6.setLayout(null);
		panelOutro6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro6.setBounds(0, 260, 175, 40);
		panelOutros.add(panelOutro6);
		
		JLabel label_31 = new JLabel("Continentinho");
		label_31.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_31.setBounds(6, 6, 120, 26);
		panelOutro6.add(label_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(138, 7, 30, 26);
		panelOutro6.add(textField_32);
		
		JPanel panelOutro7 = new JPanel();
		panelOutro7.setLayout(null);
		panelOutro7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro7.setBounds(0, 312, 175, 40);
		panelOutros.add(panelOutro7);
		
		JLabel label_32 = new JLabel("Continentinho");
		label_32.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_32.setBounds(6, 6, 120, 26);
		panelOutro7.add(label_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(138, 7, 30, 26);
		panelOutro7.add(textField_33);
		
		JPanel panelOutro8 = new JPanel();
		panelOutro8.setLayout(null);
		panelOutro8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro8.setBounds(0, 364, 175, 40);
		panelOutros.add(panelOutro8);
		
		JLabel label_33 = new JLabel("Continentinho");
		label_33.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_33.setBounds(6, 6, 120, 26);
		panelOutro8.add(label_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(138, 7, 30, 26);
		panelOutro8.add(textField_34);
		
		JPanel panelOutro9 = new JPanel();
		panelOutro9.setLayout(null);
		panelOutro9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOutro9.setBounds(0, 416, 175, 40);
		panelOutros.add(panelOutro9);
		
		JLabel label_34 = new JLabel("Continentinho");
		label_34.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_34.setBounds(6, 6, 120, 26);
		panelOutro9.add(label_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(138, 7, 30, 26);
		panelOutro9.add(textField_35);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(754, 394, 116, 54);
		reestoque.add(button);
	}
}
