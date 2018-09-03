import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Player class has lots of methods. lol
 * 
 */
public class player {

	public int player_no;
	public int terr_owned = 0;
	String playerName = new String("");
	int num_of_dice_rolls;
	int num_of_armies;
	int num_of_cards;
	
	boolean can_trade;
	boolean won_whole_game;
	boolean eliminated;
	boolean win;
	boolean lose;
	boolean own_this_terr;
	boolean canAttack;
	boolean isAttacking;
	boolean isDefending;
	boolean canDefend;
	
	List<Object> adj_terr = new ArrayList<Object>();
	List<Object> cards_held = new ArrayList<Object>();
	public List<territory> territories_owned = new ArrayList<territory>();
	
	//////////CONSTRUCTORS//////////////////
	public player(int num) {
		this.player_no = num;
		System.out.print("Player " + this.player_no + " please enter your name: ");
		Scanner in = new Scanner(System.in);
		this.playerName = in.nextLine();
    }
	public player(int num, int numArmies) {
        this.player_no = num;
		this.num_of_armies = numArmies;
		System.out.print("Player " + this.player_no + " please enter your name: ");
		Scanner in = new Scanner(System.in);
		this.playerName = in.nextLine();
    }
	////////////////////////////////////////
	
	/** 
	 * METHODS
	 * 
	 */
	public int getplayernumber() {
		return this.player_no;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}
	
	//territories
	public void setnumofterritories(int n) {
		this.terr_owned = n;
	}
	public int getnumofterritories() {
		return this.terr_owned;
	}
	
	//dice rolls
	public void setnumofdicerolls(int n) {
		this.num_of_dice_rolls = n;
	}
	public int getnumofdicerolls() {
		return this.num_of_dice_rolls;
	}
	
	//armies
	public void setnumofarmies(int n) {
		this.num_of_armies = n;
	}
	public int getnumofarmies() {
		return this.num_of_armies;
	}
	
	//give player a certain number of cards
	public void setnumofcards(int n) {
		this.num_of_cards = n;
	}
	public int getnumofcards() {
		return this.num_of_cards;
	}
	
	//set "can trade" status
	public void setCanTrade(boolean trade) {
		this.can_trade = trade;
	}
	public boolean canTrade() {
		return this.can_trade;
	}
	
	//won entire game
	public void setWinner(boolean winner) {
		this.won_whole_game = winner;
	}
	public boolean getWinner() {
		return this.won_whole_game;
	}
	
	//when player is eliminated from game
	public void eliminate() {
		
	}
	
	//win battle
	public void setwinnerofbattle(boolean outcome) {
		this.win = outcome;
	}
	public boolean getwinnerofbattle() {
		return this.win;
	}
	
	//lose battle
	public void setloserofbattle(boolean outcome) {
		this.lose = outcome;
	}
	public boolean getloserofbattle() {
		return this.lose;
	}

	//own this territory?
	public boolean ownthisterritory(territory terr) {
		if(terr.isOwnedBy == this.player_no) {
			return true;
		} else return false;
	}
	
	//if adjacent territory can be attacked.
	//(it might be better to move this method to territory class)
	public void canAttack(territory terr) {
		if(terr.isOwnedBy != this.player_no) {
			this.canAttack = true;
		} else this.canAttack = false;
	}
	
	//withdraw from a battle
	public void withdraw() {
		
	}
	
	//status of player: 'Attacking' or 'not attacking/defending'
	public void setAttackMode(boolean mode) {
		this.isAttacking = mode;
		this.isDefending = !mode;
	}
	public boolean isAttacking() {
		return this.isAttacking;
	}

	//isDefending
	public void setDefenseMode(boolean mode) {
		this.isAttacking = !mode;
		this.isDefending = mode;
	}
	public boolean isDefending() {
		return this.isDefending;
	}
	
	public void continue_attacking() {
		this.isAttacking = true;
	}
	
	//CHOOSE TERRITORY
	public void chooseTerritory(territory choose) {
		this.territories_owned.add(choose);
		this.terr_owned = terr_owned + 1;
		choose.setOwner(player_no);
	}
	
	//ADD ONE TOKEN/ARMY TO TERRITORY
	public void addTokenToTerritory(territory t) {
		t.addTokenToTerritory();
		t.setOwner(player_no);
		t.setTaken(true);
	}
	//ADD SPECIFIED # OF TOKENS/ARMIES TO TERRITORY t
	public void addTokensToTerritory(territory t, int tokens) {
		t.addTokensToTerritory(tokens);
		t.setOwner(player_no);
		t.setTaken(true);
	}
	
	//PRINT TERRITORIES THAT THE PLAYER OWNS
	public void printTerritories() {
		System.out.print("\nPlayer "+player_no+" owns: ");
		for(int x = 0; x < territories_owned.size(); x++) {
			System.out.print(territories_owned.get(x).name+", ");
		}
	}
	
	public void rolldice() {
		
	}
	
	public void place_army() {
		
	}
	
	public void trade_cards() {
		
	}
	
	public void pick_card() {
		
	}
	
	public void attack() {
		
	}
	
	public void defend() {
		
	}
}
