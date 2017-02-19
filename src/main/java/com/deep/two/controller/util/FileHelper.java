package com.deep.two.controller.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.deep.two.util.CollectionUtil;


@Repository
@Lazy(false)
public class FileHelper {
    private static final Logger LOGGER = Logger.getLogger(FileHelper.class);
    
    public void mkdir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    
    public void saveFile(String rootDir, String id, MultipartFile[] files) { 
    	mkdir(rootDir);
        if (files == null) {
            return;
        }
        String path = rootDir + File.separator + id;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        InputStream fis = null;
        String fileName = null;
        long size = 0l;
        File file = null;
        FileOutputStream fos = null;
        try {
            for (MultipartFile partFile : files) {
                fileName = partFile.getOriginalFilename();
                size = partFile.getSize();
                if ("".equals(fileName) || size <= 0) {
                    continue;
                }
                fis = partFile.getInputStream();
                file = new File(path + File.separator + fileName);  
                fos = new FileOutputStream(file); 
                byte[] buf = new byte[1024];  
                int len = 0;  
                while ((len = fis.read(buf)) > 0) {  
                    fos.write(buf, 0, len);  
                }  
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {  
                    fos.flush();
                    fos.close();
                }
            }
        } catch(IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
    
    public void deleteFile(String rootDir, String id, String fileName) {
        String path = rootDir + File.separator + id;
        File file = new File(path + File.separator + fileName);
        file.delete();
    }
    
    public void deleteAllFile(String rootDir, String id) {
        File dir = new File(rootDir + File.separator + id);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(File file : files) {
                file.delete();
            }
            dir.delete();
        }
    }
    
    /**
     * deleteUnusedFile: 从远程目录删除被删除的文件 <br/>
     * 
     * @param id
     * @param fileList 新文件列表
     */
    public void deleteUnusedFile(String rootDir, String id, String fileList) {
       List<String> list = CollectionUtil.strToArrayList(fileList, "\\|");
       File dir = new File(rootDir + File.separator + id);
       if (dir.isDirectory()) {
           File[] files = dir.listFiles();
           for(File file : files) {
               if (!list.contains(file.getName())) {
                   file.delete();
               }
           }
       }
    }
    
    public static File getFile(String rootDir, String id, String fileName) {
        String path = rootDir + File.separator + id;
        File file = new File(path + File.separator + fileName);
        return file;
    }
    
    public static File getFile(String path) {
        File file = new File(path);
        return file;
    }
    
    public static void main(String[] args) {
    	File file = new File("C:\\Users\\sunxijin\\Desktop\\_000102616110504734.html");
        System.out.println(file);
	}
}