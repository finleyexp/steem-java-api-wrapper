package eu.bittrade.libs.steem.api.wrapper.models.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class BooleanSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean boolValue, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeString(boolValue.toString());

    }
}
