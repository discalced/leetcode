package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
public class TwoSum {
	public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(solution1(new int[]{2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(solution2(new int[]{2, 7, 11, 15}, 9)));
	}
	
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @throws Exception
	 * 
	 * This is the brute force approach. Loop through each element x and find if there is another element which value equals
	 * to target - x. As finding another value requires looping through the rest of the array.
	 */
	public static int[] solution1(int[] nums, int target) throws Exception{
		int[] indices = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (target - nums[i] > 0) {
				indices[0] = i;
				for (int j = i; j < nums.length - i; j++) {
					if (target - nums[i] == nums[j]) {
						indices[1] = j;
						return indices;
					}
				}
			}
		}
		throw new Exception("no property value");
	}
	
	/**
	 * @param nums
	 * @param target
	 * @return
	 * @throws Exception
	 * 此解法利用hashmap缓存了遍历过的数组成员， 其实利用了hashmap比较低时间复杂度的查找。
	 */
	public static int[] solution2(int[] nums, int target) throws Exception{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		throw new Exception("no property value");
	}
}
