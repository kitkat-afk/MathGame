import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This class creates the database of the whole game, storing all the characters
 * into a file. It will search the file if the username exists. If it does, it
 * will load that character. If it does not, it will write a new file with the
 * previous characters.
 */

@SuppressWarnings("unchecked")
public class Database {
	public static ArrayList<Account> files = new ArrayList<Account>();
	public static final String FILE_NAME = "StudentList";

	/**
	 * This method will return either the index in the ArrayList if the character is
	 * in the file or it will return -1 if the character is not found.
	 *
	 * @return Index in the ArrayList or -1 if not found
	 */
	public static int inFile(String playerUsername) {

		for (int i = 0; i < files.size(); i++) {
			// Checking if the username is in the system
			if (files.get(i).username.equals(playerUsername) == true) {
				return i;
			} else {
				System.out.println("Oops, your username is not in the system");
			}
		}
		return -1;
	}

	/**
	 * This method creates a new file, overwriting the old one with the past and
	 * previous information if the character is not found in the ArrayList. If the
	 * character found, it will return the character.
	 *
	 * @return The character the user creates or character in the file
	 */
	public static Account createFile(String playerUsername) {
		Account student = null;
		try {
			File newFile = new File(FILE_NAME);
			Scanner scan = new Scanner(newFile);

			// scanning the file and adding the names in
			while (scan.hasNext() == true) {
				files.add(new Account(scan.nextLine()));
			}


			if (!(inFile(playerUsername) == (-1))) {
				int i = inFile(playerUsername);
				student = files.get(i);
			} else {
				// adding the character to the arraylist
				student = new Account(playerUsername);
				files.add(student);
				ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(newFile));

				// writing the arraylist to the file
				outputStream.writeObject(files.toString());
				outputStream.close();
			}

		} catch (Exception IOException) {
			System.exit(1);
		}
		return student;
	}

}