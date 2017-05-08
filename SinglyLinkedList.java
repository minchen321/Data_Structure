
public class SinglyLinkedList {
	static Node head;

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		int[] dataList = {32, 12, 6, 14, 82, 52,11, 30, 73};
		for(int i = 0; i < dataList.length; i++){
			if(i == 0)
				head = new Node(dataList[i], null);		
			else
				list.add(dataList[i]);
			System.out.print(list.get(i) + " ");	 
		}
		
		System.out.print("\n");
		
		reverse(list);
		for(int i = 0; i < dataList.length; i++){
			System.out.print( list.get(i) + " ");	 
		}
	}
	
	public void add(int newData){		
		Node current = head;
		while(current.getNext() != null){
			current = current.getNext();
		}
		Node temp = new Node(newData);
		current.setNext(temp);		
	}//add	
	
	public int get(int index){
		Node current = head;
		for(int k = 0; k < index; k++){
			current = current.getNext();
		}
		return current.getData();
	}//get

	public static void reverse(SinglyLinkedList list){
		Node current = head;
		Node previous = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
}


class Node {
	Node next;
	int data;

	public Node(){
		
	}
	public Node(int newData){
		data = newData;
		next = null;
	}
	
	public Node(int newData, Node newNext) {
		next = newNext;
		data = newData;
	}
	
	//get methods
	public int getData(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	//set methods
	public void setNext(Node newNode){
		next = newNode;
	}
	
	public String toString(){
		return data + " ";
	}
	
}