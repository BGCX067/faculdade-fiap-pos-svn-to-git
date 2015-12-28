package br.com.artigo.restvalidation.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.artigo.restvalidation.bean.Comentario;

@Controller
@RequestMapping(value="comentario")
public class ComentarioController {
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Comentario add(@Valid @RequestBody Comentario comment) {
        return comment;
    }
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Comentario teste() {
		Comentario comment = new Comentario();
		comment.setTexto("Teste");
        return comment;
    }

}
