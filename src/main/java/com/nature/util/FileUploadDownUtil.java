package com.nature.util;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 文件上传下载工具类
 * springboot
 * FileUploadDownUtil
 * Author: 竺志伟
 * Date:   2017-04-01 15:41
 */
public class FileUploadDownUtil
{
    private static Logger logger = Logger.getLogger(FileUploadDownUtil.class);

    private static Set imgSet;
    private static Set fileSet;

    static
    {
        imgSet = new HashSet<String>();
        imgSet.add("png");
        imgSet.add("jpg");
        imgSet.add("gif");

        fileSet = new HashSet<String>();
        fileSet.add("doc");
        fileSet.add("docx");
        fileSet.add("txt");
        fileSet.add("pdf");
        fileSet.add("ppt");
    }

    /**
     * 文件上传
     *
     * @param rootPath    the root path
     * @param filePath    the file path
     * @param requestType the request type
     * @param file        the file
     * @return common result
     * @author:竺志伟
     * @date :2018-03-08 17:17:42
     */
    public static CommonResult uploadFile(String rootPath, String filePath, String requestType, MultipartFile file)
    {
        CommonResult commonResult = new CommonResult();

        if(null == file || file.isEmpty())
        {
            commonResult.setCode(CommonResult.FAILS);
            commonResult.setMessage("文件上传错误,请联系管理员!");
            return commonResult;
        }
        String fileName = file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(fileName);


        if(StringUtils.isBlank(requestType))//要求的文件类型为空,按系统要求的文件格式上传
        {
            if(StringUtils.isBlank(fileExtension) || !fileSet.contains(fileExtension.toLowerCase())) //系统默认的上传文件类型
            {
                commonResult.setCode(CommonResult.FAILS);
                commonResult.setMessage("不支持该扩展名的文件");
                return commonResult;
            }
        }
        else
        {
            if(requestType.indexOf(fileExtension.toLowerCase()) < 0) //要求的文件类型中不包含该文件的扩展名
            {
                commonResult.setCode(CommonResult.FAILS);
                commonResult.setMessage("不支持该扩展名的文件,请上传扩展名为" + requestType + "的文件");
                return commonResult;
            }
        }


        String destFileName = Tools.getDateString(null, "yyyyMMddHHmmssSSS") + "." + fileExtension;
        File destFile = new File(rootPath + DirectoryTools.SYS_FILEPATH_SEPARATOR + filePath +
                DirectoryTools.SYS_FILEPATH_SEPARATOR + Tools.getDateString(new Date(), "yyyyMM") +
                DirectoryTools.SYS_FILEPATH_SEPARATOR + destFileName);
        if(!destFile.getParentFile().exists())
        {
            destFile.getParentFile().mkdirs();
        }

        try
        {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(destFile));
            stream.write(file.getBytes());
            stream.close();

            commonResult.setCode(CommonResult.SUCCESS);
            commonResult.setMessage("文件上传成功!");

            Map data = new HashMap<String, Object>();
            data.put("fileName", fileName);
            data.put("extName", fileExtension);
            data.put("fileSize", file.getSize());
            data.put("fileUrl", destFile.getPath().replaceAll("\\\\", "/").replace(rootPath,"/"));
            commonResult.setData(data);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.error("文件上传错误", e);
            commonResult.setCode(CommonResult.FAILS);
            commonResult.setMessage("文件上传错误,请联系管理员!");
        }
        finally
        {
            return commonResult;
        }
    }


    /**
     * 图片上传
     * Upload img common result.
     *
     * @param rootPath    the root path
     * @param filePath    the file path
     * @param requestType the request type
     * @param file        the file
     * @return the common result
     * @author:竺志伟
     * @date :2018-03-08 17:17:37
     */
    public static CommonResult uploadImg(String rootPath, String filePath, String requestType, MultipartFile file)
    {
        CommonResult commonResult = new CommonResult();

        if(null == file || file.isEmpty())
        {
            commonResult.setCode(CommonResult.FAILS);
            commonResult.setMessage("图片上传错误,请联系管理员!");
            return commonResult;
        }
        String fileName = file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(fileName);


        if(StringUtils.isBlank(requestType))//要求的文件类型为空,按系统要求的文件格式上传
        {
            if(StringUtils.isBlank(fileExtension) || !imgSet.contains(fileExtension.toLowerCase())) //系统默认的上传文件类型
            {
                commonResult.setCode(CommonResult.FAILS);
                commonResult.setMessage("不支持该扩展名的图片");
                return commonResult;
            }
        }
        else
        {
            if(requestType.indexOf(fileExtension.toLowerCase()) < 0) //要求的文件类型中不包含该文件的扩展名
            {
                commonResult.setCode(CommonResult.FAILS);
                commonResult.setMessage("不支持该扩展名的文件,请上传扩展名为" + requestType + "的文件");
                return commonResult;
            }
        }


        String destFileName = Tools.getDateString(null, "yyyyMMddHHmmssSSS") + "." + fileExtension;
        File destFile = new File(rootPath + DirectoryTools.SYS_FILEPATH_SEPARATOR + filePath +
                DirectoryTools.SYS_FILEPATH_SEPARATOR + Tools.getDateString(new Date(), "yyyyMM") +
                DirectoryTools.SYS_FILEPATH_SEPARATOR + destFileName);
        if(!destFile.getParentFile().exists())
        {
            destFile.getParentFile().mkdirs();
        }
        try
        {
            //思路,如果图片过大,强制按比例压缩到指定宽度
            // 构造Image对象
            BufferedImage src = javax.imageio.ImageIO.read(file.getInputStream());
            if(src.getWidth() > 2048)
            {
                int width = 2048;
                int height = src.getHeight() * 2048 / src.getWidth();//按比例，将高度缩减
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                tag.getGraphics().drawImage(src, 0, 0, width, height, null);
                FileOutputStream out = new FileOutputStream(destFile);
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                encoder.encode(tag);
                out.close();
            }
            else
            {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(destFile));
                stream.write(file.getBytes());
                stream.close();
            }

            commonResult.setCode(CommonResult.SUCCESS);
            commonResult.setMessage("图片上传成功!");

            Map data = new HashMap<String, Object>();
            data.put("fileName", fileName);
            data.put("extName", fileExtension);
            data.put("fileSize", file.getSize());
            data.put("fileUrl", destFile.getPath().replaceAll("\\\\", "/").replace(rootPath,"/"));
            commonResult.setData(data);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.error("图片上传错误", e);
            commonResult.setCode(CommonResult.FAILS);
            commonResult.setMessage("图片上传错误,请联系管理员!");
        }
        finally
        {
            return commonResult;
        }
    }


}
