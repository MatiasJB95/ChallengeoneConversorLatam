package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class main extends JFrame {

	private JPanel contentPane;

	
/* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setTitle("Challengeoneconversorlatam4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton MenuMoneda = new JButton("Monedas");
		MenuMoneda.setBorderPainted(false);
		MenuMoneda.setForeground(Color.WHITE);
		MenuMoneda.setBackground(Color.GRAY);
		MenuMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuMonedas moneda = new MenuMonedas(); 
				moneda.setVisible(true);
				dispose();
			}
		});
		MenuMoneda.setBounds(45, 195, 96, 23);
		contentPane.add(MenuMoneda);
		
		JButton MenuTemperatura = new JButton("Distancias");
		MenuTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDistancias distancia = new MenuDistancias();
				distancia.setVisible(true);
				dispose();
			}
		});
		MenuTemperatura.setForeground(Color.WHITE);
		MenuTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		MenuTemperatura.setBackground(Color.GRAY);
		MenuTemperatura.setBorderPainted(false);
		MenuTemperatura.setBounds(252, 195, 110, 23);
		contentPane.add(MenuTemperatura);
		
		JLabel lblNewLabel = new JLabel("Seleccione alguna de las opciones");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-62, 105, 530, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Conversor");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-30, 35, 452, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Challengeoneconversorlatam4 hecho por Matias Badano");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(28, 256, 356, 26);
		contentPane.add(lblNewLabel_2);
	}
}