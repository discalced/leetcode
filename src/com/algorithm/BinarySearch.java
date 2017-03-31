package com.algorithm;

/**
 * @author yanronggao
 *	���ֲ��ң� ��֪����Ϊn����������A������Ŀ��T�������е�λ��
 *	step1: ��L=0��R=n-1
 *	step2�����L>R������ʧ��
 *	step3����m=(L+R)/2�������¸�˹����
 *	step4�����T<Am��R=m-1������step2�����T>Am��L=m+1������step2�����T=Am�����Ϊm
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
//		int m = (L+R)/2;  //ֱ��ƽ�����ܻ����int���ֵ
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
