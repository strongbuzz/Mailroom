/*
 * This class Represents a Pacakge which has a recipient, arrivalDate, and weight.
 * @author Jinwoo Lee
 */
public class Package {

	private String recipient;
	private int arrivalDate;
	private double weight;

	public Package(String recipient, int arrivalDate, double weight) {
		this.recipient = recipient;
		this.weight = weight;
		this.arrivalDate = arrivalDate;
	}

	/**
	 * This method get the recipient of the package
	 * 
	 * @return The name of recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * This method get the arrival date of the package
	 * 
	 * @return The arrival date
	 */
	public int getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * This method get the weight of package
	 * 
	 * @return The weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * This method set the recipient
	 * 
	 * @param recipient The recipient to be set
	 */
	public void setRceipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * This method set the arrival date of the package
	 * 
	 * @param arrivalDate The arrival date to be set
	 */
	public void setArrivalDateString(int arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * This method set the weight of the package
	 * 
	 * @param weight The weigh to be set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * This method print the recipient and arrival date
	 * 
	 */
	public String toString() {
		if (recipient == null) {
			System.out.print("empty.");
		}
		String s = "";
		s = s + recipient + " " + arrivalDate;

		return s;

	}
}
