package sv.com.telecomunicaciones.vistas.tester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pendingView extends JFrame{
    private JTable tblPending;
    private JPanel pnlPending;
    private JLabel lblEncabezado;
    private JLabel lblImagen;
    private JLabel lblIndicaciones;
    private JButton btnRegresar;
    private JButton btnAprobar;
    private JButton btnRechazar;
    private JTextArea txtComentarios;
    private JLabel lblComentarios;
    private JTextField txtEstado;
    private JTextField txtPrgramadorEncargado;
    private JTextField txtID;
    private JLabel lblID;
    private JLabel lblProgramador;
    private JLabel lblEstado;

    public pendingView (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPending);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testerView vista = new testerView("Módulo de testing");
                vista.setVisible(true);
                dispose();
            }
        });
    }

}
