package sv.com.telecomunicaciones.vistas.desarrollador;

import sv.com.telecomunicaciones.metodos.metodosdesarrollador.SeleccionarProgramadorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import sv.com.telecomunicaciones.bins.DesarrolladorBeans.DesarrolladorBins;


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

    /*Asignar las variables del menu de eleccion de solicitud al menu de asignar programador*/

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
    /*Termina el asignar*/

    SeleccionarProgramadorDatos seleccionarProgramadorDatos = new SeleccionarProgramadorDatos();

    public AsignarProgramador(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProgram);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        cmbAsignar.setModel(seleccionarProgramadorDatos.selectProgramadores());

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes(title);
                menuNSolicitudes.setVisible(true);
                dispose();
            }
        });


        /*Enviar: Esto es para hacer el insert, ignorar el JPane y agregar el query*/
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarAsignado();
                MenuNSolicitudes menuNSolicitudes = new MenuNSolicitudes(title);
                menuNSolicitudes.setVisible(true);
                dispose();
            }
        });
    }


    public void enviarAsignado(){
        String id = txtId.getText();
        String estado = "En desarrollo";
        String comentario = txtComentarios.getText();
        String fecha = txtFecha.getText();
        Calendar cal = Calendar.getInstance();

        try {
            // Paso 1: verificar el formato de la fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false); // para que la validación sea estricta
            Date date = dateFormat.parse(txtFecha.getText());

            // Paso 2: crear una instancia de Calendar y establecer la fecha
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Paso 3: verificar que los valores de día, mes y año sean válidos
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1; // sumar 1 porque los meses en Calendar van de 0 a 11
            int year = calendar.get(Calendar.YEAR);
            if (day != calendar.getActualMaximum(Calendar.DAY_OF_MONTH) || month < 1 || month > 12 || year < 0 || year > 9999) {
                Date today = new Date();
                if (date.compareTo(today) < 0 ) {
                    JOptionPane.showMessageDialog(null,"La fecha es incorrecta");
                }else{
                    JOptionPane.showMessageDialog(null,"Fecha correcta");
                }
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"La fecha es incorrecta");
        }
        String programador = (String) cmbAsignar.getSelectedItem();
        JOptionPane.showMessageDialog(null,"El programador es " +programador+ "Su comentario fue " +comentario+ "Y la fecha de finalizacion es " +fecha+ "Y el ID es"+id);
    }
        /*Fin Enviar*/

    public static void main(String[] args) {
        JFrame frame = new AsignarProgramador("Ingreso de Datos");
        frame.setVisible(true);
    }


}
