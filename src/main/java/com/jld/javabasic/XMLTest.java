package com.jld.javabasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLTest {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {


        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("demo.xml"));
        String xpath = "//target";
        System.out.println(document.selectNodes(xpath).size());
    }
}
