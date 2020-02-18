package com.springboot.blog.controller;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-02-16 19:01
 **/

import com.springboot.blog.entity.Result;
import com.springboot.blog.entity.TencentCOS;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 图片上传Controller
 */
@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ImageUploadController {





    /**
     * 上传头像
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("username") String username, Model model) throws Exception {
        //获取文件的名称
        String fileName = multipartFile.getOriginalFilename();

        //判断有无后缀
        if (fileName.lastIndexOf(".") < 0)
            return new Result(500, "上传图片格式不正确", null);

        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        //如果不是图片
        if (!prefix.equalsIgnoreCase(".jpg") && !prefix.equalsIgnoreCase(".jpeg") && !prefix.equalsIgnoreCase(".svg") && !prefix.equalsIgnoreCase(".gif") && !prefix.equalsIgnoreCase(".png")) {
            return new Result(500, "上传图片格式不正确", null);
        }

        //使用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
        //将Multifile转换成File
        multipartFile.transferTo(excelFile);

        //调用腾讯云工具上传文件
        String imageName = TencentCOS.uploadfile(excelFile, "avatar");

        //程序结束时，删除临时文件
        deleteFile(excelFile);

        //存入图片名称，用于网页显示
        model.addAttribute("imageName", imageName);

        //更新数据库
//        userInfoService.updateUserAvatar(imageName, username);

        //返回成功信息
        return new Result(200, "头像更换成功", imageName);
    }

    /**
     * 删除临时文件
     *
     * @param files 临时文件，可变参数
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

}
