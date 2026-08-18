import java.io.*;
import java.util.*;

/*
https://codeforces.com/contest/2246/problem/C
So in the question, we are asked to find such sequence from given array, whose alternating sum is 0.
Thing to observe from the question is-
Suppose the array goes like this - [a1,a1,a1] <- which means the array consists of equal elements.
If I choose index 0 and 1 the array is - [a1,a1] length of the array =k1
If I choose index 1 and 2 the array is - [a1,a1] length of the array=k2

The above two array or sequences are considered different although k1=k2, because there exists an index j, such that
ij!=ij', index in first array is =0 and 1, index in second array is=1 and 2,
so there is a pair of index in the array here 0 index from first array and 2 index from seocnd index whixh are not equal
If index in first array = 0 and 1, index in second array was = 1 and 0
Here the sequences are not considered different since, there is not such j where ij!=ij' where Two sets i1,…,ik1
 and i′1,…,i′k2 of indices.

 Combinatorial Fact 1-
 In an subsequence of increasing elements to make alternating sum zero, equal groups should have even frequency.
 2-2=0 Different numbers cannot cancel each  other 1-2+3-4 is never equal to 0.
 To cancel out we need even frequency of same numbers.

Combinatorial Fact 2-
Lets list subsequences of n=2
{} , {1], {1,2}, {2}

n=3
array={1,2,3}
{}
{1}
{2}
{3}
{1,2}
{1,3}
{2,3}
{1,2,3}

So we have 2^n=2^3=8 possible subsequences.
And the thing to observe is-
Number of subsequence with even length = {} , {1,2}, {1,3}, {2,3} = 4
Number of subsequence with odd length = {1} , {2}, {3}, {1,2,3} = 4

So no. of subsequences of even length = no of subsequnce of odd length

This happen always or only in this case?

Its true for every n

Why?

Every even subset has a corresponding odd subset!

Lets prove it

If 1 (you can take any number) is a part of even subset remove it, you get odd subset
If it is not a part of even subset add 1, you get odd subset

{} -> {1}
{1,2} -> {2}
{1,3} -> {3}
{2,3} -> {1,2,3}

In above, no subsequence is paired twice, or no subsequence is left alone
So if number of subseuqnece of n, is 2^n, so there is 2^(n-1) number of odd and even length subsequence!

To choose an even length from given array is -
{2,2,2,3,3,3,4,4,4}

So to choose even length from given array, we need to consider all the probabilities of choosing even length from each distinct groups

for 2 -> 2^(n-1) -> 2^(3-1) -> 2^2
for 3 -> 2^2
for 4 -> 2^2

Multiple all -> 2^2*2^2*2^2 = 2^6
Can also be written as 2^(9-3)=2^(n-d)
where n is length of array 
where d is number if distinct elements

Proof-
2^(f1-1)*2^(f2-1)*2^(f3-1)=2^(f1+f2+f3-(1+1+1))
f1+f2+f3=n
1+1+1=d
so equals to 2^(n-d)

So if the array contains even count of equal numbers that alternating sum is 0, and ways to coose even count is 2^(n-d)

As the question says the array consists of -1 and positive elements arranged in increasing order
Case 1-If we choose even length subsequences ways will be = 2^(n-d)
Case 2-Even if array contains -1, even length -1 also sums to 0, so it is considered in case 1
Case 3-Is there any combinations when 0 can be the sum except above two cases?
Yes even when 1 has odd length its sum is always -1 right?
-(-1) + (-1) - (-1) = 1 (since the original array is sorted, the pattern will always be +1,-1,+1)
So in order to sum above case 0, we need someone to cancell out that 1, by giving us -1,
this can be done by a consecutive pair say - 3 and 2
2-3=-1 right?
And there can be many such pairs, suppose consecutive pairs in given n length array is l,
so only if array contains -1,
2^(n-d) ways of choosing even count subs..
2^(n-d)*l 
suppose {-1,2,2,3,4,5,5}
to choose even length one of th way is-
{2,2} + {-1,3,4}
{2,2} + {-1,4,5}

each even length subsequence can pair with l such odd consecutive pairs

so since there can be 2^(n-d) such even arrays so ans is 2(n-d)*l

Considering all threee cases discussed above-
Answer is-
2^(n-d)+2^(n-d)*l







*/
public class OmarAndAlternatingSum {

    static final long MOD = 1000000007L;

    static long modPow(long a,long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=res*a%MOD;
            a=a*a%MOD;
            b>>=1;
        }
        return res;
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){

            int n=Integer.parseInt(br.readLine());

            String[] s=br.readLine().split(" ");

            HashMap<Long,Integer> freq=new HashMap<>();

            for(String x:s){
                long v=Long.parseLong(x);
                freq.put(v,freq.getOrDefault(v,0)+1);
            }

            long ways=1;

            for(int f:freq.values()){
                ways=ways*modPow(2,f-1)%MOD;
            }

            if(!freq.containsKey(-1L)){
                System.out.println(ways);
                continue;
            }

            long ans=ways;

            ArrayList<Long> vals=new ArrayList<>();

            for(long x:freq.keySet()){
                if(x>0) vals.add(x);
            }

            Collections.sort(vals);

            for(int i=0;i+1<vals.size();i++){
                if(vals.get(i+1)==vals.get(i)+1){
                    ans+=ways;
                    if(ans>=MOD) ans-=MOD;
                }
            }

            System.out.println(ans);
        }
    }
}