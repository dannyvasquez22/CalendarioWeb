package model.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -5074782003774815458L;
	private int idUsuario;
	private String usuario_login;
	private String usuario_pass;
	private String nombre;
	private String apellido;
	private String email;
	
	public UserDTO(int idUsuario, String usuario_login, String usuario_pass, String nombre, String apellido, String email) {
		this.idUsuario = idUsuario;
		this.usuario_login = usuario_login;
		this.usuario_pass = usuario_pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public UserDTO(String usuario_login, String usuario_pass, String nombre, String apellido, String email) {
		super();
		this.usuario_login = usuario_login;
		this.usuario_pass = usuario_pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public UserDTO(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario_login() {
		return usuario_login;
	}

	public void setUsuario_login(String usuario_login) {
		this.usuario_login = usuario_login;
	}

	public String getUsuario_pass() {
		return usuario_pass;
	}

	public void setUsuario_pass(String usuario_pass) {
		this.usuario_pass = usuario_pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
