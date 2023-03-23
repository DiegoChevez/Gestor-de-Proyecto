package sv.com.telecomunicaciones.vistas.tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sv.com.telecomunicaciones.vistas.tester.*;


public class binnacleView extends JFrame{
    private JLabel lblIndicaciones;
    private JLabel lblTitulo;
    private JTable tblBinnacle;
    private JPanel pnlBinnacle;
    private JLabel lblImage;
    private JTextField txtCase;
    private JTextField txtIDBinnacle;
    private JLabel lblIdBinnacle;
    private JLabel lblCase;
    private JLabel lblDescription;
    private JLabel lblAvance;
    private JLabel lblDate;
    private JTextField txtAdvance;
    private JTextField txtDate;
    private JButton btnBack;
    private JTextArea txtDescription;

    // * Constructor con las configuraciones básicas de la ventana de JFrame
    public binnacleView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlBinnacle);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(getParent());
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testerView vista = new testerView("Módulo de testing");
                vista.setVisible(true);
                dispose();
            }
        });
    }

}
