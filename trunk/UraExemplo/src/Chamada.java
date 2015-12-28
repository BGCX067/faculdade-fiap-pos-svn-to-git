import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.jersey.api.client.UniformInterfaceException;

import br.com.sulamerica.susis.ura.bean.Imagem;
import br.com.sulamerica.susis.ura.bean.UraFax;
import br.com.sulamerica.susis.ura.client.UraServiceClient;
import br.com.sulamerica.susis.ura.client.UraServiceClientImpl;
import br.com.sulamerica.susis.ura.util.UtilConverterImagem;


public class Chamada {

	public static void main(String[] args) throws IOException {
		
		File imagemTiff = new File("89643_1.tif");
		UtilConverterImagem converterImagem = new UtilConverterImagem();
		String imagemByteBase64 = converterImagem.convertFileToByte(imagemTiff);
		
		File imagemTiff2 = new File("89643_2.tif");
		String imagemByteBase642 = converterImagem.convertFileToByte(imagemTiff2);

		UraFax uraFax = new UraFax();
		
		Imagem img1 = new Imagem();
		img1.setFileName(imagemTiff.getName());
		img1.setImagem(imagemByteBase64);
		
		Imagem img2 = new Imagem();
		img2.setFileName(imagemTiff2.getName());
		img2.setImagem(imagemByteBase642);
		
		List<Imagem> list = new ArrayList<Imagem>();
		list.add(img1);
		list.add(img2);
		uraFax.setImagem(list);
		uraFax.setIn_nMatr("93918939180010");
		uraFax.setIn_nRdp("1");
		uraFax.setIn_nDv("6");
		uraFax.setIn_fldNome("AMARO JOSE DE CARVALHO MANHAES");
		uraFax.setIn_fldCpf("4032364");
		uraFax.setIn_fldLog("ESTRADA DOS BANDEIRANTES 12430");
		uraFax.setIn_fldBairro("VARGEM PEQUENA");
		uraFax.setIn_fldCidade("RIO DE JANEIRO");
		uraFax.setIn_fldUF("RJ");
		uraFax.setIn_fldCEP("22783550");
		uraFax.setIn_fldDDDT("0");
		uraFax.setIn_fldTel("0");
		uraFax.setIn_fldFax("12122698999");
		uraFax.setIn_fldEmail("carlos.barbero@gmail.com");
		uraFax.setIn_fldSexo("M");
		uraFax.setIn_fldAsnN1(new Integer(0));
		uraFax.setIn_fldAsnN2(new Integer(1));
		uraFax.setIn_fldSegurad(new Integer(1));
		uraFax.setIn_fldTpProd("P");
		uraFax.setIn_PrestCnpj("00043752RJM2");
		uraFax.setIn_numOperacao(new Integer(0));
		uraFax.setIn_faxRcbto(new Date());
		uraFax.setIn_faxNoFax("12122698999");
		uraFax.setIn_tpOrigem("U");
		uraFax.setIn_maniTpAP(new Integer(1));
	
		
		String url = "https://saudeh.sulamerica.com.br/uraservices/rest/upload/fax";
		String userName = "100000006624MASTER";
		String password  = "sulame";
		String retorno = null;
			
		for (int i = 0; i < 5000; i++) {
			try{
			System.out.println("Teste "+ i + " Horario: "+ new Date());
			UraServiceClient uraServiceClient = new UraServiceClientImpl(url,
					userName, password);
			retorno = uraServiceClient.uploadImage(uraFax);
			System.out.println(retorno);
			}catch(UniformInterfaceException ex){
				System.out.println("Erro no processo: "+i);
			}
		}
		
		
	}

}
