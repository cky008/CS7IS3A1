package tcd.ie.chenka.s.cEnum;

import org.apache.lucene.search.similarities.*;

public enum SimilarityType {
    BM25(1, new BM25Similarity(), "BM25"),
    CLASSIC(2, new ClassicSimilarity(), "Classic (VSM)"),
    BOOLEAN(3, new BooleanSimilarity(), "Boolean"),
    LMDIRICHLET(4, new LMDirichletSimilarity(), "LMDirichlet"),
    IBS(5, new IBSimilarity(new DistributionLL(), new LambdaDF(), new NormalizationH1()) , " IBS");


    private final int choice;
    private final Similarity similarity;
    private final String name;

    SimilarityType(int choice, Similarity similarity, String name) {
        this.choice = choice;
        this.similarity = similarity;
        this.name = name;
    }

    public static Similarity getSimilarityByChoice(int choice) {
        for (SimilarityType type : values()) {
            if (type.choice == choice) {
                System.out.println("Selected " + type.name + " for scoring.");
                return type.similarity;
            }
        }
        System.out.println("Default selected - BM25 scoring.");
        return BM25.similarity;
    }
}
