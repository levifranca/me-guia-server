package edu.metrocamp.meguia.api.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TipoUsuarioSerializer extends JsonSerializer<TipoUsuario> {

	@Override
	public void serialize(TipoUsuario value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		if (value.getId() == null) {
			gen.writeNull();
		} else {
			gen.writeNumber(value.getId());
		}
	}

}
