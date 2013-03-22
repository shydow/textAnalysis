package com.tangpian.textAnalysis.pre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tangpian.textAnalysis.model.Item;

public class FileReader implements Reader {
	
	private Parser parser;
	private String fileCharset = "gbk";
	

	private int i = 0;
	public FileReader(Parser parser, String fileCharset) {
		this.parser = parser;
		this.fileCharset = fileCharset;
	}

	public List<Item> transform(String inputDir) {
		List<Item> origins = new ArrayList<Item>();
		
		File dir = new File(inputDir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.getName().endsWith(".txt")) {
				try {
					origins.addAll(readFile(file.getAbsolutePath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return origins;

	}


	private List<Item> readFile(String string) throws IOException {
		List<Item> result = new ArrayList<Item>();

		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				string), fileCharset);
		BufferedReader reader = new BufferedReader(isr);
		String tempString = null;

		while ((tempString = reader.readLine()) != null) {
			Item item = parser.parse(tempString);
			item.setId(i);
			result.add(item);
			i++;			
		}
		reader.close();
		isr.close();

		return result;
	}

}
