package sv.com.telecomunicaciones.vistas.programador;

import sv.com.telecomunicaciones.vistas.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProgramador extends JFrame {
	private JButton btnBitacora;
	private JButton btnCasos;
	private JPanel pnlMenuProgramador;
	private JButton btnRegresar;

	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;

	public MenuProgramador(String title,int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlMenuProgramador);
		this.setMinimumSize(new Dimension(900, 600));
		this.setLocationRelativeTo(getParent());


		this.idUsuario=idUser;
		this.idTrabajador=idEmpleado;
		this.rolTrabajador = rolEmpleado;
		this.areaTrabajador = areaEmpleado;

		btnCasos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CasosRecibidos casosRecibidos = new CasosRecibidos("Sistema DEVDEV",idUsuario,idTrabajador,rolTrabajador,
						areaTrabajador);
				casosRecibidos.setVisible(true);
				dispose();
			}
		});


		btnBitacora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bitacoras bitacoras = new Bitacoras("Sistema DEVDEV",idUsuario,idTrabajador,rolTrabajador,
						areaTrabajador);
				bitacoras.setVisible(true);
				dispose();
			}
		});
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login("Gestor DEVDEV");
				login.setVisible(true);
			}
		});
	}
}
