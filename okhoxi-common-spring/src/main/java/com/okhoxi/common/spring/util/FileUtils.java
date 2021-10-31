package com.okhoxi.common.spring.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Tang on 2018/2/27 10:10.
 */
@Slf4j
public class FileUtils {
    public static String CHARSET = "utf-8";

    public static <T> T readJSONObject(String fileName, Class<T> cls){
        String path = FileUtils.class.getResource("/" + fileName).getPath();
        return JSON.parseObject(readTxt(path), cls);
    }

    public static List<Map<String, Object>> readListMap(String fileName){
        String path = FileUtils.class.getResource("/" + fileName).getPath();
        return JSON.parseObject(readTxt(path), new TypeReference<List<Map<String, Object>>>(){});
    }

    public static String readTxt(String filePath) {
        StringBuilder result = new StringBuilder();
        try {
            File file = new File(filePath);
            if (!file.isFile() || !file.exists()){
                return "";
            }
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), CHARSET);
            BufferedReader bufferedReader = new BufferedReader(read);

            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                result.append(lineTxt);
                result.append("\n");
            }
            read.close();
        } catch (Exception e) {

        }
        return result.toString();
    }

    public static String readTxtFile(String fileName) {
        String path = FileUtils.class.getResource("/" + fileName).getPath();
        return readTxt(path);
    }

    public static <T> T readObject(String fileName, Class<T> objectType) {
        String path = FileUtils.class.getResource("/" + fileName).getPath();
        return JSON.parseObject(readTxt(path), objectType);
    }

    /**
     * Recursive access folder all the files below.
     *
     * @param filePath
     * @return
     */
    public static List<File> getFiles(String filePath) {
        List<File> listFile = new ArrayList<>();
        try {
            File file = new File(filePath);
            log.info("Start scanning folder: {0} {1}", file.getPath(), file.isDirectory());
            if (!file.isDirectory()) {
                listFile.add(file);
            } else {
                if (!filePath.endsWith(File.separator)) {
                    filePath += File.separator;
                }

                String[] files = file.list();
                for (int j = 0; j < files.length; j++) {
                    String strPath = filePath + files[j];
                    File tmp = new File(strPath);
                    if (!tmp.isDirectory()) {
                        listFile.add(tmp);
                    } else {
                        getFileList(listFile, tmp);
                    }
                }
            }
        } catch (Exception e) {
            log.info("Read files has error due to: " + e.getMessage());
        }
        log.info("File list size: {0}", listFile.size());
        return listFile;
    }

    private static void getFileList(List<File> list, File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getFileList(list, files[i]);
                } else {
                    list.add(files[i]);
                }
            }
        }
    }

    public static double getDirSize(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {
                double size = (double) file.length() / 1024 / 1024;
                return size;
            }
        } else {
            log.warn("File does not exists,{0}", file.getPath());
            return 0.0;
        }
    }
}
