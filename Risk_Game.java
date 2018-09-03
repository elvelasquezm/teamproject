import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Derrick Ellis, Ezekiel , Jason
 *
 */


/**
 * MAIN CLASS
 * 
 */ 
public class Risk_Game {

	/**
	 * @return 
	 * 			
	 * @param 
	 * @param  
	 * 			
	 * 			
	 * @param 
	 * 			
	 * 			
	 */

	/*@ requires 
	@ ensures 
	@
	@ requires 
	@ ensures 
	@*/


	/**
	 * METHOD THAT PUTS THE PLAYERS INTO A STRING ARRAY.
	 * THIS IS USED ONCE IN THE MAIN METHOD AT THE START OF THE GAME
	 * 
	 */ 
	public static String[][] setupPlayers(int numOfPlayers) {
		String[][] listOfPlayers = new String[6][2];
		for(int i = 1; i <= numOfPlayers; i++) {
			listOfPlayers[i-1][1] = Integer.toString(i);
		}
		return listOfPlayers;
	}

	/**
	 * MAIN METHOD
	 * 
	 */ 
	public static void main(String[] args) throws Exception{
		
		//ESTABLISH MAIN VARIABLES
		String num_of_players;
		int players = 0;
		boolean valid = true;
		territory[] tList = new territory[42]; //list of all territories

		//START GAME. PROMPT USER FOR NUMBER OF PLAYERS
		while(valid) {
			System.out.println("WELCOME TO RISK! LET'S PLAY!");
			System.out.print("How many players? ");

			//Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			num_of_players = reader.readLine();
			players = Integer.parseInt(num_of_players);
			
			//CHECK IF NUMBER OF PLAYERS IS VALID
			if(players > 1 && players < 7) {
				valid = false;
			} else {
				if(players < 2) {
					System.out.println(num_of_players + " is not enough players. Need at least 2.");
				} else {
					System.out.println(num_of_players + " is too many players. Can only have up to 6.");
				}
				System.out.println("");
			}
		}
		
		// CALLING METHOD THAT PUTS THE PLAYERS INTO A STRING ARRAY.
		List<player> pList = new ArrayList<player>(players);
		String[][] participants = setupPlayers(players);

		//READ IN LIST OF TERRITORIES FROM FILE
		FileInputStream fstream = new FileInputStream("territory_list.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		System.out.println("");
		int count = 0;
		while ((strLine = br.readLine()) != null)   {
			tList[count] = new territory(strLine);
			count++;
		}
		br.close();

		//INITIALIZE GAME BOARD
		board gameBoard = new board();

		//GIVE OUT ARMIES BASED ON NUMBER OF PLAYERS
		//WE CAN/SHOULD PROBABLY CREATE A METHOD FOR THIS
		if(players == 2) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,40));
			}
		}
		else if(players == 3) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,35));
			}
		}
		else if(players == 4) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,30));
			}
		}
		else if(players == 5) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,25));
			}
		}
		else if(players == 6) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,20));
			}
		}

		//FOR REFERENCE
		System.out.println("All players get " + pList.get(0).getnumofarmies() + " armies.");

		//DETERMINE THE ORDER OF PLAY
		Collections.shuffle(pList);
		System.out.println("");
		List<player> playerOrder = new ArrayList<player>(players);
		for(int x = 0; x < players; x++) {
			playerOrder.add(pList.get(x));
		}
		System.out.println("*ROLLING DICE TO DETERMINE ORDER OF PLAY.*"+"\nPLEASE WAIT...");
		TimeUnit.SECONDS.sleep(3);
		System.out.print("\nThe order of play is: ");
		for(int x = 0; x < players; x++) {
			System.out.print(playerOrder.get(x).getPlayerName() + " ");
		}

		System.out.println("\n");
		
		/**
		 * PLAYERS ARE CHOOSING THEIR TERRITORIES
		 * CURRENTLY, THIS IS SIMULATING THE PLAYERS CHOOSING
		 * BUT IN THE FUTURE, THIS WILL BE A USER INPUT PROCESS
		 * 
		 */ 
		List<territory> notUsed = new ArrayList<territory>(); //list to keep track of which numbers where picked/used.
		for(int i = 0; i < tList.length; i++) {
			notUsed.add(tList[i]);
		}
		System.out.println("*PLAYERS ARE CLAIMING THEIR TERRITORIES.*"+"\nPLEASE WAIT...");
		TimeUnit.SECONDS.sleep(5);
		newArmies placedPieces = new newArmies();
		placedPieces.setUpArmies(players, pList.get(0).getnumofarmies(), playerOrder, notUsed);
		
		//UPDATE tList
		for(int i = 0; i < tList.length; i++) {
			tList[i] = notUsed.get(i);
		}

		//CHECK OWNERSHIP OF TERRITORIES

		//System.out.println("");
		
	}
		
	}
