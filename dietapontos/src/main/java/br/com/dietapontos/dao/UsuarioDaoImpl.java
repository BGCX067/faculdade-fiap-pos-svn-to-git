package br.com.dietapontos.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.dietapontos.bean.Usuario;

@SuppressWarnings("static-access")
@Repository
public class UsuarioDaoImpl implements GenericDAO<Usuario> {

	@Inject
	private static SessionFactory sessionFactory;
	
	private static Session session;

	public static void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
		session = sf.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public Usuario validaUsuario(Usuario us) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		us.setSenha(sha.encodePassword(us.getSenha(), "256"));
		Query query = session.createQuery(
				"from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", us.getEmail());
		query.setParameter("senha", us.getSenha());
		List<Usuario> lista = query.list();
		Usuario usuario = null;
		if (lista != null && lista.size() > 0) {
			usuario = lista.get(0);
		}
		return usuario;
	}

	@Override
	public List<Usuario> listAll() {
		@SuppressWarnings("unchecked")
		List<Usuario> list = session.createQuery("from Usuario")
				.list();
		close();
		return list;
	}

	@Override
	public Usuario find(Long id) {
		Usuario c = (Usuario) session.get(Usuario.class, id);
		close();
		return c;
	}

	@Override
	public Usuario update(Usuario t) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		t.setSenha(sha.encodePassword(t.getSenha(), "256"));
		session.merge(t);
		close();
		return t;
	}

	@Override
	public Usuario save(Usuario t) {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		t.setSenha(sha.encodePassword(t.getSenha(), "256"));
		session.save(t);
		close();
		return t;
	}

	@Override
	public void delete(Usuario t) {
		session.delete(t);
		close();
	}

	public void close() {
		SessionFactory sessionFactory = session.getSessionFactory();
		session.flush();
		session.close();
		this.setSession(sessionFactory.openSession());
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		UsuarioDaoImpl.session = session;
	}
}
