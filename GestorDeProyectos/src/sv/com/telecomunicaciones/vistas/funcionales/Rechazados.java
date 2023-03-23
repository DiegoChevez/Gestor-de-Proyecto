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

    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;

    public Rechazados(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) throws SQLException {
        super(title);
        this.idUsuario=idUser;
        this.idTrabajador=idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlRechazado);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo= datosRechazados.rechazado();

        tblTablaRechazados.setModel(modelo);
        BtnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu("Sistema DEV", idUsuario, idTrabajador, rolEmpleado, areaEmpleado);
                menu.setVisible(true);
                dispose();
            }
        });
    }
    }
