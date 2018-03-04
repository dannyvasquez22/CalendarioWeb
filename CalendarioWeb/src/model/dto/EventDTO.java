package model.dto;

import java.io.Serializable;

public class EventDTO implements Serializable {

	private static final long serialVersionUID = 5959908384569298952L;
	private int idEvent;
	private CalendarDTO calendario;
	private String nombre;
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	private int duracion; // en minutos
	
	public EventDTO(int idEvent, CalendarDTO calendario, String nombre, int anio, int mes, int dia, int hora, int minuto, int segundo, int duracion) {
		this.idEvent = idEvent;
		this.calendario = calendario;
		this.nombre = nombre;
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.duracion = duracion;
	}

	public EventDTO(CalendarDTO calendario, String nombre, int anio, int mes, int dia, int hora, int minuto, int segundo, int duracion) {
		this.calendario = calendario;
		this.nombre = nombre;
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.duracion = duracion;
	}
	
	public EventDTO(int idEvent) {
		this.idEvent = idEvent;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public CalendarDTO getCalendario() {
		return calendario;
	}

	public void setCalendario(CalendarDTO calendario) {
		this.calendario = calendario;
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
	
}
