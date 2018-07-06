/*
* @Author: pankajgoyal7
* @Date:   2018-05-04 13:50:40
* @Last Modified by:   pankajgoyal7
* @Last Modified time: 2018-05-04 14:06:27
*/
class MorrisPreorderTraversal{

	Node root;

	public static void main(String... args){

		MorrisPreorderTraversal tree = new MorrisPreorderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);

		tree.traverse(tree.root);
	}

	void traverse(Node node){
		if(node == null)
			return;
	
		while(node != null){

			if(node.left == null){
				System.out.print(node.data+" ");
				node = node.right;
			}else{
				pre  = node.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;

				if(pre.right == node){
					pre.right = null;
					node = node.right;
				}else{
					System.out.print(node.data+" ");
					pre.right = node;
					node = node.left;
				}
			}
		}
	}
}