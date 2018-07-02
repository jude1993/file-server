package com.jude.fileserver.controller;

import com.jude.fileserver.file.client.Document;
import com.jude.fileserver.file.client.Utils;
import com.jude.fileserver.file.utils.Constants;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("download/file")
public class FileController {

    @RequestMapping(value="/all",method = RequestMethod.POST)
    public Document all(@RequestParam("path") String path){

    return Utils.getAllFile(path);
    }

    @RequestMapping(value="/single",method = RequestMethod.POST)
    public Document single(@RequestParam("path") String path){
    if (StringUtils.isEmpty(path)) {
        return Utils.getChildFiles(Constants.root);
    }
        return Utils.getChildFiles(path);
    }
}
