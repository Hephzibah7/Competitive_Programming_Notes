import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class DistinctSplit {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
            HashMap<Character,Integer> map1=new HashMap<>();
            HashMap<Character,Integer> map2=new HashMap<>();
            for(int i=0; i<n; i++){
                char ch=str.charAt(i);
                map2.put(ch, map2.getOrDefault(ch,0)+1);
            }
            int max=0;
            for(int i=0; i<n-1; i++){
                char ch=str.charAt(i);
                map1.put(ch, map1.getOrDefault(ch,0)+1);
                int temp=map2.get(ch);
                temp--;
                if(temp==0) map2.remove(ch);
                else map2.put(ch,temp);
                max=Math.max(max,map1.size()+map2.size());
            }
            System.out.println(max);

        }
       
    }
}
