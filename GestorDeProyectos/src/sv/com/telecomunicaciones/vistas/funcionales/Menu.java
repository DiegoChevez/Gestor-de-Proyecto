package sv.com.telecomunicaciones.vistas.funcionales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFuncionales extends JFrame{
    private JPanel panel1;
    private JButton BtnDesarrollo;
    private JButton casosEnEsperaButton;
    private JButton casosEnviadosButton;
    private JButton casosRechazadosButton;

    public MenuFuncionales(String menú) {

    }

    public static void main(String[] args) {
        JFrame frame = new MenuFuncionales("Menú");
        frame.setVisible(true);
    }


}

