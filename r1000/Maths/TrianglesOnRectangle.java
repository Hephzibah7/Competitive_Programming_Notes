package r1000.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrianglesOnRectangle {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int w=Integer.parseInt(str[0]);
            int h=Integer.parseInt(str[1]);
            long max=0;
            for(int k=0; k<4; k++){
                String temp[]=br.readLine().split(" ");
                int len=Integer.parseInt(temp[0]);
                int first=0;
                int last=0;
                for(int i=0; i<len; i++){
                    int x=Integer.parseInt(temp[i+1]);
                    if(i==0) first=x;
                    if(i==len-1) last=x;
                }
                int height=(k<=1)?h:w;
                int base=last-first;
                max=Math.max(max, 1L*base*height);

            }
            System.out.println(max);

        }
       
    }
}
