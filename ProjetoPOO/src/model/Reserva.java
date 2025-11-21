package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
	private int id;
	private Espaco espaco;
	//data e hora: inicio
	private LocalDateTime inicio;
	//data e hora: fim
	private LocalDateTime fim;
	private statusDaReserva status;
	
	//status da reserva
	public enum statusDaReserva{
		PENDENTE, CONFIRMADO, CANCELADO
	}
	//construtor de Reserva
	public Reserva(int id, Espaco espaco, LocalDateTime inicio, LocalDateTime fim) {
		this.id = id;
		this.espaco = espaco;
		this.status = statusDaReserva.PENDENTE;
		//validacao da hora
		if(inicio.isBefore(fim) == false) {
			throw new IllegalArgumentException("Erro ao reservar.");
		} else {
			this.inicio = inicio;
			this.fim = fim;
		}
	}
	//metodo calculoHora
	public double calculoHora() {
		//intervalo entre as horas
		Duration duracao = Duration.between(inicio, fim);
		//conversao horas para minutos
		return (double) duracao.toMinutes()/60;
	}
	//metodo calculoValor
	public double calculoValor() {
		//receber horas
		double horas = calculoHora();
		//polimorfismo para class Espaco
		return espaco.calcularCustoReserva(horas);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Espaco getEspaco() {
		return espaco;
	}
	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFim() {
		return fim;
	}
	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}
	public statusDaReserva getStatus() {
		return status;
	}
	public void setStatus(statusDaReserva status) {
		this.status = status;
	}
	
}
