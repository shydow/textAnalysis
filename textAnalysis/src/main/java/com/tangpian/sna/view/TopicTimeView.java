package com.tangpian.sna.view;

import java.util.ArrayList;
import java.util.List;

import com.tangpian.sna.model.Item;
import com.tangpian.sna.model.Mapping;
import com.tangpian.sna.model.Topic;

/**
 * 
 * 分类id|数量|最大概率|关键词|内容|按时间的数量 二级使用空格分割
 * 
 * @author shydow
 * 
 */
public class TopicTimeView implements Comparable, View {
	private int topicId;
	private int count;
	private double maxProbability;
	private String topicWords;
	private String contents;
	private int[] subCount;

	private static final int MAX_CONTENT_NUMBER = 10;
	private static final double THRESHOLD = 0.06;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getMaxProbability() {
		return maxProbability;
	}

	public void setMaxProbability(double maxProbability) {
		this.maxProbability = maxProbability;
	}

	public String getTopicWords() {
		return topicWords;
	}

	public void setTopicWords(String topicWords) {
		this.topicWords = topicWords;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int[] getSubCount() {
		return subCount;
	}

	public void setSubCount(int[] subCount) {
		this.subCount = subCount;
	}

	public int compareTo(Object arg0) {
		TopicTimeView other = (TopicTimeView) arg0;
		if (this.topicId == other.topicId)
			return 0;

		// 先按照count排序，相同count按照id排序
		int result = this.count > other.count ? -1
				: (this.count == other.count ? 0 : 1);
		if (result == 0) {
			result = this.topicId > other.topicId ? -1
					: (this.topicId == other.topicId ? 0 : 1);
		}
		return result;

	}

	public TopicTimeView(Topic topic, List<Mapping> mappings, List<Item> items) {
		List<String> dates = buildDates(items);

		this.setTopicId(topic.getId());

		int count = 0;
		double maxProbability = 0;
		List<String> contents = new ArrayList<String>(0);
		int[] subCount = new int[dates.size()];

		for (Mapping mapping : mappings) {
			if (topic.getId() == mapping.getBelongedTopic()
					&& mapping.getMaxProbability() >= THRESHOLD) {
				count++;
				maxProbability = mapping.getMaxProbability();
				Item item = findItem(items, mapping.getItemId());
				if (contents.size() < MAX_CONTENT_NUMBER) {
					contents.add(item.getContent());
				}
				for (int i = 0; i < subCount.length; i++) {
					if (item.getTime().substring(0, 10).equals(dates.get(i))) {
						subCount[i]++;
					}
				}
			}
		}

		this.setCount(count);
		this.setMaxProbability(maxProbability);

		StringBuffer keywords = new StringBuffer();
		for (String keyword : topic.getKeywords().keySet()) {
			keywords.append(keyword + " ");
		}
		this.setTopicWords(keywords.toString());

		StringBuffer contentBuffer = new StringBuffer();
		for (int i = 0; i < contents.size(); i++) {
			contentBuffer.append(contents.get(i) + "  ");
		}
		this.setContents(contentBuffer.toString());
		this.setSubCount(subCount);

	}

	private static List<String> dates = new ArrayList<String>();

	private static List<String> buildDates(List<Item> items) {
		for (Item item : items) {
			String time = item.getTime().substring(0, 10);
			if (!dates.contains(time)) {
				dates.add(time);
			}
		}
		return dates;
	}

	private Item findItem(List<Item> items, int itemId) {
		for (Item item : items) {
			if (item.getId() == itemId) {
				return item;
			}
		}
		return null;
	}

	public String printLine() {
		StringBuffer line = new StringBuffer();
		line.append(this.getTopicId() + "|");
		line.append(this.getCount() + "|");
		line.append(this.getMaxProbability() + "|");
		line.append(this.getTopicWords() + "|");
		for (int subCount : this.getSubCount()) {
			line.append(subCount + "|");
		}
		line.append(this.getContents() + "|");
		return line.toString();
	}

	public String printTableTitle() {
		StringBuffer firstLine = new StringBuffer();
		firstLine.append("分类id|数量|最大概率|关键词|内容|");
		for (String string : dates) {
			firstLine.append(string + "|");
		}
		firstLine.append("\n");
		return firstLine.toString();
	}

}
