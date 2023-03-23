package sv.com.telecomunicaciones.vistas.administrador;
import sv.com.telecomunicaciones.metodos.administrador.UsersData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarUsuarios extends JFrame{
    private JPanel pnlModificarUsuarios;
    private JLabel lblStatus;
    private JComboBox cmbStatus;
    private JButton btnExecute;
    private JButton btnRegresar;
    private JLabel lblEliminar;
    private JTable tblUsers;

    DefaultTableModel modelo = null;

    UsersData usersData=new UsersData();

    public ModificarUsuarios(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlModificarUsuarios);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo=usersData.selectUsers();
        tblUsers.setModel(modelo);

        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuarios User=new Usuarios ("Usuarios");
                User.setVisible(true);
                dispose();

            }
        });
        cmbStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}