package br.com.fiap.relatorio.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@RequestMapping("/fileUploadForm")
	public ModelAndView getUploadForm(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		return new ModelAndView("/relatorio/upload");
	}

	@SuppressWarnings("resource")
	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = uploadedFile.getFile();

		String fileName = file.getOriginalFilename();
		String pathTmp = null;

		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}

		try {
			inputStream = file.getInputStream();
			pathTmp = createFolder();

			File newFile = new File(pathTmp + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<File> listaFiles = getFiles(pathTmp);

		return new ModelAndView("/relatorio/showFile", "message", fileName).addObject("listFiles", listaFiles);
	}
	


	private List<File> getFiles(String pathTmp) {
		File file = new File(pathTmp);
		
		return Arrays.asList(file.listFiles());
	}

	private String createFolder() {
		String pathTmp = System.getProperty("java.io.tmpdir") + "xmls/";
		File fileTmp = new File(pathTmp);
		if(!fileTmp.exists()){
			fileTmp.mkdir();
		}
		return pathTmp;
	}

}
