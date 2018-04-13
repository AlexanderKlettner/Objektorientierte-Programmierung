import java.util.*;
public class StackArray<E> {

	//typical stack methos
	private List<E> stack;
	//constructor, creats an empty stack
	public StackArray () //? is a wildcard for second part of classname
	{
		this.stack = new ArrayList<E>();
	}
	//inserts item at the top of this stack
	public void push (E item) {
		stack.add(item);
	}

	//returns the top item of this stack and removes it
	public E pop () {
		return stack.remove(0);
	}

	//returns the top item of this stack without removing it
	public E peek () {
		return stack.get(0);
	}

	//returns true if this stack contains no elements
	public boolean isEmpty() {
		return stack.size()==0;
	}

//	//additional useful methods
//
//	//returns the position of item on this stack, the top positon has
//	//count 1, returns -1 if item is not on this stack; 
//	//compares items with equals!
	public int contains (E item) {
		if(stack.contains(item)) {
			return stack.indexOf(item);
		}else return -1;
	}
//	//returns a String-representation of this stack as
//	//[item1, item2, ...] with item1 as the top item
	public String toString () {
		return stack.toString();
	}
	
	public int getSize() {
		return stack.size();
	}
}
