package com.mkyong.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.jersey.multipart.FormDataParam;

@Path("/file")
public class UploadFileService {

	@POST
	@Path("/upload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile(@Context HttpServletRequest request, @FormDataParam("nome") String nome, @FormDataParam("telefone") String telefone) throws Exception {

		   String fileRepository="/tmp/";
		   if (ServletFileUpload.isMultipartContent(request)) {
		     FileItemFactory factory = new DiskFileItemFactory();
		     ServletFileUpload upload = new ServletFileUpload(factory);
		     
		     List<FileItem> itens = upload.parseRequest(request);
		     
		     System.out.println("@@@@@@@@@@@@@"+nome);
		     System.out.println("%%%%%%%%%%%%"+telefone);
		    
		     
		     int i = 0;
		     for (FileItem fileItem : itens) {
		    	 //Grava os arquivos
				if(!fileItem.isFormField()){
					fileItem.write(new File(fileRepository+fileItem.getName()+ i+".jpg"));
				}
				i++;
			}
		   }
		   
		   
		   
		return Response.status(200).entity("OK").build();

		//return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}