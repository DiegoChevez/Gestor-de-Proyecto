package sv.com.telecomunicaciones.vistas.administrador;
import sv.com.telecomunicaciones.metodos.administrador.EmployeeData;
import sv.com.telecomunicaciones.bins.EmployeeBeans;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarEmpleados extends JFrame{
    private JPanel pnlModificar;
    private JLabel lblStatus;
    private JComboBox cmbStatus;
    private JButton btnExecute;
    private JButton btnRegresar;
    private JTable tblModificarEmpleados;

    private JLabel lblEliminar;
    DefaultTableModel modelo = null;

    EmployeeData employeeData=new EmployeeData();

    public ModificarEmpleados(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlModificar);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo=employeeData.selectEmployee();
        tblModificarEmpleados.setModel(modelo);

    btnExecute.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnRegresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Empleados empleados=new Empleados("Empleados");
           empleados.setVisible(true);
            dispose();

        }
    });
    cmbStatus.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
        cmbStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
