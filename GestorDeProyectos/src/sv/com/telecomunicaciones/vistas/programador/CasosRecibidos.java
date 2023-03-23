package sv.com.telecomunicaciones.vistas.programador;

import sv.com.telecomunicaciones.metodos.programadores.CasosRecibidosTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CasosRecibidos extends JFrame {
	private JPanel pnlCasos;
	private JLabel lblTitulo;
	private JButton agregarUnaBitacoraButton;
	private JTable tblCasos;
	private JButton btnInfoBitacora;
	private JButton btnCerrarSession;
	private JButton btnBitacoras;
	private JButton btnCasos;
	private JButton btnHome;

	DefaultTableModel model = null;
	CasosRecibidosTable casosRecibidosTable = new CasosRecibidosTable();


	public CasosRecibidos(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlCasos);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(getParent());

		try {
			model = casosRecibidosTable.selectCasos();
			tblCasos.setModel(model);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		btnCerrarSession.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuProgramador menuProgramador = new MenuProgramador("Menu Programador");
				menuProgramador.setVisible(true);
			}
		});
	}

}
