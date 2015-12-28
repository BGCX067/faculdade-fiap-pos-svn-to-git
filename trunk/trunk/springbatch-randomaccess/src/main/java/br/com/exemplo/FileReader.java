package br.com.exemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class FileReader implements ItemReader<Guia> {


	private Log logger = LogFactory.getLog(FileReader.class);
	
	private static final String TIPO_GUIA = "1;1";
	private static final String TIPO_PROCEDIMENTO = "1;2";
	private static final String TIPO_PACOTE = "1;3";
	long ultimaPosicaoLidaNoArquivo;
	RandomAccessFile arquivoCsvEmModoLeitura = null;
	boolean isIniciouALeitura = false;
	
	public FileReader() {
		try {
			arquivoCsvEmModoLeitura = new RandomAccessFile(new File("CONTAS-0000.TXT"), "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/***
	 * O metodo read precisa ter uma logica de separar as linhas e
	 * procedimentos. Essa separacao tem que levar em conta que precisamos
	 * separar as linhas de guias, procedimentos e detalhes dos procedimentos.
	 * Para que isso funcione precisamos ler o arquivo e separar guia a guia.
	 * Guardando qual a posicao que encontra-se o arquivo para que o proximo
	 * reader possa continuar procurando guia a partir do ponto onde a leitura
	 * parou no arquivo.
	 */
	public Guia read() throws Exception, UnexpectedInputException,	ParseException, NonTransientResourceException {
		logger.info("Lendo posicao "+ultimaPosicaoLidaNoArquivo);
		// Quando a variavel isIniciouALeitura == false
		// significa que a leitura do arquivo precisa ser reposicionada
		// isto ocorre porque o arquivo ja iniciou a leitura
		if (isIniciouALeitura) {
			arquivoCsvEmModoLeitura.seek(ultimaPosicaoLidaNoArquivo);
		}

		Guia guia = null;
		boolean iniciarLeitura = true;
		boolean guiaNaoEncontrada = true;

		iteracaoLeituraArquivo: while (iniciarLeitura) {

			String line = arquivoCsvEmModoLeitura.readLine();

			// Verifica se a linha e do tipo guia
			if (line != null && line.startsWith(TIPO_GUIA)) {

				// Quando a guia encontrada for igual a false significa que
				// a guia foi encontrada no arquivo e precisa parar a iteracao
				// isto porque ja estamos na guia posterior
				if (guiaNaoEncontrada == false) {
					break iteracaoLeituraArquivo;
				}

				if (guiaNaoEncontrada) {
					guia = new Guia();
					guia.setLinha(line);
					guia.setProcedimentos(new ArrayList<Procedimentos>());
					guiaNaoEncontrada = false;
					//NOVO
					ultimaPosicaoLidaNoArquivo = arquivoCsvEmModoLeitura.getFilePointer();
					isIniciouALeitura = true;
				}

			}
			// ENTRA NO ELSE IF QUANDO A LINHA FOR PROCEDIMENTO DA GUIA
			//NOVO
			else if (line != null && (line.startsWith(TIPO_PROCEDIMENTO) ||  line.startsWith(TIPO_PACOTE) )) {
				Procedimentos procedimentos = null;

				// QUANDO o TIPO DA LINHA FOR PROCEDIMENTO
				if (line.startsWith(TIPO_PROCEDIMENTO)) {
					procedimentos = new Procedimentos();
					procedimentos.setProcedimento(line);
					guia.getProcedimentos().add(procedimentos);
					procedimentos.setDetalhes(new ArrayList<String>());

				}
				// CAI NO ELSE QUANDO FOR DETALHES DOS PROCEDIMENTOS
				else {
					// pega o ultimo elemento dos detalhes do procedimento e
					// adiciona mais um elemente.
					guia.getProcedimentos().get(guia.getProcedimentos().size() - 1).getDetalhes().add(line);
				}

				// ultima posicao valida no arquivo
				ultimaPosicaoLidaNoArquivo = arquivoCsvEmModoLeitura.getFilePointer();
			//NOVO
			}else{
				// ultima posicao valida no arquivo
				ultimaPosicaoLidaNoArquivo = arquivoCsvEmModoLeitura.getFilePointer();
				isIniciouALeitura = true;
				
			}

			// Terminou de ler o arquivo
			if (line == null) {
				break iteracaoLeituraArquivo;
			}

		}

		isIniciouALeitura = true;
		return guia;
	}

}
