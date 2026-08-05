/*
https://codeforces.com/problemset/problem/1418/A

Derive the formula-
So,
number of trades= ((((y+1)*k)-1)/(x-1))+k
*/
package r1000.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyingTorches {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            long x=Long.parseLong(str[0]);
            long y=Long.parseLong(str[1]);
            long k=Long.parseLong(str[2]);
            long temp=((y+1)*k)-1;
            long d=x-1;
            long val=((temp+d-1)/d);
            System.out.println(val+k);

        }
       
    }
}
