package com.wotreplayupload.upload;

import com.wotreplayupload.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity upload(@RequestParam("file")CommonsMultipartFile file, @RequestParam String fileTitle) {
        fileService.saveUploadFile(file);
        return ResponseEntity.noContent().build();
    }
}
