package br.com.dietapontos.bean;

public enum TipoUsuario {
	
	ADMIN("ADMIN"), USUARIO("USUARIO");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

}
