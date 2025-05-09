package Telusko;

public class BubbleSort {
    public static void main(String[] args) {
        int a[]= {6,5,2,8,9,4};
        int temp;
        System.out.println("Given Array :");
        print(a);

        for(int i=0 ;i<a.length;i++) {
            for(int j=0 ;j<i-1;j++) {
                if(a[j]>a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.println("iteration :"+(i+1));
            print(a);
        }
        System.out.println("After sorting");
        print(a);

    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();

    }

}
