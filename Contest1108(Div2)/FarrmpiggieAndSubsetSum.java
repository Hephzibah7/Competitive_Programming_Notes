import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
For a permutation∗
 p
 of even length, you can do the following process:

Initialize a counter c=0.
For each i
 from 1
 to n,
 either add i⋅pi
 to c
, subtract i⋅pi
 from c
, or do nothing.
Let the final value of the counter be cfinal.
Formally, for each i∈{1,…,n},
 consider the set Si={−i⋅pi,0,i⋅pi}
 and choose some xi∈Si.
 Set cfinal=∑ni=1xi.

You are given a single even integer n
. Find any permutation of length n
 so that regardless of the operations chosen, the final value cfinal
 will not be 1.

∗
A permutation of length n
 is an array consisting of n
 distinct integers from 1
 to n
 in arbitrary order. For example, [2,3,1,5,4]
 is a permutation, but [1,2,2]
 is not a permutation (2
 appears twice in the array), and [1,3,4]
 is also not a permutation (n=3
 but there is 4
 in the array).

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤25
). The description of the test cases follows.

The first and only line of each test case contains a single even integer n(2≤n≤50)
 — the length of the desired permutation.

Output
For each test case, output n
 integers p1,…,pn(1≤pi≤n)
 — a permutation satisfying the conditions.

If there are multiple solutions, print any of them.
*/


/*
Here we have to make sure that the submission of xi where xi belongs to Si and Si={-pi*i,0,+p*i} is not equal to 1,
when two numbers are equal to 1, probably when there are conseqcutive, or when the element itself is 1,
suppose all the numbers in the array is even, lets take below example,
{2,-4,8,-10}=here the sum of the elements is always even right?
Thus we noticed a pattern if each xi is even the sum will never be equal to 1,
xi can be {-pi*i,0,+p*i},
so how do we make sure that all elements in the array is even, since each element in the array if formed my multipilying there
index, for even index the element will always be even right?
suppose if i is even then {-pi*i,0,+p*i} will be even and thus xi for that even i will be even,
but for odd indexes how do we make sure that xi will be even ofc by multiplying by even numbers the xi will be even,
so since n is even we can reverse the permutation, in that way, in odd indexes we get even pi, and in even indexes we get off pi,
so resulting in each element becoming even and so the sum now never becomes equal to 1,
*/
public class FarrmpiggieAndSubsetSum {
      public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         int n=Integer.parseInt(br.readLine());
         for(int i=n; i>1; i--) System.out.print(i+" ");
         System.out.println(1);

        }
       
    }
}
