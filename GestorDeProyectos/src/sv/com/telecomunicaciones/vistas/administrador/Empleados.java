package sv.com.telecomunicaciones.vistas.administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import sv.com.telecomunicaciones.metodos.administrador.EmployeeData;
public class Empleados extends JFrame {
    private JPanel pnlEmpleados;
    private JLabel lblEmpleados;
    private JButton btnRegresar;
    private JButton btnAddEmpleado;
    private JButton btnExecute;
    private JTable tblEmpleados;

    DefaultTableModel modelo = null;


    EmployeeData employeeData=new EmployeeData();

    public Empleados (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlEmpleados);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());
        modelo=employeeData.selectEmployee();
        tblEmpleados.setModel(modelo);


        btnAddEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioEmpleado formularioEmpleado=new FormularioEmpleado("Crear Empleado");
                formularioEmpleado.setVisible(true);
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
        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarEmpleados modificarEmpleados=new ModificarEmpleados("Modificar Empleado");
                modificarEmpleados.setVisible(true);
                dispose();
            }
        });

    }
}
