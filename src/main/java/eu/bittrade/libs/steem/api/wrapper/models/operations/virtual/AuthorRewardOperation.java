package eu.bittrade.libs.steem.api.wrapper.models.operations.virtual;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;
import eu.bittrade.libs.steem.api.wrapper.models.Asset;
import eu.bittrade.libs.steem.api.wrapper.models.operations.Operation;

/**
 * This class represents the Steem "author_reward_operation" object.
 * 
 * This operation type occurs if the payout period is over and the author
 * finally gets his reward.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class AuthorRewardOperation extends Operation {
    @JsonProperty("author")
    private AccountName author;
    @JsonProperty("permlink")
    private String permlink;
    @JsonProperty("sbd_payout")
    private Asset sbdPayout;
    @JsonProperty("steem_payout")
    private Asset steemPayout;
    @JsonProperty("vesting_payout")
    private Asset vestingPayout;

    /**
     * Get the author who received this reward.
     * 
     * @return The author who received the reward.
     */
    public AccountName getAuthor() {
        return author;
    }

    /**
     * Get the permanent link of the post for which the author is rewarded.
     * 
     * @return The permanent link of the article.
     */
    public String getPermlink() {
        return permlink;
    }

    /**
     * Get the SDB amount the author gets for the article.
     * 
     * @return The amount of SBD.
     */
    public Asset getSbdPayout() {
        return sbdPayout;
    }

    /**
     * Get the Steem amount the author gets for the article.
     * 
     * @return The amount of Steem.
     */
    public Asset getSteemPayout() {
        return steemPayout;
    }

    /**
     * Get the Vests amount the author gets for the article.
     * 
     * @return The amount of Vests.
     */
    public Asset getVestingPayout() {
        return vestingPayout;
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
