package sv.com.telecomunicaciones.metodos.metodosdesarrollador;

import sv.com.telecomunicaciones.util.ConexionSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDesarrollador{

    String idCaso;
    String coment;

    String fecha;
    String tester;

   String programador;

    public String updateCasoJF(String id2, String Comentario, String fecha, String tester, String programador1) {
        this.programador = programador1;
        this.idCaso = id2;
        this.coment = Comentario;
        this.fecha = fecha;
        this.tester = tester;

        String SQL = "UPDATE casos SET Programador = '"+programador+"',Tester = '"+tester+"', FechaFinalizacion = '"+fecha+"',ComentariosJefe = '"+coment+"' ,Estado = 'en desarrollo' WHERE Id_Caso = '" + idCaso + "'";
        int resulSQL;
        ConexionSQL conexion = new ConexionSQL();
        Connection con = conexion.conexion();

        try {
            //definimos un metodo sql
            Statement st = con.createStatement();
            //Ejecutamos la consulta
            int actualizacion = st.executeUpdate(SQL);

            //Cerrar conexiones
            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return SQL;
    }
}
