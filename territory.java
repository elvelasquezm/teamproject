import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class territory {

	int num_of_territories = 42;
	int territoryNumber;
	String name;
	int numofArmiesHere = 0;
	boolean isTaken = false;
	int isOwnedBy;
	List<String> adj_territories_list;
	List<territory> adj_territories;
	
	//constructors
	public territory(String name, int player, int armies, List<territory> terrs) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
		this.adj_territories = terrs;
	}
	public territory(String name, int player, int armies) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
	}
	public territory(String name, int num) {
		this.name = name;
		this.territoryNumber = num;
	}
	public territory(String name) {
		this.name = name;
	}
	public territory() {
	}
	
	/**
	 * METHODS
	 */
	//name
	public int getTerritoryNumber(){
		return this.territoryNumber;
	}
	public void setnameofterritory(String territory) {
		this.name = territory;
	}
	public String getnameofterritory() {
		return this.name;
	}
	
	//is it owned?
	public void setTaken(boolean set) {
		this.isTaken = set;
	}
	public boolean isTaken() {
		return this.isTaken;
	}
	
	//owner
	public void setOwner(int owner) {
		this.isOwnedBy = owner;
	}
	public int getOwner() {
		return this.isOwnedBy;
	}
	
	//number of armies
	public void setnumberofarmies(int armies) {
		this.numofArmiesHere = armies;
	}
	public int getnumofarmies() {
		return this.numofArmiesHere;
	}
	
	//ADD TOKEN/ARMIES TO TERRITORY
	public void addTokenToTerritory() {
		this.numofArmiesHere = numofArmiesHere + 1;
	}
	public void addTokensToTerritory(int tokenNumber) {
		this.numofArmiesHere = numofArmiesHere + tokenNumber;
	}

	//adjacent territories
	public void setAdjacentterritories(List<territory> list) {
		this.adj_territories = list;
	}
	public List<territory> getAdjacentterritories(territory place) {
		//List<territory> dummy = new ArrayList<territory>();
		return this.adj_territories;
	}
	
	
}
