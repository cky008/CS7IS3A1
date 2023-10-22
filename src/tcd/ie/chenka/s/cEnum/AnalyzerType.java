package tcd.ie.chenka.s.cEnum;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import tcd.ie.chenka.s.Searcher;

public enum AnalyzerType {
    STANDARD(1, new StandardAnalyzer(), "StandardAnalyzer–"),
    ENGLISH(2, new EnglishAnalyzer(), "EnglishAnalyzer–");

    private final int choice;
    private final Analyzer analyzer;
    private final String name;

    AnalyzerType(int choice, Analyzer analyzer, String name) {
        this.choice = choice;
        this.analyzer = analyzer;
        this.name = name;
    }

    public static Analyzer getAnalyzerByChoice(int choice) {
        for (AnalyzerType type : values()) {
            if (type.choice == choice) {
                System.out.println("Selected " + type.name);
                Searcher.ANALYZER_NAME = type.name;
                return type.analyzer;
            }
        }
        System.out.println("Default selected - Standard Analyzer");
        Searcher.ANALYZER_NAME = STANDARD.name;
        return STANDARD.analyzer;
    }
}
