package model;

import java.time.LocalDateTime;

public class Pagamento {
	private int id;
	private Reserva reserva;
	private double valorPago;
	private LocalDateTime pagamentoData;
	private MetodoPagamento metodo;
	//metodos Pagamentos
	public enum MetodoPagamento {
		DINHEIRO, CARTAO, PIX
	}
	//construtor Pagamento
	public Pagamento(int id, Reserva reserva, double valorPago, LocalDateTime pagamentoData, MetodoPagamento metodo) {
		this.id = id;
		this.reserva = reserva;
		this.valorPago = valorPago;
		this.pagamentoData = pagamentoData;
		this.metodo = metodo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public LocalDateTime getPagamentoData() {
		return pagamentoData;
	}
	public void setPagamentoData(LocalDateTime pagamentoData) {
		this.pagamentoData = pagamentoData;
	}
	public MetodoPagamento getMetodo() {
		return metodo;
	}
	public void setMetodo(MetodoPagamento metodo) {
		this.metodo = metodo;
	}
}
