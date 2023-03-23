package sv.com.telecomunicaciones.vistas.funcionales;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;


public class Menu extends JFrame {
    private JButton BtnDesarrollo;
    private JButton BtnEspera;
    private JButton BtnEnviados;
    private JButton casosRechazadosButton;
    private JPanel pnlMenu;
    private JButton BtnCrearSolicitud;

    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;

    public Menu(String title, int idUsuario, int idTrabajador, String rolEmpleado, String areaEmpleado) {
        super(title);
        this.idUsuario=idUsuario;
        this.idTrabajador=idTrabajador;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMenu);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        BtnDesarrollo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                EnDesarrollo enDesarrollo = null;
                try {
                    enDesarrollo = new EnDesarrollo("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                enDesarrollo.setVisible(true);
                dispose();
            }
        });
        BtnEspera.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                EnEspera enEspera = null;
                try {
                    enEspera = new EnEspera("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                enEspera.setVisible(true);
                dispose();

            }
        });
        BtnEnviados.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Enviados enviados = null;
                try {
                    enviados = new Enviados("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                enviados.setVisible(true);
                dispose();
            }
        });
        casosRechazadosButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Rechazados rechazados = null;
                try {
                    rechazados = new Rechazados("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                rechazados.setVisible(true);
                dispose();

            }
        });

        BtnCrearSolicitud.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JefeDeAreaSolicitud jefeDeAreaSolicitud = new JefeDeAreaSolicitud("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                jefeDeAreaSolicitud.setVisible(true);
                dispose();
            }
        });
    }
    }