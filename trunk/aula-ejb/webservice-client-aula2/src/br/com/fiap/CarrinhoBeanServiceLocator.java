/**
 * CarrinhoBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap;

public class CarrinhoBeanServiceLocator extends org.apache.axis.client.Service implements br.com.fiap.CarrinhoBeanService {

    public CarrinhoBeanServiceLocator() {
    }


    public CarrinhoBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CarrinhoBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CarrinhoBeanPort
    private java.lang.String CarrinhoBeanPort_address = "http://localhost:8080/aula2-ejb3/CarrinhoBean";

    public java.lang.String getCarrinhoBeanPortAddress() {
        return CarrinhoBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CarrinhoBeanPortWSDDServiceName = "CarrinhoBeanPort";

    public java.lang.String getCarrinhoBeanPortWSDDServiceName() {
        return CarrinhoBeanPortWSDDServiceName;
    }

    public void setCarrinhoBeanPortWSDDServiceName(java.lang.String name) {
        CarrinhoBeanPortWSDDServiceName = name;
    }

    public br.com.fiap.CarrinhoBean getCarrinhoBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CarrinhoBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCarrinhoBeanPort(endpoint);
    }

    public br.com.fiap.CarrinhoBean getCarrinhoBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.CarrinhoBeanServiceSoapBindingStub _stub = new br.com.fiap.CarrinhoBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCarrinhoBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCarrinhoBeanPortEndpointAddress(java.lang.String address) {
        CarrinhoBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.CarrinhoBean.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.CarrinhoBeanServiceSoapBindingStub _stub = new br.com.fiap.CarrinhoBeanServiceSoapBindingStub(new java.net.URL(CarrinhoBeanPort_address), this);
                _stub.setPortName(getCarrinhoBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CarrinhoBeanPort".equals(inputPortName)) {
            return getCarrinhoBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://fiap.com.br/", "CarrinhoBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://fiap.com.br/", "CarrinhoBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CarrinhoBeanPort".equals(portName)) {
            setCarrinhoBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
