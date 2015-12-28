package br.com.churchsolutions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.churchsolutions.dao.VisitanteDaoImpl;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@Autowired
	private VisitanteDaoImpl visitanteDaoImpl;

	@RequestMapping(value="/iniciar",method = RequestMethod.GET)
	public String init(ModelMap model) {
		return "hello";
	}
	
	@RequestMapping(value="/salvar",method = RequestMethod.POST)
	public String salvar(ModelMap model) {
		System.out.println("chamou");
		return "hello";
	}

}
