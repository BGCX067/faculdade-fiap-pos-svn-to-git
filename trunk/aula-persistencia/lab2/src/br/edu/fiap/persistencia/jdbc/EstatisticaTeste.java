package br.edu.fiap.persistencia.jdbc;

import java.util.List;

public class EstatisticaTeste {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EstatisticaNegocio negocio = new EstatisticaNegocio();
		negocio.apagarTodasQuestoes();
		negocio.criarQuestao();
		negocio.obterTodosQuestionarios();
		
		List<String> obterRespostas = negocio.obterRespostas(12);
		
		for (String resposta : obterRespostas) {
			System.out.println(resposta);
		}

	}

}
