import java.awt.Point;

public class Tester {

	public static void main(String[] args) {
		Point[] pA = {new Point(1, 2), new Point(1, 2), new Point(3, 4), new Point(5, 6), new Point(6, 7), new Point(6, 7),};
		
		
		
		ResizableArraySet p = new ResizableArraySet(pA);
		
		
		System.out.println(p);
		System.out.println(p.size());
		System.out.println(p.getCapacity());
		
		p.clear();
		System.out.println(p.isEmpty());

		System.out.println(p);
		p.add(new Point(1,2));
		System.out.println(p.isEmpty());
	}

}
