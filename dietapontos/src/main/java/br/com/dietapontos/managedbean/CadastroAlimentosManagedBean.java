package br.com.dietapontos.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.dietapontos.bean.Alimentos;
import br.com.dietapontos.bean.TipoAlimento;

@ManagedBean(name="cadastroAlimentosManagedBean")
@RequestScoped
public class CadastroAlimentosManagedBean {
	
	private Alimentos alimentos;
	private String tipoA;

	public Alimentos getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Alimentos alimentos) {
		this.alimentos = alimentos;
	}

	public String getTipoA() {
		return tipoA;
	}

	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}

	public TipoAlimento[] getTipoAlimento() {
		return TipoAlimento.values();
	}
	
	public String cadastrar(){
		return "";
	}
	
}
