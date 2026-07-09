package r1000.String;
import java.io.*;
import java.util.*;

public class SwapAndDelete {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str=br.readLine();
            int n=str.length();
            int ones=0;
            int zeros=0;
            for(int i=0; i<n; i++){
                if(str.charAt(i)=='0') zeros++;
                else ones++;
            }
            int ans=0;
            for(int i=0; i<n; i++){
                char ch=str.charAt(i);
                if(ch=='0'){
                    if(ones==0){
                        ans=n-i;
                        break;
                    }
                    ones--;
                }
                else{
                    if(zeros==0){
                        ans=n-i;
                        break;
                    }
                    zeros--;
                }
            }
           System.out.println(ans);

        }
       
    }
}
