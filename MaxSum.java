package com.test;

//Program to write maximum sum of 2 non-consecutive elements
/*Given a list of numbers, write a program to select a subset of numbers whose sum is maximum while not picking any neighbors together

Examples: 
[1, 2, 3, 4] - Selected subset: {2, 4} 
[4, 1, 2] - Selected subset: {4, 2} 
[4, 15, 2] - Selected subset: {15}

*/
public class MaxSum {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 4 };
		int arr2[] = { 4, 1, 2 };
		int arr3[] = { 4, 15, 2 };
		int arr4[] = { 4, 7, 15, 2 };

		System.out.println(largestNonConsecutiveSum(arr1));
		System.out.println(largestNonConsecutiveSum(arr2));
		System.out.println(largestNonConsecutiveSum(arr3));
		System.out.println(largestNonConsecutiveSum(arr4));

	}

	private static int largestNonConsecutiveSum(int[] a) {
		return largestSumNonConsecutive(a, a.length - 1)[1];
	}

	//Using dynamic Programming and recursion
	private static int[] largestSumNonConsecutive(int[] a, int end) { // returns
																		// array
		// largest(end-1),largest(end)
		if (end == 0)
			return new int[] { 0, a[0] };

		int[] largest = largestSumNonConsecutive(a, end - 1);
		int tmp = largest[1];
		largest[1] = Math.max(largest[0] + a[end], largest[1]);
		largest[0] = tmp;

		return largest;
	}

}
