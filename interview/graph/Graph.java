/*
* @Author: pankajgoyal7
* @Date:   2018-06-20 23:24:51
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-07-03 23:07:34
*/

package interview.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

class Graph<T>{
	
	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
    private boolean isDirected = false;
	
    public Graph(){
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long,Vertex<T>>();
	}

    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        isDirected = isDirected;
    }

	public void addEdge(long src,long dest){

		Vertex<T> vertex1 = null;
        if(allVertex.containsKey(src)){
            vertex1 = allVertex.get(src);
        }else{
            vertex1 = new Vertex<T>(src);
            allVertex.put(src, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(dest)){
            vertex2 = allVertex.get(dest);
        }else{
            vertex2 = new Vertex<T>(dest);
            allVertex.put(dest, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2);
        allEdges.add(edge);

        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

	}

	public void addEdge(long src,long dest,int weight){
		Vertex<T> vertex1 = null;
        if(allVertex.containsKey(src)){
            vertex1 = allVertex.get(src);
        }else{
            vertex1 = new Vertex<T>(src);
            allVertex.put(src, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(dest)){
            vertex2 = allVertex.get(dest);
        }else{
            vertex2 = new Vertex<T>(dest);
            allVertex.put(dest, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,weight);
        allEdges.add(edge);

        vertex1.addAdjacentVertex(edge, vertex2);
        // if(!isDirected){
            // vertex2.addAdjacentVertex(edge, vertex1);
        // }
	}

	public List<Edge<T>> getAllEdges(){
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex(){
		return allVertex.values();
	}

    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }
}

class Edge<T>{

	private Vertex<T> src;
	private Vertex<T> dest;
	private int weight;

	Edge(Vertex<T> src,Vertex<T> dest,int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	Edge(Vertex<T> src,Vertex<T> dest){
		this.src = src;
		this.dest = dest;
	}

	public int getWeight(){
		return this.weight;
	}

	Vertex<T> getSrc(){
        return src;
    }
    
    Vertex<T> getDest(){
        return dest;
    }
}

class Vertex<T>{

	long id;
	private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();


	Vertex(long id){
		this.id = id;
	}

	public void setData(T data){
		this.data = data;
	}

	public long getId(){
		return this.id;
	}

	public List<Edge<T>> getEdges(){
        return edges;
    }

    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
}
