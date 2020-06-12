package com.zhu.common.utils.Http;/*
2019/7/18
41586
*/


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    private static final String charset = "UTF-8";

    public static CloseableHttpClient httpClient;

    static {

        try {


            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());

            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(builder.build());

            Registry<ConnectionSocketFactory> socketFactoryRegistry
                    = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();

            PoolingHttpClientConnectionManager poolManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            poolManager.setMaxTotal(200);
            poolManager.setDefaultMaxPerRoute(100);

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(30000)
                    .setSocketTimeout(30000)
                    .setConnectTimeout(0)
                    .build();


            CloseableHttpClient client = HttpClients.custom()
                    .setConnectionManager(poolManager)
                    .setDefaultRequestConfig(requestConfig)
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                    .build();


            httpClient = client;


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static HttpResult get(String url) {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return HttpResult.failure("Http Code=" + statusCode);
            }

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, HttpUtils.charset);
            EntityUtils.consume(entity);

            return HttpResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return HttpResult.failure("发生请求失败：" + e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
            } catch (IOException e) {
            }
        }
    }

//    public static HttpResult post(String url, JSONObject bodyParams, JSONObject headParams) {
//
//        HttpPost post = null;
//        CloseableHttpResponse response = null;
//        try {
//            String dayTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//            post = new HttpPost(url);
//            // 构造消息头
//            post.addHeader("Content-Type","application/x-www-form-urlencoded");
//
//            // 构建消息实体
//            if (headParams != null) {
//                for (String str : headParams.keySet()) {
//                    bodyParams.put(str, headParams.getString(str));
//                }
//            }
//            HttpEntity paramsEntity = new StringEntity(bodyParams.toString(), HttpUtils.charset);
//            post.setEntity(paramsEntity);
//
//
//            response = httpClient.execute(post);
//
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode != HttpStatus.SC_OK) {
//                return HttpResult.failure("Http Code=" + statusCode);
//            }
//
//            InputStream ins = response.getEntity().getContent();
//            //按指定的字符集构建文件流
//            BufferedReader br = new BufferedReader(new InputStreamReader(ins, "GBK"));
//            StringBuffer sbf = new StringBuffer();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sbf.append(line);
//            }
//            br.close();
//            return HttpResult.success(sbf.toString());
////            HttpEntity entity = response.getEntity();
////            String result = EntityUtils.toString(entity, HttpUtils.charset);
////            EntityUtils.consume(entity);
////            return HttpResult.success(result);
//        } catch (Exception e) {
//            return HttpResult.failure("发生请求失败：" + e.getMessage());
//        } finally {
//            try {
//                if (response != null) {
//                    response.close();
//                }
//                if (post != null) {
//                    post.releaseConnection();
//                }
//            } catch (IOException e) {
//            }
//        }
//    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8080/openapi/router";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appKey", "b0ukdpen6p");
        params.put("v", "3.0");
        params.put("method", "triopi.member.info.batch.query");
        //HttpResult test = post(url, new JSONObject(params), null, PublicConstants.URL_TYPE_CMIOT);
    }

    public static final class HttpResult {
        public final boolean success;
        public final String data;
        public final String errorDetail;


        private HttpResult(boolean success, String data, String errorDetail) {
            this.success = success;
            this.data = data;
            this.errorDetail = errorDetail;
        }

        private static HttpResult failure(String errorDetail) {
            return new HttpResult(false, null, errorDetail);
        }

        private static HttpResult success(String data) {
            return new HttpResult(true, data, null);
        }
    }
}

