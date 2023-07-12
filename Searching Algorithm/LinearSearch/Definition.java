package LinearSearch;

public class Definition {
	
	public static int linearSearch(int [] arr, int key) {
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] == key) {
				
				return i+1;
			}			
		}
		return 999;		
	}//end of linearSearch method

}
