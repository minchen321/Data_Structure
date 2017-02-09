
public class Sorting {
	
	public static void main(String[] args){     
		
	    int[] arraylist = {10, 9, 8, 7, 6, 4, 5, 1, 3, 2};
	    insertionSort(arraylist);
	    print(arraylist);
	    int[] arraylist_1 = {10, 7, 8, 9, 4, 6, 5, 1, 3, 2};
	    bubbleSort(arraylist_1);
	    print(arraylist_1);
	    int[] arraylist_2 = {9, 10, 8, 7, 6, 4, 5, 1, 3, 2};
	    bubbleSort(arraylist_2);
	    print(arraylist_2);
    }
	
//----------------Insertion Sort------------------------
	//All items to the left of current item are smaller
	//Use for small data sets
	//It runs in O(n^2) (Best sorting method compares to other same runtime sorting methods.)
	 public static int[] insertionSort(int[] list){
		 int i, j, key, temp;
		 for(i = 1; i<list.length; i++){ //The first element is always sorted so i starts from 1
			 key = list[i]; //key is the value at index i
			 j = i - 1; //j is the index on the left of current index i
			 while(j >= 0 && key <list[j]){
				 //swap
				 temp = list[j];
				 list[j] = list[j + 1];
				 list[j + 1] = temp;		 
				 j--;	 
			 }//while loop
		 }//for loop
		 return list;
	 }//insertionSort
	 
//----------------Bubble Sort------------------------
	 //Repeatedly compare two adjacent items, the larger number swaps to the right
	 //After iterating the array n times, the last n elements are sorted 
	 //Use for small data sets
	 //It runs in O(n^2)
	 public static int[] bubbleSort(int[] list){
		 int i, j, temp = 0;
		 for(i = 0; i < list.length - 1; i++){
			 for(j = 0; j < list.length - 1 - i; j++){ //on this line, i is the items have been sorted
				 if(list[j] > list[j + 1]){
					 //swap
					 temp = list[j];
					 list[j] = list[j + 1];
					 list[j + 1] = temp;
				 }//if
			 }	 
		 } 
		 return list;
	 }//bubbleSort
	 
//----------------Selection Sort------------------------
	 //Set the first element to the minimum value, compare it to each element
	 //If there is any element smaller than the minimum value, change that element to minimum value
	 //Swap the smallest value to the first place
	 //Use for small data sets
	 //It runs in O(n^2)
	 public static int[] selectionSort(int[] list){
		 int i, j, minValue, minIndex, temp = 0;
		 for(i = 0; i < list.length; i++){
			 minValue = list[i]; //first unsorted value
			 minIndex = i; //first unsorted index
			 for(j = i; j < list.length; j++){
				 if(list[j] < minValue){
					 minValue = list[j];
					 minIndex = j;
				 }//if
			 }//for loop j
			
			 if(minValue < list[i]){ //check if the minValue is the first item
				 temp = list[i];
				 list[i] = list[minIndex];
				 list[minIndex] = temp;
			 }//if			 
		 }//for loop i	 
	 return list;	 
	 }
	 
	 //print function
	 public static void print(int[] list){
		 for(int i = 0; i < list.length; i++){
			 System.out.print(list[i]+ " ");	 
		 }
		 System.out.println(" ");
	 }//print
	 
}
