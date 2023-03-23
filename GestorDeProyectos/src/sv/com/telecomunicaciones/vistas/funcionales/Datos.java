package sv.com.telecomunicaciones.vistas.funcionales;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.com.telecomunicaciones.util.ConexionSQL;

public class DatosDesarrollo {
    private final String SQL_SELECT0 = "SELECT *" + "FROM casos";

    private final String SQL_SELECT1 = "SELECT *" + "FROM casos";

    public DefaultTableModel desarrollo() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn = ConexionSQL.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT0);
        rs = stmt.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        int numberOfColumns = meta.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            dtm.addColumn(meta.getColumnLabel(i));
        }

        while (rs.next()) {
            Object[] fila = new Object[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++) {
                fila[i]=rs.getObject(i+1);
            }
            dtm.addRow(fila);
        }

        return dtm;

        }

    public DefaultTableModel espera() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn = ConexionSQL.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT1);
        rs = stmt.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        int numberOfColumns = meta.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            dtm.addColumn(meta.getColumnLabel(i));
        }

        while (rs.next()) {
            Object[] fila = new Object[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++) {
                fila[i]=rs.getObject(i+1);
            }
            dtm.addRow(fila);
        }

        return dtm;

    }
}