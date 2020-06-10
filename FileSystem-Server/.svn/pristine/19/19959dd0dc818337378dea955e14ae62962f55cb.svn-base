package com.free4lab.filesystem.util;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.*;

/**
 * Created by lizhenhao on 2017/3/7.
 */
public class TikaUtil {

    public static Parser parserGenerator(String fileName) {
        String[] temp = fileName.split("\\.");
        String fileType = temp[temp.length-1].toLowerCase();
        Parser parser;
        if(fileType.equals("txt") || fileType.equals("doc")||fileType.equals("docx")) {
            parser = new AutoDetectParser();
        }
        else if(fileType.equals("pdf")) {
            parser = new AutoDetectParser();
        }
        else if(fileType.equals("xlsx")) {
            parser = new AutoDetectParser();
        }
        else if(fileType.equals("jpg")||fileType.equals("jpeg")||fileType.equals("png")) {
            //图片不做处理
            parser = null;
        }
        else if(fileType.equals("mp3")||fileType.equals("mp4")) {
            //音频不做处理
            parser = null;
        }
        else {
            parser = new AutoDetectParser();
        }

        return parser;

    }

    public static String parseFile(InputStream inputStream,String fileName) {
        //建立解析参数
        Parser parser = parserGenerator(fileName);
        if(parser == null) return null;
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try {
            ParseContext context = new ParseContext();
                //解析
            parser.parse(inputStream,handler,metadata,context);
            return handler.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseFile(InputStream inputStream) {
        Tika tika = new Tika();
        try {
            String content = tika.parseToString(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) throws Exception {

//
//        File file = new File("C:/Users/lizhenhao/Desktop/英语演讲稿.docx");//
//        TXTParser parser = new TXTParser();
//        BodyContentHandler handler = new BodyContentHandler();
//        Metadata metadata = new Metadata();
//        FileInputStream inputstream = new FileInputStream(file);
//
//
//        ParseContext context = new ParseContext();
//
//        //解析
//        parser.parse(inputstream,handler,metadata,context);
//        System.out.println(handler.toString());
        File file =new File("K:\\middleware\\round2\\testdata\\RESULT.rs");
        InputStream in;
        OutputStream out;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream("K:\\middleware\\round2\\testdata\\testsearch.rs");
            byte[] buffer = new byte[1024];
            int len = 0;

            while((len = in.read(buffer))!= -1) {
                out.write(buffer,0,len);
            }
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        String content = parseFile(file);
//        System.out.println(content);
    }


}
