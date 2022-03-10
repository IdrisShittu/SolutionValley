import java.util.*;
import javax.swing.*;
public class ProjRem{
	public static void main (String args[]){
		String result="",res; int count; int comb=0; char con='1';
		
	int len=Integer.parseInt(JOptionPane.showInputDialog("enter length:"));
    long[] A = new long [len];
    
    for(int i=0;i<len;i++){
    			A[i]=Integer.parseInt(JOptionPane.showInputDialog("enter "+(i+1)+" data" ));
    		}//next for i
    	
    		int power=1;
    		
		for(int a=1;a<=len;a++){
			power=power*2;
			}
			
		for(int i=3;i<power;i++){
			
			res="";count=0;
			for(int j=i;j>0;j=j/2){
				res+=j%2;
				if(j%2==1)count++;
			}
			
			if (count==1)continue;
		
			comb=0;
			
			for(int a=0;a<res.length();a++){
		
				if(res.charAt(a)==con){
					comb+=A[a];
					result+=A[a]+",";
				}
			    
			}
			
			if(comb==0){
				JOptionPane.showMessageDialog(null,result,"result..",JOptionPane.INFORMATION_MESSAGE);
			}
			result="";
		
			
		}


	
	}
}