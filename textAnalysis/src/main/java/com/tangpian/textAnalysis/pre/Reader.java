package com.tangpian.textAnalysis.pre;

import java.util.List;

import com.tangpian.textAnalysis.model.Item;

public interface Reader {
	public List<Item> transform(String inputDir);
}
