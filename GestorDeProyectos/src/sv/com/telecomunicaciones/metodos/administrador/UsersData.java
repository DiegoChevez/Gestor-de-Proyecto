package sv.com.telecomunicaciones.metodos.administrador;

import sv.com.telecomunicaciones.util.ConexionA;
import sv.com.telecomunicaciones.vistas.administrador.FormularioUsuario;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UsersData {
    private final String SQL_SELECT = "SELECT * FROM usuarios";

    private final String SQL_INSERT = "INSERT INTO usuarios(Empleado, Usuario, Contrasena, Estado) VALUES (?,?,?,'Activo')";
    public int insert(FormularioUsuario formularioUsuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registros afectados
        try {
            conn = ConexionA.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, formularioUsuario.setIdEmployee());
            stmt.setString(index++, formularioUsuario.setName());
            stmt.setString(index++, formularioUsuario.setName());
            stmt.setString(index++, formularioUsuario.setSurnameUser());

            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionA.close(stmt);
            ConexionA.close(conn);
        }
        return rows;
    }


    public DefaultTableModel selectUsers(){

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

