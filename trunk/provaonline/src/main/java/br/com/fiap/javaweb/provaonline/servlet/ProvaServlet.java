package br.com.fiap.javaweb.provaonline.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.javaweb.provaonline.bean.Alternativa;
import br.com.fiap.javaweb.provaonline.bean.Questoes;
import br.com.fiap.javaweb.provaonline.dao.CategoriaDaoImpl;
import br.com.fiap.javaweb.provaonline.dao.PerguntasDaoImpl;

/**
 * Servlet implementation class CadastrarPerguntasServlet
 */
@WebServlet("/paginas/prova")
public class ProvaServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaDaoImpl categoriaDaoImpl;
	
	@Inject
	private PerguntasDaoImpl perguntasDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Questoes> listaQuestoes = perguntasDaoImpl.listAll();
		request.getSession().setAttribute("questoes", listaQuestoes);
		request.getSession().setAttribute("result", null);
		response.sendRedirect("prova.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Questoes> listaQuestoes = (List<Questoes>)request.getSession().getAttribute("questoes");
		Double qtdCertas = 0D;
		Double qtdQuestoes = Double.valueOf(request.getParameterMap().size());
		for(int j=0;j<qtdQuestoes;j++){
			Questoes q = listaQuestoes.get(j);
			Long resposta = Long.parseLong(request.getParameter("questao"+(j+1)));
			if(getCorreta(q).equals(resposta)){
				qtdCertas++;
			}
		}
		Double result = (qtdCertas/qtdQuestoes);
		result *= 100;
		DecimalFormat df = new DecimalFormat("#,###.00");
		if(result == 0){
			request.getSession().setAttribute("result", 0);
		}else{
			request.getSession().setAttribute("result", df.format(result));
		}
		request.getSession().setAttribute("questoes", null);
		response.sendRedirect("prova.jsp");
	}
	
	public Long getCorreta(Questoes q){
		Long value = null;
		for(Alternativa a:q.getAlternativas()){
			if(a.getCorreta()){
				value = a.getId();
			}
		}
		return value;
	}
}
