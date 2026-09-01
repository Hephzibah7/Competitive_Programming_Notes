package r1100.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
No proper monotonic pattern observable so any kind of sorting is not needed.
Since we will loop for each i, then (k-i) will be remaining, this we will pick from the highest (k-i) times from b array
*/
public class Quests {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String stra[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0; i<n; i++) a[i]=Integer.parseInt(stra[i]);
            String strb[]=br.readLine().split(" ");
            int b[]=new int[n];
            for(int i=0; i<n; i++) b[i]=Integer.parseInt(strb[i]);
            long sum=0;
            long max=0;
            long ans=0;
            for(int i=0; i<Math.min(n,k); i++){
                sum+=a[i];
                max=Math.max(max,b[i]);
                ans=Math.max(ans,sum+(max*(k-(i+1))));
            }
            System.out.println(ans);


        }
       
    }
}
