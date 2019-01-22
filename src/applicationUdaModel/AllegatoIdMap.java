package applicationUdaModel;

import java.util.HashMap;
import java.util.Map;

public class AllegatoIdMap {
private Map<Integer,Allegato> map;
	
	public AllegatoIdMap() {
		map=new HashMap<>();
	}
	
	public Allegato get(Allegato allegato) {
		Allegato old = map.get(allegato.getCodAllegato());
		if(old == null) {
			//vuole dire che nella mappa non c'è questo allegato
			//e devo aggiungerlo
			map.put(allegato.getCodAllegato(), allegato);
			return allegato;
		}
		return old;
	}
	//inserisco una classe nella mappa
	public void put (Integer codAllegato, Allegato allegato) {
		map.put(codAllegato,allegato);
	}
}
