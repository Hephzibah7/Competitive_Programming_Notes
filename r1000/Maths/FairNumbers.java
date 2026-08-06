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
            String str=br.readLine();
            BigInteger b=new BigInteger(str);
            while(true){
                if(check(String.valueOf(b))==true) break;
                b=b.add(BigInteger.ONE);
            
            }
            System.out.println(b);

        }
       
    }
    static boolean check(String str){
        int n=str.length();
        boolean temp=true;
        BigInteger b=new BigInteger(str);
        for(int i=0; i<n; i++){
            int val=str.charAt(i)-'0';
            if(val!=0 && !(b.mod(BigInteger.valueOf(val)).equals(BigInteger.ZERO))) {
                temp=false;
                break;
            } 
        }
        return temp;
    }
}
