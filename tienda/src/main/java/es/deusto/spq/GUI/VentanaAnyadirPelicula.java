package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Pelicula;

public class VentanaAnyadirPelicula {
	
	private JFrame frame;
	private JTextField nombre;
	private JComboBox genero;
	private JTextField director;
	private JTextField actor;
	private JButton anyadir;
	private JButton atras;
	
	public VentanaAnyadirPelicula() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame("Añadir Pelicula");
		frame. setBounds(100, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel lnombre = new JLabel("Nombre de la pelicula: ");
		lnombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lnombre.setBounds(75, 150, 100, 20);
		panelPrincipal.add(lnombre);
		
		JLabel ltipo = new JLabel("Genero de la pelicula : ");
		ltipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ltipo.setBounds(75, 200, 100, 20);
		panelPrincipal.add(ltipo);
		
		JLabel ldirector = new JLabel("Nombre del director: ");
		ldirector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ldirector.setBounds(75, 250, 100, 20);
		panelPrincipal.add(ldirector);
		
		JLabel lactor = new JLabel("Nombre del actor principal: ");
		lactor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lactor.setBounds(75, 300, 120, 20);
		panelPrincipal.add(lactor);
		
		nombre = new JTextField();
		nombre.setBounds(250, 150, 150, 25);
		panelPrincipal.add(nombre);	
		
		genero = new JComboBox();
		genero.addItem("Accion");
		genero.addItem("Terror");
		genero.addItem("Drama");
		genero.addItem("Ciencia ficcion");	
		genero.setBounds(50, 200, 150, 25);
		panelPrincipal.add(genero);
		
		director = new JTextField();
		director.setBounds(250, 250, 150, 25);
		panelPrincipal.add(director);
		
		actor = new JTextField();
		actor.setBounds(250, 300, 150, 25);
		panelPrincipal.add(actor);
		
		frame.setVisible(true);
		
		anyadir = new JButton("Añadir");
		anyadir.setFocusPainted(false);
		anyadir.setBounds(230, 500, 150, 25);
		panelPrincipal.add(anyadir);
		
		atras = new JButton("Atrás");
		atras.setFocusPainted(false);
		atras.setBounds(90, 500, 90, 25);
		panelPrincipal.add(atras);
		
		anyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosGUI metodos = new MetodosGUI();
				metodos.comprobarVacio(nombre);
				metodos.comprobarVacioItem(genero);
				metodos.comprobarVacio(director);
				metodos.comprobarVacio(actor);
				
				if (metodos.comprobarVacio(nombre) && metodos.comprobarVacioItem(genero)
						&& metodos.comprobarVacio(director) && metodos.comprobarVacio(actor)) {
					Pelicula nueva = new Pelicula();
					nueva.setNombre(nombre.getText());
					nueva.setTipo(genero.getSelectedItem().toString());
					nueva.setDirector(director.getText());
					nueva.setActor(actor.getText());
					
					Response response = Controller.getInstance().guardarNuevaPelicula(nueva);
					
					if (response.getStatus() == Status.OK.getStatusCode()) {
			        	
			            JOptionPane.showMessageDialog(null, "Libro creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			            new VentanaMenu();
			            frame.dispose();
			            
			        } else {
			            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
			        }
					
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
			}
			
				
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
