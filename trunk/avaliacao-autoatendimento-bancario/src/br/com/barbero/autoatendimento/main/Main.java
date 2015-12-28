package br.com.barbero.autoatendimento.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import br.com.barbero.autoatendimento.bean.Cliente;

/***
 * Classe que controla os Stacks do programa de auto atendimento.
 * @author Carlos Barbero
 * 
 */
public class Main extends AutoAtendimento {
	
	private static Logger logger = Logger.getLogger(Main.class.getName());

	/***
	 * Metodo responsavel por iniciar o auto atentimento do banco
	 * @param args
	 * @throws {@link SQLException} 
	 * @throws {@link IOException} caso ocorra algum problema com o arquivo.
	 */
	public static void main(String[] args) throws SQLException, IOException {
		FileHandler fileHandler = new FileHandler(Main.class.getName()+".log");
		logger.addHandler(fileHandler);
		logger.info("Inicializou o Auto atendimento");
		Cliente cliente = inicializaAutoAtendimento();
		System.out.println("Bem vindo! " +cliente.getNome());
		processarAutoAtendimento(cliente);
		logger.info("Terminou o programa de  Auto atendimento");
	}

}
