package eu.bittrade.libs.steem.api.wrapper.models.operations;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.bittrade.libs.steem.api.wrapper.enums.PrivateKeyType;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.AccountName;

/**
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class AccountWitnessProxyOperation extends Operation {
    @JsonProperty("account")
    private AccountName account;
    @JsonProperty("proxy")
    private AccountName proxy;

    public AccountWitnessProxyOperation() {
        // Define the required key type for this operation.
        super(PrivateKeyType.POSTING);
    }

    /**
     * @return the account
     */
    public AccountName getAccount() {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(AccountName account) {
        this.account = account;
    }

    /**
     * @return the proxy
     */
    public AccountName getProxy() {
        return proxy;
    }

    /**
     * @param proxy
     *            the proxy to set
     */
    public void setProxy(AccountName proxy) {
        this.proxy = proxy;
    }

    @Override
    public byte[] toByteArray() throws SteemInvalidTransactionException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
