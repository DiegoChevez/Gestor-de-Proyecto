package sv.com.telecomunicaciones.vistas.administrador;
import sv.com.telecomunicaciones.metodos.administrador.EmployeeData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearUsuario extends JFrame {
    private JPanel pnlUsers;
    private JLabel lblUsers;
    private JButton btnRegresar;
    private JButton btnAddUser;
    private JTable tblEmpleadosView;
    private JLabel lblEmpleado;
    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;

    DefaultTableModel modelo = null;


    EmployeeData employeeData=new EmployeeData();
    public CrearUsuario (String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
        super(title);
        this.idUsuario=idUser;
        this.idTrabajador=idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlUsers);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo=employeeData.selectEmployee();
        tblEmpleadosView.setModel(modelo);

    btnAddUser.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FormularioUsuario formularioUsuario=new FormularioUsuario("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
            int filaSeleccionada = tblEmpleadosView.getSelectedRow();
            Object nameUser = tblEmpleadosView.getValueAt(filaSeleccionada,1);
            Object surnameUser = tblEmpleadosView.getValueAt(filaSeleccionada,2);
            Object idEmployee = tblEmpleadosView.getValueAt(filaSeleccionada,0);
            formularioUsuario.setNameUser(String.valueOf(nameUser));
            formularioUsuario.setIdEmployee(Integer.parseInt(idEmployee.toString()));
            formularioUsuario.setSurnameUser(String.valueOf(surnameUser));

            formularioUsuario.setVisible(true);
            dispose();


        }
    });
    btnRegresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Usuarios User=new Usuarios ("Sistema DEV", idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
            User.setVisible(true);
            dispose();

        }
    });


    }
    private void tblGetUser(MouseEvent e) {
        int fila = tblEmpleadosView.rowAtPoint(e.getPoint());
        int columna = tblEmpleadosView.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)) {




        }
    }
}
