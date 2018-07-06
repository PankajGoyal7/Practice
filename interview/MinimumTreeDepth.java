/*
* @Author: pankajgoyal7
* @Date:   2018-06-12 16:07:12
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-06-12 16:27:41
*/
import java.util.Queue;
import java.util.LinkedList;

class MinNode{
	int key;
	MinNode left,right;
	MinNode(int item){
		key = item;
		left = right = null;
	}
}
class MinimumTreeDepth{

	static int depth = 0;
	static int findMinDepth(MinNode root){
		if(root == null)
			return 0;

		Queue<MinNode> q = new LinkedList<MinNode>();
		q.add(root);
		q.add(null);

		depth++;

		while(!q.isEmpty()){
			
			MinNode n = q.poll();
			if(n == null &&  !q.isEmpty()){
				q.add(null);
				depth++;
				// System.out.println();
			}else{
				if(n.left == null && n.right == null)
					return depth;

				if(n.left != null)
					q.add(n.left);

				if(n.right != null)
					q.add(n.right);

				// System.out.print(n.key+" ");
			}	
		}
		return depth;
	}

	public static void main(String[] args) {
		MinNode root = new MinNode(1);
		root.left = new MinNode(2);
		root.right = new MinNode(3);
		root.left.left = new MinNode(4);
		root.left.right = new MinNode(5);
		root.right.left = new MinNode(6);
		root.right.right = new MinNode(7);
		root.left.left.left = new MinNode(8);
		root.left.left.right = new MinNode(9);
		root.left.right.left = new MinNode(8);
		root.left.right.right = new MinNode(9);

		root.right.left.left = new MinNode(10);
		root.right.left.right = new MinNode(11);
		root.right.right.left = new MinNode(12);
		root.right.right.right = new MinNode(13);

		System.out.println(findMinDepth(root));
	}
}