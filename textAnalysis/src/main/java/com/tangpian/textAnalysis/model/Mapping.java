package com.tangpian.textAnalysis.model;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	public Mapping(int itemId) {
		this.itemId = itemId;
	}

	private int itemId;

	// Integer 为topic id；
	private Map<Integer, Double> probabilities = new HashMap<Integer, Double>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Map<Integer, Double> getMapping() {
		return probabilities;
	}

	public void setMapping(Map<Integer, Double> probabilities) {
		this.probabilities = probabilities;
	}

	public void addMapping(int typeId, double probability) {
		probabilities.put(typeId, probability);
	}

	public double getMaxProbability() {
		double max = 0;
		for (int id : probabilities.keySet()) {
			if (probabilities.get(id) > max) {
				max = probabilities.get(id);
			}
		}
		return max;
	}

	public int getBelongedTopic() {
		int maxId = 0;
		double max = 0;
		for (int id : probabilities.keySet()) {
			if (probabilities.get(id) > max) {
				max = probabilities.get(id);
				maxId = id;
			}
		}
		return maxId;

	}

}
