package sv.com.telecomunicaciones.vistas.programador;

import sv.com.telecomunicaciones.metodos.programadores.CasosBitacoras;
import sv.com.telecomunicaciones.metodos.programadores.CasosRecibidosTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Bitacoras extends JFrame {
	private JTable tblCasosBitacoras;
	private JButton btnVerBitacoras;
	private JLabel lblTitulo;
	private JButton btnCasos;
	private JButton btnBitacoras;
	private JButton btnCerrarSession;
	private JButton btnHome;
	private JPanel pnlBitacoras;

	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;

	private String idCaso;
	DefaultTableModel model = null;

	CasosBitacoras casosBitacoras = new CasosBitacoras();

public Bitacoras(String title,int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {

	super(title);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setContentPane(pnlBitacoras);
	this.setMinimumSize(new Dimension(900, 600));
	this.setLocationRelativeTo(getParent());

	this.idUsuario=idUser;
	this.idTrabajador=idEmpleado;
	this.rolTrabajador = rolEmpleado;
	this.areaTrabajador = areaEmpleado;

	model = casosBitacoras.selectCasosBitacoras(idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
	tblCasosBitacoras.setModel(model);

	btnHome.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuProgramador menuProgramador = new MenuProgramador("Sistema",idUsuario,idTrabajador,rolTrabajador,
					areaTrabajador);
			menuProgramador.setVisible(true);
			dispose();
		}
	});
	btnCasos.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			CasosRecibidos casosRecibidos = new CasosRecibidos("Casos Recibidos",idUsuario,idTrabajador,rolTrabajador,
					areaTrabajador);
			casosRecibidos.setVisible(true);
			dispose();
		}
	});
	btnCerrarSession.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	btnVerBitacoras.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	});
}

	//Metodos
	public String casoSeleccionar(MouseEvent e){
		int fila = tblCasosBitacoras.rowAtPoint(e.getPoint());
		int columna = tblCasosBitacoras.columnAtPoint(e.getPoint());
		if ((fila > -1) && (columna > -1)){

			idCaso = model.getValueAt(fila, 0).toString();
			System.out.println(idCaso);
		}
		return idCaso;
	}
}
