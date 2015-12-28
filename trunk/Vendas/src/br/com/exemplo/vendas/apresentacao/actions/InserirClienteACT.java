package br.com.exemplo.vendas.apresentacao.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.vendas.apresentacao.service.ServiceCliente;
import br.com.exemplo.vendas.apresentacao.web.Action;
import br.com.exemplo.vendas.negocio.model.vo.ClienteFisicoVO;
import br.com.exemplo.vendas.negocio.model.vo.ClienteJuridicoVO;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.exception.LayerException;

@SuppressWarnings("unused")
public class InserirClienteACT implements Action
{
	public String execute( HttpServletRequest request, HttpServletResponse response )
			throws LayerException
	{
		ServiceCliente serviceCliente = new ServiceCliente();
		String nome = request.getParameter( "nome" );
		String endereco = request.getParameter( "endereco" );
		String telefone = request.getParameter( "telefone" );
		String situacao = request.getParameter( "situacao" );
		
		String cpf = request.getParameter( "cpf" );
		String cnpj = request.getParameter( "cnpj" );
		String ie = request.getParameter( "ie" );

		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setNome(nome);
		clienteVO.setEndereco(endereco);
		clienteVO.setTelefone(telefone);
		clienteVO.setSituacao(situacao);
		Boolean sucesso = null;
		if(cpf != null && !cpf.equals("")){
			ClienteFisicoVO clienteFisico = new  ClienteFisicoVO(clienteVO);
			clienteFisico.setCpf(cpf);
			sucesso = serviceCliente.inserir( clienteFisico );
		}else{
			ClienteJuridicoVO clientejuridico = new ClienteJuridicoVO(clienteVO);
			clientejuridico.setCnpj(cnpj);
			clientejuridico.setIe(ie);
			sucesso = serviceCliente.inserir( clientejuridico );
		}

		if (sucesso.booleanValue( ))
		{
			request.setAttribute( "sucesso", sucesso ) ;
		}
		return "index.html" ;
	}
}
