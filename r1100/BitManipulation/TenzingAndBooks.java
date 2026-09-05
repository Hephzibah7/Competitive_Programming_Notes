// package r1100.BitManipulation;
/*
Observe the bitwise OR: if a bit of the knowledge changes to 1
, it will never become 0
.

It tells us, if a book has difficulty rating y
, and x|y≠x
, Tenzing will never read this book because it will change a 0
 bit in x
 to 1
.

We called a number y
 valid if x|y=x
. For each sequence, we can find a longest prefix of it such that all numbers in this prefix are valid. Find the bitwise OR of the three prefix and check whether it equals to x
.

Time complexity: O(n)
 per test case.
*/
import java.io.*;
import java.util.*;
public class TenzingAndBooks {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            long x=Long.parseLong(str[1]);
            long data[][]=new long[3][n];
            for(int i=0; i<3; i++){
                String strarr[]=br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    data[i][j]=Long.parseLong(strarr[j]);
                }            
            }
            if(check(data,x,n)==true) System.out.println("yes");
            else System.out.println("no");

        }

    }
    static boolean check(long arr[][], long x, int n){
        long val=0;
        if(val==x) return true;
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                long temp=val|arr[i][j];
                if(((temp)&x)==temp) {
                val=val|arr[i][j];
                 if(val==x) return true;
                }
                else break;
            }
        }
        return false;
    }
}
