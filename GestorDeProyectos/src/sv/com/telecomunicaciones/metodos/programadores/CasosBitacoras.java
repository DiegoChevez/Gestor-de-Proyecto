package sv.com.telecomunicaciones.metodos.programadores;

import sv.com.telecomunicaciones.util.ConexionSQL;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class CasosBitacoras {
	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.conexion();
	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;

	public DefaultTableModel selectCasosBitacoras(int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
		DefaultTableModel dtm = new DefaultTableModel();

		this.idUsuario=idUser;
		this.idTrabajador=idEmpleado;
		this.rolTrabajador = rolEmpleado;
		this.areaTrabajador = areaEmpleado;

		String SQL =
				"SELECT c.Id_Caso, COUNT(b.Caso) as NumBitacoras, CONCAT(ee.Nombres, ' ', ee.Apellidos) AS Encargado," +
						" c.Estado FROM casos c JOIN empleados pe ON c.Programador = pe.Id_Empleado JOIN empleados ee" +
						" ON c.Encargado = ee.Id_Empleado LEFT JOIN bitacoras b ON c.Id_Caso = b.Caso WHERE pe" +
						".Id_Empleado = "+idTrabajador+" GROUP BY c.Id_Caso";

		try {
			//definimos un metodo sql
			Statement st = con.createStatement();
			//Ejecutamos la consulta
			ResultSet rs = st.executeQuery(SQL);
			ResultSetMetaData meta = rs.getMetaData();
			int numberOfColumns = meta.getColumnCount();
			//Formando encabezado
			for (int i = 1; i <= numberOfColumns; i++) {
				dtm.addColumn(meta.getColumnLabel(i));
			}
			//Creando las filas para el JTable
			while (rs.next()) {
				Object[] fila = new Object[numberOfColumns];
				for (int i = 0; i < numberOfColumns; i++) {
					fila[i]=rs.getObject(i+1);
				}
				dtm.addRow(fila);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dtm;
	}
}
