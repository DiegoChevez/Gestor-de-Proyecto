package sv.com.telecomunicaciones.vistas.tester;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;

import sv.com.telecomunicaciones.bins.tester.*;
import sv.com.telecomunicaciones.metodos.tester.*;

public class BinnacleView extends JFrame{
    private JLabel lblIndicaciones;
    private JLabel lblTitulo;
    private JTable tblBinnacle;
    private JPanel pnlBinnacle;
    private JLabel lblImage;
    private JTextField txtCase;
    private JTextField txtIDBinnacle;
    private JTextField txtAdvance;
    private JTextField txtDate;
    private JButton btnBack;
    private JButton btnWatchBinnacle;
    private JTextArea txtDescription;

    DefaultTableModel modelo = null;
    BinnacleBeans binnacleBeans = null;
    BinnacleData binnacleData = new BinnacleData();

    // * Constructor con las configuraciones básicas de la ventana de JFrame
    public BinnacleView(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlBinnacle);
        this.setMinimumSize(new Dimension(600,500));
        this.setLocationRelativeTo(getParent());

        modelo = binnacleData.selectBinnacle();
        tblBinnacle.setModel(modelo);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TesterView vista = new TesterView("Módulo de testing");
                vista.setVisible(true);
                dispose();
            }
        });

        btnWatchBinnacle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WatchBinnacle watch = new WatchBinnacle("Bitacora del caso seleccionado");
                int filaSeleccionada = tblBinnacle.getSelectedRow();
                Object valorSeleccionado = tblBinnacle.getValueAt(filaSeleccionada,0);

                binnacleBeans.setIdBinnacle(Integer.parseInt(valorSeleccionado.toString()));
                watch.setVisible(true);
                dispose();
            }
        });
        tblBinnacle.addMouseListener(new MouseAdapter() {
        });
        tblBinnacle.addComponentListener(new ComponentAdapter() {
        });
    }
}

