package br.com.fiap.aop.aspectj.regras;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.InstanceAlreadyExistsException;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAuditoria {
	
	Logger log = Logger.getLogger(LogAuditoria.class);
	private long horarioInicial;
	private long horarioFinal;
	
	@Before("execution(* br.com.fiap.atividade.dao..*(..))")
	public void logBefore(JoinPoint joinPoint){
		 horarioInicial = new Date().getTime();
		 log.info("Horario Inicio:"+ impressaoHorario(this.horarioInicial) +"	Metodo: "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* br.com.fiap.atividade.dao..*(..))")
	public void logAfter(JoinPoint joinPoint){
		horarioFinal = new Date().getTime();
		log.info("Horario Final:"+ impressaoHorario(this.horarioFinal) +"	Metodo: "+joinPoint.getSignature().getName() );
	}
	
	@AfterThrowing(pointcut = "execution(*  br.com.fiap.atividade..*(..) )",  throwing = "ex")
	public void exception(JoinPoint joinPoint,Throwable ex){
		if(ex instanceof SQLException ){
			log.error(String.format("Erro no Banco de Dados: %s", ex.getMessage()));
		}
	}
	
	private String impressaoHorario(Long horario){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss.S");
		return simpleDateFormat.format(new Date(horario));
	}


}
