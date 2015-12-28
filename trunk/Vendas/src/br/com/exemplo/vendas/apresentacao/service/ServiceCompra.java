package br.com.exemplo.vendas.apresentacao.service ;

import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.entity.Compra;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class ServiceCompra
{
	
	public CompraVO find(CompraVO vo) throws LayerException{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		requestDTO.set("CompraVO", vo);
		responseDTO = BusinessDelegate.getInstance( ).findCompra( requestDTO ) ;
		CompraVO compra = (CompraVO) responseDTO.get( "compra" ) ;
		return compra;
	}
	
	public Boolean inserir( CompraVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "CompraVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).inserirCompra( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public List<CompraVO> listar( ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).selectionarTodasCompras( requestDTO ) ;
		CompraVO[ ] compras = ( CompraVO[ ] ) responseDTO.get( "listaCompra" ) ;
		List<CompraVO> lista = Arrays.asList( compras ) ;
		return lista ;
	}

	public Boolean alterar( CompraVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "CompraVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).alterarCompra( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}

	public Boolean excluir( CompraVO vo ) throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		requestDTO.set( "CompraVO", vo ) ;
		responseDTO = BusinessDelegate.getInstance( ).excluirCompra( requestDTO ) ;
		Boolean sucesso = ( Boolean ) responseDTO.get( "resposta" ) ;

		return sucesso ;
	}
	
	public CompraVO[] listarValorEntre() throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;
		responseDTO = BusinessDelegate.getInstance( ).listarValorEntre( requestDTO ) ;
		CompraVO[ ] compras = ( CompraVO[ ] ) responseDTO.get( "listaCompra" ) ;
		return compras;
	}
	
	public CompraVO[] listarComprasComReserva() throws LayerException
	{
		ServiceDTO requestDTO = new ServiceDTO( ) ;
		ServiceDTO responseDTO = new ServiceDTO( ) ;

		responseDTO = BusinessDelegate.getInstance( ).listarComprasComReserva( requestDTO ) ;
		CompraVO[ ] compras = ( CompraVO[ ] ) responseDTO.get( "listaCompra" ) ;
		return compras;
	}

	
	
}