package br.com.fiap.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.ws.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer {

	public long divide(long x, long y) {
		return (y >= 0) ? x / y : 0;
	}

	public long multiplica(long x, long y) {
		return x * y;
	}

	public long soma(long x, long y) {
		return x + y;
	}

	public long subtrai(long x, long y) {
		return x - y;
	}

}
