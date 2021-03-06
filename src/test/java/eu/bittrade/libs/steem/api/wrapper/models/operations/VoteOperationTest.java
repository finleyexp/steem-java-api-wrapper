package eu.bittrade.libs.steem.api.wrapper.models.operations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.UnsupportedEncodingException;

import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import eu.bittrade.libs.steem.api.wrapper.BaseTest;
import eu.bittrade.libs.steem.api.wrapper.IntegrationTest;
import eu.bittrade.libs.steem.api.wrapper.exceptions.SteemInvalidTransactionException;
import eu.bittrade.libs.steem.api.wrapper.models.Transaction;

/**
 * Test a Steem "vote operation" and verify the results against the api.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class VoteOperationTest extends BaseTest {
    final String EXPECTED_BYTE_REPRESENTATION = "0007666f6f6261726107666f6f6261726307666f6f62617264e803";
    final String EXPECTED_TRANSACTION_HASH = "baeec6f72307dec3a7ffa78b6aa56ebd8eb9fa1390d69653d76613646fecc058";
    final String EXPECTED_TRANSACTION_SERIALIZATION = "00000000000000000000000000000000000000000000000000000000"
            + "00000000f68585abf4dcf0c80457010007666f6f6261726107666f6f6261726307666f6f62617264e80300";

    private static VoteOperation voteOperation;
    private static Transaction voteOperationTransaction;

    @BeforeClass
    public static void setup() throws Exception {
        voteOperation = new VoteOperation();
        voteOperation.setAuthor("foobarc");
        voteOperation.setPermlink("foobard");
        voteOperation.setVoter("foobara");
        voteOperation.setWeight((short) 1000);

        Operation[] operations = { voteOperation };

        voteOperationTransaction = new Transaction();
        voteOperationTransaction.setExpirationDate(EXPIRATION_DATE);
        voteOperationTransaction.setRefBlockNum(REF_BLOCK_NUM);
        voteOperationTransaction.setRefBlockPrefix(REF_BLOCK_PREFIX);
        // TODO: Add extensions when supported.
        // transaction.setExtensions(extensions);
        voteOperationTransaction.setOperations(operations);
    }

    @Test
    public void testVoteOperationToByteArray() throws UnsupportedEncodingException, SteemInvalidTransactionException {
        assertThat("Expect that the operation has the given byte representation.",
                Utils.HEX.encode(voteOperation.toByteArray()), equalTo(EXPECTED_BYTE_REPRESENTATION));
    }

    @Test
    public void testVoteOperationTransactionHex()
            throws UnsupportedEncodingException, SteemInvalidTransactionException {
        voteOperationTransaction.sign();

        assertThat("The serialized transaction should look like expected.",
                Utils.HEX.encode(voteOperationTransaction.toByteArray()), equalTo(EXPECTED_TRANSACTION_SERIALIZATION));
        assertThat("Expect that the serialized transaction results in the given hex.",
                Utils.HEX.encode(Sha256Hash.wrap(Sha256Hash.hash(voteOperationTransaction.toByteArray())).getBytes()),
                equalTo(EXPECTED_TRANSACTION_HASH));
    }

    @Category({ IntegrationTest.class })
    @Test
    public void verifyTransaction() {

    }

    @Category({ IntegrationTest.class })
    @Test
    public void getTransactionHex() {

    }
}
