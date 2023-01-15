import java.util.Scanner;

/**
 * This class represents a MailroomManger which has ten instance one,two
 * three,four,five,zero,temp,tempTwo,tempThree,tempFour,tempFive and
 * arrivalDate, invalid.
 * 
 * @author Jinwoo Lee
 *
 */
public class MailroomManger {

	private static PackageStack one = new PackageStack();
	private static PackageStack two = new PackageStack();
	private static PackageStack three = new PackageStack();
	private static PackageStack four = new PackageStack();
	private static PackageStack five = new PackageStack();
	private static PackageStack zero = new PackageStack();

	private static PackageStack temp = new PackageStack();
	private static PackageStack tempTwo = new PackageStack();
	private static PackageStack tempThree = new PackageStack();
	private static PackageStack tempFour = new PackageStack();
	private static PackageStack tempFive = new PackageStack();
	static int arrivalDate = 0;
	static boolean invalid = false;

	/**
	 * This method print the stacks
	 * 
	 */
	public static void print() {

		System.out.println("Current Packages:\n--------------------------------");
		System.out.print("Stack 1 (A-G):|");
		System.out.println(one.toString());
		System.out.print("Stack 2 (H-J):|");
		System.out.println(two.toString());
		System.out.print("Stack 3 (K-M):|");
		System.out.println(three.toString());
		System.out.print("Stack 4 (N-R):|");
		System.out.println(four.toString());
		System.out.print("Stack 5 (S-Z):|");
		System.out.println(five.toString());
		System.out.print("Floor:  |");
		System.out.println(zero.toString() + "\n");
	}

	/**
	 * This method runs the program
	 * 
	 * @throws FullStackException When stack is at capacity.
	 */
	public static void main(String[] args) throws FullStackException {

		Node one1 = new Node(null);
		System.out.println(
				"Welcome to the Irving Mailroom Manager. You can try to make it better, but the odds are stacked against you. It is day 0.\n");

		boolean test = true;
		while (test) {
			System.out.println(menu());
			Scanner scan = new Scanner(System.in);
			System.out.println("Please select an option:");
			String input = scan.nextLine();

			if (!input.equalsIgnoreCase("D") && !input.equalsIgnoreCase("G") && !input.equalsIgnoreCase("T")
					&& !input.equalsIgnoreCase("P") && !input.equalsIgnoreCase("M") && !input.equalsIgnoreCase("F")
					&& !input.equalsIgnoreCase("L") && !input.equalsIgnoreCase("E") && !input.equalsIgnoreCase("Q")) {
				System.out.println("Invalid Input!");
				invalid = true;
			}

			/**
			 * This method Deliver a package
			 */
			if (input.equalsIgnoreCase("D")) {
				System.out.println("Please enter the recipient name:");
				String recipient = scan.nextLine();
				char ch = recipient.toLowerCase().charAt(0);
				if (ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' && ch != 'e' && ch != 'f' && ch != 'g' && ch != 'h'
						&& ch != 'i' && ch != 'j' && ch != 'k' && ch != 'l' && ch != 'm' && ch != 'n' && ch != 'o'
						&& ch != 'p' && ch != 'q' && ch != 'r' && ch != 's' && ch != 't' && ch != 'u' && ch != 'v'
						&& ch != 'w' && ch != 'x' && ch != 'y' && ch != 'z') {
					invalid = true;

					System.out.println("Invalid input!");
				} else {
					System.out.println("Please enter the weight (lbs): ");
					try {
						double weight = scan.nextDouble();

						Package newPackage = new Package(recipient, arrivalDate, weight);

						char ch1 = recipient.toLowerCase().charAt(0);
						System.out.println(ch1);
						if (ch1 == 'a' || ch1 == 'b' || ch1 == 'c' || ch1 == 'd' || ch1 == 'e' || ch1 == 'f'
								|| ch1 == 'g') {

							if (one.getSize() > 6) {

								if (one.getSize() > 6) {

									if (!(two.getSize() > 6)) {

										two.push(newPackage);
										System.out.println("A " + weight + " lb package is awaiting pickup by "
												+ recipient + ". As stack 1 was full, it was placed in stack 2.");
									}

									else if (two.getSize() > 6) {
										if (!(three.getSize() > 6)) {
											three.push(newPackage);
											System.out.println("A " + weight + " lb package is awaiting pickup by "
													+ recipient
													+ ". As stack 1 and stack 2 was full, it was placed in stack 3.");
										} else if (three.getSize() > 6) {
											if (!(four.getSize() > 6)) {
												four.push(newPackage);
												System.out.println("A " + weight + " lb package is awaiting pickup by "
														+ recipient
														+ ". As stack 1 and stack 2 and stack 3 was full,\n it was placed in stack 4.");
											}

										} else if (four.getSize() > 6) {
											if (!(five.getSize() > 6)) {
												five.push(newPackage);
												System.out.println("A " + weight + " lb package is awaiting pickup by "
														+ recipient
														+ ". As stack 1 and stack 2 and stack 3 and stack 4 was full,\n it was placed in stack 5.");
											}
										}
									}
								}

								else {

									zero.push(newPackage);
									System.out.println("A " + weight + " lb package is awaiting pickup by " + recipient
											+ ". As all stack was full,\n it was placed in on the floor.");
								}

							}

							else {
								System.out.println(
										"A " + weight + " lb package is awaiting pickup by " + recipient + ".");
								one.push(newPackage);
							}
						}

						if (ch1 == 'h' || ch1 == 'i' || ch1 == 'j') {
							if (two.getSize() > 6) {
								one.push(newPackage);
								System.out.println("A " + weight + " lb package is awaiting pickup by " + recipient
										+ ". As stack 2 was full, it was placed in stack 1.");
							} else {
								System.out.println(
										"A " + weight + " lb package is awaiting pickup by " + recipient + ".");
								two.push(newPackage);
							}
						}

						if (ch1 == 'k' || ch1 == 'l' || ch1 == 'm') {
							if (three.getSize() > 6) {
								four.push(newPackage);
								System.out.println("A " + weight + " lb package is awaiting pickup by " + recipient
										+ ". As stack 3 was full, it was placed in stack 4.");
							} else {
								System.out.println(
										"A " + weight + " lb package is awaiting pickup by " + recipient + ".");
								three.push(newPackage);
							}
						}

						if (ch1 == 'n' || ch1 == 'o' || ch1 == 'p' || ch1 == 'q' || ch1 == 'r') {
							if (four.getSize() > 6) {
								five.push(newPackage);
								System.out.println("A " + weight + " lb package is awaiting pickup by " + recipient
										+ ". As stack 4 was full, it was placed in stack 5.");
							} else {
								System.out.println(
										"A " + weight + " lb package is awaiting pickup by " + recipient + ".");
								four.push(newPackage);
							}
						}

						if (ch1 == 's' || ch1 == 't' || ch1 == 'u' || ch1 == 'v' || ch1 == 'w' || ch1 == 'x'
								|| ch1 == 'y' || ch1 == 'z') {
							if (five.getSize() > 6) {
								four.push(newPackage);
								System.out.println("A " + weight + " lb package is awaiting pickup by " + recipient
										+ ". As stack 5 was full, it was placed in stack 4.");
							} else {
								System.out.println(
										"A " + weight + " lb package is awaiting pickup by " + recipient + ".");
								five.push(newPackage);
							}
						}
					} catch (Exception e) {
						System.out.println("Invalid input! " + e.toString());
					}

				}
			}

			/**
			 * This method Print the stacks
			 */
			if (input.equalsIgnoreCase("P")) {

				print();
			}

			/**
			 * This method make it tomorrow
			 */
			if (input.equalsIgnoreCase("T")) {

				arrivalDate++;
				System.out.println("It is now day " + arrivalDate + ".");

				if (!one.isEmpty()) {
					int size1 = one.getSize();
					int date = one.getTail().getData().getArrivalDate();

					if (((arrivalDate - date) == 5)) {

						while (one.getHead() != null && arrivalDate - one.getHead().getData().getArrivalDate() != 5) {
							Node oneHead = one.getHead();
							Package pack = oneHead.getData();
							temp.push(pack);

							one.pop();
							oneHead = oneHead.getNext();
						}
						while (one.getHead() != null) {
							one.pop();
						}
						while (temp.getHead() != null) {
							Node tempHead = temp.getHead();
							Package pack = tempHead.getData();
							one.push(pack);
							temp.pop();
							tempHead = tempHead.getNext();
						}

						int size2 = one.getSize();
						int size = size1 - size2;
						System.out.println(" packages have been returned to sender.");

					}

				}
				if (!two.isEmpty()) {
					int size1 = two.getSize();
					int date = two.getTail().getData().getArrivalDate();

					if (((arrivalDate - date) == 5)) {

						while (two.getHead() != null && arrivalDate - two.getHead().getData().getArrivalDate() != 5) {
							Node twoHead = two.getHead();
							Package pack = twoHead.getData();
							tempTwo.push(pack);

							two.pop();
							twoHead = twoHead.getNext();
						}
						while (two.getHead() != null) {
							two.pop();
						}
						while (tempTwo.getHead() != null) {
							Node tempHead = tempTwo.getHead();
							Package pack = tempHead.getData();
							two.push(pack);
							tempTwo.pop();
							tempHead = tempHead.getNext();
						}

						int size2 = two.getSize();
						int size = size1 - size2;
						System.out.println(size + " packages have been returned to sender.");

					}

				}
				if (!three.isEmpty()) {
					int size1 = three.getSize();
					int date = three.getTail().getData().getArrivalDate();

					if (((arrivalDate - date) == 5)) {

						while (three.getHead() != null
								&& arrivalDate - three.getHead().getData().getArrivalDate() != 5) {
							Node threeHead = three.getHead();
							Package pack = threeHead.getData();
							tempThree.push(pack);

							three.pop();
							threeHead = threeHead.getNext();
						}
						while (three.getHead() != null) {
							three.pop();
						}
						while (tempThree.getHead() != null) {
							Node tempHead = tempThree.getHead();
							Package pack = tempHead.getData();
							three.push(pack);
							tempThree.pop();
							tempHead = tempHead.getNext();

						}

						int size2 = three.getSize();
						int size = size1 - size2;
						System.out.println(size + "packages have been returned to sender.");

					}

				}
				if (!four.isEmpty()) {
					int size1 = four.getSize();
					int date = four.getTail().getData().getArrivalDate();

					if (((arrivalDate - date) == 5)) {

						while (four.getHead() != null && arrivalDate - four.getHead().getData().getArrivalDate() != 5) {
							Node fourHead = four.getHead();
							Package pack = fourHead.getData();
							tempFour.push(pack);

							four.pop();
							fourHead = fourHead.getNext();
						}
						while (four.getHead() != null) {
							four.pop();
						}
						while (tempFour.getHead() != null) {
							Node tempHead = tempFour.getHead();
							Package pack = tempHead.getData();
							four.push(pack);
							tempFour.pop();
							tempHead = tempHead.getNext();
						}

						int size2 = four.getSize();
						int size = size1 - size2;
						System.out.println(size + "packages have been returned to sender.");

					}

				}

				if (!five.isEmpty()) {
					int size1 = five.getSize();
					int date = five.getTail().getData().getArrivalDate();

					if (((arrivalDate - date) == 5)) {

						while (five.getHead() != null && arrivalDate - five.getHead().getData().getArrivalDate() != 5) {
							Node fiveHead = five.getHead();
							Package pack = fiveHead.getData();
							tempFive.push(pack);

							five.pop();
							fiveHead = fiveHead.getNext();
						}

						while (five.getHead() != null) {
							five.pop();
						}

						while (tempFive.getHead() != null) {
							Node tempHead = tempFive.getHead();
							Package pack = tempHead.getData();
							five.push(pack);
							tempFive.pop();
							tempHead = tempHead.getNext();
						}

						int size2 = five.getSize();
						int size = size1 - size2;
						System.out.println(size + "packages have been returned to sender.");

					}

				}

			}

			/**
			 * This method list all packages awaiting a user
			 */
			if (input.equalsIgnoreCase("L")) {
				System.out.println("Please enter the recipient name:");
				String name = scan.nextLine();

				Node tail1 = one.getTail();
				Node tail2 = two.getTail();
				Node tail3 = three.getTail();
				Node tail4 = four.getTail();
				Node tail5 = five.getTail();
				int stackNum = 1;
				boolean test1 = false;

				if (!one.isEmpty() || !two.isEmpty() || !three.isEmpty() || !four.isEmpty() || !five.isEmpty()) {

					int packageNum5 = 1;
					while (tail5 != null) {
						if (tail5.getData().getRecipient().equalsIgnoreCase(name)) {
							System.out.println("Package " + packageNum5 + " is in Stack 5, it was delivered"
									+ " on day " + tail5.getData().getArrivalDate() + ", and weighs "
									+ tail5.getData().getWeight() + " lbs.");
							test1 = true;
							packageNum5++;
						}

						tail5 = tail5.getPrev();
					}

					int packageNum4 = 1;
					while (tail4 != null) {
						if (tail4.getData().getRecipient().equalsIgnoreCase(name)) {
							System.out.println("Package " + packageNum4 + " is in Stack 4, it was delivered"
									+ " on day " + tail4.getData().getArrivalDate() + ", and weighs "
									+ tail4.getData().getWeight() + " lbs.");
							test1 = true;
							packageNum4++;
						}
						tail4 = tail4.getPrev();
					}

					int packageNum3 = 1;
					while (tail3 != null) {
						if (tail3.getData().getRecipient().equalsIgnoreCase(name)) {
							System.out.println("Package " + packageNum3 + " is in Stack 3, it was delivered"
									+ " on day " + tail3.getData().getArrivalDate() + ", and weighs "
									+ tail3.getData().getWeight() + " lbs.");
							test1 = true;
							packageNum3++;
						}
						tail3 = tail3.getPrev();
					}

					int packageNum2 = 1;
					while (tail2 != null) {

						if (tail2.getData().getRecipient().equalsIgnoreCase(name)) {
							System.out.println("Package " + packageNum2 + " is in Stack 2, it was delivered"
									+ " on day " + tail2.getData().getArrivalDate() + ", and weighs "
									+ tail2.getData().getWeight() + " lbs.");
							test1 = true;
							packageNum2++;

						}

						tail2 = tail2.getPrev();
					}

					int packageNum1 = 1;
					while (tail1 != null) {
						if (tail1.getData().getRecipient().equalsIgnoreCase(name)) {
							System.out.println("Package " + packageNum1 + " is in Stack 1, it was delivered"
									+ " on day " + tail1.getData().getArrivalDate() + ", and weighs "
									+ tail1.getData().getWeight() + " lbs.");
							test1 = true;
							packageNum1++;
						}
						tail1 = tail1.getPrev();
					}
					if (test1 == false)
						System.out.println("We dont have this recipient");

				} else {
					System.out.println("empty");

				}
			}

			/**
			 * This method get someone's package
			 */
			if (input.equalsIgnoreCase("G")) {
				if (one.isEmpty() && two.isEmpty() && three.isEmpty() && four.isEmpty() && five.isEmpty()) {
					System.out.println("Invalid input! Stack is empty");
					invalid = true;
				}
				if (!one.isEmpty() || !two.isEmpty() || !three.isEmpty() || !four.isEmpty() || !five.isEmpty()) {
					boolean test2 = true;
					System.out.println("Pleaes enter the recipient name:");
					String name = scan.nextLine();

					char ch1 = name.toLowerCase().charAt(0);

					if (ch1 == 'a' || ch1 == 'b' || ch1 == 'c' || ch1 == 'd' || ch1 == 'e' || ch1 == 'f'
							|| ch1 == 'g') {
						Node head1 = one.getHead();
						Package pack = null;

						while (head1 != null) {
							if (!head1.getData().getRecipient().equalsIgnoreCase(name)) {
								pack = one.peek();
								one.pop();
								zero.push(pack);

								head1 = head1.getNext();
							} else {
								System.out.println("\nMove " + zero.getSize() + " packages from Stack 1 to floor.");

								print();

								System.out.println("Give " + name + " " + one.getHead().getData().getWeight() + " lb"
										+ " pacakge delivered on day " + one.getHead().getData().getArrivalDate()
										+ ".");
								System.out.println("Return " + zero.getSize() + " packages to stack 1 from floor.\n");

								one.pop();

								Node head11 = zero.getHead();

								Package temp = null;

								while (head11 != null) {

									temp = zero.pop();
									one.push(temp);

									head11 = head11.getNext();
								}

								print();

								break;
							}

						}
					}

					if (ch1 == 'h' || ch1 == 'i' || ch1 == 'j') {
						Node head2 = two.getHead();
						Package pack = null;

						while (head2 != null) {
							if (!head2.getData().getRecipient().equalsIgnoreCase(name)) {
								pack = two.peek();
								two.pop();
								zero.push(pack);

								head2 = head2.getNext();

							} else {
								System.out.println("\nMove " + zero.getSize() + " packages from Stack 2 to floor.");

								print();

								System.out.println("Give " + name + " " + two.getHead().getData().getWeight() + " lb"
										+ " pacakge delivered on day " + two.getHead().getData().getArrivalDate()
										+ ".");
								System.out.println("Return " + zero.getSize() + " packages to stack 2 from floor.\n");

								two.pop();

								Node head22 = zero.getHead();

								Package temp = null;

								while (head22 != null) {

									temp = zero.pop();
									two.push(temp);

									head22 = head22.getNext();
								}

								print();

								break;
							}

						}
					}

					if (ch1 == 'k' || ch1 == 'l' || ch1 == 'm') {
						Node head3 = three.getHead();
						Package pack = null;

						while (head3 != null) {
							if (!head3.getData().getRecipient().equalsIgnoreCase(name)) {
								pack = three.peek();
								three.pop();
								zero.push(pack);

								head3 = head3.getNext();

							} else {
								System.out.println("\nMove " + zero.getSize() + " packages from Stack 3 to floor.");

								print();

								System.out.println("Give " + name + " " + three.getHead().getData().getWeight() + " lb"
										+ " pacakge delivered on day " + three.getHead().getData().getArrivalDate()
										+ ".");
								System.out.println("Return " + zero.getSize() + " packages to stack 3 from floor.\n");

								three.pop();

								Node head33 = zero.getHead();

								Package temp = null;

								while (head33 != null) {

									temp = zero.pop();
									three.push(temp);

									head33 = head33.getNext();
								}

								print();

								break;
							}

						}
					}

					if (ch1 == 'n' || ch1 == 'o' || ch1 == 'p' || ch1 == 'q' || ch1 == 'r') {
						Node head4 = four.getHead();
						Package pack = null;

						while (head4 != null) {
							if (!head4.getData().getRecipient().equalsIgnoreCase(name)) {
								pack = four.peek();
								four.pop();
								zero.push(pack);

								head4 = head4.getNext();

							} else {
								System.out.println("\nMove " + zero.getSize() + " packages from Stack 4 to floor.");

								print();

								System.out.println("Give " + name + " " + four.getHead().getData().getWeight() + " lb"
										+ " pacakge delivered on day " + four.getHead().getData().getArrivalDate()
										+ ".");
								System.out.println("Return " + zero.getSize() + " packages to stack 4 from floor.\n");

								four.pop();

								Node head44 = zero.getHead();

								Package temp = null;

								while (head44 != null) {

									temp = zero.pop();
									four.push(temp);

									head44 = head44.getNext();
								}

								print();

								break;
							}

						}
					}

					if (ch1 == 's' || ch1 == 't' || ch1 == 'u' || ch1 == 'v' || ch1 == 'w' || ch1 == 'x' || ch1 == 'y'
							|| ch1 == 'z') {
						Node head5 = five.getHead();
						Package pack = null;

						while (head5 != null) {
							if (!head5.getData().getRecipient().equalsIgnoreCase(name)) {
								pack = five.peek();
								five.pop();
								zero.push(pack);

								head5 = head5.getNext();

							} else {
								System.out.println("\nMove " + zero.getSize() + " packages from Stack 5 to floor.");

								print();

								System.out.println("Give " + name + " " + five.getHead().getData().getWeight() + " lb"
										+ " pacakge delivered on day " + five.getHead().getData().getArrivalDate()
										+ ".");
								System.out.println("Return " + zero.getSize() + " packages to stack 5 from floor.\n");

								five.pop();

								Node head55 = zero.getHead();

								Package temp = null;

								while (head55 != null) {

									temp = zero.pop();
									five.push(temp);

									head55 = head55.getNext();
								}

								print();

								break;
							}

						}
					}

				}
				// else {
				// System.out.println("Invalid Input!");
				// }

			}

			/**
			 * This method find packages in the wrong stack and move to floor
			 */
			if (input.equalsIgnoreCase("F")) {

				if (one.isEmpty() && two.isEmpty() && three.isEmpty() && four.isEmpty() && five.isEmpty()) {
					System.out.println("Invalid input!");
					invalid = true;
				} else {
					if (!one.isEmpty()) {
						Node oneHead = one.getHead();
						while (oneHead != null) {
							char ch1 = oneHead.getData().getRecipient().toLowerCase().charAt(0);

							if (ch1 != 'a' || ch1 != 'b' || ch1 != 'c' || ch1 != 'd' || ch1 != 'e' || ch1 != 'f'
									|| ch1 != 'g') {
								if ((ch1 == 'a' || ch1 == 'b' || ch1 == 'c' || ch1 == 'd' || ch1 == 'e' || ch1 == 'f'
										|| ch1 == 'g')) {
									Package pack = one.pop();
									temp.push(pack);
									oneHead = oneHead.getNext();
								} else {
									Package pack = one.peek();
									zero.push(pack);
									one.pop();
									oneHead = oneHead.getNext();

								}
							}

						}
						Node tempHead = temp.getHead();
						while (tempHead != null) {
							Package pack = temp.pop();
							one.push(pack);
							tempHead = tempHead.getNext();
						}

					}

					if (!two.isEmpty()) {
						Node twoHead = two.getHead();
						while (twoHead != null) {
							char ch1 = twoHead.getData().getRecipient().toLowerCase().charAt(0);

							if (ch1 != 'h' || ch1 != 'i' || ch1 != 'j') {
								if ((ch1 == 'h' || ch1 == 'i' || ch1 == 'j')) {
									Package pack = two.pop();
									tempTwo.push(pack);
									twoHead = twoHead.getNext();
								} else {
									Package pack = two.peek();
									zero.push(pack);
									two.pop();
									twoHead = twoHead.getNext();

								}
							}

						}
						Node tempHead = tempTwo.getHead();
						while (tempHead != null) {
							Package pack = tempTwo.pop();
							two.push(pack);
							tempHead = tempHead.getNext();
						}

					}
					if (!three.isEmpty()) {
						Node threeHead = three.getHead();
						while (threeHead != null) {
							char ch1 = threeHead.getData().getRecipient().toLowerCase().charAt(0);

							if (ch1 != 'k' || ch1 != 'l' || ch1 != 'm') {
								if ((ch1 == 'k' || ch1 == 'l' || ch1 == 'm')) {
									Package pack = three.pop();
									tempThree.push(pack);
									threeHead = threeHead.getNext();
								} else {
									Package pack = three.peek();
									zero.push(pack);
									three.pop();
									threeHead = threeHead.getNext();

								}
							}

						}
						Node tempHead = tempThree.getHead();
						while (tempHead != null) {
							Package pack = tempThree.pop();
							three.push(pack);
							tempHead = tempHead.getNext();
						}

					}

					if (!four.isEmpty()) {
						Node fourHead = four.getHead();
						while (fourHead != null) {
							char ch1 = fourHead.getData().getRecipient().toLowerCase().charAt(0);

							if (ch1 != 'n' || ch1 != 'o' || ch1 != 'p' || ch1 != 'q' || ch1 != 'r') {
								if ((ch1 == 'n' || ch1 == 'o' || ch1 == 'p' || ch1 == 'q' || ch1 == 'r')) {
									Package pack = four.pop();
									tempFour.push(pack);
									fourHead = fourHead.getNext();
								} else {
									Package pack = four.peek();
									zero.push(pack);
									four.pop();
									fourHead = fourHead.getNext();

								}
							}

						}
						Node tempHead = tempFour.getHead();
						while (tempHead != null) {
							Package pack = tempFour.pop();
							four.push(pack);
							tempHead = tempHead.getNext();
						}

					}

					if (!five.isEmpty()) {
						Node fiveHead = five.getHead();
						while (fiveHead != null) {
							char ch1 = fiveHead.getData().getRecipient().toLowerCase().charAt(0);

							if (ch1 != 's' || ch1 != 't' || ch1 != 'u' || ch1 != 'v' || ch1 != 'w' || ch1 != 'x'
									|| ch1 != 'y' || ch1 != 'z') {
								if ((ch1 == 's' || ch1 == 't' || ch1 == 'u' || ch1 == 'v' || ch1 == 'w' || ch1 == 'x'
										|| ch1 == 'y' || ch1 == 'z')) {
									Package pack = five.pop();
									tempFive.push(pack);
									fiveHead = fiveHead.getNext();
								} else {
									Package pack = five.peek();
									zero.push(pack);
									five.pop();
									fiveHead = fiveHead.getNext();

								}
							}

						}
						Node tempHead = tempFive.getHead();
						while (tempHead != null) {
							Package pack = tempFive.pop();
							five.push(pack);
							tempHead = tempHead.getNext();
							System.out.println();
						}

					} else {
						System.out.println("Misplaced packages moved to floor.");
					}
				}
			}

			/**
			 * This method move a package from one stack to another
			 */
			if (input.equalsIgnoreCase("M")) {
				System.out.println("Please enter the source stack (enter 0 for floor):");
				int sourceNum = scan.nextInt();
				System.out.println("Please enter the destination stack:");
				int destinationNum = scan.nextInt();

				if (sourceNum != 1 && sourceNum != 2 && sourceNum != 3 && sourceNum != 4 && sourceNum != 5
						&& sourceNum != 0) {
					System.out.println("Invalid input");
					invalid = true;
				} else {
					if (sourceNum == 0) {

						Package pac = zero.pop();
						if (destinationNum == 0) {
							System.out.println("cannot move");
						}
						if (destinationNum == 1) {
							one.push(pac);
						}
						if (destinationNum == 2) {
							two.push(pac);
						}
						if (destinationNum == 3) {
							three.push(pac);
						}
						if (destinationNum == 4) {
							four.push(pac);
						}
						if (destinationNum == 5) {
							five.push(pac);
						}
					}

					if (sourceNum == 1) {
						if (one.getTail() == null) {
							System.out.println("Stack 1 is empty");
						} else {
							Package pac = one.pop();
							if (destinationNum == 0) {
								zero.push(pac);
							}
							if (destinationNum == 1) {
								System.out.println("Cannot move");
							}
							if (destinationNum == 2) {
								two.push(pac);
							}
							if (destinationNum == 3) {
								three.push(pac);
							}
							if (destinationNum == 4) {
								four.push(pac);
							}
							if (destinationNum == 5) {
								five.push(pac);
							}
						}
					}
					if (sourceNum == 2) {
						if (two.getTail() == null) {
							System.out.println("Stack 2 is empty");
						} else {

							Package pac = two.pop();
							if (destinationNum == 0) {
								zero.push(pac);
							}
							if (destinationNum == 1) {
								one.push(pac);
							}
							if (destinationNum == 2) {
								System.out.println("Stack 2 is empty");
							}
							if (destinationNum == 3) {
								three.push(pac);
							}
							if (destinationNum == 4) {
								four.push(pac);
							}
							if (destinationNum == 5) {
								five.push(pac);
							}
						}
					}

					if (sourceNum == 3) {
						if (three.getTail() == null) {
							System.out.println("Stack 3 is empty");
						} else {
							Package pac = three.pop();
							if (destinationNum == 0) {
								zero.push(pac);
							}
							if (destinationNum == 1) {
								one.push(pac);
							}
							if (destinationNum == 2) {
								two.push(pac);
							}
							if (destinationNum == 3) {
								System.out.println("Cannot move");
							}
							if (destinationNum == 4) {
								four.push(pac);
							}
							if (destinationNum == 5) {
								five.push(pac);
							}
						}
					}

					if (sourceNum == 4) {
						if (four.getTail() == null) {
							System.out.println("Stack 4 is empty");
						} else {
							Package pac = four.pop();
							if (destinationNum == 0) {
								zero.push(pac);
							}
							if (destinationNum == 1) {
								one.push(pac);
							}
							if (destinationNum == 2) {
								two.push(pac);
							}
							if (destinationNum == 3) {
								three.push(pac);
							}
							if (destinationNum == 4) {
								System.out.println("Cannot move");
							}
							if (destinationNum == 5) {
								five.push(pac);
							}
						}
					}
					if (sourceNum == 5) {
						if (five.getTail() == null) {
							System.out.println("Stack 5 is empty");
						} else {
							Package pac = five.pop();
							if (destinationNum == 0) {
								zero.push(pac);
							}
							if (destinationNum == 1) {
								one.push(pac);
							}
							if (destinationNum == 2) {
								two.push(pac);
							}
							if (destinationNum == 3) {
								three.push(pac);
							}
							if (destinationNum == 4) {
								four.push(pac);
							}
							if (destinationNum == 5) {
								System.out.println("Cannot move");
							}
						}
					}

				}
			}

			/**
			 * This method empty the floor.
			 */
			if (input.equalsIgnoreCase("E")) {

				if (zero.isEmpty()) {
					System.out.println("Floor is empty");
				} else {
					Node zeroHead = zero.getHead();
					while (zero.getHead() != null) {
						zero.pop();
					}
					try {
						zeroHead = zeroHead.getNext();
					} catch (NullPointerException e) {
						System.out.println("Invalid input!");
					}
					System.out.println("The floor has been emptied. Mr. Trash Can is no longer hungry.");
				}
			}

			/**
			 * This method quit the program.
			 */
			if (input.equalsIgnoreCase("Q")) {
				System.out.println("Use Amazon Locker next time.");
				break;
			}

		}

	}

	/**
	 * This method display the menu
	 * 
	 * @return The menu
	 */
	public static String menu() {

		String menu = "";

		menu = menu + "\nMenu:\n" + "D) Deliver a package \n" + "G) Get someone's package\n" + "T) Make it tomorrow\n"
				+ "P) Print the stacks\n" + "M) Move a package from one stack to another\n"
				+ "F) Find packages in the wrong stack and move to floor\n" + "L) List all packages awaiting a user\n"
				+ "E) Empty the floor.\n" + "Q) Quit\n";

		return menu;

	}

}
