import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class newArmies {

	//CONSTRUCTORS
	public newArmies() {

	}
	
	/**
	 *      !!!!NOT FINISHED!!!
	 * THIS METHOD IS TO SIMULATE SETTING UP/PLACING ARMIES AT THE BEGINNING OF THE GAME
	 * IN THE FUTURE, THIS WILL BE A USER INPUT PROCESS, SO I DON'T KNOW HOW USEFUL THIS
	 * METHOD IS NOW.
	 * 
	 */
	public void setUpArmies(int numOfPlayers, int numOfArmies, List<player> pList, List<territory> trackingList) {

		List<territory> dummyList = trackingList;
		Collections.shuffle(dummyList);
		//CLAIM TERRITORIES
		int count = 0;
		//int nextTerr = 0;
		for(territory t : dummyList) {
			pList.get(count).chooseTerritory(t);
			t.setOwner(pList.get(count).player_no);
			t.setTaken(true);
			//t.addTokenToTerritory();
			count++;
			//nextTerr++;
			if(count == numOfPlayers) {
				count = 0;
			}
//			if(nextTerr == pList.get(count).terr_owned) {
//				nextTerr = 0;
//			}
		}

		//ADD ARMIES/TOKENS TO TERRITORIES
//		int check = 0;
//		for(int x = 0; x < numOfPlayers; x++) {
//			loop:
//				for(int y = 0; y < pList.get(x).territories_owned.size(); y++) {
//					System.out.println("check ceil: "+Math.ceil(numOfArmies/pList.get(x).territories_owned.size()));
//					System.out.println("check floor: "+Math.floor(numOfArmies/pList.get(x).territories_owned.size()));
//					System.out.println("check: "+numOfArmies/pList.get(x).territories_owned.size());
//					for(int z = 0; z <= (int)numOfArmies/pList.get(x).territories_owned.size(); z++) {
//						pList.get(x).territories_owned.get(y).addTokenToTerritory();
//						check++;
//						if(check == (pList.get(x).getnumofarmies())) {
//							check = 0;
//							break loop;
//						}
//					}
//				}
//		}
		
		trackingList = dummyList;
		
		for(int x = 0; x < numOfPlayers; x++) {
			pList.get(x).printTerritories();
		}
		
//		for(player p : pList) {
//			System.out.println("\nPlayer "+ p.player_no+": ");
//			for(int x = 0; x < p.territories_owned.size(); x++) {
//				System.out.println(p.territories_owned.get(x).name + " has " + p.territories_owned.get(x).numofArmiesHere+" armies.");
//			}
//		}
		

	}

}