package sv.com.telecomunicaciones.vistas.desarrollador;
import sv.com.telecomunicaciones.bins.DesarrolladorBeans.DesarrolladorBins;
import sv.com.telecomunicaciones.metodos.metodosdesarrollador.MenuCasosDatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import sv.com.telecomunicaciones.metodos.login.VistasModulos;


public class MenuCasos extends  JFrame {
    private JLabel lblCasos;
    private JTable tblCasos;
    private JTextField txtIdCaso;
    private JTextField txtEncargado;
    private JTextField txtEstado;
    private JTextField txtDescripcion;
    private JTextField txtPorcentaje;
    private JTextField txtTester;
    private JTextField txtComentarios;
    private JLabel lblComentarios;
    private JTextField txtComentarioTester;
    private JButton btnAtras;
    private JPanel pnlMenuCasos;

    int idUsuario;

    int idTrabajador;

    String rolTrabajador;

    String areaTrabajador;

    DefaultTableModel modelo2=null;

    DesarrolladorBins desarrolladorBeans = null;
    MenuCasosDatos menuCasosDatos = new MenuCasosDatos();

    VistasModulos vistasModulos = new VistasModulos();




    public MenuCasos(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){

        super(title);
        this.idUsuario = idUser;
        this.idTrabajador = idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMenuCasos);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo2= menuCasosDatos.selectCaso();
        tblCasos.setModel(modelo2);

        tblCasos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerCasos(e);
            }
        });
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDesarrollador menuDesarrollador = new MenuDesarrollador("Menu desarrollador", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                menuDesarrollador.setVisible(true);
                dispose();

            }
        });
    }

    public void tblObtenerCasos(MouseEvent e){

        int fila = tblCasos.rowAtPoint(e.getPoint());
        int columna = tblCasos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtIdCaso.setText(modelo2.getValueAt(fila,0).toString());
            txtEncargado.setText(modelo2.getValueAt(fila,1).toString());
            txtEstado.setText(modelo2.getValueAt(fila,10).toString());
            txtDescripcion.setText(modelo2.getValueAt(fila,2).toString());
            txtPorcentaje.setText(modelo2.getValueAt(fila,7).toString());
            txtTester.setText(modelo2.getValueAt(fila,8).toString());;
            txtComentarios.setText(modelo2.getValueAt(fila,5).toString());;
            txtComentarioTester.setText(modelo2.getValueAt(fila,9).toString());;
        }

    }

    }
