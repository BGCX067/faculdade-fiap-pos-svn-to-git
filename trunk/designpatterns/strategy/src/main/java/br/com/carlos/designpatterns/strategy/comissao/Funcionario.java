package br.com.carlos.designpatterns.strategy.comissao;

public class Funcionario {

	private long id;
    
	private Cargo cargo;
      
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
      
      
}
