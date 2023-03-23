package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JefeDeAreaSolicitud extends JFrame {

    private JPanel pnlSolicitud;
    private JLabel lblTopic;
    private JLabel lblDesc;
    private JLabel lblImg;
    private JTextArea txtDesc;
    private JButton btnEnviar;
    private JLabel lblSpace1;
    private JButton BtnRegresar;

    public JefeDeAreaSolicitud(String title) {
        super(title);
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
                Menu menu = new Menu(title);
                menu.setVisible(true);
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JefeDeAreaSolicitud("Jefe de Área");
        frame.setVisible(true);
    }
    }