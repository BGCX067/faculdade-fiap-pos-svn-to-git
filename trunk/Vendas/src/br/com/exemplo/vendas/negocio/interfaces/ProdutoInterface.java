package br.com.exemplo.vendas.negocio.interfaces ;


public interface ProdutoInterface
{
	public br.com.exemplo.vendas.util.dto.ServiceDTO inserirProduto(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO alterarProduto(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO excluirProduto(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO selecionarTodosProduto(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;

	public br.com.exemplo.vendas.util.dto.ServiceDTO getProduto(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO, Integer codigo )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
	public br.com.exemplo.vendas.util.dto.ServiceDTO listarPorPrecoEstoque(
			br.com.exemplo.vendas.util.dto.ServiceDTO requestDTO )
			throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException ;
	
}
