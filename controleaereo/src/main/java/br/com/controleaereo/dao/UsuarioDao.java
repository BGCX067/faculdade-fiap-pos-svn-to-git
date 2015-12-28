package br.com.controleaereo.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.controleaereo.bean.Usuario;

@SuppressWarnings("unchecked")
@Repository
public class UsuarioDao extends SessionFac implements GenericDAO<Usuario> {

	private static UsuarioDao INSTANCE;

	private UsuarioDao() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}
	}

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}

	@Override
	public List<Usuario> listAll() {

		return null;
	}

	@Override
	public Usuario find(Long id) {
		Usuario c = (Usuario) getSession().get(Usuario.class, id);
		return c;
	}

	@Override
	public Usuario update(Usuario t) {
		getSession().update(t);
		return t;
	}

	@Override
	public Usuario save(Usuario t) throws Exception{
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		t.setSenha(sha.encodePassword(t.getSenha(), "256"));
		getSession().save(t);
		return t;
	}

	@Override
	public void delete(Usuario t) {
		getSession().delete(t);
	}

	public Usuario validaUsuario(Usuario usuario) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		usuario.setSenha(sha.encodePassword(usuario.getSenha(), "256"));
		Query query = getSession().createQuery(
				"from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		List<Usuario> lista = query.list();
		Usuario u = null;
		if (lista != null && lista.size() > 0) {
			u = lista.get(0);
		}
		return u;
	}

}
