package com.testlab.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @BelongsProject: stable-diffusion-webui-api-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 14:15:56 星期二
 * @FileName: FilesUtil
 * @Description: 文件工具
 */
public class FilesUtil {
    /**
     * 图片转化成base64字符串
     *
     * @param imageFilePath 待处理的图片
     */
    public static String imageToBase64(String imageFilePath) {
        byte[] data = null;
        // 读取图片字节数组
        try (InputStream in = Files.newInputStream(Paths.get(imageFilePath));) {
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(data));
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imageBase64Str base64字符串
     */
    public static boolean base64ToImage(String imageBase64Str) {
        if (imageBase64Str == null) {
            // 图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imageBase64Str);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            // 新生成的图片
            long timeMillis = System.currentTimeMillis();
            String imgFilePath = "D:\\myprojects\\IdeaProjects\\LearningProjects\\stable-diffusion-webui-api-service\\files\\outputFiles\\tanbing2-" + timeMillis + ".jpg";
            try (OutputStream out = Files.newOutputStream(Paths.get(imgFilePath))) {
                out.write(b);
                out.flush();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String s = imageToBase64("D:\\myprojects\\IdeaProjects\\LearningProjects\\stable-diffusion-webui-api-service\\files\\outputFiles\\tanbing2-1691480379348.jpg");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("D:\\myprojects\\IdeaProjects\\LearningProjects\\stable-diffusion-webui-api-service\\files\\outputFiles\\tanbing2-1691480379348.txt"))) {
            bufferedWriter.write(s);
        }
    }
}
