import java.util.ArrayList;
import java.util.List;

public class board {

		continent europe;
		continent europewithTerr;
		continent N_Amer;
		continent nawithTerr;
		continent asia;
		continent asiawithTerr;
		continent africa;
		continent afrwithTerr;
		continent S_Amer;
		continent sawithTerr;
		continent australia;
		continent auswithTerr;
	
	//constructor
		public board() {
			//ADD CONTINENTS TO BOARD
			this.europe = new continent("Europe");
			this.N_Amer = new continent("North America");
			this.asia = new continent("Asia");
			this.africa = new continent("Africa");
			this.S_Amer = new continent("South America");
			this.australia = new continent("Australia");

		}
	
	//LIST OF CONTINENTS
	List<continent> continent = new ArrayList<continent>(6);{
	continent.add(europe);
	continent.add(N_Amer);
	continent.add(asia);
	continent.add(africa);
	continent.add(S_Amer);
	continent.add(australia);
	
	//ADD TERRITORIES TO EACH CONTINENT
	List<String> europeList = new ArrayList<String>(7);
	territory gb = new territory("GB");
	territory ice = new territory("Iceland");
	territory ne = new territory("Northern Europe");
	territory s = new territory("Scandinavia");
	territory se = new territory("Southern Europe");
	territory u = new territory("Ukraine");
	territory we = new territory("Western Europe");
	europeList.add(gb.getnameofterritory());
	europeList.add(ice.getnameofterritory());
	europeList.add(ne.getnameofterritory());
	europeList.add(s.getnameofterritory());
	europeList.add(se.getnameofterritory());
	europeList.add(u.getnameofterritory());
	europeList.add(we.getnameofterritory());
	europewithTerr = new continent("Europe",europeList);
	//europewithTerr.getTerritories();
	
	List<String> naList = new ArrayList<String>(9);
	territory al = new territory("Alaska");
	territory alb = new territory("Alberta");
	territory ca = new territory("Central America");
	territory eus = new territory("Eastern U.S.");
	territory gl = new territory("Greenland");
	territory nt = new territory("Northwest Territory");
	territory o = new territory("Ontario");
	territory q = new territory("Quebec");
	territory wus = new territory("Western U.S.");
	naList.add(al.getnameofterritory());
	naList.add(alb.getnameofterritory());
	naList.add(ca.getnameofterritory());
	naList.add(eus.getnameofterritory());
	naList.add(gl.getnameofterritory());
	naList.add(nt.getnameofterritory());
	naList.add(o.getnameofterritory());
	naList.add(q.getnameofterritory());
	naList.add(wus.getnameofterritory());
	nawithTerr = new continent("North America",naList);
	//nawithTerr.getTerritories();
	
	List<String> asiaList = new ArrayList<String>(12);
	territory af = new territory("Afghanistan");
	territory ch = new territory("China");
	territory in = new territory("India");
	territory irk = new territory("Irkutsk");
	territory j = new territory("Japan");
	territory kam = new territory("Kamchatka");
	territory me = new territory("Middle East");
	territory mon = new territory("Mongolia");
	territory si = new territory("Siam");
	territory sib = new territory("Siberia");
	territory ur = new territory("Ural");
	territory ya = new territory("Yakutsk");
	asiaList.add(af.getnameofterritory());
	asiaList.add(ch.getnameofterritory());
	asiaList.add(in.getnameofterritory());
	asiaList.add(irk.getnameofterritory());
	asiaList.add(j.getnameofterritory());
	asiaList.add(kam.getnameofterritory());
	asiaList.add(me.getnameofterritory());
	asiaList.add(mon.getnameofterritory());
	asiaList.add(si.getnameofterritory());
	asiaList.add(sib.getnameofterritory());
	asiaList.add(ur.getnameofterritory());
	asiaList.add(ya.getnameofterritory());
	asiawithTerr = new continent("Asia",asiaList);
	//asiawithTerr.getTerritories();
	
	List<String> saList = new ArrayList<String>(4);
	territory ar = new territory("Argentina");
	territory br = new territory("Brazil");
	territory pe = new territory("Peru");
	territory ven = new territory("Venezuela");
	saList.add(si.getnameofterritory());
	saList.add(sib.getnameofterritory());
	saList.add(ur.getnameofterritory());
	saList.add(ya.getnameofterritory());
	sawithTerr = new continent("South America",saList);
	//sawithTerr.getTerritories();
	
	List<String> afrList = new ArrayList<String>(6);
	territory co = new territory("Congo");
	territory ea = new territory("East Africa");
	territory egy = new territory("Egypt");
	territory mad = new territory("Madagascar");
	territory nafr = new territory("North Africa");
	territory safr = new territory("South Africa");
	afrList.add(co.getnameofterritory());
	afrList.add(ea.getnameofterritory());
	afrList.add(egy.getnameofterritory());
	afrList.add(mad.getnameofterritory());
	afrList.add(nafr.getnameofterritory());
	afrList.add(safr.getnameofterritory());
	afrwithTerr = new continent("Africa",afrList);
	//afrwithTerr.getTerritories();
	
	List<String> ausList = new ArrayList<String>(4);
	territory eaus = new territory("Eastern Australia");
	territory ind = new territory("Indonesia");
	territory ng = new territory("New Guinea");
	territory wa = new territory("Western Australia");
	ausList.add(si.getnameofterritory());
	ausList.add(sib.getnameofterritory());
	ausList.add(ur.getnameofterritory());
	ausList.add(ya.getnameofterritory());
	auswithTerr = new continent("Australia",ausList);
	//auswithTerr.getTerritories();
	
	//METHODS
	}
	
	
}
