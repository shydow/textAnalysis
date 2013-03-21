package com.tangpian.sna.lda;

import java.util.List;

import com.tangpian.sna.model.Mapping;
import com.tangpian.sna.model.Topic;

public class Result {
	private List<Topic> types;
	private List<Mapping> mappings;

	public Result(List<Topic> types, List<Mapping> mappings) {
		this.types = types;
		this.mappings = mappings;
	}

	public List<Topic> getTypes() {
		return types;
	}

	public void setTypes(List<Topic> types) {
		this.types = types;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

}
