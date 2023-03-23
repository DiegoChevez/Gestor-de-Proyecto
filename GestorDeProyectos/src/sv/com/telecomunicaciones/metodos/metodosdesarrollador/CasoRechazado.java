package sv.com.telecomunicaciones.metodos.metodosdesarrollador;

import sv.com.telecomunicaciones.util.ConexionSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CasoRechazado {

    private String idCaso;
    private String razon;

    public String casorechazado(String idCaso, String razon){

        this.idCaso = idCaso;
        this.razon = razon;

        String SQL = "UPDATE casos SET Estado = 'rechazado', ComentariosJefe = '"+razon+"' WHERE Id_Caso = 'FNZ23123'";
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



