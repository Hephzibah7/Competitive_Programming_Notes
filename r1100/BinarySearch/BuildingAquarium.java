// package r1100.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BuildingAquarium {
      public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            long x=Long.parseLong(str[1]);
            String strarr[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
            long max=0;
            for(int i=0; i<n; i++) max=Math.max(max, arr[i]);
            long low=1;
            long high=max+x;
            long ans=0;
            Arrays.sort(arr);
            while(low<=high){
                long mid=(low+high)/2;
                if(findTotal(arr,mid)<=x){
                    ans=mid;
                    low=mid+1;
                }
                else high=mid-1;
            }
            System.out.println(ans);

        }
       
    }
    static long findTotal(long[] arr, long h){
        long sum=0;
        int i=0;
        while(i<arr.length && arr[i]<=h) {
            sum+=h-arr[i];
            i++;
        }
        return sum;
    }
}
