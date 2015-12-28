package br.com.exemplo.vendas.apresentacao.actions;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceReserva;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.entity.Reserva;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.negocio.model.vo.ReservaVO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class InserirReservaACT implements Action {

	@SuppressWarnings("deprecation")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws LayerException {
		
		request.getSession().setAttribute("listaClientes", null);
		
		Date data = new Date(request.getParameter("data"));
		String atendente = request.getParameter("atendente");
		String situacao = request.getParameter("situacao");
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		String clienteRequest = request.getParameter("cliente");

		Cliente cliente = new Cliente();
		Reserva reserva = new Reserva();
		cliente.setId(Integer.parseInt(clienteRequest));
		ClienteVO cli = new ClienteVO();
		cli.setId(cliente.getId());
		cli.setNome(cliente.getNome());
		cli.setEndereco(cliente.getEndereco());
		cli.setTelefone(cliente.getTelefone());
		cli.setSituacao(cliente.getSituacao());
		ReservaVO reservaVO = new ReservaVO(null, data, atendente, situacao,valor, cli);
		ServiceReserva service = new ServiceReserva();
		Boolean sucesso = service.inserir(reservaVO);

		if (sucesso.booleanValue()) {
			return "index.html";
		}else if(!sucesso.booleanValue()){
			return "erro.html";
		}
		return "index.html";
	}
}
