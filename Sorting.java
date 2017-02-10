
public class Sorting {
		private static int arraySize;
		
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
	    
	    int[] arraylist_3 = {9, 8, 7, 5, 4, 6, 1, 3, 2, 10};
		arraylist_3 = mergeSort(arraylist_3);
		print(arraylist_3);
		
		int[] arraylist_4 = {9, 8, 7, 5, 4, 6, 1, 3, 2, 10};
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
	 
//----------------Merge Sort------------------------	
	 //Divide the list into small equal-size lists
	 //compare the elements on each list, the smaller value goes into the new sorted list
	 //Continue the the comparison until the list is completely sorted
	 //MergeSort is recursive 
	 //Use for large data sets
	 //It runs in O(n log n).
	 public static int[] mergeSort(int[] list){
		 if(list.length <= 1)// base case is when the array is empty or there is only one element
			 return list; 
		 int midpoint = list.length / 2;
		 int[] left = new int[midpoint];//divide the list to left and right array
		 int[] right;
		 
		 if(list.length % 2 == 0) //check the length of list is even or odd
			 right = new int[midpoint];
		 else 
			 right = new int[midpoint + 1];
		
		 int[] result = new int[list.length];
		 for(int i = 0; i < midpoint; i++)
			 left[i] = list[i];
		 int x = 0;
		 for(int j = midpoint; j < list.length; j++){
			 if(x < right.length){
				 right[x] = list[j];
				 x++;
			 }
		  }//for loop
		 left = mergeSort(left);//break down left array
		 right = mergeSort(right);//break down right array
		 result = merge(left, right);

		 return result;
	 }

	 public static int[] merge(int[] left, int[] right){
		  int lengthResult = left.length + right.length;
		  int[] result = new int[lengthResult];
		  int indexLeft = 0;
		  int indexRight = 0;
		  int indexResult = 0;
		  
		  while(indexLeft < left.length || indexRight < right.length){
			  if(indexLeft < left.length && indexRight < right.length){
				  if(left[indexLeft] <= right[indexRight]){
					  result[indexResult] = left[indexLeft];
					  indexLeft++;
					  indexResult++;
				  }
				  else{
					  result[indexResult] = right[indexRight];
					  indexRight++;
					  indexResult++;
				  }//else  
			  }
			  else if(indexLeft < left.length){ //if there is still elements on the left, it must be greater than the previous elements
				  result[indexResult] = left[indexLeft];
				  indexLeft++;
				  indexResult++;
			  }
			  else if(indexRight  < right.length){ //if there is still elements on the right, it must be greater than the previous elements
				  result[indexResult] = right[indexRight];
				  indexRight++;
				  indexResult++;
			  }	  
		  }//while
		  return result;
	 }
	 
//----------------Quick Sort------------------------	 
	 //QuickSort is recursive 
	 //Efficient for large data sets
	 //Run time depends on the selection of pivot; Worst case runs in O(n^2); Usually is O(n log n)
	 //Everything on the left is smaller than the pivot; everything on the right is greater than the pivot
	 //Start the sorting by setting the first/middle/last item as a pivot 
	 //But randomly chosen pivots ensure O(n log n)	 
	 
	 //print function
	 public static void print(int[] list){
		 for(int i = 0; i < list.length; i++){
			 System.out.print(list[i]+ " ");	 
		 }
		 System.out.println("\n");
	 }//print
	 
}
