package sv.com.telecomunicaciones.metodos.administrador;
import javax.swing.table.DefaultTableModel;
import sv.com.telecomunicaciones.util.ConexionA;
import sv.com.telecomunicaciones.bins.administrador.AreaBeans;
import java.sql.*;
public class AreaData {
    private final String SQL_SELECT = "SELECT Id_Area, Area FROM areas";

    public DefaultTableModel selectArea(){

        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionA.getConnection();
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
            ConexionA.close(rs);
            ConexionA.close(stmt);
            ConexionA.close(conn);
        }
        return dtm;
    }

}