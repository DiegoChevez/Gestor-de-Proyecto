package sv.com.telecomunicaciones.metodos.programadores;

import javax.swing.table.DefaultTableModel;
import sv.com.telecomunicaciones.util.ConexionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CasosRecibidosTable {
	ConexionSQL conexion = new ConexionSQL();
	Connection con = conexion.conexion();
	public DefaultTableModel selectCasos() throws SQLException {
		DefaultTableModel dtm = new DefaultTableModel();

		String SQL ="SELECT casos.Id_Caso AS Caso, casos.DescripcionCaso AS Descripción, casos.ComentariosJefe, casos.FechaFinalizacion, casos.PorcentajeAvance AS Progreso, casos.Estado FROM casos JOIN empleados ON casos.programador = empleados.Id_Empleado WHERE empleados.Id_Empleado = 5 ORDER BY casos.FechaRealizacion DESC;";

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
