package com.aiolia.controller;

import com.aiolia.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 文件上传和下载
 * @author aiolia
 * @version 1.0
 * @create 2022/12/12
 */
@RestController
@RequestMapping("/common")
public class CommonController
{
    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file)
    {
        String originalFilename = file.getOriginalFilename();
        String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName=UUID.randomUUID().toString()+suffix;

        File dir=new File(basePath);
        if(!dir.exists())
        {
            dir.mkdirs();
        }

        try
        {
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return R.success(fileName);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response)
    {
        FileInputStream fileInputStream=null;
        ServletOutputStream outputStream=null;
        try
        {
            fileInputStream=new FileInputStream(new File(basePath+name));
            outputStream=response.getOutputStream();
            int len=0;
            byte[] bytes=new byte[1024];
            while((len=fileInputStream.read(bytes))!=-1)
            {
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally
        {
            try
            {
                fileInputStream.close();
                outputStream.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

    }
}
