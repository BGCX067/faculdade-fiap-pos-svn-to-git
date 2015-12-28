package br.com.dietapontos.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dietapontos.bean.Usuario;

@ManagedBean(name = "menuManagedBean")
@SessionScoped
public class MenuManagedBean {

	private Usuario usuario;

	public MenuManagedBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		usuario = ((LoginManagedBean) context.getExternalContext()
				.getSessionMap().get("loginManagedBean")).getUsuario();
	}

	public String getPoints() {
		Double metabolismo;
		int weight = Integer.parseInt(usuario.getPeso());
		int size = Integer.parseInt(usuario.getAltura());
		int age = Integer.parseInt(usuario.getIdade());
		Double activityLevel = Double.parseDouble(usuario.getTaxaAtividade());
		if ("m".equals(usuario.getSexo())) {
			metabolismo = activityLevel * (66 + ((13.7 * weight) + (5 * size) - (6.8 * age)));
		} else {
			metabolismo = activityLevel * (655 + ((9.6 * weight) + (1.8 * size) - (4.7 * age)));
		}
		metabolismo /= 3.6;
		return String.valueOf((int) metabolismo.doubleValue());
	}
}