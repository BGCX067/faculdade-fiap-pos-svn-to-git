package br.com.fiap.atividade.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class UtilFormatter {
	
	public static String converToString(Double d){
		NumberFormat nf = new DecimalFormat ("R$ #,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
		return nf.format(d);
	}

}
