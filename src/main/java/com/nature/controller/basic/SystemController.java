/*
 * Copyright (c) 2017~2030. 竺志伟 tdzr_0606@126.com
 */

package com.nature.controller.basic;

import com.nature.util.CommonResult;
import com.nature.util.FileUploadDownUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * springboot
 * FileUploadController
 * Author: 竺志伟
 * Date:   2017-08-31 12:01
 */
@Controller
@RequestMapping(value = "/system/")
public class SystemController extends BaseController
{

    @Value("${web.upload-path}")
    private String uploadRootPath;


    /**
     * 文件上传
     *
     * @param file     the upload file
     * @param uploadFilePath the upload file path
     * @param requestType    the request type
     * @return common result
     * @author:竺志伟
     * @date :2018-03-08 17:19:34
     */
    @RequestMapping("/fileupload")
    @ResponseBody
    public CommonResult fileUpload(@RequestParam(value = "file", required = true) MultipartFile file,
                                   @RequestParam(value = "uploadFilePath", required = true) String uploadFilePath,
                                   @RequestParam(value = "requestType", required = false) String requestType)
    {
        return FileUploadDownUtil.uploadFile(uploadRootPath, uploadFilePath,requestType, file);
    }


    /**
     * 图片上传
     * Img upload common result.
     *
     * @param file     the upload file
     * @param uploadFilePath the upload file path
     * @param requestType    the request type
     * @return the common result
     * @author:竺志伟
     * @date :2018-03-08 17:19:37
     */
    @RequestMapping("/imgpload")
    @ResponseBody
    public CommonResult imgUpload(@RequestParam(value = "file", required = true) MultipartFile file,
                                  @RequestParam(value = "uploadFilePath", required = true) String uploadFilePath,
                                  @RequestParam(value = "requestType", required = false) String requestType)
    {
        return FileUploadDownUtil.uploadImg(uploadRootPath,uploadFilePath,requestType,file);
    }

}
