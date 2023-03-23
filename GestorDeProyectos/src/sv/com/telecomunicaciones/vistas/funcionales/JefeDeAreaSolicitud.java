package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JefeDeAreaSolicitud extends JFrame {

    private JPanel pnlSolicitud;
    private JLabel lblTopic;
    private JLabel lblDesc;
    private JLabel lblImg;
    private JTextArea txtDesc;
    private JButton btnEnviar;
    private JLabel lblSpace1;
    private JButton BtnRegresar;

    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;

    public JefeDeAreaSolicitud(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {
        super(title);
        this.idUsuario=idUser;
        this.idTrabajador=idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlSolicitud);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        btnEnviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Datos Enviados");
            }
        });
        BtnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu("Sistema DEV", idUsuario, idTrabajador, rolEmpleado, areaEmpleado);
                menu.setVisible(true);
                dispose();
            }
        });
    }
    }