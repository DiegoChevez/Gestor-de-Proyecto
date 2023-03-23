package sv.com.telecomunicaciones.bins.loginBeans;

public class LoginBeans {
	private int idUsuario;
	private int idTrabajador;
	private String username;
	private String userpass;
	private String estado;
	private String nombresUser;
	private String apellidosUser;
	private String rolEmpleado;
	private String areaEmpleado;

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombresUser() {
		return nombresUser;
	}
	public void setNombresUser(String nombresUser) {
		this.nombresUser = nombresUser;
	}

	public String getApellidosUser() {
		return apellidosUser;
	}
	public void setApellidosUser(String apellidosUser) {
		this.apellidosUser = apellidosUser;
	}

	public String getAreaEmpleado() {
		return areaEmpleado;
	}
	public void setAreaEmpleado(String areaEmpleado) {
		this.areaEmpleado = areaEmpleado;
	}

	public String getRolEmpleado() {
		return rolEmpleado;
	}
	public void setRolEmpleado(String rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}
}
