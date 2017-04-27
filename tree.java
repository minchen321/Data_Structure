public class tree {
	
	Node root;	
	
	public static void main(String[] args){
		tree newTree = new tree();
		newTree.addNode(50, "John");
		newTree.addNode(20, "Mike");
		newTree.addNode(21, "Joe");
		newTree.addNode(31, "Kate");
		newTree.addNode(43, "Tom");
		
		newTree.inOrderTraverse(newTree.root);
		newTree.preOrderTraverse(newTree.root);
		newTree.postOrderTraverse(newTree.root);
		System.out.println(newTree.findNode(21));
	}
	
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		if(root == null){
			root = newNode;
		}
		else{
			Node currentNode = root;
			Node parent;
			while(true){
				parent = currentNode;
				if(key < currentNode.key){ //if newNode's key is smaller than the currentNode
					currentNode = currentNode.leftChild; //leftChild's key is smaller than parent's key
					if(currentNode == null){ //if leftChild is null
						parent.leftChild = newNode;
						return;
					}
				}else{
					currentNode = currentNode.rightChild;
					if(currentNode == null){
						parent.rightChild = newNode;//rightChild's key is greater than parent
						return;
					}
				}//else
			}//while		
		}//else
	}//addNode

	public Node findNode(int key){
		Node currentNode = root;
		while(currentNode.key != key){
			if(currentNode.key > key)
				currentNode = currentNode.leftChild;
			else
				currentNode = currentNode.rightChild;
			//if the node is not found
			if(currentNode == null)
				return null;
		}
		return currentNode;
	}
	
	// In order traversal starts from the most left child (smallest value),
	//then jumps up to the parent, and then jumps down to the right child
	//each node is visited in an increasing order
	public void inOrderTraverse(Node currentNode){
		if(currentNode != null){
			inOrderTraverse(currentNode.leftChild);
			System.out.println(currentNode);
			inOrderTraverse(currentNode.rightChild);
		}
	}//inOrderTraversal
	
	//Start from the root, travel the children of each position from left to right
	public void preOrderTraverse(Node currentNode){
		if(currentNode != null){
			System.out.println(currentNode);
			preOrderTraverse(currentNode.leftChild);
			preOrderTraverse(currentNode.rightChild);
		}
	}
	
	//Start from the most left position,
	//travel the children of each position from left to right
	//root is the last node
	public void postOrderTraverse(Node currentNode){
		if(currentNode != null){
			postOrderTraverse(currentNode.leftChild);
			postOrderTraverse(currentNode.rightChild);
			System.out.println(currentNode);
		}
	}

}

class Node{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
		
	}
	public String toString(){
		return name + " has a key " + key;
	}
}