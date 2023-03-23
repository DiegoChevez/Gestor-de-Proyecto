package sv.com.telecomunicaciones.vistas.programador;

import sv.com.telecomunicaciones.metodos.login.BuscarUsuario;
import sv.com.telecomunicaciones.util.ConexionSQL;
import sv.com.telecomunicaciones.vistas.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgregarBitacora extends JFrame{
	private JPanel pnlAgregarBitacora;
	private JButton btnCancelar;
	private JButton btnSubir;
	private JTextArea txtDescripcion;
	private JTextField textField1;
	private JTextField txtFechaRealizacion;
	private JLabel lblTitulo;
	private JLabel txtAvance;
	private String caso;

	public AgregarBitacora(String title, String idCaso, int idUser, int idEmpleado, String rolEmpleado, String areaEmpleado) {

		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pnlAgregarBitacora);
		this.setMinimumSize(new Dimension(600, 500));
		this.setLocationRelativeTo(getParent());
		this.caso = idCaso;
		lblTitulo.setText("Agregar Bitacora - Caso: " + idCaso);
		String fecha = String.valueOf(getFechaActual());
		txtFechaRealizacion.setText(fecha);


		btnSubir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ValidarForm();
			}
		});
	}

	public void ValidarForm(){
		String descripcion = txtDescripcion.getText();
		String fechaActual = String.valueOf(getFechaActual());
		String progreso = txtAvance.getText();

		if (descripcion.isBlank() || progreso.isBlank()) {
			JOptionPane.showMessageDialog(null,"Campos Vacios");

		} else {
			String patron = "^[0-9]+$";
			Pattern pattern = Pattern.compile(patron);
			Matcher matcher = pattern.matcher(progreso);
			if (matcher.matches()) {
				JOptionPane.showMessageDialog(null, "Bitacora Agregada");
			} else {
				JOptionPane.showMessageDialog(null,"El campo Progreso solamente acepta numeros");
				return;
			}
		}
	}

	public Timestamp getFechaActual(){
		ConexionSQL conexion = new ConexionSQL();
		Connection con = conexion.conexion();
		try {
			// Crear una declaración SQL para obtener la fecha del servidor
			String SQL = "SELECT NOW() as server_date";

			// Ejecutar la consulta
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL);

			// Obtener la fecha del servidor del resultado de la consulta
			if (resultSet.next()) {
				java.sql.Timestamp serverDate = resultSet.getTimestamp("server_date");
				System.out.println("Fecha del servidor: " + serverDate);
				return serverDate;
			}
		} catch (SQLException ex) {
			System.out.println("Ocurrió un error al obtener la fecha del servidor: " + ex.getMessage());
		}
		return null;
	}
}
