package br.edu.fiap.persistencia.jdbc;

import java.util.List;

public class EstatisticaNegocio {

	public void obterTodosQuestionarios() throws Exception {
		List<String> list;
		EstatisticaDAO estatisticaDAO = new EstatisticaDAO();
		list = estatisticaDAO.obterTodasQuestoes();
		for (int i = 0; i < list.size(); i++) {
			String questao = list.get(i);
			System.out.println(questao);
		}
	}

	public void criarQuestao() throws Exception {
		EstatisticaDAO estatisticaDAO = new EstatisticaDAO();
		String[] respostas = { "MySQL", "PostgreSQL", "Oracle" };
		estatisticaDAO.criarQuestao("Qual é o BD mais popular atualmente ?", respostas);
	}

	public void apagarTodasQuestoes() throws Exception {
		EstatisticaDAO estatisticaDAO = new EstatisticaDAO();
		estatisticaDAO.apagarTodasQuestoes();
	}
	
	
	public List<String> obterRespostas(int idQuestao) throws Exception{
		EstatisticaDAO estatisticaDAO = new EstatisticaDAO();
		return estatisticaDAO.obterRespostas(idQuestao);
	}

}
