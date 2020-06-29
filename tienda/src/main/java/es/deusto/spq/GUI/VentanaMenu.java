package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaMenu extends JFrame{
	
	private JButton anadir;
	private JButton consultar;
	private JButton atras;
	private JFrame frame;
	
	public VentanaMenu() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		
		anadir = new JButton("Anyadir nuevo articulo");
		anadir.setFocusPainted(false);
		anadir.setBounds(45, 100, 200, 50);
		panelPrincipal.add(anadir);
		
		consultar = new JButton("Consultar stock");
		consultar.setFocusPainted(false);
		consultar.setBounds(265, 100, 200, 50);
		panelPrincipal.add(consultar);
		
		atras = new JButton("Cerrar sesion");
		atras.setFocusPainted(false);
		atras.setBounds(170, 200, 150, 28);
		panelPrincipal.add(atras);
		
		
		frame.setVisible(true);
		
	
	
	anadir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new VentanaAnyadirPelicula();
			
		}
	});
	
	}
}
