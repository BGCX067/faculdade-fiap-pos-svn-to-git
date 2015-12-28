package br.com.barbero.autoatendimento.bean;

/***
 * {@link Enum} que define os tipos de operacoes existente no sistema.
 * @author Carlos Barbero
 *
 */
public enum TipoOperacao {
	
	SAQUE("- Saque"), DEPOSITO("+ Depósito");
	
	private String tipoOperacao = null;
	
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	
	private TipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	

}
