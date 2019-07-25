package get2019.assignment8;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @pram ZoneArea is Contain all Zone Object
 * @param CageArea Contain All Cage Object
 * @param AnimalArea is Contain all the animal of Zoo
 * @func AddZone
 * @func AddCage
 * @func AddAnimal
 * @func Create a type of Cage
 * this class show all type operation through switch case
 * @author Rivak
 *
 */
public class Zoo {
	static int id = 0;
	static ArrayList<Zone> ZoneArea = new ArrayList<Zone>();
	static ArrayList<Cage> CageArea = new ArrayList<Cage>();
	static ArrayList<Animal> AnimalArea = new ArrayList<Animal>();

	public static void main(String[] args) {
		// String zoneType = Lion.class.getSuperclass().getSimpleName();
		int exit = 0;
		Scanner sc = new Scanner(System.in);

		while (exit != -1) {
			System.out.println("1-Ädd Zone");

			System.out.println("2-Add Cage");

			System.out.println("3-Add Animal");

			System.out.println("4-Remove Animal");
			System.out.println("5-Show Animal");
			System.out.println("6-Exit");
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1: {
				if (ZoneArea.size() < 3) {
					System.out.println(ZoneArea.size());
					System.out.println("Enter Catergory of Zone");
					sc.nextLine();
					String Category = sc.nextLine();
					System.out.println("Enter Cage Capacity of Zone");
					int cageCapacity = sc.nextInt();
					switch (Category) {
					case "Mammal": {
						Zone Z1 = addZone("Mammal", cageCapacity); //return the mammal type Object of zone
						ZoneArea.add(Z1); //Add zone Object to list
						break;
					}

					case "Reptile": {
						Zone Z1 = addZone("Reptile", cageCapacity); //return the Reptile type Object of zone
						ZoneArea.add(Z1);//Add zone Object to list
						break;
					}

					case "Bird": {
						Zone Z1 = addZone("Bird", cageCapacity);  //return the Bird type Object of zone
						ZoneArea.add(Z1);//Add zone Object to list;
					}

					}
				} else {
					System.out.println("Zone Full");
				}
				break;
			}

			case 2: {
				if (ZoneArea.size() == 0) {
					System.out.println("Please Create Zaone"); //check if zone is Empty or not
				} else {
					System.out.println("Enter Type of Cage");
					sc.nextLine();
					String cageType = sc.nextLine();
					System.out.println("Enter Animal Capacity of cage");
					int animalCapacity = sc.nextInt();
					if ("Lion".equals(cageType)) { 
						String zoneType = Lion.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType); //Create a Lion Type Cage

					} else if ("Crocodile".equals(cageType)) {
						String zoneType = Crocodile.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType); //Create a Crocodile Type Cage

					} else if ("Peacock".equals(cageType)) {
						String zoneType = Peacock.class.getSuperclass().getSimpleName();
						insertIntoTheCage(zoneType, animalCapacity, cageType); //Create a Peacock Type Cage

					} else {
						System.out.println("We dont't Have Your Choise"); //we have fix class now so only 3 will check
					}

				}
				break;

			}

			case 3:
				if (ZoneArea.size() == 0) {
					System.out.println("Please Create Zone"); //check that Zone is Present 
				} else if (CageArea.size() == 0) {
					System.out.println("Please Create Cage");  //check that Cage is Present 
				} else {
					System.out.println("Enter Type of Animal");
					sc.nextLine();
					String animalType = sc.nextLine();
					System.out.println("Enter NAme of Animal");
					String animalName = sc.nextLine();
					for (int i = 0; i < CageArea.size(); i++) { //check size of is greater then animal insert or not
						Cage CageObj = CageArea.get(i); 
						if (animalType.equals(CageObj.cageType)) {
							if (CageObj.Aniamlcapacity > 0) { //check Animal capacity is available or not
								CageObj.Aniamlcapacity = CageObj.Aniamlcapacity - 1; //Decrease every time after insert the animal
								Animal A1 = addAnimal(id++, animalName, animalType);
								AnimalArea.add(A1);
							} else {
								System.out.println("Capacity full");
							}
						}
					}
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter Name of Animal");
				String animalName = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName.equals(A1.name)) {  //check the animal is present or not if yes then remove it
						AnimalArea.remove(i);
					}
				}
				break;

			case 5:
				sc.nextLine();
				System.out.println("Enter NAme of Animal");
				String animalName1 = sc.nextLine();
				for (int i = 0; i < AnimalArea.size(); i++) {
					Animal A1 = AnimalArea.get(i);
					if (animalName1.equals(A1.name)) {//check the  capacity of aniaml if yess then show 
						System.out.println("Name of Animal->" + A1.name);
						System.out.println("Id of Animal->" + A1.id);
						System.out.println("Sound Of Animal->" + A1.getSound());
					} else {
						System.out.println("Animal Not Found");
					}
				}
				break;
			case 6:
				System.out.println("Thanks For Comming");
				System.exit(0);

			}
		}
	}

	private static void insertIntoTheCage(String zoneType, int animalCapacity,
			String cageType) {
		for (int i = 0; i < ZoneArea.size(); i++) {
			Zone ZoneAreaObj = ZoneArea.get(i);
			if (zoneType.equals(ZoneAreaObj.category)) {
				if (ZoneAreaObj.cageCapity > 0) { //check zone hase capacity or not
					ZoneAreaObj.cageCapity = ZoneAreaObj.cageCapity - 1; //reduse the capcity by one of cage after insert
					Cage c1 = addCage(cageType, animalCapacity);
					CageArea.add(c1);

				} else {
					System.out.println("Cage Size Full");
				}
				break;
			}
		}

	}
	/**
	 * inert the data into zone class
	 * @param zoneType
	 * @param Cagecapacity
	 * @return Object of the zone type
	 */
	public static Zone addZone(String zoneType, int Cagecapacity) {

		return new Zone(zoneType, Cagecapacity);
	}
	
	/**
	 * insert the data into Cage class
	 * @param CageType
	 * @param Acapacity
	 * @return  return the object of cage type
	 */
	public static Zone addZone(String zoneType, int Cagecapacity) {

		return new Zone(zoneType, Cagecapacity, true, false);
	}
	
	/**
	 * insert the data into animal class
	 * @param Id
	 * @param Name
	 * @param Type
	 * @return animal type object
	 */
	public static Animal addAnimal(int Id, String Name, String Type) {
		if ("Lion".equals(Type)) {

			return new Lion(Id, Name);
		} else if ("Crocodile".equals(Type)) {
			return new Crocodile(Id, Name);
		} else if ("Peacock".equals(Type)) {
			return new Peacock(Id, Name);
		} else {

			System.out.println("No Animal Found");
			return null;
		}
	}

}
