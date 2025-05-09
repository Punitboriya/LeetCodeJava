package Others;

public class LC_189 {
    public static void main(String[] args) {

        int a[] = { 1, 8, 9, 4, 5 };
        int k = 3;
        int[] temp = new int[k];// k={ , , }
        int n = a.length; // n=5
        for (int i = 0; i < k; i++) {
            temp[i] = a[n - k + i];
        } // {9,4,5}
        print(temp);
        for (int i = n - 1; i >= k; i--) {// j=4,j=3
            a[i] = a[i - k]; // {1,8,9,4,8},{1,8,9,1,8}
        } // {1,8,9,1,8}
        print(a);
        for (int i = 0; i < k; i++) {// m=0
            a[i] = temp[i]; // {9,,,1,8} ,{9,4,,1,8},{9,4,5,1,8}
        }
        print(a);
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " , ");
        }
        System.out.println();
    }
}
