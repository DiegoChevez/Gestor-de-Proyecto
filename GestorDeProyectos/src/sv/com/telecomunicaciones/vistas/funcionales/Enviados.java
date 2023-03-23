package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Enviados extends JFrame {
    private JPanel pnlEnviados;
    private JLabel lblTopic;
    private JLabel lblSpace1;
    private JLabel lblSpace2;
    private JLabel lblImg;
    private JButton BtnRegresar;
    private JTable tblTablaEnviado;

    DefaultTableModel modelo=null;
    Datos datosEnviados = new Datos();

    public Enviados(String title) throws SQLException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlEnviados);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo= datosEnviados.enviado();

        tblTablaEnviado.setModel(modelo);
        BtnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(title);
                menu.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new EnEspera("Casos en Espera");
        frame.setVisible(true);
    }

}
