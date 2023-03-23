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

    public MenuDesarrollador(String title){
            super(title);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(pnlDesarrollador);
            this.setMinimumSize(new Dimension(600, 500));
            this.setLocationRelativeTo(getParent());
        btnSolicitudes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes(title);
                    menuNSolicitudes.setVisible(true);
                    dispose();
            }
        });

        btnCasos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object evt = e.getSource();
                if (evt.equals(btnCasos)){
                    MenuCasos menuCasos = new MenuCasos(title);
                    menuCasos.setVisible(true);
                    dispose();
                }

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new MenuDesarrollador("Ingreso de Datos");
        frame.setVisible(true);
    }
}
