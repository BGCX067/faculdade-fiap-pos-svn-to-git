package br.com.controleaereo.managedbeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.controleaereo.bean.Usuario;
import br.com.controleaereo.bo.UsuarioBO;

@ManagedBean(name = "clientes")
public class ClientesManagedBean {
	private String nome;
	private String email;
	private String senha;

	private HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session;
	}

	public String getNome() {
		Usuario u = (Usuario) getSession().getAttribute("userSession");
		if (u != null) {
			return u.getNome();
		}
		if(nome == null){
			nome = "";
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String cadastrar() {
		Mapper mapper = new DozerBeanMapper();
		Usuario destObject = mapper.map(this, Usuario.class);
		try {
			UsuarioBO.getInstance().cadastra(destObject);
		} catch (Exception e) {
			addError("Usuário já existente");
		}
		return "login.jsf";
	}

	public void login(ActionEvent actionEvent) {
		Mapper mapper = new DozerBeanMapper();
		Usuario destObject = mapper.map(this, Usuario.class);
		Usuario u = UsuarioBO.getInstance().find(destObject);
		if (u == null) {
			addError("Usuário ou senha inválidos");
		} else {
			getSession().setAttribute("userSession", u);
			try {
				if ("adm".equals(u.getNivel())) {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("PaginasAdm/menuAdm.jsf");
				} else {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("paginas/menuUsuario.jsf");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String sair() {
		getSession().setAttribute("userSession", null);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("login.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addError(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
	}
}