package sv.com.telecomunicaciones.vistas.funcionales;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.com.telecomunicaciones.util.ConexionSQL;

public class Datos {
    private final String SQL_SELECT0 = "SELECT id_caso, Encargado, DescripcionCaso, FechaRealizacion, ComentariosJefe, Programador, PorcentajeAvance, Estado FROM casos WHERE casos.Estado LIKE '%En Desarrollo%'";

    private final String SQL_SELECT1 = "SELECT id_caso, Encargado, DescripcionCaso, FechaRealizacion, Estado FROM casos WHERE casos.Estado LIKE '%En Espera%'";

    private final String SQL_SELECT2 = "SELECT id_caso, Encargado, DescripcionCaso, FechaRealizacion, Estado FROM casos WHERE casos.Estado LIKE '%Enviado%'";

    private final String SQL_SELECT3 = "SELECT * FROM casos WHERE casos.Estado LIKE '%Rechazado%'";

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

    public DefaultTableModel enviado() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn = ConexionSQL.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT2);
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

    public DefaultTableModel rechazado() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn = ConexionSQL.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT3);
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