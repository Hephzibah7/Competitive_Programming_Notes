/*
https://codeforces.com/problemset/problem/1411/B

Important Maths observation-

See,
If you want find the super-fair number which divides all digits (1,2....9),
LCM or least common multiple of (1,2...9), It is 2520.
i.e, LCM(1,2...9)=2520,
that mean 2520 is the smallest number that is divisble by all of non zero digits, so in order to get next fair number,
we dont need to traverse infinitely because the next fair number is guarenteed to appear in the next multiple of 2520 anyway.
So increment the number until you get a fair number, maximum loop will work is till 2520.
*/
package r1000.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FairNumbers {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            long num=Long.parseLong(br.readLine());
            while(true){
                if(check(num)==true) break;
                num++;
            }
            System.out.println(num);

        }
       
    }
    static boolean check(long num){
       long temp=num;
       while(temp>0){
        int d=(int)(temp%10);
        if(d!=0 && num%d!=0) return false;
        temp=temp/10;
       }
       return true;
    }
}
