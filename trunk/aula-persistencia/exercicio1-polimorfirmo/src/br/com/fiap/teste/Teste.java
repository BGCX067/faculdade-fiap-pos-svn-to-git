package br.com.fiap.teste;

import br.com.fiap.Impressao;
import br.com.fiap.ImpressaoDoc;
import br.com.fiap.ImpressaoPDF;

/***
 * 
 * @author rm44699
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Impressao impressaoDoc = new ImpressaoDoc();
		Impressao impressaoPdf = new ImpressaoPDF();
		
		imprimir(impressaoDoc);
		imprimir(impressaoPdf);
		
		imprimir(new Impressao() {
			@Override
			public String imprimir() {
				return "Impressao Anônima";
			}
		});

	}
	
	/***
	 * 
	 * @param impressao
	 */
	public static void imprimir(Impressao impressao){
		System.out.println(impressao.imprimir());
	}

}
