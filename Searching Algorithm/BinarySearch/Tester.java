package BinarySearch;

import BinarySearch.Definition;

public class Tester {

	public static void main(String[] args) {
		
		int [] arr = {2,4,6,8,10,12,14,16,18,20};
		
		System.out.println(Definition.binarySearch(arr, 15));
		System.out.println(Definition.binarySearch(arr, 18));
		System.out.println(Definition.binarySearch(arr, 4));
		
		System.out.println(Definition.binarySearch(arr, 0, arr.length-1, 15));
		System.out.println(Definition.binarySearch(arr, 0, arr.length-1, 18));
		System.out.println(Definition.binarySearch(arr, 0, arr.length-1, 4));
		
	}
}
