package br.com.fiap.aop.regras;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.fiap.atividade.dao.LogErroData;

public aspect VerificaData {

	pointcut verificarDataPedido() : execution(public * br.com.fiap.atividade.dao.EstoqueDaoImpl.salvarCompras(..));

	before() : verificarDataPedido(){
		Object[] objetos = thisJoinPoint.getArgs();
		for (Object object : objetos) {
			if(object instanceof Date){
				Date objDate = (Date) object;
				Date date = new Date();
				if(objDate.before(new Date(date.getYear(), date.getMonth(), date.getDay()))){
					LogErroData logErroData = new LogErroData();
					try {
						logErroData.inserirTabelaDeLog("Data do pedido inferior a data do sistema");
						throw new RuntimeException("Erro Log");
					} catch (ClassNotFoundException | SQLException e) {
						throw new RuntimeException("Erro");
					}
				}
			}
		}
		
	}
	
	

}
