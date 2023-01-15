import java.util.EmptyStackException;

/*
 * This class Represents a PackageStack which has a head, tail, stack size, and capacity of the stack
 * @author Jinwoo Lee
 */
public class PackageStack {

	private Node head;
	private Node tail;
	private int stackSize;
	final int CAPACITY = 6;

	/**
	 * This is a Constructor used to create a new PackageStack object
	 */
	public PackageStack() {
		this.head = null;
	}

	/**
	 * This method gets the size of stack
	 * 
	 * @return The size of stack
	 */
	public int getSize() {
		return stackSize;
	}

	/**
	 * This method gets the head of stack
	 * 
	 * @return The head of stack
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * This method gets the tail of stack
	 * 
	 * @return The tail of stack
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * This method move push the package in a stack
	 * 
	 * @throws FullStackException When the stack is at capacity.
	 */
	public void push(Package x) throws FullStackException {

		boolean a = true;

		if (stackSize > CAPACITY) {
			throw new FullStackException();
		}
		Node newNode = new Node(x);
		newNode.setNext(head);
		if (head == null) {
			tail = newNode;
		} else {
			head.setPrev(newNode);
		}
		head = newNode;
		stackSize++;
	}

	/**
	 * This method move pop the package in a stack
	 * 
	 * @throws EmptyStackException When the stack was empty.
	 */
	public Package pop() throws EmptyStackException {

		if (this.head == null) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}

		Node temp = head;
		if (head.getNext() == null) {
			head = null;
			tail = null;
		} else {
			head = head.getNext();
			head.setPrev(null);
		}

		stackSize--;
		return temp.getData();

	}

	/**
	 * This method get the data of package at peek
	 * 
	 * @return The package at peek
	 */
	public Package peek() {
		if (head == null) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}
		return head.getData();
	}

	/**
	 * This method when the stack is empty
	 * 
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * This method when the stack is full
	 * 
	 */
	public boolean isFull() {
		return stackSize > CAPACITY;
	}

	/**
	 * This method print the recipient, weight,and arrival date of the package
	 * 
	 */
	public String toString() {
		Node temp = tail;
		if (temp == null) {
			System.out.print("empty.");
		}

		String s = "";
		while (temp != null) {

			s = s + "[" + temp.getData().toString() + "]";
			temp = temp.getPrev();
		}
		return s;
	}
}
