package application;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.enums.Status;
import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the account data:");
		
		try {
		System.out.print("Number: ");
		int numberAccount = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Holder: ");
		String holder = scanner.nextLine();
		
		System.out.print("Initial Balance: ");
		Double initialBalance = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.print("WithDraw Limit: ");
		Double withdrawLimit = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.print("Status: ");
		Status status = Status.valueOf(scanner.nextLine().toUpperCase());
		
		Account acc1 = new Account(numberAccount, holder, initialBalance, withdrawLimit, status);
		
		System.out.print("Enter the deposit amount: ");
		Double depositAmount = scanner.nextDouble();
		scanner.nextLine();
		
		acc1.deposit(depositAmount);
		
		System.out.println("");
		
		System.out.println(acc1);
		
		System.out.println("");
		
		System.out.print("Enther the withdraw amount: ");
		Double withdrawAmount = scanner.nextDouble();
		scanner.nextLine();
		
		acc1.withdraw(withdrawAmount);
		
		System.out.println("");
		
		System.out.println(acc1);
		
		scanner.close();
		}
		catch (DomainException e) {
			System.out.println("Error in operation " + e.getMessage());
		}
		catch (RuntimeException e) {
		System.out.println("Unexpected Error!");
		}

	}

}
