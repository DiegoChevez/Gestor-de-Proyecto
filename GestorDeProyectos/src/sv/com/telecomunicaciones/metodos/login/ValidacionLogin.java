package sv.com.telecomunicaciones.metodos.login;

import sv.com.telecomunicaciones.vistas.Login;

import javax.swing.*;

public class ValidacionLogin {

	private String txtUsuario;
	private String txtContrasena;

	public void ValidacionLogin( String txtUser,String txtPasswd){
		this.txtUsuario = txtUser;
		this.txtContrasena = txtPasswd;

		if (txtUsuario.isBlank() || txtContrasena.isBlank()) {
			JOptionPane.showMessageDialog(null, "Campos Vacios","Login",JOptionPane.ERROR_MESSAGE);
			Login login = new Login("Gestor DEVDEV");
			login.setVisible(true);
		} else {
			BuscarUsuario buscarUsuario = new BuscarUsuario();
			buscarUsuario.BuscarUsuario(txtUsuario,txtContrasena);
		}

	}

}
