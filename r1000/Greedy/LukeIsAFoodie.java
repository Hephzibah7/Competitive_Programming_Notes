/*
https://codeforces.com/problemset/problem/1704/B

Given,
Luke has to travel from left to right and he wants to finish all piles of food, he can eat a pile only when
Math.abs(v-ai)<x otherwise you need to change v
Goal to minimize the number of changes,

∣v−ai​∣≤x 
means- −x≤v−ai​≤x
which is equal to ai​−x≤v≤ai​+x, so every element gives us the interval of v,
but we need only single value of v right? so which interval should we consider?
ofc the intersection of each intervals?
we would go on traversing the array, go on intersecting the intervals, until l>r, this case is invalid,
why we intersect the interval, we intersect the interval this tells us that there is a valid v value in the range between
l and r, such that luke can eat the current element, but if the intersection gives the invalid case that is l becomes
greater than r, which means there is no valid v available and so we need to change the interval,
so count++

Pattern to remember-
Whenever you see:
One variable (v) must satisfy many constraints.
Each constraint gives a valid interval.
Think:
Maintain the intersection of all valid intervals.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LukeIsAFoodie {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            long x=Long.parseLong(str[1]);
            String strarr[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
            int count=0;
            int i=1;
            long l=arr[0]-x;
            long r=arr[0]+x;
            while(i<n){
                long currl=Math.max(l,arr[i]-x);
                long currr=Math.min(r,arr[i]+x);
                if(currl>currr){
                    count++;
                    l=arr[i]-x;
                    r=arr[i]+x;
                }
                else{
                    l=currl;
                    r=currr;
                }
                i++;
            }
            System.out.println(count);

        }
       
    }
}
