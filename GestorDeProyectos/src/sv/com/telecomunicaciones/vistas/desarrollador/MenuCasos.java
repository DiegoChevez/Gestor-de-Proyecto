package sv.com.telecomunicaciones.vistas.desarrollador;
import sv.com.telecomunicaciones.bins.DesarrolladorBins;
import sv.com.telecomunicaciones.metodos.MenuCasosDatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


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

    DefaultTableModel modelo2=null;
    DesarrolladorBins desarrolladorBeans = null;
    MenuCasosDatos menuCasosDatos = new MenuCasosDatos();


    public MenuCasos(String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMenuCasos);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        modelo2= menuCasosDatos.selectCaso();
        tblCasos.setModel(modelo2);

        }

    public static void main(String[] args) {
        JFrame frame = new MenuCasos("Ingreso de Datos");
        frame.setVisible(true);
    }
    }
