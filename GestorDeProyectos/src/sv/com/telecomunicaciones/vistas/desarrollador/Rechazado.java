package sv.com.telecomunicaciones.vistas.desarrollador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rechazado extends JFrame{
    private JLabel lblRechazado;
    private JLabel lblImgRechazo;
    private JTextField txtIdCaso;
    private JTextField txtSolicitante;
    private JLabel lblIdCaso;
    private JLabel lblSolicitante;
    private JLabel lblRazon;
    private JTextArea txtaRazon;
    private JButton btnEnviar;
    private JPanel pnlRechazado;
    private JButton btnAtras;
    int idUsuario;

    int idTrabajador;

    String rolTrabajador;

    String areaTrabajador;
    private String IdCaso;
    private String Solicitante;


    public Rechazado(String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){

        super(title);
        this.idUsuario = idUser;
        this.idTrabajador = idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;

        System.out.println(idUser+""+idEmpleado+rolEmpleado+areaEmpleado);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlRechazado);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes("Rechazado", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
                menuNSolicitudes.setVisible(true);
                dispose();
            }
        });
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                enviarRechazo();
            }
        });
    }
    public void enviarRechazo(){
        if (txtaRazon.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la razon del rechazo");
        } else {
            String id = txtIdCaso.getText();
            String razon;
            razon = txtaRazon.getText();
            String rechazado = "rechazado";
            JOptionPane.showMessageDialog(null, "El ID del caso es "+id+ "Y la razon del rechazo fue" + razon + "Y su estado ahora esta" +rechazado);

            MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes("Menu nuevas solicitudes", idUsuario, idTrabajador, rolTrabajador, areaTrabajador);
            menuNSolicitudes.setVisible(true);
            dispose();

        }
    }
    public void setTxtIdCaso(String IdCaso) {
        this.IdCaso = IdCaso;
        txtIdCaso.setText(IdCaso);
    }
    public void setTxtSolicitante(String Solicitante) {
        this.Solicitante = Solicitante;
        txtSolicitante.setText(Solicitante);
    }
}
