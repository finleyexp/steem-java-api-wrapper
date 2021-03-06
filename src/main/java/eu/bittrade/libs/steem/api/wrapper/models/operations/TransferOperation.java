package eu.bittrade.libs.steem.api.wrapper.models.operations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.enums.OperationType;
import eu.bittrade.libs.steem.api.wrapper.enums.PrivateKeyType;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.util.SteemUtils;

/**
 * This class represents the Steem "transfer_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class TransferOperation extends Operation {
    @JsonProperty("from")
    private AccountName from;
    @JsonProperty("to")
    private AccountName to;
    @JsonProperty("amount")
    private Asset amount;
    @JsonProperty("memo")
    private String memo;

    /**
     * Create a new transfer operation.
     */
    public TransferOperation() {
        // Define the required key type for this operation.
        super(PrivateKeyType.ACTIVE);
    }

    /**
     * Get the user who sends the asset.
     * 
     * @return The user who sends the asset.
     */
    public AccountName getFrom() {
        return from;
    }

    /**
     * Set the user who sends the asset.
     * 
     * @param from
     *            the user who sends the asset.
     */
    public void setFrom(AccountName from) {
        this.from = from;
    }

    /**
     * Get the user who received the transfer.
     * 
     * @return The user who received the transfer.
     */
    public AccountName getTo() {
        return to;
    }

    /**
     * Set the user who will receive the transfer.
     * 
     * @param to
     *            The user who will receive the transfer.
     */
    public void setTo(AccountName to) {
        this.to = to;
    }

    /**
     * Get the amount and the currency that has been transfered.
     * 
     * @return The amount and the currency that has been transfered.
     */
    public Asset getAmount() {
        return amount;
    }

    /**
     * Set the amount and the currency that should be transfered.
     * 
     * @param amount
     *            Set amount and the currency that should be transfered.
     */
    public void setAmount(Asset amount) {
        this.amount = amount;
    }

    /**
     * Get the message of this transfer.
     * 
     * @return The message of this transfer.
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Set a message for this transfer.
     * 
     * @param memo
     *            The message of this transfer.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedTransferOperation = new ByteArrayOutputStream()) {
            serializedTransferOperation
                    .write(SteemUtils.transformIntToVarIntByteArray(OperationType.TRANSFER_OPERATION.ordinal()));
            serializedTransferOperation.write(this.getFrom().toByteArray());
            serializedTransferOperation.write(this.getTo().toByteArray());
            serializedTransferOperation.write(this.getAmount().toByteArray());
            serializedTransferOperation.write(SteemUtils.transformStringToVarIntByteArray(this.getMemo()));

            return serializedTransferOperation.toByteArray();
        } catch (IOException e) {
            throw new SteemInvalidTransactionException(
                    "A problem occured while transforming the operation into a byte array.", e);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
