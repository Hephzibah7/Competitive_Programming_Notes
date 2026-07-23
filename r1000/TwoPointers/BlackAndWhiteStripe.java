// package r1000.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackAndWhiteStripe {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String s=br.readLine();
            int black=0;
            int white=0;
            for(int i=0; i<k; i++){
                if(s.charAt(i)=='B') black++;
                else white++;
            }
            int l=0;
            int r=k-1;
            int min=Integer.MAX_VALUE;
            while(l<=r && r<n){
              
                min=Math.min(min, white);
                if(s.charAt(l)=='W'){
                    white--;
                }
                l++;
                r++;
                if(r<n && s.charAt(r)=='W') white++;
            } 
            System.out.println(min);

        }
       
    }
}
