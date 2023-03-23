package sv.com.telecomunicaciones.metodos.login;

import sv.com.telecomunicaciones.vistas.Login;
import sv.com.telecomunicaciones.vistas.programador.MenuProgramador;

import javax.swing.*;


public class VistasModulos {
	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;

	public void VistasModulos(int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
		this.idUsuario=idUser;
		this.idTrabajador=idEmpleado;
		this.rolTrabajador = rolEmpleado;
		this.areaTrabajador = areaEmpleado;

		switch(rolEmpleado) {
			case "Administrador":
				JOptionPane.showMessageDialog(null, "Usted es un Administrador", "Administrador",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuAdministrador MenuAdmin = new MenuAdministrador("title");
				MenuAdmin.setVisible(true);*/
				break;
			case "Jefe":
				JOptionPane.showMessageDialog(null, "Usted es un Jefe de Area", "Jefe de Area",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuFuncionales MenuFun = new MenuFuncionales("title");
				MenuFun.setVisible(true);*/
				break;
			case "Jefe de Desarrollo":
				JOptionPane.showMessageDialog(null, "Usted es un Jefe de Desarrollo", "Jefe de Desarrollo",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuDesarrollador MenuDev = new MenuDesarrollador("title");
				MenuDev.setVisible(true);*/
				break;
			case "Empleado":
				JOptionPane.showMessageDialog(null, "Usted es un Empleado", "Empleado",
						JOptionPane.INFORMATION_MESSAGE);
				/*MenuTester MenuTest = new MenuTester("title");
				MenuTest.setVisible(true);*/
				break;
			case "Programadores":
				JOptionPane.showMessageDialog(null, "Usted es un programador", "Programador",
						JOptionPane.INFORMATION_MESSAGE);

				MenuProgramador menuProgramador = new MenuProgramador("Dashboard - Programador",idUsuario,
						idTrabajador,rolTrabajador,areaTrabajador);
				Login login = new Login("Login");
				login.dispose();
				menuProgramador.setVisible(true);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Usted no es un empleado", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				break;
		}
	}

}
