package com.tangpian.sna.tokenizer;

import java.util.ArrayList;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

public class AnsjTokenizer extends AbstractTokenizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tangpian.sna.Tokenizer#tokenString(java.lang.String)
	 */
	public List<String> tokenString(String origin) {
		List<Term> terms = ToAnalysis.paser(origin);
		List<String> result = new ArrayList<String>();
		for (Term term : terms) {
			String word = term.getName().trim();

			result.add(word);
		}

		return result;
	}

}
