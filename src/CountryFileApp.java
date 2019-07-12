import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class CountryFileApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		Path path = Paths.get("countries.txt");

		if (Files.notExists(path)) {// catch IOExceptions which always may occur when dealing with files.
			try {
				Files.createFile(path);
			} catch (IOException e) {
				System.out.println("IOException");
			}
		}

		System.out.println("Welcome to the Countries Maintenance Application!");
		boolean valid = true;
		do {
			System.out.println("1. See the list of countries");
			System.out.println("2. Add a country");
			System.out.println("3. Exit");
			System.out.println();
			System.out.println("Enter menu number: ");
			int userInput = scnr.nextInt();
			scnr.nextLine();

			if (userInput == 1) {
				printCountries();
			} else if (userInput == 2) {
				System.out.print("Enter a Country name to add: ");
				String name = scnr.nextLine();
				System.out.print("Enter their population: ");
				long population = scnr.nextLong();
				Country newCountry = new Country(name, population);
				CountryFileUtil.appendToFile(newCountry);
			}else {
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
			System.out.println(count + ") " + c.getName() + " (pop " + NumberFormat.getInstance().format(c.getPopulation()) + " )");
			count++;
		}
		System.out.println();
	}
	
	
	
}// class
