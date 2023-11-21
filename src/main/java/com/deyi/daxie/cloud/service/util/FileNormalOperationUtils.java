package com.deyi.daxie.cloud.service.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@Slf4j
public class FileNormalOperationUtils {
    /**
     * @description: 在线播放MP4文件
     * @author: Re、ZOO2
     * @date: 2021/7/25 22:50
     * @param: [request, floderPath 文件夹路径, fileName 文件名称, response]
     * @return: void
     **/
    public static void  aloneVideoPlay(HttpServletRequest request, HttpServletResponse response, String floderPath/*, String fileName*/) {
        InputStream is = null;
        OutputStream os = null;
        try {
            response.setContentType("video/mp4");
            File file = new File(floderPath /*+ fileName*/);
            response.addHeader("Content-Length", "" + file.length());
            is = new FileInputStream(file);
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (Exception e) {
            log.error("播放MP4失败", e);
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
