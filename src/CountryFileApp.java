import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CountryFileApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to the Countries Maintenance Application!");
		
		boolean valid = true;
		do {
			System.out.println("1. See the list of countries");
			System.out.println("2. Add a country");
			System.out.println("3. Delete a country");
			System.out.println("4. Exit");
			System.out.println();
			System.out.println("Enter menu number: ");
			int userInput = scnr.nextInt();
			scnr.nextLine();
			
			if(userInput == 1) {
				printCountries();
			} else if(userInput == 2) {
				System.out.print("Enter a Country name to add: ");
				String name = scnr.nextLine();
				System.out.print("Enter their population: ");
				int population = scnr.nextInt();
				Country newCountry = new Country(name, population);
				CountryFileUtil.appendToFile(newCountry);
			}
//			else if(userInput == 3) {
//				printCountries();
//				System.out.println("Which country do you want to delete?");
//				int deleteInput = scnr.nextInt();
//				deleteInput -= 1;
//				scnr.nextLine();
//				CountryFileUtil.rewriteFile(deleteInput);
//			}
			else {
				System.out.println("Adios!");
				valid = false;
			}
			
		} while (valid);
		scnr.close();
	}// main
	
	
	public static void printCountries() {
		System.out.println("Current Countries:");
		List<Country> countries = CountryFileUtil.readFile();
		int count = 1;
		for (Country c : countries) {
			System.out.println(count + ") " + c.getName() + " has " + c.getPopulation() + " people");
			count++;
		}
		System.out.println();
	}
}// class
