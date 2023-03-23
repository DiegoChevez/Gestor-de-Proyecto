package sv.com.telecomunicaciones.vistas.administrador;
import sv.com.telecomunicaciones.bins.administrador.AreaBeans;
import sv.com.telecomunicaciones.metodos.administrador.AreaData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregarArea extends JFrame{
    private JPanel pnlArea;
    private JTextField txtId;
    private JTextField txtArea;
    private JLabel lblId;
    private JLabel lblArea;
    private JLabel lblAgregar;
    private JTable tblArea;
    private JButton btnRegresar;
    private JButton btnAdd;
    private JButton btnModificar;

    DefaultTableModel modelo = null;

    AreaBeans areaBeans=null;
    AreaData data=new AreaData();

    public AgregarArea(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlArea);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo = data.selectArea();
        tblArea.setModel(modelo);


        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdministrador administrador=new MenuAdministrador("Modulo de Administracion");
                administrador.setVisible(true);
                dispose();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        tblArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getAreaData(e);


            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarAreas modificarAreas=new ModificarAreas("Modificar Area");
                modificarAreas.setVisible(true);
                dispose();

            }
        });

    }
    private void getAreaData(MouseEvent e){
        int fila = tblArea.rowAtPoint(e.getPoint());
        int columna = tblArea.columnAtPoint(e.getPoint());

        if((fila > -1 )&&(columna > -1)){
            txtId.setText(modelo.getValueAt(fila,0).toString());
            txtArea.setText(modelo.getValueAt(fila,1).toString());

        }
    }
}


