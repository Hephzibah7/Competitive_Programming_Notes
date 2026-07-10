

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkiResort {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         long k=Long.parseLong(str[1]);
        long q=Long.parseLong(str[2]);
        String strarr[]=br.readLine().split(" ");
        int arr[]=new int[n];
        for(int i=0; i<n; i++) arr[i]=Integer.parseInt(strarr[i]);
        int i=0;
        long ans=0;
        while(i<n){
            if(arr[i]<=q){
                int index=i;
                int j=i;
                while(j<n && arr[j]<=q){
                    long temp=index+k-1;
                    if(temp<=j) ans+=j-temp+1;
                    j++;
                }
                i=j;
            }
            else i++;
        }
        System.out.println(ans);

        }
       
    }
}
