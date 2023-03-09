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
import utility.Distancias;
import javax.swing.SwingConstants;


public class MenuDistancias extends JFrame{
	private String[] DiferentesDistancias = { " Kilometros", " Millas" , " Hectometros", " Leguas"};
	private JPanel contentPane;
	private JTextField Valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDistancias frame = new MenuDistancias();
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
	public MenuDistancias() {
		setTitle("Challengeoneconversorlatam4");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 346);
		contentPane = new JPanel(); 
		contentPane.setBackground(Color.BLACK); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox DistanciaB = new JComboBox();
		DistanciaB.setBounds(228, 67, 122, 22);
		contentPane.add(DistanciaB);
		DistanciaB.addItem("-Seleccione-");

		JComboBox DistanciaA = new JComboBox();
		DistanciaA.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		DistanciaA.setBackground(Color.WHITE);
		for (int i = 0; i < DiferentesDistancias.length; i++) {
			DistanciaA.addItem(DiferentesDistancias[i]);
			DistanciaB.addItem(DiferentesDistancias[i]);
		}

		DistanciaA.setBounds(31, 67, 122, 22);
		contentPane.add(DistanciaA);
 
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
						String tipoDistanciaA = DistanciaA.getSelectedItem().toString().split(" ")[1].trim();
						String tipoDistanciaB = DistanciaB.getSelectedItem().toString().split(" ")[1].trim();
						Distancias DistanciaMin = new Distancias(tipoDistanciaA, Double.parseDouble(Valor.getText()));
						Distancias DistanciaMax = new Distancias(tipoDistanciaB);
						ConverDis conversor = new ConverDis(DistanciaMin, DistanciaMax);
						DecimalFormat formato2 = new DecimalFormat("#.##");
						LabelDistanciaTotal.setText("La conversion de "+tipoDistanciaA +" a " + tipoDistanciaB + " es: " +formato2.format(conversor.convertir()));
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
		btnConvert.setBounds(157, 203, 89, 23);
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
		
		JLabel lblNewLabel = new JLabel("Distancia a Convertir");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(94, 11, 207, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(163, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		

		DistanciaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DistanciaB.getSelectedItem() == "--") {
					btnConvert.setEnabled(false);
					LabelDistanciaTotal.setText("");
				} else if (DistanciaB.getSelectedItem() == DistanciaA.getSelectedItem()) {
					btnConvert.setEnabled(false);
					
					LabelDistanciaTotal.setText("Error! No puede convertir "+ DistanciaA.getSelectedItem()+ " Por " + DistanciaA.getSelectedItem()  );
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