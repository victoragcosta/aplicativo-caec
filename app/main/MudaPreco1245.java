package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JButton;

public class MudaPreco1245 extends JFrame {

	private JPanel mudaPreco;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
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
	public void mudarPreco() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MudaPreco1245 frame = new MudaPreco1245();
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
	public MudaPreco1245() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 500);
		mudaPreco = new JPanel();
		mudaPreco.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mudaPreco);
		mudaPreco.setLayout(null);
		
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBounds(6, 6, 175, 456);
		mudaPreco.add(panelBebidas);
		panelBebidas.setLayout(null);
		
		JPanel panelBebida1 = new JPanel();
		panelBebida1.setBounds(0, 0, 175, 40);
		panelBebidas.add(panelBebida1);
		panelBebida1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBebida1.setLayout(null);
		
		JLabel lblCoca = new JLabel("Continentinho");
		lblCoca.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCoca.setBounds(6, 6, 120, 26);
		panelBebida1.add(lblCoca);
		
		textField = new JTextField();
		textField.setBounds(138, 7, 30, 26);
		panelBebida1.add(textField);
		textField.setColumns(10);
		
		JPanel panelBebida2 = new JPanel();
		panelBebida2.setBounds(0, 52, 175, 40);
		panelBebidas.add(panelBebida2);
		panelBebida2.setLayout(null);
		panelBebida2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label = new JLabel("Continentinho");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(6, 6, 120, 26);
		panelBebida2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 7, 30, 26);
		panelBebida2.add(textField_1);
		
		JPanel panelBebida3 = new JPanel();
		panelBebida3.setBounds(0, 104, 175, 40);
		panelBebidas.add(panelBebida3);
		panelBebida3.setLayout(null);
		panelBebida3.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_4 = new JLabel("Continentinho");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_4.setBounds(6, 6, 120, 26);
		panelBebida3.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(138, 7, 30, 26);
		panelBebida3.add(textField_5);
		
		JPanel panelBebida4 = new JPanel();
		panelBebida4.setBounds(0, 156, 175, 40);
		panelBebidas.add(panelBebida4);
		panelBebida4.setLayout(null);
		panelBebida4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_5 = new JLabel("Continentinho");
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_5.setBounds(6, 6, 120, 26);
		panelBebida4.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(138, 7, 30, 26);
		panelBebida4.add(textField_6);
		
		JPanel panelBebida5 = new JPanel();
		panelBebida5.setBounds(0, 208, 175, 40);
		panelBebidas.add(panelBebida5);
		panelBebida5.setLayout(null);
		panelBebida5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_6 = new JLabel("Continentinho");
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_6.setBounds(6, 6, 120, 26);
		panelBebida5.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(138, 7, 30, 26);
		panelBebida5.add(textField_7);
		
		JPanel panelBebida6 = new JPanel();
		panelBebida6.setBounds(0, 260, 175, 40);
		panelBebidas.add(panelBebida6);
		panelBebida6.setLayout(null);
		panelBebida6.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_7 = new JLabel("Continentinho");
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_7.setBounds(6, 6, 120, 26);
		panelBebida6.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(138, 7, 30, 26);
		panelBebida6.add(textField_8);
		
		JPanel panelBebida7 = new JPanel();
		panelBebida7.setBounds(0, 312, 175, 40);
		panelBebidas.add(panelBebida7);
		panelBebida7.setLayout(null);
		panelBebida7.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_8 = new JLabel("Continentinho");
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_8.setBounds(6, 6, 120, 26);
		panelBebida7.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(138, 7, 30, 26);
		panelBebida7.add(textField_9);
		
		JPanel panelBebida8 = new JPanel();
		panelBebida8.setBounds(0, 364, 175, 40);
		panelBebidas.add(panelBebida8);
		panelBebida8.setLayout(null);
		panelBebida8.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_9 = new JLabel("Continentinho");
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_9.setBounds(6, 6, 120, 26);
		panelBebida8.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(138, 7, 30, 26);
		panelBebida8.add(textField_10);
		
		JPanel panelBebida9 = new JPanel();
		panelBebida9.setBounds(0, 416, 175, 40);
		panelBebidas.add(panelBebida9);
		panelBebida9.setLayout(null);
		panelBebida9.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_10 = new JLabel("Continentinho");
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_10.setBounds(6, 6, 120, 26);
		panelBebida9.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(138, 7, 30, 26);
		panelBebida9.add(textField_11);
		
		JPanel panelSnacks = new JPanel();
		panelSnacks.setLayout(null);
		panelSnacks.setBounds(193, 6, 175, 456);
		mudaPreco.add(panelSnacks);
		
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
		mudaPreco.add(panel2Snacks);
		
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
		mudaPreco.add(panelOutros);
		
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
		
		JPanel panel_23 = new JPanel();
		panel_23.setLayout(null);
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_23.setBounds(0, 104, 175, 40);
		panelOutros.add(panel_23);
		
		JLabel label_28 = new JLabel("Continentinho");
		label_28.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_28.setBounds(6, 6, 120, 26);
		panel_23.add(label_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(138, 7, 30, 26);
		panel_23.add(textField_29);
		
		JPanel panel_24 = new JPanel();
		panel_24.setLayout(null);
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_24.setBounds(0, 156, 175, 40);
		panelOutros.add(panel_24);
		
		JLabel label_29 = new JLabel("Continentinho");
		label_29.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_29.setBounds(6, 6, 120, 26);
		panel_24.add(label_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(138, 7, 30, 26);
		panel_24.add(textField_30);
		
		JPanel panel_25 = new JPanel();
		panel_25.setLayout(null);
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_25.setBounds(0, 208, 175, 40);
		panelOutros.add(panel_25);
		
		JLabel label_30 = new JLabel("Continentinho");
		label_30.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_30.setBounds(6, 6, 120, 26);
		panel_25.add(label_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(138, 7, 30, 26);
		panel_25.add(textField_31);
		
		JPanel panel_26 = new JPanel();
		panel_26.setLayout(null);
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_26.setBounds(0, 260, 175, 40);
		panelOutros.add(panel_26);
		
		JLabel label_31 = new JLabel("Continentinho");
		label_31.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_31.setBounds(6, 6, 120, 26);
		panel_26.add(label_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(138, 7, 30, 26);
		panel_26.add(textField_32);
		
		JPanel panel_27 = new JPanel();
		panel_27.setLayout(null);
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_27.setBounds(0, 312, 175, 40);
		panelOutros.add(panel_27);
		
		JLabel label_32 = new JLabel("Continentinho");
		label_32.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_32.setBounds(6, 6, 120, 26);
		panel_27.add(label_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(138, 7, 30, 26);
		panel_27.add(textField_33);
		
		JPanel panel_28 = new JPanel();
		panel_28.setLayout(null);
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_28.setBounds(0, 364, 175, 40);
		panelOutros.add(panel_28);
		
		JLabel label_33 = new JLabel("Continentinho");
		label_33.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_33.setBounds(6, 6, 120, 26);
		panel_28.add(label_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(138, 7, 30, 26);
		panel_28.add(textField_34);
		
		JPanel panel_29 = new JPanel();
		panel_29.setLayout(null);
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_29.setBounds(0, 416, 175, 40);
		panelOutros.add(panel_29);
		
		JLabel label_34 = new JLabel("Continentinho");
		label_34.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_34.setBounds(6, 6, 120, 26);
		panel_29.add(label_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(138, 7, 30, 26);
		panel_29.add(textField_35);
		
		JButton btnNewButton = new JButton("OK\n");
		btnNewButton.setBounds(754, 408, 116, 54);
		mudaPreco.add(btnNewButton);
	}
}
