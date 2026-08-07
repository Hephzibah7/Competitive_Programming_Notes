/*
https://codeforces.com/problemset/problem/1374/C
Let's go from left to right over characters of s
 maintaining the current bracket balance (for the position i
 the balance is the number of opening brackets on the prefix till the i-th
character minus the number of closing brackets on the same prefix).
If the current balance becomes less than zero, then let's just take some opening bracket after the current position (it obviously exists 
because the number of opening equals the number of closing brackets) and move it to the beginning (so the negative balance becomes zero again 
and the answer increases by one).
 Or we can move the current closing bracket to the end of the string because it leads to the same result.
*/
package r1000.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveBrackets {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
            int ans=0;
            int balance=0;
            for(int i=0; i<n; i++){
                char ch=str.charAt(i);
                if(ch=='(') balance++;
                else balance--;
                if(balance<0) ans++;
            }
            System.out.println(ans);

        }
       
    }
    
}
