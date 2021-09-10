package commons.httpComponents.httpclient;


import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie2;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


/**
 * @author Jion
 *  测试Get请求
 */
public class SendGetRequestExample {

    /** 简单的请求 */
    @Test
    public void SendGetRequest() throws IOException {

        // 请求客户端
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // Get请求
        HttpGet httpGet = new HttpGet("http://news.baidu.com/");

        // 请求头信息
        httpGet.setHeader("Accept","text/html");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");

        // 执行Get请求,并获得响应
        CloseableHttpResponse response = httpclient.execute(httpGet);

        // 强制终止请求
//        httpGet.abort();

        // 状态,  HTTP/1.1 200 OK
        StatusLine statusLine = response.getStatusLine();
        int status = statusLine.getStatusCode();
        System.out.println( "响应状态: " + status);
        // 全部头信息
        Header[] headers = response.getAllHeaders();
        // 指定响应头信息,可能一个Key对应多个Value
        headers = response.getHeaders("Set-Cookie");
        // 头信息
        System.out.println("Set-Cookie响应头信息:  " +
                            headers[0].getName() + ' ' + headers[0].getValue());
        // 头信息集合
        HeaderElement[] elements = headers[0].getElements();
        System.out.println("头信息集合:" +  elements[0].toString());

        // 响应体信息
        HttpEntity entity = response.getEntity();
        // 编码规则
        Header contentEncoding = entity.getContentEncoding();
        System.out.println("响应编码: " + contentEncoding);

        // 响应类型,通过 Header类展示
        Header contentType = entity.getContentType();
        System.out.println("响应类型: " + contentType.toString());
        // 长度
        System.out.println(entity.getContentLength());
        // 响应正文,通过IO流形式
        InputStream inputStream = entity.getContent();
        String content = IOUtils.toString(inputStream, "UTF-8");
        System.out.println("响应体 " + content);
        // 关闭响应流
        inputStream.close();
        response.close();
    }

    /** 携带请求认证 */
    @Test
    public void SendGetRequestWithAuth() throws IOException{

        // 认证
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("www.baidu.com", 80),
                new UsernamePasswordCredentials("user", "passwd"));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        httpclient.close();
    }

    /** 代理请求 */
    @Test
    public void SendGetRequestByProxy() throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 目标页面
        HttpHost target = new HttpHost("news.baidu.com", 80, "https");
        // 代理服务器
        HttpHost proxy = new HttpHost("127.0.0.1", 80, "http");
        // 代理配置
        RequestConfig config = RequestConfig.custom()
                    .setProxy(proxy)
                    .setConnectTimeout(10000)
                    .build();
        // 访问代理服务器
        HttpGet request = new HttpGet("/");
        request.setConfig(config);
        // 代理请求
        CloseableHttpResponse response = httpclient.execute(target, request);

        System.out.println("响应状态: " + response.getStatusLine());
        System.out.println("响应内容:" + EntityUtils.toString(response.getEntity()));
        response.close();
        httpclient.close();
    }

    /** 携带Cookie的请求 */
    @Test
    public void SendGetRequestWithCookie() throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // Cookie信息
        CookieStore cookieStore = new BasicCookieStore();
        // 增加cookie
//        Cookie cookie = new BasicClientCookie2("user","jion");
//        cookieStore.addCookie(cookie);

        // 请求上下文
        HttpClientContext localContext = HttpClientContext.create();
        // 绑定Cookie信息
        localContext.setCookieStore(cookieStore);

        HttpGet httpget = new HttpGet("https://news.baidu.com/");
        System.out.println("请求状态: " + httpget.getRequestLine());

        // 发送携带上下文信息的请求
        CloseableHttpResponse response = httpclient.execute(httpget, localContext);

        System.out.println("响应状态: " + response.getStatusLine());

        // 解析响应的Cookies
        List<Cookie> cookies = cookieStore.getCookies();
        for (int i = 0; i < cookies.size(); i++) {
            System.out.println("获得Cookie  : " + cookies.get(i).toString());
        }
        EntityUtils.consume(response.getEntity());

        // 关闭请求
        response.close();
        httpclient.close();
    }

    /** 发送请求并下载 */
    @Test
    public void sendGetRequestDownload() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet("https://blog.jionjion.top/images/avatar.gif");

        System.out.println("请求状态: " + httpget.getRequestLine());

        // 发送携带上下文信息的请求
        CloseableHttpResponse response = httpclient.execute(httpget);

        System.out.println("响应状态: " + response.getStatusLine());

        // 保存响应内容
        InputStream inputStream = response.getEntity().getContent();
        OutputStream outputStream = new FileOutputStream(new File("S:\\jion.gif"));
        IOUtils.copy(inputStream, outputStream);

        // 关闭请求
        inputStream.close();
        outputStream.close();
        EntityUtils.consume(response.getEntity());
        response.close();
        httpclient.close();

    }


}
