package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Envio;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCorreos extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private final ButtonGroup grupoOrigen = new ButtonGroup();
	private final ButtonGroup grupoDestino = new ButtonGroup();
	private JComboBox comboTipo;
	private JRadioButton rdbNacional;
	private JRadioButton rdbNacional2;
	private JRadioButton rdbExtranjero;
	private JRadioButton rdbExtranjero2;
	private JSpinner spinnerPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioCorreos frame = new FormularioCorreos();
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
	
	public FormularioCorreos() {
		setTitle("Calculadora env\u00EDos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ciudad Origen:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 1 1");
		
		txtOrigen = new JTextField();
		contentPane.add(txtOrigen, "cell 3 1,growx");
		txtOrigen.setColumns(10);
		
		rdbNacional = new JRadioButton("Nacional");
		grupoOrigen.add(rdbNacional);
		rdbNacional.setSelected(true);
		contentPane.add(rdbNacional, "flowx,cell 3 2");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Destino:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 3");
		
		txtDestino = new JTextField();
		contentPane.add(txtDestino, "cell 3 3,growx");
		txtDestino.setColumns(10);
		
		rdbNacional2 = new JRadioButton("Nacional");
		grupoDestino.add(rdbNacional2);
		rdbNacional2.setSelected(true);
		contentPane.add(rdbNacional2, "flowx,cell 3 4");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de env\u00EDo:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 1 5");
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10 h", "Paq 14 - Antes de las 14 h", "Paq 24 - Al d\u00EDa siguiente"}));
		contentPane.add(comboTipo, "cell 3 5,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Peso:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 1 7");
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		contentPane.add(spinnerPeso, "cell 3 7");
		
		JButton btnCalcular = new JButton("Calcular Precio");
		btnCalcular.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				validar();
			}
		});
		contentPane.add(btnCalcular, "cell 3 9");
		
		rdbExtranjero = new JRadioButton("Extranjero");
		grupoOrigen.add(rdbExtranjero);
		contentPane.add(rdbExtranjero, "cell 3 2");
		
		rdbExtranjero2 = new JRadioButton("Extranjero");
		grupoDestino.add(rdbExtranjero2);
		contentPane.add(rdbExtranjero2, "cell 3 4");
	}
	

	protected void validar() {
		if (txtOrigen.getText()==null || txtOrigen.getText().isBlank()
				|| txtDestino.getText()==null || txtDestino.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, 
					"Debe introducir los campos de origen y destino",
					"Compruebe los datos", JOptionPane.WARNING_MESSAGE);
			
			return;
		} else {			
		Envio env = new Envio (txtOrigen.getText(),rdbNacional.isSelected(), 
				txtDestino.getText(), rdbNacional2.isSelected(), (String)comboTipo.getSelectedItem(), 
				(int)spinnerPeso.getValue());
		JOptionPane.showMessageDialog(this, 
				"El precio del envío es: "+ env.calculaImporte(),
				"Precio Total", JOptionPane.INFORMATION_MESSAGE);
		}
	}}	

