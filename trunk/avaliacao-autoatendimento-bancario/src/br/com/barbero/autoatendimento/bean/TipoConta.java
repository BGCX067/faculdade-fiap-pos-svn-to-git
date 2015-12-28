package br.com.barbero.autoatendimento.bean;

/***
 * {@link Enum} que define os tipos de contas existente no sistema.
 * @author Carlos Barbero
 *
 */
public enum TipoConta {
	
	POUPANCA, CORRENTE, BUSCAR;
	
	
	public TipoConta getTipoConta(String tipo){
		TipoConta tipoConta = null;
		if(tipo.equals("C")){
			tipoConta = TipoConta.CORRENTE;
		}
		else{
			tipoConta = TipoConta.POUPANCA;
		}
		return tipoConta;
	}
	
}
