package br.com.fiap.relatorio.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public ModelAndView gerarRelatorio (@RequestParam(value="fileName") String fileName, ModelAndView modelAndView) throws JRException{
		File datasource = new File(System.getProperty("java.io.tmpdir") + "xmls/"+fileName);
		
		JRDataSource jrDataSource = new JRXmlDataSource(datasource, "/report/data");

		
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("dataSourceCliente", jrDataSource);

		 
		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("multiFormatView", parameterMap);
		return modelAndView;
	}

}
