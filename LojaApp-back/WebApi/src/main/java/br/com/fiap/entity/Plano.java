package br.com.fiap.entity;

public class Plano {
	
	private int idPlano;
    private String nome;
    private double valor;
    private Contrato contrato;

    public int getIdPlano() {
		return idPlano;
	}



	public void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Contrato getContrato() {
		return contrato;
	}



	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}



	public String exibirDados() {
        return "----------------------------------------" + '\n' +
                "| PLANO " + '\n' +
                "| Nome do plano: " + nome + '\n' +
                "| valor: " + valor + '\n' +
                "| ID: " + idPlano + '\n' +
                "----------------------------------------";
    }
}
