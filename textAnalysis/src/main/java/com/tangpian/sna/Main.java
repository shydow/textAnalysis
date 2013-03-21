package com.tangpian.sna;

import java.util.List;
import java.util.TreeSet;

import com.tangpian.sna.lda.LdaProcessor;
import com.tangpian.sna.model.Item;
import com.tangpian.sna.model.Mapping;
import com.tangpian.sna.model.Topic;
import com.tangpian.sna.pre.CSVFileParser;
import com.tangpian.sna.pre.CSVFileReader;
import com.tangpian.sna.pre.Reader;
import com.tangpian.sna.view.TopicTimeView;
import com.tangpian.sna.view.ViewPrinter;

public class Main {
	private static String inputDir = "/tmp/cmcc/input/";
	private static String outputFile = "/tmp/cmcc/output.txt";

	public static void main(String[] args) {

		// read
		System.out.println("reading……");
		Reader reader = new CSVFileReader(new CSVFileParser());
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
