package br.com.fiap;

public class CarrinhoBeanProxy implements br.com.fiap.CarrinhoBean {
  private String _endpoint = null;
  private br.com.fiap.CarrinhoBean carrinhoBean = null;
  
  public CarrinhoBeanProxy() {
    _initCarrinhoBeanProxy();
  }
  
  public CarrinhoBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initCarrinhoBeanProxy();
  }
  
  private void _initCarrinhoBeanProxy() {
    try {
      carrinhoBean = (new br.com.fiap.CarrinhoBeanServiceLocator()).getCarrinhoBeanPort();
      if (carrinhoBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)carrinhoBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)carrinhoBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (carrinhoBean != null)
      ((javax.xml.rpc.Stub)carrinhoBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.CarrinhoBean getCarrinhoBean() {
    if (carrinhoBean == null)
      _initCarrinhoBeanProxy();
    return carrinhoBean;
  }
  
  public br.com.fiap.Item[] obterMedicamentos() throws java.rmi.RemoteException{
    if (carrinhoBean == null)
      _initCarrinhoBeanProxy();
    return carrinhoBean.obterMedicamentos();
  }
  
  public void cadastrarItem(br.com.fiap.Item arg0) throws java.rmi.RemoteException{
    if (carrinhoBean == null)
      _initCarrinhoBeanProxy();
    carrinhoBean.cadastrarItem(arg0);
  }
  
  public void removerCadastro(int arg0) throws java.rmi.RemoteException{
    if (carrinhoBean == null)
      _initCarrinhoBeanProxy();
    carrinhoBean.removerCadastro(arg0);
  }
  
  public int obterQuantidadeItens() throws java.rmi.RemoteException{
    if (carrinhoBean == null)
      _initCarrinhoBeanProxy();
    return carrinhoBean.obterQuantidadeItens();
  }
  
  
}