package thinkDataStructures.ch8;

import org.jsoup.select.Elements;
import thinkDataStructures.ch6.WikiFetcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Index {
    private Map<String, Set<TermCounter>> index = new HashMap<>();

    public void add(String term, TermCounter tc) {
        Set<TermCounter> set = get(term);
        if(set == null){
            index.put(term, new HashSet<TermCounter>());
        }
        else set.add(tc);
    }

    private Set<TermCounter> get(String term) {
        return index.get(term);
    }

    public void printIndex() {
        for (String term: index.keySet()) {
            System.out.println(term);
            Set<TermCounter> tcs = get(term);
            for (TermCounter tc: tcs) {
                System.out.println("    " + tc.getLabel() + " " + tc.get(term));
            }
        }
    }

    public void indexPage(String url, Elements paragraphs) {
        TermCounter tc = new TermCounter(url);
        tc.processElements(paragraphs);
        for (String term : tc.keySet()) add(term, tc);
    }

    public static void main(String[] args) throws IOException {
        WikiFetcher wf = new WikiFetcher();
        Index indexer = new Index();

        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Elements paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        url = "https://en.wikipedia.org/wiki/Programming_language";
        paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        indexer.printIndex();
    }
}
