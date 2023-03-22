package sv.com.telecomunicaciones.metodos;
import sv.com.telecomunicaciones.util.ConexionC;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MenuNSolicitudesDatos {

    private final String SQL_INSERT = "INSERT INTO persona(id_persona,nombre_persona,edad_persona,telefono_persona,sexo_persona,id_ocupacion,fecha_nac) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre_persona=?, edad_persona=?, telefono_persona=?, sexo_persona=?, id_ocupacion=?, fecha_nac=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    String areaEmpleado = "General";
    private final String SQL_SELECT ="SELECT Id_Caso,empleados.Nombres,DescripcionCaso,areas.Area FROM casos INNER JOIN empleados ON casos.Encargado = empleados.Id_Empleado INNER JOIN areas ON empleados.Area = areas.Id_Area WHERE areas.Area = '"+areaEmpleado+"'";

    public DefaultTableModel selectSolicitud(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
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
