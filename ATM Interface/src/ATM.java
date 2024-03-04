import java.util.HashMap;
import java.util.Map;

// ATM class encapsulating ATM functionalities
public class ATM {
	private Map<String, User> users;

	public ATM() {
		users = new HashMap<>();
		// Dummy users for demonstration
		users.put("123456", new User("123456", 1234, 1000.0));
		users.put("654321", new User("654321", 4321, 2000.0));
	}

	public boolean authenticateUser(String userID, int pin) {
		User user = users.get(userID);
		return user != null && user.getUserPIN() == pin;
	}

	public double checkBalance(String userID) {
		return users.get(userID).getAccountBalance();
	}

	public void withdraw(String userID, double amount) {
		User user = users.get(userID);
		if (user.getAccountBalance() >= amount) {
			user.setAccountBalance(user.getAccountBalance() - amount);
			System.out.println("Withdrawal successful. Remaining balance: " + user.getAccountBalance());
		} else {
			System.out.println("Insufficient funds.");
		}
	}

	public void deposit(String userID, double amount) {
		User user = users.get(userID);
		user.setAccountBalance(user.getAccountBalance() + amount);
		System.out.println("Deposit successful. New balance: " + user.getAccountBalance());
	}
}
