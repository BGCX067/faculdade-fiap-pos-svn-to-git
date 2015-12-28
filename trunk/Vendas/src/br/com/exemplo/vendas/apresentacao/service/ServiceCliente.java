package br.com.exemplo.vendas.apresentacao.service ;

import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceCliente
{
	public Boolean inserir( ClienteVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ClienteVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirCliente( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<ClienteVO> listar( ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).findCliente( requestDTO ) ;
		List<ClienteVO> lista = null;
		if(responseDTO.getAllAttributes().size() > 0){
			ClienteVO[ ] clientes = ( ClienteVO[ ] ) responseDTO.get( "listaCliente" ) ;
			lista = Arrays.asList( clientes ) ;
		}
		return lista ;
	}

	public Boolean alterar( ClienteVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ClienteVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarCliente( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( ClienteVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "ClienteVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirCliente( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
	
	public ClienteVO[] selecionarClientesComCompra() throws LayerException{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selecionarClientesComCompra( requestDTO ) ;
		ClienteVO[ ] clientes = null;
		if(responseDTO.getAllAttributes().size() > 0){
			clientes = ( ClienteVO[ ] ) responseDTO.get( "listaCliente" ) ;
		}
		return clientes;
	}
}