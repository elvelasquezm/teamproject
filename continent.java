import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class continent {

	String name;
	List<String> has;	
	List<String> terrs;
	
	
	//CONSTRUCTORS
	public continent(String name) {
		this.name = name;
	}
	public continent(String name, List<String> has) {
		this.name = name;
		this.has = has;
	}

	//////////METHODS///////////
	
	/**
	 * ADDS A LIST OF TERRITORIES TO THE CONTINENT
	 * 
	 */ 
	public void setTerritories(List<String> list) {
		this.has = list;
	}
	
	/**
	 * GETS THE LIST OF TERRITORIES OF THE CONTINENT
	 * 
	 */
	public void getTerritories(){
		System.out.println("");
		System.out.println(name + " includes the following territories:");
		for(int i = 0; i < has.size(); i++) {
			System.out.println(has.get(i));
		}
	}
	
}
