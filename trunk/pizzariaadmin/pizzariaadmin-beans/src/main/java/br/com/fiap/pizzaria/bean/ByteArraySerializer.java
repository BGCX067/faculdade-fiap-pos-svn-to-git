package br.com.fiap.pizzaria.bean;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class ByteArraySerializer extends JsonSerializer<byte[]> {

	@Override
	public void serialize(byte[] bytes, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		byte[] encodeBase64 = Base64.encodeBase64(bytes);
		jgen.writeString(new String(encodeBase64));
	}

}
