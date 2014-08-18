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
         * ����Ҫ��URL�µ�URLConnection�Ի��� URLConnection���Ժ����׵Ĵ�URL�õ������磺 // Using   
         *  java.net.URL and //java.net.URLConnection   
         */    
        URL url = new URL("http://www.faircanton.com/message/check.asp");     
        URLConnection connection = url.openConnection();     
        /**   
         * Ȼ���������Ϊ���ģʽ��URLConnectionͨ����Ϊ������ʹ�ã���������һ��Webҳ��   
         * ͨ����URLConnection��Ϊ���������԰����������Webҳ���͡��������������   
         */    
        connection.setDoOutput(true);     
        /**   
         * ���Ϊ�˵õ�OutputStream�������������Լ����Writer���ҷ���POST��Ϣ�У����磺 ...   
         */    
        OutputStreamWriter out = new OutputStreamWriter(connection     
                .getOutputStream(), "8859_1");     
        out.write("username=kevin&password=*********"); //post�Ĺؼ����ڣ�      
        // remember to clean up      
        out.flush();     
        out.close();     
        /**   
         * �����Ϳ��Է���һ����������������POST��    
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:   
         * text/plain Content-type: application/x-www-form-urlencoded   
         * Content-length: 99 username=bob password=someword   
         */    
        // һ�����ͳɹ��������·����Ϳ��Եõ��������Ļ�Ӧ��      
        String sCurrentLine;     
        String sTotalString;     
        sCurrentLine = "";     
        sTotalString = "";     
        InputStream l_urlStream;     
        l_urlStream = connection.getInputStream();     
        // ��˵�е������װ����      
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));     
        while ((sCurrentLine = l_reader.readLine()) != null) {     
            sTotalString += sCurrentLine + "/r/n";     
    
        }     
        System.out.println(sTotalString);     
    }
    public static void main(String args[]) throws IOException {
        // ����һ��html�ַ���
        // String html="<html><head><title>First Parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
        // Document doc=Jsoup.parse(html);

        // �ӱ��ض�ȡhtml�ļ�
        // File in=new File("E://baobiao.html");
        // Document doc1=Jsoup.parse(in, "GBK");

        // ��һ��url����һ��document
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
