package com.jude.fileserver.controller;

import com.jude.fileserver.file.client.Document;
import com.jude.fileserver.file.client.Utils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
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

    public void doUpload(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List items = upload.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
                } else {
                    if (item.getName() != null && !item.getName().equals("")) {
                        System.out.println("上传文件的大小:" + item.getSize());
                        System.out.println("上传文件的类型:" + item.getContentType());
                        // item.getName()返回上传文件在客户端的完整路径名称
                        System.out.println("上传文件的名称:" + item.getName());

                        File tempFile = new File(item.getName());
                        File file = new File(sc.getRealPath("/") + savePath, tempFile.getName());
                        item.write(file);
                        request.setAttribute("upload.message", "上传文件成功！");
                    }else{
                        request.setAttribute("upload.message", "没有选择上传文件！");
                    }
                }
            }
        }catch(FileUploadException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("upload.message", "上传文件失败！");
        }
        request.getRequestDispatcher("/uploadResult.jsp").forward(request, response);
    }
}
