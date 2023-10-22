# CS7IS3 - Continuous Assessment Part 1

Apache Lucene Search Engine for Cranfield Collection.

Kaiyu Chen - 20100199 - chenka@tcd.ie

## Usage

1. Clone the repository

   ```cmd
   git clone https://github.com/cky008/CS7IS3A1.git
   ```

2. Navigate to the project root directory

   ```cmd
   cd CS7IS3A1
   ```

3. Compile and package the project:

   ```cmd
   mvn clean install
   mvn package
   ```

4. Run the application

   ```cmd
   java -jar target/CS7IS3A1-1.1.jar
   ```

5. Navigate to the trec_eval folder and use `make` to generate an executable trec_eval

   ```cmd
   cd trec_eval
     make
   ```

6. Evaluate the search engine's performance using trec_eval

   ```cmd
   ./trec_eval [path_to_qrel_file] [path_to_results_file]
   ```

   Here, the [path_to_qrel_file] should be **../cran/QRelsCorrectedforTRECeval,** and [path_to_results_file] should be**../output/[file_name]**. Below is some sample for usage:

   ```cmd
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-EnglishAnalyzer–BM25.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-EnglishAnalyzer–Boolean.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-EnglishAnalyzer–Classic.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-EnglishAnalyzer–IBS.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-EnglishAnalyzer–LMDirichlet.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-StandardAnalyzer–BM25.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-StandardAnalyzer–Boolean.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-StandardAnalyzer–Classic.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-StandardAnalyzer–IBS.txt
   ./trec_eval ../cran/QRelsCorrectedforTRECeval ../output/output-StandardAnalyzer–LMDirichlet.txt
   ```

## Performance

#### Table

| MAP          | Standard Analyzer | English Analyzer |
| ------------ | ----------------- | ---------------- |
| BM25         | 0.3511            | 0.4155           |
| Classic(VSM) | 0.201             | 0.3634           |
| Boolean      | 0.2238            | 0.3365           |
| LMDirichlet  | 0.32              | 0.3316           |
| IBS          | 0.3243            | 0.4053           |

#### Figure

![MAP for different Similarities with Standard & English Analyzer](./assets/CleanShot%202023-10-22%20at%2004.48.01.png)