
//Iris Currie
import java.awt.Point;
import java.util.Arrays;

public class ResizableArraySet {

	public static final int DEFAULT_CAPACITY = 5;

	private int size;
	private Point[] data;

	/**
	 * Constructs an empty set with the default capacity.
	 */
	public ResizableArraySet() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs an empty set with the specified capacity.
	 * 
	 * @param capacity the initial capacity of the set
	 */
	public ResizableArraySet(int capacity) {
		size = 0;
		data = new Point[capacity];
	}

	/**
	 * Constructs a set containing the points in the given array. The initial
	 * capacity of the set will be equal to the length of the specified array (even
	 * if it contains duplicates)
	 * 
	 * @param pointsNew an array of points to be added
	 */
	public ResizableArraySet(Point[] pointsNew) {

		this(pointsNew.length);
		for (int i = 0; i < data.length; i++) {
			add(pointsNew[i]);
		}

	}

	/**
	 * Adds the specified point to this set.
	 * 
	 * @param pt the point to be added
	 * @return true if the add was successful, and false otherwise
	 */
	public boolean add(Point pt) {
		if (indexOf(pt) > -1) {
			return false;
		}

		checkCapacity();

		data[size++] = pt;
		return true;
	}

	/**
	 * Removes one unspecified entry from this set, if possible.
	 * 
	 * @return either the removed entry, if the removal was successful, or null.
	 */
	public Point remove() {
		if (size == 0) {
			return null;
		}

		Point last = data[size - 1];

		data[size-- - 1] = null;

		return last;
	}

	/**
	 * Removes the specified point from this set.
	 * 
	 * @param pt the point to be removed
	 * @return true if the remove was successful, and false otherwise
	 */
	public boolean remove(Point pt) {
		if (size == 0) {
			return false;
		}

		int index = indexOf(pt);

		if (index == -1) {
			return false;
		}

		data[index] = data[size - 1];
		data[size-- - 1] = null;
		return true;
	}

	/**
	 * Removes all points from this set.
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;

	}

	/**
	 * Determines whether the specified point is in this set.
	 * 
	 * @param pt the point whose presence is to be tested
	 * @return true if the point is in this set, and false otherwise
	 */
	public boolean contains(Point pt) {
		return indexOf(pt) > -1;
	}

	/**
	 * Returns the length of the underlying array.
	 * 
	 * @return the length of the underlying array
	 */
	public int getCapacity() {
		return data.length;
	}

	/**
	 * Returns the number of elements in this set.
	 * 
	 * @return the number of elements in this set
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if this set contains no elements, and false otherwise.
	 * 
	 * @return true if this set contains no elements, and false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns a space-separated, list of points in the form (x, y) (no decimal
	 * points in the output). For example: "(2, -3) (0, 0) (2, 5)" If the set is
	 * empty, return the point "EMPTY". In Java's Point class, x and y are public
	 * instance variables containing int values. So, if pt is a reference to a Point
	 * object, then pt.x and pt.y will give the x- and y-coordinates as integers.
	 */
	public String toString() {
		String result = "";
		if (size == 0) {
			return "EMPTY";
		}
		// loop through the elements to add them to result
		for (int i = 0; i < size; i++) {
			result += "(" + (int) data[i].x + ", " + (int) data[i].y + ") ";
		}

		return result.trim();
	}

	/**
	 * Returns an array containing all of the points in this set. If the set
	 * contains no elements, an empty array is returned.
	 * 
	 * @return an array of all the elements in this set
	 */
	public Point[] toArray() {
		Point[] newArr = new Point[size];
		for (int i = 0; i < size; i++) {
			newArr[i] = data[i];
		}
		return newArr;
	}

	/**
	 * Returns a count of the number of points in this set whose distance from the
	 * origin (0, 0) is less than or equal to the specified radius.
	 * 
	 * @param radius the radius to check
	 * @return the number of points in this set whose distance from the origin is
	 *         less than or equal to radius
	 */
	public int withinRadius(double radius) {
		int count = 0;

		for (Point p : data) {
			double length = Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
			if (length <= radius) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Computes the intersection of this set and another set (items common to both
	 * sets), and returns the results as a new set. Order is unimportant. Just be
	 * sure the correct points are being returned. Do not make modifications to
	 * either of the original sets.
	 * 
	 * @param other another set
	 * @return a set with all elements that are common to both sets.
	 */
	public ResizableArraySet intersection(ResizableArraySet other) {
		ResizableArraySet r = new ResizableArraySet();

		for (Point p : data) {
			if (other.contains(p)) {
				r.add(p);
			}
		}

		return r;
	}

	/**
	 * Computes the union of this set and another set (items in either or both
	 * sets), and returns the results as a new set. Order is unimportant. Just be
	 * sure the correct points are being returned. Do not make modifications to
	 * either of the original sets.
	 * 
	 * @param other another set
	 * @return a set with all elements that are in either or both sets.
	 */
	public ResizableArraySet union(ResizableArraySet other) {
		ResizableArraySet r = new ResizableArraySet();

		for (Point p : data) {
			r.add(p);
		}

		for (Point p : other.toArray()) {
			r.add(p);
		}

		return r;
	}

	/**
	 * Computes and returns the set of all that can be obtained by adding each point
	 * in this set to each of the other points in this set (but not adding a point
	 * to itself). Adding points means adding the x-coordinates, and adding the
	 * y-coordinates. For example, if this set contained (2, 3), (5, 10), (0, 1),
	 * and (7, 12) then this method should return a set containing (7, 13), (2, 4),
	 * (9, 15), (5, 11), and (12, 22) The order of the elements is unimportant.
	 * 
	 * @return a set with all possible sums of a point with the other points in this
	 *         set
	 */
	public ResizableArraySet allSum() {
		ResizableArraySet r = new ResizableArraySet();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					continue;
				}
				int x = data[i].x + data[j].x;
				int y = data[i].y + data[j].y;
				r.add(new Point(x, y));

			}
		}

		return r;
	}

	/*
	 * Returns the index of a specified string, or -1 if the string is not in the
	 * array. add(pt), remove(pt) and contains(pt) can all make use of this method
	 */
	private int indexOf(Point pt) {

		for (int i = 0; i < size; i++) {
			if (data[i].equals(pt)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * checks the size against the capacity of the underlying array, and if the size
	 * is equal to the length of the array will create a new array twice as large
	 * and copy everything into it
	 */
	private void checkCapacity() {
		if (size == data.length) {
			data = Arrays.copyOf(data, size * 2);
		}
	}
}
