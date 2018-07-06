/*
* @Author: pankajgoyal7
* @Date:   2018-06-03 01:05:19
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-03 01:39:38
*/
class Node{
	int data;
	Node next;
	Node(int key){
		data = key;
		next = null;
	}
}
class ReverseLinkedList{

	private static Node reverseLinkedList(Node head){

		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null){
			next =  curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	private static Node reverseLinkedListSize(Node head,int k){
		return reverseLinkedListSizeUtil(head,k);
	}	

	private static Node reverseLinkedListSizeUtil(Node head,int k){

		Node prev = null;
		Node curr = head;
		Node next = null;
		int count = 0;
		while(curr != null && count < k){
			next =  curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if(next != null)
			head.next = reverseLinkedListSizeUtil(next,k);

		return prev;
	}


	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		Node h = reverseLinkedListSize(head,3);
		while(h != null){
			System.out.println(h.data);
			h =  h.next;
		}
	}
}