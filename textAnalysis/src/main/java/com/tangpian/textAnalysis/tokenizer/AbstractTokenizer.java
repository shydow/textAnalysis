package com.tangpian.textAnalysis.tokenizer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTokenizer implements Tokenizer {

	protected abstract List<String> tokenString(String origin);
	
	public String segmentation(String origin) {
		List<String> words = tokenString(origin);
		return filterString(words);
	}
	
	private String filterString(List<String> words) {
		StringBuffer sb = new StringBuffer();
		for (String word : words) {
			if (!isIgnore(word)) {
				sb.append(word+ " ");
			}
		}
		return sb.toString();
		
	}

	private boolean isIgnore(String origin) {
		String stopwords = "http zj zy zyk 、 → @ / : 【 】 ： ！ ； 》 。 - * 《 > … …… 丶";
		for (String word : stopwords.split(" ")) {
			if (origin.equalsIgnoreCase(word)) {
				return true;
			}
		}

		String regex = "\\@[^\\x00-\\xff]+|\\@\\w+|\\w+|\\d+|\\[[^\\x00-\\xff]+\\]";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(origin);
		return matcher.matches();
	}

}