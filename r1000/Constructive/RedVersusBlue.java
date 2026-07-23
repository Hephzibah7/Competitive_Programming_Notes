import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedVersusBlue {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int r=Integer.parseInt(str[1]);
            int b=Integer.parseInt(str[2]);
            int val=r/(b+1);
            StringBuilder sb=new StringBuilder();
            StringBuilder str1=new StringBuilder();
            for(int i=0; i<val; i++) str1.append('R');
            StringBuilder str2=new StringBuilder(str1).append("R");
            int i=0;
            int count=0;
            int req=r-val*(b+1);
          
            while(i<n){
                if(count<req){
                    sb.append(str2);
                    i+=val+1;
                }
                else{
                    sb.append(str1);
                    i+=val;
                }
                if(i<n) {
                    sb.append('B');
                    count++;
                    i++;
                }
            }
            System.out.println(sb);
            
            

        }
       
    }
    
}
