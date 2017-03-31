package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Design and implement a TwoSum class. It should support the following operations: add
and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)  true; find(7)  false*/
public class TwoSumIII {
	public static void main(String[] args) {
		int[] numbers = {0,1,4,4,5,65,77,89,100,110,111,112,334,567};
		TwoSumIII twoSumIII = new TwoSumIII();
		System.out.println("use method 1st");
		for (int i = 0; i < numbers.length; i++) {
			twoSumIII.add1(numbers[i]);
			twoSumIII.add3(numbers[i]);
		}
		System.out.println(twoSumIII.find1(77));
		System.out.println(twoSumIII.find1(70));
		System.out.println(twoSumIII.find1(8));
		System.out.println(twoSumIII.find1(8555));
		System.out.println("use method 3rd");
		System.out.println(twoSumIII.find3(77));
		System.out.println(twoSumIII.find3(70));
		System.out.println(twoSumIII.find3(8));
		System.out.println(twoSumIII.find3(8555));
	}
	
	private Set<Integer> set1 = new HashSet<>();
	private List<Integer> list1 = new ArrayList<>();
	
	public void add1(int num) {
		for(Integer n : list1) {
			set1.add(n + num);
		}
		list1.add(num);
	}
	
	public boolean find1(int num) {
		return set1.contains(num);
	}
	
	private int[] numbers2 ={};
	
	public void add2(int num) {
		//TODO:使用modified binary tree， 维护一个有序数组，每次插到合适位置
	}
	
	public boolean find2(int num) {
		for (int i = 0, j = numbers2.length - 1; i < numbers2.length && j >= 0;) {
			if (numbers2[i] + numbers2[j] == num) {
				return true;
			}
			if (numbers2[i] + numbers2[j] > num) {
				j --;
			}
			if (numbers2[i] + numbers2[j] < num) {
				i ++;
			}
		}
		return false;
	}
	
	private Map<Integer, Integer> map3 = new HashMap<>();	
	
	public void add3(int num) {
		Integer quantity = map3.get(num);
		if (quantity == null) {
			map3.put(num, 0);
		} else {
			map3.put(num, quantity + 1);
		}
	}
	
	public boolean find3(int num) {
		for (Entry<Integer, Integer> entry : map3.entrySet()) {
			if ((num - entry.getKey().intValue() == entry.getKey().intValue()) && entry.getValue() > 1) {
				return true;
			}
			if (map3.get(num - entry.getKey()) != null) {
				return true;
			}
		}
		return false;
	}
	
}
