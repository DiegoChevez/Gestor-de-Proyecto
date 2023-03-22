package sv.com.telecomunicaciones.vistas;
import sv.com.telecomunicaciones.util.ConexionSQL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {

	//Instanciar nuestra conexion
	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.conexion();
	private JTextField txtUsuario;
	private JTextField txtContra;
	private JButton btnIngresar;
	private JPanel pnlLogin;
	private JLabel alertUser;
	private JLabel alertPasswd;
	private int idUser;
	private int idEmpleado;
	private String username;
	private String nombresUser;
	private String apellidosUser;
	private String passwdUser;
	private String rolEmpleado;
	private String areaEmpleado;
	private String status;

	public Login(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlLogin);
		this.setMinimumSize(new Dimension(600, 600));
		this.setLocationRelativeTo(getParent());

		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuscarUsuario();
			}
		});
	}

	public void BuscarUsuario() {

		String user = txtUsuario.getText();
		String passwd = String.valueOf(txtContra.getText());
		int resulSQL;

		//Nuestra Consulta
		String SQL ="SELECT * FROM usuarios where Usuario = '"+ user +"' AND Contrasena = '"+ passwd +"' AND Estado = 'Activo'";

		try {
			//definimos un metodo sql
			Statement st = con.createStatement();
			//Ejecutamos la consulta
			ResultSet rs = st.executeQuery(SQL);

			if(rs.next()){
				resulSQL = 1;
				switch (resulSQL){
					case 1:
						// Recuperar los valores de las columnas y guardarlos en variables
						idUser = rs.getInt("Id_Usuario");
						idEmpleado = rs.getInt("Empleado");
						username = rs.getString("Usuario");
						passwdUser = rs .getString("Contrasena");
						status = rs.getString("Estado");
						BuscarEmpleado(idUser, idEmpleado, username, passwdUser, status);
						st.close();
						rs.close();
						System.out.println("ID Usuario: "+idUser+"\n" +"ID Empleado: "+idEmpleado+"\n" + "Usuario: " + username+ "\n" + "Contraseña: " + passwdUser+"\n" + "Estado: " +status+"\n");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Credenciales Incorrectas" );
						break;
				}

			}else {
				JOptionPane.showMessageDialog(null, "Usuario no existe" );
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error"+ e.getMessage() );
		}
	}

	public void BuscarEmpleado(int idUser, int empleado, String Usuario, String Contrasena, String Estado){
		int resulSQL;
		this.idUser = idUser;
		this.idEmpleado = empleado;
		this.username = Usuario;
		this.passwdUser = Contrasena;
		this.status = Estado;

		String SQL ="SELECT e.Id_Empleado,e.Nombres,e.Apellidos, r.Rol AS RolEmpleado, a.Area AS AreaEmpleado FROM " +
						"empleados e INNER JOIN roles r ON e.Rol = r.Id_Rol INNER JOIN areas a ON e.Area = a.Id_Area " +
						"WHERE e.Id_Empleado ="+idEmpleado;

		try {
			//definimos un metodo sql
			Statement st = con.createStatement();
			//Ejecutamos la consulta
			ResultSet rs = st.executeQuery(SQL);

			if(rs.next()){
				resulSQL = 1;
				if (resulSQL==1){
					// Recuperar los valores de las columnas y guardarlos en variables
					nombresUser = rs.getString("Nombres");
					apellidosUser = rs.getString("Apellidos");
					rolEmpleado = rs.getString("RolEmpleado");
					areaEmpleado = rs.getString("AreaEmpleado");

					st.close();
					rs.close();
					System.out.println("Nombres: "+nombresUser+"\n"+
										"Apellidos: "+apellidosUser+"\n"+
										"rolEmpleado: "+rolEmpleado+"\n"+
										"areaEmpleado: "+areaEmpleado+"\n");

					VistasModulos(rolEmpleado, areaEmpleado);

				}
			}else {
				JOptionPane.showMessageDialog(null, "No se encontro el empleado" );
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error "+e.getMessage() );
		}


	}

	public void VistasModulos(String rolEmpleado, String areaEmpleado){
		this.rolEmpleado = rolEmpleado;
		this.areaEmpleado = areaEmpleado;

		switch(rolEmpleado) {
			case "Administrador":
				JOptionPane.showMessageDialog(null, "Usted es un Administrador", "Administrador",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuAdministrador MenuAdmin = new MenuAdministrador("title");
				MenuAdmin.setVisible(true);*/
				break;
			case "Jefe":
				JOptionPane.showMessageDialog(null, "Usted es un Jefe de Area", "Jefe de Area",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuFuncionales MenuFun = new MenuFuncionales("title");
				MenuFun.setVisible(true);*/
				break;
			case "Jefe de Desarrollo":
				JOptionPane.showMessageDialog(null, "Usted es un Jefe de Desarrollo", "Jefe de Desarrollo",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuDesarrollador MenuDev = new MenuDesarrollador("title");
				MenuDev.setVisible(true);*/
				break;
			case "Empleado":
				JOptionPane.showMessageDialog(null, "Usted es un Empleado", "Empleado",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuTester MenuTest = new MenuTester("title");
				MenuTest.setVisible(true);*/
				break;
			case "Programadores":
				JOptionPane.showMessageDialog(null, "Usted es un programador", "Programador",
						JOptionPane.INFORMATION_MESSAGE);

				/*MenuProgramador MenuProg = new MenuProgramador("title");
				MenuProg.setVisible(true);*/
				break;
			default:
				JOptionPane.showMessageDialog(null, "Usted no es un empleado", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				break;
		}
	}




}
