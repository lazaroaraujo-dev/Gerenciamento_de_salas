package model;

public class Auditorio extends Espaco {
	private double taxa;
	//construtor Auditorio
	public Auditorio(int id, String nome, int capacidade, boolean disponivel, double precoPorHora) {
		super(id, nome, capacidade, disponivel, precoPorHora);
		this.taxa = 100;
	}
	//metodo abstract calcularReserva
	@Override
	public double calcularCustoReserva(double horas) {
		double valor;
		valor = precoPorHora * horas + this.taxa;
		// TODO Auto-generated method stub
		return valor;
	}
}

