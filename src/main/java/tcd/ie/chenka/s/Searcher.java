package tcd.ie.chenka.s;

import tcd.ie.chenka.s.cEnum.SimilarityType;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.FSDirectory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Paths;

public class Searcher {
    private static final String INDEX_DIR = "lucene_index";
    public static String ANALYZER_NAME = "";

    public static void search(int simType, Analyzer analyzer) throws Exception {
        try (DirectoryReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX_DIR)))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            searcher.setSimilarity(SimilarityType.getSimilarityByChoice(simType));

            MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[]{"title", "author", "bib", "content"}, analyzer);

            System.out.println("Querying...");
            try (BufferedReader queryReader = CranProcessor.getQueryReader();
                 BufferedWriter queryWriter = CranProcessor.getQueryWriter(ANALYZER_NAME, simType)) {

                String queryStr;
                int queryNumber = 0;

                while ((queryStr = CranProcessor.extractNextQuery(queryReader)) != null && !queryStr.isEmpty()) {
                    queryNumber++;
                    Query query = queryParser.parse(QueryParser.escape(queryStr));
                    ScoreDoc[] hits = searcher.search(query, 50).scoreDocs;
                    CranProcessor.writeSearchResult(queryWriter, queryNumber, hits, searcher);
                }

                System.out.println("Querying finished, total queries:" + queryNumber);
            }
        }
    }
}
