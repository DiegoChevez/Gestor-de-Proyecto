package sv.com.telecomunicaciones.vistas.programador;

import sv.com.telecomunicaciones.bins.loginBeans.LoginBeans;
import sv.com.telecomunicaciones.metodos.login.BuscarEmpleado;
import sv.com.telecomunicaciones.vistas.Login;
import sv.com.telecomunicaciones.util.ConexionSQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoCasos extends JFrame{
	private JTextField txtFechaRealizacion;
	private JTextField txtIdCaso;
	private JTextField txtEncargado;
	private JTextArea txtDescripcion;
	private JTextField txtFechaFinalizacion;
	private JTextField txtTester;
	private JButton btnAgregarBitacora;
	private JButton btnRegresar;
	private JTextArea txtComentarioJefe;
	private JTextField txtAvance;
	private JTextArea txtComentarioTester;
	private JPanel pnlInfoCasos;
	private JLabel lblTitulo;

	private String caso;
	private String encargado;
	private String descripcionCaso;
	private String fechaRealizacion;
	private String comentariosJefe;
	private String fechaFinalizacion;
	private int porcentajeAvance;
	private String tester;
	private String comentariosTester;
	private String estado;


	private int idTrabajador;
	private int idUsuario;
	private String rolTrabajador;
	private String areaTrabajador;

	public InfoCasos(String title,String idCaso,int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlInfoCasos);
		this.setMinimumSize(new Dimension(900, 600));
		this.setLocationRelativeTo(getParent());

		this.idUsuario=idUser;
		this.idTrabajador=idEmpleado;
		this.rolTrabajador = rolEmpleado;
		this.areaTrabajador = areaEmpleado;

		this.caso = idCaso;
		Llenartxt();



		btnAgregarBitacora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String estadoBtn = btnAgregarBitacora.getText();
				if(estadoBtn != "Agregar"){
					SubitCaso();
				}else {
					AgregarBitacora agregarBitacora = new AgregarBitacora("Sistema DEV", caso,idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
					agregarBitacora.setVisible(true);
				}

			}
		});
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CasosRecibidos casosRecibidos = new CasosRecibidos("Sistema DEV",idUsuario,idTrabajador,rolTrabajador,
						areaTrabajador);
				casosRecibidos.setVisible(true);
			}
		});
	}
	public void Llenartxt(){
		String SQL = "SELECT CONCAT(ee.Nombres, ' ' , ee.Apellidos) AS Solicitante, casos.DescripcionCaso,casos" +
				".FechaRealizacion,casos.ComentariosJefe,casos.FechaFinalizacion,casos.PorcentajeAvance,CONCAT(et" +
				".Nombres,' ',et.Apellidos) AS Tester, casos.ComentariosTester,casos.Estado FROM casos INNER JOIN " +
				"empleados ee ON casos.Encargado = ee.Id_Empleado INNER JOIN empleados et ON casos.Tester = et" +
				".Id_Empleado WHERE casos.Id_Caso = '"+caso+"'";
		int resulSQL;

		ConexionSQL conexion = new ConexionSQL();
		Connection con = conexion.conexion();

		try {
			//definimos un metodo sql
			Statement st = con.createStatement();
			//Ejecutamos la consulta
			ResultSet rs = st.executeQuery(SQL);

			if(rs.next()){
				resulSQL = 1;
				switch (resulSQL){
					case 1:
						// Recuperar los valores de las columnas y guardarlos en variables
						encargado = rs.getString("Solicitante");
						descripcionCaso = rs.getString("DescripcionCaso");
						fechaRealizacion = rs.getString("FechaRealizacion");
						comentariosJefe = rs.getString("ComentariosJefe");
						fechaFinalizacion = rs.getString("FechaFinalizacion");
						porcentajeAvance = rs.getInt("PorcentajeAvance");
						tester = rs.getString("Tester");
						comentariosTester = rs.getString("ComentariosTester");
						estado = rs.getString("Estado");

						//Guardar datos
						lblTitulo.setText(caso + " : "+estado);
						txtIdCaso.setText(caso);
						txtAvance.setText(porcentajeAvance + "%");
						txtComentarioJefe.setText(comentariosJefe);
						txtDescripcion.setText(descripcionCaso);
						txtEncargado.setText(encargado);
						txtComentarioTester.setText(comentariosTester);
						txtFechaFinalizacion.setText(fechaFinalizacion);
						txtFechaRealizacion.setText(fechaRealizacion);
						txtTester.setText(tester);

						if(porcentajeAvance==100){
							btnAgregarBitacora.setText("Subir");
						}

						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Error" );
						break;
				}

			}else {
				JOptionPane.showMessageDialog(null, "error 1" );
			}
			//Cerrar conexiones
			st.close();
			rs.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error"+ e.getMessage() );
		}

	}

	public void SubitCaso(){
		String SQL = "UPDATE casos SET Estado = 'en espera de una respuesta' WHERE Id_Caso = '"+caso+"'";

		ConexionSQL conexion = new ConexionSQL();
		Connection con = conexion.conexion();

		try {
			//definimos un metodo sql
			Statement st = con.createStatement();
			//Ejecutamos la consulta
			int actualizacion = st.executeUpdate(SQL);
			if(actualizacion==1){
				JOptionPane.showMessageDialog(null,"Base de Datos Actualizada");
				dispose();
				CasosRecibidos casosRecibidos = new CasosRecibidos("",idUsuario,idTrabajador,rolTrabajador,areaTrabajador);
				casosRecibidos.setVisible(true);
			}

			//Cerrar conexiones
			st.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error"+ e.getMessage() );
		}
	}
}
