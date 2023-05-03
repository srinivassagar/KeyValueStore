package kvStore;

/*
Author: Srinivas A
Client code to test
 */
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TestDriver {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        KeyValueStore.write("abcd", 1);
        KeyValueStore.delete("abcd");
        KeyValueStore.read("abcd");
        KeyValueStore.update("abcd", 3);
        KeyValueStore.delete("abcd");

        System.out.println("output" + KeyValueStore.read("abcd"));
    }
}
