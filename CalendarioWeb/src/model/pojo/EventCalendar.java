package model.pojo;

import java.io.Serializable;

public class EventCalendar implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String nombre; //nombre de Evento
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	private int duracion;
	private String color;
	
	public EventCalendar(int idEvento, String nombre, int anio, int mes, int dia, int hora, int minuto, int segundo, int duracion, String color) {
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.duracion = duracion;
		this.color = color;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
