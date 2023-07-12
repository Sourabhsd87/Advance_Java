package LinearSearch;

import LinearSearch.Definition;

public class Tester {
	
	public static void main(String[] args) {

		int [] arr = {3,6,9,12,15,18,21,24,27,30};
		
		System.out.println(Definition.linearSearch(arr, 17));
		System.out.println(Definition.linearSearch(arr, 6));
		System.out.println(Definition.linearSearch(arr, 27));
			
	}

}
