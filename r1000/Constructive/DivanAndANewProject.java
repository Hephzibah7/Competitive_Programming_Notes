package r1000.Constructive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class DivanAndANewProject {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0; i<n; i++) a[i]=Integer.parseInt(str[i]);
            Integer arr[]=new Integer[n];
            for(int i=0; i<n; i++) arr[i]=i;
            
            Arrays.sort(arr, (i,j)->Integer.compare(a[j], a[i]));
        
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0; i<n; i++) arr[i]=arr[i]+1;
            Arrays.sort(a);
            for(int i=0; i<n; i++){
                map.put(arr[i],a[n-i-1]);
            }
            List<Integer> list=new ArrayList<>();
            for(int i=0; i<n; i++){
                if(i%2==0) list.add(arr[i]);
            }
            Collections.reverse(list);
            list.add(0);
            for(int i=0; i<n; i++){
                if(i%2!=0) list.add(arr[i]);
            }
            int ans[]=new int[n+1];
            for(int i=0; i<list.size(); i++){
                ans[list.get(i)]=(i+1);
            }
            long val=0;
            int temp=ans[0];
            
            for(int i=1; i<list.size(); i++){
                val+=1L*Math.abs(temp-ans[i])*map.get(i);
                
            }
            System.out.println(val*2);
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<=n; i++) sb.append(ans[i]+" ");
            sb.trimToSize();
            System.out.println(sb);

        }
       
    }
}
