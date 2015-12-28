package br.com.fiap.pizzaria.web.controller.pizza;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.fiap.pizzaria.bean.Imagem;

@Controller
@RequestMapping("image")
public class UploadController {
	

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public @ResponseBody Imagem upload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		Imagem imagem =  new Imagem();
		imagem.setImagem(multipartFile.getBytes());
		imagem.setNome(multipartFile.getOriginalFilename());
		return imagem;
	}

}
