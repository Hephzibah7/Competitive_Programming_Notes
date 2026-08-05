/*
https://codeforces.com/problemset/problem/1418/A

Derive the formula-
So,
number of trades= ((((y+1)*k)-1)/(x-1))+k

New formula-
If you want ceil value of (5/3), 
if you do-
int x=Math.ceil(5/3), ->x=2
Because java first perfomrs integer division, then converts to math ceil

Solution 1-
int x=Math.ceil((doubel)5/3), ->x=3
Either type cast one of the operand to double or

Solution 2-
int x=(a+b-1)/b ->x=3
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
