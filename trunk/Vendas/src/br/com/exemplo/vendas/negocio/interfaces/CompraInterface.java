package br.com.exemplo.vendas.negocio.interfaces ;

public interface CompraInterface
{
	public br.com.exemplo.vendas.util.dto.ServiceDTO inserirCompra(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO alterarCompra(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO excluirCompra(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO selecionarTodasCompras(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO getCompra(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO)
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
	public br.com.exemplo.vendas.util.dto.ServiceDTO listarValorEntre(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO)
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
	public br.com.exemplo.vendas.util.dto.ServiceDTO listarComprasComReserva(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO)
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
}

