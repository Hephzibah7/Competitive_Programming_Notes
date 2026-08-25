package r1100.Maths;
/*
Question asks to count the number of distinct strings.
And we are given possible operations.
Through possible operations -> we can have different sequence
We dont have to count different sequences we have to count this sequences producing different strings
so what kind of sequences produce same strings?

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class EraseFirstOrSecondLater {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0; i<n; i++){
                char ch=str.charAt(i);
                if(!map.containsKey(ch)) map.put(ch,i);
            }
            int count=0;
            for(int i=0; i<n; i++){
                if(map.get(str.charAt(i))==i) count+=n-i;
            }
            System.out.println(count);

        }
       
    }
}
