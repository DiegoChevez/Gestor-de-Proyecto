package sv.com.telecomunicaciones.vistas.administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioEmpleado extends JFrame {
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JComboBox cmbRol;
    private JComboBox cmbArea;
    private JButton btnCreateEmpleado;
    private JPanel pnlAdd;
    private JLabel lblEmpleado;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblRol;
    private JLabel lblArea;
    private JButton btnRegresar;

    public FormularioEmpleado(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAdd);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        btnCreateEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados empleados=new  Empleados("Empleados");
                empleados.setVisible(true);
                dispose();
            }

        });
    }

    public static void main(String[] args) {
        FormularioEmpleado addUser=new FormularioEmpleado("Agregar Usuario");
        addUser.setVisible(true);
    }
}

