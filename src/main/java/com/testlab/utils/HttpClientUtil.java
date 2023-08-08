package com.testlab.utils;

import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class HttpClientUtil {

    /**
     * 发送application/json的请求
     *
     * @param url  请求地址
     * @param json 请求体
     * @return 响应结果
     */
    public static JSONObject doPost(String url, String jsonString) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            try {
                StringEntity s = new StringEntity(jsonString);
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
}
