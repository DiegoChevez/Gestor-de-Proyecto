package sv.com.telecomunicaciones.vistas.administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioUsuario extends JFrame {
    private JPanel pnlCreateUsers;
    private JLabel lblCreateUser;
    private JButton btnRegresar;
    private JButton btnCreateUser;
    private JLabel lblUsername;
    private JTextField txtPassword;
    private JLabel lblPassword;
    private JTextField txtUsername;

    private String nameUser;
    private String surnameUser;
    private int idTrabajador;
    private int idUsuario;
    private String rolTrabajador;
    private String areaTrabajador;


private String name;

    @Override
    public void setName(String name) {
        this.name = name;
       txtUsername.setText(nameUser+surnameUser);
    }

    public int idEmployee;

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;


    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }

    public FormularioUsuario (String title, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
        super(title);
        this.idUsuario=idUser;
        this.idTrabajador=idEmpleado;
        this.rolTrabajador = rolEmpleado;
        this.areaTrabajador = areaEmpleado;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlCreateUsers);
        this.setMinimumSize(new Dimension(600,600));
        this.setLocationRelativeTo(getParent());

        txtUsername.setText(nameUser+surnameUser);
    btnCreateUser.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUsuario crearUsuario=new CrearUsuario("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
                crearUsuario.setVisible(true);
                dispose();


            }
        });
    }
}
