package com.leetcode;

import java.util.Arrays;

import com.algorithm.BinarySearch;

/*Similar to Question [1. Two Sum], except that the input array is already sorted in
ascending order.*/
public class TwoSumII {
	public static void main(String[] args) {
		int[] numbers = {0,1,4,5,65,77,89,100,110,111,112,334,567};
		try {
			System.out.println(Arrays.toString(solution1(numbers, 9)));
			System.out.println(Arrays.toString(solution2(numbers, 9)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @param numbers
	 * @param target
	 * @return
	 * @throws Exception
	 * 
	 * 第一种解法，利用二分查找，时间复杂度是O(nlogn)
	 */
	public static int[] solution1(int[] numbers, int target) throws Exception {
		for (int i = 0; i < numbers.length; i++) {
			int indice = BinarySearch.binarySearchUseLoop(numbers, i + 1, numbers.length - i - 1, target - numbers[i]);
			if (indice >= 0) {
				return new int[]{i, indice};
			} 
		}
		throw new Exception("can't find the two numbers.");
	}
	
	/**
	 * @param numbers
	 * @param target
	 * @return
	 * @throws Exception
	 * 
	 * 第二种解法，利用双指针法，时间复杂度是O(n)
	 */
	public static int[] solution2(int[] numbers, int target) throws Exception {
		for (int i = 0, j = numbers.length - 1; i < numbers.length && j >= 0; ) {
			if (numbers[i] + numbers[j] == target) {
				return new int[] {i,j};
			}
			if (numbers[i] + numbers[j] > target) {
				j --;
			}
			if (numbers[i] + numbers[j] < target) {
				i ++;
			}
		}
		throw new Exception("can't find the two numbers.");
	}
}
