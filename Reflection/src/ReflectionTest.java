import java.util.*;
import java.lang.reflect.*;
public class ReflectionTest {
	public static void main(String[] args) {
		String name;
		if (args.length > 0) name = args[0];
		else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date): ");
			name = scanner.next();
			scanner.close();
		}
		try {
			// print class name and superclass name
			Class<?> cl = Class.forName(name); // java.lang.Class
			Class<?> supercl = cl.getSuperclass();
			System.out.print("class " + name);
			if (supercl != null && supercl != Object.class)
				System.out.print(" extends " + supercl.getName());
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}
		catch(ClassNotFoundException e) { e.printStackTrace(); }
	}
	public static void printConstructors(Class<?> cl) {
		// java.lang.reflect.Constructor
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for (Constructor<?> c : constructors) {
			System.out.print(" " + Modifier.toString(c.getModifiers()));
			System.out.print(" " + c.getName() + "(");
			// print parameter types
			Class<?>[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	public static void printMethods(Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class<?> retType = m.getReturnType();
			// print modifiers, return type and method name
			System.out.print(" " + Modifier.toString(m.getModifiers()));
			System.out.print(" " + retType.getName() + " " + m.getName() + "(");
			// print parameter types
			Class<?>[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	public static void printFields(Class<?> cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			Class<?> type = f.getType();
			System.out.print(" " + Modifier.toString(f.getModifiers()));
			System.out.println(" " + type.getName() + " " + f.getName() + ";");
		}
	}
}