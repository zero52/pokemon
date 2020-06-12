package com.zhu.common.utils;

import org.springframework.util.ClassUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * 
 * @ClassName Base64Utils
 * @Description TODO(base64处理工具类)
 * @author zz
 * @Date 2019年8月22日 上午11:40:28
 * @version 1.0.0
 */
public class Base64Utils {

    public static String Base64ToFile(String base64) {
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
          String filePath = "file/temp/";
          String fileName = "TEMP.png";
          String realPath = rootPath+filePath;
          
          File file = null;
          File dir=new File(realPath);
          if (!dir.exists() && !dir.isDirectory()) {
                  dir.mkdirs();
          }
          BufferedOutputStream bos = null;
          java.io.FileOutputStream fos = null;
          try {
              byte[] bytes = Base64.getDecoder().decode(base64);
              file=new File(realPath+fileName);
              fos = new java.io.FileOutputStream(file);
              bos = new BufferedOutputStream(fos);
              bos.write(bytes);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if (bos != null) {
                  try {
                      bos.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              if (fos != null) {
                  try {
                      fos.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
          return realPath+fileName;
    }
    
}
