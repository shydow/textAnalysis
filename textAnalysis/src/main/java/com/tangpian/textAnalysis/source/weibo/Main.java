package com.tangpian.textAnalysis.source.weibo;

import java.util.List;
import java.util.TreeSet;

import com.tangpian.textAnalysis.lda.LdaProcessor;
import com.tangpian.textAnalysis.model.Item;
import com.tangpian.textAnalysis.model.Mapping;
import com.tangpian.textAnalysis.model.Topic;
import com.tangpian.textAnalysis.pre.FileReader;
import com.tangpian.textAnalysis.pre.Reader;
import com.tangpian.textAnalysis.view.TopicTimeView;
import com.tangpian.textAnalysis.view.ViewPrinter;

public class Main {
	private static String inputDir = "/tmp/cmcc/input/";
	private static String outputFile = "/tmp/cmcc/output.txt";

	public static void main(String[] args) {

		// read
		System.out.println("reading……");
		Reader reader = new FileReader(new WeiboFileParser(), "gbk");
		List<Item> items = reader.transform(inputDir);

		// lda
		System.out.println("lda……");
		LdaProcessor processor = new LdaProcessor(items,inputDir);
		List<Topic> topics = processor.getTopics();
		List<Mapping> mappings = processor.getMappings();

		// output
		System.out.println("output……");

		//print topic-time view;
		TreeSet<TopicTimeView> result = buildView(topics, mappings, items);
		new ViewPrinter<TopicTimeView>().print(result, outputFile);
		
	}


	private static TreeSet<TopicTimeView> buildView(List<Topic> topics,
			List<Mapping> mappings, List<Item> items) {
		TreeSet<TopicTimeView> result = new TreeSet<TopicTimeView>();

		for (Topic topic : topics) {
			result.add(new TopicTimeView(topic, mappings, items));
		}

		return result;
	}

}
