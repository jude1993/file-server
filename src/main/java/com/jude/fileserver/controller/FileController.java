package com.jude.fileserver.controller;

import com.jude.fileserver.file.client.Document;
import com.jude.fileserver.file.client.Utils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Value("${ROOT_PATH}")
    private String rootPath;

    @RequestMapping(value="/list",method = RequestMethod.POST)
    public Document all(@RequestParam("path") String path){
        if(StringUtils.isEmpty(path)){
            return null;
        }
    return Utils.getAllFile(path);
    }

    @RequestMapping(value="/detail",method = RequestMethod.POST)
    public Document single(@RequestParam("path") String path){
    if (StringUtils.isEmpty(path)) {
        return Utils.getChildFiles(rootPath);
    }
        return Utils.getChildFiles(path);
    }

    @RequestMapping(value="/download",method = RequestMethod.POST)
    public void download(HttpServletResponse response,@RequestBody Document document){
        doDownload(response,document.getPath(),document.getName());
    }

    public void doDownload(HttpServletResponse resp, String path, String name) {
        File file = new File(path);
        resp.reset();
        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os;
        try {
            os = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
