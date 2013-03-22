package com.tangpian.textAnalysis.lda;

import java.util.List;

import com.tangpian.textAnalysis.model.Mapping;
import com.tangpian.textAnalysis.model.Topic;

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
