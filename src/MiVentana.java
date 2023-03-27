import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MiVentana extends JFrame {
	JPanel actual=null;
	JPanel anterior=null;
	JPanel bienvenida;
	JPanel login;
	JPanel miCuentaPanel;
	JPanel registro;
	JPanel perfil;
	JPanel accesoPermitido;
	JPanel ayuda;
	String nombre;
	
	public MiVentana() {
		this.setVisible(true);
		this.setSize(525, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Menu Principal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.ORANGE);
	
		Bienvenida();
		timer();
		repaint();
		revalidate();
		
		
	}
	
	
	public void timer() {
		
		Timer timer = new Timer();
		
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				Login();
			}
		};
		
		timer.schedule(tarea, 2000);
		
	}

	
	public void Bienvenida() {

		bienvenida = new JPanel();
		bienvenida.setSize(300,120);
		bienvenida.setLocation(100,180);
		bienvenida.setLayout(null);
		bienvenida.setBackground(Color.RED);
		
		JLabel titleinicio = new JLabel("Bienvenido",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleinicio.setSize(260, 40);
		titleinicio.setLocation(20, 40);
		titleinicio.setOpaque(true);
		titleinicio.setBackground(Color.GREEN);
		bienvenida.add(titleinicio);
		
		actual=bienvenida;
		
		add(actual);
		
		repaint();
		revalidate();
	}
	
	
	public void menuMiCuenta() {
		miCuentaPanel = new JPanel();
        miCuentaPanel.setSize(525, 290);
        miCuentaPanel.setLocation(0, 350);
        miCuentaPanel.setLayout(null);
        miCuentaPanel.setBackground(Color.GREEN);

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(20, 20, 100, 20);
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(20, 50, 100, 20);
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(120, 50, 200, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 80, 100, 20);
        JTextField emailField = new JTextField();
        emailField.setBounds(120, 80, 200, 20);

        JLabel passwordLabel = new JLabel("ContraseÃ±a:");
        passwordLabel.setBounds(20, 110, 100, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 110, 200, 20);

        JLabel confirmPasswordLabel = new JLabel("Confirmar contraseÃ±a:");
        confirmPasswordLabel.setBounds(20, 140, 150, 20);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(170, 140, 150, 20);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(150, 180, 100, 30);

        JButton updateButton = new JButton("Actualizar datos");
        updateButton.setBounds(260, 180, 130, 30);

        miCuentaPanel.add(nameLabel);
        miCuentaPanel.add(nameField);
        miCuentaPanel.add(apellidoLabel);
        miCuentaPanel.add(apellidoField);
        miCuentaPanel.add(emailLabel);
        miCuentaPanel.add(emailField);
        miCuentaPanel.add(passwordLabel);
        miCuentaPanel.add(passwordField);
        miCuentaPanel.add(confirmPasswordLabel);
        miCuentaPanel.add(confirmPasswordField);
        miCuentaPanel.add(cancelButton);
        miCuentaPanel.add(updateButton);

        cancelButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		       Perfil();
		    }
		});
      
        anterior = actual;
        actual = miCuentaPanel;
        remove(perfil);
        add(actual);
        revalidate();
        repaint();
	}
	
	
	public void Login () {
		login = new JPanel();
		login.setSize(400,290);
		login.setLocation(50,50);
		login.setLayout(null);
		login.setBackground(Color.ORANGE);
		
		JLabel titleinicio = new JLabel("Iniciar Sesion",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleinicio.setSize(280, 40);
		titleinicio.setLocation(60, 40);
		titleinicio.setOpaque(true);
		titleinicio.setBackground(Color.GREEN);
		login.add(titleinicio);
		
		JLabel usuario = new JLabel("Ingrese su usuario",JLabel.CENTER);
		usuario.setFont(new Font("Comic Sans", Font.BOLD,16));
		usuario.setSize(250, 20);
		usuario.setLocation(75, 95);
		usuario.setOpaque(true);
		usuario.setBackground(Color.GREEN);
		login.add(usuario);
		
		JLabel iniciarcontraseña = new JLabel("ContraseÃ±a",JLabel.CENTER);
		iniciarcontraseña.setFont(new Font("Comic Sans", Font.BOLD,16));
		iniciarcontraseña.setSize(250, 30);
		iniciarcontraseña.setLocation(75, 155);
		iniciarcontraseña.setOpaque(true);
		iniciarcontraseña.setBackground(Color.GREEN);
		login.add(iniciarcontraseña);
		
		JButton entrarcuentar = new JButton();
		entrarcuentar.setText("Aceptar");
		entrarcuentar.setSize(100, 40);
		entrarcuentar.setLocation(150, 225);
		entrarcuentar.setOpaque(true);
		entrarcuentar.setBackground(Color.white);
		login.add(entrarcuentar);
		
		JTextField username = new JTextField("Nicolas");
		username.setSize(250, 30);
		username.setLocation(75, 120);
		login.add(username);
		
		JPasswordField password = new JPasswordField("niko1");
		password.setSize(250, 30);
		password.setLocation(75, 190);
		login.add(password);
	
		entrarcuentar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = username.getText();
				String pwd = new String (password.getPassword());
				
				BufferedReader reader;
				
				Boolean flag = false;
				
				try{
					
					FileReader file = new FileReader("users.txt");
					reader = new BufferedReader(file);
					
					String line = reader.readLine();
					
					while(line != null) {
						
						String data [] = line.split(",");
						 
						if( user.equals(data[0]) ) {
							if( pwd.equals(data[3]) ) {
								flag = true;
							}
						} 
						
						line = reader.readLine();
						
					}
					
					if(flag==true) {
						nombre = username.getText();
						JOptionPane.showMessageDialog(null,"Bienvenido "+nombre,"Acceso Permitido", JOptionPane.CLOSED_OPTION );
						Perfil();
						
					}else {
						JOptionPane.showMessageDialog(null,"Error","Datos incorrectos, intentar denuevo.", JOptionPane.ERROR_MESSAGE );
					}
					
					
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		anterior=actual;
		actual=login;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
}	
	
	
	
	
	public void menuCrearUsuario() {
		registro = new JPanel();
		registro.setSize(400,550);
		registro.setLocation(50,50);
		registro.setLayout(null);
		registro.setBackground(Color.RED);
		
		JLabel titleregistro = new JLabel("Registro de Nuevo Usuario",JLabel.CENTER);
		titleregistro.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleregistro.setSize(280, 40);
		titleregistro.setLocation(60, 40);
		titleregistro.setOpaque(true);
		titleregistro.setBackground(Color.GREEN);
		registro.add(titleregistro);
	
		//Etiquetas
		JLabel nombre = new JLabel("Ingrese sus nombres",JLabel.CENTER);
		nombre.setFont(new Font("Comic Sans", Font.BOLD,16));
		nombre.setSize(250, 20);
		nombre.setLocation(75, 95);
		nombre.setOpaque(true);
		nombre.setBackground(Color.GREEN);
		registro.add(nombre);
				
		JLabel apellido = new JLabel("Apellidos",JLabel.CENTER);
		apellido.setFont(new Font("Comic Sans", Font.BOLD,16));
		apellido.setSize(250, 20);
		apellido.setLocation(75, 155);
		apellido.setOpaque(true);
		apellido.setBackground(Color.GREEN);
		registro.add(apellido);
				
		JLabel correoregistro = new JLabel("Ingrese su correo electronico",JLabel.CENTER);
		correoregistro.setFont(new Font("Comic Sans", Font.BOLD,16));
		correoregistro.setSize(250, 30);
		correoregistro.setLocation(75, 220);
		correoregistro.setOpaque(true);
		correoregistro.setBackground(Color.GREEN);
		registro.add(correoregistro);
		
		JLabel registrocontraseña = new JLabel("Ingrese contraseÃ±a",JLabel.CENTER);
		registrocontraseña.setFont(new Font("Comic Sans", Font.BOLD,16));
		registrocontraseña.setSize(250, 30);
		registrocontraseña.setLocation(75, 290);
		registrocontraseña.setOpaque(true);
		registrocontraseña.setBackground(Color.GREEN);
		registro.add(registrocontraseña);
		
		JLabel repetircontraseña = new JLabel("Repetir contraseÃ±a",JLabel.CENTER);
		repetircontraseña.setFont(new Font("Comic Sans", Font.BOLD,16));
		repetircontraseña.setSize(250, 30);
		repetircontraseña.setLocation(75, 360);
		repetircontraseña.setOpaque(true);
		repetircontraseña.setBackground(Color.GREEN);
		registro.add(repetircontraseña);

		//Campo Para Escribir
		//Nombres
		JTextField username = new JTextField();
		username.setSize(250, 30);
		username.setLocation(75, 120);
		registro.add(username);
		
		//Apellido
		JTextField apellidos = new JTextField();
		apellidos.setSize(250, 30);
		apellidos.setLocation(75, 180);
		registro.add(apellidos);
		
		//Correo
		JTextField correo = new JTextField();
		correo.setSize(250, 30);
		correo.setLocation(75, 255);
		registro.add(correo);
		
		//contraseï¿½a
		JPasswordField password = new JPasswordField();
		password.setSize(250, 30);
		password.setLocation(75, 325);
		registro.add(password);
		
		JPasswordField repetirpassword = new JPasswordField();
		repetirpassword.setSize(250, 30);
		repetirpassword.setLocation(75, 395);
		registro.add(repetirpassword);
		
		JLabel tyc = new JLabel("Terminos y condiciones",JLabel.CENTER);
		tyc.setFont(new Font("Comic Sans", Font.BOLD,16));
		tyc.setSize(250, 40);
		tyc.setLocation(75, 430);
		tyc.setOpaque(true);
		tyc.setBackground(Color.GREEN);
		registro.add(tyc);
		
		JRadioButton acepto = new JRadioButton("Acepto");
		acepto.setSize(100, 20);
		acepto.setLocation(95, 475);
		acepto.setOpaque(true);
		acepto.setBackground(Color.cyan);
		registro.add(acepto);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(acepto);
		
		JButton finalregistro = new JButton();
		finalregistro.setText("Aceptar");
		finalregistro.setSize(100, 40);
		finalregistro.setLocation(150, 500);
		finalregistro.setOpaque(true);
		finalregistro.setBackground(Color.white);
		registro.add(finalregistro);
		
		JButton cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setSize(90, 20);
		cancelar.setLocation(300, 515);
		cancelar.setOpaque(true);
		cancelar.setBackground(Color.white);
		registro.add(cancelar);
		
		String contra1 = password.toString();
		String contra2 = repetirpassword.toString();
		
		finalregistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int errores=0;
				
					if(password.toString() != repetirpassword.toString()) {
						JOptionPane.showMessageDialog(finalregistro,"Las contraseÃ±as no coinciden. Intenta denuevo.");
						errores++;
					}
					
							
				repaint();
				revalidate();
			}
			
		});
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Perfil();
					
							
				repaint();
				revalidate();
			}
			
		});
		
		
		
		anterior=actual;
		actual=registro;
		remove(anterior);
		add(actual);
		repaint();
		revalidate();
	}
	
	
	
	
	public void Ayuda() {
		ayuda = new JPanel();
        ayuda.setSize(400, 290);
        ayuda.setLocation(50, 50);
        ayuda.setLayout(null);
        ayuda.setBackground(Color.ORANGE);
        
        
        JLabel instrucciones1 = new JLabel("1-Hacer click en la opcion Usuarios en el menu superior");
        instrucciones1.setFont(new Font("Comic Sans", Font.BOLD,12));
        instrucciones1.setBounds(20, 20, 400, 20);
       

        JLabel instrucciones2 = new JLabel("2-Hacer click en la opcion crear Usuario en el menu desplegado");
        instrucciones2.setFont(new Font("Comic Sans", Font.BOLD,12));
        instrucciones2.setBounds(20, 50, 450, 20);
       

        JLabel instrucciones3 = new JLabel("3-Llenar los campos solicitados");
        instrucciones3.setFont(new Font("Comic Sans", Font.BOLD,12));
        instrucciones3.setBounds(20, 80, 300, 20);
        

        JLabel instrucciones4 = new JLabel("4-Hacer click en el boton aceptar");
        instrucciones4.setFont(new Font("Comic Sans", Font.BOLD,12));
        instrucciones4.setBounds(20, 110,350, 20);
       

        JLabel instrucciones5 = new JLabel("5-Listo, el usuario se ha creado");
        instrucciones5.setFont(new Font("Comic Sans", Font.BOLD,12));
        instrucciones5.setBounds(20, 140, 300, 20);
        
        JButton crearcuenta = new JButton();
        crearcuenta.setText("Crear nuevo usuario");
        crearcuenta.setSize(300, 40);
        crearcuenta.setLocation(50, 225);
        crearcuenta.setOpaque(true);
        crearcuenta.setBackground(Color.white);
        
        ayuda.add(instrucciones1);
      
        ayuda.add(instrucciones2);
     
        ayuda.add(instrucciones3);
       
        ayuda.add(instrucciones4);
      
        ayuda.add(instrucciones5);
        
        ayuda.add(crearcuenta);
       
        crearcuenta.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuCrearUsuario();
		    }
		});
		
        anterior=actual;
		actual=ayuda;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
		
		
	}

	
	public void Perfil() {
		perfil = new JPanel();
		perfil.setSize(525,350);
		perfil.setLocation(0,0);
		perfil.setLayout(null);
		perfil.setBackground(Color.ORANGE);
		
		JMenu cuentaMenu = new JMenu("Cuenta");
		JMenuItem miCuentaMenuItem = new JMenuItem("Mi cuenta");
		cuentaMenu.add(miCuentaMenuItem);
		JMenuItem cerrarSesionMenuItem = new JMenuItem("Cerrar sesion");
		cuentaMenu.add(cerrarSesionMenuItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(cuentaMenu);
		this.setJMenuBar(menuBar);

		JMenu usuariosMenu = new JMenu("Usuarios");
		JMenuItem listaUsuarioMenuItem = new JMenuItem("Lista de usuarios");
		JMenuItem crearUsuarioMenuItem = new JMenuItem("Crear usuarios");
		usuariosMenu.add(listaUsuarioMenuItem);
		usuariosMenu.add(crearUsuarioMenuItem);
		menuBar.add(usuariosMenu);

		JMenu ayudaMenu = new JMenu("Ayuda");
		JMenuItem manualMenuItem = new JMenuItem("Como crear usuarios??");
		ayudaMenu.add(manualMenuItem);
		menuBar.add(ayudaMenu);
		
		JLabel bienvenidaPerfil = new JLabel();
		bienvenidaPerfil.setText("Bienvenido "+ nombre);
		bienvenidaPerfil.setBounds(100, 10, 300, 80);
		bienvenidaPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenidaPerfil.setForeground(Color.BLACK);
		bienvenidaPerfil.setFont(new Font("cooper black",0,25));
		
		perfil.add(bienvenidaPerfil);
		
		JLabel iconoLista = new JLabel(new ImageIcon("iconoLista.JPG"));
		iconoLista.setBounds(165, 80, 170, 170);
		perfil.add(iconoLista);
		
		
		miCuentaMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuMiCuenta();
		    }
		});
		
		crearUsuarioMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuCrearUsuario();
		    }
		});
		
		crearUsuarioMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuCrearUsuario();
		    }
		});
		
		cerrarSesionMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		    	JOptionPane.showMessageDialog(null,"Adios "+nombre,"Bye bye", JOptionPane.CLOSED_OPTION );
		    	menuBar.remove(cuentaMenu);
		    	menuBar.remove(usuariosMenu);
		    	menuBar.remove(ayudaMenu);
		    	Login();
		    	
		    }
		});
		
		manualMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        Ayuda();
		    }
		});
		
		anterior=actual;
		actual=perfil;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
		
		

	}

}





