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

	public MenuProgramador(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlMenuProgramador);
		this.setMinimumSize(new Dimension(900, 600));
		this.setLocationRelativeTo(getParent());


		btnCasos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame menuProgramador = new MenuProgramador("Dashboard - Programador");
				JFrame casosRecibidos = new CasosRecibidos("Casos Recibidos");
				menuProgramador.dispose();
				casosRecibidos.setVisible(true);
				dispose();
			}
		});


		btnBitacora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame bitacoras = new BitacoraForm("Bitacoras");
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
