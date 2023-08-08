package com.testlab.controller;

import com.alibaba.fastjson2.JSONObject;
import com.testlab.config.SdApiConfig;
import com.testlab.model.Img2ImgVo;
import com.testlab.model.Txt2ImgVo;
import com.testlab.utils.FilesUtil;
import com.testlab.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @BelongsProject: stable-diffusion-webui-SdApiController-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 10:41:34 星期二
 * @FileName: SdApiController
 * @Description: TODO
 */
@Slf4j
@RequestMapping("test")
@RestController
public class SdApiController {

    @Autowired
    private SdApiConfig sdApiConfig;

    @PostMapping("sdapi/v1/txt2img")
    public void txt2img(@RequestBody Txt2ImgVo paramMap) throws Exception {
        log.info(paramMap.toString());
        String txt2imgUrl = sdApiConfig.getTxt2imgUrl();
        String jsonString = JSONObject.toJSONString(paramMap);
        JSONObject responseJsonObj = HttpClientUtil.doPost(txt2imgUrl, jsonString);
        assert responseJsonObj != null;
        saveImages(responseJsonObj);
    }

    @PostMapping("/sdapi/v1/img2img")
    public void img2img(@RequestBody Img2ImgVo paramMap) throws IOException {
        log.info(paramMap.toString());
        String img2imgUrl = sdApiConfig.getImg2imgUrl();
        String jsonString = JSONObject.toJSONString(paramMap);
        JSONObject responseJsonObj = HttpClientUtil.doPost(img2imgUrl, jsonString);
        assert responseJsonObj != null;
        saveImages(responseJsonObj);
    }

    private static void saveImages(JSONObject responseJsonObj) {
        List<String> images = responseJsonObj.getList("images", String.class);
        for (String base64Str : images) {
            FilesUtil.base64ToImage(base64Str);
        }
    }
}
