package dsa.assignment2;

import java.util.Scanner;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

public class Main {

	public static void main(String[] args) {

		CommandShell obj = new CommandShell();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = "";
		String currentName = "";
		while (!name.equals("exit")) {
			System.out.println("Create a Direcotry");
			System.out.println("Show Direcotry");
			System.out.println("Exit");
			name = sc.nextLine();
			String data[] = name.split(" ");
			switch (data[0]) {
			case "MakeDir":
				if (data[1].equals("")) {
					System.out.println("Wrong command");
					throw new AssertionError();
					System.exit(0);
				}
				obj.createDirecotry(data[1]);
				break;
			case "exit":
				System.out.println("exit");
				System.exit(0);
				break;
			case "CD":
				if (data[1].equals("")) {
					System.out.println("Wrong command");
					throw new AssertionError();
					System.exit(0);
				} else {
					currentName = obj.goInsideTheDirectory(data[1]);
					System.out.println(currentName + "/");
					System.out.println();
				}
				break;
			case "Show":
				System.out.println("|/Root|--------------------");
				// root = obj.getRoot();
				obj.printList(obj.Root);
				break;
			case "bc":
				currentName = obj.goBackToTheDirectory();
				System.out.println(currentName + "/");
				System.out.println();
				break;
			case "c":
				currentName = obj.ShowCurrentDirecotry();
				System.out.println(currentName + "/");
				System.out.println();
				break;
			case "find":
				currentName = obj.findFolder(data[1], obj.current);
				System.out.println(currentName + "/");
				System.out.println();
				break;
				
			default:
				throw new AssertionError();
		}

	}
}
