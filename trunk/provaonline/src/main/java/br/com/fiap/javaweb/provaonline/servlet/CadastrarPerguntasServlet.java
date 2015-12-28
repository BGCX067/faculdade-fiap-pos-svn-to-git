package br.com.fiap.javaweb.provaonline.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.javaweb.provaonline.bean.Alternativa;
import br.com.fiap.javaweb.provaonline.bean.Categoria;
import br.com.fiap.javaweb.provaonline.bean.Questoes;
import br.com.fiap.javaweb.provaonline.dao.CategoriaDaoImpl;
import br.com.fiap.javaweb.provaonline.dao.PerguntasDaoImpl;

/**
 * Servlet implementation class CadastrarPerguntasServlet
 */
@WebServlet("/paginas/CadastrarPerguntas")
public class CadastrarPerguntasServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	@Inject
	private PerguntasDaoImpl perguntasDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPerguntasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("operacao") != null){
			if(request.getParameter("operacao").equals("del")){
				Questoes questoes = perguntasDaoImpl.find(Long.parseLong(request.getParameter("id")));
				perguntasDaoImpl.delete(questoes);
			}
		}
		getListCategoria(request);
		request.getRequestDispatcher("cadastrarPerguntas.jsp").forward(request, response);

	}

	private void getListCategoria(HttpServletRequest request) {
		List<Categoria> categoria  = categoriaDaoImpl.listAll();
		request.setAttribute("listaCategoria", categoria);
		List<Questoes> listaQuestoes =  perguntasDaoImpl.listAll();
		request.setAttribute("listaQuestoes", listaQuestoes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getListCategoria(request);
		Questoes questoes = new Questoes();
		questoes.setQuestao(request.getParameter("questao"));
		Categoria categoria = categoriaDaoImpl.find(Long.parseLong(request.getParameter("categoria")));
		Alternativa alternativa1 = new Alternativa();
		alternativa1.setAlternativa(request.getParameter("alternativa1"));
		alternativa1.setCorreta(request.getParameter("correta").equals("correta1") ? true : false);
		Alternativa alternativa2 = new Alternativa();
		alternativa2.setAlternativa(request.getParameter("alternativa2"));
		alternativa2.setCorreta(request.getParameter("correta").equals("correta2") ? true :false);
		Alternativa alternativa3 = new Alternativa();
		alternativa3.setAlternativa(request.getParameter("alternativa3"));
		alternativa3.setCorreta(request.getParameter("correta").equals("correta3") ? true :false);
		
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(alternativa1);
		alternativas.add(alternativa2);
		alternativas.add(alternativa3);
		questoes.setAlternativas(alternativas);
		questoes.setCategoria(categoria.getDescricao());
		perguntasDaoImpl.save(questoes);
		List<Questoes> listaQuestoes =  perguntasDaoImpl.listAll();
		request.setAttribute("listaQuestoes", listaQuestoes);
		request.getRequestDispatcher("cadastrarPerguntas.jsp").forward(request, response);
		
	}

}
