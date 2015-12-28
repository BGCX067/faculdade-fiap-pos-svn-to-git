package br.com.fiap.javaweb.provaonline.bean;

public enum TipoUsuario {
	
	ADMIN("ADMIN"), ALUNO("ALUNO");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

}
