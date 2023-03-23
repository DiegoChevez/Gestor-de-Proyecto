package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Rechazados extends JFrame {
    private JPanel pnlRechazado;
    private JLabel lblTopic;
    private JLabel lblImg;
    private JLabel lblSpace2;
    private JLabel lblSpace1;
    private JButton BtnRegresar;
    private JTable tblTablaRechazados;

    DefaultTableModel modelo=null;
    Datos datosRechazados = new Datos();

    public Rechazados(String title) throws SQLException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlRechazado);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo= datosRechazados.rechazado();

        tblTablaRechazados.setModel(modelo);
        BtnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(title);
                menu.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new Rechazados("Casos en Espera");
        frame.setVisible(true);
    }

}
