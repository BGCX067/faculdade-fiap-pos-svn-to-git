/**
 * ConverterBeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.converter;

public interface ConverterBeanService extends javax.xml.rpc.Service {
    public java.lang.String getConverterBeanPortAddress();

    public br.com.fiap.converter.ConverterBean getConverterBeanPort() throws javax.xml.rpc.ServiceException;

    public br.com.fiap.converter.ConverterBean getConverterBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
