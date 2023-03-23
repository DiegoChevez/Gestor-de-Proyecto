package sv.com.telecomunicaciones.vistas.programador;
import sv.com.telecomunicaciones.metodos.programadores.CasosRecibidosTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CasosRecibidos extends JFrame {
	private JPanel pnlCasos;
	private JLabel lblTitulo;
	private JButton agregarUnaBitacoraButton;
	private JTable tblCasos;
	private JButton btnInfoCaso;
	private JButton btnCerrarSession;
	private JButton btnBitacoras;
	private JButton btnCasos;
	private JButton btnHome;
	private String idCaso;

	DefaultTableModel model = null;

	CasosRecibidosTable casosRecibidosTable = new CasosRecibidosTable();

	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;


	public CasosRecibidos(String title,int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlCasos);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(getParent());

		this.idUsuario=idUser;
		this.idTrabajador=idEmpleado;
		this.rolTrabajador = rolEmpleado;
		this.areaTrabajador = areaEmpleado;

		try {
			model = casosRecibidosTable.selectCasos(idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
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
				MenuProgramador menuProgramador = new MenuProgramador("Menu Programador",idUsuario,idTrabajador,
						rolTrabajador,areaTrabajador);
				menuProgramador.setVisible(true);
			}
		});
		tblCasos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				idCaso = casoSeleccionar(e);
			}
		});
		agregarUnaBitacoraButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AgregarBitacora agregarBitacora = new AgregarBitacora("Agregar Bitacora", idCaso,idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
				agregarBitacora.setVisible(true);
				dispose();
			}
		});
		btnInfoCaso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idCaso.isBlank()){
					JOptionPane.showMessageDialog(null, "Seleccione un caso","Login",JOptionPane.ERROR_MESSAGE);
				}else{
					InfoCasos infoCasos = new InfoCasos("Sistema DEVDEV",idCaso,idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
					System.out.println(idCaso);
					infoCasos.setVisible(true);
					dispose();
				}
			}
		});
	}

	//Metodos
	public String casoSeleccionar(MouseEvent e){
		int fila = tblCasos.rowAtPoint(e.getPoint());
		int columna = tblCasos.columnAtPoint(e.getPoint());
		if ((fila > -1) && (columna > -1)){

			idCaso = model.getValueAt(fila, 0).toString();
			System.out.println(idCaso);
		}
		return idCaso;
	}
	}