package interfaz;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utility.ConverDis;
import utility.ConverMonedas;
import utility.Distancias;
import utility.Monedas;

import javax.swing.SwingConstants;

public class MenuMonedas extends JFrame{

	private String[] MonedasDiferentes = { " Peso Argentino", " Dolar", " Euro" , " Libras Esterlinas", " Yen Japones", " Won sul-coreano"};
	private JPanel contentPane;
	private JTextField Valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMonedas frame = new MenuMonedas();
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
	public MenuMonedas() {
		setTitle("Challengeoneconversorlatam4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 346);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox MonedaB = new JComboBox();
		MonedaB.setBounds(228, 67, 122, 22);
		contentPane.add(MonedaB);
		MonedaB.addItem("-Seleccione-");

		JComboBox MonedaA = new JComboBox();
		MonedaA.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		MonedaA.setBackground(Color.WHITE);
		for (int i = 0; i < MonedasDiferentes.length; i++) {
			MonedaA.addItem(MonedasDiferentes[i]);
			MonedaB.addItem(MonedasDiferentes[i]);
		}

		MonedaA.setBounds(31, 67, 122, 22);
		contentPane.add(MonedaA);

		Valor = new JTextField();
		Valor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
					e.consume();
				}
			}
		});
		Valor.setBounds(56, 100, 86, 20);
		contentPane.add(Valor);
		Valor.setColumns(10);

		JLabel LabelDistanciaTotal = new JLabel("");
		LabelDistanciaTotal.setBounds(126, 135, 270, 23);
		contentPane.add(LabelDistanciaTotal);

		JButton btnConvert = new JButton("Convertir");
		btnConvert.setForeground(Color.WHITE);
		btnConvert.setBackground(Color.GRAY);
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Valor.getText().length() == 0) {
					LabelDistanciaTotal.setText("Error! Ingrese un Valor");
					LabelDistanciaTotal.setForeground(Color.WHITE);
				} else {
					try {
						String tipoMonedaA = MonedaA.getSelectedItem().toString().split(" ")[1].trim();
						String tipoMonedaB = MonedaB.getSelectedItem().toString().split(" ")[1].trim();
						Monedas MinMoneda = new Monedas(tipoMonedaA, Double.parseDouble(Valor.getText()));
						Monedas MaxMoneda = new Monedas(tipoMonedaB);
						ConverMonedas conversor = new ConverMonedas(MinMoneda, MaxMoneda);
						DecimalFormat formato2 = new DecimalFormat("#.#####");
						LabelDistanciaTotal.setText("La conversion de "+tipoMonedaA +" a " + tipoMonedaB + " es: " +formato2.format(conversor.convertir()));
						LabelDistanciaTotal.setForeground(Color.WHITE);
						LabelDistanciaTotal.setBounds(70, 158, 500, 22);
						int n = JOptionPane.showConfirmDialog(null , "¿Desea continuar con el Conversor?");
						 switch (n) {
					 case 0:
						 main menuMain = new main();
							menuMain.setVisible(true);
							dispose();
				            break;
				        case 1:
				        	 JOptionPane.showMessageDialog(null, "Programa Terminado");
				             System.exit(0);
				            break;
				        case 2:
				       	 JOptionPane.showMessageDialog(null, "Programa Terminado");
			             System.exit(0);
			             break;
						 }
						 }
					 catch (Exception ex) {
						LabelDistanciaTotal.setText("Algo ha salido mal");
						LabelDistanciaTotal.setForeground(Color.WHITE);
						ex.printStackTrace();
					}
				}

			}
		});
		btnConvert.setBounds(150, 191, 89, 23);
		contentPane.add(btnConvert);


		JButton btnVolver = new JButton("<- Menu Principal");
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main menuMain = new main();
				menuMain.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Ebrima", Font.PLAIN, 12));
		btnVolver.setBounds(126, 237, 150, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Tipo de Cambio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(82, 11, 207, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(163, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cotizacion a dia 9/3/22");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(27, 283, 343, 14);
		contentPane.add(lblNewLabel_2);

		MonedaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MonedaB.getSelectedItem() == "--") {
					btnConvert.setEnabled(false);
					LabelDistanciaTotal.setText("");
				} else if (MonedaB.getSelectedItem() == MonedaA.getSelectedItem()) {
					btnConvert.setEnabled(false);
					
					LabelDistanciaTotal.setText("Error! No puede convertir "+ MonedaA.getSelectedItem()+ " Por " + MonedaA.getSelectedItem()  );
					LabelDistanciaTotal.setForeground(Color.WHITE);
					LabelDistanciaTotal.setBounds(50, 158, 500, 22);
				} else {
					LabelDistanciaTotal.setText("");
					btnConvert.setEnabled(true);
					
				}
				
			}
			
		});
	}
}