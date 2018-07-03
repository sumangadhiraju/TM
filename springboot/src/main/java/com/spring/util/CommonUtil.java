package com.spring.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.spring.resources.Resources;


public class CommonUtil {
	
	public static String getResources(String filename) {
    	String path = "";
    	try {
    		URL r = Resources.class.getResource("");
    		path = URLDecoder.decode(r.getFile(), "UTF-8");
    		
    		if(path.startsWith("/")) {
    			path.replaceFirst("/", "");
    		}
    	}catch(UnsupportedEncodingException e) {
    		System.out.println(e);
    		
    	}
    	
    	return path + filename;
    }
	
	public static NodeList getNodeList(String fileName, String tagName) {
		NodeList nList = null;
		try {
			File file = new File(CommonUtil.getResources(fileName));
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName(tagName);
		} catch (Exception e) {
			System.out.println(e);
		}
		return nList;
	}
}
