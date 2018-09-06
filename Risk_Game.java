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
import java.util.Scanner;

/**
 * @author Derrick Ellis, Ezekiel , Jason
 *
 */


/**
 * MAIN CLASS
 * 
 */ 
public class Risk_Game {
	public static final int numOfTerritories = 42;
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
	 * MAIN METHOD
	 * 
	 */ 
	public static void main(String[] args) throws Exception{

		//ESTABLISH MAIN VARIABLES
		String num_of_players;
		int players = 0;
		boolean valid = true;
		territory[] tList = new territory[numOfTerritories]; //list of all territories

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
		//String[][] participants = setupPlayers(players);

		//READ IN LIST OF TERRITORIES FROM FILE
		FileInputStream fstream = new FileInputStream("territory_list.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		System.out.println("");
		int count = 0;
		while ((strLine = br.readLine()) != null)   {
			tList[count] = new territory(strLine, count + 1);
			count++;
		}
		br.close();

		//INITIALIZE GAME BOARD
		@SuppressWarnings("unused")
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
		System.out.println("\nAll players get " + pList.get(0).getnumofarmies() + " armies.");

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
		TimeUnit.SECONDS.sleep(3);
		/**
		 * PLAYERS ARE CHOOSING THEIR TERRITORIES
		 * CURRENTLY, THIS IS SIMULATING THE PLAYERS CHOOSING
		 * BUT IN THE FUTURE, THIS WILL BE A USER INPUT PROCESS
		 * 
		 */
		System.out.println("*PLAYERS, CLAIM YOUR TERRITORIES!*");
		//************************TERRITORY DRAFT BEGIN***************
		/*****************************KNOWN ISSUES!!!!!
		 * During Draft phase, empty strings throws an exception at the parseInt
		 * Need to fix drafting by name
		 * Need to fix adding armies by number
		 */
		int currentPlayer = 0;
		int territoriesClaimed = 0;
		while(territoriesClaimed <= numOfTerritories - 1){
			System.out.print("\n" + pList.get(currentPlayer).getPlayerName() +":\n");
			for(int n = 0; n < numOfTerritories; n++){
				if(!tList[n].isTaken()){
					System.out.print(n+1 + ": " + tList[n].getnameofterritory() + "\n");
				}
			}
			System.out.print("\nPlease choose a territory by NUMBER: ");
			boolean noTerritorySelected = true;
			while(noTerritorySelected){
				Scanner in = new Scanner(System.in);
				String selection = new String(in.nextLine());
				for(int n = 0; n < numOfTerritories; n++){
					//System.out.print(selection + " : " + tList[n].getnameofterritory() + "\n");
					if((tList[n].getnameofterritory().equals(selection) || Integer.toString(tList[n].getTerritoryNumber()).equals(selection)) && !tList[n].isTaken()){
						tList[n].setTaken(true);
						tList[n].setOwner(currentPlayer);
						tList[n].addTokenToTerritory();
						noTerritorySelected = false;
						pList.get(currentPlayer).reduceUnplacedArmies();
					}
				}
				if(noTerritorySelected){
					System.out.print("Not a valid selection. Please Try again: ");
				}
				//in.close();
			}
			currentPlayer = (currentPlayer + 1) % players;
			territoriesClaimed++;
		}
		//Placing Remaining Armies Begin
		System.out.print("\nAll territories claimed!\n");
		int playersWithArmiesRemaining = 0;
		while(playersWithArmiesRemaining != players){
			System.out.print("\n" + pList.get(currentPlayer).getPlayerName() + "\'s owned territories: (Remaining Armies " + pList.get(currentPlayer).getUnplacedArmies() + ")\n");
			System.out.print("Territory \t\t\t Number of Armies\n------------------------------------------------------------------\n");
			for (int n = 0; n < numOfTerritories; n++){
				if(tList[n].getOwner() == currentPlayer){
					System.out.printf("%-30s %-30d", tList[n].getTerritoryNumber() + ": " + tList[n].getnameofterritory(), tList[n].getnumofarmies());
					System.out.print("\n");
				}
			}
			System.out.print("Choose a territory to add an army to: ");
			boolean noTerritorySelected = true;
			while(noTerritorySelected){
				Scanner in = new Scanner(System.in);
				String selection = new String(in.nextLine());
				for(int n = 0; n < numOfTerritories; n++){
					//System.out.print(selection + " : " + tList[n].getnameofterritory() + "\n");
					if((tList[n].getnameofterritory().equals(selection) || Integer.toString(tList[n].getTerritoryNumber()).equals(selection)) && tList[n].getOwner() == currentPlayer){
						tList[n].addTokenToTerritory();
						noTerritorySelected = false;
						pList.get(currentPlayer).reduceUnplacedArmies();
					}
				}
				if(noTerritorySelected){
					System.out.print("Not a valid selection. Please Try again: ");
				}
				//in.close();
			}
			currentPlayer = (currentPlayer + 1) % players;
			playersWithArmiesRemaining = 0;
			for(int n = 0; n < players; n++){
				if(pList.get(n).getUnplacedArmies() == 0){
					playersWithArmiesRemaining++;
				}
			}

		}
		//Placing Remaining Armies End
		//************************TERRITORY DRAFT END*****************

		System.out.println("\nAll armies have been placed.\nNow let's begin!");

		//********************GAMEPLAY BEGINS****************************
		String optionNumber;
		boolean weHaveAWinner = false;
		while(weHaveAWinner == false) {
			for(player p : pList) {
				playerTurn pT = new playerTurn(p);
				System.out.println(p.getPlayerName()+", what would you like to do? CHOOSE NUMBER\n");
				p.getPlayerOptions();

				//Enter data using BufferReader
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				// Reading data using readLine
				optionNumber = reader.readLine();

				for(int i = 0; i < p.playerOptions.length; i++) {
					if(optionNumber == p.playerOptions[i][0]) {
						if(optionNumber == "1") {
							//ATTACK
							p.attack();
						}
						if(optionNumber == "2") {
							//REINFORCE
							p.reinforce();
						}
						break;
					}
				}

			}
		}


	}

}
