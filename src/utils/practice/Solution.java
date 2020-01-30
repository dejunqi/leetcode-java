package utils.practice;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Solution {

    /*
    * Given a file path, find all duplicate files under the directory
    * */
    public List<List<String>> findDuplicates(String path) throws Exception {
        List<List<String>> res = new ArrayList<>();
        if (path == null || path.length() == 0) {
            return res;
        }
        List<String> files = getAllFiles(path);
        Map<String, List<String>> map = new HashMap<>();
        for (String file : files) {
            String hashcode = hashFile(new File(file), "MD5");
            map.put(hashcode, map.getOrDefault(hashcode, new ArrayList<>()));
            map.get(hashcode).add(file);
        }

        for (String hashcode : map.keySet()) {
            List<String> list = map.get(hashcode);
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }

    // api
    private List<String> getAllFiles(String path) {
        List<String> res = new ArrayList<>();
        getAllFilesHelper(path, res);
        return res;
    }

    private void getAllFilesHelper(String curPath, List<String> res) {
        File dir = new File(curPath);
        if (dir.isFile()) {
            res.add(curPath);
            return;
        }

        String[] subdirs = dir.list();
        if (subdirs == null || subdirs.length == 0) return;

        for (String subdir : subdirs) {
            getAllFilesHelper(curPath + "/" + subdir, res);
        }
    }

    private Map<Long, List<String>> getAllFilesBySize(String path) {
        Map<Long, List<String>> res = new HashMap<>();
        getAllFilesBySizeHelper(path, res);
        return res;
    }

    private void getAllFilesBySizeHelper(String path, Map<Long, List<String>> res) {
        File file = new File(path);
        if (file.isFile()) {
            long size = file.length();
            if (!res.containsKey(size)) {
                res.put(size, new ArrayList<>());
            }
            res.get(size).add(path);
            return;
        }

        String[] paths = file.list();
        if (paths == null || paths.length == 0) return;

        for (String filePath : paths) {
            getAllFilesBySizeHelper(path + "/" + filePath, res);
        }
    }

    // given method
    private String hashFile(File file, String algorithm)
            throws Exception {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance(algorithm);


            byte[] bytesBuffer = new byte[1024];
            int bytesRead = -1;


            while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
                digest.update(bytesBuffer, 0, bytesRead);
            }


            byte[] hashedBytes = digest.digest();


            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | IOException ex) {
            throw new Exception(
                    "Could not generate hash from file", ex);
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

    public int hashFunction(String str) {
        /**
         * 整数的哈希函数
        * 对于字符串的哈希函数, 可以把每个字符看成是数字, 然后把字符串分解为 26 进制的大整数, 例如
        * code = c * 26 ^ 3 + o * 26 ^ 2 + d * 26 ^ 1 + e * 26 ^ 0
        * */
        int base = 256;
        int M = 17;
        int i = 0;
        int len = str.length();
        int res = 0;
        while (i < len) {
            res += (str.charAt(len - i - 1) * Math.pow(base, i)) % M;
            i++;
        }
        return res;
    }

    public void test() {}
}

