package sv.com.telecomunicaciones.vistas.desarrollador;

import sv.com.telecomunicaciones.bins.DesarrolladorBeans.DesarrolladorBins;
import sv.com.telecomunicaciones.metodos.metodosdesarrollador.MenuNSolicitudesDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuNSolicitudes extends JFrame{
    private JLabel lblSolicitudes;
    private JLabel lblImgSolicitud;
    private JTable tblSolicitudes;
    private JTextField txtIdSolicitud;
    private JTextField txtIdSolicitante;
    private JLabel lblIdSolicitud;
    private JLabel lblSolicitante;
    private JLabel lblDescripcionSolicitud;
    private JButton btnRechazar;
    private JButton btnAceptar;
    private JLabel lblDecision;
    private JButton btnMenu;
    private JTextArea txtaDescripcion;
    private JPanel pnlSolicitudes;

    int idUsuario;

    int idTrabajador;

    String rolTrabajador;

    String areaTrabajador;

    DefaultTableModel modelo=null;
    DesarrolladorBins desarrolladorBeans = null;
    MenuNSolicitudesDatos menuNSolicitudesDatos = new MenuNSolicitudesDatos();
    public MenuNSolicitudes(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){

        super(title);
        this.idUsuario = idUser;
        this.idTrabajador = idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;

        System.out.println(idUser+""+idEmpleado+rolEmpleado+areaEmpleado);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlSolicitudes);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());


        modelo = menuNSolicitudesDatos.selectSolicitud();
        tblSolicitudes.setModel(modelo);


        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    MenuDesarrollador menuDesarrollador = new MenuDesarrollador("Menu desarrollador", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                    menuDesarrollador.setVisible(true);
                    dispose();

            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (txtIdSolicitud.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Seleccione un caso");
                    }else{
                    AsignarProgramador asignarProgramador = new AsignarProgramador("Asignar programador", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                    asignarProgramador.setTxtSolicitante(txtIdSolicitante.getText());
                    asignarProgramador.setDescripcionP(txtaDescripcion.getText());
                    asignarProgramador.setIdSPro(txtIdSolicitud.getText());
                    asignarProgramador.setVisible(true);
                    dispose();
                    }
                }
        });

        btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtIdSolicitud.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Seleccione un caso");
                }else{
                    Rechazado rechazado = new Rechazado("Rechazado", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                    rechazado.setTxtIdCaso(txtIdSolicitud.getText());
                    rechazado.setTxtSolicitante(txtIdSolicitante.getText());
                    rechazado.setVisible(true);
                    dispose();
                }

            }
        });
        tblSolicitudes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                tblObtenerSolicitudes(e);
            }
        });


    }
    public void tblObtenerSolicitudes(MouseEvent e){
        int fila = tblSolicitudes.rowAtPoint(e.getPoint());
        int columna = tblSolicitudes.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)){
            txtIdSolicitud.setText(modelo.getValueAt(fila,0).toString());
            txtIdSolicitante.setText(modelo.getValueAt(fila,1).toString());
            txtaDescripcion.setText(modelo.getValueAt(fila,2).toString());
        }
    }


    public JTextArea getTxtaDescripcion() {
        txtaDescripcion.setBounds(10,50,400,300);
        return txtaDescripcion;
    }
}

