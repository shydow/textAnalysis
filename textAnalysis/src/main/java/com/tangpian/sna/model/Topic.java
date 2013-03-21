package com.tangpian.sna.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * id从0开始
 * @author shydow
 *
 */
public class Topic {
	private int id;
	private TreeMap<String, Double> keywords = new TreeMap<String, Double>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TreeMap<String, Double> getKeywords() {
		return keywords;
	}

	public void setKeywords(TreeMap<String, Double> keywords) {
		this.keywords = keywords;
	}

	public void addKeyword(String word, double probability) {
		keywords.put(word, probability);
	}


}
