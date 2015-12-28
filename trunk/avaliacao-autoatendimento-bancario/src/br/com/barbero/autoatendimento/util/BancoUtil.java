package br.com.barbero.autoatendimento.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.barbero.autoatendimento.dao.Conexao;


/***
 * Classe com metodos utilitarios
 * @author Carlos Barbero
 *
 */
public class BancoUtil {
	
	
	/***
	 * Metodo responsavel por executar o script de carga no banco de dados.
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public static void cargaInicial() throws FileNotFoundException, SQLException{
		Conexao con = new Conexao();
		Connection conexao = con.getConnection();
		conexao.setAutoCommit(true);
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("create.sql"));
		StringBuilder createSql = new StringBuilder();
		while (sc.hasNext()) {
			createSql.append(sc.next() + " ");
		}
		
		String[] script = createSql.toString().split(";");
		
		for (String sql : script) {
			PreparedStatement pstmt = conexao.prepareStatement(sql.trim());
			pstmt.executeUpdate();
		}
		conexao.close();
	}
	
	
	public static void impressaoNomeBanco(){
		System.out.println("************|-------------|****************");
		System.out.println("************|     BANCO   |****************");
		System.out.println("************|-------------|****************");
		System.out.println("Horário: "+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
	}
	
	/***
	 * Metodo responsavel por retornar o valor formatado para moeda Brasileira.
	 * @param valor {@link BigDecimal}
	 * @return {@link String}
	 */
	public static String getValorFormatado(BigDecimal valor){
		DecimalFormat decimalFormat =  new DecimalFormat("R$ #,###,##0.00");
		return decimalFormat.format(valor);
	}
	
	/***
	 * Metodo responsavel por validar valores negativos para saque e deposito
	 * @param value {@link BigDecimal}
	 * @return {@link Boolean}
	 */
	public static boolean isValidSaqueDeposito(BigDecimal value){
		boolean validacao = false;
		if(value.signum() == -1){
			validacao = false;
		}else{
			validacao = true;
		}
		return validacao;
	}

}
