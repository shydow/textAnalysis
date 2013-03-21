package com.tangpian.sna.tokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class PaodingTokenizer extends AbstractTokenizer {

	public List<String> tokenString(String origin) {
		List<String> result = new ArrayList<String>();
		Analyzer analyzer = new PaodingAnalyzer();

		try {
			TokenStream tokenStream = analyzer.tokenStream(origin,
					new StringReader(origin));

			OffsetAttribute offsetAttribute = tokenStream
					.addAttribute(OffsetAttribute.class);
			CharTermAttribute charTermAttribute = tokenStream
					.addAttribute(CharTermAttribute.class);

			while (tokenStream.incrementToken()) {
				int startOffset = offsetAttribute.startOffset();
				int endOffset = offsetAttribute.endOffset();
				result.add(charTermAttribute.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
