package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class EnDesarrollo extends JFrame {
    public JPanel pnlDesarrollo;
    private JLabel lblImg;
    private JLabel lblSpace3;
    private JLabel lblSpace1;
    private JLabel lblTopic;
    private JButton BtnRegresar;
    private JTable tblTablaDesarrollo;

    DefaultTableModel modelo=null;
    Datos datos = new Datos();

    public EnDesarrollo(String title) throws SQLException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlDesarrollo);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo= datos.desarrollo();

        tblTablaDesarrollo.setModel(modelo);

        BtnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(title);
                menu.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new EnDesarrollo("Ingreso de Datos");
        frame.setVisible(true);
    }

}