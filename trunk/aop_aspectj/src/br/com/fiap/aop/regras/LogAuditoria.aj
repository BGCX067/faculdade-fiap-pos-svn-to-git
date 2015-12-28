package br.com.fiap.aop.regras;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public aspect LogAuditoria {
	
	Logger log = Logger.getLogger(LogAuditoria.class);
	Long horarioInicial = null;
	Long horarioFinal = null;
	
	pointcut logTrace() : call ( public * br.com.fiap.atividade.dao..*(..));
	
	before() : logTrace() {
		 DOMConfigurator.configure("log4j.xml");
		 horarioInicial = new Date().getTime();
		 
		 log.info("Horario Inicio:"+ impressaoHorario(this.horarioInicial) +"	Metodo: "+thisJoinPoint.getSignature().getName());
	}
	
	after()  : logTrace() {
		horarioFinal = new Date().getTime();
		 log.info("Horario Final:"+ impressaoHorario(this.horarioFinal) +"	Metodo: "+thisJoinPoint.getSignature().getName() );
		
	}
	
	
	private String impressaoHorario(Long horario){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss.S");
		return simpleDateFormat.format(new Date(horario));
	}
	
	after() throwing(SQLException ex) : logTrace() {
		log.error(String.format("Erro no Banco de Dados: %s", ex.getMessage()));
	}
	

}
