package sv.com.telecomunicaciones.metodos.metodosdesarrollador;

import sv.com.telecomunicaciones.util.ConexionC;
import javax.swing.*;
import java.sql.*;

public class SeleccionarProgramadorDatos{

    String areaEmpleado = "Finanzas";

    private final String SQL_SELECT = "SELECT empleados.* FROM empleados INNER JOIN areas ON empleados.Area = areas.Id_Area INNER JOIN roles ON empleados.Rol = roles.Id_Rol WHERE areas.Area = '"+areaEmpleado+"' AND roles.Rol = 'Programadores' AND empleados.Id_Empleado NOT IN (SELECT DISTINCT casos.Encargado FROM casos WHERE casos.Estado='en desarrollo')";

    public DefaultComboBoxModel selectProgramadores(){

        DefaultComboBoxModel dtm = new DefaultComboBoxModel();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
//Creando las filas para el JTable
            while (rs.next()) {
                dtm.addElement(rs.getObject(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionC.close(rs);
            ConexionC.close(stmt);
            ConexionC.close(conn);
        }
        return dtm;
    }
}
