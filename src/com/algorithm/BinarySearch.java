package com.algorithm;

/**
 * @author yanronggao
 *	二分查找： 已知长度为n的有序数组A，查找目标T在数组中的位置
 *	step1: 设L=0，R=n-1
 *	step2：如果L>R，查找失败
 *	step3：设m=(L+R)/2，加上下高斯符号
 *	step4：如果T<Am，R=m-1，返回step2；如果T>Am，L=m+1，返回step2；如果T=Am，结果为m
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = {0,1,4,5,65,77,89,100,110,111,112,334,567};
		try {
			for (int i : numbers) {
				System.out.println(binarySearch(numbers,i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int binarySearch(int[] numbers, int target) throws Exception{
		int indice = binarySearchUseLoop(numbers, 0, numbers.length - 1, target);
		if (indice < 0) {
			throw new Exception("can not find target " + target);
		}
		return indice;
	}
	
	public static int binarySearchUseRecuise(int[] numbers, int L, int R, int T) {
		if (L > R) {
			return -1;
		}
//		int m = (L+R)/2;  //直接平均可能会溢出int最大值
		int m = L + (R - L)/2;
		if (numbers[m] == T) {
			return m;
		} else if (numbers[m] < T) {
			L = m + 1;
		} else if (numbers[m] > T) {
			R = m - 1;
		}
		return binarySearchUseRecuise(numbers, L, R, T);
	}
	
	public static int binarySearchUseLoop(int[] numbers, int L, int R, int T) {
		while (true) {
			int m = L + (R - L)/2;
			if (T < numbers[m]) {
				R = m - 1;
			}
			if (T > numbers[m]) {
				L = m + 1;
			}
			if (T == numbers[m]) {
				return m;
			}
			if (L > R) {
				return -1;
			}
		}
	}
}
