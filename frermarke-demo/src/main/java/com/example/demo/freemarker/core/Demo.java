package com.example.demo.freemarker.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

public class Demo {

	public static void main(String[] args) {
		String path = new ClassLoader().getResource("").getPath();
		File file = new File(path);
		Version version = new Version("2.3.20");
		Configuration cfg = new Configuration(version);
		cfg.setDefaultEncoding("UTF-8");
		try {
			cfg.setDirectoryForTemplateLoading(file);
			Template tpt = cfg.getTemplate("demo.ftl");
			Map<String,Object> map = new HashMap<>();
			map.put("title", "成都物联网公司");
			map.put("date", "2017-08-12");
			map.put("name", "李春梅");
			map.put("email", "lishi@123.com");
			map.put("company", "红杉树");
			File newFile= new File("C:\\Users\\Administrator\\Desktop\\xxx.doc");
			FileOutputStream fos = new FileOutputStream(newFile);
			OutputStreamWriter ops = new OutputStreamWriter(fos);
			Writer wr = new BufferedWriter(ops);
			tpt.process(map, wr);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
