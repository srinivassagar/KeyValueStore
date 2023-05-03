package kvStore.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
Author: Srinivas A
This file is utility helps in hashing and getting the bucket number;
 */

public class BucketDetails {

    private static final int TOTAL_BUCKET_NO = 10;

    public static byte[] hash(String input) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5").digest(input.getBytes());
    }

    public static BigInteger getBucketNo(String key) throws NoSuchAlgorithmException {
        BigInteger number = new BigInteger(hash(key));
        return number.mod(new BigInteger(String.valueOf(TOTAL_BUCKET_NO)));
    }

}
