package com.tangpian.sna.pre;

import java.util.List;

import com.tangpian.sna.model.Item;

public interface Reader {
	public List<Item> transform(String inputDir);
}
