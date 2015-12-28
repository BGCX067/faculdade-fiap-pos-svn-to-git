package br.com.exemplo;

import java.util.List;

public class Procedimentos {
	
	private String procedimento;
	
	private List<String> detalhes;
	
	public String getProcedimento() {
		return procedimento;
	}
	
	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	
	public void setDetalhes(List<String> detalhes) {
		this.detalhes = detalhes;
	}
	
	public List<String> getDetalhes() {
		return detalhes;
	}

	@Override
	public String toString() {
		return "Procedimentos [procedimento=" + procedimento + ", detalhes="
				+ detalhes + "]";
	}
	

	
	
}
