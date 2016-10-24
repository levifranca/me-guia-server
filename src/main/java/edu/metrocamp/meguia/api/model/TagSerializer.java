package edu.metrocamp.meguia.api.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TagSerializer extends JsonSerializer<Tag> {

	@Override
	public void serialize(Tag value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		if (value.getNome() == null) {
			gen.writeNull();
		} else {
			gen.writeString(value.getNome());
		}
	}

}
