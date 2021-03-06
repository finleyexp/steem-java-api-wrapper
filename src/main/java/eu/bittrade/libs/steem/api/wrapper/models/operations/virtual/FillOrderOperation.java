package eu.bittrade.libs.steem.api.wrapper.models.operations.virtual;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.models.operations.Operation;

/**
 * This class represents a Steem "fill_order_operation" object.
 * 
 * This operation type occurs if a order has been closed completely or if a part
 * of the order has been closed.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class FillOrderOperation extends Operation {
    @JsonProperty("current_owner")
    private AccountName currentOwner;
    @JsonProperty("current_orderid")
    // Original type is uint32_t here so we have to use long.
    private int currentOrderId;
    @JsonProperty("current_pays")
    private Asset currentPays;
    @JsonProperty("open_owner")
    private AccountName openOwner;
    @JsonProperty("open_orderid")
    // Original type is uint32_t here so we have to use long.
    private long openOrderId;
    @JsonProperty("open_pays")
    private Asset openPays;

    /**
     * 
     * @return
     */
    public AccountName getCurrentOwner() {
        return currentOwner;
    }

    /**
     * 
     * @return
     */
    public int getCurrentOrderId() {
        return currentOrderId;
    }

    /**
     * 
     * @return
     */
    public Asset getCurrentPays() {
        return currentPays;
    }

    /**
     * 
     * @return
     */
    public AccountName getOpenOwner() {
        return openOwner;
    }

    /**
     * 
     * @return
     */
    public long getOpenOrderId() {
        return openOrderId;
    }

    /**
     * 
     * @return
     */
    public Asset getOpenPays() {
        return openPays;
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
