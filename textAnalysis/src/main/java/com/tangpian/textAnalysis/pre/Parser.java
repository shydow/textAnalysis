package com.tangpian.textAnalysis.pre;

import com.tangpian.textAnalysis.model.Item;

public interface Parser {
	public Item parse(String line);
}
