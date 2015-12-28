package br.com.fiap.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.math.util.MathUtils;

@WebService
public class OperacaoesImpl implements Operacoes {

	@WebMethod
	@Override
	public long calcularFatorial(int numero) {
		return MathUtils.factorial(numero);
	}


}
