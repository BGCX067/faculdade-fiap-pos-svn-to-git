package br.com.fiap.javaweb.provaonline.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.fiap.javaweb.provaonline.bean.Usuario;

public class UsuarioDaoImpl {
	
	
private Session  session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public Usuario validaUsuario(Usuario us){
		Query query = this.session.createQuery("from Usuario u where u.email = :email and u.senha = :senha");
		query.setParameter("email", us.getEmail());
		query.setParameter("senha", us.getSenha());
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.list();
		Usuario usuario = null;
		if(lista != null && lista.size() >0){
			usuario = lista.get(0);
		}
	  return usuario;
	}

}
