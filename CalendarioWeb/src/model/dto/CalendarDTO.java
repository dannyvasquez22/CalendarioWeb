package model.dto;

import java.io.Serializable;

public class CalendarDTO implements Serializable {

	private static final long serialVersionUID = -1805163017932349151L;
	private int idCalendario;
	private UserDTO usuario;
	private String nombre;
	private String color;
	
	public CalendarDTO(int idCalendario, UserDTO usuario, String nombre, String color) {
		this.idCalendario = idCalendario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.color = color;
	}
	
	public CalendarDTO(UserDTO usuario, String nombre, String color) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.color = color;
	}
	
	public CalendarDTO(int idCalendario) {
		this.idCalendario = idCalendario;
	}

	public int getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}

	public UserDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UserDTO usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
