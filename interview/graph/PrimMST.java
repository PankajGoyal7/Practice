/*
* @Author: pankajgoyal7
* @Date:   2018-06-23 00:27:11
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-23 00:43:32
*/

package interview.graph;

import java.util.*;

public class PrimMST{

	public List<Edge<Integer>> primMST(Graph<Integer> graph){

		BinaryHeap<Vertex<Integer>> minHeap = new BinaryHeap<>();
		
		Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();

		List<Edge<Integer>> result = new ArrayList<>();

		for(Vertex<Integer> v:graph.getAllVertex()){
			minHeap.add(Integer.MAX_VALUE,v);
		}

		Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();

		minHeap.decrease(startVertex, 0);


        //iterate till heap + map has elements in it
        while(!minHeap.empty()){
            //extract min value vertex from heap + map
            Vertex<Integer> current = minHeap.extractMin();

            //get the corresponding edge for this vertex if present and add it to final result.
            //This edge wont be present for first vertex.
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }

            //iterate through all the adjacent vertices
            for(Edge<Integer> edge : current.getEdges()){
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);
                //check if adjacent vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if(minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()){
                    //decrease the value of adjacent vertex to this edge weight.
                    minHeap.decrease(adjacent, edge.getWeight());
                    //add vertex->edge mapping in the graph.
                    vertexToEdge.put(adjacent, edge);
                }
            }
        }
        return result;
    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getSrc().equals(v) ? e.getDest() : e.getSrc();
    }


	public static void main(String[] args) {
		Graph<Integer> graph = new Graph();


		graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimMST prims = new PrimMST();
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge.getSrc().getId() + " " + edge.getDest().getId() +" weight "+edge.getWeight());
        }	
	}
}