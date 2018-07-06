/*
* @Author: pankajgoyal7
* @Date:   2018-06-03 16:22:17
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-03 17:03:43
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode{
	int data;
	TreeNode left,right,next;
	TreeNode(int item){
		data = item;
		left = right = next = null;
	}
}
class ConnectLevelNodesTree{

	private static void connectTreeNodes(TreeNode root){

		if(root == null)
			return;

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(root);

		while(!q1.isEmpty() ||  !q2.isEmpty()){

			TreeNode prev = null;
			while(!q1.isEmpty()){
				TreeNode node = q1.peek();
				q1.poll();

				if(prev != null){
					prev.next = node;
				}
				prev = node;

				if(node.left != null)
					q2.add(node.left);

				if(node.right != null)
					q2.add(node.right);
			}

			TreeNode prev2 = null;
			while(!q2.isEmpty()){
				TreeNode node = q2.peek();
				q2.poll();

				if(prev2 != null){
					prev2.next = node;
				}
				prev2 = node;

				if(node.left != null)
					q1.add(node.left);

				if(node.right != null)
					q1.add(node.right);
			}
		}
	
	}

	static void sprialOrderTraversal(TreeNode root){
		if(root == null)
			return;

		Stack<TreeNode> q1 = new Stack<TreeNode>();
		Stack<TreeNode> q2 = new Stack<TreeNode>();

		q1.push(root);

		while(!q1.empty() ||  !q2.empty()){

			while(!q1.empty()){

				TreeNode node = q1.peek();
				q1.pop();

				System.out.print(node.data+" ");

				if(node.right != null)
					q2.push(node.right);

				if(node.left != null)
					q2.push(node.left);
			}

			while(!q2.empty()){
				TreeNode node = q2.peek();
				q2.pop();

				System.out.print(node.data+" ");


				if(node.left != null)
					q1.push(node.left);

				if(node.right != null)
					q1.push(node.right);

			}
		}
	

	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		connectTreeNodes(root);

		System.out.println(root.left.data+" next is "+root.left.next.data+" " +root.right.data+" next is "+ root.right.next);

		sprialOrderTraversal(root);

	}
}