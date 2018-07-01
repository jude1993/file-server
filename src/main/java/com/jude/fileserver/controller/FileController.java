package com.jude.fileserver.controller;

import com.jude.fileserver.file.client.Document;
import com.jude.fileserver.file.client.Utils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("download")
public class FileController {

    @RequestMapping(value="file/{path}",method = RequestMethod.GET)
    public Document file(@PathVariable String path){

        return Utils.getAllFile("D:\\"+path);
    }

    @RequestMapping("echo")
    public void echo(){
        System.out.println("success");
    }
}
