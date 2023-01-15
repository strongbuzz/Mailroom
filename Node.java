/*
 * This class Represents a Node which has data, cursor next, cursor previous
 * @author Jinwoo Lee
 */
class Node {

	private Package data;
	private Node next;
	private Node prev;

	/**
	 * This is a constructor used to create a new Package object
	 * 
	 * @param initial data of the car
	 */
	public Node(Package data) {

		this.data = data;
		this.next = null;
		this.prev = null;
	}

	/**
	 * This method get the data of the package
	 * 
	 * @return The data of a pacakge
	 */
	public Package getData() {
		return data;
	}

	/**
	 * This method get the next node data
	 * 
	 * @return The data of a next package
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * This method get the previous node data
	 * 
	 * @return The data of a previous package
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * This method set data of a package
	 * 
	 * @param data The data to be set
	 */
	public void setData(Package data) {
		this.data = data;
	}

	/**
	 * This method set next data of a package
	 * 
	 * @param data The next data of package to be set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * This method set previous data of a package
	 * 
	 * @param data The previous data of package to be set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
