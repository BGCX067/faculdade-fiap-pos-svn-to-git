/**
 * CarrinhoBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap;

public interface CarrinhoBean extends java.rmi.Remote {
    public br.com.fiap.Item[] obterMedicamentos() throws java.rmi.RemoteException;
    public void cadastrarItem(br.com.fiap.Item arg0) throws java.rmi.RemoteException;
    public void removerCadastro(int arg0) throws java.rmi.RemoteException;
    public int obterQuantidadeItens() throws java.rmi.RemoteException;
}
