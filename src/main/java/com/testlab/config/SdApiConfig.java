package com.testlab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: stable-diffusion-webui-api-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 10:51:03 星期二
 * @FileName: SdApiConfig
 * @Description: TODO
 */
@Component
public class SdApiConfig {

    @Value("${sd-webui.address}")
    private String address;

    @Value("${sd-webui.txt2img.path}")
    private String txt2imgPath;

    @Value("${sd-webui.txt2img.method}")
    private String txt2imgMethod;

    @Value("${sd-webui.img2img.path}")
    private String img2imgPath;

    @Value("${sd-webui.img2img.method}")
    private String img2imgMethod;

    public String getTxt2imgUrl() {
        return address + txt2imgPath;
    }

    public String getImg2imgUrl() {
        return address + img2imgPath;
    }
}
