package djikstra;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {

    private String name;
    private LinkedList<Node> shortestPath = new LinkedList<Node>();
    private HashMap<Node, Integer> adjacentNodes = new HashMap<Node, Integer>();

    private Integer distance = Integer.MAX_VALUE;


    public void addDestination(Node node, int distance){
        this.adjacentNodes.put(node,distance);
    }
    public Node(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public HashMap<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(HashMap<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
