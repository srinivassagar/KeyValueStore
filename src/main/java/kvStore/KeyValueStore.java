package kvStore;

/*
Author: Srinivas A
This class mainly provides APIs for CRUD operation on KV Store
 */

import com.google.common.base.Preconditions;
import kvStore.util.Cache;
import kvStore.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class KeyValueStore {

    public static boolean write(String key, Object value) throws IOException, NoSuchAlgorithmException {

        Preconditions.checkArgument(key != null);
        Preconditions.checkArgument(value != null);

        boolean status = false;
        try {
            Cache.set(key, value);
            FileUtil.write(key, value);
            status = true;
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return status;
    }


    public static Object read(String key) throws FileNotFoundException, NoSuchAlgorithmException {
        Preconditions.checkArgument(key != null);


        Object value = Cache.get(key);

        if (value == null)
            value = FileUtil.read(key);

        System.out.println("Value is " + value);
        return value;
    }

    public static boolean update(String key, Object value) throws IOException, NoSuchAlgorithmException {
        Preconditions.checkArgument(key != null);
        Preconditions.checkArgument(value != null);
        //set it in cache and fileutil
        boolean status = false;
        try {
            Cache.set(key, value);
            FileUtil.update(key, value);
            status = true;
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return status;
    }

    public static boolean delete(String key) {
        Preconditions.checkArgument(key != null);

        boolean status = false;

        try {
            Cache.delete(key);
            FileUtil.deleteKey(key);
            status = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return status;
    }


}
