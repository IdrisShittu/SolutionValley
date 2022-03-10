import  java.util.Vector;

public class Entry {
	public int end;
	public Vector<Integer> values;


	public Entry() {
		end = 0;
		values = new Vector<Integer>();
	}


	public Entry(int e, Vector<Integer> v) {
		end = e;
		values = v;
	}
}