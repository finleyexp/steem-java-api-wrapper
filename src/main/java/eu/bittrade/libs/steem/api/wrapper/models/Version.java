package eu.bittrade.libs.steem.api.wrapper.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a Steem "steem_version_info" object.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class Version {
    @JsonProperty("blockchain_version")
    private String blockchainVersion;
    @JsonProperty("steem_revision")
    private String steemRevision;
    @JsonProperty("fc_revision")
    private String fcRevision;

    /**
     * 
     * @return
     */
    public String getBlockchainVersion() {
        return blockchainVersion;
    }

    /**
     * 
     * @return
     */
    public String getSteemRevision() {
        return steemRevision;
    }

    /**
     * 
     * @return
     */
    public String getFcRevision() {
        return fcRevision;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
