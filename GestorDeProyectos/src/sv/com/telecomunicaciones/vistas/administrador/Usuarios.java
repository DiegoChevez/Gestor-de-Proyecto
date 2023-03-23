package sv.com.telecomunicaciones.vistas.administrador;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import sv.com.telecomunicaciones.metodos.administrador.UsersData;
import sv.com.telecomunicaciones.metodos.administrador.UsersData;

public class Usuarios extends JFrame {
    private JPanel pnlUser;
    private JLabel lblUsers;
    private JTable tblUsers;
    private JButton btnRegresar;
    private JButton btnAddEmpleado;
    private JButton btnExecute;
    DefaultTableModel modelo = null;
   UsersData usersData=new UsersData();

    public Usuarios (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlUser);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());
        modelo=usersData.selectUsers();
        tblUsers.setModel(modelo);

    btnAddEmpleado.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CrearUsuario crearUsuario=new CrearUsuario("Crear usuario");
            crearUsuario.setVisible(true);
            dispose();


        }
    });
    btnExecute.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModificarUsuarios modificarUsuarios=new ModificarUsuarios("Modificar Usuarios");
            modificarUsuarios.setVisible(true);
            dispose();

        }
    });
    btnRegresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            MenuAdministrador administrador=new MenuAdministrador("Modulo de Administracion");
            administrador.setVisible(true);
            dispose();

        }
    });




    }

}
