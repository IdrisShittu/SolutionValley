//8.20.3.-2.3.7.16.-9
import  java.util.*;
import javax.swing.*;
public class TheSolution{
	
    static int target1=0;
    static int target2=0;
    static int len=0;
    static int subLen=0;
    static List<Integer> entry = new ArrayList();
	
	public static void main(String[] args) {
		
		len=Integer.parseInt(JOptionPane.showInputDialog("Enter Set Size:"));
		subLen=Integer.parseInt(JOptionPane.showInputDialog("Enter SubSet Size:"));
		target1=Integer.parseInt(JOptionPane.showInputDialog("Enter TargetSum1:"));
		target2=Integer.parseInt(JOptionPane.showInputDialog("Enter TargetSum2:"));
		
		int input;
		for(int i=0;i<len;i++){
    		input=Integer.parseInt(JOptionPane.showInputDialog("enter "+(i+1)+" data" ));
    		entry.add(input);	
    	}//next for i
    	
    	
    		
     	
      	System.out.println("Input Set");
      	System.out.println(entry);
      	System.out.println("Set Size:" + entry.size());
      	System.out.println("SubSet Size: " + subLen);
      	System.out.println("No of subset Enumerated: "+ getCombinations(subLen,entry).size());
      	System.out.println("No successful Subset");
		
		}

public static  List<List<Integer>> getCombinations(int k, List<Integer> list) {
	
	int sum = 0;
	int val = 0;

	
    List<List<Integer>> combinations = new ArrayList();
    if (k == 0) {
        combinations.add(new ArrayList());
        return combinations;
    }
    for (int i = 0; i < list.size(); i++) {
        Integer element = list.get(i);
        List<Integer> rest = getSublist(list, i+1);
        for (List<Integer> previous : getCombinations(k-1, rest)) {
            previous.add(element);
            
            sum = 0;
            
            
            if((previous.size())==subLen){
            	
            	
            
            
            	for (int temp : previous) {
            		sum += temp;
            	}
            	
            	if(sum==target1){
            		
            		System.out.println("**********************Target Sum 1*********************");
            		Collections.reverse(previous);
            		System.out.println("Subset : " + previous + " sum :" + sum);
            		System.exit(0);
            		
            	}else if(sum==target2){
            		
            		System.out.println("**********************Target Sum 2*********************");
            		Collections.reverse(previous);
            		System.out.println("Subset : " + previous + " sum :" + sum);
					entry.removeAll(previous);
					System.out.println("CompSet : " + entry );
					System.exit(0);
            		
            	}
			
			}
			
            combinations.add(previous);
        }
        
        
    }
    return combinations;
}

public static <Integer> List<Integer> getSublist(List<Integer> list, int i) {
    List<Integer> sublist = new ArrayList();
    for (int j = i; j < list.size(); j++) {
        sublist.add(list.get(j));
    }
    return sublist;
}

}