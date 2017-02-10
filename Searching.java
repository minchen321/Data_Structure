
public class Searching {

	public static void main(String[] args) {
		int[] list = {23, 33, 100, 90, 15, 40};
		int searchedValue = 23;
		int targetIndex = linearSearch(searchedValue, list);
		if(targetIndex == -1){
			System.out.println(searchedValue + " does not exist on the list.");
		}
		else
			System.out.println(searchedValue + " is found on index " + targetIndex +".");

		targetIndex = binarySearch(list, searchedValue);
		if(targetIndex == -1){
			System.out.println(searchedValue + " does not exist on the list.");
		}
		else
			System.out.println(searchedValue + " is found on index " + targetIndex +".");
		
	
	}
	
//-----------------------Linear Search--------------------------
	//It runs in O(n).
	public static int linearSearch(int target, int[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] == target)
				return i;
		}
		return -1;
	}//LinearSearch
	
//-----------------------Binary Search----------------------------
	//Assume the array is sorted
	public static int binarySearch(int[] array, int targetValue){
		int low = 0;
		int high = array.length - 1;
		
		while(low <= high){
			int mid = (low + high) / 2;
			if(array[mid] == targetValue) //if the target is at index mid
				return mid;
			else if(targetValue < array[mid]){ //target is on the left side of index mid
				high = mid - 1;
			}//else if 
			else
				low = mid + 1;	
		}//while
		return -1;
	}//binarySearch

}
