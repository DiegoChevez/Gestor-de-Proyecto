package sv.com.telecomunicaciones.vistas;
import sv.com.telecomunicaciones.metodos.login.*;
import sv.com.telecomunicaciones.util.ConexionSQL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private JTextField txtUsuario;
	private JTextField txtContra;
	private JButton btnIngresar;
	private JPanel pnlLogin;
	private JLabel alertUser;
	private JLabel alertPasswd;
	private JButton btbCerrarSesion;


	public Login(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlLogin);
		this.setMinimumSize(new Dimension(400, 600));
		this.setLocationRelativeTo(getParent());

		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txtUser = txtUsuario.getText();
				String txtPasswd = txtContra.getText();

				//Instanciamos nuestro metodo
				ValidacionLogin validacionLogin = new ValidacionLogin();
				validacionLogin.ValidacionLogin(txtUser,txtPasswd);
				dispose();
			}
		});
		btbCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
