package br.com.fiap.converter.teste;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.fiap.converter.ConverterBean;
import br.com.fiap.converter.ConverterBeanService;
import br.com.fiap.converter.ConverterBeanServiceLocator;

public class Client {
	
	public static void main(String[] args) throws ServiceException, RemoteException {
		ConverterBeanService converterBeanService = new ConverterBeanServiceLocator();
		ConverterBean converterBeanPort = converterBeanService.getConverterBeanPort();
		double fahrenheitToCelsisus = converterBeanPort.fahrenheitToCelsisus(10f);
		System.out.println("fahrenheitToCelsisus : "+ fahrenheitToCelsisus);
		double celsisusToFahrenheit = converterBeanPort.celsisusToFahrenheit((float) fahrenheitToCelsisus);
		System.out.println("celsisusToFahrenheit : "+ celsisusToFahrenheit);
		
	}

}
