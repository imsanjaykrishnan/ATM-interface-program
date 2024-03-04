import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your user ID: ");
		String userID = scanner.nextLine();
		System.out.print("Enter your PIN: ");
		int pin = scanner.nextInt();

		if (atm.authenticateUser(userID, pin)) {
			System.out.println("Authentication successful.");
			System.out.println("1. Check Balance");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Deposit Money");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Your balance is: " + atm.checkBalance(userID));
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				atm.withdraw(userID, withdrawAmount);
				break;
			case 3:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				atm.deposit(userID, depositAmount);
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} else {
			System.out.println("Authentication failed. Invalid user ID or PIN.");
		}
	}
}
