package thinkDataStructures.ch6;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class WikiNodeExample {

    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        // download and parse the document
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        // select the content text and pull out the paragraphs.
        org.jsoup.nodes.Element content = doc.getElementById("mw-content-text");

        // TODO: avoid selecting paragraphs from sidebars and boxouts
        Elements paras = content.select("p");
        Element firstPara = paras.get(1);

        recursiveDFS(firstPara);
        System.out.println();
//
//        iterativeDFS(firstPara);
//        System.out.println();

        Iterable<Node> iter = new WikiNodeIterable(firstPara);
        for (Node node: iter) {
            if (node instanceof TextNode) {
                System.out.print(node);
            }
        }
    }

    private static void iterativeDFS(org.jsoup.nodes.Element root) {
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);

        // if the stack is empty, we're done
        while (!stack.isEmpty()) {

            // otherwise pop the next Node off the stack
            Node node = stack.pop();
            if (node instanceof TextNode) {
                System.out.print(node);
            }

            // push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            Collections.reverse(nodes);

            for (Node child: nodes) {
                stack.push(child);
            }
        }
    }

    private static void recursiveDFS(Node node) {
        if (node instanceof TextNode) {
            System.out.print(node);
        }
        for (Node child: node.childNodes()) {
            recursiveDFS(child);
        }
    }
}