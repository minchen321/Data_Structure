import java.util.*;
public class stackAndQueue {

	public static void main(String[] args) {
		Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		//Stack 
		Stack<Integer> stack = new Stack<Integer>();
	
		for(int i = 0; i < arr.length; i++)
			stack.push(arr[i]);	
			
		reverseStack(stack);	
		System.out.println("\n");
		
		//Matching Parentheses
		String parenthesesList[] = {"[]]]]]{}])", "{{[]}}", "()[[]]()", "}", "{", "", "", "))" };
		for(int j = 0; j < parenthesesList.length; j++){
			if(parenthesesList[j].length() <= 1 || parenthesesList[j].length() % 2 == 1)
				print(false);
			else
				print(isMatched(parenthesesList[j]));
		}
			
		System.out.println("\n");
		//Queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int k = arr.length - 1; k >= 0; k--){
			queue.add(arr[k]);
		}
		
		reverseQueue(queue);
		
	}
	
	public static void reverseStack(Stack<Integer> s){
		if(s.isEmpty())
			System.out.println("The stack is empty.");
		else{
			while(s.size() > 0)
				System.out.print(s.pop() + " ");
		}	
	}//reverse
	
	public static void print(boolean checkBool){
		if(checkBool == true)
			System.out.print("True" + " ");
		else
			System.out.print("False" + " ");
	}//print
	
	public static boolean isMatched(String parentheses){
	    String opening = "({[";
		String closing = ")}]";
		
		Stack<Character> newParentheses = new Stack<Character>();
		char[] charArray = parentheses.toCharArray();
		for(char i : charArray){
			if(opening.indexOf(i) != - 1)
				newParentheses.push(i); 
			else if(closing.indexOf(i) != -1){
				if(newParentheses.isEmpty())
					return false;
				if(closing.indexOf(i) != opening.indexOf(newParentheses.pop()))
					return false;
			}
		}
		return true;
	}//isMatched
	
	public static void reverseQueue(Queue<Integer> q){
		if(q.isEmpty())
			System.out.println("The stack is empty.");
		else{
			while(q.size() > 0)
				System.out.print(q.remove() + " ");
		}	
	}//reverse
}
