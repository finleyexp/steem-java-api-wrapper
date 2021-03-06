package eu.bittrade.libs.steem.api.wrapper.models.operations.virtual;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.models.operations.Operation;

/**
 * This class represents a Steem "fill_convert_request_operation" object.
 * 
 * This operation type occurs if a "Convert to Steem" request has been fulfilled
 * by the blockchain.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class FillConvertRequestOperation extends Operation {
    @JsonProperty("owner")
    private AccountName owner;
    // Original type is uint32_t so we have to use long here.
    @JsonProperty("requestid")
    private long requestId;
    @JsonProperty("amount_in")
    private Asset amountIn;
    @JsonProperty("amount_out")
    private Asset amountOut;

    /**
     * Get the owner of this conversion request.
     * 
     * @return The owner as an AccountName instance.
     */
    public AccountName getOwner() {
        return owner;
    }

    /**
     * Get the id of this request.
     * 
     * @return The id of this request.
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * Get the amount and the type of the currency that has been converted
     * within this operation.
     * 
     * @return The source asset.
     */
    public Asset getAmountIn() {
        return amountIn;
    }

    /**
     * Get the amount and the type of the target currency.
     * 
     * @return The target asset.
     */
    public Asset getAmountOut() {
        return amountOut;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        // The byte representation is not needed for virtual operations as we
        // can't broadcast them.
        return new byte[0];
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
