package br.com.fiap.aop.aspectj;

public enum TipoCliente {
	
	FISICO("Fisica"), JURIDICO("Juridica");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoCliente(String tipoCliente) {
		this.descricao = tipoCliente;
	}

}
