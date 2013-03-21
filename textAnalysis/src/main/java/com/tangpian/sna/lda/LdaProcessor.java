package com.tangpian.sna.lda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tangpian.sna.lda.algorithm.Estimator;
import com.tangpian.sna.lda.algorithm.LDAOption;
import com.tangpian.sna.model.Item;
import com.tangpian.sna.model.Mapping;
import com.tangpian.sna.model.Topic;
import com.tangpian.sna.tokenizer.AnsjTokenizer;
import com.tangpian.sna.tokenizer.Tokenizer;

public class LdaProcessor {
	private String ldaDir;
	
	//default lda running value;
	private String tokenizedFile = "tmp.txt";
	private String modelName = "model-final";
	private int topicNumber = 50;
	private double alpha = 2;
	private double beta = 0.4;
	private int niters = 100;
	private boolean inf = false;
	private boolean est = true;

	private Tokenizer tokenizer = new AnsjTokenizer();
	
	private LDAOption option = new LDAOption();
	private Result result;

	private void init() {
		option.dir = ldaDir;
		option.dfile = tokenizedFile;
		option.est = est; 
		// /option.estc = true;
		option.inf = inf;
		option.modelName = modelName;
		option.niters = niters;
		option.K = topicNumber;
		option.alpha = alpha;
		option.beta = beta;
	}
	
	private void process() {
		Estimator estimator = new Estimator();
		estimator.init(option);
		result = estimator.estimate();
	}
	
	public LdaProcessor(List<Item> origins,String inputDir) {
		ldaDir = inputDir + "lda/";
		
		perpareFile(origins);
		init();
		process();
	}

	private void perpareFile(List<Item> origins) {
		List<String> tokenizedContents = new ArrayList<String>();
		for (Item item : origins) {
			String content = item.getContent();
			tokenizedContents.add(tokenizer.segmentation(content));
		}

		try {
			File dir = new File(ldaDir);
			dir.delete();
			dir.mkdirs();
			BufferedWriter writer = new BufferedWriter(new FileWriter(ldaDir
					+ tokenizedFile));
			writer.write(tokenizedContents.size() + "\n");
			for (String string : tokenizedContents) {
				writer.write(string + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Topic> getTopics() {
		return result.getTypes();
	}
	
	public List<Mapping> getMappings() {
		return result.getMappings();
	}
	

}
