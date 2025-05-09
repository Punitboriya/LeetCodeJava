package Blind75;

import java.util.Arrays;

public class LC04_238_PAEEI {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };

        print(a);
//		print(product(a));
//		System.out.print("productUsingDiv: ");
//		print(productUsingDiv(a));
        print(fProduct(a));
//		print(productExceptSelf(a));
    }

    private static int[] productExceptSelf(int[] a) {

        int prod[] = new int[a.length];
        Arrays.fill(prod, 1);

        int pre = 1, post = 1;

        for (int i = 0; i < a.length; i++) {
            System.out.println("i=" + i + "prifix=" + pre);
            prod[i] = pre;
            pre *= a[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            prod[i] *= post;
            post *= a[i];
        }

        return prod;
    }

    public static int[] fProduct(int[] a) {

        int pr = 1;
        int po = 1;

        int prod[] = new int[a.length];
        Arrays.fill(prod, 1);

        for (int i = 1; i < a.length; i++) {

            System.out.println("i: " + i + " prifix: " + pr);
            pr = pr * a[i - 1];
            System.out.println("Pre: " + pr);
            prod[i] = pr;
            System.out.println("prod[" + i + "]: " + prod[i]);

        }
        print(prod);
        System.out.println("---------------");
        for (int i = a.length - 2; i >= 0; i--) {
            System.out.println("i=" + i + "postfix=" + po);
            po = po * a[i + 1];
            prod[i] = prod[i] * po;
            System.out.println("prod[" + i + "]: " + prod[i]);
        }

        return prod;
    }

    public static int[] product(int[] a) {

        int prod[] = new int[a.length];

        for (int i = 0; i < prod.length; i++) {
            prod[i] = 1;
        }

        for (int i = 0; i < a.length; i++) {
            int p = 1;
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    p = p * a[j];
                    prod[i] = p;
                }
            }
        }
        return prod;
    }

    static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static int[] productUsingDiv(int[] a) {
        int mul = 1;
        for (int i : a) {
            mul *= i;
        }

        int prod[] = new int[a.length];

        for (int i = 0; i < prod.length; i++) {
            prod[i] = mul / a[i];
        }
        return prod;

    }

}
