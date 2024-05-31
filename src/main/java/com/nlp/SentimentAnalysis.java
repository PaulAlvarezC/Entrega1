package com.nlp;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentimentAnalysis {
	
	public static void main(String[] args) {
		
		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
		
		String text = "Hola! Me llamo Paul Alvarez. Y realmente no me gusta Guayaquil. Y de verdad que detesto al equipo Barcelona.";
		
		CoreDocument coreDocument = new CoreDocument(text);
		
		stanfordCoreNLP.annotate(coreDocument);
		
		List<CoreSentence> sentences = coreDocument.sentences();
		
		for(CoreSentence sentence: sentences) {
			
			String sentiment = sentence.sentiment();
			System.out.println(sentiment + " - " + sentence);
		}

	}

}
