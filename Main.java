import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			int choice = 0; // tracks choice of player
			String playerName = ""; // stores name of the player for entirety of session until termination
			int prevScore = 0; // stores previous score in the same session
			int triesTaken = 0; // counter for tries taken to correctly guess
			
			playerName = introMsg(playerName, scanner); // intro message and collects player name
			
			while(choice < 2){
				choice = playerChoice(choice, scanner); // asks player about their choice
				
				
				// if choice is 1, start the game
				if(choice == 1) {
					
					// displays score of previous game
					System.out.println();
					System.out.println("-> Previous Score: " + prevScore);
					
					// prompts user to pick a range for playing the game
					System.out.println();
					System.out.println("-> You have chosen to play the game, Good Luck " + playerName + "\n"
									 + "-> Let's start, please pick a range between which the game will be played.\n"
									 + "-> Example, to play a game between 1 and 10, input 10.");
					int range = 10;
					range = scanner.nextInt();
					
					// using the range given by the user, picks a random number from within it
					int randomNumber = randomNumGen(range, scanner);
					System.out.println();
					System.out.println("-> A random number between 1 and " + range + " has been picked.\n"
									 + "-> You can start guessing. Good Luck!");
					
					// placeholder 
					int playerGuess = 0;
					
					// starts game and collects player's guesses, gives hints and increments number of tries on incorrect guessesJay
					while(playerGuess != randomNumber) {
						System.out.println("-> Number of tries: " + triesTaken + "\n"
										 + "-> Take your guess.");
						playerGuess = scanner.nextInt();
						
						if(playerGuess > randomNumber) {
							System.out.println("-> Try a smaller number.");
						}
						if(playerGuess < randomNumber) {
							System.out.println("-> Try a larger number.");
						}
						triesTaken++;
					}
					System.out.println("-> Your guess was correct!\n"
									 + "-> You took " + triesTaken + " tries to guess the number correctly. :)");
					prevScore  = triesTaken;
						
				}
				
				// if choice is 2, displays exit message and stops the game loop
				else {
					exitMsg(playerName);
					break;
				}
			}
			scanner.close();
		} 
		catch(Exception all) {
			System.out.println("-> Something went wrong due to incorrect input. \n"
							 + "-> Please run the game file again.");
		}
	}
	
	static String introMsg(String playerName, Scanner scanner) {
		String opening1 = "XXXXXXXXXX     XX      XX     XXXXXXXXXX     XXXXXXXXXX     XXXXXXXXXX    XX      \r\n"
				+ "XX             XX      XX     XX             XX             XX            XX      \r\n"
				+ "XX             XX      XX     XX             XX             XX            XX      \r\n"
				+ "XX             XX      XX     XX             XX             XX            XX      \r\n"
				+ "XX             XX      XX     XX             XX             XX            XX      \r\n"
				+ "XX   XXXXX     XX      XX     XXXXXXXXXX     XXXXXXXXXX     XXXXXXXXXX    XX      \r\n"
				+ "XX      XX     XX      XX     XX                     XX             XX    XX      \r\n"
				+ "XX      XX     XX      XX     XX                     XX             XX    XX      \r\n"
				+ "XX      XX     XX      XX     XX                     XX             XX            \r\n"
				+ "XXXXXXXXXX     XXXXXXXXXX     XXXXXXXXXX     XXXXXXXXXX     XXXXX XXXX    XX      ";

		String opening2 = "************************- Number Guessing Game -****************************\n"
						+ "-> Hello Player, please enter your name for moving further.";
		
		System.out.println(opening1);
		System.out.println(opening2);

		playerName = scanner.nextLine();
		
		System.out.println();
		System.out.println("-> Hello " + playerName + ", welcome to the number guessing name.");
		
		return playerName;
	}

	static int playerChoice(int choice, Scanner scanner) {

		System.out.println();
		System.out.println("-> Please choose one of the following options: \n"
						 + "-> 1. Set a range and start playing the game \n"
						 + "-> 2. Quit");
		choice = scanner.nextInt();
		return choice;
	}

	static int randomNumGen(int range, Scanner scanner) {
		System.out.println();
		System.out.println("-> Range picked between 1 to " + range);
		Random random = new Random();
		return random.nextInt(range) + 1;
	}
	
	static void exitMsg(String playerName) {
		System.out.println();
		System.out.println("-> You have chosen to quit the game.\n"
						 + "-> Thank you for playing, See you later, " + playerName + ".");
	}
	
}
