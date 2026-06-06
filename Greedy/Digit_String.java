import java.io.*;
import java.util.*;

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



