/**
 * ConverterBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.converter;

public class ConverterBeanServiceLocator extends org.apache.axis.client.Service implements br.com.fiap.converter.ConverterBeanService {

    public ConverterBeanServiceLocator() {
    }


    public ConverterBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConverterBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConverterBeanPort
    private java.lang.String ConverterBeanPort_address = "http://localhost:8080/ConversorTemperatura/ConverterBean";

    public java.lang.String getConverterBeanPortAddress() {
        return ConverterBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConverterBeanPortWSDDServiceName = "ConverterBeanPort";

    public java.lang.String getConverterBeanPortWSDDServiceName() {
        return ConverterBeanPortWSDDServiceName;
    }

    public void setConverterBeanPortWSDDServiceName(java.lang.String name) {
        ConverterBeanPortWSDDServiceName = name;
    }

    public br.com.fiap.converter.ConverterBean getConverterBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConverterBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConverterBeanPort(endpoint);
    }

    public br.com.fiap.converter.ConverterBean getConverterBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.converter.ConverterBeanServiceSoapBindingStub _stub = new br.com.fiap.converter.ConverterBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getConverterBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConverterBeanPortEndpointAddress(java.lang.String address) {
        ConverterBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.converter.ConverterBean.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.converter.ConverterBeanServiceSoapBindingStub _stub = new br.com.fiap.converter.ConverterBeanServiceSoapBindingStub(new java.net.URL(ConverterBeanPort_address), this);
                _stub.setPortName(getConverterBeanPortWSDDServiceName());
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
        if ("ConverterBeanPort".equals(inputPortName)) {
            return getConverterBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://converter.fiap.com.br/", "ConverterBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://converter.fiap.com.br/", "ConverterBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConverterBeanPort".equals(portName)) {
            setConverterBeanPortEndpointAddress(address);
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
