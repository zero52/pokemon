package com.zhu.common.utils.ORC;/*
2019/7/19
41586
*/

import com.baidu.aip.ocr.AipOcr;

public class AipOcrUtils {

    private  static AipOcr client;

    // 官网获取的 API Key 更新为你注册的
    private  static String clientId = "kaEvQU7ABIOyhUWmV3lNnio8";
    // 官网获取的 Secret Key 更新为你注册的
    private  static String clientSecret = "3UOulnQoXajxsiMBLptVhtuNILjU6yGe";

    public static final String APP_ID = "16835890";
    public static final String API_KEY = "kaEvQU7ABIOyhUWmV3lNnio8";
    public static final String SECRET_KEY = "3UOulnQoXajxsiMBLptVhtuNILjU6yGe";

    static {
        // 初始化一个AipOcr
        client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
    }

    public static AipOcr getClient() {
        return client;
    }

    public static void setClient(AipOcr client) {
        AipOcrUtils.client = client;
    }
}
