package com.net.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Test {
    public static void testPost() throws IOException {     
        /**   
         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using   
         *  java.net.URL and //java.net.URLConnection   
         */    
        URL url = new URL("http://www.faircanton.com/message/check.asp");     
        URLConnection connection = url.openConnection();     
        /**   
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。   
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：   
         */    
        connection.setDoOutput(true);     
        /**   
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...   
         */    
        OutputStreamWriter out = new OutputStreamWriter(connection     
                .getOutputStream(), "8859_1");     
        out.write("username=kevin&password=*********"); //post的关键所在！      
        // remember to clean up      
        out.flush();     
        out.close();     
        /**   
         * 这样就可以发送一个看起来象这样的POST：    
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:   
         * text/plain Content-type: application/x-www-form-urlencoded   
         * Content-length: 99 username=bob password=someword   
         */    
        // 一旦发送成功，用以下方法就可以得到服务器的回应：      
        String sCurrentLine;     
        String sTotalString;     
        sCurrentLine = "";     
        sTotalString = "";     
        InputStream l_urlStream;     
        l_urlStream = connection.getInputStream();     
        // 传说中的三层包装阿！      
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));     
        while ((sCurrentLine = l_reader.readLine()) != null) {     
            sTotalString += sCurrentLine + "/r/n";     
    
        }     
        System.out.println(sTotalString);     
    }
    public static void main(String args[]) throws IOException {
        // 解析一个html字符串
        // String html="<html><head><title>First Parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
        // Document doc=Jsoup.parse(html);

        // 从本地读取html文件
        // File in=new File("E://baobiao.html");
        // Document doc1=Jsoup.parse(in, "GBK");

        // 从一个url加载一个document
        Document doc2 =
                Jsoup.connect(
                        "http://api.map.baidu.com/ag/coord/convert?from=2&to=4&x=116.254615&y=29.814476")
                        .get();
        // Element content=doc2.getElementById("plan5");
        // Elements links=content.getElementsByTag("a");
        // String linkHref=null;
        // String linkText=null;
        // for(Element link:links){
        // linkHref=link.attr("href");
        // linkText=link.text();
        // }
        // System.out.println("linkHref"+linkHref);
        // System.out.println("linkText:"+linkText);
        String el = doc2.body().text();
        JSONObject jObject=JSONObject.fromObject(el);
        System.out.println(el);
        System.out.println(jObject.getString("x"));
        
    }
}
