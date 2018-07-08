package graph.model;

import java.util.List;

public class GraphVertex<T>{

    private T data;
    private List<T> adjacentVertices;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<T> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
}
