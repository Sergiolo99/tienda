package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.Controller;
import es.deusto.spq.data.Usuario;
import es.deusto.spq.server.DAOFactory;

public class VentanaLogin {

	private JFrame frame;
	private JTextField tFLogin;
	private JPasswordField tFCont;

	MetodosGUI mGUI = new MetodosGUI();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaLogin() {
		initialize();
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Inicio de sesion");
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
	
        
		JLabel lblLoginTit = new JLabel("Usuario");
		lblLoginTit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLoginTit.setBounds(100, 80, 90, 20);
		panelPrincipal.add(lblLoginTit);
		
		tFLogin = new JTextField();
		tFLogin.setBounds(270, 80, 140, 20);
		panelPrincipal.add(tFLogin);
		tFLogin.setColumns(10);
		
		JLabel lblContrasenya = new JLabel("Contrasenya");
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasenya.setBounds(100, 150, 90, 30);
		panelPrincipal.add(lblContrasenya);
		
		tFCont = new JPasswordField();
		tFCont.setColumns(10);
		tFCont.setBounds(270, 150, 140, 20);
		panelPrincipal.add(tFCont);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setBounds(300, 200, 89, 23);
		panelPrincipal.add(btnLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBounds(100, 200, 107, 23);
		panelPrincipal.add(btnRegistrarse);
		
		
		
		
		

		frame.setVisible(true);
		MetodosGUI mgui = new MetodosGUI();
		
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new VentanaRegistro();
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodosGUI mGUI = new MetodosGUI();
				String password1 = new String(tFCont.getPassword());
				if(!mGUI.validarUsuario(tFLogin.getText())) {
				}
				
				if(!mGUI.validarContrasenya(password1)){
					mGUI.mensajeError(tFCont, "Introduce una contraseña valida (8 o más caracteres)");
				
				}else{
					Response r = Controller.getInstance().login(tFLogin.getText(), password1);
					System.out.println(r);
					if(r.getStatus() == Status.OK.getStatusCode()){
						JOptionPane.showMessageDialog(null, "Login", "Successful", JOptionPane.INFORMATION_MESSAGE);
						Usuario u1 = DAOFactory.getInstance().createUsuarioDAO().getUsuario(tFLogin.getText());

						Controller.getInstance().setUsuario(u1);

						new VentanaMenu();
						frame.dispose();
												
					}else{
						JOptionPane.showMessageDialog(null, "Login", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}				
				
			}
		});
	}
}
