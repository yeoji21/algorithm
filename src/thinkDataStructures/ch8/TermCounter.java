package thinkDataStructures.ch8;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import thinkDataStructures.ch6.WikiFetcher;
import thinkDataStructures.ch6.WikiNodeIterable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TermCounter {
    private Map<String, Integer> map;
    private String label;

    public String getLabel() {
        return label;
    }

    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.fetchWikipedia(url);

        TermCounter counter = new TermCounter(url.toString());
        counter.processElements(paragraphs);
        counter.printCounts();
    }

    public TermCounter(String label) {
        this.label = label;
        this.map = new HashMap<>();
    }

    public void put(String term, int count) {
        map.put(term, count);
    }

    public int get(String term) {
        return map.getOrDefault(term, 0);
    }

    public void increaseTerm(String term) {
        put(term, get(term) + 1);
    }

    public void processElements(Elements paragraphs) {
        for (Node node : paragraphs) processTree(node);
    }

    private void processTree(Node root) {
        for (Node node : new WikiNodeIterable(root)) {
            if(node instanceof TextNode) processText(((TextNode) node).text());
        }
    }

    private void processText(String text) {
        String[] array = text.replaceAll("\\pP", " ").toLowerCase().split("\\s+");
        for (int i = 0; i < array.length; i++) {
            increaseTerm(array[i]);
        }
    }

    public void printCounts() {
        for (String key: map.keySet()) {
            Integer count = get(key);
            System.out.println(key + ", " + count);
        }
        System.out.println("Total of all counts = " + map.size());
    }

    public Set<String> keySet() {
        return map.keySet();
    }
}
