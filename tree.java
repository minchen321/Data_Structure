public class tree {
	Node root;	
		
	public static void main(String[] args){
		tree newTree = new tree();
		newTree.addNode(50);
		newTree.addNode(20);
		newTree.addNode(21);
		newTree.addNode(31);
		newTree.addNode(43);
		
//		newTree.inOrderTraverse(newTree.root);
//		newTree.preOrderTraverse(newTree.root);
//		newTree.postOrderTraverse(newTree.root);		
		newTree.deleteNode(31);
		newTree.inOrderTraverse(newTree.root);
		System.out.println("\n");
		int height = newTree.depth(newTree.root);
		System.out.println("Height of this tree is : " + height);
	}
	
	public void addNode(int key){
		Node newNode = new Node(key);
		if(root == null)
			root = newNode;
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
	
	//In a sorted Binary tree, delete a node
	//the right child will replace the position of the deleted node
	public boolean deleteNode(int key){
		Node currentNode = root;
		Node parent = root;
		boolean isLeftChild = true;
				
		while(currentNode.key != key){
			parent = currentNode;
			if(key < currentNode.key){
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			}else{
				isLeftChild = false;
				currentNode = currentNode.rightChild;
			}
			//if the target node is not found
			if(currentNode == null)
				return false;
		}
			//if currentNode has no child
			if(currentNode.leftChild == null && currentNode.rightChild == null){
				if(currentNode == root)
					root = null;
				else if(isLeftChild)
					parent.leftChild = null;
				else
					parent.rightChild = null;
			}
			//if currentNode has no rightChild
			else if(currentNode.rightChild == null){
				if(currentNode == root)
					root = currentNode.leftChild;
				else if(isLeftChild)
					parent.leftChild = currentNode.leftChild;
				else 
					parent.rightChild = currentNode.leftChild;
			}
			//if currentNode has no leftChild
			else if(currentNode.leftChild ==null){
				if(currentNode == root)
					root = currentNode.rightChild;
				else if(isLeftChild)
					parent.leftChild = currentNode.rightChild;
				else 
					parent.rightChild = currentNode.rightChild;	
			}
			else{
				//replace currentNode with a new node
				Node replacement = getReplacementNode(currentNode);
				if(currentNode == root)
					root = replacement;
				else if(isLeftChild)
					parent.leftChild = replacement;
				else
					parent.rightChild = replacement;
				replacement.leftChild = currentNode.leftChild;
			}
		return true;
	}
		
	public Node getReplacementNode(Node replacedNode){
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node currentNode = replacedNode.rightChild;
		while(currentNode != null){
			replacementParent = replacement;
			replacement = currentNode;
			currentNode = currentNode.leftChild;
		}
		if(replacement != replacement.rightChild){
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
	
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

	public int depth(Node n){
		if(n == null)
			return 0;
		else{
			int leftDepth = depth(n.leftChild);
			int rightDepth = depth(n.rightChild);
			
			if(leftDepth > rightDepth)
				return (leftDepth + 1);
			else
				return(rightDepth + 1);
		}
	}
	
	// In order traversal starts from the most left child (smallest value),
	//then jumps up to the parent, and then jumps down to the right child
	//each node is visited in an increasing order
	public void inOrderTraverse(Node currentNode){
		if(currentNode != null){
			inOrderTraverse(currentNode.leftChild);
			System.out.print(currentNode + " ");
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
	
	Node(int key){
		this.key = key;
	}
	public String toString(){
		return key+"";
	}
}