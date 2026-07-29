package r1000.Maths;
/*
https://codeforces.com/problemset/problem/1474/B
Given d, let p be the smallest number after 1 which divides a,
p should be primes why?
As we know since p should be the smallest number after 1 that divides a so p-1>=d,
that is p>=1+d,
So, if p is not a prime number, anything dividing p whill be <p, will also divide a
which will be less than d, so since p is the smallest number dividing a, p should be primes number,
q should be such that q>=p+d, and even q should be prime number for above same reasons.
now x=p*q, x will be the number who first factors will be p and q.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferentDivisors {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int d=Integer.parseInt(br.readLine());
            int primes[]=new int[100001];
            
            for(int i=2; i*i<=100000; i++){
                if(primes[i]==1) continue;
                for(int j=i*i; j<=100000; j+=i){
                    primes[j]=1;
                    
                }
            }
            
            int p=1+d;
            while(primes[p]!=0) p++;
            int q=p+d;
            while(primes[q]!=0) q++;
            int x=p*q;
            System.out.println(x);

        }
       
    }
}
