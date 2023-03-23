package sv.com.telecomunicaciones.vistas.administrador;
import sv.com.telecomunicaciones.metodos.administrador.AreaData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarAreas extends JFrame{
    private JPanel pnlModificarArea;
    private JLabel lblStatus;
    private JComboBox cmbStatus;
    private JButton btnExecute;
    private JButton btnRegresar;
    private JTable tblAreas;
    private JLabel lblEliminar;



    DefaultTableModel modelo = null;

   AreaData areaData=new AreaData();

    public ModificarAreas(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlModificarArea);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo=areaData.selectArea();
       tblAreas.setModel(modelo);

        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               AgregarArea area=new AgregarArea("Area");
               area.setVisible(true);
                dispose();

            }
        });
        cmbStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cmbStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
