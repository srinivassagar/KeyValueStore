package kvStore.util;

/*
Author: Srinivas A
This class provides APIs related to File CRUD.
 */

import com.opencsv.CSVWriter;
import kvStore.Record;

import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class FileUtil {

    public static void write(String key, Object value) throws IOException, NoSuchAlgorithmException {
        write(key, value, "");
    }

    public static void write(String key, Object value, String label) throws NoSuchAlgorithmException, IOException {
        Record record = Record.getRecord(key, value, label);
        System.out.println("Record value is " + record);
        String path = getPath(key);
        FileWriter fw = new FileWriter(path, true);
        CSVWriter csvWriter = new CSVWriter(fw);
        csvWriter.writeNext(new String[]{record.getKey(), String.valueOf(record.getValue()), record.getLabel(), String.valueOf(record.getTimestamp())}, false);
        csvWriter.close();
        System.out.println("Write of a key is successfull");
    }

    private static String getPath(String key) throws NoSuchAlgorithmException {
        BigInteger hash = BucketDetails.getBucketNo(key);
        String path = hash + ".csv";
        return path;
    }

    public static Object read(String key) throws FileNotFoundException, NoSuchAlgorithmException {
        String path = getPath(key);
        Object value = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Record finalRecord = null;
            String line = br.readLine();
            while (line != null) {
                Record record = Record.getRecord(line.split(",")[0], line.split(",")[1], line.split(",")[2]);

                if (record.getKey().equalsIgnoreCase(key)) {
                    finalRecord = record;
                }

                line = br.readLine();
            }
            if (finalRecord != null) {
                if (!finalRecord.getLabel().equalsIgnoreCase("d"))
                    value = finalRecord.getValue();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean update(String key, Object value) throws IOException, NoSuchAlgorithmException {
        write(key, value);
        return true;
    }

    public static boolean deleteKey(String key) throws IOException, NoSuchAlgorithmException {
        Object value = read(key);
        write(key, value, "D");
        return true;
    }

}
