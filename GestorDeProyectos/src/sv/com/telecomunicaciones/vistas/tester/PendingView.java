package sv.com.telecomunicaciones.vistas.tester;

import sv.com.telecomunicaciones.bins.tester.BinnacleBeans;
import sv.com.telecomunicaciones.metodos.tester.BinnacleData;
import sv.com.telecomunicaciones.metodos.tester.PendingData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class PendingView extends JFrame{
    private JTable tblPending;
    private JPanel pnlPending;
    private JLabel lblEncabezado;
    private JLabel lblImagen;
    private JLabel lblIndicaciones;
    private JButton btnRegresar;
    private JButton btnAprobar;
    private JButton btnRechazar;
    private JTextArea txtComentarios;
    private JLabel lblComentarios;
    private JTextField txtEstado;
    private JTextField txtPrgramadorEncargado;
    private JTextField txtID;
    private JLabel lblID;
    private JLabel lblProgramador;
    private JLabel lblEstado;

    DefaultTableModel modelo = null;
    BinnacleBeans binnacleBeans = null;
    PendingData pending = new PendingData();

    public PendingView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPending);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        modelo = pending.selectPending();
        tblPending.setModel(modelo);

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TesterView vista = new TesterView("Módulo de testing");
                vista.setVisible(true);
                dispose();
            }
        });
        btnAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Se ha aprobado correctamente");

            }
        });
        btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Se ha rechazado la solicitud");


            }
        });

        tblPending.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getPendingCases(e);
            }
        });
    }

    private void getPendingCases(MouseEvent e) {
        int fila = tblPending.rowAtPoint(e.getPoint());
        int columna = tblPending.columnAtPoint(e.getPoint());

        if((fila > -1 )&&(columna > -1)){
            txtID.setText(modelo.getValueAt(fila,0).toString());
            txtPrgramadorEncargado.setText(modelo.getValueAt(fila,1).toString());
            txtEstado.setText(modelo.getValueAt(fila,2).toString());

    }


}}
