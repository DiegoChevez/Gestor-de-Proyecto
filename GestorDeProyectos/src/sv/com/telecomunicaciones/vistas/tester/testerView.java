package sv.com.telecomunicaciones.vistas.tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sv.com.telecomunicaciones.vistas.tester.*;

public class testerView extends JFrame {
    private JLabel lblTitle;
    private JButton pendientesButton;
    private JLabel lblIndicacion;
    private JButton btnBitacora;
    private JPanel pnlTester;
    // * Constructor con las configuraciones básicas de la ventana de JFrame
    public testerView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlTester);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(getParent());
        pendientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendingView pendiente = new pendingView("Vista de pendientes");
                pendiente.setVisible(true);
                dispose();
            }
        });
        btnBitacora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binnacleView binnacle = new binnacleView("Vista de bitacoras");
                binnacle.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        testerView vista = new testerView("Módulo de testing");
        vista.setVisible(true);
    }


}
