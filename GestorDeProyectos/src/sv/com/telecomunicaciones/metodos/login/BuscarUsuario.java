package sv.com.telecomunicaciones.metodos.login;
import sv.com.telecomunicaciones.util.ConexionSQL;
import sv.com.telecomunicaciones.bins.loginBeans.LoginBeans;
import sv.com.telecomunicaciones.vistas.Login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BuscarUsuario {

	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.conexion();

	private int idUser;
	private int idEmpleado;
	private String username;
	private String passwdUser;
	private String status;


	public void BuscarUsuario(String txtUsuario, String txtContrasena) {

		String user = txtUsuario;
		String passwd = txtContrasena;

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

						//Guardar datos
						LoginBeans loginBeans = new LoginBeans();

						loginBeans.setIdUsuario(idUser);
						loginBeans.setIdTrabajador(idEmpleado);
						loginBeans.setUsername(username);
						loginBeans.setUserpass(passwdUser);
						loginBeans.setEstado(status);

						BuscarEmpleado buscarEmpleado = new BuscarEmpleado();
						buscarEmpleado.BuscarEmpleado(idUser,idEmpleado,username,passwdUser,status);

						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Credenciales Incorrectas" );
						Login login = new Login("Gestor DEVDEV");
						login.setVisible(true);
						break;
				}

			}else {
				JOptionPane.showMessageDialog(null, "Usuario no existe" );
				Login login = new Login("Gestor DEVDEV");
				login.setVisible(true);
			}
			//Cerrar conexiones
			st.close();
			rs.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error"+ e.getMessage() );
		}
	}
}
