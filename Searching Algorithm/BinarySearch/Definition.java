package BinarySearch;

public class Definition {

	public static int binarySearch(int[] arr, int key) {

		int left = 0;
		int right = arr.length - 1;
		int mid = 0;

		while (left <= right) {

			mid = (left + right) / 2;

			if (arr[mid] == key) {

				return mid;
			}

			if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 999;
	}//end of BinarySearch
	
	public static int binarySearch(int [] arr,int left,int right,int key) {
		
		if(left > right) {
			return 999;
		}
		
		int mid = (left + right) / 2;
		
		if(arr[mid] == key) {
			return key;
		}
		
		if(arr[mid] > key) {
			
			return binarySearch(arr,left,mid-1,key);
		} 
		else {
			
			return binarySearch(arr,mid+1,right,key);
		}
			
	}//end of binarySearch By Recursion;

}
