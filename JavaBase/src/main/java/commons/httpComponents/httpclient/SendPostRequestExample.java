package commons.httpComponents.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Jion
 *  Post请求
 */
public class SendPostRequestExample {

    /** 携带附件请求 */
    @Test
    public void SendGetRequestWithAttachment() throws IOException {

        // 附件
        String filePath = "";
        File file = new File(filePath);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://httpbin.org/post");

        // 带有数据流的请求
        InputStreamEntity reqEntity = new InputStreamEntity(
            new FileInputStream(file), -1, ContentType.APPLICATION_OCTET_STREAM);
        reqEntity.setChunked(true);

        // 或者使用文件实体类
//        FileEntity entity = new FileEntity(file, ContentType.create("binary/octet-stream","UTF-8"));

        // 携带附件
        httppost.setEntity(reqEntity);

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httppost);

        System.out.println("响应状态: " + response.getStatusLine());
        System.out.println("响应内容: " + EntityUtils.toString(response.getEntity()));

        // 关闭请求
        response.close();
        httpclient.close();
    }

    @Test
    public void SendPostRequestByForm() throws IOException, URISyntaxException {

        // 登录后回调存入Cookies
        BasicCookieStore cookieStore = new BasicCookieStore();
        // 客户端
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();

        // 请求
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI("https://www.baidu.com/"))
                .addParameter("username", "admin")
                .addParameter("password", "123456")
                .build();

        CloseableHttpResponse response = httpclient.execute(login);
            HttpEntity entity = response.getEntity();

            System.out.println("响应状态: " + response.getStatusLine());
            EntityUtils.consume(entity);

            List<Cookie> cookies = cookieStore.getCookies();
            for(Cookie cookie : cookies){
                System.out.println("获得Cookie " + cookie.toString());
            }
            response.close();
        httpclient.close();
    }

    /** 携带认证的请求 */
    public void sendPostRequestWithBasicAuthentication() throws IOException{

        // 代理服务器
        HttpHost target = new HttpHost("127.0.0.1", 80, "http");
        // 认证代理
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("admin", "123456"));
        // 客户端
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        // 认证缓存
        AuthCache authCache = new BasicAuthCache();
        // 基础认证
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        // 请求上下文
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);

        //
        HttpPost httpPost = new HttpPost("http://www.baidu.com");

        System.out.println("请求状态: " + httpPost.getRequestLine());
        System.out.println("目标代理: " + target);

        CloseableHttpResponse response = httpclient.execute(target, httpPost, localContext);
        System.out.println("响应状态: " + response.getStatusLine());
        System.out.println("响应文本" + EntityUtils.toString(response.getEntity()));
        response.close();
        httpclient.close();
    }
}
