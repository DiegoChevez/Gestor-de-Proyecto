package sv.com.telecomunicaciones.vistas.desarrollador;

import javax.swing.*;
import java.awt.*;

public class AsignarProgramador extends JFrame{
    private JPanel pnlProgram;
    private JLabel lblImgProgra;
    private JTextField txtId;
    private JTextField txtSolicitante;
    private JTextField txtDescrpcion;
    private JTextField txtComentarios;
    private JLabel lblId;
    private JLabel lblSolicitante;
    private JLabel lblDescripcion;
    private JLabel lblComentarios;
    private JComboBox cmbAsignar;
    private JLabel lblAsigna;
    private JButton btnEnviar;
    private JButton btnAtras;
    private JTextField txtFecha;
    private JLabel lblfecha;

    private String idSolicitudP;

    private String solicitanteP;

    private String descripcionP;

    public void setIdSPro(String idSolicitudP){
        this.idSolicitudP = idSolicitudP;
        txtId.setText(idSolicitudP);
    }

    public void setTxtSolicitante(String solicitanteP){
        this.solicitanteP = solicitanteP;
        txtSolicitante.setText(solicitanteP);
    }

    public void setDescripcionP(String descripcionP){

        this.descripcionP = descripcionP;
        txtDescrpcion.setText(descripcionP);

    }

    public AsignarProgramador(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProgram);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }
    public static void main(String[] args) {
        JFrame frame = new AsignarProgramador("Ingreso de Datos");
        frame.setVisible(true);
    }


}
