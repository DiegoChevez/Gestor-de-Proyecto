package sv.com.telecomunicaciones.metodos.login;
import sv.com.telecomunicaciones.util.ConexionSQL;
import sv.com.telecomunicaciones.bins.loginBeans.LoginBeans;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarEmpleado {
	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.conexion();

	private int idUsuario;
	private int idTrabajador;
	private String username;
	private String userpass;
	private String estado;
	private String nombresUser;
	private String apellidosUser;
	private String rolEmpleado;
	private String areaEmpleado;


	public void BuscarEmpleado(int idUser, int idEmpleado, String usuario, String contrasena, String estado){

		this.idUsuario = idUser;
		this.idTrabajador = idEmpleado;
		this.username = usuario;
		this.userpass = contrasena;
		this.estado = estado;

		int resulSQL;

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

					//Guardar Datos
					LoginBeans loginBeans = new LoginBeans();
					loginBeans.setNombresUser(nombresUser);
					loginBeans.setApellidosUser(apellidosUser);
					loginBeans.setRolEmpleado(rolEmpleado);
					loginBeans.setAreaEmpleado(areaEmpleado);

					VistasModulos vistasModulos = new VistasModulos();
					vistasModulos.VistasModulos(idUsuario,idTrabajador,rolEmpleado,areaEmpleado);

				}
			}else {
				JOptionPane.showMessageDialog(null, "No se encontro el empleado" );
			}
			st.close();
			rs.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error "+e.getMessage() );
		}

	}

}
