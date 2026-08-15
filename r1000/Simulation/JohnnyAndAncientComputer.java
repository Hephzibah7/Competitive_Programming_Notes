/*
https://codeforces.com/contest/1362/problem/A

Things to observe-
If a=ra*2^x
and b=rb*2^y,
you need to convert a to b by dividing a by 2 till you reach b,
So you can reduce a to b only if ra=rb, ra and rb here are odd values


*/
package r1000.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JohnnyAndAncientComputer {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            long a=Long.parseLong(str[0]);
            long b=Long.parseLong(str[1]);
            long ra=a;
            long rb=b;
            while(ra%2==0) ra/=2;
            while(rb%2==0) rb/=2;
            if(ra!=rb){
                System.out.println(-1);
                continue;
            }
            a=a/ra;
            b=b/rb;

            a=(long)(Math.log(a)/Math.log(2));
            b=(long)(Math.log(b)/Math.log(2));
            long ans=(long)Math.ceil(Math.abs(a-b)/3.0);
            System.out.println(ans);

        }
       
    }
}
