package sv.com.telecomunicaciones.vistas.programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProgramador extends JFrame {
	private JButton btnBitacora;
	private JButton btnCasos;
	private JPanel pnlMenuProgramador;

	public MenuProgramador(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlMenuProgramador);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(getParent());

		btnCasos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});


		btnBitacora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
