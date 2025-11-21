package model;

public class CabineIndividual extends Espaco {
	//construtor CabineIndividual
	public CabineIndividual(int id, String nome, int capacidade, boolean disponivel, double precoPorHora) {
		super(id, nome, capacidade, disponivel, precoPorHora);
	}
	//metodo abstract calcularReserva
	@Override
	public double calcularCustoReserva(double horas) {
		double valor;
		double desconto;
		if(horas >= 4) {
			valor = precoPorHora * horas;
			desconto = valor * (10/100);
			valor = valor - desconto;
		} else {
			valor = precoPorHora * horas;
		}
		// TODO Auto-generated method stub
		return valor;
	}
}
