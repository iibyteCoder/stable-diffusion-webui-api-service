package com.testlab;

import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: stable-diffusion-webui-api-service
 * @Author: zyb
 * @CreateTime: 2023-08-08 15:02:12 星期二
 * @FileName: HttpclientTest
 * @Description: TODO
 */
public class HttpclientTest {

    /**
     * 发送application/json的请求
     *
     * @param url  请求地址
     * @param json 请求体
     * @return 响应结果
     */
    public static JSONObject doPost(String url, JSONObject json) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            try {
                StringEntity s = new StringEntity(json.toString());
                s.setContentEncoding("UTF-8");
                s.setContentType("application/json");// 发送json数据需要设置contentType
                post.setEntity(s);
                // 配置请求参数实例
                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000) // 设置连接主机服务超时时间
                        .setConnectionRequestTimeout(35000) // 设置连接请求超时时间
                        .setSocketTimeout(60000) // 设置读取数据连接超时时间
                        .build();
                // 为httpPost实例设置配置
                post.setConfig(requestConfig);
                HttpResponse res = client.execute(post);
                if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = res.getEntity();
                    // 返回json格式：
                    String result = EntityUtils.toString(entity);
                    return JSONObject.parseObject(result);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:7861/sdapi/v1/txt2img";
        String param = "{\n" +
                "    \"denoising_strength\": 0,\n" +
                "    \"prompt\": \"puppy dogs\",\n" +
                "    \"negative_prompt\": \"\",\n" +
                "    \"seed\": -1,\n" +
                "    \"batch_size\": 2,\n" +
                "    \"n_iter\": 1,\n" +
                "    \"steps\": 50,\n" +
                "    \"cfg_scale\": 7,\n" +
                "    \"width\": 512,\n" +
                "    \"height\": 512,\n" +
                "    \"restore_faces\": false,\n" +
                "    \"tiling\": false,\n" +
                "    \"override_settings\": {\n" +
                "        \"sd_model_checkpoint\": \"chilloutmix_NiPrunedFp32Fix.safetensors\"\n" +
                "    },\n" +
                "    \"script_args\": [],\n" +
                "    \"sampler_index\": \"Euler\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(param);
        JSONObject jsonObject1 = doPost(url, jsonObject);
        System.out.println(jsonObject1);
    }
}
