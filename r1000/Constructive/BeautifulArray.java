
/*
https://codeforces.com/contest/1715/problem/B


Explanation-
This is a constructive problem since we need to construct the array.
Given,
  Summation Math.floor(ai/k) = b
  where a1+a2....an=s,

  How to construct the array-
  s=a1+a2...an
  s=(kq1+r1)+(kq2+r2)....+(kqn+rn)
  s=k(q1+q2...qn)+(r1+r2...rn)

  Since we know that summation of all quotient is nothing but beauty or b so the above equation can be written as
  s=kb+(r1+r2...rn) where remainder can be 0 to k-1,
  what is the minimum value s can be- s=kb+0+0...0=s=kb,
  what is the maximum value s can be- s=kb+(k-1)+(k-1)...=kb+n(k-1)

  lets take an example- 
  if k=5, n=3, s=27, b=4
   what should be a[0]=5*4=20, now if you see the first element of the array already satisfies the given beauty right,
   if a[0]=20, then we can say beauty  of the array is b, only when other elements do not contribute any beauty,
   that can be only ppossible if they are smaller than k, so in above problem
   need=27-20=7,
   we cannot add 7 to a[0] since then 27/5=5, which surpasses the beauty so we can add maximum value possible so that beauty doesn
   surpass b, that is 20+4=4, right?
   a[0]=24, 24/5=4 which is equal to b,
   now need=27-24=3, 
   so a[1]=3 less than k, that is less than 5, the contribution of this element in beauty is 0, that is 3/5=0,
   so now the array is=[24,3,0]
*/
package r1000.Constructive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class BeautifulArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            BigInteger k = new BigInteger(str[1]);
            BigInteger b = new BigInteger(str[2]);
            BigInteger s = new BigInteger(str[3]);
            BigInteger arr[] = new BigInteger[n];
            BigInteger val = k.multiply(b);
            Arrays.fill(arr,BigInteger.ZERO);
            if (s.compareTo(val) < 0 ||
                    s.compareTo(val.add(k.subtract(BigInteger.ONE)
                            .multiply(BigInteger.valueOf(n)))) > 0) {
                System.out.println(-1);
                continue;
            }
            if (s.equals(k.multiply(b))) {
                arr[0] = s;
            }
            else{
            BigInteger need = s.subtract(val);
            
            arr[0]=val;
            int i=0;
            while (need.compareTo(BigInteger.ZERO) > 0 && i<n) {
               
                BigInteger temp = need.min(k.subtract(BigInteger.ONE));
                need=need.subtract(temp);
                 
                arr[i]=arr[i].add(temp);
               
                i++;
            }
        }
            StringBuilder sb=new StringBuilder();
            for(int j=0; j<n; j++) sb.append(arr[j]+" ");
            sb.trimToSize();
            System.out.println(sb);

        }

    }
}
