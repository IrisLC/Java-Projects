import java.util.Arrays;

/**
 * Implements a set of strings using a fixed length array
 * 
 * @author Iris Currie
 */
public class FixedArraySet {
	//Don't add any other instance variables
	private String[] data;
	private int size;
	
	public static final int DEFUALT_CAPACITY = 10;
	
	/**
	 * Constructs a new set with specified capacity
	 * @param capacity maximum number of elements that can be in the set
	 */
	public FixedArraySet(int capacity) {
		data = new String[capacity];
		size = 0;
	}
	
	/**
	 * Constructs a new set with a default capacity
	 */
	public FixedArraySet() {
		this(DEFUALT_CAPACITY);
	}
	
	/**
	 * Adds a specified string to the set if
	 * it's not already in the set, and the array 
	 * is not full
	 * 
	 * @param s the string to be added
	 * @return true if the add was successful, false otherwise
	 */
	public boolean add(String s) {
		//check if the array is full
		//if so return false
		if (size >= data.length) {
			return false;
		}
		
		//check if s is already in the set.
		//if it is return false
		if(indexOf(s) != -1) {
			return false;
		}
		
		
		data[size++] = s;
		
		return true;
	}
	
	/**
	 * checks if a given string is located in the array
	 * 
	 * @param s the string being searched for
	 * @return true if the string was found, false otherwise
	 */
	public boolean contains(String s) {
		return indexOf(s) > -1;
	}
	
	/**
	 * removes the element at the end of the array
	 * 
	 * @return The removed string
	 */
	public String remove() {
		if(size == 0) {
			return null;
		}
		
		String removed = data[size - 1];
		
		data[size-- - 1] = null;
		
		return removed;
	}
	
	/**
	 * removes a specified string from the set
	 * 
	 * @param s the string to be removed
	 * @return true if the remove was successful, false otherwise
	 */
	public boolean remove(String s) {
		//returns false if the array is empty
		if (size == 0) {
			return false;
		}
		//gets the index of the string
		int index = indexOf(s);
		
		//returns false if the element was not found
		if(index == -1) {
			return false;
		}
		
		//replaces the index to be removed with the end of the array 
		data[index] = data[size - 1];
		
		//removes the end of the array
		data[size-- - 1] = null;
		
		return true;
	}
	
	/**
	 * sets all elements of the array to null
	 */
	public void clear() {
		for(int i = 0; i < size; i++) {
			data[i] = null;
		}
		
		size = 0;
	}
	
	/**
	 * returns the size of the set
	 * @return the size of the set
	 */
	public int size() {
		return size;
	}
	
	/**
	 * returns whether the set is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		String result = "";
		//loop through the elements to add them to result
		for(int i = 0; i < size; i++) {
			result += data[i] + " ";
		}
		
		return result.trim();
	}
	
	/**
	 * Returns an array of all the elements contained in the set
	 * @return
	 */
	public String[] toArray() {
		return Arrays.copyOf(data,  size);
	}
	/*
	 * Returns the index of a specified string,
	 * or -1 if the string is not in the array.
	 * add(s), remove(s) and contains(s) can all
	 * make use of this method
	 */
	private int indexOf(String s) {
		
		for(int i = 0; i < size; i++) {
			if(data[i].equals(s)) {
				return i;
			}
		}
		
		//did you make it to this point?
		//if so, you didn't find s
		return -1;
	}
	
	
}
