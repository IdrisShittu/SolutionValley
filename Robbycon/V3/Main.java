import  java.util.*;
import javax.swing.*;

public class Main {
	public static Vector<Integer> solve(Vector<Integer> s) {
		Vector<Entry> open = new Vector<Entry>();
		
		open.add(new Entry());
		
		int total = 0;
		for(int i = 0; i < s.size(); ++i)
			total += s.elementAt(i);
		
		Vector<Integer> result = null;
		Vector<Integer> temp;
		
		while(open.size() > 0) {
			Entry e = open.firstElement();
			open.removeElementAt(0);


			//System.out.println(e.values.size());
			int sum = 0;
			for(int i = 0; i < e.values.size(); ++i)
				sum += e.values.elementAt(i);
			
			if(total - sum == 0) {
				result = e.values;
				break;
			}
			
			for(int i = e.end; i < s.size(); ++i) {
				temp = (Vector<Integer>)(e.values.clone());
				temp.add(s.elementAt(i));
				
				open.add(new Entry(i+1, temp));
			}
		}
		

		if(result.size() == s.size())
			return null;


		temp = new Vector<Integer>();
		for(int i = 0; i < s.size(); ++i) {
			if(result.size() > 0 && result.firstElement() == s.elementAt(i))
				result.removeElementAt(0);
			else
				temp.add(s.elementAt(i));
		}
		
		return temp;
	}
	
	public static void main(String args[]) {
		Vector<Integer> set, result;
		
		int len=Integer.parseInt(JOptionPane.showInputDialog("enter length:"));
		Integer[] array=new Integer[len];
		for(int i=0;i<len;i++){
    			array[i]=Integer.parseInt(JOptionPane.showInputDialog("enter "+(i+1)+" data" ));
    		}//next for i
    		
		set = new Vector<Integer>(Arrays.asList(array));
		
		result = solve(set);
		System.out.println(result);
	}
}