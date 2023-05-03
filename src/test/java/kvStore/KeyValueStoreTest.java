package kvStore;

/*
Author : Srinivas A
Unit test cases for KV Crud operation
 */

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class KeyValueStoreTest {

    @Test
    public void successInsert() throws IOException, NoSuchAlgorithmException {

        Assert.assertTrue(KeyValueStore.write("abcd", 5));
        Assert.assertTrue(KeyValueStore.write("abcde", 6));
        Assert.assertTrue(KeyValueStore.write("abcdef", 6));

    }

    @Test
    public void successUpdate() throws IOException, NoSuchAlgorithmException {
        Assert.assertTrue(KeyValueStore.update("abcd", 50));
    }

    @Test
    public void successDelete() throws FileNotFoundException, NoSuchAlgorithmException {
        KeyValueStore.delete("abcd");
        Assert.assertEquals(null,KeyValueStore.read("abcd"));

    }

    @Test
    public void successRead() throws FileNotFoundException, NoSuchAlgorithmException {

        Assert.assertEquals(6, Integer.parseInt((String) KeyValueStore.read("abcde")));

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKey() throws FileNotFoundException, NoSuchAlgorithmException {

        KeyValueStore.read(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidValue() throws IOException, NoSuchAlgorithmException {
        KeyValueStore.write("abcd", null);
    }
}
