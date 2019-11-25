import java.util.Scanner;

enum Command { ADD, LIST, SUM, QUIT, INVALID };

public class ArrayEnum {	
	public static void main(String[] args) {

		final int values[] = new int[100];
		int index = 0;
		
		Scanner scanner = new Scanner(System.in);
	while ( true ) {
		final Command command = getCommand(scanner); // Command is enum
		if ( command == Command.QUIT ) {
			System.out.println("Bye!");
			break;
		}
	switch ( command ) {
	case ADD:
		final int newValue = getValue(scanner);
		values[index] = newValue;
		index++;
		break;
	case LIST:
		printList(values, index);
		break;
	case SUM:
		System.out.println(getSum(values, index));
		break;
	case INVALID:
		default: break;
		}
	}
	scanner.close();
	}
	
	private static Command getCommand(Scanner scanner) {
		final String commandString = scanner.next().toUpperCase();
		Command command = Command.INVALID;
		if(commandString.equals("ADD")) command = Command.ADD;
		else if(commandString.equals("LIST")) command = Command.LIST;
		else if(commandString.equals("SUM")) command = Command.SUM;
		else if(commandString.equals("QUIT")) command = Command.QUIT;
		else {
			System.out.println("Invalid Command");
			command = Command.INVALID;
		}
		return command;
	}
	
	private static int getValue(Scanner scanner) {
		final int value = scanner.nextInt();
		return value;
	}
	
	private static void printList(int[] values, int index) {
		for(int i = 0; i < index; i++) System.out.print(values[i] + " ");
		System.out.println();
	}
	
	private static int getSum(int[] values, int index) {
		int sum = 0;
		for(int i=0; i<index; i++) sum += values[i];
		return sum;
	}
}