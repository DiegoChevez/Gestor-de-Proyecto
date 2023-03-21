package sv.com.telecomunicaciones.util;
import javax.swing.*;
import java.sql.*;
public class ConexionSQL {
	Connection conectar = null;

	public Connection conexion(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/telecomunicacionessv", "root","");

		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error"+e.getMessage(), "No se ha conectado",JOptionPane.ERROR_MESSAGE);
		}
		return conectar;
	}
}
