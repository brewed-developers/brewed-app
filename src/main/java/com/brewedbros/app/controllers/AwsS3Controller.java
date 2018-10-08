package com.brewedbros.app.controllers;

import com.brewedbros.app.services.AWSS3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/storage/s3")
public class AwsS3Controller {
    private static final Logger logger = LoggerFactory.getLogger(AwsS3Controller.class);

    @Autowired
    private AWSS3Service awss3Service;


    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.awss3Service.uploadFile(file);
    }

    @PostMapping("/uploadFiles")
    public List<String> uploadFiles(@RequestPart(value = "file") MultipartFile[] files) {
        return Arrays.asList(files)
                .parallelStream()
                .map(file -> this.awss3Service.uploadFile(file))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.awss3Service.deleteFileFromS3Bucket(fileUrl);
    }
}