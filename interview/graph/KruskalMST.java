/*
* @Author: pankajgoyal7
* @Date:   2018-06-20 23:13:04
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-23 00:51:37
*/
package interview.graph;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


public class KruskalMST{	

	public List<Edge<Integer>> getMST(Graph graph){

                List<Edge<Integer>> allEdges = graph.getAllEdges();
                
                allEdges.sort(Comparator.comparing(Edge::getWeight));

                DisjointSet ds = new DisjointSet();

                Collection<Vertex<Integer>> vertices = (Collection<Vertex<Integer>>) graph.getAllVertex();

                for (Vertex<Integer> vertex : vertices) {
                        ds.makeSet(vertex.getId());
                }

                List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

                for(Edge<Integer> edge:allEdges){
                        long root1 = ds.findSet(edge.getSrc().getId());
                        long root2 = ds.findSet(edge.getDest().getId());
                        if(root1 == root2){
                                continue;
                        }else{
                                resultEdge.add(edge);
                                ds.union(edge.getSrc().getId(),edge.getDest().getId());
                        }
                }
                return resultEdge; 
        }


        public static void main(String[] args) {

              Graph<Integer> graph = new Graph<Integer>();
              graph.addEdge(1, 2, 4);
              graph.addEdge(1, 3, 1);
              graph.addEdge(2, 5, 1);
              graph.addEdge(2, 6, 3);
              graph.addEdge(2, 4, 2);
              graph.addEdge(6, 5, 2);
              graph.addEdge(6, 4, 3);
              graph.addEdge(4, 7, 2);
              graph.addEdge(3, 4, 5);
              graph.addEdge(3, 7, 8);

              KruskalMST mst = new KruskalMST();
              List<Edge<Integer>> result = mst.getMST(graph);
              for (Edge<Integer> edge : result) {
                System.out.println(edge.getSrc().getId() + " " + edge.getDest().getId());
        }
}
}