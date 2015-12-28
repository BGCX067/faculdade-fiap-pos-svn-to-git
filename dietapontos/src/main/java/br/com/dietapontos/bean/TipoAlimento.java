package br.com.dietapontos.bean;

public enum TipoAlimento {
	
	PROTEINA("PROTEINA"), LIPIDIO("LIPIDIO"), VITAMINAS("VITAMINAS"), MINERAIS("MINERAIS"), CARBOIDRATO("CARBOIDRATO");
	
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	private TipoAlimento(String t) {
		this.tipo = t;
	}
}
