package r1000.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
we want to minimize LCM(a,b) subject to a+b=n and a>0 and b>0
Assume, a<=b
case 1-
If a|b,
LCM(a,b)=b, as b<=n the answer is always less than equal to n, if a divides b
If a does not divide b,
we know, LCM(a,b)=a*b/gcd(a,b) -(1)
so as a does not divide b, so gcd(a,b)<a, (why gcd if a and b is the greatest common divisor of a and b, so gcd(a,b) by rules
is always less than or equal to the smallest value here it is a, but since a does not divde b in this case , so cd cannot be equal to 
a, will ofc be lesser than a).
Thus the largest possible gcd will be a/2, (why? -> every divisor of a is atmost a/2)
hence gcd(a,b)<=a/2
Therefore if you put the above relation in eq 1,
then lcm(a,b)=gcd(a,b)/(a/2), thus lcm(a,b)>=2b, when a does not divide b

That is bad why?
since a+b=n,
and a<=b, then b>=n/2=>2b>=n,
so lcm(a,b)>=n in case when a does not divide b,
but if a divides b then lcm(a,b) will be less than n,
so if a divides b, so a+b=n, a+xa=n, a(1+x)=n, a also divides n
so the crux of the problem is to find a, which divides n, and then find b by this relation a+b=n,
and find the smaller b, because b will be the lcm,
what about when n is prime number then?
the only number that divides n is 1 so a becomes 1, and b=n-1
*/
public class MinimumLCM {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         int n=Integer.parseInt(br.readLine());
         int a=-1;
         int b=n;
         for(int i=2; i*i<=n; i++){
            //when you traverse till sqrt of n, you get two divisors of n at a time, one is i, other is n/i
            if(n%i!=0) continue;
            int temp=n-i;
            if(temp<b){
                b=temp;
                a=i;

            }
            int candidate=n/i;
            temp=n-candidate;
            if(temp<b){
                b=temp;
                a=candidate;

            }
            
         }
         if(a==-1) System.out.println(1 + " "+ (n-1));
         else System.out.println(a+" "+b);

        }
       
    }
}
