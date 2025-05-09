package Telusko;
/*
1. Linear Search
Works on: Unsorted or Sorted arrays.
How: It checks each element one by one until it finds the target.

2. Binary Search
Works on: Sorted arrays only.
How: It divides the array into halves and reduces search space every step.
*/
public class LinearBinarySerch {

    public static void main(String[] args) {

//		int a[] = { 5, 7,8, 9, 11, 13,17 };

        int a[] = { 5, 17,18, 2, 11, 13,1 };
        int t = 17;

        print(a);

//		int result = linearSearch(a, t);
        int result = binarySearch(a, t);

        if (result != -1) {
            System.out.println("Index:" + result);
        } else {
            System.out.println("Element not found!");
        }

    }

    private static void print(int[] a) {
        for(int i=0 ;i<a.length;i++) {
            System.out.print(a[i]+",");
        }
        System.out.println();

    }

    private static int linearSearch(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] a, int t) {
        int s = 0, e = a.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                e = m - 1;
            } else if (a[m] < t) {
                s = m + 1;
            }
        }
        return -1;
    }

//	private static int binarySearch(int[] a, int t) {
//		int s = 0, e = a.length - 1;
//		System.out.println("start");
//		while (s <= e) {
//			int m = (s + e) / 2;
//			System.out.println("m:"+m);
//			System.out.println("s:"+s);
//			System.out.println("e:"+e);
//			if (a[m] == t) {
//				System.out.println("a[m] == t");
//				System.out.println("m:"+m);
//				System.out.println("s:"+s);
//				System.out.println("e:"+e);
//				return m;
//			} else if (a[m] > t) {
//				System.out.println("a[m] > t");
//				System.out.println("m:"+m);
//				System.out.println("s:"+s);
//				System.out.println("e:"+e);
//				e = m - 1;
//			} else if (a[m] < t) {
//				System.out.println("a[m] < t");
//				System.out.println("m:"+m);
//				System.out.println("s:"+s);
//				System.out.println("e:"+e);
//				s = m + 1;
//			}
//			System.out.println("end");
//		}
//		System.out.println("whileloop->out");
//		return -1;
//	}

}
