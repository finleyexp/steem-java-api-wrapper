package eu.bittrade.libs.steem.api.wrapper.models.serializer;

import java.io.IOException;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import eu.bittrade.libs.steem.api.wrapper.models.Asset;

/**
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class AssetSerializer extends JsonSerializer<Asset> {

    @Override
    public void serialize(Asset asset, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        String amountFormat = "%." + (int)asset.getPrecision() + "f";
        jsonGenerator.writeString(String.format(Locale.US, amountFormat, asset.getAmount()) + " " + asset.getSymbol().toString().toUpperCase());
    }
}
