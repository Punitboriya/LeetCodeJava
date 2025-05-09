package Others;

public class LC_189_2nd {
    public static void main(String[] args) {
        int a[] = { 1, 8, 9, 4, 5 };
        int n = a.length;
        int k = 3;
        k %= n;

        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        print(a);

    }
    public static void reverse(int[] a, int s, int e) {
        while (s < e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

}
