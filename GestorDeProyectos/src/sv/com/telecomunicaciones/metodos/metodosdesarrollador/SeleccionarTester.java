package sv.com.telecomunicaciones.metodos.metodosdesarrollador;

import sv.com.telecomunicaciones.util.ConexionC;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeleccionarTester {

    final String SQL_SELECT = "SELECT Nombres FROM Empleados";

    public DefaultComboBoxModel selectTester() {
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
