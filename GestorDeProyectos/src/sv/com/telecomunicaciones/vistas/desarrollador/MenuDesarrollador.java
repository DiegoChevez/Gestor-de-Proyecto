package sv.com.telecomunicaciones.vistas.desarrollador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDesarrollador extends JFrame {
    private JLabel lblBienvenido;
    private JButton btnCasos;
    private JLabel lblImg;
    private JButton btnSolicitudes;
    private JPanel pnlDesarrollador;

    int idUsuario;

    int idTrabajador;

    String rolTrabajador;

    String areaTrabajador;
    public MenuDesarrollador(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
        super(title);
        this.idUsuario = idUser;
        this.idTrabajador = idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;

        System.out.println(idUsuario+""+idTrabajador+rolTrabajador+areaTrabajador);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(pnlDesarrollador);
            this.setMinimumSize(new Dimension(600, 500));
            this.setLocationRelativeTo(getParent());
        btnSolicitudes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes("Menu Nuevas solicitudes", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                    menuNSolicitudes.setVisible(true);
                    dispose();
            }
        });

        btnCasos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object evt = e.getSource();
                if (evt.equals(btnCasos)){
                    MenuCasos menuCasos = new MenuCasos("Menu casos", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                    menuCasos.setVisible(true);
                    dispose();
                }

            }
        });
    }

}
