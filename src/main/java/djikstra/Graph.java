package djikstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<Node>();

    private PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
    private Set<Node> settledNodes = new HashSet<>();

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public Graph getShortestDistanceFromSource(Graph graph, Node source){


        return graph;
    }


}
