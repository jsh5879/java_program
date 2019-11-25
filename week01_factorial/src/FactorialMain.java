import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorialMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		try {
			final int number = scanner.nextInt();
			if(number <= 0) throw new InputMismatchException();
			
			for(int i = 1; i <=number; i++) {
				final long factorial = getFactorial(i);
				System.out.println("Factorial of " + i + " = " + factorial);
			}
		}catch(InputMismatchException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
	}
	private static long getFactorial(final int number) {
		long factorial = 1;
		for(int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
