package br.com.fiap.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contrato {
	private ApoliceSeguro apoliceSeguro;
    private Date dataAssinatura;
    private Date dataVigencia;
    private Date dataTermino;


    public ApoliceSeguro getApoliceSeguro() {
        return apoliceSeguro;
    }

    public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
        this.apoliceSeguro = apoliceSeguro;
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }
    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }
    public Date getDataVigencia() {
        return dataVigencia;
    }
    public void setDataVigencia(Date dataVigencia) {
        this.dataVigencia = dataVigencia;
    }
    public Date getDataTerminoContrato() {
        return dataTermino;
    }
    public void setDataTerminoContrato(Date dataTerminoContrato) {
        this.dataTermino = dataTerminoContrato;
    }


}
