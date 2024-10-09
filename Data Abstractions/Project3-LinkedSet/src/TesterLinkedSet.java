
public class TesterLinkedSet {

	public static void main(String[] args) {
		LinkedSet s = new LinkedSet();
		
		s.add("a");
		s.add("b");
		s.add("a");
		
		System.out.println(s);
		System.out.println(s.contains("a"));
		System.out.println(s.contains("c"));
		
		s.add("c");
		s.add("d");
		s.add("e");
		String[] arr = s.toArray();
		
		for(String i: arr) {
			System.out.println(i);
		}
		
		LinkedSet s2 = new LinkedSet(arr);
		System.out.println(s2);
	}
}
