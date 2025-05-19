package Blind75;

public class LC05_70_CS {
    public static void main(String[] args) {
       int n=6;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int a[]= new int[n+1];
        a[1]=1;
        a[2]=2;
        for(int i=3;i<a.length;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
    }
}
