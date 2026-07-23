
/*
https://codeforces.com/problemset/problem/1632/B


Explanation-
Important mathematcal observation
For suppose n=4,
For any combination of permutation, the maximum xor will always be >=2^k, where k in the highest vhecked bit
lets take this combination= 0,1,2,3=max(1,3,1)=3
1,0,2,3=max(1,2,1)
2,0,1,3=max(2,1,2)

so 0=00, 1=01, 2=10, 3=11, here the highest checked bit is 1, and so 2^1=2, so the max xor will never be less than 2,
but we have to make sure such that the xor does not get greater than 2^k,
group 1=where the highest bit here bit 1 is bot checked (0,1)
group 2=where the highest bit that is bit 1 is checked (2,3)
so you can rearrange group 1 and 2 anyhow but, where pairing group 1 and group 2,
always keep 0,2^k, here 0,2 together such that the max xor is 2
*/
package r1000.BitManipulation;
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
