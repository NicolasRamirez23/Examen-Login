import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;

import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
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
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class MiVentana extends JFrame {
	JPanel actual=null;
	JPanel anterior=null;
	JPanel bienvenida;
	JPanel login;
	JPanel miCuentaPanel;
	JPanel registro;
	JPanel perfil;
	JPanel accesoPermitido;
    JPanel listaUsuarios;
	JPanel ayuda;
	String nombre;
	DefaultTableModel tableModel;
	JTable table;
	ArrayList<String[]> usersList;

	private DefaultTableModel modelo;


	
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
		miCuentaPanel.setSize(525,700);
		miCuentaPanel.setLocation(0,0);
		miCuentaPanel.setLayout(null);
		miCuentaPanel.setBackground(Color.ORANGE);
		
		JLabel editarPerfil = new JLabel();
		editarPerfil.setText("Bienvenido "+ nombre);
		editarPerfil.setBounds(100, 10, 300, 80);
		editarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		editarPerfil.setForeground(Color.BLACK);
		editarPerfil.setFont(new Font("cooper black",0,25));
		
		miCuentaPanel.add(editarPerfil);
		
		JLabel iconoLista = new JLabel(new ImageIcon("iconoLista.JPG"));
		iconoLista.setBounds(165, 80, 170, 170);
		miCuentaPanel.add(iconoLista);

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(70, 300, 100, 20);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 300, 200, 20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(70, 330, 100, 20);
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(200, 330, 200, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(70, 360, 100, 20);
        JTextField emailField = new JTextField();
        emailField.setBounds(200, 360, 200, 20);


        JLabel passwordLabel = new JLabel("Contraseña:");

        

        passwordLabel.setBounds(70, 390, 100, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 390, 200, 20);


        JLabel confirmPasswordLabel = new JLabel("Confirmar contraseña:");

        

        confirmPasswordLabel.setBounds(70, 420, 150, 20);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 420, 150, 20);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(150, 450, 100, 30);

        JButton updateButton = new JButton("Actualizar datos");
        updateButton.setBounds(260, 450, 130, 30);

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
        
        remove(anterior);
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
		


		JLabel iniciarcontraseña = new JLabel("Contraseña",JLabel.CENTER);
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
		
		JLabel editarPerfil = new JLabel();
		editarPerfil.setText("Editar Perfil");
		editarPerfil.setBounds(100, 10, 300, 80);
		editarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		editarPerfil.setForeground(Color.BLACK);
		editarPerfil.setFont(new Font("cooper black",0,25));
		
		perfil.add(editarPerfil);
		
		JLabel iconoLista = new JLabel(new ImageIcon("iconoLista.JPG"));
		iconoLista.setBounds(165, 80, 170, 170);
		perfil.add(iconoLista);
		
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
		

		JLabel registrocontraseña = new JLabel("Ingrese contraseña",JLabel.CENTER);
		registrocontraseña.setFont(new Font("Comic Sans", Font.BOLD,16));
		registrocontraseña.setSize(250, 30);
		registrocontraseña.setLocation(75, 290);
		registrocontraseña.setOpaque(true);
		registrocontraseña.setBackground(Color.GREEN);
		registro.add(registrocontraseña);
		
		JLabel repetircontrasena = new JLabel("Repetir contraseña",JLabel.CENTER);

		

		repetircontrasena.setFont(new Font("Comic Sans", Font.BOLD,16));
		repetircontrasena.setSize(250, 30);
		repetircontrasena.setLocation(75, 360);
		repetircontrasena.setOpaque(true);
		repetircontrasena.setBackground(Color.GREEN);
		registro.add(repetircontrasena);


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
		
		//contraseña
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
		
		String contra1 = new String(password.getPassword());
		String contra2 = new String(repetirpassword.getPassword());
		
		finalregistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int errores=0;
				
				if (!contra1.equals(contra2)) {
				    JOptionPane.showMessageDialog(finalregistro, "Las contraseñas no coinciden. Intenta denuevo.");
				    errores++;
				} else {
				    
				}
						
						
					
					if (errores == 0) {
			            try (PrintWriter out = new PrintWriter(new FileWriter("users.txt", true))) {
			                out.println(username.getText() + "," + apellidos.getText() + "," + correo.getText() + "," + contra1+","+contra2);
			                JOptionPane.showMessageDialog(finalregistro, "Registro exitoso.");
			                // Limpiar los campos del formulario
			                username.setText("");
			                apellidos.setText("");
			                correo.setText("");
			                password.setText("");
			                repetirpassword.setText("");
			            } catch (IOException ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(finalregistro, "Error al guardar el registro.");
			            }
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
	
	
	public void ListaUsuario() {
		
	        listaUsuarios = new JPanel(new BorderLayout());
	        listaUsuarios.setSize(525,700);
	        listaUsuarios.setLocation(0,0);
	        listaUsuarios.setLayout(null);
	        listaUsuarios.setBackground(Color.GREEN);
	        

	        JLabel listausuario= new JLabel("Lista de usuarios");
   		 listausuario.setFont(new Font("Comic Sans", Font.BOLD,30));
   		 listausuario.setBounds(130, 10, 300, 50);
   		listaUsuarios.add(listausuario);
   		
   		 JLabel editar = new JLabel("Editar");
   	     editar.setFont(new Font("Comic Sans", Font.BOLD,20));
   	     editar.setBounds(10, 30, 450, 100);
   	     listaUsuarios.add(editar);
   	     
   	     
   	  JPanel panel = new JPanel(new BorderLayout());

   	ArrayList<String> usuarios = new ArrayList<>();
   	try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
   	    String line;
   	    while ((line = br.readLine()) != null) {
   	        String[] data = line.trim().split(",");
   	        if (data.length == 4) {
   	            String usuario = data[0] + " " + data[1];
   	            usuarios.add(usuario);
   	        }
   	    }
   	} catch (Exception e) {
   	    e.printStackTrace();
   	}

   	String[] usuariosArray = usuarios.toArray(new String[0]);
   	JComboBox<String> comboBox = new JComboBox<>(usuariosArray);
   	comboBox.setBounds(180, 100, 150, 50);

   listaUsuarios.add(comboBox, BorderLayout.CENTER);
   	listaUsuarios.add(panel, BorderLayout.NORTH);
   	     
   	JButton btnSeleccionarUsuario = new JButton("Seleccionar usuario");
   	btnSeleccionarUsuario.setBounds(180, 170, 150, 50);
  	listaUsuarios.add(btnSeleccionarUsuario, BorderLayout.CENTER);

   	// Agregar acción al botón
   	btnSeleccionarUsuario.addActionListener(new ActionListener() {
   	    public void actionPerformed(ActionEvent e) {
   	        String usuarioSeleccionado = (String) comboBox.getSelectedItem();
   	        btnSeleccionarUsuario.setText(usuarioSeleccionado);
   	        
   	     btnSeleccionarUsuario.addActionListener(new ActionListener() {
 		    @Override
 		    public void actionPerformed(ActionEvent e) {
 		        
 		    	menuMiCuenta();
 		    }
 		});
 		
   	     
   	    }
   	});
   	

   	String[] columnNames = {"Nombre", "Apellido", "Correo", "Contraseña", "Eliminar"};
   	DefaultTableModel model = new DefaultTableModel(columnNames, 0);

   	try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
   	    String line;
   	    while ((line = br.readLine()) != null) {
   	        String[] data = line.trim().split(",");
   	        if (data.length == 4) {
   	            Object[] rowData = new Object[data.length + 1];
   	            System.arraycopy(data, 0, rowData, 0, data.length);
   	            rowData[data.length] = "Eliminar";
   	            model.addRow(rowData);
   	        }
   	    }
   	} catch (Exception e) {
   	    e.printStackTrace();
   	}

   	JTable table = new JTable(model);
   	table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
   	table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox()));
   	table.addMouseListener(new MouseAdapter() {
   	    @Override
   	    public void mouseClicked(MouseEvent e) {
   	        int column = table.getColumnModel().getColumnIndex("Eliminar");
   	        int row = table.rowAtPoint(e.getPoint());
   	     if (column == table.getColumnModel().getColumnIndex("Eliminar") && row != -1) {
   	      model.removeRow(row);
   	        }
   	    }
   	});
   	JScrollPane scrollPane = new JScrollPane(table);
   	scrollPane.setBounds(20, 300, 480, 100);
   	listaUsuarios.add(scrollPane, BorderLayout.CENTER);
   	
   	
   	
   	


   	

	        
	        

	        anterior=actual;
			actual=listaUsuarios;
			remove(anterior);
			add(actual);
			
			repaint();
			revalidate();
	        
	    }
	
	
	public void Ayuda() {
		remove(perfil);
		ayuda = new JPanel();
        ayuda.setSize(400, 290);
        ayuda.setLocation(50, 50);
        ayuda.setLayout(null);
        ayuda.setBackground(Color.GRAY);
        
        
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
		perfil.setSize(525,700);
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
		

		listaUsuarioMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        ListaUsuario();
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