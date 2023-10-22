package tcd.ie.chenka.s;

import org.apache.lucene.analysis.Analyzer;
import tcd.ie.chenka.s.cEnum.AnalyzerType;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Analyzer analyzer = setAnalyzer();
        int simType = CranProcessor.indexer(analyzer);
        Searcher.search(simType, analyzer);
        System.out.println("PROGRAM TERMINATED");
    }

    private static Analyzer setAnalyzer() {
        System.out.println("Please select the type of Analyzer:\n1. Standard Analyzer\n2. English Analyzer");
        int choice = new Scanner(System.in).nextInt();
        return AnalyzerType.getAnalyzerByChoice(choice);
    }
}
