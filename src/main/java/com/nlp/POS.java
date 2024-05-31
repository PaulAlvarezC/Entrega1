package com.nlp;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

//Part of Speech
public class POS {
	
	public static void main(String[] args) {
		
		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
		
		String text = "TODO ESTO ME PREOCUPA MUJER PERO MUCHO ME SONROJARIA ANTE LOS TROYANOS Y LAS TROYANAS DE ROZAGANTES PELOS SI COMO UN COBARDE HUYERA DEL COMBATE Y TAMPOCO MI CORAZON ME INCITA A ELLO QUE SIEMPRE SUPE SER VALIENTE Y PELEAR EN PRIMERA FILA MANTENIENDO LA INMENSA GLORIA DE MI PADRE Y DE MI MISMO";
		//String text = "IVE IO GEWS UYI EUYIO ERS LEFMEQ OEW QYFIW QIKEHS WY VSGMS E OE XMIVVE C TSV XSHSW OSW OYKEVIW.";
		
		CoreDocument coreDocument = new CoreDocument(text);
		
		stanfordCoreNLP.annotate(coreDocument);
		
		List<CoreLabel> coreLabelList = coreDocument.tokens();
		
		for(CoreLabel coreLabel: coreLabelList) {
			String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
			System.out.println(coreLabel.originalText() + " = " + pos);
		}

	}

}
