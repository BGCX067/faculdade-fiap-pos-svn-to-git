package br.com.fiap.aop.aspectj.regras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import br.com.fiap.atividade.bean.Pedido;

@Aspect
public class LogVendasDiarias {

	Logger log = Logger.getLogger("vendas");

	@AfterReturning(pointcut = "execution ( * br.com.fiap.atividade.dao.EstoqueDaoImpl.salvarCompras(..))", returning = "obj")
	public void vendasDiarias(Object obj) {
		try {
			if (obj instanceof List<?>) {
				ArrayList<Pedido> lista = (ArrayList<Pedido>) obj;
				Integer quantidate = lista.size();
				Double double1 = 0.0;
				for (Pedido pedido : lista) {
					double1 += pedido.getValorUnitario();
				}
				gravarLog(quantidate, double1);
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	private void gravarLog(Integer quantidade, Double valor) throws IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss.S");
		DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
		File file = new File("vendasDiarias.log");

		FileWriter fileWritter = new FileWriter(file.getName(), true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write(String.format(
				"Data: %s Vendas Diarias: quantidade %s, Valores Totais %s",
				simpleDateFormat.format(new Date()), quantidade,
				decimalFormat.format(valor)));
		bufferWritter.write(System.getProperty("line.separator"));
		bufferWritter.close();
	}

}
