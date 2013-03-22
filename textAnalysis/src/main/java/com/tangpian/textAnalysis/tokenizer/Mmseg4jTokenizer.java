package com.tangpian.textAnalysis.tokenizer;

import java.util.List;


public class Mmseg4jTokenizer extends AbstractTokenizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tangpian.sna.Tokenizer#tokenString(java.lang.String)
	 */
	public List<String> tokenString(String origin) {
//		Analyzer analyzer = new ComplexAnalyzer();
//		List<String> words = new ArrayList<String>();
//		Reader reader = new StringReader(origin);
//
//		TokenStream tokenStream;
//		try {
//			tokenStream = analyzer.tokenStream(null, reader);
//			OffsetAttribute offsetAttribute = tokenStream
//					.addAttribute(OffsetAttribute.class);
//			CharTermAttribute charTermAttribute = tokenStream
//					.addAttribute(CharTermAttribute.class);
//
//			while (tokenStream.incrementToken()) {
//				int startOffset = offsetAttribute.startOffset();
//				int endOffset = offsetAttribute.endOffset();
//				words.add(charTermAttribute.toString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return words;
		
		return null;
	}

}
