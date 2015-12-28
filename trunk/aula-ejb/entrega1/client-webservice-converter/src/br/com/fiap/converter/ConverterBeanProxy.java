package br.com.fiap.converter;

public class ConverterBeanProxy implements br.com.fiap.converter.ConverterBean {
  private String _endpoint = null;
  private br.com.fiap.converter.ConverterBean converterBean = null;
  
  public ConverterBeanProxy() {
    _initConverterBeanProxy();
  }
  
  public ConverterBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initConverterBeanProxy();
  }
  
  private void _initConverterBeanProxy() {
    try {
      converterBean = (new br.com.fiap.converter.ConverterBeanServiceLocator()).getConverterBeanPort();
      if (converterBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)converterBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)converterBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (converterBean != null)
      ((javax.xml.rpc.Stub)converterBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.converter.ConverterBean getConverterBean() {
    if (converterBean == null)
      _initConverterBeanProxy();
    return converterBean;
  }
  
  public double fahrenheitToCelsisus(float arg0) throws java.rmi.RemoteException{
    if (converterBean == null)
      _initConverterBeanProxy();
    return converterBean.fahrenheitToCelsisus(arg0);
  }
  
  public double celsisusToFahrenheit(float arg0) throws java.rmi.RemoteException{
    if (converterBean == null)
      _initConverterBeanProxy();
    return converterBean.celsisusToFahrenheit(arg0);
  }
  
  
}