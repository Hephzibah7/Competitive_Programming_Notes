// package r1000.BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
https://codeforces.com/problemset/problem/1438/B

Simple Problem-
If you notice each unique element in b, gives unique element in b, by relation ai=2^bi
If the array b consists of duplicate elements, so will array a contain.
And if array contains duplicate elements like 4 2 8 4, then we can at very instant get two non intersecting subarrays
where sum is equal, here 4.
But if the array a contains all distinct elements, then?
Think of binary number, give me a binary number who decimal is 12?
1100 right?
any other combination?
No which means 12 has only one combination 8+4, when array elements are the power of 2,
which means, that no two subarrays with distinct elements can form same sum.
*/
public class ValeriiAgainstEveryone {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(str[i]);
            HashSet<Long> set=new HashSet<>();
            for(int i=0; i<n; i++) set.add(arr[i]);
            if(set.size()<n) System.out.println("YES");
            else System.out.println("NO");

        }
       
    }
}
