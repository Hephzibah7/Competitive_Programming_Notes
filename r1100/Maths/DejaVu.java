package r1100.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DejaVu {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String strarr[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
            String strq[]=br.readLine().split(" ");
            long q[]=new long[k];
            for(int i=0; i<k; i++) q[i]=Long.parseLong(strq[i]);
            long minx=100;
            for(int i=0; i<k; i++){
                if(q[i]>=minx) continue;
                for(int j=0; j<n; j++){
                    if(arr[j]%((long)Math.pow(2,q[i]))==0) arr[j]+=(long)Math.pow(2,q[i]-1);
                }
                minx=Math.min(minx,q[i]);
            }
            for(int i=0; i<n; i++) System.out.print(arr[i]+" ");
            System.out.println();

        }
       
    }
}
