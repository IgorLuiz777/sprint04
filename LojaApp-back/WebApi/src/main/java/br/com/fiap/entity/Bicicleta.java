package br.com.fiap.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bicicleta {
	private String modelo;
    private String marca;
    private String numeroSerie;
    private double valorMercado;
    private int id;

    @Override
    public String toString() {
        return "Bicicleta{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", valorMercado=" + valorMercado +
                ", id=" + id +
                '}';
    }

    public String exibirDados() {
        return  "\n Modelo: " + this.modelo +
                "\n Marca: " + this.marca +
                "\n Número de série: " + this.numeroSerie +
                "\n Valor do mercado: " + this.valorMercado +
                "\n ID: " + this.id;
    }

    public void cadastrarBicicleta(String modelo, String marca, String numeroSerie, double valor) {
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.valorMercado = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
