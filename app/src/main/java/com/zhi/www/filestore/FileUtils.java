package com.zhi.www.filestore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/10.
 */
public class FileUtils {

    private static SaveResult saveResult;

    public FileUtils(SaveResult saveResult){
        this.saveResult = saveResult;
    }

    public static void save(String name, String content){
        checkDir(name);
        File file = new File(Constants.FILE_PATH + File.separator + name);
        byte[] bytes = content.getBytes();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
            saveResult.result(Constants.CODE_SAVE_SUCCESS);
        } catch (FileNotFoundException e) {
            saveResult.result(Constants.CODE_SAVE_FAIL);
            e.printStackTrace();
        } catch (IOException e) {
            saveResult.result(Constants.CODE_SAVE_FAIL);
            ToastUtils.make(R.string.str_file_fail);
            e.printStackTrace();
        }
    }

    public static void checkDir(String name){
        File file = new File(Constants.FILE_PATH);
        if(!file.exists()){
            file.mkdir();
        }
        File f = new File(Constants.FILE_PATH, name);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}