package r1100.TwoPointers;
/*
Instinctively we do greedy, for each index i from 0 to k, we check which gives us maximum choosing the first operation or second operation
But in this case the local correct answer does not guarentee the global correct answer.
So we loop through the possible operations as performing operation 1 and 2 and then 1 and 2,
is same as first perfomring all 1 and then 2, so we loop through all possible distribution like if k =3
i=0, index1=0, index2=(3-0)
i=1  index1= index2=(3-1)=2
so the sum for all the index1 operations will be prefix[2*index1]
but what if index1=3 and 2*3 crosses n, its never possible since in question uts mentioned 2k<n
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class MaximumSum {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String strarr[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
            Arrays.sort(arr);
            long prefix[]=new long[n+1];
            for(int i=1; i<=n; i++) prefix[i]=prefix[i-1]+arr[i-1];
            long sum=prefix[n];
            long max=0;
            for(int i=0; i<=k; i++){
                int index1=i;
                int index2=k-i;
                long sum1=prefix[2*index1];
                long sum2=prefix[n]-prefix[n-index2];
                max=Math.max(max,sum-(sum1+sum2));
            }
            System.out.println(max);
        }

    }
}
