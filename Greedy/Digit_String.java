import java.io.*;
import java.util.*;
/*

Digit_String is a greedy problem where we have to find the minimum number of operations to make 
the string beautiful. A string is beautiful if we we cannot choose any subsequences from the string
such that it is divisible by 4.
The characters in the string is expected to be 1,2,3,4
If the character in the string is 4- It ofcourse is divisible by 4, so we have to remove all 4's present in the string.
So what are the possible subsequences that could be divisible by 4-12,32
So whenever we see odd number-1,3 and even number-2, are paired it can form a string divisible by 4.
odd number (1,3) + even number (2) wrong (its not a valid beautiful string)
So what pair do we need to get beautiful string?
even number(2)  + odd number(1,3) right (ex-21, 23, 31 , 33)
All even character is also valid (ex-222222)
All odd character is also valid (ex-1111,3333)
So we loop through each index in the given string, and find the number of 2's in the left and number of 1's and 3's
in the right, and our goal will be maximize that.
At the end the answer will be-
ans=
Either the string.length-max(even and odd pair)
or string.length-all(even character)
or string.length-all(odd character)
The ans gives us the minimum operations required to make string beautiful.
Remember a string which has no 12,13 subsequence (length 2), it will not have (212,312), i mean to say, if we are checking 
for 2 length subsequence possibility in the given string, we do not have to check for subsequence 3,4 or more than that.

*/ 
public class Digit_String {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String s=br.readLine();
         int len=s.length();
         int suff=0;
         int pref=0;
         for(int i=0; i<len; i++){
            if(s.charAt(i)=='1' || s.charAt(i)=='3') suff++;
         }
         int ans=suff;
         for(int i=0; i<len; i++){
            if(s.charAt(i)=='1' || s.charAt(i)=='3') suff--;
            if(s.charAt(i)=='2') pref++;
            ans=Math.max(ans, suff+pref);

         }
         System.out.println(len-ans);

        }
       
    }
    
   
    
}



