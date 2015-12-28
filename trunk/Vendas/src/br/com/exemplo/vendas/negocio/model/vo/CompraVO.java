package br.com.exemplo.vendas.negocio.model.vo ;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Reserva;

@XmlRootElement(name="CompraVO")
public class CompraVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 792902696334733058L;
	private Integer numero;
	private Date data;
	private String responsavel;
	private String situacao;
	private BigDecimal valor;
	private Reserva reserva;
	private Cliente cliente;

	public CompraVO( )
	{
	}

	public CompraVO(Integer numero){
		this.numero = numero;
	}
	
	public CompraVO(Integer numero, Date data, String responsavel,
			String situacao, BigDecimal valor, Reserva reserva, Cliente cliente) {
		super();
		this.numero = numero;
		this.data = data;
		this.responsavel = responsavel;
		this.situacao = situacao;
		this.valor = valor;
		this.reserva = reserva;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CompraVO [numero=" + numero + ", data=" + data
				+ ", responsavel=" + responsavel + ", situacao=" + situacao
				+ ", valor=" + valor + ", reserva=" + reserva + ", cliente="
				+ cliente + "]";
	}
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
