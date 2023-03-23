package sv.com.telecomunicaciones.vistas.administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdministrador extends JFrame{
    private JButton btnExecute;
    private JButton btnUsuario;
    private JPanel pnlAdmin;
    private JLabel lblMenu;
    private JLabel lblElige;
    private JButton btnShow;
    private JButton btnArea;
    private JButton btnEmpleados;

    public MenuAdministrador(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAdmin);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());


        btnUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuarios User=new Usuarios ("Usuarios");
                User.setVisible(true);
                dispose();

            }

        });

        btnArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarArea addArea=new  AgregarArea("Agregar Area");
                addArea.setVisible(true);
                dispose();

            }
        });
        btnEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados empleado=new Empleados("Agregar Empleado");
                empleado.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        MenuAdministrador administrador=new MenuAdministrador("Modulo de Administracion");
        administrador.setVisible(true);
    }

}
