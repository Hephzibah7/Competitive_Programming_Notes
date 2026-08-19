import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ReverseASubstring {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n=Integer.parseInt(br.readLine());
       String str=br.readLine();
       char arr[]=new char[n];
       for(int i=0; i<n; i++) arr[i]=str.charAt(i);
       Arrays.sort(arr);
        StringBuilder sb1=new StringBuilder(str);
        StringBuilder sb2=new StringBuilder();
        for(int i=0; i<n; i++) sb2.append(arr[i]);
        if(sb1.toString().equals(sb2.toString())) System.out.println("NO");
        else {
            System.out.println("YES");
            int temp=0;
            while(temp<n && sb1.charAt(temp)==sb2.charAt(temp)) temp++;
            int num=sb2.charAt(temp);
            int temp2=temp+1;
            while(temp2<n && sb1.charAt(temp2)!=num) temp2++;
            System.out.println((temp+1)+" "+(temp2+1));

        }
       
    }
}
