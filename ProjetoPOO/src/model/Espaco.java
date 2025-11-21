package model;

public abstract class Espaco {
	
	protected int id;
	protected String nome;
	protected int capacidade;
	protected boolean disponivel;
	protected double precoPorHora;
	
	public Espaco(int id, String nome, int capacidade, boolean disponivel, double precoPorHora) {
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.disponivel = true;
		this.precoPorHora = precoPorHora;
	}
	//id
	public int getid() {
		return id;
	}
	
	public void setId(int id) {
        this.id = id;
    }
	//nome
	public String getnome() {
		return nome;
	}
	
	public void setnome(String nome) {
        this.nome = nome;
    }
	//capacidade
	public int getcapacidade() {
		return capacidade;
	}
	
	public void setcapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
	//precoPorHora
	public double getprePorHora() {
		return precoPorHora;
	}
	
	public void setprePorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }
	//método abstrato calcularCustoReserva
	public abstract double calcularCustoReserva(double horas);
}
