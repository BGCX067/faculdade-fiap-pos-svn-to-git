package br.com.fiap.javaweb.provaonline.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import br.com.fiap.javaweb.provaonline.bean.TipoUsuario;
import br.com.fiap.javaweb.provaonline.bean.Usuario;
import br.com.fiap.javaweb.provaonline.dao.UsuarioDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDaoImpl usuarioDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("username"));
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		usuario.setSenha(sha.encodePassword(request.getParameter("password"), "256"));
		Usuario usuarioValidado = usuarioDaoImpl.validaUsuario(usuario);
		if(usuarioValidado != null && usuarioValidado.getTipoUsuario().getDescricao().equals(TipoUsuario.ALUNO.getDescricao())){
			request.getSession().setAttribute("userSession", usuarioValidado);
			response.sendRedirect("paginas/prova");
		}else if(usuarioValidado != null){
			request.getSession().setAttribute("userSession", usuarioValidado);
			request.getRequestDispatcher("/paginas/menuAdmin.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("index.jsp?e=true").forward(request, response);
		}
	}

}
