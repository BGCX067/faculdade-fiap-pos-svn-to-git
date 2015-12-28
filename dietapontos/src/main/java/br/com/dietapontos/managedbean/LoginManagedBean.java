package br.com.dietapontos.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.dietapontos.bean.Usuario;
import br.com.dietapontos.dao.UsuarioDaoImpl;

@ManagedBean(name = "loginManagedBean")
@SessionScoped
@SuppressWarnings("static-access")
public class LoginManagedBean {
	
	@Inject
	private static UsuarioDaoImpl usuarioDao;
	
	private Usuario usuario = new Usuario();
	
	public UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}
	
	public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	 public String login(){
		 usuario = usuarioDao.validaUsuario(usuario);
		 if(usuario != null){
			 return "/paginas/menu.faces";
		 }else{
			 return "/loginError.faces";
		 }
		 
	 }
}