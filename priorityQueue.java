import java.util.PriorityQueue;
public class priorityQueue {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> list = new PriorityQueue<Integer>();
		//add items to the queue
		int arrayList[] = {39, 43, 11, 99, 9, 13, 2};
		for(int i = 0; i < arrayList.length; i++){
			list.add(arrayList[i]);
		}

		for(Integer num: list){
			System.out.print(num + " ");
		}
		System.out.println("\n");
		//clear() will empty the entire list
		//remove the minimum value on the queue
		list.poll();
		//remove a particular item
		list.remove(9);
		for(Integer num: list){
			System.out.print(num + " ");
		}
		//show the first item in the line
		System.out.println("\n" + "head = " + list.peek());

	}
}
