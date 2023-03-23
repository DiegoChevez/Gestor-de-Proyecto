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
    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;
    public MenuAdministrador(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {
        super(title);
        this.idUsuario=idUser;
        this.idTrabajador=idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlAdmin);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());


        btnUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuarios User=new Usuarios ("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                User.setVisible(true);
                dispose();

            }

        });

        btnArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarArea addArea=new  AgregarArea("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                addArea.setVisible(true);
                dispose();

            }
        });
        btnEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados empleado=new Empleados("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                empleado.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        MenuAdministrador administrador=new MenuAdministrador("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
        administrador.setVisible(true);
    }

}
