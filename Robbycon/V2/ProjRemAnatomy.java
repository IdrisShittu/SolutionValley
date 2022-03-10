import java.util.*;
import javax.swing.*;
public class ProjRemAnatomy{
	
	
		public static void sub(long A[]){

		double total = 0; int colum; int coum=1;
    	double x,q,lo = 1;int vb;
    	String input, inp;
    	double t = 0; long start=0; long end=0;
		String output = "Subscript\tValue\n";
		String seval="";String seva="";String seal="";

		double[] arry = new double[A.length]; double[] n = new double[A.length]; double[] c1n = new double[A.length];

    	for ( int counter = 0; counter < A.length; counter++ )
    	{

			total += A[ counter ];

			seval = seval + A[ counter ]+ ", ";
			//start = System.currentTimeMillis();
    	}


		for ( int counter = 0; counter < A.length; counter++ )
    	{
    		arry[ counter ] = 2 * A[ counter ];
    		seva = seva + arry[ counter ] + ",  ";
    	}

    	for ( int counter = 0; counter < arry.length; counter++ )
    	{
    		n[ counter ] = arry[ counter ] - total;
    		seal = seal + n[ counter ] + ",  ";

    	}


    	for ( int counter = 0; counter < n.length; counter++ )
    	{
    		double cou = n.length;
    		double fir = n[counter];
			for ( colum = coum; colum < cou; colum++ )
    		{
    			String hj="";
    			double sec = n[colum];

    				c1n[colum] = fir + n[colum];
    				if(c1n[colum] == 0)
    				{
    					for ( int colums = 0; colums < A.length; colums++ )
    					{
    						double cons = counter, colu = colum;
    						if (colums != cons)
    						{

    								if (colums != colu)
    								{
    									hj = hj + A[colums] + ", ";

    								}

    						}
    					}
    					JTextArea outputArea = new JTextArea();
    					//end = System.currentTimeMillis();

    					long res = end - start;
    					JOptionPane.showMessageDialog( null,"Result is: " + hj, "Detect Input", JOptionPane.INFORMATION_MESSAGE );
    					System.exit( 0 );
    				}

    		}
    		coum = coum + 1;
    		String outpt = "Subscript\tValue\tColum\n";


    	}

    	for ( int counter = 0; counter < c1n.length; counter++ )
    	{
    		double chk = c1n[counter];double len = c1n.length;
			if(chk != 0)
    		{
				JOptionPane.showMessageDialog( null,"No result. Please follow procedure!", "You do not follow procedure!", JOptionPane.INFORMATION_MESSAGE );
    			System.exit( 0 );
    		}

    	}



 System.exit( 0 );


	}
	
	
	
	
	
	public static void main (String args[]){
		String res; int count; int b; char con='1'; long resulti,resultj,comb=0;int conn; String ana;
		
	int len=Integer.parseInt(JOptionPane.showInputDialog("enter length:"));
    long[] A = new long [len+1];
    
    for(int i=0;i<len;i++){
    			A[i]=Integer.parseInt(JOptionPane.showInputDialog("enter "+(i+1)+" data" ));
    		}//next for i
    A[len]=0;
    		int power=1;
    		
    for(int a=1;a<=len+1;a++){
			power=power*2;
			}
    	
    		
    
    		
		
			
label2:		for(int i=3;i<power;i++){
			
		
			
			
			   for(int c=0;c<len;c++){
label1:			for(int d=c+1;d<=len;d++){
    		
    		resulti=A[c];resultj=A[d];
    		if((A[c]+A[d])==0)continue label1;
    		
			
			
			res="";count=0;conn=0;
			for(int j=i;j>0;j=j/2){
				conn++;
				if((conn-1)==c){
					res+=0;
					continue;
				}
				if((conn-1)==d){
					res+=0;
					continue;
				}
				
				res+=j%2;
				if((j%2)==1)count++;
				
			}
			
			if (count<=1)continue label2;
			System.out.print("domain: ("+A[c]+","+A[d]+")");
			comb=A[c]+A[d];
			b=2;
			long[] result=new long[count+2];
			result[0]=resulti;
    		result[1]=resultj;
    		ana="";
			for(int a=0;a<res.length();a++){
					
				if( (res.charAt(a)==con) && (a!=c) && (a!=d)){
					ana+=(A[a]+" ");
					comb+=A[a];
					result[b++]=A[a];
					}
			    
			}
			
			System.out.println(ana);
			System.out.println();
			if(comb==A[c]+A[d]){
				System.out.println("result:____________________________________________________________");
				for(int m=0;m<count+2;m++)System.out.print(result[m]+" ");
				System.out.println();
				
			}
			
		
			
		}

	   }
	  }
	
	}
}