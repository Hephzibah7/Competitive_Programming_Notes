package r1000.PrefixSum;
import java.io.*;
import java.io.IOException;

public class TrafficLight {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         char ch=str[1].charAt(0);
         String input=br.readLine();
         String temp=input+input;
         int prefix[]=new int[2*n];
         int len=2*n;
         prefix[len-1]=(input.charAt(n-1)=='g')?len-1:0;
         for(int i=len-2; i>=0; i--){
            if(temp.charAt(i)=='g') prefix[i]=i;
            else prefix[i]=prefix[i+1];
         }
         int max=0;
         for(int i=0; i<n; i++){
            if(input.charAt(i)==ch){
                max=Math.max(max,prefix[i]-i);
            }
         }
         System.out.println(max);
        }
    }

}
