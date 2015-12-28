package br.com.dietapontos.managedbean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.dietapontos.bean.TipoUsuario;
import br.com.dietapontos.bean.Usuario;
import br.com.dietapontos.dao.UsuarioDaoImpl;

@ManagedBean(name = "cadastroUsuariosManagedBean")
@SessionScoped
@SuppressWarnings("unused")
public class CadastroUsuariosManagedBean {

	@Inject
	private static UsuarioDaoImpl usuarioDao;
	
	private String tipoU;
	private Usuario usuario = new Usuario();

	public String cadastrar() {
		usuario.setTipoUsuario(tipoU);
		usuarioDao.save(usuario);
		br.com.dietapontos.bean.TipoUsuario.values();
		return "index.faces";
	}

	public static UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}

	public static void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		CadastroUsuariosManagedBean.usuarioDao = usuarioDao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoUsuario[] getTipoUsuario() {
		return TipoUsuario.values();
	}

	public void setTipoU(String tipoUsuario) {
		this.tipoU = tipoUsuario;
	}

	public String getTipoU() {
		return tipoU;
	}
	
}
