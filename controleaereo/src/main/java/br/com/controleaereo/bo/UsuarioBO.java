package br.com.controleaereo.bo;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.dao.UsuarioDao;

@Service
public class UsuarioBO {

	@Inject
	private UsuarioDao usuarioDao;

	private static UsuarioBO INSTANCE;

	private UsuarioBO() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static UsuarioBO getInstance() {
		return INSTANCE;
	}

	public void cadastra(Usuario usuario) throws Exception{
		usuarioDao.save(usuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Usuario find(Usuario usuario) {
		return usuarioDao.validaUsuario(usuario);
	}
}
