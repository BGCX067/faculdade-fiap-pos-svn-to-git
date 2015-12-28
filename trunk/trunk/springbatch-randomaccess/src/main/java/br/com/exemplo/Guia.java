package br.com.exemplo;

import java.util.List;

public class Guia {
	
	private String linha;
	private List<Procedimentos> procedimentos;
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	
	public List<Procedimentos> getProcedimentos() {
		return procedimentos;
	}
	
	public void setProcedimentos(List<Procedimentos> procedimentos) {
		this.procedimentos = procedimentos;
	}
	@Override
	public String toString() {
		return "Guia [linha=" + linha + ", procedimentos=" + procedimentos
				+ "]";
	}
	
	
	

}
