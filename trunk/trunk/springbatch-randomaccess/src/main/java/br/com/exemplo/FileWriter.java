package br.com.exemplo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class FileWriter implements ItemWriter<Guia> {

	
	
	public void write(List<? extends Guia> args) throws Exception {
		for (Guia guia : args) {
			System.out.println(guia.toString());
		}

	}

}
