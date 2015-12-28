package br.com.fiap.aop.regras;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.util.UtilCalculo;

public aspect RegraDeNegocio {
	
	private Double novoValor = 0d;
	boolean agostoSetembro = false;
	private int diaSemana;
	private Double descontoDomingo = 100d;
	private boolean livroAspecto = false;
	
	pointcut vendaMaiorQue1000() : call( private * br.com.fiap.atividade.service.PedidoService.somar(..));

	
	
	
	after() returning(Double r)  : vendaMaiorQue1000() {
		novoValor = r;
		Double val =  r;
		Object[] objetos = thisJoinPoint.getArgs();
		
		
		for(Object o : objetos){
			if(o instanceof Date){
				Date data = (Date) o;
				Calendar c = Calendar.getInstance();
				c.setTime(data);
				diaSemana = c.get(Calendar.DAY_OF_WEEK);
				if(data.getMonth() == 7 || data.getMonth() == 8){
					agostoSetembro = true;
				}
			}
		}
		
		for(Object o : objetos){
			if(o instanceof List){
				@SuppressWarnings("unchecked")
				List<Pedido> lisPedidos = (List<Pedido>) objetos[0];
				regraDeNegocio(val, lisPedidos);
			}
		}
		
		
		
	}

	private void regraDeNegocio(Double val, List<Pedido> lisPedidos) {
		//Venda maior que R$1000
		if(val > 1000d){
			for (Pedido pedido : lisPedidos) {
				Double valorComDesconto = pedido.getValorUnitario() - UtilCalculo.calcular(pedido.getValorUnitario(), 5.0);
				novoValor += valorComDesconto;
				pedido.setDesconto(valorComDesconto);
			}
			
		}
		//Compras acima de 10 itens.
		else if(lisPedidos.size() > 10){
			Double valor10Itens = 0d;
			for (Pedido pedido : lisPedidos) {
				 valor10Itens += pedido.getValorUnitario();
			}
			
		 novoValor = (valor10Itens - UtilCalculo.calcular(valor10Itens, 5.0d));
		 
		}
		
		if(agostoSetembro){
			novoValor = novoValor + UtilCalculo.calcular(novoValor, 10.0);
		 }
		
		//Livro de aspecto e no domingo.
		for (Pedido pedido : lisPedidos) {
			if(pedido.getDescricao().contains("AspectJ") && diaSemana == 1){
				novoValor = (novoValor - descontoDomingo) ;
				Double tmp = novoValor < 0 ? 0: novoValor;
				novoValor = tmp;
				break;
			}
		}
		
		
	}
	
	Object around() : vendaMaiorQue1000(){
		proceed();
		return new Double(novoValor);
	}
	
	
	
	
	
}
