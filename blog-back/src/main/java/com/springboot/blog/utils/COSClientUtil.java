package com.springboot.blog.utils;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class COSClientUtil {

    //todo 这些变量信息自行到 腾讯云对象存储控制台 获取

    private COSClient cOSClient;

    private static final String ENDPOINT = "";  //用户可以指定域名，不指定则为默认生成的域名

    //secretId
    private static final String secretId = "AKIDA5l7E6UEcmiP9koD4g291nLfjXCdqosh";
    // secretKey
    private static final String secretKey = "jEXUCpHgqlaDSRBmywjHai4IHyQcSRDs";
    // 存储通名称
    private static final String bucketName = "bingos-1258635419";//公有读私有写
    // 1 初始化用户身份信息(secretId, secretKey)
    private static COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
    // 3 生成cos客户端
    private static COSClient cosclient = new COSClient(cred, clientConfig);

    public COSClientUtil() {
        cOSClient = new COSClient(cred, clientConfig);
    }
    public COSClient getCOSClient(){
        return cosclient;
    }
    /**
     * 销毁
     */
    public void destory() {
        cOSClient.shutdown();
    }

    /**
     * 上传图片
     *
     * @param url
     */
    public void uploadImg2Cos(String url) throws Exception {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            this.uploadFile2Cos(fin, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            throw new Exception("上传失败");
        }
    }

    public String uploadFile2Cos(MultipartFile file,String path) throws Exception {

        //图片名称
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        //图片后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        System.out.println("substring = " + substring);
        Random random = new Random();
        //生成新的图片名称(随机数0-9999+系统当前时间+上传图片名)
        String name = path+random.nextInt(10000) + System.currentTimeMillis() + "_" + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2Cos(inputStream, name);
            return name;
        } catch (Exception e) {
            throw new Exception("上传失败");
        }
    }

    /**
     * 获得图片路
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        return getUrl(fileUrl);
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = cOSClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 上传到COS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2Cos(InputStream instream, String fileName) {
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = cOSClient.putObject(bucketName,  fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断Cos服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    public List<COSObjectSummary> listResources() {
        // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
// 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
// prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("vue_springboot_blog/images");
// deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("/");
// 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        List<COSObjectSummary> cosObjectSummaries;
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = new COSClientUtil().getCOSClient().listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
            } catch (CosClientException e) {
                e.printStackTrace();
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();

            // object summary表示所有列出的object列表
            cosObjectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                System.out.println(key);
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
            }

            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());
        return cosObjectSummaries;
    }
}
