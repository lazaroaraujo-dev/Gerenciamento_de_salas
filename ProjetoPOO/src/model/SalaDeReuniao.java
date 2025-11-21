package model;

public class SalaDeReuniao extends Espaco{
	private boolean usarProjetor;
	//atributo usarProjetor
	public boolean isUsarProjetor() {
		return usarProjetor;
	}

	public void setUsarProjetor(boolean usarProjetor) {
		this.usarProjetor = usarProjetor;
	}
	//construtor de SalaDeReuniao
	public SalaDeReuniao(int id, String nome, int capacidade, double precoPorHora, boolean usarProjetor) {
		super(id, nome, capacidade, usarProjetor, precoPorHora);
		this.usarProjetor = usarProjetor;
	}
	//metodo abstract calcularCustoReserva
	@Override
	public double calcularCustoReserva(double horas) {
		double valor;
		valor = precoPorHora * horas;
		//uso do projetor
		if(usarProjetor == true) {
			valor += 15.0;
		}
		// TODO Auto-generated method stub
		return valor;
	}
	
}