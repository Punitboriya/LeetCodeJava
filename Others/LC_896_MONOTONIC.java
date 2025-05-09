package Others;

public class LC_896_MONOTONIC {

    public static void main(String[] args) {

        int[] a = { 4, 8, 9, 7, 77 };

        System.out.println(mono2(a));

    }

    private static boolean mono(int[] a) {
        boolean inc = true, dec = true;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                dec = false;
            } else if (a[i] > a[i + 1]) {
                inc = false;
            }
        }
        return inc || dec;
    }

    private static boolean mono2(int[] a) {
        int ci = 0, cd = 0;

        if (a.length == 1) {
            return true;
        }

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] <= a[i + 1]) {
                System.out.println("Inc : a[i]=" + a[i] + " a[i+1]=" + a[i + 1]);
                ci++;
            }
            if (a[i] >= a[i + 1]) {
                System.out.println("Dec :  a[i]=" + a[i] + " a[i+1]=" + a[i + 1]);
                cd++;
            }
            if (ci == a.length - 1 || cd == a.length - 1) {
                System.out.println("Length of array :" + a.length);
                System.out.println("i=" + i + " ci= " + ci);
                System.out.println("i=" + i + " cd= " + cd);
                return true;
            }
            System.out.println("---------");
        }

        return false;

    }

    private static boolean monofinal(int[] a) {

        if (a.length == 1) {
            return true;
        }
        int ci = 0, cd = 0;

        for (int i = 0; i < a.length - 1; i++) {//
            if (a[i] <= a[i + 1]) {// 6<=4,4<=4
                ci++;// 1
            }
            if (a[i] >= a[i + 1]) {//
                cd++;// 1
            }
            if (ci == a.length - 1 || cd == a.length - 1) {
                return true;
            }
        }
        return false;
    }

}
