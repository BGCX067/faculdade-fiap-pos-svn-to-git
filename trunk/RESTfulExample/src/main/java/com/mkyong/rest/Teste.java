package com.mkyong.rest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    Client client = Client.create();
	    WebResource resource = client.resource("http://localhost:9090/upload/rest/file/upload");
	    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
	    File file1 = new File("arquivo1.pdf"); 	
	    File file2 = new File("arquivo2.pdf");
	    
	    FileDataBodyPart fileDataBodyPart1 = new  FileDataBodyPart("file",file1, MediaType.APPLICATION_OCTET_STREAM_TYPE);
	    FileDataBodyPart fileDataBodyPart2 = new  FileDataBodyPart("file",file2);

	    formDataMultiPart.field("nome", "Barbero");
	    formDataMultiPart.field("telefone", "1231231231");
	    formDataMultiPart.bodyPart(fileDataBodyPart1);
	    formDataMultiPart.bodyPart(fileDataBodyPart2);
	   
	    
	    String post = resource.type(MediaType.MULTIPART_FORM_DATA)
        .accept(MediaType.MULTIPART_FORM_DATA)
        .post(String.class, formDataMultiPart);
	    
	    System.out.println(post);
	    client.destroy();
	    
	    
	}

}
