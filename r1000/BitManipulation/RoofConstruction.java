// package r1000.BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoofConstruction {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            StringBuilder str=new StringBuilder(Integer.toBinaryString(n-1));
           
            str.reverse();
            int len=str.length();
            int lastbit=len-1;
            int k=lastbit;
            while(k>=0){
                if(str.charAt(k)=='0') k--;
                else break;
            }

            int num=(int)(Math.pow(2,k));
            
            StringBuilder sb=new StringBuilder();
            for(int i=num-1; i>=0; i--) sb.append(i+" ");
            for(int i=num; i<n; i++) sb.append(i+ " ");
            sb.trimToSize();
            System.out.println(sb);

        }
       
    }
}
