package thinkDataStructures.ch6;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 15);
    }

    public static void testConjecture(String destination, String source, int limit) throws IOException {
        String url = source;
        for (int i = 0; i < limit; i++) {
            if(visited.contains(url)){
                System.out.println("We're in loop, exiting.");
                return;
            }
            else visited.add(url);

            Element element = getFirstValidLink(url);
            if(element == null){
                System.out.println("got to a page with no valid links");
                return;
            }
            System.out.println("**" + element.text() + "**");
            url = element.attr("abs:href");

            if (url.equals(destination)) {
                System.out.println("Eureka!");
                break;
            }
        }
    }

    private static Element getFirstValidLink(String url) throws IOException {
        System.out.printf("Fetching %s...", url);
        Elements paragraphs = wf.fetchWikipedia(url);
        WikiParser wp = new WikiParser(paragraphs);
        return wp.findFirstLink();
    }
}