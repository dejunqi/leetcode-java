package dropbox.findduplicatefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class FindDuplicateFiles {

    public List<List<String>> findDuplicates(String path) throws Exception {
        List<List<String>> res = new ArrayList<>();

        List<String> paths = getAllFiles(path);
        Map<String, List<String>> map = new HashMap<>();

        for (String filepath : paths) {
            File file = new File(filepath);
            String hashCode = hashFile(file, "MD5");
            map.put(hashCode, map.getOrDefault(hashCode, new ArrayList<>()));
            map.get(hashCode).add(filepath);
        }

        for (String code : map.keySet()) {
            List<String> filepaths = map.get(code);
            if (filepaths.size() > 1) {
                res.add(filepaths);
            }
        }
        return res;
    }

    // api
    private List<String> getAllFiles(String path) throws Exception {
        List<String> files = new ArrayList<>();
        getAllFilesHelper(path, files);
        return files;
    }

     private void getAllFilesHelper(String path, List<String> files) {
        File file = new File(path);
        if (file.isFile()) {
            files.add(path);
            return;
        }

        String[] dirs = file.list();
        if (dirs == null || dirs.length == 0) {
            return;
        }
        for (String dir : dirs) {
            getAllFilesHelper(path + "/" + dir, files);
        }
     }

     private Map<Long, List<String>> getAllFilesBySize(String path) {
        Map<Long, List<String>> map = new HashMap<>();
         getAllFilesBySizeHelper(path, map);
         return map;
     }

     private void getAllFilesBySizeHelper(String curPath, Map<Long, List<String>> map) {
        File file = new File(curPath);
        if (file.isFile()) {
            Long size = file.length();
            map.put(size, map.getOrDefault(size, new ArrayList<>()));
            map.get(size).add(curPath);
            return;
        }

        String[] dirs = file.list();
        if (dirs == null || dirs.length == 0) return;
        for (String dir : dirs) {
            getAllFilesBySizeHelper(curPath + "/" + dir, map);
        }
     }

    // given method
    private static String hashFile(File file, String algorithm)
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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }



}
