/*
* @Author: pankajgoyal7
* @Date:   2018-06-21 10:44:16
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-23 00:41:59
*/
package interview.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class BinaryHeap<T>{

	private List<Node> allNodes = new ArrayList<>();
	private Map<T,Integer> nodePosition = new HashMap<>();

	class Node{
		int weight;
		T key;
	}

	public boolean containsData(T key){
		return nodePosition.containsKey(key);
	}

	public void add(int weight,T key){
		Node node = new Node();
		node.weight = weight;
		node.key = key;
		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		int parentIndex  = (current - 1)/2;
		nodePosition.put(key,current);

		while(parentIndex >= 0){
			Node parentNode = allNodes.get(parentIndex);
			Node currentNode = allNodes.get(current);
			if(parentNode.weight > currentNode.weight){
				swap(parentNode,currentNode);
				updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
				current = parentIndex;
				parentIndex = (current - 1)/2;
			}else{
				break;
			}
		}
	}

	public Integer getWeight(T key) {
        Integer position = nodePosition.get(key);
        if( position == null ) {
            return null;
        } else {
            return allNodes.get(position).weight;
        }
    }

    public boolean empty(){
        return allNodes.size() == 0;
    }
    
	private void swap(Node parentNode,Node currentNode){
		int weight = parentNode.weight;
		T data = parentNode.key;


		parentNode.weight = currentNode.weight;
		parentNode.key = currentNode.key;

		currentNode.weight = weight;
		currentNode.key = data;
	}

	private void updatePositionMap(T data1,T data2,int pos1,int pos2){
		nodePosition.remove(data1);
		nodePosition.remove(data2);

		nodePosition.put(data1,pos1);
		nodePosition.put(data2,pos2);
	}

	public void decrease(T data,int newWeight){
		Integer pos = nodePosition.get(data);
		allNodes.get(pos).weight = newWeight;
		int parent = (pos - 1)/2;
		while(parent >= 0){
			if(allNodes.get(parent).weight >allNodes.get(pos).weight){
				swap(allNodes.get(parent),allNodes.get(pos));
				updatePositionMap(allNodes.get(parent).key,allNodes.get(pos).key,parent,pos);
				pos =  parent;
				parent = (pos - 1)/2;
			}else{
				break;
			}
		}
	}

	public Node extractMinNode(){
		int size = allNodes.size() -1 ;
		Node minNode = new Node();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;

		int lastNodeWeight = allNodes.get(size).weight;
		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;

		nodePosition.remove(minNode.key);
		nodePosition.remove(allNodes.get(0).key);

		nodePosition.put(allNodes.get(0).key,0);
		allNodes.remove(size);

		int currentIndex  = 0;
		size--;

		while(true){
			int left = 2 * currentIndex + 1;
			int right =  2*currentIndex + 2;
			if(left > size)
				break;

			if(right > size)
				right = left;

			int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
			if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){
				swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).key,allNodes.get(smallerIndex).key,currentIndex,smallerIndex);
				currentIndex = smallerIndex;
			}else{
				break;
			}
		}
		return minNode;
	}

	public T extractMin(){
		Node node = extractMinNode();
		return node.key;
	}

	public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.key);
        }
    }

    private void printPositionMap(){
        System.out.println(nodePosition);
    }

	public static void main(String[] args) {
		BinaryHeap<String> heap = new BinaryHeap<String>();
		heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        heap.decrease("Pramila", 1);
        heap.printHeap();
        heap.printPositionMap();
	}
}