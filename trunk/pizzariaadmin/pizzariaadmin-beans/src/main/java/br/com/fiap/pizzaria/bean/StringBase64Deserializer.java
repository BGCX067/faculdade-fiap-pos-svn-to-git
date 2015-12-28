package br.com.fiap.pizzaria.bean;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class StringBase64Deserializer extends JsonDeserializer<byte[]> {

	@Override
	public byte[] deserialize(JsonParser jsonParser, DeserializationContext deseriali) throws IOException, JsonProcessingException {
		byte[] decodeBase64 = Base64.decodeBase64(jsonParser.getText());
		return decodeBase64;
	}
	

}
