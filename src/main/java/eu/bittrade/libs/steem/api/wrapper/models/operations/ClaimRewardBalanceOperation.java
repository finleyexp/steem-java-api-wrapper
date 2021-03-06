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
 * This class represents the Steem "claim_reward_balance_operation" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class ClaimRewardBalanceOperation extends Operation {
    private AccountName account;
    @JsonProperty("reward_steem")
    private Asset rewardSteem;
    @JsonProperty("reward_sbd")
    private Asset rewardSbd;
    @JsonProperty("reward_vests")
    private Asset rewardVests;

    /**
     * Create a new and empty claim reward balance operation.
     */
    public ClaimRewardBalanceOperation() {
        super(PrivateKeyType.POSTING);
    }

    /**
     * Get the account the reward should be collected for.
     * 
     * @return The account name.
     */
    public AccountName getAccount() {
        return account;
    }

    /**
     * Set the account the reward should be collected for.
     * 
     * @param account
     *            The account name.
     */
    public void setAccount(AccountName account) {
        this.account = account;
    }

    /**
     * Get the amount of Steem that should be collected.
     * 
     * @return The amount of Steem.
     */
    public Asset getRewardSteem() {
        return rewardSteem;
    }

    /**
     * Set the amount of Steem that should be collected. Please note that it is
     * not possible to collect more than that what is available. You can check
     * the available amount by requesting the Account information using
     * {@link eu.bittrade.libs.steem.api.wrapper.SteemApiWrapper#getAccounts(java.util.List)
     * getAccounts(List)} method.
     * 
     * @param rewardSteem
     *            The amount of Steem to collect.
     */
    public void setRewardSteem(Asset rewardSteem) {
        this.rewardSteem = rewardSteem;
    }

    /**
     * Get the amount of Steem Doller that should be collected.
     * 
     * @return The amount of Steem Doller.
     */
    public Asset getRewardSbd() {
        return rewardSbd;
    }

    /**
     * Set the amount of Steem Dollers that should be collected. Please note
     * that it is not possible to collect more than that what is available. You
     * can check the available amount by requesting the Account information
     * using
     * {@link eu.bittrade.libs.steem.api.wrapper.SteemApiWrapper#getAccounts(java.util.List)
     * getAccounts(List)} method.
     * 
     * @param rewardSbd
     *            The amount of Steem Dollers to collect.
     */
    public void setRewardSbd(Asset rewardSbd) {
        this.rewardSbd = rewardSbd;
    }

    /**
     * Get the amount of Vests that should be collected.
     * 
     * @return The amount of Vests.
     */
    public Asset getRewardVests() {
        return rewardVests;
    }

    /**
     * Set the amount of Vests that should be collected. Please note that it is
     * not possible to collect more than that what is available. You can check
     * the available amount by requesting the Account information using
     * {@link eu.bittrade.libs.steem.api.wrapper.SteemApiWrapper#getAccounts(java.util.List)
     * getAccounts(List)} method.
     * 
     * @param rewardVests
     *            The amount of Vests to collect.
     */
    public void setRewardVests(Asset rewardVests) {
        this.rewardVests = rewardVests;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        try (ByteArrayOutputStream serializedClaimRewardOperation = new ByteArrayOutputStream()) {
            serializedClaimRewardOperation
                    .write(SteemUtils.transformIntToVarIntByteArray(OperationType.CLAIM_REWARD_BALANCE_OPERATION.ordinal()));
            serializedClaimRewardOperation.write(this.account.toByteArray());
            serializedClaimRewardOperation.write(this.rewardSteem.toByteArray());
            serializedClaimRewardOperation.write(this.rewardSbd.toByteArray());
            serializedClaimRewardOperation.write(this.rewardVests.toByteArray());

            return serializedClaimRewardOperation.toByteArray();
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
