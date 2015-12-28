package br.com.fiap.javaweb.provaonline.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.javaweb.provaonline.bean.Pessoa;
import br.com.fiap.javaweb.provaonline.bean.TipoUsuario;
import br.com.fiap.javaweb.provaonline.bean.Usuario;
import br.com.fiap.javaweb.provaonline.dao.PessoaDaoImpl;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/CadastrarUsuario")
public class CadastrarUsuarioServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDaoImpl pessoaDaoImpl;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setSobrenome(request.getParameter("sobrenome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(sha.encodePassword(request.getParameter("password"), "256"));
		usuario.setTipoUsuario(request.getParameter("tipoAluno").equals("ALUNO") ?  TipoUsuario.ALUNO : TipoUsuario.ADMIN);
		pessoa.setUsuario(usuario);
		pessoaDaoImpl.save(pessoa);
		response.sendRedirect("usuarioCadastradoComSucesso.jsp");
		
	}

}
