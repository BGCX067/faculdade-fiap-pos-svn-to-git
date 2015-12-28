package br.com.fiap.aop.aspectj.regras;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.util.UtilCalculo;

@Aspect
public class RegraDeNegocio {
	
	
	Logger log = Logger.getLogger(RegraDeNegocio.class);
	private double valorTotal = 0.0d;
	
	@Before("execution( * br.com.fiap.atividade.service.UtilSomar.*(..))")
	public void logService(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		
		for (Object object : args) {
			if(object instanceof List<?>){
				List<Pedido> listaPedido = (List<Pedido>) object;
				for (Pedido pedido : listaPedido) {
					valorTotal += pedido.getValorUnitario();
				}
				maiorque1000(listaPedido);
			}
		}
		
	}

	private void maiorque1000(List<Pedido> listaPedido) {
		if(valorTotal > 1000d){
			for (Pedido pedido : listaPedido) {
				Double valorComDesconto = pedido.getValorUnitario() - UtilCalculo.calcular(pedido.getValorUnitario(), 5.0);
				pedido.setDesconto(valorComDesconto);
			}

		}
	}

	

	
	
	
	
	
	
	
	
	
}
