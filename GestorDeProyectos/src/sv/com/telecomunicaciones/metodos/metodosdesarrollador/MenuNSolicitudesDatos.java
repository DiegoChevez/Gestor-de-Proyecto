package sv.com.telecomunicaciones.metodos.metodosdesarrollador;
import sv.com.telecomunicaciones.bins.DesarrolladorBeans.DesarrolladorBins;
import sv.com.telecomunicaciones.util.ConexionC;
import sv.com.telecomunicaciones.vistas.desarrollador.AsignarProgramador;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MenuNSolicitudesDatos{

    private final String SQL_SELECT ="SELECT casos.Id_Caso, casos.Encargado AS IdEncargado, CONCAT(empleados.Nombres,' ',empleados.Apellidos) AS Encargado,casos.DescripcionCaso FROM casos INNER JOIN Empleados ON casos.Encargado = Empleados.Id_Empleado WHERE casos.estado = 'en espera de respuesta'";

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
